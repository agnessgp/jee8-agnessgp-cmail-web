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
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.agnessgp.mail.modelo.Contacto;
import com.agnessgp.mail.service.ServiceException;

/**
 * Descripción de la Clase
 *
 * @Autor: Patricio Pilco
 * @Fecha: 24/02/2019
 */
@Stateless
public class ContactoDAO {

	@PersistenceContext(name = "ap-agnessgp-mail-PU")
	private EntityManager em;

	public List<Contacto> obtenerTodos() throws ServiceException {
		try {
			TypedQuery<Contacto> query = em.createNamedQuery(Contacto.BUSCAR_TODOS, Contacto.class);
			List<Contacto> listaContactos = query.getResultList();
			return listaContactos;
		} catch (Exception e) {
			Logger.getAnonymousLogger().info(e.getMessage());
			throw new ServiceException(e.getMessage());
		}
	}

	public Contacto obtenerPorId(Long id) {
		return em.find(Contacto.class, id);
	}

	public Contacto obtenerPorCorreo(String correo) throws ServiceException {

		Logger.getAnonymousLogger().info("obtenerPorCorreo");
		try {
			CriteriaBuilder cb = em.getCriteriaBuilder();
			CriteriaQuery<Contacto> consulta = cb.createQuery(Contacto.class);
			Root<Contacto> contactos = consulta.from(Contacto.class);
			Predicate preCorreo = null;
			if (correo != null) {
				preCorreo = cb.equal(contactos.get("correoElectronico"), correo);
			}
			consulta.select(contactos).where(preCorreo);
			List<Contacto> lista = em.createQuery(consulta).getResultList();
			if (lista != null && !lista.isEmpty()) {
				return lista.get(0);
			} else {
				return null;
			}
		} catch (Exception e) {
			Logger.getAnonymousLogger().info(e.getMessage());
			throw new ServiceException(e.getMessage());
		}
	}

	public Contacto actualizar(Contacto contacto) {
		return em.merge(contacto);
	}

	public void crear(Contacto contacto) throws ServiceException {
		try {
			em.persist(contacto);
		} catch (Exception e) {
			Logger.getAnonymousLogger().info(e.getMessage());
			throw new ServiceException(e.getMessage());
		}
	}
}
