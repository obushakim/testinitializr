package obus.api.testinitializr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import obus.api.testinitializr.dao.ObusDao;
import obus.api.testinitializr.entity.Obus;

@Service("obusService")
public class ObusService {

	@Autowired
	@Qualifier("obusDao")
	private ObusDao obusDao;

	public Obus getObusById(int id) {
		return obusDao.getObusById(id);
	}

	public List<Obus> getObuses() {
		return obusDao.getObuses();
	}

	public void insertObus(Obus obus) {
		obusDao.insertObus(obus);
	}

	public void updateObus(Obus obus) {
		obusDao.updateObus(obus);
	}

	public void deleteObus(int id) {
		obusDao.deleteObus(id);
	}
}
