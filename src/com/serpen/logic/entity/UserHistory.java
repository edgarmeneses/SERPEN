package com.serpen.logic.entity;

/**
 * Universidad Pedagogica y Tecnologica de Colombia 
 * @author Eliana Ayala
 *         Daniela Blanco 
 *         Diana Gonzalez
 *         Edgar Meneses
 *Clase  que contiene las caracteristicas de un Historial 
 *de usuario
 *
 */
public class UserHistory {
	/**
	 * Atributos de la clase user History
	 */
	private int id;
	private int nickname;
	private char estado;
	private int  rol;	

	public static final char TIPO_ESTADO_INACTIVO= 'I'; 

	/**
	 * Constructor vacio de la clase rol
	 */
	public UserHistory() {

	}
	/**
	 * Constructor de la clase Historial user
	 * @param id
	 * @param nickname
	 * @param estado
	 * @param rol
	 */
	public UserHistory(int id, int nickname, char estado, int rol) {
		super();
		this.id = id;
		this.nickname = nickname;
		this.estado = estado;
		this.rol = rol;
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
	public int getNickname() {
		return nickname;
	}
	public void setNickname(int nickname) {
		this.nickname = nickname;
	}
	public char getEstado() {
		return estado;
	}
	public void setEstado(char estado) {
		this.estado = estado;
	}
	public int getRol() {
		return rol;
	}
	public void setRol(int rol) {
		this.rol = rol;
	}
	/**
	 * To String de la clase  historial de  usuario
	 */
	@Override
	public String toString() {
		return "UserHistory [id=" + id + ", nickname=" + nickname + ", estado="
				+ estado + ", rol=" + rol + "]";
	}









}
