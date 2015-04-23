package com.serpen.persistence.test;

import org.hibernate.Session;

import com.serpen.logic.entity.Role;
import com.serpen.logic.entity.RoleHistory;
import com.serpen.persistence.conf.HibernateUtil;

public class TestConsultarHistorialRol {
	
	
	public static void main(String[] args) {
		    Session sesion = HibernateUtil.getSessionFactory().openSession();
	        RoleHistory roleHistory = (RoleHistory) sesion.load(RoleHistory.class, 1);
	        System.out.println(roleHistory);
	        sesion.close();
	}

}
