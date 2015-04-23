package com.serpen.interfaces;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;

public class EditUsers extends CustomComponent implements View{
	
	private PanelAdministrator administrator;
	private PanelEditUsers editUsers;
	public static final String NAMEEDIT="EditarUsuario";
	
	public EditUsers(Navigator navigator) {
		
		HorizontalLayout layout = new HorizontalLayout();
		
		administrator = new PanelAdministrator(navigator);
		editUsers = new PanelEditUsers(navigator);
		
		
		
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
