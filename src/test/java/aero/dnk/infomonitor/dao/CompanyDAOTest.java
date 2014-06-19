package aero.dnk.infomonitor.dao;

import java.util.List;

import aero.dnk.infomonitor.dao.flight.CompanyDAO;
import aero.dnk.infomonitor.domain.*;
import aero.dnk.infomonitor.domain.flight.Company;
import static org.junit.Assert.*;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/META-INF/spring/root-context.xml")
public class CompanyDAOTest {
	
	private static final String COMPANY_NAME = "Some Company";
	private static final String IMAGE_PATH = "/logo/some company logo.jpg";

	@Autowired
	private CompanyDAO companyDAO;
	
	@Autowired
    SessionFactory sessionFactory;	
	
	@SuppressWarnings("unchecked")
	@Test
	@Transactional
	public void companyDAOSaveGetDelete(){
		
		//	First check database have no test record 
		String query = "from Company where name = '"+COMPANY_NAME+"'";
		List <Company> companyList = sessionFactory.
				getCurrentSession().createQuery(query).list();
		assertEquals("First check database have no test record",companyList.isEmpty(),true);
		
		// Save record
		Company company = new Company(COMPANY_NAME, IMAGE_PATH);
		companyDAO.saveCompany(company);
		
		// Check database have at least one test record
		companyList = sessionFactory.
				getCurrentSession().createQuery(query).list();
		assertEquals("Check database have at least one test record",companyList.isEmpty(),false);
		
		// Get record
		assertNotNull(companyDAO.getCompany(company.getId()));
		
		// Remove record 
		companyDAO.removeCompany(company);
		assertNull(companyDAO.getCompany(company.getId()));
	}
}