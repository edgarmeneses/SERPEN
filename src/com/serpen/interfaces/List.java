package com.serpen.interfaces;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;

public class List extends CustomComponent implements View{
	
	private PanelAdministrator administrator;
	private PanelList list;
	public static final String NAMELIST="ListarUsuarios";
	
	public List(Navigator navigator) {
		HorizontalLayout layout = new HorizontalLayout();
		
		administrator = new PanelAdministrator(navigator);
		list = new PanelList(navigator);
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
