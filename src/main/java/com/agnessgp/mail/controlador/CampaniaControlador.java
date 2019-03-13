/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.agnessgp.mail.controlador;

import java.io.Serializable;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.ManagedProperty;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.PrimeFaces;

import com.agnessgp.mail.bean.CampaniaBean;
import com.agnessgp.mail.dto.Componente;
import com.agnessgp.mail.service.ComponenteService;
import com.agnessgp.mail.util.UtilBean;

import lombok.Getter;
import lombok.Setter;

/**
 * Descripción de la Clase
 * 
 * @Autor: Patricio Pilco
 * @Fecha: 25/02/2019
 */
@Named("campania")
@SessionScoped
public class CampaniaControlador extends UtilBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8428022532443544177L;

	@Inject
	@Getter
	CampaniaBean campaniaBean;

	@EJB
	@Getter
	ComponenteService componenteService;

	@Getter
	@Setter
	@ManagedProperty(value = "#{subMenuPaginaControlador}")
	private SubMenuPaginaControlador subMenuPagina;

	@PostConstruct
	public void init() {
		Logger.getAnonymousLogger().info("Cargando Campania Controlador....");
		campaniaBean.initListaCampaniasTodos();
		campaniaBean.initListaComponentes();
		campaniaBean.setListaComponentes(componenteService.crear(campaniaBean.getListaComponentes(),
				new Componente("frgCrearNuevaCampania", "ui:fragment", Boolean.FALSE)));
		PrimeFaces.current().ajax().update("frmCrearNuevaCampania");
		
		subMenuPagina.initListaAcciones();
		subMenuPagina.initControlador("campania");
	}

	public boolean obtenerEstadoComponente(String id) {
		Componente componente = componenteService.buscarPorId(campaniaBean.getListaComponentes(), id);
		if (componente != null) {
			return componente.getVisible();
		}
		return Boolean.FALSE;
	}
}
