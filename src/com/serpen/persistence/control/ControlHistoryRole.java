package com.serpen.persistence.control;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.serpen.error.connection.ErrorConnection;
import com.serpen.logic.entity.RoleHistory;
import com.serpen.persistence.conf.HibernateUtil;

import java.util.List;
/**
 * Universidad Pedagogica y Tecnologica de Colombia 
 * @author Eliana Ayala
 *         Daniela Blanco 
 *         Diana Gonzalez
 *         Edgar Meneses
 *  Clase  que contiene el control de historial role
 *
 */
public class ControlHistoryRole {

	/**
	 * Atributos de la clase control Historial Rol
	 */
	Session sesion;
	Transaction transaction;
	/**
	 * Constructor de la clase control Historial Rol
	 * @param sesion
	 * @param transaction
	 */
	public ControlHistoryRole(Session sesion, Transaction transaction) {
		this.sesion = sesion;
		this.transaction = transaction;
	}
	/**
	 * Metodo que se encarga de insertar un Historial
	 * @param rol
	 * @param nombre
	 */
	public void insert(int rol, String nombre){
		
	}

	/**
	 * Metodo que lista los historiales de role
	 * @return
	 * @throws ErrorConnection
	 */
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
	/**
	 * Metodo que se encarga de consultar un historial de usuario
	 * @param id
	 * @return
	 * @throws ErrorConnection
	 */
	public RoleHistory consult(int id)throws ErrorConnection{

		RoleHistory roleHistory=new RoleHistory();
		roleHistory = (RoleHistory) sesion.load(RoleHistory.class, 1);
		System.out.println(roleHistory);
		//	        sesion.close();

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
//	 		hrole.consult(1);
			sesion.close();
			

		} catch (ErrorConnection e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}