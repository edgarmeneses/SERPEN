package com.serpen.persistence.control;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.serpen.logic.entity.Role;
import com.serpen.logic.entity.UserHistory;
import com.serpen.persistence.conf.HibernateUtil;

public class ControlHistoryUser {
	
	private Session sesion; 

    
    public ControlHistoryUser(Session sesion) {
		// TODO Auto-generated constructor stub
    	this.sesion = sesion;
	}

	public void insert(int nikname, int role ){
		UserHistory userHistory = new UserHistory();
		userHistory.setNickname(nikname);
		userHistory.setEstado(userHistory.TIPO_ESTADO_INACTIVO);
		userHistory.setRol(role);
		
		sesion.save(userHistory);
		sesion.beginTransaction().commit();
		
	}

}
