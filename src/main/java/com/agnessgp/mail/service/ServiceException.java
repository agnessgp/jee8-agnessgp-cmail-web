/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agnessgp.mail.service;

import lombok.Getter;
import lombok.Setter;

/**
 * Descripción de la Clase
 *
 * @Autor: Patricio Pilco
 * @Fecha: 24/02/2019
 */
public class ServiceException extends Exception {

	@Getter
	@Setter
	private Integer httpStatusCode;

	private static final long serialVersionUID = -1873750263916403862L;

	public ServiceException(String message, Integer httpStatusCode) {
		super(message);
		this.httpStatusCode = httpStatusCode;
	}

	public ServiceException(String message) {
		super(message);
	}

}
