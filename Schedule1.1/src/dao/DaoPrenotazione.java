package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import business.entity.BO;
import business.entity.Insegnamento;
import business.entity.Prenotazione;
import dao.Dao;

public class DaoPrenotazione extends DaoService implements DaoInterface {

	String QUERY_INSERIMENTO_PRENOTAZIONE = "INSERT INTO `schedule_dib`.`prenota_aula` (`Corso_laurea`, `Nome_insegn`, `Data`, `Ora_inizio`, `Ora_fine`, `Aula`, `Npiano`, `Tipologia`, `Note`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	String QUERY_ELIMINA_PRENOTAZIONE = "DELETE FROM `schedule_dib`.`prenota_aula` WHERE `prenota_aula`.`Data`=? AND `prenota_aula`.`Ora_inizio`=? AND `prenota_aula`.`Ora_fine`=? AND `prenota_aula`.`Aula`=? AND `prenota_aula`.`Npiano`=? ";
	String QUERY_UPDATE_PRENOTAZIONE = "UPDATE `schedule_dib`.`prenota_aula` SET `Corso_laurea`=?, `Nome_insegn`=?, `Data`=?, `Ora_inizio`=?, `Ora_fine`=?, `Aula`=?, `Npiano`=?, `Tipologia`=?, `Note`=?  WHERE `Nome_insegn` = ? ;";

	// Visualizza una specifica prenotazione, utilizando nella condizione le
	// chiavi primarie
	String SELECT_PRENOTAZIONE = "SELECT `Corso_laurea`, `Nome_insegn`, `Data`, `Ora_inizio`, `Ora_fine`, `Aula`, `Npiano`, `Tipologia`, `Note` FROM `schedule_dib`.`prenota_aula`  WHERE `prenota_aula`.`Data`=? AND `prenota_aula`.`Ora_inizio`=? AND `prenota_aula`.`Ora_fine`=? AND `prenota_aula`.`Aula`=? AND `prenota_aula`.`Npiano`=? ";

	// Tutte le prenotazioni di un determinato corso di laurea scelto
	String SELECT_CORSODILAUREA = "SELECT * FROM `schedule_dib`.`prenota_aula` WHERE `Corso_laurea` = ?  ORDER BY `Data` ASC ";

	// Tutte le prenotazioni di un determinato insegnamento scelto
	String SELECT_NOMEINSEGN = "SELECT * FROM `schedule_dib`.`prenota_aula` WHERE `Nome_insegn` = ? ORDER BY `Data` ASC ";

	// Tutte le prenotazioni del giorno ordinate per l'ora di inizio
	String SELECT_PRENOTAZIONIDIOGGIORDER = "SELECT * FROM `schedule_dib`.`prenota_aula` WHERE `Data` LIKE CURRENT_DATE ORDER BY `Ora_inizio` ASC ";
	// Tutte le prenotazioni del giorno, in mattinata
	String SELECT_PRENOTAZIONIDIOGGIMATTINA = "SELECT * FROM `schedule_dib`.`prenota_aula` WHERE `Data` LIKE CURRENT_DATE AND `Ora_inizio`<'11:59:59' ORDER BY `Ora_inizio` ASC";
	// Tutte le prenotazioni del giorno , nel pomeriggio
	String SELECT_PRENOTAZIONIDIOGGIPOMERIGGIO = "SELECT * FROM `schedule_dib`.`prenota_aula` WHERE `Data` LIKE CURRENT_DATE AND `Ora_inizio`>'11:59:59' ORDER BY `Ora_inizio` ASC";

	// Tutte le prenotazioni in una specifica aula per la data odierna, ordinate
	// per ora inizio
	String SELECT_PRENOTAZIONIOGGIAULA = "SELECT `Nome_insegn`, `Aula` FROM `schedule_dib`.`prenota_aula` WHERE `Aula`= ? AND `Data` LIKE CURRENT_DATE ORDER BY `Ora_inizio` ASC";

