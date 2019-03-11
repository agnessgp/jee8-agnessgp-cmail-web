package com.agnessgp.mail.util;

import lombok.Getter;
import lombok.Setter;

public enum AccionesEnum {

	ATRAS(1,"ATRAS","ui-icon-arrow-back"),
	REFRESCAR(2,"REFRESCAR","ui-icon-refresh"),
	NUEVO(3,"NUEVO","ui-icon-description"),
	BUSCAR(4,"BUSCAR","ui-icon-find-in-page"),
	INFORMACION(5,"INFORMACION","ui-icon-announcement");
	
	@Getter @Setter
	private int id;
	
	@Getter @Setter
	private String descripcion;
	
	@Getter @Setter
	private String icono;

	
	private AccionesEnum(int id, String descripcion, String icono) {
		this.id = id;
		this.descripcion = descripcion;
		this.icono = icono;
	} 
	
	
}
