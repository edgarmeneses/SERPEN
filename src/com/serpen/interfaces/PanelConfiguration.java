package com.serpen.interfaces;

import com.serpen.error.connection.ErrorConnection;
import com.serpen.logic.entity.User;
import com.serpen.persistence.control.ControlGeneral;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.ThemeResource;
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
import com.vaadin.ui.Button.ClickListener;

public class PanelConfiguration  extends Panel{

	//	
	private Label lbLabelPrincipal;
	private Image imgPasword;
	private Label lblNewPassword;
	private PasswordField txtNewPassword;
	private Image imgSecurity;
	private Label lblNewSecurityAns;
	private TextField txtNewSecurityAns;
	private Panel panelEdit;
	private Navigator navigator;
	private Button btnAccept;
	private Button  btnCancel;
	private User user;
	private ControlGeneral control;

	public PanelConfiguration(Navigator navigator, User user, ControlGeneral control){

		this.navigator=navigator;
		this.user = user;
		this.control=control;

		FormLayout formLayoutPrin= new FormLayout();
		formLayoutPrin.setSizeFull();
		formLayoutPrin.setVisible(true);

		panelEdit = new  Panel();
		panelEdit.setWidth("400px");
		panelEdit.setHeight("400px");

		FormLayout formLayoutEdit = new FormLayout();

		formLayoutEdit.setVisible(true);

		HorizontalLayout layautPassword= new HorizontalLayout();


		HorizontalLayout layoutSecurity = new HorizontalLayout();


		HorizontalLayout layoutBtn = new HorizontalLayout();
		layoutBtn.setVisible(true);



		lbLabelPrincipal = new Label("Configurar Usuario");
		lbLabelPrincipal.setWidth("150px");
		lbLabelPrincipal.setHeight("50px");
		lbLabelPrincipal.setVisible(true);

		this.imgPasword = new Image("Constraseña");
		ThemeResource resource = new ThemeResource("../Imagen/constrase_a_converted.png");
		imgPasword =new Image (null, resource);
		this.imgPasword.setVisible(true);

		lblNewPassword = new Label("Nueva Contraseña");
		lblNewPassword.setWidth("150px");
		lblNewPassword.setHeight("50px");
		lblNewPassword.setVisible(true);

		txtNewPassword = new PasswordField();
		txtNewPassword.setWidth("150px");
		txtNewPassword.setHeight("50px");
		txtNewPassword.setVisible(true);

		this.imgSecurity = new Image("Constraseña");
		ThemeResource resource1 = new ThemeResource("../Imagen/profesor.jpg");
		imgSecurity =new Image (null, resource1);
		this.imgSecurity.setVisible(true);

		lblNewSecurityAns = new Label("Respuesta  Seguridad");
		lblNewSecurityAns.setWidth("150px");
		lblNewSecurityAns.setHeight("50px");
		lblNewSecurityAns.setVisible(true);

		btnAccept = new Button("Aceptar");
		btnAccept.setWidth("100px");
		btnAccept.setHeight("50px");
		btnAccept.setVisible(true);
		btnAccept.addClickListener(new ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				// TODO Auto-generated method stub
								
				try {
					control.getUser().upDate(user.getNickname(), txtNewPassword.getValue(),txtNewSecurityAns.getValue());
					
					System.out.println("COMPROBAR");
					System.out.println(user.getPassword());
					System.out.println(user.getAnswer());
					System.out.println("----------------------");
					Notification.show("Contraseña Cambiada Satisfactoriamente");
				} catch (ErrorConnection e) {
					// TODO Auto-generated catch block
					System.out.println("causa: " + e.getCause());
				
			}
			}
		});
		

		btnCancel = new Button("Cancelar");
		btnCancel.addClickListener(new ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				// TODO Auto-generated method stub

				navigator.navigateTo(Administrator.NAMEADMINISTRATOR);
			}
		});
		btnCancel.setWidth("100px");
		btnCancel.setHeight("50px");


		txtNewSecurityAns = new TextField();
		txtNewSecurityAns.setWidth("150px");
		txtNewSecurityAns.setHeight("50px");
		txtNewSecurityAns.setVisible(true);

		formLayoutEdit.addComponent(lbLabelPrincipal);
		formLayoutEdit.addComponent(layautPassword);
		formLayoutEdit.addComponent(layoutSecurity);
		formLayoutEdit.addComponent(layoutBtn);

		layautPassword.addComponent(imgPasword);
		layautPassword.addComponent(lblNewPassword);
		layautPassword.addComponent(txtNewPassword);
		layoutSecurity.addComponent(imgSecurity);
		layoutSecurity.addComponent(lblNewSecurityAns);
		layoutSecurity.addComponent(txtNewSecurityAns);
		layoutBtn.addComponent(btnAccept);
		layoutBtn.addComponent(btnCancel );

		panelEdit.setContent(formLayoutEdit);
		formLayoutPrin.addComponent(panelEdit);
		setContent(formLayoutPrin);
	}
	/**
	 * metodo que permite cambiar la informacion del usuario que ingreso a la plataforma
	 * permite cambiar su contraseña y su respuesta de seguridad
	 */
	private void changeInform(){

	}

}
