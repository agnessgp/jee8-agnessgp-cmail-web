/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agnessgp.mail.modelo;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

/**
 * Descripción de la Clase
 *
 * @Autor: Patricio Pilco
 * @Fecha: 24/02/2019
 */
@Entity
@NamedQueries({
    @NamedQuery(name = Empresa.BUSCAR_TODOS, query = "SELECT c FROM Empresa c")
})
public class Empresa implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = -7656013614781692081L;

	// ======================================
    // =             Constantes              =
    // ======================================
    public static final String BUSCAR_TODOS = "Empresa.encontrarTodos";

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;

	@Getter
	@Setter
	private String nombre;
	
    @Getter
    @Setter
    private String correoElectronico;
    
    @Getter
	@Setter
	private String apodo;
    
    @OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL)
    private Set<Emisor> emisores;
    
}
