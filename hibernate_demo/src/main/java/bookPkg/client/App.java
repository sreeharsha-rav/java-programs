package bookPkg.client;

import java.util.Scanner;
import bookPkg.dao.BookDAO;
import bookPkg.dao.BookDAOImpl;

public class App {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BookDAO bk = new BookDAOImpl();
		int id;
		String title;
		float price;
		
		while (true) {
			System.out.println("********** Book CRUD Menu **********");
			System.out.println("1. Create a book");
			System.out.println("2. Read a book");
			System.out.println("3. Read all books");
			System.out.println("4. Update a book");
			System.out.println("5. Delete a book");
			System.out.println("6. Exit");
			System.out.println("************************************");
			System.out.print("Enter your choice: ");
			int choice = sc.nextInt();
			sc.nextLine();
			
			switch (choice) {
			case 1:
				System.out.println();
				System.out.println("Creating a book...");
				System.out.print("Enter book title: ");
				title = sc.nextLine();
				System.out.print("Enter book price: ");
				price = sc.nextFloat();
				sc.nextLine();
				bk.createBook(title, price);
				System.out.println();
				break;
			case 2:
				System.out.println();
				System.out.println("Reading a book...");
				System.out.print("Enter book ID: ");
				id = sc.nextInt();
				sc.nextLine();
				bk.readBook(id);
				System.out.println();
				break;
			case 3:
				System.out.println();
				System.out.println("Reading all books...");
				bk.readAllBooks();
				System.out.println();
				break;
			case 4:
				System.out.println();
				System.out.println("Updating a book...");
				System.out.print("Enter book ID: ");
				id = sc.nextInt();
				sc.nextLine();
				System.out.print("Enter new book title: ");
				title = sc.nextLine();
				System.out.print("Enter new book price: ");
				price = sc.nextFloat();
				sc.nextLine();
				bk.updateBook(id, title, price);
				System.out.println();
				break;
			case 5:
				System.out.println();
				System.out.println("Deleting a book...");
				System.out.print("Enter book ID: ");
				id = sc.nextInt();
				sc.nextLine();
				bk.deleteBook(id);
				System.out.println();
				break;
			case 6:
				System.out.println();
				System.out.println("Exiting...");
				sc.close();
				System.exit(0);
				break;
			default:
				System.out.println();
				System.out.println("\n" + "Invalid choice. Please try again.");
				System.out.println();
				break;
			}
		}
	}
}
