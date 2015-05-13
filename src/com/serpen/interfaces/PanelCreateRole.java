package com.serpen.interfaces;
import com.serpen.error.connection.ErrorConnection;
import com.serpen.logic.entity.Role;
import com.serpen.persistence.control.ControlGeneral;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

/**
 * Universidad Pedagogica y Tecnologica de Colombia 
 * @author Eliana Ayala
 *         Daniela Blanco 
 *         Diana Gonzalez
 *         Edgar Meneses
 *Clase de la interfaz que se encarga de pintar la ventana de Panel control List
 *extiende de Panel
 */
public class PanelCreateRole extends Panel{

	/**
	 * Atributos de la clase Panel Create Role 
	 */
	private Image imgNewRole;
	private  Label lblCreateRole;
	private Label lblNewRole;
	private TextField txtNewRole;
	private Button btnAccept;
	private Button btnCancel;
	private Panel pnlPrincipal;
	private Navigator navigator;

	/**
	 * Constructor que se pide por parametros 
	 * @param navigator
	 * @param control
	 * Instancia de los componentes que se van a pintar en la clase
	 * create rol
	 */
	public PanelCreateRole(Navigator navigator, ControlGeneral control) {
		// TODO Auto-generated constructor stub

		this.navigator = navigator;
		FormLayout layoutPrinc = new FormLayout();
		layoutPrinc.setVisible(true);
		layoutPrinc.setSizeFull();
		layoutPrinc.beforeClientResponse(false);

		pnlPrincipal =  new Panel();
		pnlPrincipal.setWidth("500px");
		pnlPrincipal.setHeight("300px");
		pnlPrincipal.setVisible(true);


		FormLayout layoutPanel = new FormLayout();
		layoutPanel.setVisible(true);
		layoutPanel.setSizeFull();
		layoutPanel.beforeClientResponse(false);

		HorizontalLayout ltlCreateRole = new HorizontalLayout();
		ltlCreateRole.setVisible(true);


		HorizontalLayout ltlNewRole = new HorizontalLayout();
		ltlNewRole.setVisible(true);

		HorizontalLayout ltlbtnRole= new HorizontalLayout();
		ltlbtnRole.setVisible(true);

		lblCreateRole = new Label("Crear Rol");
		lblCreateRole.setWidth("150px");
		lblCreateRole.setHeight("50px");
		lblCreateRole.setVisible(true);

		this.imgNewRole = new Image("Rol");
		ThemeResource resource = new ThemeResource("../Imagen/role.png");
		imgNewRole = new Image(null, resource);
		imgNewRole.setWidth("50px");
		imgNewRole.setHeight("50px");
		this.imgNewRole.setVisible(true);

		lblNewRole = new Label("Ingrese el Nombre");
		lblNewRole.setWidth("150px");
		lblNewRole.setHeight("50px");
		lblNewRole.setVisible(true);

		txtNewRole = new TextField();
		txtNewRole.setWidth("150px");
		txtNewRole.setHeight("50px");
		txtNewRole.setVisible(true);

		btnAccept = new Button("Crear");
		btnAccept.setWidth("100px");
		btnAccept.setHeight("50px");
		btnAccept.addClickListener(new ClickListener() {		
			@Override
			public void buttonClick(ClickEvent event) {
				// TODO Auto-generated method stub

				try {
					control.getRole().insert(txtNewRole.getValue());
					Notification.show("Rol Insertado con Exito!");
				} catch (ErrorConnection e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}					
			}
		});	

		setContent(layoutPrinc);
		btnCancel = new Button("Cancelar");
		btnCancel.setWidth("100px");
		btnCancel.setHeight("50px");
		btnCancel.addClickListener(new Button.ClickListener(){

			@Override
			public void buttonClick(ClickEvent event) {
				// TODO Auto-generated method stub

				navigator.navigateTo(Administrator.NAMEADMINISTRATOR);
			}

		});
		setContent(layoutPrinc);

		layoutPrinc.addComponent(pnlPrincipal);
		pnlPrincipal.setContent(layoutPanel);

		layoutPanel.addComponent(ltlCreateRole);
		layoutPanel.addComponent(ltlNewRole);
		layoutPanel.addComponent(ltlbtnRole);

		ltlCreateRole.addComponent(lblCreateRole);

		ltlNewRole.addComponent(imgNewRole);
		ltlNewRole.addComponent(lblNewRole);
		ltlNewRole.addComponent(txtNewRole);

		ltlbtnRole.addComponent(btnAccept);
		ltlbtnRole.addComponent(btnCancel);
	}
}
