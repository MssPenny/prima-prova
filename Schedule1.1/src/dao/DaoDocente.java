package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import business.entity.BO;
import business.entity.Docente;


public class DaoDocente extends DaoService implements DaoInterface {

	String QUERY_INSERIMENTO_DOCENTE = "INSERT INTO `schedule_dib`.`dati_docenti` (`Nome`, `Cognome`, `DNascita`, `ResidenzaAb`, `IndirizzoAb`, `Telefono`, `Email`, `IndWeb`, `Npiano`, `UbiUfficio`, `Login`, `Password`) VALUES (?, ?, ?, ?, ?, ?,?,?,?,?,?,?)";
	String QUERY_INSERIMENTO_IDENTIFICATO = "INSERT INTO `schedule_dib`.`associa_doc` (`Login`, `Password`,`Corso_laurea`, `Nome_insegn`) VALUES (?, ?, ?, ?)";
	String QUERY_UPDATE_IDENTIFICATO = "UPDATE `schedule_dib`.`associa_doc` SET `Corso_laurea`=?, `Nome_insegn`=?   WHERE `Login` = ? ;";
	String QUERY_UPDATE_DOCENTE = "UPDATE `schedule_dib`.`dati_docenti` SET `Nome`=?, `Cognome`=?, `DNascita`=?, `ResidenzaAb`=?, `IndirizzoAb`=?, `Telefono`=?, `Email`=?, `IndWeb`=?, `Npiano`=?, `UbiUfficio`=?  WHERE `Login` = ? ;";
	String QUERY_ELIMINA_IDENTIFICATO = "DELETE FROM `schedule_dib`.`associa_doc` WHERE `Login`=?";
	String QUERY_ELIMINA_DOCENTE = "DELETE FROM `schedule_dib`.`dati_docenti` WHERE `Login`=?";
	String SELECT_DOCENTE = "SELECT Nome,Cognome, DNascita, ResidenzaAb, IndirizzoAb, Telefono, Email, IndWeb, Npiano, UbiUfficio, dati_docenti.Login, dati_docenti.Password, Corso_laurea, Nome_insegn FROM dati_docenti JOIN associa_doc ON dati_docenti.Login = associa_doc.Login  AND dati_docenti.Password = associa_doc.Password WHERE dati_docenti.Login=?;";

	Dao dao;

	public DaoDocente() {
		dao = new Dao();
	}

	@Override
	public boolean create(BO bo) {
		Docente docente = (Docente) bo;

		PreparedStatement inserimentoDocente = null;
		PreparedStatement inserimentoIdentificato = null;

		try {
			int identificatoindex = 1;
			inserimentoIdentificato = dao.getInstance().prepareStatement(QUERY_INSERIMENTO_IDENTIFICATO);
			inserimentoIdentificato = setParameter(inserimentoIdentificato, docente.getLogin(), identificatoindex++);
			inserimentoIdentificato = setParameter(inserimentoIdentificato, docente.getPassword(), identificatoindex++);
			inserimentoIdentificato = setParameter(inserimentoIdentificato, docente.getCorsoLaurea(),
					identificatoindex++);
			inserimentoIdentificato = setParameter(inserimentoIdentificato, docente.getNomeInsegnamento(),
					identificatoindex++);
			insertQuery(inserimentoIdentificato);

			int index = 1;
			inserimentoDocente = dao.getInstance().prepareStatement(QUERY_INSERIMENTO_DOCENTE);
			inserimentoDocente = setParameter(inserimentoDocente, docente.getNome(), index++);
			inserimentoDocente = setParameter(inserimentoDocente, docente.getCognome(), index++);
			inserimentoDocente = setParameter(inserimentoDocente, docente.getDataNascita(), index++);
			inserimentoDocente = setParameter(inserimentoDocente, docente.getResidenzaAb(), index++);
			inserimentoDocente = setParameter(inserimentoDocente, docente.getIndirizzoAb(), index++);
			inserimentoDocente = setParameter(inserimentoDocente, docente.getTelefono(), index++);
			inserimentoDocente = setParameter(inserimentoDocente, docente.getEmail(), index++);
			inserimentoDocente = setParameter(inserimentoDocente, docente.getIndWeb(), index++);
			inserimentoDocente = setParameter(inserimentoDocente, docente.getnPiano(), index++);
			inserimentoDocente = setParameter(inserimentoDocente, docente.getUbiUfficio(), index++);
			inserimentoDocente = setParameter(inserimentoDocente, docente.getLogin(), index++);
			inserimentoDocente = setParameter(inserimentoDocente, docente.getPassword(), index++);
			insertQuery(inserimentoDocente);

		} catch (SQLException e) {

			System.err.println("si e' verificato un errore:\n\n".concat(e.getMessage()));
		}
		return true;
	}

