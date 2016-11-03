package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import business.entity.BO;
import business.entity.Orario;

public class DaoOrario extends DaoService implements DaoInterface {

	String QUERY_INSERIMENTO_ORARIO = "INSERT INTO `schedule_dib`.`orario` (`Giorno1`, `Ora_inizio1`, `Ora_fine1`, `Giorno2`, `Ora_inizio2`, `Ora_fine2`, `Giorno3`, `Ora_inizio3`, `Ora_fine3`, `Nome_insegn`, `Corso_laurea`) VALUES (?, ?, ?, ?, ?, ?,?,?,?,?,?)";
	String QUERY_ELIMINA_ORARIO = "DELETE FROM `schedule_dib`.`orario` WHERE `Nome_insegn`=? ";
	String QUERY_UPDATE_ORARIO = "UPDATE `schedule_dib`.`orario` SET `Giorno1`=?, `Ora_inizio1`=?, `Ora_fine1`=?, `Giorno2`=?, `Ora_inizio2`=?, `Ora_fine2`=?, `Giorno3`=?, `Ora_inizio3`=?, `Ora_fine3`=?, `Nome_insegn`=?, `Corso_laurea`=?  WHERE `Nome_insegn` = ? ;";
	String SELECT_ORARIO = "SELECT `Giorno1`, `Ora_inizio1`, `Ora_fine1`, `Giorno2`, `Ora_inizio2`, `Ora_fine2`, `Giorno3`, `Ora_inizio3`, `Ora_fine3`, `Nome_insegn`, `Corso_laurea` FROM `schedule_dib`.`orario`  WHERE `Nome_insegn` = ? ";

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
			setParameter(ricercaOra, orario.getNomeInsegn(), 1);

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

			i = new Orario(giorno1, oraInizio1, oraFine1, giorno2, oraInizio2, oraFine2, giorno3, oraInizio3, oraFine3, nomeInsegn, corsoLaurea);

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
			updateOrario = setParameter(updateOrario, orario.getNomeInsegn(),index++);
			updateOrario = setParameter(updateOrario, orario.getCorsoLaurea(),index++);

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

		Orario inse = new Orario("Martedi", "09:00", "10:30", "giovedi", "10:00", "11:00", "venerdi", "09:00", "10:30", "prova", "ITPS");
		DaoOrario d = new DaoOrario();
		System.out.println("create: " + d.create(inse));
		System.err.println("vuoi prenderlo?");
		Scanner s = new Scanner(System.in);
		int conferma = s.nextInt();
		if (conferma == 1) {
			System.out.println("read: " +  d.delete(inse));

		}
		
		
	}

}
