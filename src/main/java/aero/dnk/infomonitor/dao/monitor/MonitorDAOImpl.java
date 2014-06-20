package aero.dnk.infomonitor.dao.monitor;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import aero.dnk.infomonitor.domain.monitor.FlightClass;
import aero.dnk.infomonitor.domain.monitor.Monitor;

@Repository
public class MonitorDAOImpl implements MonitorDAO {

	@Autowired
	private SessionFactory sessionFactory;	
	
	@Override
	public void save(Monitor monitor) throws DataAccessException {
		sessionFactory.getCurrentSession().save(monitor);
	}

	@Override
	public void remove(Monitor monitor) throws DataAccessException {
		if (null != monitor) {
			sessionFactory.getCurrentSession().delete(monitor);
		}	
	}

	@Override
	public Monitor get(String id) throws DataAccessException {
		Monitor instance = (Monitor) sessionFactory
				.getCurrentSession().get(Monitor.class, id);
		return instance;
	}

	@Override
	public List<Monitor> list() throws DataAccessException {
		@SuppressWarnings("unchecked")
		List <Monitor> list = (List <Monitor>) sessionFactory.getCurrentSession().
				createQuery("from Monitor").list();
				return list;
	}

}
