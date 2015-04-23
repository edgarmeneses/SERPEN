package com.serpen.interfaces;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.ExternalResource;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.Link;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Button.ClickListener;

public class Login extends CustomComponent implements View{
	
	public static final String NAME="";
	private Image icon;
	private Image imgUserName;
	private Image imgPasword;
	private TextField txfUserName;
	private PasswordField txfPasword;
	private Link lblQuestion;
	private Button btnLogin;
	private Panel pnlLogin;
	private Navigator navigator;
	
	public Login(Navigator navigator){
		
		this.navigator=navigator;
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
				
				if(txfUserName.getValue().equals("Diana")){
					if(txfPasword.getValue().equals("123")){
						navigator.addView(Administrator.NAME3, new Administrator(navigator));
						navigator.navigateTo(Administrator.NAME3);
//						navigator.addView(CreateUser.NAME5, new CreateUser(navigator));
//						navigator.navigateTo(CreateUser.NAME5);


					}
				}else{
					Notification.show("Usuario o cotraseña no registrado");
				}
			}
		});
		//btnLogin.addClickListener(this);
		//this.btnLogin.addStyleName("v-button-style");	
		//this.btnLogin.addStyleName("v-ie8");	
	
		this.lblQuestion = new Link("¿olvido su contraseña?",new ExternalResource("#!"+Question.NAME2));

		
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

//	@Override
//	public void buttonClick(ClickEvent event) {
//		// TODO Auto-generated method stub
//		if (event.getComponent().equals(lblQuestion)){
//			
//			Question q = new Question(navigator);
//			navigator.addView(Question.NAME2, Question.class);
//			
//			AbsoluteLayout layout= new AbsoluteLayout();
//			layout.addComponent(q);
//			
//			setCompositionRoot(layout);
//			setSizeFull();
//		}
//	}

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}

}
