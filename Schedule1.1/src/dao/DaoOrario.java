package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import business.entity.BO;
import business.entity.Corso;
import business.entity.Identificato;
import business.entity.Insegnamento;
import business.entity.Orario;

public class DaoOrario extends DaoService implements DaoInterface {

	String QUERY_INSERIMENTO_ORARIO = "INSERT INTO `schedule_dib`.`orario` (`Giorno1`, `Ora_inizio1`, `Ora_fine1`, `Giorno2`, `Ora_inizio2`, `Ora_fine2`, `Giorno3`, `Ora_inizio3`, `Ora_fine3`, `Nome_insegn`, `Corso_laurea`) VALUES (?, ?, ?, ?, ?, ?,?,?,?,?,?)";
	String QUERY_ELIMINA_ORARIO = "DELETE FROM `schedule_dib`.`orario` WHERE `Nome_insegn`=? ";
	String QUERY_UPDATE_ORARIO = "UPDATE `schedule_dib`.`orario` SET `Giorno1`=?, `Ora_inizio1`=?, `Ora_fine1`=?, `Giorno2`=?, `Ora_inizio2`=?, `Ora_fine2`=?, `Giorno3`=?, `Ora_inizio3`=?, `Ora_fine3`=?, `Nome_insegn`=?, `Corso_laurea`=?  WHERE `Nome_insegn` = ? ;";
	String SELECT_ORARIO = "SELECT `Giorno1`, `Ora_inizio1`, `Ora_fine1`, `Giorno2`, `Ora_inizio2`, `Ora_fine2`, `Giorno3`, `Ora_inizio3`, `Ora_fine3`, `Nome_insegn`, `Corso_laurea` FROM `schedule_dib`.`orario`  WHERE `Corso_laurea` = ? AND `Nome_insegn` = ? ";
	String SELECT_ORARIOASSOCDOC = "SELECT * from `schedule_dib`.`orario`, `schedule_dib`.`associa_doc` WHERE `orario`.`Nome_insegn`=`associa_doc`.`Nome_insegn` AND  `associa_doc`.`Login`=? AND `associa_doc`.`Password`=? AND `orario`.`Corso_laurea`=? ";

	Dao dao;

	public DaoOrario() {
		dao = new Dao();
	}

	@Override
	public boolean create(BO bo) {
		Orario orario = (Orario) bo;

		PreparedStatement inserimentoOrario = null;

		try {
			int index = 1;
			inserimentoOrario = dao.getInstance().prepareStatement(QUERY_INSERIMENTO_ORARIO);
			inserimentoOrario = setParameter(inserimentoOrario, orario.getGiorno1(), index++);
			inserimentoOrario = setParameter(inserimentoOrario, orario.getOraInizio1(), index++);
			inserimentoOrario = setParameter(inserimentoOrario, orario.getOraFine1(), index++);
			inserimentoOrario = setParameter(inserimentoOrario, orario.getGiorno2(), index++);
			inserimentoOrario = setParameter(inserimentoOrario, orario.getOraInizio2(), index++);
			inserimentoOrario = setParameter(inserimentoOrario, orario.getOraFine2(), index++);
			inserimentoOrario = setParameter(inserimentoOrario, orario.getGiorno3(), index++);
			inserimentoOrario = setParameter(inserimentoOrario, orario.getOraInizio3(), index++);
			inserimentoOrario = setParameter(inserimentoOrario, orario.getOraFine3(), index++);
			inserimentoOrario = setParameter(inserimentoOrario, orario.getNomeInsegn(), index++);
			inserimentoOrario = setParameter(inserimentoOrario, orario.getCorsoLaurea(), index++);

			insertQuery(inserimentoOrario);

		} catch (SQLException e) {

			System.err.println("si e' verificato un errore:\n\n".concat(e.getMessage()));
		}
		return true;
	}

