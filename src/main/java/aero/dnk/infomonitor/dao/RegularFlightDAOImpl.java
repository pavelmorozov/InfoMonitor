package aero.dnk.infomonitor.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import aero.dnk.infomonitor.domain.Company;
import aero.dnk.infomonitor.domain.Destination;
import aero.dnk.infomonitor.domain.RegularFlight;

@Repository
public class RegularFlightDAOImpl implements RegularFlightDAO {

	@Autowired
	private SessionFactory sessionFactory;	

	
	@Override
	public void save(RegularFlight regularFlight) throws DataAccessException {
		sessionFactory.getCurrentSession().save(regularFlight);

	}

	@Override
	public void remove(RegularFlight regularFlight) throws DataAccessException {
		if (null != regularFlight) {
			sessionFactory.getCurrentSession().delete(regularFlight);
		}

	}

	@Override
	public RegularFlight get(Long id) throws DataAccessException {
		RegularFlight regularFlight = (RegularFlight) sessionFactory
				.getCurrentSession().get(RegularFlight.class, id);
		return regularFlight;
	}

	@Override
	public List <RegularFlight> list()
		throws DataAccessException{
		@SuppressWarnings("unchecked")
		List <RegularFlight> list = (List <RegularFlight>) sessionFactory.getCurrentSession().
				createQuery("from RegularFlight").list();
				return list;
	}
	
	@Override
	public List <RegularFlight> search(Destination destination,
		String flightNumber, Company company)
		throws DataAccessException{
		
		Criteria criteria = sessionFactory.getCurrentSession().
		createCriteria(RegularFlight.class);
		
		if (destination!= null) {
			criteria.add(Restrictions.eq("destination", destination));
		}
		if (flightNumber!= null) {
			criteria.add(Restrictions.like("flightNumber", flightNumber));
		};
		if (company!= null) {
			criteria.add(Restrictions.eq("company", company));
		};

		@SuppressWarnings("unchecked")
		List<RegularFlight> registerList = (List<RegularFlight>) criteria.list();
		
		return registerList;
	}
}
