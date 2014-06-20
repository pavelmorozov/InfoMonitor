package aero.dnk.infomonitor.dao.monitor;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import aero.dnk.infomonitor.domain.monitor.FlightRegistrationInfo;
import aero.dnk.infomonitor.domain.monitor.ImageInfo;

@Repository
public class ImageInfoDAOImpl implements ImageInfoDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void save(ImageInfo imageInfo) throws DataAccessException {
		sessionFactory.getCurrentSession().save(imageInfo);
	}

	@Override
	public void remove(ImageInfo imageInfo) throws DataAccessException {
		if (null != imageInfo) {
			sessionFactory.getCurrentSession().delete(imageInfo);
		}
	}

	@Override
	public ImageInfo get(String id) throws DataAccessException {
		ImageInfo instance = (ImageInfo) sessionFactory
				.getCurrentSession().get(ImageInfo.class, id);
		return instance;
	}

	@Override
	public List<ImageInfo> list() throws DataAccessException {
		@SuppressWarnings("unchecked")
		List <ImageInfo> list = (List <ImageInfo>) sessionFactory.getCurrentSession().
				createQuery("from ImageInfo").list();
				return list;
	}
}
