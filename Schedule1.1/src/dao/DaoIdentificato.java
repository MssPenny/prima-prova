package dao;

import dao.DaoService;

public class DaoIdentificato extends DaoService{
	
	/**
	 * Query di selezione delle credenziali di accesso
	 */
	static final String QUERY_LOGIN = "SELECT tipo FROM Credenziali WHERE username = ? AND password = ?;";


}
