package com.serpen.interfaces;

import com.serpen.error.connection.ErrorConnection;
import com.serpen.logic.entity.User;
import com.serpen.persistence.control.ControlGeneral;
import com.vaadin.navigator.Navigator;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.UI;
/**
 * Universidad Pedagogica y Tecnologica de Colombia 
 * @author Eliana Ayala
 *         Daniela Blanco 
 *         Diana Gonzalez
 *         Edgar Meneses
 *Clase de la interfaz que se encarga de pintar la ventana de Panel control List
 *extiende de Panel
 */
public class PanelControlList extends Panel{

	/**
	 * Atributos de la clase panelControlList 
	 */
	private Button btnUpdate;
	private Button btnRemove;
	private Navigator navigator;
	private User user;
	private ControlGeneral cGeneral;
	private PanelList list;

	/**
	 * Constructor de la clase Panel Controlque por parametro pide
	 * @param navigator
	 * @param control
	 * @param user
	 * @param list
	 * Instancia los componenes que se deben pintar  en la clase List
	 */
	public PanelControlList(Navigator navigator, ControlGeneral control, User user, PanelList list) {
		// TODO Auto-generated constructor stub
		this.user = user;
		this.navigator= navigator;
		this.cGeneral= control;
		this.list= list;

		HorizontalLayout layout = new HorizontalLayout();

		btnUpdate = new Button("Editar");
		btnUpdate.addClickListener(new ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				// TODO Auto-generated method stub
				WindowsEditUser windEdit = new WindowsEditUser(navigator, control,user);
				UI.getCurrent().addWindow(windEdit);
			}
		});

		btnRemove = new Button("Eliminar");
		btnRemove.addClickListener(new ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				// TODO Auto-generated method stub
				removeUser();
			}
		});

		layout.addComponent(btnUpdate);
		layout.addComponent(btnRemove);

		setContent(layout);
		setSizeFull();

	}

	/**
	 * Metodo removerUser que se encarfa de remover un 
	 * usuario de la base de datos
	 */
	public void removeUser(){

		try {
			cGeneral.getUser().remove(user.getNickname());
			list.fill();
		} catch (ErrorConnection e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
