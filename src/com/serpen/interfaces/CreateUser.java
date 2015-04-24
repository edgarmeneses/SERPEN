package com.serpen.interfaces;

import com.serpen.logic.entity.User;
import com.serpen.persistence.control.ControlGeneral;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;

public class CreateUser extends CustomComponent implements View{ 
	
	private PanelAdministrator administrator;
	private PanelCreateUser createUser;
	public static final String NAMECREATE="CrearUsuario"; 
	
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
