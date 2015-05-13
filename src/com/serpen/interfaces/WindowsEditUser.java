package com.serpen.interfaces;

import com.serpen.logic.entity.User;
import com.serpen.persistence.control.ControlGeneral;
import com.vaadin.navigator.Navigator;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

/**
 * Universidad Pedagogica y Tecnologica de Colombia 
 * @author Eliana Ayala
 *         Daniela Blanco 
 *         Diana Gonzalez
 *         Edgar Meneses
 *Clase de la interfaz que se encarga de pintar la ventana Editar usuario
 *extiende de custom Componente e implementa  View
 */
public class WindowsEditUser extends Window{

	/**
	 * Atributos de la clase editar Usuario
	 */
	private PanelEditUsers editUsers;

	/**
	 * Constructor de la clase Windows Edit User
	 * @param navigator
	 * @param control
	 * @param user
	 */
	public WindowsEditUser(Navigator navigator, ControlGeneral control, User user) {
		// TODO Auto-generated constructor stub
		super("Editar Usuario");
		center();
		setWidth("600px");
		setHeight("600px");
		VerticalLayout layout = new VerticalLayout();
		this.editUsers = new PanelEditUsers(navigator, control,user);
		layout.addComponent(editUsers);
		layout.setMargin(true);
		setContent(layout);

	}

}
