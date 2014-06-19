package aero.dnk.infomonitor.dao.monitor;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import aero.dnk.infomonitor.domain.monitor.FlightRegistrationInfo;

@Repository
public class FlightRegistrationInfoDAOImpl implements FlightRegistrationInfoDAO {
	
	@Autowired
	private SessionFactory sessionFactory;	

	@Override
	public void save(FlightRegistrationInfo flightRegistrationInfo)
			throws DataAccessException {
		sessionFactory.getCurrentSession().save(flightRegistrationInfo);
	}

	@Override
	public void remove(FlightRegistrationInfo flightRegistrationInfo)
			throws DataAccessException {
		if (null != flightRegistrationInfo) {
			sessionFactory.getCurrentSession().delete(flightRegistrationInfo);
		}	
	}

	@Override
	public FlightRegistrationInfo get(String id) throws DataAccessException {
		FlightRegistrationInfo instance = (FlightRegistrationInfo) sessionFactory
				.getCurrentSession().get(FlightRegistrationInfo.class, id);
		return instance;
	}

	@Override
	public List<FlightRegistrationInfo> list() throws DataAccessException {
		@SuppressWarnings("unchecked")
		List <FlightRegistrationInfo> list = (List <FlightRegistrationInfo>) sessionFactory.getCurrentSession().
				createQuery("from FlightRegistrationInfo").list();
				return list;
	}

}
