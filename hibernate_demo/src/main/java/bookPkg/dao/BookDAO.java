package bookPkg.dao;

// A Data Access Object (DAO) interface for the book table
public interface BookDAO {
	public void createBook(String bookTitle, float bookPrice);
	public void readBook(int bookId);
	public void readAllBooks();
	public void updateBook(int bookId, String bookTitle, float bookPrice);
	public void deleteBook(int bookId);
}
