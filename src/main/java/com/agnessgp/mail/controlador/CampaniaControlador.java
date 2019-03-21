/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.agnessgp.mail.controlador;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.PrimeFaces;

import com.agnessgp.mail.bean.CalendarBean;
import com.agnessgp.mail.bean.CampaniaBean;
import com.agnessgp.mail.bean.MenuBean;
import com.agnessgp.mail.dto.Componente;
import com.agnessgp.mail.modelo.Campania;
import com.agnessgp.mail.service.CampaniaService;
import com.agnessgp.mail.service.ComponenteService;
import com.agnessgp.mail.service.ServiceException;
import com.agnessgp.mail.util.UtilBean;

import lombok.Getter;

/**
 * Descripción de la Clase
 * 
 * @Autor: Patricio Pilco
 * @Fecha: 25/02/2019
 */
@Named("campania")
@SessionScoped
public class CampaniaControlador implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8428022532443544177L;

	@Inject
	@Getter
	CampaniaBean campaniaBean;

	@EJB
	ComponenteService componenteService;
	
	@EJB
	CampaniaService campaniaService;

	@Inject
	@Getter
	private MenuBean menuBean;
	
	@Inject
	@Getter
	UtilBean utilBean;

	@PostConstruct
	public void init() {
		Logger.getAnonymousLogger().info("Cargando Campania Controlador....");
		campaniaBean.initListaCampaniasTodos();
		campaniaBean.initListaComponentes();
		campaniaBean.setListaComponentes(componenteService.crear(campaniaBean.getListaComponentes(),
				new Componente("frgCrearNuevaCampania", "ui:fragment", Boolean.FALSE)));
		menuBean.initControlador("campania");
		PrimeFaces.current().ajax().update("frmCrearNuevaCampania");
	}

	public boolean obtenerEstadoComponente(String id) {
		Componente componente = componenteService.buscarPorId(campaniaBean.getListaComponentes(), id);
		if (componente != null) {
			return componente.getVisible();
		}
		return Boolean.FALSE;
	}
	
	public void limpiarCampania() {
		campaniaBean.setCampania(new Campania());
	}
	
	public void nuevoAction() {
		limpiarCampania();
		//campaniaBean.getCampania().setFechaCreacion(LocalDate.now());
		componenteService.activarPorId(campaniaBean.getListaComponentes(), "frgCrearNuevaCampania");
	}
	
	public String crearCampaniaEnProgreso() {
		try {
			campaniaBean.getCampania().setFechaCreacion(LocalDate.now());
			campaniaService.crearNuevoCampaniaEnProgreso(campaniaBean.getCampania());
			buscarCampaniaTodos();
			utilBean.mostrarMensajeInfoPanel("Aviso", "El contacto fué creado exitosamente.");
			componenteService.inactivarPorId(campaniaBean.getListaComponentes(), "frgCrearNuevaCampania");
			return itemEditar();
			//PrimeFaces.current().ajax().update("frmCrearNuevaCampania");
		} catch (ServiceException e) {
			utilBean.mostrarMensajeErrorPanel("Error", e.getMessage());
		}
		return null;
	}
	
	public void buscarCampaniaTodos() {
		try {
			campaniaBean.setListaCampaniasTodos(campaniaService.listarCampania());
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
		}
	}
	
	public String itemEditar() {
		return "pg_campania_detalle.xhtml?faces-redirect=true";
	}

	public void itemEliminar() {
		
	}
}
