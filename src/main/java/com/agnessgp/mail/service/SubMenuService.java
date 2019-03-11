package com.agnessgp.mail.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.MenuModel;

import com.agnessgp.mail.dto.Accion;
import com.agnessgp.mail.util.AccionesEnum;

@Stateless
public class SubMenuService {

	public List<Accion> cargarAccionesBasico() {
		List<Accion> listaAcciones = new ArrayList<>();
		listaAcciones.add(new Accion(AccionesEnum.ATRAS.getId(), AccionesEnum.ATRAS.getDescripcion(), Boolean.TRUE,	Boolean.TRUE, "/pg_contactos_inicio",  AccionesEnum.ATRAS.getIcono(),"",Boolean.TRUE));
		listaAcciones.add(new Accion(AccionesEnum.REFRESCAR.getId(), AccionesEnum.REFRESCAR.getDescripcion(),	Boolean.FALSE, Boolean.TRUE, "/pg_contactos_inicio", AccionesEnum.REFRESCAR.getIcono(),"",Boolean.TRUE));
		listaAcciones.add(new Accion(AccionesEnum.NUEVO.getId(), AccionesEnum.NUEVO.getDescripcion(), Boolean.FALSE,	Boolean.TRUE, "/pg_contactos_inicio", AccionesEnum.NUEVO.getIcono(),"frmCrearNuevo",Boolean.TRUE));
		listaAcciones.add(new Accion(AccionesEnum.BUSCAR.getId(), AccionesEnum.BUSCAR.getDescripcion(), Boolean.FALSE,Boolean.TRUE, "/pg_contactos_inicio", AccionesEnum.BUSCAR.getIcono(),"",Boolean.TRUE));
		listaAcciones.add(new Accion(AccionesEnum.INFORMACION.getId(), AccionesEnum.INFORMACION.getDescripcion(), Boolean.FALSE,Boolean.TRUE, "/pg_contactos_inicio", AccionesEnum.INFORMACION.getIcono(),"",Boolean.FALSE));
		return listaAcciones;
	}

	public MenuModel cargarModelAccionesBasico(String controlador, List<Accion> listaAcciones) {
		MenuModel model = new DefaultMenuModel();
		for (Accion accion : listaAcciones) {
			DefaultMenuItem item = new DefaultMenuItem(accion.getNombre());
			item.setUpdate(accion.getUpdate());
			item.setIcon(accion.getIcono());
			item.setDisabled(accion.getDeshabilitado());
			String command = "#{".concat(controlador).concat(".").concat(accion.getNombre().toLowerCase())
					.concat("Action}");
			item.setCommand(command);
			item.setAjax(accion.getAjax());
			item.setStyle("font-size:10px;");
			model.addElement(item);
		}
		return model;
	}

	public List<Accion> activarAccion(List<Accion> listaAcciones, Accion accion) {

		for (Accion accionItem : listaAcciones) {
			if (accionItem.getId() == accion.getId()) {
				accionItem.setDeshabilitado(Boolean.FALSE);
			}
		}
		return listaAcciones;
	}

	public List<Accion> inactivarAccion(List<Accion> listaAcciones, Accion accion) {
		for (Accion accionItem : listaAcciones) {
			if (accionItem.getId() == accion.getId()) {
				accionItem.setDeshabilitado(Boolean.TRUE);
			}
		}
		return listaAcciones;
	}
}
