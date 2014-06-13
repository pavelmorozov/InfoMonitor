package aero.dnk.infomonitor.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import aero.dnk.infomonitor.domain.Company;
import aero.dnk.infomonitor.domain.Destination;
import aero.dnk.infomonitor.domain.RegularFlight;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/META-INF/spring/root-context.xml")
public class RegularFlightDAOTest {

	private static final String DESTINATION_NAME = "DNK";
	private static final String FLIGHT_NUMBER = "TestFlight_777";
	private static final String COMPANY_NAME = "Test company";
	
	@Autowired
	private RegularFlightDAO regularFlightDAO;
	
	@Autowired
    SessionFactory sessionFactory;	
	
	@Test
	@Transactional
	public void destinationDAOSaveGetDelete(){
		//	First check database have no test record 
		
//		String query = "from RegularFlight";
		
//		String query = "from RegularFlight where flightNumber = '"
//				+FLIGHT_NUMBER+"'";
//		@SuppressWarnings("unchecked")
//		List <RegularFlight> regularFlightList = sessionFactory.
//				getCurrentSession().createQuery(query).list();

		String query = "from RegularFlight";
		
		@SuppressWarnings("unchecked")
		List c = sessionFactory.
				getCurrentSession().createQuery(query).list();

		
		//assertEquals("First check database have no test record", regularFlightList.isEmpty(),true);
	}

}
