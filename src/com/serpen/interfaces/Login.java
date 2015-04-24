package com.serpen.interfaces;

import org.apache.tika.parser.txt.TXTParser;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.serpen.error.connection.ErrorConnection;
import com.serpen.logic.entity.User;
import com.serpen.persistence.control.ControlGeneral;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.ExternalResource;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Link;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;

public class Login extends CustomComponent implements View{

	public static final String NAMElOGUEO="";
	private Image icon;
	private Image imgUserName;
	private Image imgPasword;
	private TextField txfUserName;
	private PasswordField txfPasword;
	private Link lblQuestion;
	private Button btnLogin;
	private Panel pnlLogin;
	private Navigator navigator;
	private ControlGeneral control;

	public Login(Navigator navigator, ControlGeneral control){

		this.navigator=navigator;
		this.control = control;

		FormLayout layoutPrincipal= new FormLayout();
		layoutPrincipal.setSizeFull();
		layoutPrincipal.beforeClientResponse(false);
		layoutPrincipal.setVisible(true);
		layoutPrincipal.setStyleName("v-SIDEBAR");

		FormLayout layoutPanel = new FormLayout();
		//		layoutPanel.setWidth("400px");
		//		layoutPanel.setHeight("500px");
		layoutPanel.setVisible(true);

		HorizontalLayout layoutUser = new HorizontalLayout();

		ThemeResource resource = new ThemeResource("../Imagen/user.png");
		imgUserName =new Image(null, resource);
		this.imgUserName.setWidth("50px");
		this.imgUserName.setHeight("50px");
		this.imgUserName.setVisible(true);

		imgUserName.setSizeUndefined(); // Actually the default
		this.txfUserName = new TextField("Usuario");


		HorizontalLayout layoutPassword =  new HorizontalLayout();


		this.imgPasword = new Image("falta imagen");
		ThemeResource resource2 = new ThemeResource("../Imagen/constrase_a_converted.png");
		imgPasword =new Image (null, resource2);
		this.imgPasword.setWidth("50px");
		this.imgPasword.setHeight("50px");
		this.imgPasword.setVisible(true);

		this.txfPasword = new PasswordField("Constraseña:");
		this.txfPasword.setRequired(true);
		this.txfPasword.setValue("");
		this.txfPasword.setNullRepresentation("");

		HorizontalLayout layoutEvent = new HorizontalLayout();


		this.btnLogin = new Button("Ingresar");
		btnLogin.addClickListener(new Button.ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				// TODO Auto-generated method stub

				try {
					User user = control.getUser().consult(Integer.valueOf(txfUserName.getValue()));
					System.out.println(user);

					if(validateUser(user)){
						navigate(user);
					}
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					Notification.show("No se puede ingresar letras en el campo  ");
				} catch (ErrorConnection e) {
					// TODO Auto-generated catch block
					Notification.show(e.getMessage()+
							" Causa: " + e.getCause());
				} catch(ObjectNotFoundException ob){
					Notification.show("Usuario o Contraseña Invalido");
				} 

			}
		});
		//btnLogin.addClickListener(this);
		//this.btnLogin.addStyleName("v-button-style");	
		//this.btnLogin.addStyleName("v-ie8");	

		this.lblQuestion = new Link("¿olvido su contraseña?",new ExternalResource("#!"+Question.NAMEQUESTION));


		pnlLogin = new Panel();
		pnlLogin.setSizeFull();
		pnlLogin.setWidth("400px");
		pnlLogin.setHeight("500px");

		layoutUser.addComponent(imgUserName);
		layoutUser.addComponent(txfUserName);

		layoutPassword.addComponent(imgPasword);
		layoutPassword.addComponent(txfPasword);

		layoutEvent.addComponent(btnLogin);
		layoutEvent.addComponent(lblQuestion);

		layoutPanel.addComponent(layoutUser);
		layoutPanel.addComponent(layoutPassword);
		layoutPanel.addComponent(layoutEvent);


		layoutPrincipal.addComponent(pnlLogin);
		this.pnlLogin.setContent(layoutPanel);
		this.setCompositionRoot(layoutPrincipal);
		setSizeFull();

	}

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub

	}
	/**
	 * metodo que permite crear la navegacion hacia la pagina del rol que tiene el usuari
	 * es decir permite cargar la ventana princopal para el administrador o para un usuario
	 * @param user
	 */
	private void navigate(User user){
		switch (user.getRol().getName()) {
		case "Administrador":
			navigator.addView(Administrator.NAMEADMINISTRATOR, new Administrator(navigator,user,control));
			navigator.navigateTo(Administrator.NAMEADMINISTRATOR);
			break;
		case "Usuario":
			Notification.show("Modulo en construccion ");
			break;
		default:
			Notification.show("Rol inválido contacte a su administro ");
			break;
		}

	}
	/**
	 * metdo que evalua si la contraseña del usuario conicide con la ingresada 
	 * en el campo de texto 
	 * @param user
	 * @return
	 */
	private boolean validateUser(User user){
		return user.getPassword().equals(txfPasword.getValue());
	}

}
