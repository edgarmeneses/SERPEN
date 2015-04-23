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
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextField;

public class RestorePassword extends CustomComponent implements View {
	
	private Label lblLogo;
	private Label lblNewPassword;
	private Label lblConfirm;
	private TextField txtNewPassword;
	private TextField txtConfirm;
	private Button btnConfirm;
	private Panel pnlMain;
	private Button btnCancel;
	private Image  imgSecurity;
	private Image imgPasword;
	public static final String NAME2="Pregunta";
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
		
		txtNewPassword = new TextField("Nueva Contraseña");
		lblConfirm = new Label("Falta imagen");
		txtConfirm = new TextField("Confirmar Constraseña");
		
		btnConfirm = new Button("Confirmar");
		btnCancel = new Button("Cancelar");
		
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
