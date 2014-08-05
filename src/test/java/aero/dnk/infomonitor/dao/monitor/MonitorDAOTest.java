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
import aero.dnk.infomonitor.domain.monitor.Monitor;
import aero.dnk.infomonitor.domain.monitor.MonitorInfo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/META-INF/spring/root-context.xml")
public class MonitorDAOTest {
	private static final String FLIGHT_NUMBER = "TestFlight_777";
	private static final String BUSINESS_CLASS_NAME = "Buss class";
	private static final String BUSINESS_CLASS_COLOR = "777777";
	private static final String MONITOR_ID = "first monitor";
	
	@Autowired
	private FlightClassDAO flightClassDAO;
	@Autowired
	private RegularFlightDAO regularFlightDAO;
	@Autowired
	private FlightRegistrationInfoDAO flightRegistrationInfoDAO;
	@Autowired	
	private MonitorDAO monitorDAO;
//	@Autowired	
//	private MonitorInfoDAO monitorInfoDAO;
	
	@Autowired
    SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Test
	@Transactional
	public void testDAOSaveGetDelete(){
		//	First check database have no test record 
		String query = "from Monitor where id = '"
				+MONITOR_ID+"'";
		
		List <FlightRegistrationInfoDAO> entityList = sessionFactory.
				getCurrentSession().createQuery(query).list();
		assertEquals("First check database have no test record", entityList.isEmpty(),true);

		// Save record
		FlightClass flightClass = new FlightClass(BUSINESS_CLASS_NAME, BUSINESS_CLASS_COLOR);
		flightClassDAO.save(flightClass);		
		
		RegularFlight regularFlight = new RegularFlight(null,FLIGHT_NUMBER,null);
		regularFlightDAO.save(regularFlight);
		
		FlightRegistrationInfo flightRegistrationInfo = new FlightRegistrationInfo(MONITOR_ID, regularFlight, flightClass); 
		flightRegistrationInfoDAO.save(flightRegistrationInfo);
		
		Monitor monitor = new Monitor(MONITOR_ID, flightRegistrationInfo);
		monitorDAO.save(monitor);
		
		// Check database have at least one test record
		entityList = sessionFactory.
				getCurrentSession().createQuery(query).list();
		assertEquals("Check database have at least one test record",entityList.isEmpty(),false);
		
		// Check record
	    System.out.println(monitor.getMonitorName()+" "
	    		+monitor.getMonitorInfo().getClass()+" "
	    		+monitor.getMonitorInfo().getId());
	    
	    if (monitor.getMonitorInfo() instanceof FlightRegistrationInfo) {
	    	System.out.println(monitor.getMonitorInfo().getClass().getName());
	    	flightRegistrationInfo = flightRegistrationInfoDAO.get(monitor.getMonitorInfo().getId());
	    	
	    	System.out.println("Flight number: "+
	    	flightRegistrationInfo.getFlight().getFlightNumber()+" "+
	    			flightRegistrationInfo.getFlightClass().getClassName());	    	
	    }else{
	    	System.out.println("XXX --- unknown class --- XXX");
	    }
	    
		// Get record
	    assertNotNull(monitorDAO.get(MONITOR_ID));
	    
		// List record
	    assertEquals("Test list records",monitorDAO.list().isEmpty(),false);

		// Remove record 
	    monitorDAO.remove(monitor);
		assertNull(monitorDAO.get(MONITOR_ID));	    
	}
}
