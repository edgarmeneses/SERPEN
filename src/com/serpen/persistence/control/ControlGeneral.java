package com.serpen.persistence.control;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.serpen.persistence.conf.HibernateUtil;
/**
 * Universidad Pedagogica y Tecnologica de Colombia 
 * @author Eliana Ayala
 *         Daniela Blanco 
 *         Diana Gonzalez
 *         Edgar Meneses
 *Clase  que contiene los controles generales 
 *
 */
public class ControlGeneral {
	
	/**
	 * Atributos de la clase control General
	 */
	private ControlRole controlRole;
	private ControlUser controlUser;
	private ControlHistoryRole controlHistoryRole;
	private ControlHistoryUser controlHistoryUser;
	public ControlGeneral(Session sesion, Transaction transaction) {
		
		this.controlRole = new ControlRole(sesion);
		this.controlUser = new ControlUser(sesion, transaction);
		this.controlHistoryRole = new ControlHistoryRole(sesion, transaction);
		this.controlHistoryUser = new ControlHistoryUser(sesion, transaction);
	}
	
	/**
	 * getters and setters
	 * @return
	 */
	public ControlRole getRole() {
		return controlRole;
	}
	public void setRole(ControlRole controlRole) {
		this.controlRole = controlRole;
	}
	public ControlUser getUser() {
		return controlUser;
	}
	public void setUser(ControlUser controlUser) {
		this.controlUser = controlUser;
	}
	public ControlHistoryRole getHistoryRole() {
		return controlHistoryRole;
	}
	public void setHistoryRole(ControlHistoryRole controlHistoryRole) {
		this.controlHistoryRole = controlHistoryRole;
	}
	public ControlHistoryUser getHistoryUser() {
		return controlHistoryUser;
	}
	public void setHistoryUser(ControlHistoryUser controlHistoryUser) {
		this.controlHistoryUser = controlHistoryUser;
	}
}