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
 * @Autor: Patricio Pilco
 * @Fecha: 24/02/2019
 */
public class DatosMail implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -4472784578805686597L;
	@Getter
    @Setter
    private String from;
    @Getter
    @Setter
    private String subject;
    @Getter
    @Setter
    private String to;
    @Getter
    @Setter
    private String content;
    
	public DatosMail() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
    
    
    
}
