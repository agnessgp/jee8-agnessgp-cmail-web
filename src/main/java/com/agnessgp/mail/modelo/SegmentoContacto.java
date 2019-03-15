/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.agnessgp.mail.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

/**
 * Descripción de la Clase
 * @Autor: Patricio Pilco
 * @Fecha: 24/02/2019
 */
@Entity
/*
@NamedQueries({
    @NamedQuery(name = SegmentoContacto.BUSCAR_TODOS, query = "SELECT c FROM SegmentoContacto c"),
    @NamedQuery(name = SegmentoContacto.BUSCAR_POR_CAMPANIA, query = "SELECT c FROM SegmentoContacto c WHERE c.mailingPK.campaniaId = :campaniaId"),
})
*/
public class SegmentoContacto implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = -789568563566129264L;
	//public final static String BUSCAR_TODOS = "Mailing.bucarTodos";
    //public final static String BUSCAR_POR_CAMPANIA = "Mailing.buscarPorCampania";
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;
    
    @Column
    @Getter
    @Setter
    private Long idSegmento;
    
    @Column
    @Getter
    @Setter
    private Long idContacto;
    
}
