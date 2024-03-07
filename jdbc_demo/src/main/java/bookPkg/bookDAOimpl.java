package bookPkg;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class bookDAOimpl implements bookDAO {
	@Override
	public void create(int bookId, String bookTitle, double bookPrice) {
		String query = "INSERT INTO books VALUES (?, ?, ?)";
		try (Connection conn = MyConnection.getConnection()) {
			PreparedStatement prepStmt = conn.prepareStatement(query);
			prepStmt.setInt(1, bookId);
			prepStmt.setString(2, bookTitle);
			prepStmt.setDouble(3, bookPrice);
			System.out.println("Created book with ID: " + bookId + ", Title: " + bookTitle + ", and Price: " + bookPrice);
			int rowsInserted = prepStmt.executeUpdate();
			System.out.println("Inserted " + rowsInserted + " row into the table");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void read(int bookId) {
		String query = "SELECT * FROM books WHERE book_id = ?";
		try (Connection conn = MyConnection.getConnection()) {
			PreparedStatement prepStmt = conn.prepareStatement(query);
			prepStmt.setInt(1, bookId);
			ResultSet rs = prepStmt.executeQuery();
			// Check if book ID exists
			if (!rs.isBeforeFirst()) {
				System.out.println("No data found for book ID: " + bookId);
				return;
			}
			while (rs.next()) {
				int bookId2 = rs.getInt("book_id");
				String bookTitle = rs.getString("book_title");
				double bookPrice = rs.getDouble("book_price");
				System.out.println("Book ID: " + bookId2 + ", Book Title: " + bookTitle + ", Book Price: " + bookPrice);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void readAll() {
		String query = "SELECT * FROM books";
		try (Connection conn = MyConnection.getConnection()) {
			PreparedStatement prepStmt = conn.prepareStatement(query);
			ResultSet rs = prepStmt.executeQuery();
			if (!rs.isBeforeFirst()) {
				System.out.println("No data found in the table");
				return;
			}
			while (rs.next()) {
				int bookId = rs.getInt("book_id");
				String bookTitle = rs.getString("book_title");
				double bookPrice = rs.getDouble("book_price");
				System.out.println("Book ID: " + bookId + ", Book Title: " + bookTitle + ", Book Price: " + bookPrice);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(int bookId, String bookTitle, double bookPrice) {
		String query = "UPDATE books SET book_title = ?, book_price = ? WHERE book_id = ?";
		try (Connection conn = MyConnection.getConnection()) {
			PreparedStatement prepStmt = conn.prepareStatement(query);
			prepStmt.setString(1, bookTitle);
			prepStmt.setDouble(2, bookPrice);
			prepStmt.setInt(3, bookId);
			int rowsUpdated = prepStmt.executeUpdate();
			// Check if book ID exists
			if (rowsUpdated == 0) {
				System.out.println("No data found for book ID: " + bookId);
				return;
			}

			System.out.println("Updated " + rowsUpdated + " row in the table");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int bookId) {
		String query = "DELETE FROM books WHERE book_id = ?";
		try (Connection conn = MyConnection.getConnection()) {
			PreparedStatement prepStmt = conn.prepareStatement(query);
			prepStmt.setInt(1, bookId);
			int rowsDeleted = prepStmt.executeUpdate();
			// Check if book ID exists
			if (rowsDeleted == 0) {
				System.out.println("No data found for book ID: " + bookId);
				return;
			}
			System.out.println("Deleted " + rowsDeleted + " row from the table");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
