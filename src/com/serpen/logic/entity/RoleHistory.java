package com.serpen.logic.entity;
/**
 * Universidad Pedagogica y Tecnologica de Colombia 
 * @author Eliana Ayala
 *         Daniela Blanco 
 *         Diana Gonzalez
 *         Edgar Meneses
 *Clase  que contiene las caracteristicas de un historial rol
 *
 */
public class RoleHistory {

	/**
	 * Atributos de la clase historial rol
	 */
	private int id;
	private int role;
	private String name;

	/**
	 * Constructor vacio de la clase historial rol
	 */
	public RoleHistory() {

	}
	/**
	 * Constructor de la clase Historial rol que pide por parametro
	 * @param id
	 * @param name
	 */
	public RoleHistory(int id, int role, String name) {
		this.id = id;
		this.role = role;
		this.name = name;
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
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "RoleHistory [id=" + id + ", role=" + role + ", name=" + name
				+ "]";
	}
}
