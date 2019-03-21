/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agnessgp.mail.modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

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
    @NamedQuery(name = Campania.BUSCAR_TODOS, query = "SELECT c FROM Campania c")
})
public class Campania implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -1437559718440229531L;
	// ======================================
    // =             Constantes              =
    // ======================================
    public static final String BUSCAR_TODOS = "Campania.encontrarTodos";

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
    private String descripcion;
    
    @Getter
	@Setter
	private String tipo;
    
    @Getter
	@Setter
	private String estado;

    @Getter
    @Setter
    private LocalDate fechaCreacion;
    
    @Getter
    @Setter
    private Boolean calendarizado;
    
    @Getter
    @Setter
    private Date fechaCalendarizacion;
   
    
    @Getter
    @Setter
    @OneToMany(mappedBy = "campania")
    Set<Publicacion> publicaciones;
    
}
