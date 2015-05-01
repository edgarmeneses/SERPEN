package com.serpen.interfaces;

import java.util.LinkedList;
import java.util.List;

import org.hibernate.ObjectNotFoundException;

import com.serpen.error.connection.ErrorConnection;
import com.serpen.logic.entity.Role;
import com.serpen.logic.entity.User;
import com.serpen.persistence.control.ControlGeneral;
import com.vaadin.annotations.Theme;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;

@SuppressWarnings("serial")

/**
 * asigna el tema a la clase que se desea modelar
 * @author 
 *
 */
@Theme("themeCreateUser")
public class PanelCreateUser extends Panel implements View{

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
	private Navigator navigator;
	private ControlGeneral control;

	public PanelCreateUser (Navigator navigator, ControlGeneral control) {

		this.navigator = navigator;
		this.control=control;

		FormLayout layoutPrincipal = new FormLayout();
		layoutPrincipal.setSizeFull();
		layoutPrincipal.beforeClientResponse(false);
		layoutPrincipal.setVisible(true);


		FormLayout layoutPanel = new FormLayout();
		layoutPanel.setVisible(true);

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


		try {
			rolList();
			rol = new ComboBox("Rol",rolList());
			rol.setInputPrompt("Seleccionar Rol:");
			rol.setInvalidAllowed(false);
		} catch (ErrorConnection e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		HorizontalLayout layoutbutton = new HorizontalLayout();

		btnNew = new Button("Aceptar");		
		btnNew.addClickListener(new ClickListener() {		
			@Override
			public void buttonClick(ClickEvent event) {
				// TODO Auto-generated method stub

				try {
					int nickame=Integer.valueOf(txtNickname.getValue());
					String password=txtPassword.getValue();
					String answer=txtAnswer.getValue();
					Role role = control.getRole().consultName(rol.getValue().toString());
					control.getUser().insert(nickame,password,answer,role);
					Notification.show("El Usuario  ha sido insertado con exito!");
				} catch (ErrorConnection e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}		
			}
		});	
		btnCancel = new Button("Cancelar");
		btnCancel.addClickListener(new Button.ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				// TODO Auto-generated method stub
				//navigator.addView(Administrator.NAME3, new );

				navigator.navigateTo(Administrator.NAMEADMINISTRATOR);
			}
		});

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
		
		
		setContent(layoutPrincipal);

	}
	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub

	}

	public List<String> rolList() throws ErrorConnection{
		List<Role> role;

		List<String> nameRole = new LinkedList<String>(); 
		role = control.getRole().list();
		System.out.println("rol nuevo "+role);
		for (int i = 0; i < role.size(); i++) {
			nameRole.add(role.get(i).getName());

		}
		System.out.println(nameRole);
		return nameRole;		
	}	
}
