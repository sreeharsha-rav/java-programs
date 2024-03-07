package bookPkg.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import bookPkg.entity.Book;
import util.HibernateUtil;
import java.util.ArrayList;

// A Data Access Object (DAO) implementation for the book table
public class BookDAOImpl implements BookDAO {
	@Override
	public void createBook(String bookTitle, float bookPrice) {
		try {
			// Initialize the session and transaction
			Session session = HibernateUtil.buildSessionFactory().openSession();
			Transaction tx = session.getTransaction();
			tx.begin();
			// Create a new book
			Book book = new Book(bookTitle, bookPrice);
			session.persist(book);
			System.out.println(book);
			System.out.println("Book created successfully!");
			tx.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void readBook(int bookId) {
		try {
			// Initialize the session and transaction
			Session session = HibernateUtil.buildSessionFactory().openSession();
			Transaction tx = session.getTransaction();
			tx.begin();
			Book book = session.get(Book.class, bookId);
			// Check if the book exists
			if (book == null) {
				System.out.println("Book not found!");
			} else {
				System.out.println("Book found!");
				System.out.println(book);
				System.out.println("Book read successfully!");
			}
			tx.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void readAllBooks() {
		try {
			// Initialize the session and transaction
			Session session = HibernateUtil.buildSessionFactory().openSession();
			ArrayList<Book> books = (ArrayList<Book>) session.createQuery("from Book", Book.class).list();
			// Check if there are any books
			if (books.isEmpty()) {
				System.out.println("No books found!");
			} else {
				System.out.println("Books found!");
				for (Book book : books) {
					System.out.println(book);
				}
				System.out.println("Books read successfully!");
			}
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateBook(int bookId, String bookTitle, float bookPrice) {
		try {
			// Use a session to get the book
			Session session1 = HibernateUtil.buildSessionFactory().openSession();
			session1.beginTransaction();
			Book book = session1.get(Book.class, bookId);
			session1.getTransaction().commit();
			session1.close();
			// Check if the book exists
			if (book == null) {
                System.out.println("Book not found!");
            } else {
            	System.out.println("Book found!");
            	// Update the book
            	book.setBookTitle(bookTitle);
            	book.setBookPrice(bookPrice);
                // Use a session to update the book
                Session session2 = HibernateUtil.buildSessionFactory().openSession();
                session2.beginTransaction();
                session2.merge(book);
                System.out.println(book);
                System.out.println("Book updated successfully!");
                session2.getTransaction().commit();
                session2.close();
            }
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteBook(int bookId) {
		try {
			// Initialize the session and transaction
			Session session = HibernateUtil.buildSessionFactory().openSession();
			Transaction tx = session.getTransaction();
			tx.begin();
			Book book = session.get(Book.class, bookId);
			// Check if the book exists
			if (book == null) {
                System.out.println("Book not found!");
            } else {
                System.out.println("Book found!");
                // Delete the book
                session.remove(book);
                System.out.println("Book deleted successfully!");
            }
			tx.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
