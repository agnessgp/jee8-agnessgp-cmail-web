package com.agnessgp.mail.dto;

import lombok.Getter;
import lombok.Setter;

public class Accion {

	@Getter
	@Setter
	private int id;
	@Getter
	@Setter
	private String nombre;
	@Getter
	@Setter
	private Boolean deshabilitado;
	@Getter
	@Setter
	private Boolean visible;
	@Getter
	@Setter
	private String url;
	@Getter
	@Setter
	private String icono;
	@Getter
	@Setter
	private String update;
	@Getter
	@Setter
	private Boolean ajax;

	public Accion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Accion(int id, String nombre, Boolean deshabilitado, Boolean visible, String url, String icono, String update, Boolean ajax) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.deshabilitado = deshabilitado;
		this.visible = visible;
		this.url = url;
		this.icono = icono;
		this.update = update;
		this.ajax = ajax;
	}

	

}
