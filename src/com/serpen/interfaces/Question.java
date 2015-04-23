package com.serpen.interfaces;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextField;

public class Question extends  CustomComponent implements ClickListener,View {

	public static final String NAMEQUESTION ="¿olvido su contraseña?";
	//public static final String NAME3 ="Pregunta";
	private Label lblDescription;
	private Label lblDescription2;
	private Image UserName;
	private TextField txtUsername;
	private Image question;
	private TextField txtQuestion;
	private Button btnAccept;
	private Button btnCancel;
	private Panel panel;
	private Navigator navigator;

	public Question(Navigator navigator){

		this.navigator=navigator;
		FormLayout layoutPrincipal = new FormLayout();
		layoutPrincipal.setSizeFull();
		layoutPrincipal.beforeClientResponse(false);
		layoutPrincipal.setVisible(true);

		FormLayout layoutPanel = new FormLayout();
		//		layoutPanel.setWidth("500px");
		//		layoutPanel.setHeight("500px");
		layoutPanel.setVisible(true);


		HorizontalLayout layoutDescription1 = new HorizontalLayout();

		lblDescription = new Label("Para poder recuperar su constraseña por favor ingrese");

		HorizontalLayout layoutDescription2 = new HorizontalLayout();

		lblDescription2 = new Label(" la respuesta de la siguiente pregunta");

		HorizontalLayout layoutUser = new HorizontalLayout();

		ThemeResource resource = new ThemeResource("../Imagen/user.png");
		UserName = new Image(null, resource);
		this.UserName.setVisible(true);
		txtUsername = new TextField("Usuario:");

		HorizontalLayout layoutTeacher = new HorizontalLayout();

		ThemeResource resource2 = new ThemeResource("../Imagen/profesor.jpg");
		question = new Image(null, resource2);
		this.question.setVisible(true);
		txtQuestion = new TextField("Nombre de su profesor favorito?");

		HorizontalLayout layoutEvent = new HorizontalLayout();
		btnAccept = new Button("Aceptar");
		btnAccept.addClickListener(new Button.ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				// TODO Auto-generated method stub
				if(txtUsername.getValue().equals("Diana")){
					if(txtQuestion.getValue().equals("Sara")){
						navigator.addView(RestorePassword.NAMERESTORE, new RestorePassword(navigator));
						navigator.navigateTo(RestorePassword.NAMERESTORE);
					}
				}else{
					Notification.show("Usauario o pregunta erronea");
				}
			}
		});

		btnCancel = new Button("Cancelar");
		btnCancel.addClickListener(new Button.ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				navigator.addView(Login.NAMELOGUEO, new Login(navigator) );
				navigator.navigateTo(Login.NAMELOGUEO);
			}
		});

		panel = new Panel();
		panel.setSizeFull();
		panel.setWidth("500px");
		panel.setHeight("500px");

		layoutDescription1.addComponent(lblDescription);
		layoutDescription2.addComponent(lblDescription2);

		layoutUser.addComponent(UserName);
		layoutUser.addComponent(txtUsername);

		layoutTeacher.addComponent(question);
		layoutTeacher.addComponent(txtQuestion);

		layoutEvent.addComponent(btnAccept);
		layoutEvent.addComponent(btnCancel);

		layoutPanel.addComponent(layoutDescription1);
		layoutPanel.addComponent(layoutDescription2);	
		layoutPanel.addComponent(layoutUser);
		layoutPanel.addComponent(layoutTeacher);
		layoutPanel.addComponent(layoutEvent);

		layoutPrincipal.addComponent(panel);
		this.panel.setContent(layoutPanel);
		this.setCompositionRoot(layoutPrincipal);
		setSizeFull();	
	}

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void buttonClick(ClickEvent event) {
		// TODO Auto-generated method stub

	}	
}
