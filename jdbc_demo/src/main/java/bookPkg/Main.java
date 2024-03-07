package bookPkg;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		bookDAO bk = new bookDAOimpl();
		int id;
		String title;
		double price;
		
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
				System.out.print("Enter book ID: ");
				id = sc.nextInt();
				sc.nextLine();
				System.out.print("Enter book title: ");
				title = sc.nextLine();
				System.out.print("Enter book price: ");
				price = sc.nextDouble();
				sc.nextLine();
				bk.create(id, title, price);
				System.out.println();
				break;
			case 2:
				System.out.println();
				System.out.println("Reading a book...");
				System.out.print("Enter book ID: ");
				id = sc.nextInt();
				sc.nextLine();
				bk.read(id);
				System.out.println();
				break;
			case 3:
				System.out.println();
				System.out.println("Reading all books...");
				bk.readAll();
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
				price = sc.nextDouble();
				sc.nextLine();
				bk.update(id, title, price);
				System.out.println();
				break;
			case 5:
				System.out.println();
				System.out.println("Deleting a book...");
				System.out.print("Enter book ID: ");
				id = sc.nextInt();
				sc.nextLine();
				bk.delete(id);
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
