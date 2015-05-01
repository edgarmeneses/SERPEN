package com.serpen.interfaces;


import com.serpen.logic.entity.User;
import com.serpen.persistence.control.ControlGeneral;
import com.vaadin.event.MouseEvents.ClickEvent;
import com.vaadin.event.MouseEvents.ClickListener;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Panel;

public class PanelAdministrator extends Panel{

//
//	public static final String NAMEPANELA="Administrador";
	private Image Imglogo;
	private Panel pnlOption;
	private Image ImgnewUser;
	private Image imgList;
	private Image imgEdit;
	private Image imgConfig;
	private Image imgNewRol;
	private Image imgRol;
	private Navigator navigator;
	private User user;
	private ControlGeneral control;
	public PanelAdministrator (Navigator navigator, User user, ControlGeneral control){

		this.navigator=navigator;
		this.control= control;
		
		FormLayout layoutPrincipal = new FormLayout();
		layoutPrincipal.setSizeFull();
		layoutPrincipal.setVisible(true);



		FormLayout layoutPanel = new FormLayout();
		layoutPanel.setSizeFull();
		layoutPanel.setVisible(true);

		pnlOption = new  Panel();
		pnlOption.setSizeFull();
		pnlOption.setWidth("200px");
		pnlOption.setHeight("500px");

		this.Imglogo = new Image("LOGO");
		ThemeResource resource = new ThemeResource("../Imagen/logo.jpg");
		Imglogo =new Image (null, resource);
		this.Imglogo.setVisible(true);

		this.ImgnewUser = new Image("Crear");
		ThemeResource resource1 = new ThemeResource("../Imagen/crear.png");
		ImgnewUser =new Image (null, resource1);
		ImgnewUser.addClickListener(new ClickListener() {
			
			@Override
			public void click(ClickEvent event) {
				// TODO Auto-generated method stub
				navigator.addView(CreateUser.NAMECREATE, new CreateUser(navigator,user,control));
				navigator.navigateTo(CreateUser.NAMECREATE);
			}
		});

		this.ImgnewUser.setVisible(true);

		this.imgList= new Image("Listar");
		ThemeResource resource2 = new ThemeResource("../Imagen/buscar.png");
		imgList =new Image (null, resource2);
		this.imgList.setVisible(true);
		imgList.addClickListener(new ClickListener() {
			
			@Override
			public void click(ClickEvent event) {
				// TODO Auto-generated method stub
				navigator.addView(List.NAMELIST, new List(navigator, user,control));
				navigator.navigateTo(List.NAMELIST);
			}
		});
		

		this.imgEdit= new Image("Editar");
		ThemeResource resource3 = new ThemeResource("../Imagen/editar.png");
		imgEdit =new Image (null, resource3);
		this.imgEdit.setVisible(true);
		imgEdit.addClickListener(new ClickListener(){

			@Override
			public void click(ClickEvent event) {
				// TODO Auto-generated method stub
				navigator.addView(EditUsers.NAMEEDIT, new EditUsers(navigator, user,control));
				navigator.navigateTo(EditUsers.NAMEEDIT);
				System.out.println("hhhhh");
			}
			
		});
		
		this.imgNewRol = new Image("Rol");
	    ThemeResource resource5 = new ThemeResource("../Imagen/role.png");
	    imgNewRol= new Image(null, resource5);
	    this.imgNewRol.setVisible(true);
	    imgNewRol.setWidth("50px");
	    imgNewRol.setHeight("50px");
	    imgNewRol.addClickListener(new ClickListener(){

			@Override
			public void click(ClickEvent event) {
				// TODO Auto-generated method stub
				navigator.addView(CreateRol.NAMECREATEROLE, new CreateRol(navigator, user, control));
				navigator.navigateTo(CreateRol.NAMECREATEROLE);
			}
	    	
	    });
	    
		this.imgConfig= new Image("Configuracion");
		ThemeResource resource4 = new ThemeResource("../Imagen/configuracion.png");
		imgConfig =new Image (null, resource4);
		this.imgConfig.setVisible(true);
		this.imgConfig.setWidth("50px");
		this.imgConfig.setHeight("50px");
		imgConfig.addClickListener(new ClickListener(){

			@Override
			public void click(ClickEvent event) {
				// TODO Auto-generated method stub
				navigator.addView(Configuration.NAMECONFIGURATION, new Configuration(navigator,user,control));
				navigator.navigateTo(Configuration.NAMECONFIGURATION);
				System.out.println("hhhhh");
			}
			
		});
		

		this.imgRol = new Image("Rol");
		ThemeResource resource6 = new ThemeResource("../Imagen/rol.png");
		imgRol = new Image(null , resource6);
		this.imgRol.setVisible(true);
		this.imgRol.setWidth("50px");
		this.imgRol.setHeight("50px");
		imgRol.addClickListener(new ClickListener(){

			@Override
			public void click(ClickEvent event) {
				// TODO Auto-generated method stub
				navigator.addView(ListRol.NAMELISTROLE, new ListRol(navigator, user, control));
				navigator.navigateTo(ListRol.NAMELISTROLE);
			}
			
		});


		layoutPrincipal.addComponent(Imglogo);
		layoutPrincipal.addComponent(pnlOption);	

		layoutPanel.addComponent(ImgnewUser);
		layoutPanel.addComponent(imgList);
		layoutPanel.addComponent(imgEdit);
		layoutPanel.addComponent(imgNewRol);
		layoutPanel.addComponent(imgConfig);
		layoutPanel.addComponent(imgRol);

		this.pnlOption.setContent(layoutPanel);	
		//this.setCompositionRoot(layoutPrincipal);
		setContent(layoutPrincipal);

	}

}