package com.agnessgp.mail.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.Dependent;
import javax.faces.model.SelectItem;

import com.agnessgp.mail.modelo.Emisor;

import lombok.Getter;
import lombok.Setter;

@Dependent
public class EmisorBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 640088986925093020L;

	@Getter
	@Setter
	private Emisor emisor;

	@Getter
	@Setter
	private List<SelectItem> listaItemsEmisorTodos;
	
	public void initListaItemsEmisorTodos() {
		setListaItemsEmisorTodos(new ArrayList<>());
	}

}
