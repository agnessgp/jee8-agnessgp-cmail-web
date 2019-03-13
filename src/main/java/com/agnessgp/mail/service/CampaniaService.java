package com.agnessgp.mail.service;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.agnessgp.mail.dao.CampaniaDAO;
import com.agnessgp.mail.modelo.Campania;

@Stateless
public class CampaniaService implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8219674445578196982L;
	@EJB
	CampaniaDAO campaniaDAO;
	
	public List<Campania> listarCampania() throws ServiceException {
		return campaniaDAO.obtenerTodos();
	}
	
	public Campania crearNuevoContacto(Campania campania) throws ServiceException {
			campaniaDAO.crear(campania);
			return campania;
	}
}
