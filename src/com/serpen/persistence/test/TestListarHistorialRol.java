package com.serpen.persistence.test;

import java.util.List;

import org.hibernate.Session;

import com.serpen.logic.entity.Role;
import com.serpen.logic.entity.RoleHistory;
import com.serpen.persistence.conf.HibernateUtil;

public class TestListarHistorialRol {

	public static void main(String[] args) {
		Session sesion = HibernateUtil.getSessionFactory().openSession();
		List listaRol = sesion.createQuery(
				"from historial_rol " +
				"in class com.serpen.persistence.entity.RoleHistory").list();
		for (int i = 0; i<listaRol.size(); i++) {
			RoleHistory roleHistory =(RoleHistory) listaRol.get(i);
			System.out.println(roleHistory);
		}
	}
}
