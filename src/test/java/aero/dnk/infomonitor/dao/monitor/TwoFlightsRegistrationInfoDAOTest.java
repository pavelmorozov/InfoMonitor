package aero.dnk.infomonitor.dao.monitor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import aero.dnk.infomonitor.dao.flight.RegularFlightDAO;
import aero.dnk.infomonitor.domain.flight.RegularFlight;
import aero.dnk.infomonitor.domain.monitor.FlightClass;
import aero.dnk.infomonitor.domain.monitor.FlightRegistrationInfo;
import aero.dnk.infomonitor.domain.monitor.TwoFlightsRegistrationInfo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/META-INF/spring/root-context.xml")
public class TwoFlightsRegistrationInfoDAOTest {
	private static final String FLIGHT_NUMBER1 = "TestFlight_777";
	private static final String FLIGHT_NUMBER2 = "TestFlight_888";
	private static final String MONITOR_ID = "first monitor";
	
	@Autowired
	private RegularFlightDAO regularFlightDAO;
	
	@Autowired
	private TwoFlightsRegistrationInfoDAO twoFlightsRegistrationInfoDAO;
	
	@Autowired
    SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Test
	@Transactional
	public void testDAOSaveGetDelete(){
		//	First check database have no test record 
		String query = "from TwoFlightsRegistrationInfo where id = '"
				+MONITOR_ID+"'";
		
		List <TwoFlightsRegistrationInfo> entityList = sessionFactory.
				getCurrentSession().createQuery(query).list();
		assertEquals("First check database have no test record", entityList.isEmpty(),true);
		
		// Save record
		RegularFlight regularFlight1 = new RegularFlight(null,FLIGHT_NUMBER1,null);
		RegularFlight regularFlight2 = new RegularFlight(null,FLIGHT_NUMBER2,null);
		regularFlightDAO.save(regularFlight1);
		regularFlightDAO.save(regularFlight2);
		
		TwoFlightsRegistrationInfo twoFlightsRegistrationInfo = new TwoFlightsRegistrationInfo(MONITOR_ID, regularFlight1, regularFlight2); 
		twoFlightsRegistrationInfoDAO.save(twoFlightsRegistrationInfo);
		
		// Check database have at least one test record
		entityList = sessionFactory.
				getCurrentSession().createQuery(query).list();
		assertEquals("Check database have at least one test record",entityList.isEmpty(),false);
		
		// Check record
	    System.out.println(twoFlightsRegistrationInfo.getId()+" "
	    		+twoFlightsRegistrationInfo.getFlight1().getFlightNumber()+" "
	    		+twoFlightsRegistrationInfo.getFlight2().getFlightNumber());		

		// Get record
	    assertNotNull(twoFlightsRegistrationInfoDAO.get(MONITOR_ID));
	    
		// Remove record 
	    twoFlightsRegistrationInfoDAO.remove(twoFlightsRegistrationInfo);
		assertNull(twoFlightsRegistrationInfoDAO.get(MONITOR_ID));	    
	}
}
