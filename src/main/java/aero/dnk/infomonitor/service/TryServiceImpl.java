package aero.dnk.infomonitor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import aero.dnk.infomonitor.dao.CompanyDAO;
import aero.dnk.infomonitor.domain.Company;

@Service


public class TryServiceImpl implements TryService{
	
	@Autowired
	private CompanyDAO companyDAO;
	
	@Override

	@Transactional
	public void tryServiceMethod(){

		Company company = new Company("New company", "/path/path.jpg");
		companyDAO.saveCompany(company);

		
		
		System.out.println("Try service");
		
	}
}

