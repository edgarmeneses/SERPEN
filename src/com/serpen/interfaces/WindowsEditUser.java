package com.serpen.interfaces;

import com.serpen.logic.entity.User;
import com.serpen.persistence.control.ControlGeneral;
import com.vaadin.navigator.Navigator;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

public class WindowsEditUser extends Window{
	
	private PanelEditUsers editUsers;
	
	public WindowsEditUser(Navigator navigator, ControlGeneral control) {
		// TODO Auto-generated constructor stub
		super("Editar Usuario");
		center();
		setWidth("600px");
		setHeight("600px");
		VerticalLayout layout = new VerticalLayout();
		this.editUsers = new PanelEditUsers(navigator, control);
		layout.addComponent(editUsers);
		layout.setMargin(true);
		setContent(layout);
		
	}

}
