package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import business.entity.BO;
import business.entity.Aula;
public class DaoAula extends DaoService implements DaoInterface {

	String QUERY_INSERIMENTO_AULA = "INSERT INTO `schedule_dib`.`dati_aule` (`Nome`, `Nposti`, `Npiano`, `Ubicazione`, `Tipologia`) VALUES (?, ?, ?, ?, ?)";
	String QUERY_ELIMINA_AULA = "DELETE FROM `schedule_dib`.`dati_aule` WHERE `Nome`=?";
	String QUERY_UPDATE_AULA = "UPDATE `schedule_dib`.`dati_aule` SET `Nome`=?, `Nposti`=?, `Npiano`=?, `Ubicazione`=?, `Tipologia`=?  WHERE `Nome` = ? ;";
	String SELECT_AULA = "Select `Nome`, `Nposti`, `Npiano`, `Ubicazione`, `Tipologia` FROM `schedule_dib`.`dati_aule`  WHERE `Nome` = ? ";

	Dao dao;

	public DaoAula() {
		dao = new Dao();
	}

	@Override
	public boolean create(BO bo) {
		Aula aula = (Aula) bo;

		PreparedStatement inserimentoAula = null;

		try {
			int index = 1;
			inserimentoAula = dao.getInstance().prepareStatement(QUERY_INSERIMENTO_AULA);
			inserimentoAula = setParameter(inserimentoAula, aula.getNome(), index++);
			inserimentoAula = setParameter(inserimentoAula, aula.getnPosti(), index++);
			inserimentoAula = setParameter(inserimentoAula, aula.getnPiano(), index++);
			inserimentoAula = setParameter(inserimentoAula, aula.getUbicazione(), index++);
			inserimentoAula = setParameter(inserimentoAula, aula.getTipologia(), index++);
			insertQuery(inserimentoAula);

		} catch (SQLException e) {

			System.err.println("si e' verificato un errore:\n\n".concat(e.getMessage()));
		}
		return true;
	}

	@Override
	public BO read(BO bo) {

		String nomeAul = "";
		int nPosti;
		int nPiano;
		String ubicazione = "";
		String tipologia = "";
		Aula i = null;
		Aula aula = (Aula) bo;
		PreparedStatement ricercaAul = null;

		try {
			ricercaAul = dao.getInstance().prepareStatement(SELECT_AULA);
			setParameter(ricercaAul, aula.getNome(), 1);

			ResultSet resultsRicercaAul = selectQuery(ricercaAul);

			if (resultsRicercaAul.next()) {

				nomeAul = resultsRicercaAul.getString("Nome");
				nPosti = resultsRicercaAul.getInt("Nposti");
				nPiano = resultsRicercaAul.getInt("Npiano");
				ubicazione = resultsRicercaAul.getString("Ubicazione");
				tipologia = resultsRicercaAul.getString("Tipologia");

			} else {
				throw new SQLException();
			}

			i = new Aula(nomeAul, nPosti, nPiano, ubicazione, tipologia);

		} catch (SQLException e) {
			return null;
		}
		return i;
	}

	@Override
	public boolean update(BO bo) {

		PreparedStatement updateAula = null;
		Aula aula = (Aula) bo;

		try {

			updateAula = dao.getInstance().prepareStatement(QUERY_UPDATE_AULA);

			int index = 1;

			updateAula = setParameter(updateAula, aula.getNome(), index++);
			updateAula = setParameter(updateAula, aula.getnPosti(), index++);
			updateAula = setParameter(updateAula, aula.getnPiano(), index++);
			updateAula = setParameter(updateAula, aula.getTipologia(), index++);
			updateAula = setParameter(updateAula, aula.getUbicazione(), index++);

			updateAula = setParameter(updateAula, aula.getNome(), index++);

			updateDeleteQuery(updateAula);

		} catch (SQLException e) {

			return false;
		}
		return true;

	}

	@Override
	public boolean delete(BO bo) {
		Aula aula = (Aula) bo;

		PreparedStatement inserimentoAula = null;

		try {
			int index = 1;
			inserimentoAula = dao.getInstance().prepareStatement(QUERY_ELIMINA_AULA);
			inserimentoAula = setParameter(inserimentoAula, aula.getNome(), index++);

			insertQuery(inserimentoAula);

		} catch (SQLException e) {

			System.err.println("si e' verificato un errore:\n\n".concat(e.getMessage()));
		}
		return true;

	}

	@Override
	public void search(BO bo) {
		// TODO Auto-generated method stub

	}

}
