package com.agnessgp.mail.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.Dependent;

import com.agnessgp.mail.dto.Componente;
import com.agnessgp.mail.modelo.Campania;
import com.agnessgp.mail.modelo.Emisor;

import lombok.Getter;
import lombok.Setter;

@Dependent
public class CampaniaBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3267716089377797191L;

	@Setter
	@Getter
	private List<Componente> listaComponentes;

	@Setter
	@Getter
	private Campania campania;

	@Getter
	@Setter
	private List<Campania> listaCampaniasTodos;
	
	@Setter
	@Getter
	private Emisor emisorCampania;
	
	@Setter
	@Getter
	private Boolean emisorSeleccionarPnl;

	
	public void initNuevaCapania() {
		setCampania(new Campania());
	}
	
	public void initListaCampaniasTodos() {
		setListaCampaniasTodos(new ArrayList<>());
	}
	
	public void initListaComponentes() {
		setListaComponentes(new ArrayList<>());
	}
}
