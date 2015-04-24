package com.serpen.interfaces;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Button.ClickEvent;

public class PanelControlList extends Panel{
	
	private Button btnUpdate;
	private Button btnRemove;
	
	public PanelControlList() {
		// TODO Auto-generated constructor stub
		HorizontalLayout layout = new HorizontalLayout();
		
		btnUpdate = new Button("Editar");
		btnUpdate.addClickListener(new ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				// TODO Auto-generated method stub
				
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
