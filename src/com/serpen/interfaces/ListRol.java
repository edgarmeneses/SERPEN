package com.serpen.interfaces;

import com.serpen.logic.entity.User;
import com.serpen.persistence.control.ControlGeneral;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Button.ClickEvent;
/**
 * Universidad Pedagogica y Tecnologica de Colombia 
 * @author Eliana Ayala
 *         Daniela Blanco 
 *         Diana Gonzalez
 *         Edgar Meneses
 *Clase de la interfaz que se encarga de pintar la ventana de listar rol
 *extiende de custom Componente e implementa  View
 */
public class ListRol extends CustomComponent implements View{

	/**
	 * Atributos de la clase listar rol
	 */
	private PanelAdministrator administrator;
	private PanelListRol roListRol;
	public static final String NAMELISTROLE="ListarRoles";

	/**
	 * Constructor de la clase Listar rol que pide por parametro
	 * @param navigator
	 * @param user
	 * @param control
	 * Instancia los componentes que se van a pintar en la clase listar
	 */
	public ListRol(Navigator navigator, User user, ControlGeneral control){
		HorizontalLayout layout = new HorizontalLayout();
		administrator= new PanelAdministrator(navigator, user, control);
		roListRol= new PanelListRol(navigator, control);
		layout.addComponent(administrator);
		layout.addComponent(roListRol);
		setCompositionRoot(layout);
		setSizeFull();
	}

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub

	}
}
