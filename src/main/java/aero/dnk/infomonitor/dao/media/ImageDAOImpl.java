package aero.dnk.infomonitor.dao.media;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import aero.dnk.infomonitor.domain.media.Image;
import aero.dnk.infomonitor.domain.monitor.FlightClass;

@Repository
public class ImageDAOImpl implements ImageDAO {

	@Autowired
	private SessionFactory sessionFactory;	
	
	@Override
	public void save(Image image) throws DataAccessException {
		sessionFactory.getCurrentSession().save(image);
	}

	@Override
	public void remove(Image image) throws DataAccessException {
		if (null != image) {
			sessionFactory.getCurrentSession().delete(image);
		}
	}

	@Override
	public Image get(Long id) throws DataAccessException {
		Image item = (Image) sessionFactory
				.getCurrentSession().get(Image.class, id);
		return item;
	}

	@Override
	public List<Image> list() throws DataAccessException {
		@SuppressWarnings("unchecked")
		List <Image> list = (List <Image>) sessionFactory.getCurrentSession().
			createQuery("from Image").list();
		return list;
	}

}
