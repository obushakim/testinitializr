package obus.api.testinitializr.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import obus.api.testinitializr.entity.Obus;

@Transactional
@Repository("obusDao")
public class ObusDao {

	@PersistenceContext
	private EntityManager entityManager;

	public Obus getObusById(int id) {
		return entityManager.find(Obus.class, id);
	}

	public List<Obus> getObuses() {
		Query query = entityManager.createQuery("FROM Obus as ob ORDER BY ob.id");
		return query.getResultList();
	}

	public void insertObus(Obus obus) {
		entityManager.persist(obus);
	}

	public void updateObus(Obus obus) {
		Obus ob = getObusById(obus.getId());
		ob.setId(obus.getId());
		ob.setNama(obus.getNama());

		entityManager.flush();
	}

	public void deleteObus(int id) {
		entityManager.remove(getObusById(id));
	}
}
