
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

//

@Theme("Login")
public class SerpenpruebaUI extends UI implements ClickListener {

	public Button button;
	
	@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = SerpenpruebaUI.class)
	public static class Servlet extends VaadinServlet {
	}

	@Override
	protected void init(VaadinRequest request) {
		
		Session sesion = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = sesion.beginTransaction();
		ControlGeneral control = new ControlGeneral(sesion,transaction);
		
		Navigator navigator = new Navigator(this, this);
		navigator.addView(Login.NAMElOGUEO, new Login(navigator, control) );
		navigator.addView(Question.NAMEQUESTION, new Question(navigator, control));
		//navigator.addView(RestorePassword.NAME4, new RestorePassword(navigator,control));
		//navigator.addView(Administrator.NAME3, new Administrator(navigator));
		//navigator.addView(RestorePassword.NAME4, new RestorePassword(navigator));
//		navigator.addView(Login.NAME, new Login(navigator) );
//		navigator.addView(Question.NAME, new Question(navigator));
//		navigator.addView(Administrator.NAME3, new Administrator(navigator));
		
//		CreateUser createUser = new CreateUser();
//		layout.addComponent(createUser);
		
//		RestorePassword restorePassword = new RestorePassword();
//		layout.addComponent(restorePassword);
		
		//layout.addComponent(new Label("Prueba..."));
//		Logue logue = new Logue();
//		layout.addComponent(logue);

//		Login login = new Login();
//		layout.addComponent(login);
//	
//		Question question = new Question();
//		layout.addComponent(question);
//		
//		Administrator administrator= new Administrator();
//		layout.addComponent(administrator);
		
//		List list = new List();
//		layout.addComponent(list);
		
		
//		
		
		//setContent(new Logue());
	}

	@Override
	public void buttonClick(ClickEvent event) {
		// TODO Auto-generated method stub
		button.setCaption("clic");
		Navigator navigator = new Navigator(this, this);
		Navigator navigator2 = new Navigator(this, this);	
	}

}
