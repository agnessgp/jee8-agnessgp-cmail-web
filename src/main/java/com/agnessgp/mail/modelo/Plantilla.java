package com.agnessgp.mail.modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Plantilla implements Serializable{

	
	/**
	* 
	*/
	private static final long serialVersionUID = -7943012191472012245L;

		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Getter
	    @Setter
	    private Long id;
	    
	    @Column
	    @Getter
	    @Setter
	    private String nombre;
	    
	    @Column
	    @Getter
	    @Setter
	    private String html;
	    
	    @Column
	    @Getter
	    @Setter
	    private String texto;
	    
	    @Column
	    @Getter
	    @Setter
	    private String imagen;
	    
	    @Column
	    @Getter
	    @Setter
	    private String url;
	    
	    @Column
	    @Getter
	    @Setter
	    private String tipo;
	    
	    @Column
	    @Getter
	    @Setter
	    private LocalDate fechaCreacion ;
	    
	    @Column
	    @Getter
	    @Setter
	    private String estado;
	    
	    @Column
	    @Getter
	    @Setter
	    private String usuario;
	    
	    @Getter
	    @Setter
	    @OneToMany(mappedBy = "plantilla")
	    Set<Publicacion> publicaciones;
	    
}
