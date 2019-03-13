package com.agnessgp.mail.dao;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.agnessgp.mail.modelo.Campania;
import com.agnessgp.mail.service.ServiceException;

@Stateless
public class CampaniaDAO {

	@PersistenceContext(name = "ap-agnessgp-mail-PU")
	private EntityManager em;
	
	public Campania obtenerPorId(Long id) {
		return em.find(Campania.class, id);
	}
	
	public List<Campania> obtenerTodos() throws ServiceException {
		try {
			TypedQuery<Campania> query = em.createNamedQuery(Campania.BUSCAR_TODOS, Campania.class);
			List<Campania> listaCampanias = query.getResultList();
			return listaCampanias;
		} catch (Exception e) {
			Logger.getAnonymousLogger().info(e.getMessage());
			throw new ServiceException(e.getMessage());
		}
	}
	
	public Campania actualizar(Campania campania) {
		return em.merge(campania);
	}

	public void crear(Campania campania) {
		em.persist(campania);
	}
}
