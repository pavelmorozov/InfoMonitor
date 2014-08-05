package aero.dnk.infomonitor.dao.media;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import aero.dnk.infomonitor.dao.monitor.FlightClassDAO;
import aero.dnk.infomonitor.domain.flight.DestinationMultiLanguage;
import aero.dnk.infomonitor.domain.media.Image;
import aero.dnk.infomonitor.domain.monitor.FlightClass;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/META-INF/spring/root-context.xml")
public class ImageDAOTest {
	private static final String IMAGE1_NAME = "IMAGE";
	private static final String IMAGE2_NAME = "IMAGE";
	private static final String IMAGE3_NAME = "IMAGE";
	private static final String IMAGE1_FILE = "IMAGE 1 FILE";
	private static final String IMAGE2_FILE = "IMAGE 2 FILE";
	private static final String IMAGE3_FILE = "IMAGE 3 FILE";
	
	@Autowired
	private ImageDAO imageDAO;
	
	@Autowired
    SessionFactory sessionFactory;	
	
	@SuppressWarnings("unchecked")
	@Test
	@Transactional
	public void testSaveGetDelete(){
		//	First check database have no test record 
		String query = "from Image where imageName = '"
				+IMAGE1_NAME+"'";
		List <Image> entityList = sessionFactory.
				getCurrentSession().createQuery(query).list();
		assertEquals("First check database have no test record", entityList.isEmpty(),true);

		// Save record
		Image image = new Image(IMAGE1_NAME, IMAGE1_FILE);
		imageDAO.save(image);
		
		// Check database have at least one test record
		entityList = sessionFactory.
				getCurrentSession().createQuery(query).list();
		assertEquals("Check database have at least one test record",entityList.isEmpty(),false);
		
		// Check List
		image = new Image(IMAGE2_NAME, IMAGE2_FILE);
		imageDAO.save(image);
		
		image = new Image(IMAGE3_NAME, IMAGE3_FILE);
		imageDAO.save(image);
		
		entityList = imageDAO.list();
		assertNotNull("Check objects list",entityList.size());
		System.out.println("");
		System.out.println("**************************************************************");
		System.out.println("");
		for (Image imageEntity : entityList) {
		    System.out.println(imageEntity.getImageName());
		} 
		System.out.println("");
		System.out.println("**************************************************************");
		System.out.println("");
		// Get record
		assertNotNull(imageDAO.get(image.getId()));		
		
		// Remove record 
		imageDAO.remove(image);
		assertNull(imageDAO.get(image.getId()));
	}
}
