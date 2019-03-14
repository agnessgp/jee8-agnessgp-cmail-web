package com.agnessgp.mail.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import org.primefaces.model.menu.MenuElement;
import org.primefaces.model.menu.MenuModel;

import com.agnessgp.mail.dto.Accion;
import com.agnessgp.mail.service.SubMenuService;

import lombok.Getter;
import lombok.Setter;

@Dependent
public class MenuBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1258483720047462190L;

	@EJB
	private SubMenuService subMenuService;

	@Getter
	@Setter
	private List<Accion> listaAcciones;

	@Getter
	@Setter
	private MenuModel model;
	
	@Getter
	@Setter
	private String nombreControlador;

	@Getter
	@Setter
	private Accion accionSeleccion;

	public void initControlador(String nombreControlador) {
		setNombreControlador(nombreControlador); 
		if(nombreControlador.equals("contacto")) {
			listaAcciones = subMenuService.cargarAccionesBasico();
		}else if(nombreControlador.equals("campania")) {
			listaAcciones = subMenuService.cargarAccionesCampania();
		}
		
		model = subMenuService.cargarModelAccionesBasico(nombreControlador, listaAcciones);
	}
	
	/*Métodos Comunes*/
	public void activarAccionSeleccion() {
		listaAcciones = subMenuService.activarAccion(getListaAcciones(), getAccionSeleccion());
		model = subMenuService.cargarModelAccionesBasico(getNombreControlador(), listaAcciones);
	}

	public void inactivarAccionSeleccion() {
		listaAcciones = subMenuService.inactivarAccion(getListaAcciones(), getAccionSeleccion());
		model = subMenuService.cargarModelAccionesBasico(getNombreControlador(), listaAcciones);
	}

}
