package aero.dnk.infomonitor.dao.flight;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import aero.dnk.infomonitor.domain.flight.CodeShare;
import aero.dnk.infomonitor.domain.flight.Company;
import aero.dnk.infomonitor.domain.flight.Destination;
import aero.dnk.infomonitor.domain.flight.RegularFlight;

@Repository
public class CodeShareDAOImpl implements CodeShareDAO {
	
	@Autowired
	private SessionFactory sessionFactory;	
	

	@Override
	public void save(CodeShare codeShare) throws DataAccessException {
		sessionFactory.getCurrentSession().save(codeShare);
	}

	@Override
	public void remove(CodeShare codeShare) throws DataAccessException {
		if (null != codeShare) {
			sessionFactory.getCurrentSession().delete(codeShare);
		}		
	}

	@Override
	public CodeShare get(Long id) throws DataAccessException {
		CodeShare codeShare = (CodeShare) sessionFactory
				.getCurrentSession().get(CodeShare.class, id);
		return codeShare;
	}

	@Override
	public List<CodeShare> list() throws DataAccessException {
		@SuppressWarnings("unchecked")
		List <CodeShare> list = (List <CodeShare>) sessionFactory.getCurrentSession().
				createQuery("from CodeShare").list();
				return list;
	}

	@Override
	public List<CodeShare> search(String flightNumber,
			Company company) throws DataAccessException {
		
		Criteria criteria = sessionFactory.getCurrentSession().
		createCriteria(CodeShare.class);
		
		if (flightNumber!= null) {
			criteria.add(Restrictions.like("flightNumber", flightNumber));
		};
		if (company!= null) {
			criteria.add(Restrictions.eq("flightCompany", company));
		};

		@SuppressWarnings("unchecked")
		List<CodeShare> list = (List<CodeShare>) criteria.list();

		return list;
	}
}
