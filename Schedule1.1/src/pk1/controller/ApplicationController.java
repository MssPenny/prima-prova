package pk1.controller;

import java.util.LinkedHashMap;
import business.entity.Docente;


/**
 * Classe chiamata dal front controller per gestire tutte le richieste delle
 * varie interfacce
 *
 */
public class ApplicationController implements ApplicationControllerInt{

	/**
	 * Istanza della classe {@link Docente}
	 */
	private ServiceInterface docente;
	
	/**
	 * Istanza della classe {@link ViewDispatcher}
	 */
//	private ViewDispatcher view;
	
	/**
	 * Istanza della classe {@link GestioneLogin}
	 */
//	private GestioneLogin login;
	
	/**
	 * Istanza della classe {@link GestioneVettura}
	 */
	private ServiceInterface vettura;
	
	/**
	 * Istanza della classe {@link GestioneAgenzia}
	 */
	private ServiceInterface agenzia;
	
	/**
	 * Istanza della classe {@link GestionePrenotazione}
	 */
	private ServiceInterface prenotazione;
	
	/**
	 * Istanza della classe {@link GestioneFascia}
	 */
	private ServiceInterface fascia;
	
	/**
	 * Istanza della classe {@link GestioneAmministratore}
	 */
	private ServiceInterface amministratore;
	
	/**
	 * Istanza della classe {@link GestioneContratto}
	 */
	private ServiceInterface contratto;
	
	/**
	 * Istanza della classe {@link GestioneAgenzieDiPrenotazioni}
	 */
	private ServiceInterface gap;

	/**
	 * Costante del path della schermata cliente 
	 */
	final static String CLIENTE = "schermate/Cliente.fxml";
	
	/**
	 * Costante del path della schermata pannello cliente 
	 */
	final static String PANNELLO_CLIENTE = "schermate/PannelloCliente.fxml";
	
	/**
	 * Costante del path della schermata pannello amministratore 
	 */
	final static String PANNELLO_AMMINISTRATORE = "schermate/PannelloAmministratore.fxml";
	
	/**
	 * Costante del path della schermata login 
	 */
	final static String LOGIN = "schermate/Login.fxml";
	
	/**
	 * Costante del path della schermata elenco prenotazioni 
	 */
	final static String ELENCO_PRENOTAZIONI = "schermate/ElencoPrenotazioni.fxml";
	
	/**
	 * Costante del path della schermata elenco contratti 
	 */
	final static String CONTRATTI = "schermate/ElencoContratti.fxml";
	
	/**
	 * Costante del path della schermata elenco agenzie 
	 */
	final static String AGENZIE = "schermate/ElencoAgenzie.fxml";
	
	/**
	 * Costante del path della schermata garage 
	 */
	final static String GARAGE = "schermate/Garage.fxml";
	
	/**
	 * Costante del path della schermata about 
	 */
	final static String ABOUT = "schermate/About.fxml";
	
	/**
	 * Costante del path della schermata elenco vetture 
	 */
	final static String ELENCO_VETTURE = "schermate/ElencoVetture.fxml";
	
	/**
	 * Costante del path della schermata cerca utente 
	 */
	final static String CERCA_UTENTE = "schermate/CercaUtente.fxml";
	
	/**
	 * Costante del path della schermata cerca vettura 
	 */
	final static String CERCA_VETTURA = "schermate/CercaVettura.fxml";
	
	/**
	 * Costante del path della schermata cerca agenzia 
	 */
	final static String CERCA_AGENZIA = "schermate/CercaAgenzia.fxml";
	
	/**
	 * Costante del path della schermata cerca contratto 
	 */
	final static String CERCA_CONTRATTO = "schermate/CercaContratto.fxml";
	
	/**
	 * Costante del path della schermata visualizza contratto 
	 */
	final static String VISUALIZZA_CONTRATTO = "schermate/VisualizzaContratto.fxml";
	
	/**
	 * Costante del path della schermata cerca prenotazione 
	 */
	final static String CERCA_PRENOTAZIONE = "schermate/CercaPrenotazione.fxml";
	
