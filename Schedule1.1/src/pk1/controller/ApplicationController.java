package pk1.controller;

import java.util.LinkedHashMap;
import java.util.List;

import business.entity.BO;
import business.entity.Corso;
import business.entity.Docente;
import business.entity.Identificato;
import business.entity.Insegnamento;
import business.entity.Orario;
import dao.Dao;
import dao.DaoCorso;
import dao.DaoIdentificato;
import dao.DaoInsegnamento;
import dao.DaoOrario;
import dao.DaoPrenotazione;

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
	// private ViewDispatcher view;

	/**
	 * Istanza della classe {@link GestioneLogin}
	 */
	// private GestioneLogin login;

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

	public void dispatchRequest(String request) {
		// TODO Auto-generated method stub

	}

	/**
	 * Cotruisce un istanza di questa classe
	 */
	/*
	 * public ApplicationController() { login = new GestioneLogin(); view = new
	 * ViewDispatcher(); cliente = new GestioneCliente(); vettura = new
	 * GestioneVettura(); agenzia = new GestioneAgenzia(); prenotazione = new
	 * GestionePrenotazione(); fascia = new GestioneFascia(); amministratore =
	 * new GestioneAmministratore(); contratto = new GestioneContratto(); gap =
	 * new GestioneAgenzieDiPrenotazioni(); }
	 * 
	 * /** Gestitsce le richieste che gli vengono passate dal front controller
	 * 
	 * @param request la richiesta da soddisfare
	 *
	 * public void dispatchRequest(String request) {
	 * 
	 * switch (request) {
	 * 
	 * case "logout" : view.setInterface(LOGIN, Login.getStage()); break; case
	 * "accessoCliente": view.setInterface(PANNELLO_CLIENTE, Login.getStage());
	 * break; case "accessoAmministratore":
	 * view.setInterface(PANNELLO_AMMINISTRATORE, Login.getStage()); break; case
	 * "cliente": if (Login.getStato().equalsIgnoreCase("registrazione")) {
	 * view.setInterface(CLIENTE, Login.getStage()); } else {
	 * view.setPane(CLIENTE); } break;
	 * 
	 * case "visualizzaPrenotazioni": view.setPane(ELENCO_PRENOTAZIONI); break;
	 * case "visualizzaContratti": view.setPane(CONTRATTI); break; case
	 * "visualizzaGarage": view.setPane(GARAGE); break; case
	 * "visualizzaAgenzia": view.setPane(AGENZIE); break; case "about":
	 * view.setPane(ABOUT); break; case "elencoVetture":
	 * view.setPane(ELENCO_VETTURE); break; case "cercaUtente":
	 * view.setPane(CERCA_UTENTE); break; case "cercaVettura":
	 * view.setPane(CERCA_VETTURA); break; case "vettura":
	 * view.setPane(VETTURA); break; case "cercaAgenzia":
	 * view.setPane(CERCA_AGENZIA); break; case "agenzia":
	 * view.setPane(AGENZIA); break; case "cercaContratto":
	 * view.setPane(CERCA_CONTRATTO); break; case "contratto":
	 * view.setPane(VISUALIZZA_CONTRATTO); break; case "apriContratto":
	 * view.setPane(APRI_CONTRATTO); break; case "chiudiContratto":
	 * view.setPane(CHIUDI_CONTRATTO); break; case "cercaPrenotazione":
	 * view.setPane(CERCA_PRENOTAZIONE); break; case "prenotazione":
	 * view.setPane(PRENOTAZIONE); break; case "cercaFascia":
	 * view.setPane(CERCA_FASCIA); break; case "fascia": view.setPane(FASCIA);
	 * break; case "cercaAmministratore": view.setPane(CERCA_AMMINISTRATORE);
	 * break; case "amministratore": view.setPane(AMMINISTRATORE); break;
	 * default: break; } }
	 * 
	 * /** Gestisce le richieste di dati che gli vengono passati dal front
	 * controller
	 * 
	 * @param key la richiesta
	 * 
	 * @param p i dati da elaborare
	 * 
	 * @return la risposta alla richiesta
	 */
	public Object handleRequest(String key, LinkedHashMap<String, Object> p) {
		Dao dao = new Dao();
		dao.getInstance();
		DaoCorso daocorsi = new DaoCorso();
		DaoPrenotazione daoprenotazione = new DaoPrenotazione();
		DaoInsegnamento daoinsegnamento = new DaoInsegnamento();
		DaoIdentificato daoidentificato = new DaoIdentificato();
		DaoOrario daoorario = new DaoOrario();
		Object result = null;
		int tipo = -1;

		switch (key) {

		case "VisualizzaInsegnamento":
			result = daocorsi.readTuttiCorsi(new Corso(p.get("corsoLaurea").toString()));
			break;

		case "VisualizzaInsegnamentoConNomeCorso":
			result = daoinsegnamento
					.readImseCor(new Insegnamento(p.get("nome").toString(), p.get("corsoLaurea").toString()));
			break;

		case "UpdateInsegnamento":
			result = daoinsegnamento
					.update(new Insegnamento(p.get("nome").toString(), p.get("corsoLaurea").toString()));
			break;

		case "VisualizzaAssociaDoc":
			result = daoidentificato.read(new Identificato(p.get("login").toString(), p.get("password").toString()));
			break;

		case "VisualizzaOrari":
			result = daoorario.readOrario(new Orario(p.get("CorsoLaurea").toString(), p.get("NomeInsegn").toString()));
			break;

		case "VisualizzaOrariCorso":
			
			result = daoorario.readOraAssocDoc(p);
			break;

		default:
			break;
		}
		return result;
	}

}
