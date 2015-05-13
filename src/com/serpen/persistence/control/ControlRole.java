package com.serpen.persistence.control;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.serpen.error.connection.ErrorConnection;
import com.serpen.logic.entity.Role;
import com.serpen.logic.entity.RoleHistory;
import com.serpen.persistence.conf.HibernateUtil;
/**
 * Universidad Pedagogica y Tecnologica de Colombia 
 * @author Eliana Ayala
 *         Daniela Blanco 
 *         Diana Gonzalez
 *         Edgar Meneses
 *  Clase  que contiene el control Role
 *
 */
public class ControlRole {

	/**
	 * atributos de la clase control Role
	 */
	Session sesion;
	Transaction transaction;

	/**
	 * Constructor de la clase Role que pide por parametro
	 * @param sesion
	 * @param transaction
	 */
	public ControlRole(Session sesion, Transaction transaction) {
		this.sesion = sesion;
		this.transaction = transaction;
	}

	/**
	 * Metodo que se encarga de insertar un rol
	 * @param name
	 * @throws ErrorConnection
	 */
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

	/**
	 * Metodo que se encarga de listar de un rol
	 * @return lista
	 * @throws ErrorConnection
	 */
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

	/**
	 * Metodo que se encarga de consultar por  el id de un rol
	 * @param id
	 * @return
	 * @throws ErrorConnection
	 */
	public Role consult(int id) throws ErrorConnection{
		try{
			Role role = new Role();
			role = (Role) sesion.load(Role.class,id);
			System.out.println(role);
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

	/**
	 * Metodo que se encarga de consultar por el nombre de un rol 
	 * @param name
	 * @return rol
	 * @throws ErrorConnection
	 */
	public Role consultName(String name) throws ErrorConnection{
	     
		Criteria criteria = sesion.createCriteria(Role.class);
		criteria.add(Restrictions.like("name", name));
		return (Role) criteria.list().get(0);			
	}


	/**
	 * Metodo que se encarga de elminaar un Rol pidiendo por parametro un id
	 * @param id
	 * @throws ErrorConnection
	 */
	public void remove(int id) throws ErrorConnection{
		Transaction transaction = sesion.beginTransaction();
		Role role = consult(id);
		sesion.delete(role);
		transaction.commit();
	}

	/**
	 * Metodo que se encarga de actualizar un rol
	 * @param id
	 * @param nombre
	 * @throws ErrorConnection
	 */
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

			//rol.list();

			//        	rol.remove("Diana");
			//        	rol.list();
			//			rol.insert("Felipe");
			//        	rol.consult(2);
			rol.consultName("Andres");
			//rol.upDate(2, "NNNN");
			//sesion.close();


		} catch (ErrorConnection e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}