﻿package aero.dnk.infomonitor.dao.monitor;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import aero.dnk.infomonitor.domain.monitor.Monitor;
import aero.dnk.infomonitor.domain.monitor.MonitorInfo;

@Repository
public class MonitorInfoDAOImpl implements MonitorInfoDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void save(MonitorInfo monitorInfo) throws DataAccessException {
		sessionFactory.getCurrentSession().save(monitorInfo);
	}

	@Override
	public void remove(MonitorInfo monitorInfo) throws DataAccessException {
		if (null != monitorInfo) {
			sessionFactory.getCurrentSession().delete(monitorInfo);
		}	
	}

	@Override
	public MonitorInfo get(String id) throws DataAccessException {
		MonitorInfo instance = (MonitorInfo) sessionFactory
				.getCurrentSession().get(MonitorInfo.class, id);
		return instance;
	}

	@Override
	public List<MonitorInfo> list() throws DataAccessException {
		@SuppressWarnings("unchecked")
		List <MonitorInfo> list = (List <MonitorInfo>) sessionFactory.getCurrentSession().
				createQuery("from MonitorInfo").list();
		return list;
	}

	@Override
	public void update(MonitorInfo monitorInfo) throws DataAccessException {
		//delete MonitorInfo with id passed
		Monitor monitor = (Monitor) sessionFactory
				.getCurrentSession().get(Monitor.class, monitorInfo.getId());
		monitor.setMonitorInfo(null);
		
		MonitorInfo monitorInfoPersisted = (MonitorInfo) sessionFactory
				.getCurrentSession().get(MonitorInfo.class, monitorInfo.getId());
		
		if (monitorInfoPersisted != null){
			sessionFactory.getCurrentSession().delete(monitorInfoPersisted);
		}
		
		//save MonitorInfo
		sessionFactory.getCurrentSession().save(monitorInfo);
		monitor.setMonitorInfo(monitorInfo);
		sessionFactory.getCurrentSession().save(monitor);
	}
	
	

}
