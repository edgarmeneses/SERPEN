package com.serpen.interfaces;

import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Panel;

public class PanelButtonRol extends Panel{

	private Button btnDelete;

	public PanelButtonRol(){

		HorizontalLayout horizontalLayout = new HorizontalLayout();

		btnDelete = new Button("Eliminar");
		btnDelete.addClickListener(new ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				// TODO Auto-generated method stub
			}
		});

		horizontalLayout.addComponent(btnDelete);

		this.setContent(horizontalLayout);
		this.setSizeFull();

	}

}
