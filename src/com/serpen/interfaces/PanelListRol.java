package com.serpen.interfaces;

import com.serpen.logic.entity.User;
import com.serpen.persistence.control.ControlGeneral;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Button.ClickEvent;

public class PanelListRol extends Panel{

	private Label lblUser;
	private TextField txtUser;
	private ComboBox boxRol;
	private Button btnSearch;
	private Button btnReturn;
	private Table table;
	private Panel pnlMenuRol;
	private Panel pnlTableRol;
	private Navigator navigator;
	private ControlGeneral controlGeneral;
	
	public PanelListRol(Navigator navigator, ControlGeneral control){
		
		this.navigator=navigator;
		this.controlGeneral=control;
		
		FormLayout layoutPrincipal = new FormLayout();
		layoutPrincipal.setVisible(true);
		
		FormLayout layoutPanel = new FormLayout();
		layoutPanel.setVisible(true);
		
		HorizontalLayout layoutMenu = new HorizontalLayout();
		layoutMenu.setVisible(true);
		
		pnlMenuRol = new Panel();
		pnlMenuRol.setSizeFull();
		pnlMenuRol.setWidth("1000");
		pnlMenuRol.setHeight("100");
		
		pnlTableRol = new Panel();
		pnlTableRol.setSizeFull();
		pnlTableRol.setWidth("1000px");
		pnlTableRol.setHeight("300px");
		
		
		lblUser = new Label("Usuario");		
		lblUser.setWidth("100px");
		lblUser.setHeight("50px");
		lblUser.setVisible(true);

		txtUser = new TextField();
		txtUser.setWidth("150px");
		txtUser.setHeight("50px");
		txtUser.setRequired(true);
		txtUser.setValue("");
		txtUser.setNullRepresentation("");
		
		boxRol = new ComboBox("");
		boxRol.setVisible(true);
		boxRol.setValue("");
		
		btnSearch= new  Button("Buscar");
		
		btnSearch.setWidth("150px");
		btnSearch.setHeight("50px");
		btnSearch.setVisible(true);
		
		btnReturn= new  Button("Regresar");
		btnReturn.setWidth("150px");
		btnReturn.setHeight("50px");
		btnReturn.setVisible(true);
		btnReturn.addClickListener(new Button.ClickListener(){

			@Override
			public void buttonClick(ClickEvent event) {
				// TODO Auto-generated method stub
				
				navigator.navigateTo(Administrator.NAMEADMINISTRATOR);
			}
			
		});
		
		table = new Table();
		
		table.addContainerProperty("Usuario", String.class, null);
		table.addContainerProperty("Rol", String.class, null);
		table.addContainerProperty("Estado", String.class, null);
		table.addContainerProperty("Control", PanelButtonRol.class, null);
		    
		table.addItem(new Object[]{" ", " " , " ",new PanelButtonRol()}, 2);
	    table.addItem(new Object[] { " " ," " , " ",new PanelButtonRol()},3);
		    
		   
	    table.setPageLength(table.size());  
	    table.setWidth("80%"); 
	    table.setHeight("170px");
	    table.setFooterVisible(true);
	    
	    layoutMenu.addComponent(lblUser);
	  		layoutMenu.addComponent(txtUser);
	  		layoutMenu.addComponent(boxRol);
	  		layoutMenu.addComponent(btnSearch);
	  		layoutPanel.addComponent(table);
	  		layoutPanel.addComponent(btnReturn);
	  		
	  		
	  		this.pnlMenuRol.setContent(layoutMenu);
	  		this.pnlTableRol.setContent(layoutPanel);
	  		
	  		layoutPrincipal.addComponent(pnlMenuRol);
	  		layoutPrincipal.addComponent(pnlTableRol);

			setContent(layoutPrincipal);

	}
	}
