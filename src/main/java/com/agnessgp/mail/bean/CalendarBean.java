package com.agnessgp.mail.bean;

import java.io.Serializable;
import java.util.Date;

import javax.enterprise.context.Dependent;

import org.primefaces.event.SelectEvent;

@Dependent
public class CalendarBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7887497446642166144L;

	public void dateChange(SelectEvent event) {
        System.out.println("doing well in office");
        Date date = (Date)event.getObject();}
}
