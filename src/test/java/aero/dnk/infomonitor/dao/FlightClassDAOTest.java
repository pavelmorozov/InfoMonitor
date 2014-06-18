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

import aero.dnk.infomonitor.domain.FlightClass;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/META-INF/spring/root-context.xml")
public class FlightClassDAOTest {
	private static final String BUSINESS_CLASS_NAME = "Buss class";
	private static final String ECONOMY_CLASS_NAME = "Eco class";
	
	@Autowired
	private FlightClassDAO flightClassDAO;
	
	@Autowired
    SessionFactory sessionFactory;	
	
	@SuppressWarnings("unchecked")
	@Test
	@Transactional
	public void flightClassDAOSaveGetDelete(){
		//	First check database have no test record 
		String query = "from FlightClass where className = '"
				+BUSINESS_CLASS_NAME+"'";
		List <FlightClass> entityList = sessionFactory.
				getCurrentSession().createQuery(query).list();
		assertEquals("First check database have no test record", entityList.isEmpty(),true);

		// Save record
		FlightClass flightClass = new FlightClass(BUSINESS_CLASS_NAME);
		flightClassDAO.save(flightClass);
		
		// Check database have at least one test record
		entityList = sessionFactory.
				getCurrentSession().createQuery(query).list();
		assertEquals("Check database have at least one test record",entityList.isEmpty(),false);
		
		// Check List
		flightClass = new FlightClass(ECONOMY_CLASS_NAME);
		flightClassDAO.save(flightClass);
		
		entityList = flightClassDAO.list();
		assertEquals("Check objects list",entityList.size(),2);
		
		// Get record
		assertNotNull(flightClassDAO.get(flightClass.getId()));		
		
		// Remove record 
		flightClassDAO.remove(flightClass);
		assertNull(flightClassDAO.get(flightClass.getId()));
	}
}
