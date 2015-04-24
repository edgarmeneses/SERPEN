package com.serpen.interfaces;

import com.serpen.persistence.control.ControlGeneral;
import com.vaadin.navigator.Navigator;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Button.ClickEvent;

public class PanelList extends Panel{
	
	private Label lblUser;
	private TextField txtUser;
	private ComboBox boxRol;
	private Button btnSearch;
	private Button btnReturn;
	private Table table;
	private Panel pnlMenu;
	private Panel pnlTable;
	private Navigator navigator;
	private ControlGeneral control;
	
	public PanelList(Navigator navigator, ControlGeneral control){
		
		this.navigator = navigator;
		this.control = control;
		
		FormLayout layoutPrincipal = new FormLayout();
		layoutPrincipal.setVisible(true);
		
		FormLayout layoutPanel = new FormLayout();
		layoutPanel.setVisible(true);
		
		HorizontalLayout layoutMenu = new HorizontalLayout();
		layoutMenu.setVisible(true);
		
		pnlMenu = new Panel();
		pnlMenu.setSizeFull();
		pnlMenu.setWidth("1000");
		pnlMenu.setHeight("100");
		
		pnlTable = new Panel();
     	pnlTable.setSizeFull();
		pnlTable.setWidth("1000px");
		pnlTable.setHeight("300px");

		
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
		btnReturn.addClickListener(new ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				// TODO Auto-generated method stub
				navigator.navigateTo(Administrator.NAMEADMINISTRATOR);
			}
		});
		
		table = new Table();
//	    table.setWidth("100%"); //Ocupa todo el ancho del navegador
//	    table.setHeight("170px"); //Altura del Grid.
	    
// Definir  columnas 
	    table.addContainerProperty("Usuario", String.class, null);
	    table.addContainerProperty("Rol", String.class, null);
	    table.addContainerProperty("Estado", String.class, null);
	    table.addContainerProperty("Control", PanelControlList.class, null);
	         
//	    Añadir algunas otras filas utilizando addItem
	    table.addItem(new Object[]{"123", "admin" , "Actico", new PanelControlList()}, 2);
	    table.addItem(new Object[] { " " ," " , " ", new PanelControlList()},3);
	    
	    //Mostrar exactamente el momento contenían fila
	    table.setPageLength(table.size());  
	    table.setWidth("80%"); //Ocupa todo el ancho del navegador
	    table.setHeight("170px"); //Altura del Grid.
	    table.setFooterVisible(true);
		
	    layoutMenu.addComponent(lblUser);
		layoutMenu.addComponent(txtUser);
		layoutMenu.addComponent(boxRol);
		layoutMenu.addComponent(btnSearch);
		layoutPanel.addComponent(table);
		layoutPanel.addComponent(btnReturn);
		
		
		this.pnlMenu.setContent(layoutMenu);
		this.pnlTable.setContent(layoutPanel);
		
		layoutPrincipal.addComponent(pnlMenu);
		layoutPrincipal.addComponent(pnlTable);
		
		setContent(layoutPrincipal);
		//this.setCompositionRoot(layoutPrincipal);	
		//this.setSizeFull();	 

	}
}