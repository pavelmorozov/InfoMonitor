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

import aero.dnk.infomonitor.domain.Destination;
import aero.dnk.infomonitor.domain.DestinationMultiLanguage;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/META-INF/spring/root-context.xml")
public class DestinationDAOTest {
	private static final String DESTINATION_NAME = "DNK";
	private static final String DESTINATION_LANGUAGE_1 = "Dnipropetrovsk";
	private static final String DESTINATION_LANGUAGE_2 = "ƒнепропетровск";
	private static final String DESTINATION_LANGUAGE_3 = "ƒн≥пропетровськ";
	private static final int TRANSLATE_NUMBER = 3;
	
	@Autowired
	private DestinationDAO destinationDAO;
	
	@Autowired
    SessionFactory sessionFactory;	
	
	@SuppressWarnings("unchecked")
	@Test
	@Transactional
	public void destinationDAOSaveGetDelete(){
		
		//	First check database have no test record 
		String query = "from Destination where airPort = '"+DESTINATION_NAME+"'";
		List <Destination> destinationList = sessionFactory.
				getCurrentSession().createQuery(query).list();
		assertEquals("First check database have no test record",destinationList.isEmpty(),true);
		
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
		destination.setAirPort("DNK");
		
		destinationDAO.saveDestination(destination);
		
		// Check database have at least one test record
		destinationList = sessionFactory.
				getCurrentSession().createQuery(query).list();
		assertEquals("Check database have at least one test record",destinationList.isEmpty(),false);
		
		// Check HashSet 
		destinationMultiLanguageSet = destinationList.get(0).getDestinationMultiLanguage();
		for (DestinationMultiLanguage destinationMultiLanguage : destinationMultiLanguageSet) {
		    System.out.println(destinationMultiLanguage.getAirPortMultiLanguage());
		}
		assertEquals("Check translate numbers",
				destinationMultiLanguageSet.size(),TRANSLATE_NUMBER);
		
		// Get record
		assertNotNull(destinationDAO.getDestination(destination.getId()));
		
		// Remove record 
		destinationDAO.removeDestination(destination);
		assertNull(destinationDAO.getDestination(destination.getId()));
	}	
}
