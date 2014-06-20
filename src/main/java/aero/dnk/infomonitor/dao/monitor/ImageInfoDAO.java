package aero.dnk.infomonitor.dao.monitor;

import java.util.List;

import org.springframework.dao.DataAccessException;

import aero.dnk.infomonitor.domain.monitor.ImageInfo;

public interface ImageInfoDAO {
	void save(ImageInfo imageInfo) throws DataAccessException;
	void remove(ImageInfo imageInfo) throws DataAccessException;
	ImageInfo get(String id) throws DataAccessException;
	public List <ImageInfo> list()
		throws DataAccessException;
}
