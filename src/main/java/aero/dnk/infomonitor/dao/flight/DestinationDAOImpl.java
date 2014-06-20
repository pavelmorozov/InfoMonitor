package aero.dnk.infomonitor.dao.flight;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import aero.dnk.infomonitor.domain.flight.Company;
import aero.dnk.infomonitor.domain.flight.Destination;

@Repository
public class DestinationDAOImpl implements DestinationDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Destination getDestination(Long id) throws DataAccessException{
		Destination destination = (Destination) sessionFactory.getCurrentSession().get(Destination.class, id);
		return destination; 				
	}
	
	@Override
	public void saveDestination(Destination destination) throws DataAccessException{
		sessionFactory.getCurrentSession().save(destination);
	}
	
	@Override
	public void removeDestination(Destination destination) throws DataAccessException{
		if (null != destination) {
			sessionFactory.getCurrentSession().delete(destination);
		}		
	}	
}
