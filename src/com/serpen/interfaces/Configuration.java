package com.serpen.interfaces;

import java.util.ResourceBundle.Control;

import com.serpen.logic.entity.User;
import com.serpen.persistence.control.ControlGeneral;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Panel;
/**
 * Universidad Pedagogica y Tecnologica de Colombia 
 * @author Eliana Ayala
 *         Daniela Blanco 
 *         Diana Gonzalez
 *         Edgar Meneses
 *Clase de la interfaz que se encarga de pintar la ventana de Configuracion
 *extiende de custom Componente e implementa  View
 */
public class Configuration extends CustomComponent implements View{

	/**
	 * Atributos de la clase Configuration
	 */
	private PanelAdministrator administrator;
	private PanelConfiguration configuration;
	public static final String NAMECONFIGURATION="configuraciones";

	/**
	 * Constructor de la clase Configuration que pide por parametro
	 * e instancia los componentes necesarios
	 * @param navigator
	 * @param user
	 * @param control
	 */
	public Configuration(Navigator navigator, User user, ControlGeneral control) {
		// TODO Auto-generated constructor stub
		HorizontalLayout layout = new HorizontalLayout();
		administrator = new PanelAdministrator(navigator, user,control);
		configuration = new PanelConfiguration(navigator, user,control);
		layout.addComponent(administrator);
		layout.addComponent(configuration);
		setCompositionRoot(layout);
		setSizeFull();
	}
	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
	}
}
