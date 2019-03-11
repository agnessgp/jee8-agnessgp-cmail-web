/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.agnessgp.mail.service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.LinkedList;
import java.util.List;

import javax.ejb.Stateless;

import com.agnessgp.mail.dto.ContactosCarga;

/**
 * Descripción de la Clase
 * @Autor: Patricio Pilco	
 * @Fecha: 24/02/2019	
 */
@Stateless
public class ContactoCargaService {

    public List<ContactosCarga> cargarContactosArchivo() {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        List<ContactosCarga> listaContactosCarga = new LinkedList<>();
        InputStream input = classLoader.getResourceAsStream("contactos.csv");
        InputStreamReader reader = new InputStreamReader(input, Charset.forName("utf-8"));
        BufferedReader bReader = new BufferedReader(reader);
        bReader.lines().forEach(line -> {
            String[] fields = line.split("\\|");
            ContactosCarga contactosCarga = new ContactosCarga();
            contactosCarga.setNombres(fields[0]);
            contactosCarga.setApellidos(fields[1]);
            contactosCarga.setCorreoElectronico(fields[2]);
            listaContactosCarga.add(contactosCarga);
        });
        return listaContactosCarga;
    }
   
}
	