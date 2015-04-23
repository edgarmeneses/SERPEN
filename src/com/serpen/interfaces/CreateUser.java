package com.serpen.interfaces;

import org.eclipse.jetty.util.security.Password;

import com.vaadin.annotations.Theme;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;


@SuppressWarnings("serial")

//asigna el tema a la clase que se desea modelar
@Theme("themeCreateUser")
public class CreateUser extends CustomComponent implements View{

	private Label lblCreateUser;
	private TextField txtNickname;
	private PasswordField txtPassword;
	private TextField txtAnswer;
	private Image lblImagen;
	private ComboBox rol;
	private Button btnNew;
	private Button btnCancel;
	private Panel panel;
	private Label label;
	public static final String NAME5="CrearUsuario.html"; 
	public CreateUser (){
		
		FormLayout layoutPrincipal = new FormLayout();
		layoutPrincipal.setSizeFull();
		layoutPrincipal.beforeClientResponse(false);
		layoutPrincipal.setVisible(true);
		

		FormLayout layoutPanel = new FormLayout();
		layoutPanel.setVisible(true);
//		layoutPanel.setWidth("700px");
//		layoutPanel.setHeight("500px");			
		
		
//		lblCreateUser = new Label("CREAR USUARIO");
		
		HorizontalLayout layoutHorizontal = new HorizontalLayout();
        
		
		
	    VerticalLayout layoutDatos = new VerticalLayout();
	    			
		txtNickname = new TextField("Usuario");
		txtPassword = new PasswordField("Contraseña");
		txtPassword.setRequired(true);
		txtPassword.setValue("");
		txtPassword.setNullRepresentation("");
		txtAnswer = new TextField("Respuesta");
		
		VerticalLayout layoutRol = new VerticalLayout();

		ThemeResource resource = new ThemeResource("../Imagen/CrearUsuario.png");
		lblImagen = new Image(null, resource);
		this.lblImagen.setVisible(true);
		this.lblImagen.setWidth("150px");
		this.lblImagen.setHeight("150px");
		
		rol = new ComboBox("Rol");
		
		HorizontalLayout layoutbutton = new HorizontalLayout();
		btnNew = new Button("Aceptar");
		btnCancel = new Button("Cancelar");
		
		panel = new Panel();
		panel.setSizeFull();
		panel.setWidth("700px");
		panel.setHeight("500px");
		
		layoutDatos.addComponent(txtNickname);
		layoutDatos.addComponent(txtPassword);
		layoutDatos.addComponent(txtAnswer);
				
		layoutRol.addComponent(lblImagen);
		layoutRol.addComponent(rol);

		layoutbutton.addComponent(btnNew);
		layoutbutton.addComponent(btnCancel);
		
		layoutHorizontal.addComponent(layoutDatos);
		layoutHorizontal.addComponent(layoutRol);
		
		layoutPanel.addComponent(layoutHorizontal);
		layoutPanel.addComponent(layoutbutton);
				
		layoutPrincipal.addComponent(panel);
		this.panel.setContent(layoutPanel);
		this.setCompositionRoot(layoutPrincipal);
	    setSizeFull();
	}
	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}
}
