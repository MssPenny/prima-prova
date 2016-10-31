package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import business.entity.BO;
import business.entity.Identificato;
import dao.DaoService;
import dao.Dao;

public class DaoIdentificato extends DaoService {

	String SELECT_UTENTE = "Select `Login`, `Password` FROM `schedule_dib`.`associa_doc`  WHERE `Login` = ? ";
	/**
	 * Permette di cercare un utente tramite la login
	 * 
	 * @param dati
	 *            i dati della richiesta
	 * 
	 * @return 1 se e' un cliente 0 se e' un amministratore -1 se non e'
	 *         presente del database
	 * 
	 */
	Dao dao;

	public DaoIdentificato() {
		dao = new Dao();
	}

	public int search(BO bo) {
		Identificato identificato = (Identificato) bo;
		int tipo = -1;

		PreparedStatement query = null;

		try {

			query = dao.getInstance().prepareStatement(SELECT_UTENTE);
			setParameter(query, (String) identificato.getLogin(), 1);
			setParameter(query, (String) identificato.getPassword(), 2);

			ResultSet results = selectQuery(query);

			if (results.next()) {
				tipo = results.getInt("tipo");

			}
		} catch (SQLException e) {

			System.err.println("si e' verificato un errore:\n\n".concat(e.getMessage()));
		}
		return tipo;

	}

}
