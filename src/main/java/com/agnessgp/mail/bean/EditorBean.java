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
public class EditorBean implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = -5996743458770496518L;

	@Getter
	@Setter
	private Emisor emisor;

	@Getter
	@Setter
	private List<SelectItem> listaItemsEmisorTodos;
	
	public void initListaItemsEditorTodos() {
		setListaItemsEmisorTodos(new ArrayList<>());
	}

}
