package pkg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {
	static Connection conn;
	
	public static Connection getConnection() {
		String url = "jdbc:mysql://localhost:3306/mydb";
		try {
			conn = DriverManager.getConnection(url, "root", "mango%^TANGO47");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}
