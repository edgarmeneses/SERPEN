package com.serpen.interfaces;

import com.serpen.persistence.control.ControlGeneral;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Button.ClickListener;

public class PanelEditUsers  extends Panel{
	
	//
	private Label lbLabelPrincipal;
	private Image imgPasword;
	private Label lblNewPassword;
	private TextField txtNewPassword;
	private Image imgSecurity;
	private Label lblNewSecurityAns;
	private TextField txtNewSecurityAns;
	private Panel panelEdit;
	private Navigator navigator;
	private Button btnAccept;
	private Button btnCancel;
	private Label lblSearch;
	private TextField txtSearch;
	private Button btnSearch;
	private ControlGeneral control;
	public PanelEditUsers(Navigator navigator, ControlGeneral control){
		
		this.navigator=navigator;
		this.control=control;
		
		FormLayout formLayoutPrin= new FormLayout();
		formLayoutPrin.setSizeFull();
		formLayoutPrin.beforeClientResponse(false);
		formLayoutPrin.setVisible(true);
		
		panelEdit = new  Panel();
		panelEdit.setWidth("480px");
		panelEdit.setHeight("400px");
		
		FormLayout formLayoutEdit = new FormLayout();
//		formLayoutEdit.setSizeFull();
		formLayoutEdit.setVisible(true);
		
		HorizontalLayout layoutSearch= new HorizontalLayout();
		layoutSearch.setVisible(true);
		
		HorizontalLayout layautPassword= new HorizontalLayout();
//	    layautPassword.setVisible(true);
	    
	    HorizontalLayout layoutSecurity = new HorizontalLayout();
//	    layoutSecurity.setVisible(true);
	    HorizontalLayout layoutBtn = new HorizontalLayout();
	    layoutBtn.setVisible(true);
	    
	    lbLabelPrincipal = new Label("Editar Usuario");
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
		
		txtNewPassword = new TextField();
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
		
		txtNewSecurityAns = new TextField();
		txtNewSecurityAns.setWidth("150px");
		txtNewSecurityAns.setHeight("50px");
		txtNewSecurityAns.setVisible(true);
		
		btnAccept = new Button("Aceptar");
		btnAccept.setWidth("100px");
		btnAccept.setHeight("50px");
		btnAccept.setVisible(true);
		
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
//		btnCancel.setVisible(true);
		
		btnSearch= new Button("Buscar");
		btnSearch.setWidth("100px");
		btnSearch.setHeight("50px");
		btnSearch.setVisible(true);
		
		lblSearch  = new Label("Usuario");
		lblSearch.setWidth("150px");
		lblSearch.setHeight("50px");
		lblSearch.setVisible(true);
		
		txtSearch= new TextField();
		txtSearch.setWidth("150px");
		txtSearch.setHeight("50px");
		txtSearch.setVisible(true);
		
		formLayoutEdit.addComponent(lbLabelPrincipal);
		formLayoutEdit.addComponent(layoutSearch);
		formLayoutEdit.addComponent(layautPassword);
		formLayoutEdit.addComponent(layoutSecurity);
		formLayoutEdit.addComponent(layoutBtn);
		
		
		layoutSearch.addComponent(lblSearch);
	    layoutSearch.addComponent(txtSearch);
	    layoutSearch.addComponent(btnSearch);
		layautPassword.addComponent(imgPasword);
		layautPassword.addComponent(lblNewPassword);
		layautPassword.addComponent(txtNewPassword);
		layoutSecurity.addComponent(imgSecurity);
		layoutSecurity.addComponent(lblNewSecurityAns);
		layoutSecurity.addComponent(txtNewSecurityAns);
		layoutBtn.addComponent(btnAccept);
		layoutBtn.addComponent(btnCancel);
		
		panelEdit.setContent(formLayoutEdit);
		formLayoutPrin.addComponent(panelEdit);
		setContent(formLayoutPrin);
		
		//		this.setCompositionRoot(formLayoutPrin);
	}
}
