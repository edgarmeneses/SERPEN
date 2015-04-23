package com.serpen.interfaces;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Panel;

public class A extends CustomComponent implements View{
	
	private Image Imglogo;
	private Panel pnlOption;
	private Image ImgnewUser;
	private Image imgList;
	private Image imgEdit;
	private Image imgConfig;
	
	private Navigator navigator;
	public static final String name5 ="Crear usuario";
	
	public A() {
		// TODO Auto-generated constructor stub
		this.navigator=navigator;
		FormLayout layoutPrincipal = new FormLayout();
		layoutPrincipal.setSizeFull();
		layoutPrincipal.setVisible(true);
		
		
	
		FormLayout layoutPanel = new FormLayout();
		layoutPanel.setSizeFull();
		layoutPanel.setVisible(true);
		
		pnlOption = new  Panel();
		pnlOption.setSizeFull();
		pnlOption.setWidth("200px");
		pnlOption.setHeight("300px");
	
		this.Imglogo = new Image("LOGO");
		ThemeResource resource = new ThemeResource("../Imagen/logo.jpg");
		Imglogo =new Image (null, resource);
		this.Imglogo.setVisible(true);
		
		this.ImgnewUser = new Image("User");
		ThemeResource resource1 = new ThemeResource("../Imagen/crear.png");
		ImgnewUser =new Image (null, resource1);
		//ImgnewUser.addClickListener(this);
		
		this.ImgnewUser.setVisible(true);
		
		this.imgList= new Image("User");
		ThemeResource resource2 = new ThemeResource("../Imagen/buscar.png");
		imgList =new Image (null, resource2);
		this.imgList.setVisible(true);
		
		this.imgEdit= new Image("User");
		ThemeResource resource3 = new ThemeResource("../Imagen/editar.png");
		imgEdit =new Image (null, resource3);
		this.imgEdit.setVisible(true);
		
		this.imgConfig= new Image("Configuracion");
		ThemeResource resource4 = new ThemeResource("../Imagen/configuracion.png");
		imgConfig =new Image (null, resource4);
		this.imgConfig.setVisible(true);
		this.imgConfig.setWidth("50px");
		this.imgConfig.setHeight("50px");
		
		
		layoutPrincipal.addComponent(Imglogo);
		layoutPrincipal.addComponent(pnlOption);	
		
		layoutPanel.addComponent(ImgnewUser);
		layoutPanel.addComponent(imgList);
		layoutPanel.addComponent(imgEdit);
		layoutPanel.addComponent(imgConfig);
		
		this.pnlOption.setContent(layoutPanel);	
		this.setCompositionRoot(layoutPrincipal);
		
		this.setSizeFull();
	}


	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}
	

}
