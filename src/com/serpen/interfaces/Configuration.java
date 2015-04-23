package com.serpen.interfaces;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Panel;

public class Configuration extends CustomComponent implements View{
	
	private PanelAdministrator administrator;
	private PanelConfiguration configuration;
	public static final String NAMECONFIGURATION="configuraciones";
	
	public Configuration(Navigator navigator) {
		// TODO Auto-generated constructor stub
		HorizontalLayout layout = new HorizontalLayout();
		
		administrator = new PanelAdministrator(navigator);
		configuration = new PanelConfiguration(navigator);
		
		
		
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
