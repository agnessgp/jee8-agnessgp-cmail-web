package com.agnessgp.mail.modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

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

@Entity
@NamedQueries({
    @NamedQuery(name = Segmento.BUSCAR_TODOS, query = "SELECT c FROM Segmento c")
})
public class Segmento implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6031012373732728395L;
	// ======================================
    // =             Constantes              =
    // ======================================
    public static final String BUSCAR_TODOS = "Segmento.encontrarTodos";

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
    private String detalle;
    
    @Column
    @Getter
    @Setter
    private String estado;
    
    @Column
    @Getter
    @Setter
    private LocalDate fechaCreacion;
    
    @Getter
    @Setter
    @OneToMany(mappedBy = "segmento")
    Set<Publicacion> publicaciones;
    
    @Getter
    @Setter
    @ManyToMany
    Set<Contacto> contactos;
    
    
}
