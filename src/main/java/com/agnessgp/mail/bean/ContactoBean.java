/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agnessgp.mail.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.Dependent;

import com.agnessgp.mail.dto.Componente;
import com.agnessgp.mail.modelo.Contacto;

import lombok.Getter;
import lombok.Setter;

/**
 * Descripción de la Clase
 *
 * @Autor: Patricio Pilco
 * @Fecha: 25/02/2019
 */
@Dependent
public class ContactoBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4375398620241704973L;

	@Setter
	@Getter
	private List<Componente> listaComponentes;
	
	@Setter
	@Getter
	private Contacto contacto;
	
	@Getter
	@Setter
	private List<Contacto> listaContactosTodos;	
	
	@Getter
	@Setter
	private Boolean informacionVisible;

	public void initNuevoContacto() {
		setContacto(new Contacto());
	}
	
	public void initListaContactos() {
		setListaContactosTodos(new ArrayList<>());
	}
	
	public void initListaComponentes() {
		setListaComponentes(new ArrayList<>());
	}
}
