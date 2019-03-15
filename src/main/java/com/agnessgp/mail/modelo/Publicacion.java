package com.agnessgp.mail.modelo;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import com.agnessgp.mail.modelo.pk.PublicacionPK;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Publicacion implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2754869969956470950L;

	 @EmbeddedId
	 private PublicacionPK  mailingPK;
	 
	 @Column
	 @Getter
	 @Setter
	 private String estado;
	 
	 @Column
	 @Getter
	 @Setter
	 private String usuario;
	 
	 @Column
	 @Getter
	 @Setter
	 private LocalDate fechaCreacion;
	 
	 @Getter
	 @Setter
	 @ManyToOne
	 @MapsId("campaniaId")
	 @JoinColumn(name = "campaniaId")
	 Campania campania;
	 
	 @Getter
	 @Setter
	 @ManyToOne
	 @MapsId("plantillaId")
	 @JoinColumn(name = "plantillaId")
	 Plantilla plantilla;
	    
	 @Getter
	 @Setter
	 @ManyToOne
	 @MapsId("segmentoId")
	 @JoinColumn(name = "segmentoId")
	 Segmento segmento;
	 
}