	//Tutte le prenotazioni della settimana nelle aule
	String SELECT_PRENOTAZIONISETTAULA = "SELECT DISTINCT * FROM `schedule_dib`.`prenota_aula` WHERE `Tipologia`='Aula' AND `Data` BETWEEN CURRENT_DATE AND CURRENT_DATE +6 ORDER BY `Data`,`Ora_inizio` ASC";
	//Tutte le prenotazioni della settimana nel laboratorio 
	String SELECT_PRENOTAZIONISETTLAB = "SELECT DISTINCT * FROM `schedule_dib`.`prenota_aula` WHERE `Tipologia`='Laboratorio' AND `Data` BETWEEN CURRENT_DATE AND CURRENT_DATE +6 ORDER BY `Data`,`Ora_inizio` ASC";

	
	Dao dao;

	public DaoPrenotazione() {
		dao = new Dao();
	}

	@Override
	public boolean create(BO bo) {
		Prenotazione prenotazione = (Prenotazione) bo;

		PreparedStatement inserimentoPrenotazione = null;

		try {
			int index = 1;
			inserimentoPrenotazione = dao.getInstance().prepareStatement(QUERY_INSERIMENTO_PRENOTAZIONE);
			inserimentoPrenotazione = setParameter(inserimentoPrenotazione, prenotazione.getCorsoLaurea(), index++);
			inserimentoPrenotazione = setParameter(inserimentoPrenotazione, prenotazione.getNomeInsegn(), index++);
			inserimentoPrenotazione = setParameter(inserimentoPrenotazione, prenotazione.getData(), index++);
			inserimentoPrenotazione = setParameter(inserimentoPrenotazione, prenotazione.getOraInizio(), index++);
			inserimentoPrenotazione = setParameter(inserimentoPrenotazione, prenotazione.getOraFine(), index++);
			inserimentoPrenotazione = setParameter(inserimentoPrenotazione, prenotazione.getAula(), index++);
			inserimentoPrenotazione = setParameter(inserimentoPrenotazione, prenotazione.getnPiano(), index++);
			inserimentoPrenotazione = setParameter(inserimentoPrenotazione, prenotazione.getTipologia(), index++);
			inserimentoPrenotazione = setParameter(inserimentoPrenotazione, prenotazione.getNote(), index++);
			insertQuery(inserimentoPrenotazione);

		} catch (SQLException e) {

			System.err.println("si e' verificato un errore:\n\n".concat(e.getMessage()));
		}
		return true;
	}

	@Override
	public BO read(BO bo) {

		String corsoLaurea = "";
		String nomeInsegn = "";
		String data = "";
		String oraIniz = "";
		String oraFin = "";
		String aula = "";
		int nPiano;
		String tipologia = "";
		String note = "";
		Prenotazione i = null;
		Prenotazione prenotazione = (Prenotazione) bo;
		PreparedStatement ricercaPre = null;

		try {
			ricercaPre = dao.getInstance().prepareStatement(SELECT_PRENOTAZIONE);
			setParameter(ricercaPre, prenotazione.getAula(), 1);
			setParameter(ricercaPre, prenotazione.getData(), 1);
			setParameter(ricercaPre, prenotazione.getOraInizio(), 1);
			setParameter(ricercaPre, prenotazione.getOraFine(), 1);
			setParameter(ricercaPre, prenotazione.getnPiano(), 1);

			ResultSet resultsRicercaPre = selectQuery(ricercaPre);

			if (resultsRicercaPre.next()) {

				corsoLaurea = resultsRicercaPre.getString("Corso_laurea");
				nomeInsegn = resultsRicercaPre.getString("Nome_insegn");
				data = resultsRicercaPre.getString("Data");
				oraIniz = resultsRicercaPre.getString("Ora_inizio");
				oraFin = resultsRicercaPre.getString("Ora_fine");
				aula = resultsRicercaPre.getString("Aula");
				nPiano = resultsRicercaPre.getInt("Npiano");
				tipologia = resultsRicercaPre.getString("Tipologia");
				note = resultsRicercaPre.getString("Note");

			} else {
				throw new SQLException();
			}

			i = new Prenotazione(corsoLaurea, nomeInsegn, data, oraIniz, oraFin, aula, nPiano, tipologia, note);

		} catch (SQLException e) {
			return null;
		}
		return i;
	}

