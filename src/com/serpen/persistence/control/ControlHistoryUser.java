package com.serpen.persistence.control;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.serpen.logic.entity.Role;
import com.serpen.logic.entity.UserHistory;
import com.serpen.persistence.conf.HibernateUtil;
/**
 * Universidad Pedagogica y Tecnologica de Colombia 
 * @author Eliana Ayala
 *         Daniela Blanco 
 *         Diana Gonzalez
 *         Edgar Meneses
 *  Clase  que contiene el control de historial user 
 *
 */
public class ControlHistoryUser {
	
	/**
	 * Atributos de la clase control Historial user
	 */
	private Session sesion; 
   
    /**
	 * Constructor de la clase control Historial Rol
	 * @param sesion
	 * @param transaction
	 */
    public ControlHistoryUser(Session sesion) {
		// TODO Auto-generated constructor stub
    	this.sesion = sesion;
    	
	}

    /**
     * Metodo que se encaarga de insertar un historial de Usuario
     * @param nikname
     * @param role
     */
	public void insert(int nikname, int role ){
		UserHistory userHistory = new UserHistory();
		userHistory.setNickname(nikname);
		userHistory.setEstado(userHistory.TIPO_ESTADO_INACTIVO);
		userHistory.setRol(role);
		
		sesion.save(userHistory);
		sesion.beginTransaction().commit();
		
	}

}
