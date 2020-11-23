package dbm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class gestorDB {
	
	public static Connection getConnection() {
		Connection getConnectionMySQL = null;
		return getConnectionMySQL ;
	}

	public static Connection getConnectionOracle(String DB_HOST, String DB_PORT, String DB_SID, String BD_USER,
			String DB_PASS) {
		String DB_URL = "jdbc:oracle:thin:@" + DB_HOST + ":" + DB_PORT + "/" + DB_SID;

		Connection conn = null;

		try {
			conn = DriverManager.getConnection(DB_URL, BD_USER, DB_PASS);
		} catch (SQLException e) {
			System.err.println("No se ha podidio establecer la conexión.");
			System.err.println(e.getMessage());
		}
		return conn;
	}

	public static Connection getConnectionMySQL(String DB_HOST, String DB_PORT, String DB_SID, String BD_USER,
			String DB_PASS) {
		String DB_URL = "jdbc:mysql://" + DB_HOST + ":" + DB_PORT + "/" + DB_SID;

		Connection conn = null;

		try {
			conn = DriverManager.getConnection(DB_URL, BD_USER, DB_PASS);
		} catch (SQLException e) {
			System.err.println("No se ha podidio establecer la conexión.");
			System.err.println(e.getMessage());
		}
		return conn;
	}
	
	public static ResultSet getData(Connection conn, String sql) throws SQLException {
		ResultSet rs = null;
		Statement stm = conn.createStatement();
		
		rs = stm.executeQuery(sql);
		
		return rs;
	}
	
}