	/**
	 * Costante del path della schermata cerca amministratore 
	 */
	final static String CERCA_AMMINISTRATORE = "schermate/CercaAmministratore.fxml";
	
	/**
	 * Costante del path della schermata amministratore 
	 */
	final static String AMMINISTRATORE = "schermate/Amministratore.fxml";
	
	/**
	 * Costante del path della schermata prenotazione 
	 */
	final static String PRENOTAZIONE = "schermate/Prenotazione.fxml";
	
	/**
	 * Costante del path della schermata cerca fascia 
	 */
	final static String CERCA_FASCIA = "schermate/CercaFascia.fxml";
	
	/**
	 * Costante del path della schermata vettura 
	 */
	final static String VETTURA = "schermate/Vettura.fxml";
	
	/**
	 * Costante del path della schermata agenzia 
	 */
	final static String AGENZIA = "schermate/Agenzia.fxml";
	
	/**
	 * Costante del path della schermata apri contratto 
	 */
	final static String APRI_CONTRATTO = "schermate/ApriContratto.fxml";
	
	/**
	 * Costante del path della schermata chiudi contratto 
	 */
	final static String CHIUDI_CONTRATTO = "schermate/ChiudiContratto.fxml";
	
	/**
	 * Costante del path della schermata fascia 
	 */
	final static String FASCIA = "schermate/Fascia.fxml";