	public LinkedList<Orario> readOraAssocDoc(HashMap<String, Object> bo) {
		String giorno1 = "";
		String oraInizio1 = "";
		String oraFine1 = "";
		String giorno2 = "";
		String oraInizio2 = "";
		String oraFine2 = "";
		String giorno3 = "";
		String oraInizio3 = "";
		String oraFine3 = "";
		String nomeInsegn = "";
		String corsoLaurea = "";
		String login = "";
		String password = "";
		LinkedList<Orario> i = null;
		Orario orario = (Orario) bo.get("orario");
		Identificato identificato = (Identificato) bo.get("identificato");
		PreparedStatement ricercaIns = null;

		try {
			ricercaIns = dao.getInstance().prepareStatement(SELECT_ORARIOASSOCDOC);
			setParameter(ricercaIns, orario.getCorsoLaurea(), 1);
			setParameter(ricercaIns, orario.getNomeInsegn(), 2);
			setParameter(ricercaIns, identificato.getLogin(), 3);
			setParameter(ricercaIns, identificato.getPassword(), 4);

			ResultSet resultsRicercaIns = selectQuery(ricercaIns);

			while (resultsRicercaIns.next()) {

				giorno1 = resultsRicercaIns.getString("Giorno1");
				oraInizio1 = resultsRicercaIns.getString("Ora_inizio1");
				oraFine1 = resultsRicercaIns.getString("Ora_fine1");
				giorno2 = resultsRicercaIns.getString("Giorno2");
				oraInizio2 = resultsRicercaIns.getString("Ora_inizio2");
				oraFine2 = resultsRicercaIns.getString("Ora_fine2");
				giorno3 = resultsRicercaIns.getString("Giorno3");
				oraInizio3 = resultsRicercaIns.getString("Ora_inizio3");
				oraFine3 = resultsRicercaIns.getString("Ora_fine3");
				nomeInsegn = resultsRicercaIns.getString("Nome_insegn");
				corsoLaurea = resultsRicercaIns.getString("Corso_laurea");

				i.add(new Orario(giorno1, oraInizio1, oraFine1, giorno2, oraInizio2, oraFine2, giorno3, oraInizio3,
						oraFine3, nomeInsegn, corsoLaurea));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	public List<BO> readOrario(BO bo) {
		List<BO> v = null;
		Orario i = null;
		Orario orario = (Orario) bo;
		PreparedStatement ricercaCor = null;

		try {
			ricercaCor = dao.getInstance().prepareStatement(SELECT_ORARIO);
			setParameter(ricercaCor, orario.getCorsoLaurea(), 1);
			setParameter(ricercaCor, orario.getNomeInsegn(), 2);

			ResultSet resultsRicercaCor = selectQuery(ricercaCor);

			v = new ArrayList<BO>();

			while (resultsRicercaCor.next()) {
				i = new Orario(resultsRicercaCor.getString("Giorno1"), resultsRicercaCor.getString("Ora_inizio1"),
						resultsRicercaCor.getString("Ora_fine1"), resultsRicercaCor.getString("Giorno2"),
						resultsRicercaCor.getString("Ora_inizio2"), resultsRicercaCor.getString("Ora_fine2"),
						resultsRicercaCor.getString("Giorno3"), resultsRicercaCor.getString("Ora_inizio3"),
						resultsRicercaCor.getString("Ora_fine3"), resultsRicercaCor.getString("Nome_insegn"),
						resultsRicercaCor.getString("Corso_laurea"));
				v.add(i);
			}

		} catch (SQLException e) {
			return null;
		}
		return v;
	}

	@Override
	public BO read(BO bo) {
		String giorno1 = "";
		String oraInizio1 = "";
		String oraFine1 = "";
		String giorno2 = "";
		String oraInizio2 = "";
		String oraFine2 = "";
		String giorno3 = "";
		String oraInizio3 = "";
		String oraFine3 = "";
		String nomeInsegn = "";
		String corsoLaurea = "";
		Orario i = null;
		Orario orario = (Orario) bo;
		PreparedStatement ricercaOra = null;

		try {
			ricercaOra = dao.getInstance().prepareStatement(SELECT_ORARIO);
			setParameter(ricercaOra, orario.getCorsoLaurea(), 1);
			setParameter(ricercaOra, orario.getNomeInsegn(), 2);

			ResultSet resultsRicercaOra = selectQuery(ricercaOra);

			if (resultsRicercaOra.next()) {

				giorno1 = resultsRicercaOra.getString("Giorno1");
				oraInizio1 = resultsRicercaOra.getString("Ora_inizio1");
				oraFine1 = resultsRicercaOra.getString("Ora_fine1");
				giorno2 = resultsRicercaOra.getString("Giorno2");
				oraInizio2 = resultsRicercaOra.getString("Ora_inizio2");
				oraFine2 = resultsRicercaOra.getString("Ora_fine2");
				giorno3 = resultsRicercaOra.getString("Giorno3");
				oraInizio3 = resultsRicercaOra.getString("Ora_inizio3");
				oraFine3 = resultsRicercaOra.getString("Ora_fine3");
				nomeInsegn = resultsRicercaOra.getString("Nome_insegn");
				corsoLaurea = resultsRicercaOra.getString("Corso_laurea");

			} else {
				throw new SQLException();
			}

			i = new Orario(giorno1, oraInizio1, oraFine1, giorno2, oraInizio2, oraFine2, giorno3, oraInizio3, oraFine3,
					nomeInsegn, corsoLaurea);

		} catch (SQLException e) {
			return null;
		}
		return i;

	}

	@Override
	public boolean update(BO bo) {

		PreparedStatement updateOrario = null;
		Orario orario = (Orario) bo;

		try {

			updateOrario = dao.getInstance().prepareStatement(QUERY_UPDATE_ORARIO);

			int index = 1;

			updateOrario = setParameter(updateOrario, orario.getGiorno1(), index++);
			updateOrario = setParameter(updateOrario, orario.getOraInizio1(), index++);
			updateOrario = setParameter(updateOrario, orario.getOraFine1(), index++);
			updateOrario = setParameter(updateOrario, orario.getGiorno2(), index++);
			updateOrario = setParameter(updateOrario, orario.getOraInizio2(), index++);
			updateOrario = setParameter(updateOrario, orario.getOraFine2(), index++);
			updateOrario = setParameter(updateOrario, orario.getGiorno3(), index++);
			updateOrario = setParameter(updateOrario, orario.getOraInizio3(), index++);
			updateOrario = setParameter(updateOrario, orario.getOraFine3(), index++);
			updateOrario = setParameter(updateOrario, orario.getNomeInsegn(), index++);
			updateOrario = setParameter(updateOrario, orario.getCorsoLaurea(), index++);

			updateOrario = setParameter(updateOrario, orario.getNomeInsegn(), index++);

			updateDeleteQuery(updateOrario);

		} catch (SQLException e) {

			return false;
		}
		return true;

	}

	@Override
	public boolean delete(BO bo) {
		Orario orario = (Orario) bo;

		PreparedStatement eliminaOrario = null;

		try {
			int index = 1;
			eliminaOrario = dao.getInstance().prepareStatement(QUERY_ELIMINA_ORARIO);

			eliminaOrario = setParameter(eliminaOrario, orario.getNomeInsegn(), index++);
			insertQuery(eliminaOrario);

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

		Orario inse = new Orario("Martedi", "09:00", "10:30", "giovedi", "10:00", "11:00", "venerdi", "09:00", "10:30",
				"prova", "ITPS");
		DaoOrario d = new DaoOrario();
		System.out.println("create: " + d.create(inse));
		System.err.println("vuoi prenderlo?");
		Scanner s = new Scanner(System.in);
		int conferma = s.nextInt();
		if (conferma == 1) {
			System.out.println("read: " + d.delete(inse));

		}

	}

}
