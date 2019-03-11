package com.agnessgp.mail.controlador;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import org.primefaces.model.menu.MenuModel;

import com.agnessgp.mail.dto.Accion;
import com.agnessgp.mail.service.SubMenuService;

import lombok.Getter;
import lombok.Setter;

@Named
@SessionScoped
public class SubMenuPaginaControlador implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1258483720047462190L;

	@EJB
	@Getter
	private SubMenuService subMenuService;

	@Getter
	@Setter
	private List<Accion> listaAcciones;

	@Getter
	@Setter
	private MenuModel model;

	@Getter
	@Setter
	private Accion accionSeleccion;

	@PostConstruct
	public void init() {
		listaAcciones = getSubMenuService().cargarAccionesBasico();
		model = getSubMenuService().cargarModelAccionesBasico("contacto", listaAcciones);
	}

	public void activarAccionSeleccion() {
		listaAcciones = getSubMenuService().activarAccion(getListaAcciones(), getAccionSeleccion());
		model = getSubMenuService().cargarModelAccionesBasico("contacto", listaAcciones);
	}

	public void inactivarAccionSeleccion() {
		listaAcciones = getSubMenuService().inactivarAccion(getListaAcciones(), getAccionSeleccion());
		model = getSubMenuService().cargarModelAccionesBasico("contacto", listaAcciones);
	}

}
