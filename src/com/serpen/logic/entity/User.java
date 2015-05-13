package com.serpen.logic.entity;
/**
 * Universidad Pedagogica y Tecnologica de Colombia 
 * @author Eliana Ayala
 *         Daniela Blanco 
 *         Diana Gonzalez
 *         Edgar Meneses
 *Clase  que contiene las caracteristicas de un Usuario
 *
 */
public class User {

	/**
	 * Atributos de la clase usuario
	 */
	private int nickname;
	private String password;
	private String answer;
	private Role rol;
	private char  estado;


	public static final char TIPO_ESTADO_ACTIVO = 'A';
	/**
	 * Constructor vacio de la clase Usuario
	 */
	public User() {
		rol = new Role();

	}
	public char getEstado() {
		return estado;
	}
	public void setEstado(char estado) {
		this.estado = estado;
	}


	/**
	 * Constructor de la clase usuario que por parametro pide
	 * @param nickname
	 * @param password
	 * @param answer
	 * @param rol
	 * @param estado
	 */
	public User(int nickname, String password, String answer,
			Role rol, char estado) {
		this.nickname = nickname;
		this.password = password;
		this.answer = answer;
		this.rol = rol;
		this.estado = estado;
	}

	/**
	 * Getters y Setters de la clase Role 
	 * @return
	 */
	public Role getRol() {
		return rol;
	}

	public void setRol(Role rol) {
		this.rol = rol;
	}
	public int getNickname() {
		return nickname;
	}

	public void setNickname(int nickname) {
		this.nickname = nickname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	/**
	 * To String de la clase User
	 */
	public String getstate(){
		if(estado == 'A'){

			return "Activo";
		}else{
			return "Inactive";
		}

	}
	@Override
	public String toString() {
		return "User [nickname=" + nickname + ", password=" + password
				+ ", PreguntaSeguridad=" + answer + ", rol=" + rol
				+ ", estado=" + estado + "]";
	}

	


}
