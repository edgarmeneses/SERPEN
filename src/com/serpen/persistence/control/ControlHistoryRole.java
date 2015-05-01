package com.serpen.persistence.control;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.serpen.error.connection.ErrorConnection;
import com.serpen.logic.entity.RoleHistory;
import com.serpen.persistence.conf.HibernateUtil;

import java.util.List;

public class ControlHistoryRole {

	Session sesion;
	Transaction transaction;


	public ControlHistoryRole(Session sesion, Transaction transaction) {
		this.sesion = sesion;
		this.transaction = transaction;
	}

	public void insert(int rol, String nombre){

	}

	public List<RoleHistory> listHystory() throws ErrorConnection{

		List<RoleHistory> listRole = sesion.createQuery(
				"from historial_rol " +
				"in class com.serpen.persistence.entity.RoleHistory").list();
		for (int i = 0; i<listRole.size(); i++) {
			RoleHistory roleHistory =(RoleHistory) listRole.get(i);
			System.out.println(roleHistory);

		}
		if(!listRole.isEmpty()){
			return listRole;
		}else{
			throw new ErrorConnection("No hay ningun dato en la lista");
		}

	}
	public RoleHistory consult(int id)throws ErrorConnection{

		RoleHistory roleHistory=new RoleHistory();
		roleHistory = (RoleHistory) sesion.load(RoleHistory.class, 1);
		System.out.println(roleHistory);

		if(roleHistory != null){
			return roleHistory;
		}
		else{
			throw new ErrorConnection("no se encnto ningun rol");
		}
	}

	public static void main(String[] args) {

		Session sesion = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = sesion.beginTransaction();
		ControlHistoryRole hrole = new ControlHistoryRole(sesion, transaction);

		try {

			hrole.listHystory();
			sesion.close();


		} catch (ErrorConnection e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}