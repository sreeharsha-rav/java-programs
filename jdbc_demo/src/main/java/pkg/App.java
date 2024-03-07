package pkg;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class App {
	private static final String QUERY = "SELECT * FROM actor WHERE actor_id < ?";
	
	public static void main(String[] args) {
		try (Connection conn = MyConnection.getConnection()) { // Get the connection
            PreparedStatement prepStmt = conn.prepareStatement(QUERY);	// Create a prepared statement
            prepStmt.setInt(1, 20); // Set ? to 1
			ResultSet rs = prepStmt.executeQuery(); // Execute the query and store the result set
			// Loop through the data and print all of it
            while (rs.next()) {
                int id = rs.getInt("actor_id");
                String first = rs.getString("first_name");
                String last = rs.getString("last_name");
                System.out.println("ID: " + id + ", First: " + first + ", Last: " + last);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
}