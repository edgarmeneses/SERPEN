package com.serpen.error.connection;
/**
 * Universidad Pedagogica y Tecnologica de Colombia 
 * @author Eliana Ayala
 *         Daniela Blanco 
 *         Diana Gonzalez
 *         Edgar Meneses
 *Clase que se encarga de controlar los errores de coneccion
 */
public class ErrorConnection extends Exception{

	/**
	 * Atributos de la clase Error Coneccion
	 */
	private static final String ERROR_MENSAGGER="Error en la coneccion";

	/**
	 * Constructor de la clase Error Coneccion
	 */
	public ErrorConnection() {
		// TODO Auto-generated constructor stub
		super(ERROR_MENSAGGER);
	}

	/**
	 * Constructor que por parametro pide el mensaje de error
	 * @param mensagger
	 */
	public ErrorConnection(String mensagger){
		super(mensagger);		
	}
}
