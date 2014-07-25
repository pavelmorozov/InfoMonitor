package aero.dnk.infomonitor.dao.media;

import java.util.List;
import org.springframework.dao.DataAccessException;
import aero.dnk.infomonitor.domain.media.Image;

public interface ImageDAO {
	void save(Image image) throws DataAccessException;
	void remove(Image image) throws DataAccessException;
	Image get(Long id) throws DataAccessException;
	public List <Image> list()
		throws DataAccessException;
}
