package com.serpen.interfaces;

import com.serpen.logic.entity.User;
import com.serpen.persistence.control.ControlGeneral;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
/**
 * Universidad Pedagogica y Tecnologica de Colombia 
 * @author Eliana Ayala
 *         Daniela Blanco 
 *         Diana Gonzalez
 *         Edgar Meneses
 *Clase de la interfaz que se encarga de pintar la ventana de Create User
 *extiende de custom Componente e implementa  View
 */
public class CreateUser extends CustomComponent implements View{ 

	/**
	 * Atributo de  la clase de Create User
	 */
	private PanelAdministrator administrator;
	private PanelCreateUser createUser;
	public static final String NAMECREATE="CrearUsuario"; 

	/**
	 * Constructor  de la clase CreateUser que por parametro pide:
	 * @param navigator
	 * @param user
	 * @param control
	 * Crea  los componentes que se van a pintar en esta ventana
	 */
	public CreateUser(Navigator navigator, User user, ControlGeneral control) {
		// TODO Auto-generated constructor stubd
		administrator = new PanelAdministrator(navigator, user, control);
		createUser = new PanelCreateUser(navigator,control);

		HorizontalLayout horizontalLayout = new HorizontalLayout();

		horizontalLayout.addComponent(administrator);
		horizontalLayout.addComponent(createUser);

		setCompositionRoot(horizontalLayout);
		setSizeFull();

	}
	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub

	}
}
