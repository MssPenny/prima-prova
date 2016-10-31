package dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;





public class DaoService extends Dao {

	// per identificare parametro di tipo stringa

	static final String PARAM_STRINGA = "String";

	// per identificare parametro di tipo integer

	static final String PARAM_INT = "Integer";
	static final String PARAM_FLOAT = "Float";
	/*
	 * esecuzione di un inserimento nel DB
	 * 
	 * @param insert lo statement dell'inserimento
	 * 
	 * @throws SQLException se si e' verificato un errore nell'inserimento
	 */

	public void insertQuery(PreparedStatement insert) throws SQLException {
		insert.execute();
	}

	/*
	 * Permette l'esecuzione di una query di select
	 * 
	 * @param select
	 *            lo statement della select
	 * @return il risultato della selezione
	 */
	
	public ResultSet selectQuery(PreparedStatement select) {
		ResultSet risultato = null;
		try {
			risultato = select.executeQuery();
		} catch (SQLException e) {
			System.out.println("si e' verificato un errore:\n\n".concat(e.getMessage()));
		}
		return risultato;
	}

	/*
	 * Permette l'esecuzione di una query di update o delete
	 * 
	 * @param update
	 *            lo statement dell'eliminazione o modifica
	 * @return il numero di righe modificate o eliminate
	 * @throws SQLException
	 *             se e' avvenuto un errore durante la modifica o l'eliminazione
	 */
	public int updateDeleteQuery(PreparedStatement update) throws SQLException {
		int risultato = 0;

		risultato = update.executeUpdate();

		return risultato;

	}

	/*
	 * Setta i parametri incogniti nelle query al DB
	 * 
	 * @param statement
	 *            lo statement in cui settare i parametri
	 * @param param
	 *            il parametro da settare
	 * @param i
	 *            la posizione in cui inserire il parametro
	 * @return lo statement modificato
	 */public PreparedStatement setParameter(PreparedStatement statement,
				Object param, int i) {
			try {
				switch (param.getClass().getSimpleName()) {
				case PARAM_STRINGA:
					statement.setString(i, (String) param);
					break;
				case PARAM_INT:
					statement.setInt(i, (Integer) param);
					break;
				case PARAM_FLOAT:
					statement.setFloat(i, (Float) param);
					break;
				default:
					break;
				}
			} catch (SQLException e) {
		System.err.println("");
			}

			return statement;
		}

}
