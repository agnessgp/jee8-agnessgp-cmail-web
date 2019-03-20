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

import com.agnessgp.mail.bean.EditorBean;
import com.agnessgp.mail.modelo.Emisor;
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
@Named("editor")
@SessionScoped
public class EditorControlador implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5929149178091639435L;

	@Inject
	@Getter
	EditorBean editorBean;

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
		Logger.getAnonymousLogger().info("Cargando Emisor Controlador....");
		editorBean.initListaItemsEditorTodos();
		cargarListaItemsEmisorTodos();
	}

	public void cargarListaItemsEmisorTodos() {
		try {
			List<Emisor> listaEmisores = emisorService.listarEmisorTodos();
			editorBean.setListaItemsEmisorTodos(emisorService.listarItemsEmisor(listaEmisores));
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
