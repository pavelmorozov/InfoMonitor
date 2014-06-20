package aero.dnk.infomonitor.dao.monitor;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import aero.dnk.infomonitor.domain.monitor.FlightRegistrationInfo;
import aero.dnk.infomonitor.domain.monitor.TwoFlightsRegistrationInfo;

@Repository
public class TwoFlightsRegistrationInfoDAOImpl implements
		TwoFlightsRegistrationInfoDAO {
	
	@Autowired
	private SessionFactory sessionFactory;	
	
	@Override
	public void save(TwoFlightsRegistrationInfo twoFlightsRegistrationInfo)
			throws DataAccessException {
		sessionFactory.getCurrentSession().save(twoFlightsRegistrationInfo);
	}

	@Override
	public void remove(TwoFlightsRegistrationInfo twoFlightsRegistrationInfo)
			throws DataAccessException {
		if (null != twoFlightsRegistrationInfo) {
			sessionFactory.getCurrentSession().delete(twoFlightsRegistrationInfo);
		}	
	}

	@Override
	public TwoFlightsRegistrationInfo get(String id) throws DataAccessException {
		TwoFlightsRegistrationInfo instance = (TwoFlightsRegistrationInfo) sessionFactory
				.getCurrentSession().get(TwoFlightsRegistrationInfo.class, id);
		return instance;
	}

	@Override
	public List<TwoFlightsRegistrationInfo> list() throws DataAccessException {
		@SuppressWarnings("unchecked")
		List <TwoFlightsRegistrationInfo> list = (List <TwoFlightsRegistrationInfo>) sessionFactory.getCurrentSession().
				createQuery("from TwoFlightsRegistrationInfo").list();
		return list;
	}
}
