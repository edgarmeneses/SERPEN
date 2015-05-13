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
 *Clase de la interfaz que se encarga de pintar la ventana de listar User
 *extiende de custom Componente e implementa  View
 */
public class List extends CustomComponent implements View{

	/**
	 * Atributos de la clase List
	 */
	private PanelAdministrator administrator;
	private PanelList list;
	public static final String NAMELIST="ListarUsuarios";

	/**
	 * Constructor de la clase listar que  por parametro pide 
	 * @param navigator
	 * @param user
	 * @param control
	 * Instancia los componentes que se van a pintar en  esta clase
	 */
	public List(Navigator navigator, User user, ControlGeneral control) {
		HorizontalLayout layout = new HorizontalLayout();
		administrator = new PanelAdministrator(navigator, user, control);
		list = new PanelList(navigator, control);
		layout.addComponent(administrator);
		layout.addComponent(list);
		setCompositionRoot(layout);
		setSizeFull();
	}
	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub

	}
}