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

import com.agnessgp.mail.modelo.Emisor;
import com.agnessgp.mail.service.ServiceException;

/**
 * Descripción de la Clase
 *
 * @Autor: Patricio Pilco
 * @Fecha: 24/02/2019
 */
@Stateless
public class EmisorDAO {

	@PersistenceContext(name = "ap-agnessgp-mail-PU")
	private EntityManager em;

	public List<Emisor> obtenerTodos() throws ServiceException {
		try {
			TypedQuery<Emisor> query = em.createNamedQuery(Emisor.BUSCAR_TODOS, Emisor.class);
			List<Emisor> listaEmisores = query.getResultList();
			return listaEmisores;
		} catch (Exception e) {
			Logger.getAnonymousLogger().info(e.getMessage());
			throw new ServiceException(e.getMessage());
		}
	}

	public Emisor obtenerPorId(Long id) {
		return em.find(Emisor.class, id);
	}

	public Emisor actualizar(Emisor emisor) {
		return em.merge(emisor);
	}

	public void crear(Emisor emisor) throws ServiceException {
		try {
			em.persist(emisor);
		} catch (Exception e) {
			Logger.getAnonymousLogger().info(e.getMessage());
			throw new ServiceException(e.getMessage());
		}
	}
}
