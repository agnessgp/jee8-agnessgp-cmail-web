package com.agnessgp.mail.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.Stateless;

import com.agnessgp.mail.dto.Componente;

@Stateless
public class ComponenteService implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6840031357212527709L;

	public Componente buscarPorId(List<Componente> listaComponentes, String id) {
		List<Componente> resultado = listaComponentes.stream().filter(c -> c.getId().equals(id))
				.collect(Collectors.toList());
		if (!resultado.isEmpty()) {
			return resultado.get(0);
		}
		return null;
	}

	public List<Componente> activarPorId(List<Componente> listaComponentes, String id) {
		Componente componenteAux = buscarPorId(listaComponentes, id);
		if (componenteAux != null && componenteAux.getVisible().equals(Boolean.FALSE)) {
			listaComponentes.remove(componenteAux);
			componenteAux.setVisible(Boolean.TRUE);
			listaComponentes.add(componenteAux);
		}
		return listaComponentes;
	}
	
	public List<Componente> inactivarPorId(List<Componente> listaComponentes, String id) {
		Componente componenteAux = buscarPorId(listaComponentes, id);
		if (componenteAux != null && componenteAux.getVisible().equals(Boolean.TRUE)) {
			listaComponentes.remove(componenteAux);
			componenteAux.setVisible(Boolean.FALSE);
			listaComponentes.add(componenteAux);
		}
		return listaComponentes;
	}

	public List<Componente> crear(List<Componente> listaComponentes, Componente componente) {
		if (listaComponentes == null) {
			listaComponentes = new ArrayList<>();
		}
		if (buscarPorId(listaComponentes, componente.getId()) == null) {
			listaComponentes.add(componente);
		}
		return listaComponentes;
	}
}
