package com.serpen.interfaces;

import com.serpen.persistence.control.ControlGeneral;
import com.vaadin.navigator.Navigator;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.UI;

public class PanelControlList extends Panel{
	
	private Button btnUpdate;
	private Button btnRemove;
	private Navigator navigator;
	
	public PanelControlList(Navigator navigator, ControlGeneral control) {
		// TODO Auto-generated constructor stub
		HorizontalLayout layout = new HorizontalLayout();
		
		btnUpdate = new Button("Editar");
		btnUpdate.addClickListener(new ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				// TODO Auto-generated method stub
				WindowsEditUser windEdit = new WindowsEditUser(navigator, control);
				UI.getCurrent().addWindow(windEdit);
			}
		});
		
		btnRemove = new Button("Eliminar");
		btnRemove.addClickListener(new ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				// TODO Auto-generated method stub
				
			}
		});
		
		layout.addComponent(btnUpdate);
		layout.addComponent(btnRemove);
		
		setContent(layout);
		setSizeFull();
		
	}
}
