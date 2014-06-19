package aero.dnk.infomonitor.dao.flight;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import aero.dnk.infomonitor.domain.flight.Company;

@Repository
public class CompanyDAOImpl implements CompanyDAO {
	
	@Autowired
	private SessionFactory sessionFactory;	

	@Override
	public void saveCompany(Company company) throws DataAccessException {
		sessionFactory.getCurrentSession().save(company);
	}

	@Override
	public void removeCompany(Company company) throws DataAccessException {
		if (null != company) {
			sessionFactory.getCurrentSession().delete(company);
		}
	}

	@Override
	public Company getCompany(Long id) throws DataAccessException {
		Company company = (Company) sessionFactory.getCurrentSession().get(Company.class, id);
		return company; 		
	}

}
