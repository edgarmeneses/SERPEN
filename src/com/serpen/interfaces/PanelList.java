package com.serpen.interfaces;

import java.util.Iterator;
import java.util.LinkedList;

import com.serpen.error.connection.ErrorConnection;
import com.serpen.logic.entity.Role;
import com.serpen.logic.entity.User;
import com.serpen.persistence.control.ControlGeneral;
import com.vaadin.navigator.Navigator;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Button.ClickEvent;

import java.util.Collection;
import java.util.List;

import org.apache.bcel.generic.RETURN;

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
		pnlTable.setHeight("400px");


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


		boxRol = new ComboBox("",fillComboRole());
		boxRol.setVisible(true);
		boxRol.setValue("");

		boxRol.select("Seleccionar");

		btnSearch= new  Button("Buscar");

		btnSearch.setWidth("150px");
		btnSearch.setHeight("50px");
		btnSearch.setVisible(true);

		btnSearch.addClickListener(new ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				// TODO Auto-generated method stub

				fill();

			}


		});

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

		/** Definir  columnas **/
		table.addContainerProperty("Usuario", String.class, null);
		table.addContainerProperty("Rol", String.class, null);
		table.addContainerProperty("Estado", String.class, null);
		table.addContainerProperty("Control", PanelControlList.class, null);
		fill();


		/** Mostrar exactamente el momento contenían fila**/
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


	}
	/**
	 * Metodo que permite llenar la combobox con los roles existentes
	 */
	public Collection<String> fillComboRole(){


		List<String> list = new LinkedList<String>();

		//		list.add("Seleccionar Rol");

		try {
			List<Role> roles = control.getRole().list();

			for (Role role : roles) {

				list.add(role.getName());

			}
			list.add("Seleccionar");



		} catch (ErrorConnection e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;

	}
	/**
	 * Para consuktar los usuarios que hay 
	 * @param user
	 * @return
	 */
	public Object[] fillRow(User user){
		return new Object[]{user.getNickname()+"", user.getRol().getName(), user.getstate(), new PanelControlList(navigator,control,user,this)};

	}

	/**
	 * Agrega los usuarios a la tabla 
	 * @return
	 */

	public void fill(){
//		try {
////			List<User> users = control.getUser().list(stateNickname(), stateRole(),
////					this.txtUser.getValue(), boxRol.getValue().toString(), control.getRole());
//
//			table.removeAllItems();
//
//			for (int i = 0; i < users.size(); i++) {
//				table.addItem(fillRow(users.get(i)),i);
//			}
//		} catch (ErrorConnection e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
}

	private int stateRole(){

		if(boxRol.getValue().toString().equals("Seleccionar")){
			return 0;
		}else{
			return 1;
		}

	}

	private int stateNickname(){

		if(txtUser.getValue().equals("")){
			return 0;
		}else{
			return 1;
		}
	}

}

