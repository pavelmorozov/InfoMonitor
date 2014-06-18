package aero.dnk.infomonitor.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import aero.dnk.infomonitor.domain.CodeShare;
import aero.dnk.infomonitor.domain.Company;
import aero.dnk.infomonitor.domain.Destination;
import aero.dnk.infomonitor.domain.DestinationMultiLanguage;
import aero.dnk.infomonitor.domain.RegularFlight;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/META-INF/spring/root-context.xml")
public class CodeShareDAOTest {
	private static final String DESTINATION_NAME = "DNK";
	private static final String FLIGHT_NUMBER = "TestFlight_777";
	private static final String FLIGHT_NUMBER_CODE_SHARE = "TestFlight_777_CODE_SHARE";
	private static final String COMPANY_NAME = "Test company";
	private static final String DESTINATION_LANGUAGE_1 = "Dnipropetrovsk";
	private static final String DESTINATION_LANGUAGE_2 = "Днепропетровск";
	private static final String DESTINATION_LANGUAGE_3 = "Дніпропетровськ";

	@Autowired
	private CodeShareDAO codeShareDAO;
	@Autowired
	private RegularFlightDAO regularFlightDAO;
	@Autowired
	private CompanyDAO companyDAO;
	@Autowired
	private DestinationDAO destinationDAO;
	
	@Autowired
    SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Test
	@Transactional
	public void codeShareDAOSaveGetDelete(){
		//	First check database have no test record 
		String query = "from CodeShare where flightNumber = '"
				+FLIGHT_NUMBER_CODE_SHARE+"'";
		
		List <CodeShare> codeShareList = sessionFactory.
				getCurrentSession().createQuery(query).list();
		assertEquals("First check database have no test record", codeShareList.isEmpty(),true);
		
		// Save record
		Destination destination = new Destination();
		Set<DestinationMultiLanguage> destinationMultiLanguageSet = new HashSet<DestinationMultiLanguage>();
		destinationMultiLanguageSet.add(
				new DestinationMultiLanguage(DESTINATION_LANGUAGE_1,destination));
		destinationMultiLanguageSet.add(
				new DestinationMultiLanguage(DESTINATION_LANGUAGE_2,destination));		
		destinationMultiLanguageSet.add(
				new DestinationMultiLanguage(DESTINATION_LANGUAGE_3,destination));		
		destination.setDestinationMultiLanguage(destinationMultiLanguageSet);
		destination.setAirPort(DESTINATION_NAME);
		
		Company company = new Company(COMPANY_NAME, "");
		
		destinationDAO.saveDestination(destination);
		companyDAO.saveCompany(company);
		
		RegularFlight regularFlight = new RegularFlight(destination,FLIGHT_NUMBER,company);
		
		regularFlightDAO.save(regularFlight);
		
		CodeShare codeShare = new CodeShare(regularFlight,FLIGHT_NUMBER_CODE_SHARE,company);
		
		codeShareDAO.save(codeShare);

		// Check database have at least one test record
		codeShareList = sessionFactory.
				getCurrentSession().createQuery(query).list();
		assertEquals("Check database have at least one test record",codeShareList.isEmpty(),false);
		
		// Check record
	    System.out.println(codeShare.getFlightNumber()+" "
	    		+codeShare.getFlightCompany().getName()+" "+
	    		codeShare.getRegularFlight().getFlightDestination().getAirPort()+" "+
	    		codeShare.getRegularFlight().getFlightNumber());
	    
		// Get record
	    assertNotNull(codeShareDAO.get(codeShare.getId()));
	    
		// Search record
	    assertEquals("Check for search", codeShareDAO.search(FLIGHT_NUMBER_CODE_SHARE,null).isEmpty(),false);				
	    assertEquals("Check for search", codeShareDAO.search(null,company).isEmpty(),false);
		
		// Remove record 
	    codeShareDAO.remove(codeShare);
		assertNull(codeShareDAO.get(codeShare.getId()));
	}
}
