package dao;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

//applico il singleton

public class Dao {
	Connection conn;

	public  Dao() {
		connetti();
	}
	/*	
				
	 * 
	 */

	private void connetti() {

		String host = "";
		String db = "";
		String username = "";
		String password = "";
	try {
		 
		host="localhost:3306";
		db="schedule_dib";
		username="root";
		password="root";
		String url = "jdbc:mysql://".concat(host).concat("/").concat(db);
		
		// conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/schedule_dib","root","root");
		 
			
			conn = (Connection) DriverManager.getConnection(url, username, password);
		 
		} catch (SQLException e /*| ParserConfigurationException | SAXException
				| IOException e */) {
		 
		e.printStackTrace();		}
	}
 

	public Connection getInstance() {
		return conn;
	}
}
