package pk1.controller;

import java.util.LinkedHashMap;

import pk1.controller.ApplicationController;
import pk1.controller.ApplicationControllerInt;
import pk1.controller.FrontControllerInterface;

public class FrontController implements FrontControllerInterface {

	/**
	 * Variabile s'istanza della classe {@link ApplicationController}
	 */
	private ApplicationControllerInt ac;

	/**
	 * Costruisce un istanza di questa classe
	 */
	public FrontController() {
		ac = new ApplicationController();
	}

	/**
	 * Accoglie la richiesta e la invia al giusto dispatcher
	 * 
	 * @param request
	 *            la richiesta letta
	 */
	public void processRequest(String request) {

		ac.dispatchRequest(request);
	}

	/**
	 * Accoglie la richiesta e la invia al giusto gestore per ottenere dati di
	 * ritorno
	 * 
	 * @param key
	 *            la richiesta letta
	 * @param p
	 *            i dati da gestire
	 * @return la risposta alla richiesta
	 */
	public Object processRequest(String key, LinkedHashMap<String, Object> p) {
		return ac.handleRequest(key, p);

	}
}