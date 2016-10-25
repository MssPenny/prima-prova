package pk1.controller;
import java.util.LinkedHashMap;
public interface FrontControllerInterface {
	/**
	 * Setta il nuovo pannello richiesto
	 * 
	 * @param request
	 * 			la richiesta identificativa del pannello
	 */
	public void processRequest(String request);
	
	/**
	 * Elabora richieste di dati
	 * 
	 * @param key chiave identificante la richiesta da processare
	 * @param p i dati da elaborare
	 * @return
	 * 		il risultato del richiesta processata
	 */
	public Object processRequest(String key, LinkedHashMap<String, Object> p);

}
