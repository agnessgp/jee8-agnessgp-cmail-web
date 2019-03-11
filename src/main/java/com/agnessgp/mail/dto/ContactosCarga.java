/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agnessgp.mail.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
	

/**
 * Descripción de la Clase
 *
 * @Autor: Patricio Pilco
 * @Fecha: 24/02/2019
 */
public class ContactosCarga implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 212656770454231315L;

	@Getter
    @Setter
    private int id;

    @Getter
    @Setter
    private String nombres;

    @Getter
    @Setter
    private String apellidos;

    @Getter
    @Setter
    private String correoElectronico;

    public ContactosCarga(int id, String nombres, String apellidos, String correoElectronico) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correoElectronico = correoElectronico;
    }

    public ContactosCarga() {
    }

}
