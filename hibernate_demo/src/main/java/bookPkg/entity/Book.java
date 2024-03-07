package bookPkg.entity;

// Book POJO class
public class Book {
	private int bookId;
	private String bookTitle;
	private float bookPrice;
	
	// Default constructor
	public Book() {
	}
	
	// Parameterized constructor
	public Book(String bookTitle, float bookPrice) {
		this.bookTitle = bookTitle;
		this.bookPrice = bookPrice;
	}
	
	// Getters and setters
	public int getBookId() {
		return bookId;
	}
	
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	
	public String getBookTitle() {
		return bookTitle;
	}
	
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	
	public float getBookPrice() {
		return bookPrice;
	}
	
	public void setBookPrice(float bookPrice) {
		this.bookPrice = bookPrice;
	}
	
	// toString method
	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookTitle=" + bookTitle + ", bookPrice=" + bookPrice + "]";
	}

}
