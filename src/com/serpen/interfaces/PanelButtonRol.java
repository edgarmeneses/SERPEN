package com.serpen.interfaces;

import com.serpen.error.connection.ErrorConnection;
import com.serpen.logic.entity.Role;
import com.serpen.persistence.control.ControlGeneral;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Panel;

public class PanelButtonRol extends Panel{

	private Button btnDelete;
	private Role role;
	private ControlGeneral control;
	private PanelListRol listRol;
	
	public PanelButtonRol(Role role, ControlGeneral control, PanelListRol listRol){
		
		this.role = role;
		this.control = control;
		this.listRol = listRol;
		HorizontalLayout horizontalLayout = new HorizontalLayout();

		btnDelete = new Button("Eliminar");
		btnDelete.addClickListener(new ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				// TODO Auto-generated method stub
				try {
					control.getRole().remove(role.getId());
				} catch (ErrorConnection e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		horizontalLayout.addComponent(btnDelete);

		this.setContent(horizontalLayout);
		this.setSizeFull();

	}

}
