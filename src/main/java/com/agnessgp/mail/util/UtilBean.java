package com.agnessgp.mail.util;

import java.io.Serializable;

import javax.faces.application.FacesMessage;

import org.primefaces.PrimeFaces;

public class UtilBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4426959700816478743L;

	public void mostrarMensajeInfoPanel(String titulo, String mensaje) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, titulo, mensaje);
		PrimeFaces.current().dialog().showMessageDynamic(message);
	}

	public void mostrarMensajeErrorPanel(String titulo, String mensaje) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, titulo, mensaje);
		PrimeFaces.current().dialog().showMessageDynamic(message);
	}

	public void mostrarMensajeWarmPanel(String titulo, String mensaje) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, titulo, mensaje);
		PrimeFaces.current().dialog().showMessageDynamic(message);
	}

	public void mostrarMensajeFatalPanel(String titulo, String mensaje) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_FATAL, titulo, mensaje);
		PrimeFaces.current().dialog().showMessageDynamic(message);
	}

}
