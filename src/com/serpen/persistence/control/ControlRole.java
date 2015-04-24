package com.serpen.persistence.control;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.serpen.error.connection.ErrorConnection;
import com.serpen.logic.entity.Role;
import com.serpen.logic.entity.RoleHistory;
import com.serpen.persistence.conf.HibernateUtil;

public class ControlRole {

	Session sesion;
	Transaction transaction;

	public ControlRole(Session sesion, Transaction transaction) {
		this.sesion = sesion;
		this.transaction = transaction;
	}

	public void insert(String name) throws ErrorConnection{

		try{
			//Transaction transaction = sesion.beginTransaction();
			Role role = new Role();
			role.setName(name);
			sesion.save(role);      
			transaction.commit();
		}catch(Exception e){

			throw new ErrorConnection("No se pudo insertar el rol " + "Causa: "+e.getCause());
		}

	}

	public List<Role> list() throws ErrorConnection{

		try{
			List<Role> listRole = sesion.createQuery(
					"from rol " +
							"in class com.serpen.logic.entity.Role "
							+ "order by id").list();
			for (int i = 0; i<listRole.size(); i++) {
				Role role = listRole.get(i);
			}

			if(!listRole.isEmpty()){
				return listRole;
			}else{
				throw new ErrorConnection("No hay ningun dato en la entidad rol");
			}
		}catch(Exception e){
			throw new ErrorConnection("no se pudo realizar la conexion "
					+ " Causa: " + e.getCause());

		}
	}

	public Role consult(int id) throws ErrorConnection{
		try{
			Role role = new Role();
			role = (Role) sesion.load(Role.class,id);
			return role;
			//		sesion.close();
//			if(role != null){
//				return role;
//			}
//			else{
//				throw new ErrorConnection("no se encnto ningun rol");
//			}
		}catch(Exception e){
			throw new ErrorConnection("no se pudo conectar al rol"
					+ " Causa: "+e.getCause());
		}
	}

	public Role consultName(String name) throws ErrorConnection{
		try{
			Role role = new Role();
			role = (Role) sesion.load(Role.class,name);
			System.out.println(role);
			//		sesion.close();
			if(role != null){
				return role;
			}
			else{
				throw new ErrorConnection("no se encnto ningun rol");
			}
		}catch(Exception e){
			throw new ErrorConnection("no se pudo realizar la conexion "
					+ "Causa: " + e.getCause());

		}
	}


	public void remove(int id, ControlHistoryRole controlHistoryRole,
			ControlUser controlUser, ControlHistoryUser controlHistoryUser) throws ErrorConnection{
		Transaction transaction = sesion.beginTransaction();

		//		//----------- Falta (o"o) ---------------------
		//		Role role= new Role();
		//		//        role.setId(id);
		//		role.setName(name);

		Role role = consult(id);
		//		RoleHistory roleHistory = new RoleHistory();
		//		roleHistory.setName(role.getName());
		//		roleHistory.setRole(role.getId());

		controlHistoryRole.insert(role.getId(), role.getName());

		controlUser.removeRol(role.getId(), controlHistoryUser);

		sesion.delete(role);
		transaction.commit();
		//		sesion.delete(role);
		//		sesion.save(roleHistory);
		//		transaction.commit();
		//		//sesion.close();	
		//		throw new ErrorConnection("No se encuentra el rol que se desea eliminar");
	}

	public void upDate(int id,String nombre)throws ErrorConnection{

		try{
			Transaction transaction = sesion.beginTransaction();
			Role role = new Role();
			role.setId(id);
			role.setName(nombre);  
			sesion.update(role);
			transaction.commit();
			//		sesion.close();
		}catch(Exception e){

			throw new ErrorConnection("El rol ingresado no se encuentra"+"Causa: "+e.getCause());
		}
	}

	public static void main(String[] args) {

		Session sesion = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = sesion.beginTransaction();
		ControlRole rol = new ControlRole(sesion,transaction);

		try {

			rol.list();

			//        	rol.remove("Diana");
			//        	rol.list();
			//			rol.insert("Felipe");
			//        	rol.consult(2);
			//        	rol.consultName("Diana");------> malll 
			//rol.upDate(2, "NNNN");
			//sesion.close();


		} catch (ErrorConnection e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
}