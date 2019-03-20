/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agnessgp.mail.dao;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.agnessgp.mail.modelo.Contacto;
import com.agnessgp.mail.modelo.Plantilla;
import com.agnessgp.mail.service.ServiceException;

/**
 * Descripción de la Clase
 *
 * @Autor: Patricio Pilco
 * @Fecha: 24/02/2019
 */
@Stateless
public class PlantillaDAO {

	@PersistenceContext(name = "ap-agnessgp-mail-PU")
	private EntityManager em;

	public List<Plantilla> obtenerTodos() throws ServiceException {
		try {
			TypedQuery<Plantilla> query = em.createNamedQuery(Plantilla.BUSCAR_TODOS, Plantilla.class);
			List<Plantilla> listaPlantillas = query.getResultList();
			return listaPlantillas;
		} catch (Exception e) {
			Logger.getAnonymousLogger().info(e.getMessage());
			throw new ServiceException(e.getMessage());
		}
	}

	public Contacto obtenerPorId(Long id) {
		return em.find(Contacto.class, id);
	}

	public Plantilla actualizar(Plantilla plantilla) {
		return em.merge(plantilla);
	}

	public void crear(Plantilla plantilla) throws ServiceException {
		try {
			em.persist(plantilla);
		} catch (Exception e) {
			Logger.getAnonymousLogger().info(e.getMessage());
			throw new ServiceException(e.getMessage());
		}
	}
}
