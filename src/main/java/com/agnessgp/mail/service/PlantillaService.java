package com.agnessgp.mail.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.model.SelectItem;

import com.agnessgp.mail.dao.PlantillaDAO;
import com.agnessgp.mail.modelo.Plantilla;

@Stateless
public class PlantillaService implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1851253729855823210L;
	@EJB
	PlantillaDAO plantillaDAO;

	public List<Plantilla> listarPlantillaTodos() throws ServiceException {
		return plantillaDAO.obtenerTodos();
	}

	public Plantilla crearNuevaPlantilla(Plantilla plantilla) throws ServiceException {
		plantillaDAO.crear(plantilla);
		return plantilla;
	}

	public List<SelectItem> listarItemsPlantilla(List<Plantilla> listaPlantillas) throws ServiceException {
		List<SelectItem> listaItems = new ArrayList<SelectItem>();
		listaPlantillas.stream()
				.forEach((item) -> listaItems.add(new SelectItem(item.getNombre(), item.getId().toString())));
		return listaItems;
	}
}
