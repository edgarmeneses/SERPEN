package com.serpen.interfaces;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;

public class CreateUser extends CustomComponent implements View{ 
	
	private PanelAdministrator administrator;
	private PanelCreateUser user;
	public static final String NAME5="CrearUsuario"; 
	
	public CreateUser(Navigator navigator) {
		// TODO Auto-generated constructor stubd
		administrator = new PanelAdministrator(navigator);
		user = new PanelCreateUser(navigator);
		
		HorizontalLayout horizontalLayout = new HorizontalLayout();
		
		horizontalLayout.addComponent(administrator);
		horizontalLayout.addComponent(user);
		
		setCompositionRoot(horizontalLayout);
		setSizeFull();
		
	}

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}

}
