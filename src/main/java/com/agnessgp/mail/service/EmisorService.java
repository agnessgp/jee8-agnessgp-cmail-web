package com.agnessgp.mail.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.model.SelectItem;

import com.agnessgp.mail.dao.EmisorDAO;
import com.agnessgp.mail.modelo.Emisor;

@Stateless
public class EmisorService implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1851253729855823210L;
	@EJB
	EmisorDAO emisorDAO;

	public List<Emisor> listarEmisorTodos() throws ServiceException {
		return emisorDAO.obtenerTodos();
	}

	public Emisor crearNuevoEmisor(Emisor emisor) throws ServiceException {
		emisorDAO.crear(emisor);
		return emisor;
	}

	public List<SelectItem> listarItemsEmisor(List<Emisor> listaEmisores) throws ServiceException {
		List<SelectItem> listaItems = new ArrayList<SelectItem>();
		listaEmisores.stream()
				.forEach((item) -> listaItems.add(new SelectItem(item.getNombre(), item.getId().toString())));
		return listaItems;
	}
}
