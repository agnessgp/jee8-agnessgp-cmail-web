/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.agnessgp.mail.modelo.pk;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;

/**
 * Descripción de la Clase
 * @Autor: Patricio Pilco
 * @Fecha: 25/02/2019
 */
@Embeddable
public class PublicacionPK implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 2577730240726187297L;

	@Getter
    @Setter
    private Long campaniaId;
    
    @Getter
    @Setter
    private Long plantillaId;
    
    @Getter
    @Setter
    private Long receptorId;
    
    @Getter
    @Setter
    private Long emisorId;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((campaniaId == null) ? 0 : campaniaId.hashCode());
		result = prime * result + ((plantillaId == null) ? 0 : plantillaId.hashCode());
		result = prime * result + ((receptorId == null) ? 0 : receptorId.hashCode());
		result = prime * result + ((emisorId == null) ? 0 : emisorId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			
			return false;
		PublicacionPK other = (PublicacionPK) obj;
		if (campaniaId == null) {
			if (other.campaniaId != null)
				return false;
		} else if (!campaniaId.equals(other.campaniaId))
			return false;
		if (plantillaId == null) {
			if (other.plantillaId != null)
				return false;
		} else if (!plantillaId.equals(other.plantillaId))
			return false;
		if (receptorId == null) {
			if (other.receptorId != null)
				return false;
		} else if (!receptorId.equals(other.receptorId))
			return false;
		if (emisorId == null) {
			if (other.emisorId != null)
				return false;
		} else if (!emisorId.equals(other.emisorId))
			return false;
		return true;
	}
    
    
    
    
}
