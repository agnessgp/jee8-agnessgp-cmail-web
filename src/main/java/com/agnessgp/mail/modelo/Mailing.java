/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.agnessgp.mail.modelo;

import com.agnessgp.mail.modelo.pk.MailingPK;
import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import lombok.Getter;
import lombok.Setter;

/**
 * Descripción de la Clase
 * @Autor: Patricio Pilco
 * @Fecha: 24/02/2019
 */
@Entity
@NamedQueries({
    @NamedQuery(name = Mailing.BUSCAR_TODOS, query = "SELECT c FROM Mailing c"),
    @NamedQuery(name = Mailing.BUSCAR_POR_CAMPANIA, query = "SELECT c FROM Mailing c WHERE c.mailingPK.campaniaId = :campaniaId"),
})
public class Mailing implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = -789568563566129264L;
	public final static String BUSCAR_TODOS = "Mailing.bucarTodos";
    public final static String BUSCAR_POR_CAMPANIA = "Mailing.buscarPorCampania";
    
    @EmbeddedId
    private MailingPK  mailingPK;
    
    @Column
    @Getter
    @Setter
    private Boolean entrego;
    
    @Column
    @Getter
    @Setter
    private String error;
    
    @Column
    @Getter
    @Setter
    private LocalDate fechaRegistro;
    
    
    @Getter
    @Setter
    @ManyToOne
    @MapsId("campaniaId")
    @JoinColumn(name = "campaniaId")
    Campania campania;
 
    @Getter
    @Setter
    @ManyToOne
    @MapsId("contactoId")
    @JoinColumn(name = "contactoId")
    Contacto contacto;

    public Mailing(MailingPK mailingPK, Boolean entrego, String error, LocalDate fechaRegistro) {
        this.mailingPK = mailingPK;
        this.entrego = entrego;
        this.error = error;
        this.fechaRegistro = fechaRegistro;
    }

    public Mailing() {
    }
    
    
    
}
