/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.agnessgp.mail.controlador;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.agnessgp.mail.bean.EmisorBean;
import com.agnessgp.mail.bean.PlantillaBean;
import com.agnessgp.mail.modelo.Plantilla;
import com.agnessgp.mail.service.ComponenteService;
import com.agnessgp.mail.service.EmisorService;
import com.agnessgp.mail.service.PlantillaService;
import com.agnessgp.mail.service.ServiceException;
import com.agnessgp.mail.util.UtilBean;

import lombok.Getter;

/**
 * Descripción de la Clase
 * 
 * @Autor: Patricio Pilco
 * @Fecha: 25/02/2019
 */
@Named("plantilla")
@SessionScoped
public class PlantillaControlador implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5929149178091639435L;

	@Inject
	@Getter
	PlantillaBean plantillaBean;
	
	@EJB
	ComponenteService componenteService;
	
	@EJB
	EmisorService emisorService;

	@EJB
	PlantillaService plantillaService;

	@Inject
	@Getter
	UtilBean utilBean;

	@PostConstruct
	public void init() {
		Logger.getAnonymousLogger().info("Cargando Plantilla Controlador....");
		plantillaBean.initListaItemsPlanillaTodos();
		cargarListaItemsTodos();
	}

	public void cargarListaItemsTodos() {
		try {
			List<Plantilla> listaPlantillas = plantillaService.listarPlantillaTodos();
			plantillaBean.setListaItemsPlanillaTodos(plantillaService.listarItemsPlantilla(listaPlantillas));
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
