package com.serpen.persistence.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.serpen.error.connection.ErrorConnection;
import com.serpen.logic.entity.Role;
import com.serpen.logic.entity.User;
import com.serpen.persistence.conf.HibernateUtil;
import com.serpen.persistence.control.ControlGeneral;

public class TestControlGeneral {

	public static void main(String[] args) {
		Session sesion = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = sesion.beginTransaction();

		ControlGeneral general = new ControlGeneral(sesion, transaction);
		try {
			//general.getUser().insert(11111, "1111", "Ninguna", general.getRole().consult(7));
			//-----general.getUser().listByRol(general.getRole().consult(3));
			//System.out.println(general.getUser().consult(104434));
			//general.getRole().insert(name);
			List<Role> list = general.getRole().list();
			
			for (Role rol : list) {
				System.out.println(rol);
			}
			
			List<User> users = general.getUser().list();
			
			for (User user : users) {
				System.out.println(user);
			}
			
			sesion.close();
		} catch (ErrorConnection e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
