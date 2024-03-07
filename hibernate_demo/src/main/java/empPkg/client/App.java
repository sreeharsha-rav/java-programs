package empPkg.client;

import java.util.Scanner;
import empPkg.dao.EmployeeDAO;
import empPkg.dao.EmployeeDAOImpl;

// A simple console-based application to perform CRUD operations on Employee entity
public class App {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		EmployeeDAO emp = new EmployeeDAOImpl();
		int id;
		String name;
		float sal;
		
		// Menu-driven code
		while (true) {
			System.out.println("********** Employee CRUD Menu **********");
			System.out.println("1. Create an employee");
			System.out.println("2. Read an employee");
			System.out.println("3. Read all employees");
			System.out.println("4. Update an employee");
			System.out.println("5. Delete an employee");
			System.out.println("6. Exit");
			System.out.println("***************************************");
			System.out.print("Enter your choice: ");
			int choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {
			case 1:
				System.out.println();
				System.out.println("Creating an employee...");
				System.out.print("Enter employee name: ");
				name = sc.nextLine();
				System.out.print("Enter employee salary: ");
				sal = sc.nextFloat();
				sc.nextLine();
				emp.createEmployee(name, sal);
				System.out.println();
				break;
			case 2:
				System.out.println();
				System.out.println("Reading an employee...");
				System.out.print("Enter employee ID: ");
				id = sc.nextInt();
				sc.nextLine();
				emp.readEmployee(id);
				System.out.println();
				break;
			case 3:
				System.out.println();
				System.out.println("Reading all employees...");
				emp.readAllEmployees();
				System.out.println();
				break;
			case 4:
				System.out.println();
				System.out.println("Updating an employee...");
				System.out.print("Enter employee ID: ");
				id = sc.nextInt();
				sc.nextLine();
				System.out.print("Enter new employee name: ");
				name = sc.nextLine();
				System.out.print("Enter new employee salary: ");
				sal = sc.nextFloat();
				sc.nextLine();
				emp.updateEmployee(id, name, sal);
				System.out.println();
				break;
			case 5:
				System.out.println();
				System.out.println("Deleting an employee...");
				System.out.print("Enter employee ID: ");
				id = sc.nextInt();
				sc.nextLine();
				emp.deleteEmployee(id);
				System.out.println();
				break;
			case 6:
				System.out.println();
				System.out.println("Exiting the application...");
				sc.close();
				System.exit(0);
			default:
				System.out.println();
				System.out.println("Invalid choice! Please try again...");
				System.out.println();
			}
		}
	}
}