	@Override
	public void dispatchRequest(String request) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object handleRequest(String key, LinkedHashMap<String, Object> p) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Cotruisce un istanza di questa classe
	 */
	/*
	public ApplicationController() {
		login = new GestioneLogin();
		view = new ViewDispatcher();
		cliente = new GestioneCliente();
		vettura = new GestioneVettura();
		agenzia = new GestioneAgenzia();
		prenotazione = new GestionePrenotazione();
		fascia = new GestioneFascia();
		amministratore = new GestioneAmministratore();
		contratto = new GestioneContratto();
		gap = new GestioneAgenzieDiPrenotazioni();
	}

	/**
	 * Gestitsce le richieste che gli vengono passate dal front controller
	 * 
	 * @param request
	 *            la richiesta da soddisfare
	 *
	public void dispatchRequest(String request)  {

		switch (request) {

		case "logout" :
			view.setInterface(LOGIN, Login.getStage());
			break;
		case "accessoCliente":
			view.setInterface(PANNELLO_CLIENTE, Login.getStage());
			break;
		case "accessoAmministratore":
			view.setInterface(PANNELLO_AMMINISTRATORE, Login.getStage());
			break;
		case "cliente":
			if (Login.getStato().equalsIgnoreCase("registrazione")) {
				view.setInterface(CLIENTE, Login.getStage());
			} else {
				view.setPane(CLIENTE);
			}
			break;
			
		case "visualizzaPrenotazioni":
			view.setPane(ELENCO_PRENOTAZIONI);
			break;
		case "visualizzaContratti":
			view.setPane(CONTRATTI);
			break;
		case "visualizzaGarage":
			view.setPane(GARAGE);
			break;
		case "visualizzaAgenzia":
			view.setPane(AGENZIE);
			break;
		case "about":
			view.setPane(ABOUT);
			break;
		case "elencoVetture":
			view.setPane(ELENCO_VETTURE);
			break;
		case "cercaUtente":
			view.setPane(CERCA_UTENTE);
			break;
		case "cercaVettura":
			view.setPane(CERCA_VETTURA);
			break;
		case "vettura":
			view.setPane(VETTURA);
			break;
		case "cercaAgenzia":
			view.setPane(CERCA_AGENZIA);
			break;
		case "agenzia":
			view.setPane(AGENZIA);
			break;
		case "cercaContratto":
			view.setPane(CERCA_CONTRATTO);
			break;
		case "contratto":
			view.setPane(VISUALIZZA_CONTRATTO);
			break;
		case "apriContratto":
			view.setPane(APRI_CONTRATTO);
			break;
		case "chiudiContratto":
			view.setPane(CHIUDI_CONTRATTO);
			break;
		case "cercaPrenotazione":
			view.setPane(CERCA_PRENOTAZIONE);
			break;
		case "prenotazione":
			view.setPane(PRENOTAZIONE);
			break;
		case "cercaFascia":
			view.setPane(CERCA_FASCIA);
			break;
		case "fascia":
			view.setPane(FASCIA);
			break;
		case "cercaAmministratore":
			view.setPane(CERCA_AMMINISTRATORE);
			break;
		case "amministratore":
			view.setPane(AMMINISTRATORE);
			break;
		default:
			break;
		}
	}

	/**
	 * Gestisce le richieste di dati che gli vengono passati dal front controller
	 * @param key
	 * 		la richiesta
	 * @param p
	 * 		i dati da elaborare
	 * @return
	 * 		la risposta alla richiesta
	 *
	public Object handleRequest(String key, LinkedHashMap<String, Object> p)
			  {
		Object result = null;
		int tipo = -1;

		switch (key) {

		case "login":
			tipo = login.login(p);
			Login.setAmmCliente(tipo);
			if (tipo == 1) {
				result = cliente.visualizza("%", p.get("username"));
			}
			break;
		case "registra":
			result = cliente.aggiungi(p);
			break;
		case "modificaCliente":
			result = cliente.modifica(p);
			break;
		case "eliminaCliente":
			cliente.elimina(p);
			break;
		case "cercaCliente":
			result = cliente.visualizza(p.get("codFis"), p.get("username"));
			break;
		case "cercaAgenzia":
			result = agenzia.visualizza(p.get("CodiceAgenzia"), p.get("PartitaIva"));
			break;
		case "aggiungiAgenzia":
			result = agenzia.aggiungi(p);
			break;
		case "modificaAgenzia":
			result = agenzia.modifica(p);
			break;
		case "eliminaAgenzia":
			agenzia.elimina((int) p.get("codiceAgenzia"));
			break;
		case "cercaFascia":
			result = fascia.visualizza(p.get("nomeFascia"), null);
			break;
		case "aggiungiFascia":
			result = fascia.aggiungi(p);
			break;
		case "modificaFascia":
			fascia.modifica(p);
			break;
		case "eliminaFascia":
			fascia.elimina((String) p.get("nomeFascia"));
			break;
		case "cercaPrenotazione":  
			result = prenotazione.visualizza(p.get("codPrenotazion"), p.get("codFisc"));
			break;
		case "eliminaPrenotazione":  
			prenotazione.elimina((int) p.get("codPrenotazione"));
			break;
		case "inserisciPrenotazione":
			prenotazione.aggiungi(p);
			break;
		case "inserisciAP":
			gap.aggiungi(p);
			break;
		case "visualizzaVettura":
			result = vettura.visualizza(p.get("targa"), null);
			break;
		case "elimVettura":
			vettura.elimina((String) p.get("targa"));
			break;
		case "registraVettura":
			result = vettura.aggiungi(p);
			break;
		case "modVettura":
			vettura.modifica(p);
			break;
		case "listaVettureGarage":
			result = vettura.getBusinessObjects((String) p.get("fasciaSelezionata"));
			break;
		case "cercaAmministratore":
			result = amministratore.visualizza(p.get("codice"), p.get("username"));
			break;
		case "aggiungiAmm":
			result = amministratore.aggiungi(p);
			break;
		case "eliminaAmm":
			amministratore.elimina((String) p.get("codice"));
			break;
		case "modificaAmm":
			result = amministratore.modifica(p);
			break;
		case "aperturaContratto":
			contratto.aggiungi(p);
			break;
		case "chiusuraContratto" :
			contratto.modifica(p);
			break;
		case "cercaContratto" :
			result = contratto.visualizza(p.get("codContratto"), p.get("codFisc"));
			break;
		case "parcoVetture" :
			 result = ((GestioneVettura) vettura).parcoVetture();
			break;
		case "elencoContratti" :
			result = contratto.getBusinessObjects((String) p.get("codFisc"));
			break;
		case "elencoPrenotazioni" : 
			result = prenotazione.getBusinessObjects((String) p.get("codFisc"));
			break;
		case "elencoAgenzie":
			result = agenzia.getBusinessObjects(null);
			break;
		case "fasceAuto" :
			result = fascia.getName(null);
		default:
			break;
		}
		return result;
	}
	*/

}