	@Override
	public boolean update(BO bo) {

		PreparedStatement updatePrenotazione = null;
		Prenotazione prenotazione = (Prenotazione) bo;

		try {

			updatePrenotazione = dao.getInstance().prepareStatement(QUERY_UPDATE_PRENOTAZIONE);

			int index = 1;

			updatePrenotazione = setParameter(updatePrenotazione, prenotazione.getCorsoLaurea(), index++);
			updatePrenotazione = setParameter(updatePrenotazione, prenotazione.getNomeInsegn(), index++);
			updatePrenotazione = setParameter(updatePrenotazione, prenotazione.getData(), index++);
			updatePrenotazione = setParameter(updatePrenotazione, prenotazione.getOraInizio(), index++);
			updatePrenotazione = setParameter(updatePrenotazione, prenotazione.getOraFine(), index++);
			updatePrenotazione = setParameter(updatePrenotazione, prenotazione.getAula(), index++);
			updatePrenotazione = setParameter(updatePrenotazione, prenotazione.getnPiano(), index++);
			updatePrenotazione = setParameter(updatePrenotazione, prenotazione.getTipologia(), index++);
			updatePrenotazione = setParameter(updatePrenotazione, prenotazione.getNote(), index++);

			updateDeleteQuery(updatePrenotazione);

		} catch (SQLException e) {

			return false;
		}
		return true;
	}

	@Override
	public boolean delete(BO bo) {
		Prenotazione prenotazione = (Prenotazione) bo;

		PreparedStatement inserimentoPrenotazione = null;

		try {
			int index = 1;
			inserimentoPrenotazione = dao.getInstance().prepareStatement(QUERY_ELIMINA_PRENOTAZIONE);
			inserimentoPrenotazione = setParameter(inserimentoPrenotazione, prenotazione.getData(), index++);
			inserimentoPrenotazione = setParameter(inserimentoPrenotazione, prenotazione.getOraInizio(), index++);
			inserimentoPrenotazione = setParameter(inserimentoPrenotazione, prenotazione.getOraFine(), index++);
			inserimentoPrenotazione = setParameter(inserimentoPrenotazione, prenotazione.getAula(), index++);
			inserimentoPrenotazione = setParameter(inserimentoPrenotazione, prenotazione.getnPiano(), index++);

			insertQuery(inserimentoPrenotazione);

		} catch (SQLException e) {

			System.err.println("si e' verificato un errore:\n\n".concat(e.getMessage()));
		}
		return true;
	}

	// cerca tutte le prenotazioni ordinate per data crescente di un determinato
	// corso di laurea in input
	public List<BO> searchCorso(String corsolaurea) {
		PreparedStatement query = null;
		List<BO> prenotazioni = new ArrayList<BO>();
		try {
			query = dao.getInstance().prepareStatement(SELECT_CORSODILAUREA);

			setParameter(query, corsolaurea, 1);

			ResultSet result = selectQuery(query);

			while (result.next()) {
				String corsoLaurea = result.getString("Corso_laurea");
				String nomeInsegn = result.getString("Nome_insegn");
				String data = result.getString("Data");
				String oraIniz = result.getString("Ora_inizio");
				String oraFin = result.getString("Ora_fine");
				String aula = result.getString("Aula");
				int nPiano = result.getInt("Npiano");
				String tipologia = result.getString("Tipologia");
				String note = result.getString("Note");

				Prenotazione c = new Prenotazione(corsoLaurea, nomeInsegn, data, oraIniz, oraFin, aula, nPiano,
						tipologia, note);
				prenotazioni.add(c);
			}
		} catch (SQLException e) {
			System.err.println("si e' verificato un errore:\n\n".concat(e.getMessage()));
		}
		return prenotazioni;

	}

	// cerca tutte le prenotazioni ordinate per data crescente di un determinato
	// insegnamento dato in input
	public List<BO> searchInsegn(String nomeinsegn) {
		PreparedStatement query = null;
		List<BO> prenotazioni = new ArrayList<BO>();
		try {
			query = dao.getInstance().prepareStatement(SELECT_NOMEINSEGN);

			setParameter(query, nomeinsegn, 1);

			ResultSet result = selectQuery(query);

			while (result.next()) {
				String corsoLaurea = result.getString("Corso_laurea");
				String nomeInsegn = result.getString("Nome_insegn");
				String data = result.getString("Data");
				String oraIniz = result.getString("Ora_inizio");
				String oraFin = result.getString("Ora_fine");
				String aula = result.getString("Aula");
				int nPiano = result.getInt("Npiano");
				String tipologia = result.getString("Tipologia");
				String note = result.getString("Note");

				Prenotazione c = new Prenotazione(corsoLaurea, nomeInsegn, data, oraIniz, oraFin, aula, nPiano,
						tipologia, note);
				prenotazioni.add(c);
			}
		} catch (SQLException e) {
			System.err.println("si e' verificato un errore:\n\n".concat(e.getMessage()));
		}
		return prenotazioni;

	}

