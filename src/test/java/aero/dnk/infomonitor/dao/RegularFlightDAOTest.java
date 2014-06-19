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

import aero.dnk.infomonitor.dao.flight.CompanyDAO;
import aero.dnk.infomonitor.dao.flight.DestinationDAO;
import aero.dnk.infomonitor.dao.flight.RegularFlightDAO;
import aero.dnk.infomonitor.domain.flight.Company;
import aero.dnk.infomonitor.domain.flight.Destination;
import aero.dnk.infomonitor.domain.flight.DestinationMultiLanguage;
import aero.dnk.infomonitor.domain.flight.RegularFlight;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/META-INF/spring/root-context.xml")
public class RegularFlightDAOTest {

	private static final String DESTINATION_NAME = "DNK";
	private static final String FLIGHT_NUMBER = "TestFlight_777";
	private static final String COMPANY_NAME = "Test company";
	private static final String DESTINATION_LANGUAGE_1 = "Dnipropetrovsk";
	private static final String DESTINATION_LANGUAGE_2 = "Днепропетровск";
	private static final String DESTINATION_LANGUAGE_3 = "Дніпропетровськ";
	
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
	public void destinationDAOSaveGetDelete(){
		//	First check database have no test record 
		String query = "from RegularFlight where flightNumber = '"
				+FLIGHT_NUMBER+"'";
		
		List <RegularFlight> regularFlightList = sessionFactory.
				getCurrentSession().createQuery(query).list();
		assertEquals("First check database have no test record", regularFlightList.isEmpty(),true);
		
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
				
		// Check database have at least one test record
		regularFlightList = sessionFactory.
				getCurrentSession().createQuery(query).list();
		assertEquals("Check database have at least one test record",regularFlightList.isEmpty(),false);
		
		// Check record
	    System.out.println(regularFlight.getFlightNumber()+" "
	    		+regularFlight.getFlightCompany().getName()+" "+
	    		regularFlight.getFlightDestination().getAirPort());
		
		// Get record
	    assertNotNull(regularFlightDAO.get(regularFlight.getId()));
	    
	    //List record
	    assertEquals(regularFlightDAO.list().isEmpty(),false);	    
	    
		// Search record
	    assertEquals("Check for search",regularFlightDAO.search(destination,null,null).isEmpty(),false);				
	    assertEquals("Check for search",regularFlightDAO.search(null,FLIGHT_NUMBER,null).isEmpty(),false);
	    assertEquals("Check for search",regularFlightDAO.search(null,null,company).isEmpty(),false);
	    assertEquals("Check for search",regularFlightDAO.search(destination,FLIGHT_NUMBER,company).isEmpty(),false);
		
		// Remove record 
		regularFlightDAO.remove(regularFlight);
		assertNull(regularFlightDAO.get(regularFlight.getId()));
	}
}
