package com.serpen.persistence.control;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.serpen.error.connection.ErrorConnection;
import com.serpen.logic.entity.Role;
import com.serpen.logic.entity.User;
import com.serpen.persistence.conf.HibernateUtil;
import com.vaadin.ui.Notification;
/**
 * Clase que permite controlar las acciones de la clase Usuario.java
 * @author Edgar Meneses
 *
 */
public class ControlUser {
	/**
	 * sesion de la base de datos
	 */
	private Session session;
	/**
	 * permite realizar transacciones con la base de datos 
	 */
	private Transaction transaction;
	
	private final String [][] SELECT_LIST ={{"lista","rol"},{"nickname","union"}};

	/**
	 * Constructor de la clase ControlUser.java
	 * @param session sesion
	 * @param transaction transaccion
	 */
	public ControlUser(Session session, Transaction transaction) {
		this.session = session;
		this.transaction = transaction;
	}
	/**
	 * metodo que permite insertar un usuario en la tabla Usuario de la base de datos
	 * @param nickname nombre de ingreso
	 * @param pasword contraseña
	 * @param answer respuesta de seguridad
	 * @param role rol
	 * @throws ErrorConnection 
	 */
	public void insert (int nickname, String pasword, String answer, Role role)
			throws ErrorConnection{
		try{
			User user = new User();
			user.setNickname(nickname);
			user.setPassword(pasword);
			user.setEstado(User.TIPO_ESTADO_ACTIVO);
			user.setRol(role);
			user.setAnswer(answer);

			session.save(user);
			transaction.commit();

		}catch(Exception e){
			throw new ErrorConnection("no se pudo insertar el dato"
					+ " Casua: "+e.getCause());
		}
	}
	/**
	 * metodo que pemite consultar todos los uaurios iinsertados en la tabla Usuario
	 * @return usuarios
	 * @throws ErrorConnection
	 */
	public List<User> list() throws ErrorConnection{
		try{
			List<User> listaUsuario = session.createQuery(
					"from usuario " +
					"in class com.serpen.logic.entity.User order by nickname").list();
			for (int i = 0; i<listaUsuario.size(); i++) {
				User user = listaUsuario.get(i);
			}
			if(!listaUsuario.isEmpty()){
				return listaUsuario;
			}else{
				throw new ErrorConnection("no hay datos en la entidad usuario");
			}
		}catch(Exception e){
			throw new ErrorConnection("No se pudo realizar la coneccion"
					+ " Causa: "+ e.getCause());
		} 
	}
	/**
	 * TIENE ERRORES
	 * metodo para consultar todos los uaurios que tienen un rol especifico  
	 * @param rol
	 * @return usuarios
	 * @throws ErrorConnection
	 */
	public List<User> list(int rol) throws ErrorConnection{
		try{
			String sql = "from com.serpen.logic.entity.User u " +
					"WHERE u.rol.id = "+ rol;

			List<User> listaUsuario = session.createQuery(sql).list();

			return listaUsuario;
		}catch(Exception e){
			throw new ErrorConnection("No se pudo realizar la consulta"
					+ " Causa: "+e.getCause());
		}
	}
	
	/**
	 * metodo que permite listar los usuarios decuerdo a una palabra clave que 
	 * representa el nickname
	 * se haceun filtrado por nikname
	 * @param nickname
	 * @return
	 */
	public List<User> list(String nickname){
		String sql="from com.serpen.logic.entity.User where nickname like '%"+nickname+"%'";
		List<User> users = session.createQuery(sql).list();
		//Criteria criteria = session.createCriteria(User.class);c
		//criteria.add(Restrictions.like("answer", "%D%"));
		//List<User> users =  session.createQuery(sql).list();
		return users;

	}
	/**
	 * metodo para consultar un usuario segun su nickname
	 * @param nickname nickname
	 * @return usuario
	 * @throws ErrorConnection
	 */
	public User consult(int nickname) throws ErrorConnection{
		try{
			User user = (User) session.load(User.class, nickname);

			if(user != null){
				return user;
			}
			else{
				throw new ErrorConnection("No hay datos para el usuario"
						+ " " +user.getNickname());
			}
		}
		catch(Exception e){
			throw new ErrorConnection("No se pudo realizar la conecion");
		}
	}
	
	public List<User> list(String nickname, String rol){

		String sql="from com.serpen.logic.entity.User u WHERE u.nickname like '%"+nickname+"%'"
				+" AND u.rol.name = '"+ rol+"'";
		List<User> users = session.createQuery(sql).list();
		//Criteria criteria = session.createCriteria(User.class);c
		//criteria.add(Restrictions.like("answer", "%D%"));
		//List<User> users =  session.createQuery(sql).list();
		return users;
	}
	
	public List<User> list(int estdoNickname, int estadoRol, String nickname, String rol,ControlRole role) throws ErrorConnection{
		try{
			switch (SELECT_LIST[estdoNickname][estadoRol]) {
			case "lista":
				return list();
			case "rol":
				return list(role.consultName(rol).getId());
			case "nickname":
				return list(nickname);
			case "union":
				return list(nickname, rol);
				
			default:
				return null;
			}
		}catch(Exception e){
			throw new ErrorConnection("No se pudo realizar la consulta"
					+ " Causa: "+e.getCause());
		}
	}
	
	/**
	 * metodo para elimina un usuario
	 * @param nickname nickname
	 * @throws ErrorConnection
	 */
	public void remove(int nickname) throws ErrorConnection{
		try{
			User user = consult(nickname);
			
			ControlHistoryUser controlHistoryUser = new ControlHistoryUser(session, transaction);
			controlHistoryUser.insert(user.getNickname(), user.getRol().getId());
			
			session.delete(user);
			transaction.commit();
		}catch(Exception e){
			throw new ErrorConnection("no se pudo eliminar el usuario "
					+ "Causa: "+ e.getCause());
		}
	}

	public void remover() throws ErrorConnection{
		List<User> list = list();
		for (User user : list) {
			remove(user.getNickname());
			transaction.commit();
		}

	}

	public void removeRol(int rol, ControlHistoryUser controlHistoryUser) throws ErrorConnection{
		try{
			List<User> listaUsuario = session.createQuery(
					"from usuario " +
							"in class com.serpen.logic.entity.User "
							+ "where com.serpen.logic.User.rol.id= " +rol).list();
			for (int i = 0; i<listaUsuario.size(); i++) {
				User user = listaUsuario.get(i);
				remove(user.getNickname());
			}

		}catch(Exception e){
			throw new ErrorConnection("No se pudo realizar la coneccion"
					+ " Causa: "+ e.getCause());
		} 
	}

	public void upDate(int nickname, String password, String answer) throws ErrorConnection{

		try{
			User user = consult(nickname);

			user.setPassword(password);  
			user.setAnswer(answer);

			session.update(user);

			transaction.commit();
			session.close();
		}catch(Exception e){
			throw new ErrorConnection("no se pudo editar el Usuario "
					+ "Causa: "+ e.getCause());
		}
	}
public static void main(String[] args) {
	
	try {
		Session sesion = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = sesion.beginTransaction();
		
		ControlUser controlUser = new ControlUser(sesion, transaction);
		controlUser.remove(2900989);
		
	} catch (ErrorConnection e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
	
	
}

}
