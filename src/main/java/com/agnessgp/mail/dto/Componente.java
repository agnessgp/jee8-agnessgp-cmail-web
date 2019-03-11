package com.agnessgp.mail.dto;

import lombok.Getter;
import lombok.Setter;

public class Componente {

	@Getter
	@Setter
	private String id;
	@Getter
	@Setter
	private String tipo;
	@Getter
	@Setter
	private Boolean visible;

	public Componente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Componente(String id, String tipo, Boolean visible) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.visible = visible;
	}

}
