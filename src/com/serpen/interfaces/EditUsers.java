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
 *Clase de la interfaz que se encarga de pintar la ventana de Editar User
 *extiende de custom Componente e implementa  View
 */
public class EditUsers extends CustomComponent implements View{

	/**
	 * Atributos de la clase Editar usuario
	 */
	private PanelAdministrator administrator;
	private PanelEditUsers editUsers;
	public static final String NAMEEDIT="EditarUsuario";

	/**
	 * Consructor de la clase de Editar Usuario que  por parametro pide
	 * @param navigator
	 * @param user
	 * @param control
	 * Instancia los componentes que se van a pintar
	 */
	public EditUsers(Navigator navigator, User user, ControlGeneral control) {

		HorizontalLayout layout = new HorizontalLayout();
		administrator = new PanelAdministrator(navigator, user, control);
		editUsers = new PanelEditUsers(navigator, control);
		layout.addComponent(administrator);
		layout.addComponent(editUsers);
		setCompositionRoot(layout);
		setSizeFull();
	}
	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub

	}
}
