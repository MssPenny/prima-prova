package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import business.entity.BO;
import business.entity.Corso;

public class DaoCorso extends DaoService implements DaoInterface {

	String QUERY_INSERIMENTO_CORSO = "INSERT INTO `schedule_dib`.`corsi` (`Corso_laurea`) VALUES (?)";
	String QUERY_ELIMINA_CORSO = "DELETE FROM `schedule_dib`.`corsi` WHERE `corsi`.`Corso_laurea`=? ";
	String QUERY_UPDATE_CORSO = "UPDATE `schedule_dib`.`corsi` SET `Corso_laurea`=? WHERE `Corso_laurea` = ?";
	String QUERY_SELECT_CORSO = "SELECT * FROM `schedule_dib`.`corsi`";

	Dao dao;

	public DaoCorso() {
		dao = new Dao();
	}

	@Override
	public boolean create(BO bo) {
		Corso corso = (Corso) bo;

		PreparedStatement inserimentoCorso = null;

		try {
			int index = 1;
			inserimentoCorso = dao.getInstance().prepareStatement(QUERY_INSERIMENTO_CORSO);
			inserimentoCorso = setParameter(inserimentoCorso, corso.getCorsoLaurea(), index++);
			insertQuery(inserimentoCorso);

		} catch (SQLException e) {

			System.err.println("si e' verificato un errore:\n\n".concat(e.getMessage()));
		}
		return true;
	}
	public BO read(BO o){
		return o;}
	 
	
	public List<BO> readTuttiCorsi(BO bo) {
		List<BO> v=null;
		Corso i = null;
		Corso corso = (Corso) bo;
		PreparedStatement ricercaCor = null;

		try {
			ricercaCor = dao.getInstance().prepareStatement(QUERY_SELECT_CORSO);
			setParameter(ricercaCor, corso.getCorsoLaurea(), 1);

			ResultSet resultsRicercaCor = selectQuery(ricercaCor);
			 
			  v=new ArrayList<BO>();
			 
			while(resultsRicercaCor.next())
			{
				Corso c = new Corso(resultsRicercaCor.getString("Corso_laurea"));
				v.add(c );
				 
			} 

		} catch (SQLException e) {
			return null;
		}
		return v;
	}

	@Override
	public boolean update(BO bo) {
		PreparedStatement updateCorso = null;
		Corso corso = (Corso) bo;

		try {

			updateCorso = dao.getInstance().prepareStatement(QUERY_UPDATE_CORSO);

			int index = 1;
			updateCorso = setParameter(updateCorso, corso.getCorsoLaurea(), index++);
			updateDeleteQuery(updateCorso);

		} catch (SQLException e) {

			return false;
		}
		return true;
	}

	@Override
	public boolean delete(BO bo) {
		Corso corso = (Corso) bo;

		PreparedStatement deleteCorso = null;

		try {
			int index = 1;
			deleteCorso = dao.getInstance().prepareStatement(QUERY_ELIMINA_CORSO);
			deleteCorso = setParameter(deleteCorso, corso.getCorsoLaurea(), index++);

			insertQuery(deleteCorso);

		} catch (SQLException e) {

			System.err.println("si e' verificato un errore:\n\n".concat(e.getMessage()));
		}
		return true;
	}

	@Override
	public void search(BO o) {
		// TODO Auto-generated method stub

	}

}
