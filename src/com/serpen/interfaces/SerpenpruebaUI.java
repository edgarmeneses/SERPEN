
package com.serpen.interfaces;

import javax.servlet.annotation.WebServlet;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.serpen.persistence.conf.HibernateUtil;
import com.serpen.persistence.control.ControlGeneral;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.UI;
/**
 * Universidad Pedagogica y Tecnologica de Colombia 
 * @author Eliana Ayala
 *         Daniela Blanco 
 *         Diana Gonzalez
 *         Edgar Meneses
 *Clase  principal de un proyecto de vaadin interfaz en la que se llamana las ventanas 
 *
 */

@Theme("Login")
public class SerpenpruebaUI extends UI{

	public Button button;

	@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = SerpenpruebaUI.class)
	public static class Servlet extends VaadinServlet {
	}

	@Override
	protected void init(VaadinRequest request) {
		/**creacin de la sesion de hibernate para conectar los mapeos con la base da datos**/
		Session sesion = HibernateUtil.getSessionFactory().openSession();
		/**se utiliza cuando la consulta necesita una trasnaccion es decir para
		 * consultas tipo insert, update, delete
		 **/
		Transaction transaction = sesion.beginTransaction();
		/**
		 * clase control general que permite manejar los metodos de insert, delete, update,
		 * select... de cada tabla
		 **/
		ControlGeneral control = new ControlGeneral(sesion,transaction);

		/**
		 * navegator se utiliza para crear las navegaciones entre las paginas
		 **/
		Navigator navigator = new Navigator(this, this);
		/**
		 * se esta creando la pagina logue y se esta agregando como navegacion
		 * 
		 * para la clase question se hace la creacion de la ventana y se agrega su navegacion
		 * al inicar dado que es un link
		 **/
		navigator.addView(Login.NAMElOGUEO, new Login(navigator, control) );
		navigator.addView(Question.NAMEQUESTION, new Question(navigator, control));

	}
}
