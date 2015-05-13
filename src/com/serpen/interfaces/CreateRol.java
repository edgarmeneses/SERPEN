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
 *Clase de la interfaz que se encarga de pintar la ventana de Create Rol
 *extiende de custom Componente e implementa  View
 */
public class CreateRol extends CustomComponent implements View{

	/**
	 * Atributos  de la clase createRol 
	 */
	private PanelCreateRole  panelCreateRole;
	private PanelAdministrator administrator;
	public static final String NAMECREATEROLE="Roles";
	/**
	 * Constructor de la clase Create rol que por parametro pide 
	 * @param navigator
	 * @param user
	 * @param control
	 * Instanciacion de todos los componente que se van a pintar en la clase de crear rol
	 */
	public CreateRol(Navigator navigator, User user, ControlGeneral control) {
		// TODO Auto-generated constructor stub

		panelCreateRole = new PanelCreateRole(navigator,control);
		administrator= new PanelAdministrator(navigator, user , control);
		HorizontalLayout horizontalLayout = new HorizontalLayout();

		horizontalLayout.addComponent(administrator);
		horizontalLayout.addComponent(panelCreateRole);

		setCompositionRoot(horizontalLayout);
		setSizeFull();
	}
	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub

	}
}