	// ricerca tutte le prenotazioni del giorno ordinate per l'ora di inizio
	public List<Prenotazione> prenotazioniDelGiorno() {
		PreparedStatement query = null;
		List<Prenotazione> prenotazioni = new ArrayList<Prenotazione>();

		try {
			query = dao.getInstance().prepareStatement(SELECT_PRENOTAZIONIDIOGGIORDER);
			ResultSet risultati = selectQuery(query);

			while (risultati.next()) {
				String corsoLaurea = risultati.getString("Corso_laurea");
				String nomeInsegn = risultati.getString("Nome_insegn");
				String data = risultati.getString("Data");
				String oraIniz = risultati.getString("Ora_inizio");
				String oraFin = risultati.getString("Ora_fine");
				String aula = risultati.getString("Aula");
				int nPiano = risultati.getInt("Npiano");
				String tipologia = risultati.getString("Tipologia");
				String note = risultati.getString("Note");

				Prenotazione c = new Prenotazione(corsoLaurea, nomeInsegn, data, oraIniz, oraFin, aula, nPiano,
						tipologia, note);
				prenotazioni.add(c);
			}
		} catch (SQLException e) {
			System.err.println("si e' verificato un errore:\n\n".concat(e.getMessage()));
		}
		return prenotazioni;
	}

	// ricerca tutte le prenotazioni del giorno in mattinata ordinate per l'ora
	// di inizio
	public List<Prenotazione> prenotazioniDelGiornoMatt() {
		PreparedStatement query = null;
		List<Prenotazione> prenotazioni = new ArrayList<Prenotazione>();

		try {
			query = dao.getInstance().prepareStatement(SELECT_PRENOTAZIONIDIOGGIMATTINA);
			ResultSet risultati = selectQuery(query);

			while (risultati.next()) {
				String corsoLaurea = risultati.getString("Corso_laurea");
				String nomeInsegn = risultati.getString("Nome_insegn");
				String data = risultati.getString("Data");
				String oraIniz = risultati.getString("Ora_inizio");
				String oraFin = risultati.getString("Ora_fine");
				String aula = risultati.getString("Aula");
				int nPiano = risultati.getInt("Npiano");
				String tipologia = risultati.getString("Tipologia");
				String note = risultati.getString("Note");

				Prenotazione c = new Prenotazione(corsoLaurea, nomeInsegn, data, oraIniz, oraFin, aula, nPiano,
						tipologia, note);
				prenotazioni.add(c);
			}
		} catch (SQLException e) {
			System.err.println("si e' verificato un errore:\n\n".concat(e.getMessage()));
		}
		return prenotazioni;
	}

	// ricerca tutte le prenotazioni del giorno nel pomeriggio ordinate per
	// l'ora di inizio
	public List<Prenotazione> prenotazioniDelGiornoPom() {
		PreparedStatement query = null;
		List<Prenotazione> prenotazioni = new ArrayList<Prenotazione>();

		try {
			query = dao.getInstance().prepareStatement(SELECT_PRENOTAZIONIDIOGGIPOMERIGGIO);
			ResultSet risultati = selectQuery(query);

			while (risultati.next()) {
				String corsoLaurea = risultati.getString("Corso_laurea");
				String nomeInsegn = risultati.getString("Nome_insegn");
				String data = risultati.getString("Data");
				String oraIniz = risultati.getString("Ora_inizio");
				String oraFin = risultati.getString("Ora_fine");
				String aula = risultati.getString("Aula");
				int nPiano = risultati.getInt("Npiano");
				String tipologia = risultati.getString("Tipologia");
				String note = risultati.getString("Note");

				Prenotazione c = new Prenotazione(corsoLaurea, nomeInsegn, data, oraIniz, oraFin, aula, nPiano,
						tipologia, note);
				prenotazioni.add(c);
			}
		} catch (SQLException e) {
			System.err.println("si e' verificato un errore:\n\n".concat(e.getMessage()));
		}
		return prenotazioni;
	}

