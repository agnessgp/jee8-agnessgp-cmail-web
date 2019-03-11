/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agnessgp.mail.modelo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
    @NamedQuery(name = Contacto.BUSCAR_TODOS, query = "SELECT c FROM Contacto c"),
    @NamedQuery(name = Contacto.BUSCAR_POR_ID, query = "SELECT c FROM Contacto c WHERE c.id = :id"),
    @NamedQuery(name = Contacto.BUSCAR_POR_CORREO, query = "SELECT c FROM Contacto c WHERE c.correoElectronico = :correoElectronico")
})

public class Contacto implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -564634924623737646L;
	// ======================================
    // =             Constantes              =
    // ======================================
    public static final String BUSCAR_TODOS = "Contacto.encontrarTodos";
    public static final String BUSCAR_POR_ID = "Contacto.encontrarPorId";
    public static final String BUSCAR_POR_CORREO = "Contacto.encontrarPorCorreo";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;
    @Column
    @Getter
    @Setter
    private String nombres;
    @Column
    @Getter
    @Setter
    private String apellidos;
    @Column
    @Getter
    @Setter
    private String correoElectronico;

    @Getter
    @Setter
    @OneToMany(mappedBy = "contacto")
    Set<Mailing> mailings;

    public Contacto(Long id, String nombres, String apellidos, String correoElectronico) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correoElectronico = correoElectronico;
    }

    public Contacto() {
    }

}
