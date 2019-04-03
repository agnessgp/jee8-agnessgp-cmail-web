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
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.PrimeFaces;
import org.primefaces.event.MenuActionEvent;
import org.primefaces.model.menu.MenuItem;

import com.agnessgp.mail.bean.EmisorBean;
import com.agnessgp.mail.bean.MenuBean;
import com.agnessgp.mail.dto.Componente;
import com.agnessgp.mail.modelo.Contacto;
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
@Named("contacto")
@SessionScoped
public class EmisorControlador implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8428022532443544177L;

	@Inject
	@Getter
	EmisorBean emisorBean;

	//@EJB
	//@Getter
	//ContactoService contactoService;

	@EJB
	@Getter
	ComponenteService componenteService;	
	
	@Inject
	@Getter
	private MenuBean menuBean;
	
	@Inject
	@Getter
	UtilBean utilBean;
	
	@PostConstruct
	public void init() {
		Logger.getAnonymousLogger().info("Cargando Emisor Controlador....");
		emisorBean.initEmisor();
		emisorBean.initListaEmisores();
		emisorBean.initListaComponentes();
		emisorBean.setListaComponentes(componenteService.crear(emisorBean.getListaComponentes(),
				new Componente("frgCrearNuevo", "ui:fragment", Boolean.FALSE)));
		menuBean.initControlador("emisor");
		PrimeFaces.current().ajax().update("frmCrearNuevoEmisor");
	}

	public boolean obtenerEstadoComponente(String id) {
		Componente componente = componenteService.buscarPorId(emisorBean.getListaComponentes(), id);
		if (componente != null) {
			return componente.getVisible();
		}
		return Boolean.FALSE;
	}

	/*
	public void crearContacto() {
		try {
			contactoService.crearNuevoContacto(contactoBean.getContacto());
			limpiarContacto();
			buscarContactosTodos();
			utilBean.mostrarMensajeInfoPanel("Aviso", "El contacto fué creado exitosamente.");
			componenteService.inactivarPorId(contactoBean.getListaComponentes(), "frgCrearNuevo");
			PrimeFaces.current().ajax().update("frmCrearNuevo");
		} catch (ServiceException e) {
			utilBean.mostrarMensajeErrorPanel("Error", e.getMessage());
		}
	}

	public void limpiarContacto() {
		contactoBean.setContacto(new Contacto());
	}

	public void buscarContactosTodos() {
		try {
			contactoBean.setListaContactosTodos(contactoService.listarContactos());
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			Logger.getAnonymousLogger().info(contactoBean.getContacto().getCorreoElectronico());
		}
	}

	public void nuevoAction() {
		limpiarContacto();
		componenteService.activarPorId(contactoBean.getListaComponentes(), "frgCrearNuevo");
	}

	public String informacionAction() {
		Logger.getAnonymousLogger().info("clicInformacion....");
		FacesContext.getCurrentInstance().getExternalContext().getFlash().put("informacionVisible", true);
		return "/pages/private/contactos/pg_contactos_inicio.xhtml";
	}

	public void cancelarBtnContacto() {
		componenteService.inactivarPorId(contactoBean.getListaComponentes(), "frgCrearNuevo");
		PrimeFaces.current().ajax().update("frmCrearNuevo");
	}

	public void buscarAction(ActionEvent event) {
		MenuItem menuItem = ((MenuActionEvent) event).getMenuItem();
		//subMenuPagina
		//String icono = new String(menuItem.getIcon()); 
		//Logger.getAnonymousLogger().info("icono...." + icono);
	}
*/
}
