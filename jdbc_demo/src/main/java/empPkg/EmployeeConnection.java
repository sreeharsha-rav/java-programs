package empPkg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// A class to establish a connection to the database through JDBC
public class EmployeeConnection {
	static Connection conn;

	public static Connection getConnection() {
		String url = "jdbc:mysql://localhost:3306/empDB";
		try {
			conn = DriverManager.getConnection(url, "root", "mango%^TANGO47");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}
