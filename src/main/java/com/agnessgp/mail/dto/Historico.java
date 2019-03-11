package com.agnessgp.mail.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

public class Historico {

	@Getter @Setter
	private String urlOpcion;
	
	@Getter @Setter
	private int orden;
	
	@Getter @Setter
	private Accion accion;
	
	@Getter @Setter
	private String detalle;
	
	@Getter @Setter
	private Date fecha;	
	
	public Historico() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Historico(String urlOpcion, int orden, Accion accion, String detalle, Date fecha) {
		super();
		this.urlOpcion = urlOpcion;
		this.orden = orden;
		this.accion = accion;
		this.detalle = detalle;
		this.fecha = fecha;
	}


}
