package aero.dnk.infomonitor.dao.monitor;

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

import aero.dnk.infomonitor.dao.flight.CodeShareDAO;
import aero.dnk.infomonitor.dao.flight.CompanyDAO;
import aero.dnk.infomonitor.dao.flight.DestinationDAO;
import aero.dnk.infomonitor.dao.flight.RegularFlightDAO;
import aero.dnk.infomonitor.dao.monitor.FlightRegistrationInfoDAO;
import aero.dnk.infomonitor.domain.flight.CodeShare;
import aero.dnk.infomonitor.domain.flight.Company;
import aero.dnk.infomonitor.domain.flight.Destination;
import aero.dnk.infomonitor.domain.flight.DestinationMultiLanguage;
import aero.dnk.infomonitor.domain.flight.RegularFlight;
import aero.dnk.infomonitor.domain.monitor.FlightClass;
import aero.dnk.infomonitor.domain.monitor.FlightRegistrationInfo;
import aero.dnk.infomonitor.domain.monitor.MonitorInfo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/META-INF/spring/root-context.xml")
public class FlightRegistrationInfoDAOTest {
	private static final String FLIGHT_NUMBER = "TestFlight_777";
	private static final String BUSINESS_CLASS_NAME = "Buss class";
	private static final String MONITOR_ID = "first monitor";
	
	@Autowired
	private FlightClassDAO flightClassDAO;
	@Autowired
	private RegularFlightDAO regularFlightDAO;
	@Autowired
	private FlightRegistrationInfoDAO flightRegistrationInfoDAO;
	
	@Autowired
    SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Test
	@Transactional
	public void testDAOSaveGetDelete(){
		//	First check database have no test record 
		String query = "from FlightRegistrationInfo where id = '"
				+MONITOR_ID+"'";
		
		List <FlightRegistrationInfo> entityList = sessionFactory.
				getCurrentSession().createQuery(query).list();
		assertEquals("First check database have no test record", entityList.isEmpty(),true);

		// Save record
		FlightClass flightClass = new FlightClass(BUSINESS_CLASS_NAME);
		flightClassDAO.save(flightClass);		
		
		RegularFlight regularFlight = new RegularFlight(null,FLIGHT_NUMBER,null);
		regularFlightDAO.save(regularFlight);
		
		FlightRegistrationInfo flightRegistrationInfo = new FlightRegistrationInfo(MONITOR_ID, regularFlight, flightClass); 
		flightRegistrationInfoDAO.save(flightRegistrationInfo);
		
		// Check database have at least one test record
		entityList = sessionFactory.
				getCurrentSession().createQuery(query).list();
		assertEquals("Check database have at least one test record",entityList.isEmpty(),false);
		
		// Check record
	    System.out.println(flightRegistrationInfo.getId()+" "
	    		+flightRegistrationInfo.getClass().getName()+" "
	    		+flightRegistrationInfo.getFlight().getFlightNumber());

		// Get record
	    assertNotNull(flightRegistrationInfoDAO.get(MONITOR_ID));
	    
		// Remove record 
	    flightRegistrationInfoDAO.remove(flightRegistrationInfo);
		assertNull(flightRegistrationInfoDAO.get(MONITOR_ID));	    
	}	
}
