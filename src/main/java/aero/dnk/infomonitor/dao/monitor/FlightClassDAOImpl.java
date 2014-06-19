package aero.dnk.infomonitor.dao.monitor;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import aero.dnk.infomonitor.domain.monitor.FlightClass;

@Repository
public class FlightClassDAOImpl implements FlightClassDAO {
	
	@Autowired
	private SessionFactory sessionFactory;	

	@Override
	public void save(FlightClass flightClass) throws DataAccessException {
		sessionFactory.getCurrentSession().save(flightClass);
	}

	@Override
	public void remove(FlightClass flightClass) throws DataAccessException {
		if (null != flightClass) {
			sessionFactory.getCurrentSession().delete(flightClass);
		}
	}

	@Override
	public FlightClass get(Long id) throws DataAccessException {
		FlightClass flightClass = (FlightClass) sessionFactory
				.getCurrentSession().get(FlightClass.class, id);
		return flightClass;
	}

	@Override
	public List<FlightClass> list() throws DataAccessException {
		@SuppressWarnings("unchecked")
		List <FlightClass> list = (List <FlightClass>) sessionFactory.getCurrentSession().
				createQuery("from FlightClass").list();
				return list;
	}

}
