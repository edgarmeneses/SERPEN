package com.serpen.interfaces;

import com.serpen.logic.entity.User;
import com.serpen.persistence.control.ControlGeneral;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;

public class CreateRol extends CustomComponent implements View{

	private PanelCreateRole  panelCreateRole;
	private PanelAdministrator administrator;
	public static final String NAMECREATEROLE="Roles";
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
