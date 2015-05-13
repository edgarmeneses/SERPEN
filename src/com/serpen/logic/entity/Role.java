package com.serpen.logic.entity;
/**
 * Universidad Pedagogica y Tecnologica de Colombia 
 * @author Eliana Ayala
 *         Daniela Blanco 
 *         Diana Gonzalez
 *         Edgar Meneses
 *Clase  que contiene las caracteristicas de un rol
 *
 */
public class Role {

	/**
	 * Atributos de la clase role
	 */
	private int id;
	private String name;
	/**
	 * Constructor vacio de la clase rol
	 */
	public Role() {
	}

	/**
	 * Constructor de la clase rol que pide por parametro
	 * @param id
	 * @param name
	 */
	public Role(int id, String name) {
		this.id=id;
		this.name=name;
	}
	/**
	 * Getters y Setters de la clase Role 
	 * @return
	 */
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Override
	/**
	 * To String de la clase Rol
	 */
	public String toString() {
		return "Role [id=" + id + ", name=" + name + "]";
	}	
}
