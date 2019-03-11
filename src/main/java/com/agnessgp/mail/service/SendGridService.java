/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agnessgp.mail.service;

import java.io.IOException;
import java.io.Serializable;

import javax.ejb.Stateless;

import com.agnessgp.mail.dto.DatosMail;
import com.sendgrid.Content;
import com.sendgrid.Email;
import com.sendgrid.Mail;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;

/**
 * Descripción de la Clase
 *
 * @Autor: Patricio Pilco
 * @Fecha: 24/02/2019
 */
@Stateless
public class SendGridService implements Serializable {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = -3752695988264177780L;

	public int enviarCorreoElectronico(DatosMail datosMail) throws ServiceException {
        Email from = new Email(datosMail.getFrom());
        String subject = datosMail.getSubject();
        Email to = new Email(datosMail.getTo());
        Content content = new Content("text/plain", datosMail.getContent());
        Mail mail = new Mail(from, subject, to, content);
        
        SendGrid sg = new SendGrid("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");
        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sg.api(request);
            System.out.println(response.getStatusCode());
            System.out.println(response.getBody());
            System.out.println(response.getHeaders());
            return response.getStatusCode();
        } catch (IOException ex) {
            throw new ServiceException("Error en el momento de enviar el correo electrónico.");
        }
    }
    
    public void enviarCorreoCampania(){
    }
}