	@Override
	public BO read(BO bo) {
		String nomeDoc = "";
		String cognome = "";
		String dataNascita = "";
		String residenzaAb = "";
		String indirizzoAb = "";
		String telefono = "";
		String email = "";
		String indWeb = "";
		int nPiano;
		String ubiUfficio = "";
		String login = "";
		String pass = "";
		String corsoLaurea = "";
		String nomeInsegn = "";
		Docente i = null;
		Docente docente = (Docente) bo;
		PreparedStatement ricercaDoc = null;

		try {
			ricercaDoc = dao.getInstance().prepareStatement(SELECT_DOCENTE);
			setParameter(ricercaDoc, docente.getLogin(), 1);

			ResultSet resultsRicercaDoc = selectQuery(ricercaDoc);

			if (resultsRicercaDoc.next()) {

				nomeDoc = resultsRicercaDoc.getString("Nome");
				cognome = resultsRicercaDoc.getString("Cognome");
				dataNascita = resultsRicercaDoc.getString("DNascita");
				residenzaAb = resultsRicercaDoc.getString("ResidenzaAb");
				indirizzoAb = resultsRicercaDoc.getString("IndirizzoAb");
				telefono = resultsRicercaDoc.getString("Telefono");
				email = resultsRicercaDoc.getString("Email");
				indWeb = resultsRicercaDoc.getString("IndWeb");
				nPiano = resultsRicercaDoc.getInt("Npiano");
				ubiUfficio = resultsRicercaDoc.getString("UbiUfficio");
				login = resultsRicercaDoc.getString("Login");
				pass = resultsRicercaDoc.getString("Password");
				corsoLaurea = resultsRicercaDoc.getString("Corso_laurea");
				nomeInsegn = resultsRicercaDoc.getString("Nome_insegn");

			} else {
				throw new SQLException();
			}

			i = new Docente(nomeDoc, cognome, dataNascita, residenzaAb, indirizzoAb, telefono, email, indWeb, nPiano,
					ubiUfficio, login, pass, corsoLaurea, nomeInsegn);

		} catch (SQLException e) {
			return null;
		}
		return i;
	}

	@Override
	public boolean update(BO bo) {
		PreparedStatement updateDocente = null;
		PreparedStatement updateIdentificato = null;
		Docente docente = (Docente) bo;

		try {

			updateIdentificato = dao.getInstance().prepareStatement(QUERY_UPDATE_IDENTIFICATO);
			int indexIde = 1;

			updateIdentificato = dao.getInstance().prepareStatement(QUERY_UPDATE_DOCENTE);
			updateIdentificato = setParameter(updateIdentificato, docente.getCorsoLaurea(), indexIde++);
			updateIdentificato = setParameter(updateIdentificato, docente.getNomeInsegnamento(), indexIde++);
			updateDeleteQuery(updateIdentificato);

			int index = 1;

			updateDocente = setParameter(updateDocente, docente.getNome(), index++);
			updateDocente = setParameter(updateDocente, docente.getCognome(), index++);
			updateDocente = setParameter(updateDocente, docente.getDataNascita(), index++);
			updateDocente = setParameter(updateDocente, docente.getResidenzaAb(), index++);
			updateDocente = setParameter(updateDocente, docente.getIndirizzoAb(), index++);
			updateDocente = setParameter(updateDocente, docente.getTelefono(), index++);
			updateDocente = setParameter(updateDocente, docente.getEmail(), index++);
			updateDocente = setParameter(updateDocente, docente.getIndWeb(), index++);
			updateDocente = setParameter(updateDocente, docente.getnPiano(), index++);
			updateDocente = setParameter(updateDocente, docente.getUbiUfficio(), index++);
			

			updateDocente = setParameter(updateDocente, docente.getLogin(), index++);

			updateDeleteQuery(updateDocente);

		} catch (SQLException e) {

			return false;
		}
		return true;

	}

	@Override
	public boolean delete(BO bo) {
		Docente docente = (Docente) bo;

		PreparedStatement eliminaDocente = null;
		PreparedStatement eliminaIdentificato = null;


		try {
			int index = 1;
			eliminaDocente = dao.getInstance().prepareStatement(QUERY_ELIMINA_DOCENTE);
			eliminaIdentificato = dao.getInstance().prepareStatement(QUERY_ELIMINA_IDENTIFICATO);

			eliminaDocente = setParameter(eliminaDocente, docente.getLogin(), index++);

			insertQuery(eliminaIdentificato);
			int indexIde = 1;
			eliminaIdentificato = setParameter(eliminaIdentificato, docente.getLogin(), indexIde++);

			insertQuery(eliminaDocente);

		} catch (SQLException e) {

			System.err.println("si e' verificato un errore:\n\n".concat(e.getMessage()));
		}
		return true;
	}

	@Override
	public void search(BO bo) {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		System.out.println("sono nel main");

		Docente inse = new Docente("OHKJH", "GIOO", "2221", "si", "si", "30", "OS", "OS", 6, "OS", "OS", "OS", "OS",
				"OS");
		DaoDocente d = new DaoDocente();

		System.out.println("create: " + d.create(inse));
		System.err.println("vuoi prenderlo?");
		Scanner s = new Scanner(System.in);
		int conferma = s.nextInt();
		if (conferma == 1) {
			System.out.println("read: " + ((Docente) d.read(inse)).toString());

		}

	}
}
