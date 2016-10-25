package pk1.controller;

import java.util.LinkedHashMap;

/**
 * Interfaccia dall'ApplicationController implementata nell'apposita classe
 */
public interface ApplicationControllerInt {
	
	/**
	 * Setta il nuovo pannello richiesto
	 * 
	 * @param request
	 * 			la richiesta identificativa del pannello
	 */
	public void dispatchRequest(String request);
	
	/**
	 * Elabora richieste di dati
	 * 
	 * @param key chiave identificante la richiesta da processare
	 * @param p i dati da elaborare
	 * @return
	 * 		la risposta alla richiesta
	 */
	public Object handleRequest(String key, LinkedHashMap<String, Object> p);
}
