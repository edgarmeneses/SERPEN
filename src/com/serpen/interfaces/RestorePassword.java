package com.serpen.interfaces;


import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Button.ClickEvent;

public class RestorePassword extends CustomComponent implements View {
	
	private Label lblLogo;
	private Label lblNewPassword;
	private Label lblConfirm;
	private PasswordField txtNewPassword;
	private PasswordField txtConfirm;
	private Button btnConfirm;
	private Panel pnlMain;
	private Button btnCancel;
	private Image  imgSecurity;
	private Image imgPasword;
	public static final String NAMERESTORE="Pregunta";
	public Navigator navigator;
	
	public RestorePassword(Navigator navigator){
		
		this.navigator=navigator;
		
		FormLayout layoutPrincipal = new FormLayout();

		
		FormLayout layoutPanel = new FormLayout();
		
		
		HorizontalLayout layoutNewPassword = new HorizontalLayout();
		
		HorizontalLayout layoutConPassword= new HorizontalLayout();
		
		HorizontalLayout layoutBtn = new HorizontalLayout();

		
		pnlMain = new Panel();
		pnlMain.setSizeFull();
		pnlMain.setWidth("500px");
		pnlMain.setHeight("300px");

		
		lblLogo = new Label("LOGO");
		lblNewPassword = new Label("Falta imagen");
		
		txtNewPassword = new PasswordField("Nueva Contraseña");
		lblConfirm = new Label("Falta imagen");
		txtConfirm = new PasswordField("Confirmar Constraseña");
		
		btnConfirm = new Button("Confirmar");
		btnConfirm.addClickListener(new Button.ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				// TODO Auto-generated method stub
				if(txtNewPassword.getValue().equals(txtConfirm.getValue())){
					System.out.println("Agrega la contraseña ");
					Notification.show("Contraseña Cambiada Satisfactoriamente");
					
					navigator.addView(Login.NAMELOGUEO, new Login(navigator) );
					navigator.navigateTo(Login.NAMELOGUEO);
				}else{
					txtNewPassword.setValue("");
					txtConfirm.setValue("");
					Notification.show("Las contraseñas no coinciden");
				}
			}
		});
		
		btnCancel = new Button("Cancelar");
		btnCancel.addClickListener(new Button.ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				// TODO Auto-generated method stub
				navigator.addView(Login.NAMELOGUEO, new Login(navigator) );
				navigator.navigateTo(Login.NAMELOGUEO);
			}
		});
		
		this.imgPasword = new Image("password");
		ThemeResource resource1 = new ThemeResource("../Imagen/passwords.jpg");
		imgPasword =new Image (null, resource1);
		this.imgPasword.setVisible(true);
		
		this.imgSecurity = new Image("Segurity");
		ThemeResource resource = new ThemeResource("../Imagen/constrase_a_converted.png");
		imgSecurity =new Image (null, resource);
		this.imgSecurity.setVisible(true);
		
		
	
		layoutNewPassword.addComponent(imgPasword);
		layoutNewPassword.addComponent(txtNewPassword);
		layoutConPassword.addComponent(imgSecurity);
		layoutConPassword.addComponent(txtConfirm);
		
		layoutBtn.addComponent(btnConfirm);
		layoutBtn.addComponent(btnCancel);	
		this.pnlMain.setContent(layoutPanel);
		
		layoutPanel.addComponent(layoutNewPassword);
		layoutPanel.addComponent(layoutConPassword);
		layoutPanel.addComponent(layoutBtn);
		layoutPrincipal.addComponent(pnlMain);
        setCompositionRoot(layoutPrincipal);
		setSizeFull();
		
	}

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}

}
