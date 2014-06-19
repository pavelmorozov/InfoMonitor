package aero.dnk.infomonitor.dao.monitor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import aero.dnk.infomonitor.domain.monitor.ImageInfo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/META-INF/spring/root-context.xml")
public class ImageInfoDAOTest {
	private static final String IMAGE_NAME = "First image";
	private static final String IMAGE_PATH = "/abc/def.gif";
	private static final String MONITOR_ID = "first monitor";
	
	@Autowired
	private ImageInfoDAO imageInfoDAO;
	
	@Autowired
    SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Test
	@Transactional
	public void testDAOSaveGetDelete(){
		//	First check database have no test record 
		String query = "from ImageInfo where id = '"
				+MONITOR_ID+"'";
		
		List <ImageInfo> entityList = sessionFactory.
				getCurrentSession().createQuery(query).list();
		assertEquals("First check database have no test record", entityList.isEmpty(),true);

		// Save record
		ImageInfo imageInfo = new ImageInfo(MONITOR_ID, IMAGE_NAME, IMAGE_PATH); 
		imageInfoDAO.save(imageInfo);
		
		// Check database have at least one test record
		entityList = sessionFactory.
				getCurrentSession().createQuery(query).list();
		assertEquals("Check database have at least one test record",entityList.isEmpty(),false);
		
		// Check record
	    System.out.println(imageInfo.getId()+" "
	    		+imageInfo.getImageName()+" "
	    		+imageInfo.getImagePath());

		// Get record
	    assertNotNull(imageInfoDAO.get(MONITOR_ID));
	    
		// Remove record 
	    imageInfoDAO.remove(imageInfo);
		assertNull(imageInfoDAO.get(MONITOR_ID));	    
	}	

}
