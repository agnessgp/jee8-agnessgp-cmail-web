package com.agnessgp.mail.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.Dependent;
import javax.faces.model.SelectItem;

import com.agnessgp.mail.modelo.Plantilla;

import lombok.Getter;
import lombok.Setter;

@Dependent
public class PlantillaBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 640088986925093020L;

	@Getter
	@Setter
	private Plantilla plantilla;

	@Getter
	@Setter
	private List<SelectItem> listaItemsPlanillaTodos;
	
	public void initListaItemsPlanillaTodos() {
		setListaItemsPlanillaTodos(new ArrayList<>());
	}

}
