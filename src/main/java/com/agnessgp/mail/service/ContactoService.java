package com.agnessgp.mail.service;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.agnessgp.mail.dao.ContactoDAO;
import com.agnessgp.mail.modelo.Contacto;

@Stateless
public class ContactoService implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6685335765320816676L;
	
	@EJB
	ContactoDAO contactoDAO;
	
	public List<Contacto> listarContactos() throws ServiceException {
		return contactoDAO.obtenerTodos();
	}
	
	public Contacto crearNuevoContacto(Contacto contacto) throws ServiceException {
		if(contactoDAO.obtenerPorCorreo(contacto.getCorreoElectronico())==null) {
			contactoDAO.crear(contacto);
			return contacto;
		}else {
			throw new ServiceException("El contacto no se puede crear por que existe un correo silimiar.");
		}
	}
}