	// Tutte le prenotazioni in una specifica aula per oggi, ordinate per ora
	// inizio
	public List<BO> searchAula(String nomeAula) {
		PreparedStatement query = null;
		List<BO> prenotazioni = new ArrayList<BO>();
		try {
			query = dao.getInstance().prepareStatement(SELECT_PRENOTAZIONIOGGIAULA);
			setParameter(query, nomeAula, 1);
			ResultSet result = selectQuery(query);

			while (result.next()) {
				String corsoLaurea = result.getString("Corso_laurea");
				String nomeInsegn = result.getString("Nome_insegn");
				String data = result.getString("Data");
				String oraIniz = result.getString("Ora_inizio");
				String oraFin = result.getString("Ora_fine");
				String aula = result.getString("Aula");
				int nPiano = result.getInt("Npiano");
				String tipologia = result.getString("Tipologia");
				String note = result.getString("Note");

				Prenotazione c = new Prenotazione(corsoLaurea, nomeInsegn, data, oraIniz, oraFin, aula, nPiano,
						tipologia, note);
				prenotazioni.add(c);
			}
		} catch (SQLException e) {
			System.err.println("si e' verificato un errore:\n\n".concat(e.getMessage()));
		}
		return prenotazioni;
	}

	//Tutte le prenotazioni della settimana nelle aule
	public List<Prenotazione> prenotazioniDelSettAul() {
		PreparedStatement query = null;
		List<Prenotazione> prenotazioni = new ArrayList<Prenotazione>();

		try {
			query = dao.getInstance().prepareStatement(SELECT_PRENOTAZIONISETTAULA);
			ResultSet risultati = selectQuery(query);

			while (risultati.next()) {
				String corsoLaurea = risultati.getString("Corso_laurea");
				String nomeInsegn = risultati.getString("Nome_insegn");
				String data = risultati.getString("Data");
				String oraIniz = risultati.getString("Ora_inizio");
				String oraFin = risultati.getString("Ora_fine");
				String aula = risultati.getString("Aula");
				int nPiano = risultati.getInt("Npiano");
				String tipologia = risultati.getString("Tipologia");
				String note = risultati.getString("Note");

				Prenotazione c = new Prenotazione(corsoLaurea, nomeInsegn, data, oraIniz, oraFin, aula, nPiano,
						tipologia, note);
				prenotazioni.add(c);
			}
		} catch (SQLException e) {
			System.err.println("si e' verificato un errore:\n\n".concat(e.getMessage()));
		}
		return prenotazioni;
	}
	
	//Tutte le prenotazioni della settimana nel laboratorio 
	public List<Prenotazione> prenotazioniDelSettLab() {
		PreparedStatement query = null;
		List<Prenotazione> prenotazioni = new ArrayList<Prenotazione>();

		try {
			query = dao.getInstance().prepareStatement(SELECT_PRENOTAZIONISETTLAB);
			ResultSet risultati = selectQuery(query);

			while (risultati.next()) {
				String corsoLaurea = risultati.getString("Corso_laurea");
				String nomeInsegn = risultati.getString("Nome_insegn");
				String data = risultati.getString("Data");
				String oraIniz = risultati.getString("Ora_inizio");
				String oraFin = risultati.getString("Ora_fine");
				String aula = risultati.getString("Aula");
				int nPiano = risultati.getInt("Npiano");
				String tipologia = risultati.getString("Tipologia");
				String note = risultati.getString("Note");

				Prenotazione c = new Prenotazione(corsoLaurea, nomeInsegn, data, oraIniz, oraFin, aula, nPiano,
						tipologia, note);
				prenotazioni.add(c);
			}
		} catch (SQLException e) {
			System.err.println("si e' verificato un errore:\n\n".concat(e.getMessage()));
		}
		return prenotazioni;
	}
	@Override
	public void search(BO bo) {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		System.out.println("sono nel main");

		Prenotazione inse = new Prenotazione("Prova", "Editoria ci stimo provando", "2009-03-15", "16:00:00",
				"19:00:00", "Intelll", 5, "Aula", "Esame c");
		DaoPrenotazione d = new DaoPrenotazione();

		System.out.println("create: " + d.create(inse));
		System.err.println("vuoi prenderlo?");
		Scanner s = new Scanner(System.in);
		int conferma = s.nextInt();

	}
}
