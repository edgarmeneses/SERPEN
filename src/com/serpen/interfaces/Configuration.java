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

public class Configuration extends CustomComponent implements View{

	//
	private PanelAdministrator administrator;
	private PanelConfiguration configuration;
	public static final String NAMECONFIGURATION="configuraciones";

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
