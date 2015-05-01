package com.serpen.persistence.control;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.serpen.persistence.conf.HibernateUtil;

public class ControlGeneral {

	private ControlRole controlRole;
	private ControlUser controlUser;
	private ControlHistoryRole controlHistoryRole;
	private ControlHistoryUser controlHistoryUser;



	public ControlGeneral(Session sesion, Transaction transaction) {

		this.controlRole = new ControlRole(sesion,transaction);
		this.controlUser = new ControlUser(sesion, transaction);
		this.controlHistoryRole = new ControlHistoryRole(sesion, transaction);
		this.controlHistoryUser = new ControlHistoryUser(sesion, transaction);
	}

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