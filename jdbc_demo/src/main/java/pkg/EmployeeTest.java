package pkg;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class EmployeeTest {
	
	// Method to fetch employee details from the database given the employee number
	public void fetchEmployee(int empNo) {
		String query = "SELECT * FROM employees WHERE emp_no = ?";
		try (Connection conn = EmployeeConnection.getConnection()) {
			PreparedStatement prepStmt = conn.prepareStatement(query);
			prepStmt.setInt(1, empNo);
			ResultSet rs = prepStmt.executeQuery();
			// Check if rs is valid
			if (!rs.isBeforeFirst()) {
				System.out.println("No data found for employee number: " + empNo);
				return;
			}
			// Loop through the data and print all of it
			while (rs.next()) {
				int empNo2 = rs.getInt("emp_no");
				String empName = rs.getString("emp_name");
				double empSal = rs.getDouble("emp_sal");
				System.out.println("Employee Number: " + empNo2 + 
								   ", Employee Name: " + empName + 
								   ", Employee Salary: " + empSal);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// Method to update employee salary
	public void updateEmployee(int empNo, double newSal) {
		String query = "UPDATE employees SET emp_sal = ? WHERE emp_no = ?";
		try (Connection conn = EmployeeConnection.getConnection()) {
			PreparedStatement prepStmt = conn.prepareStatement(query);
			prepStmt.setDouble(1, newSal);
			prepStmt.setInt(2, empNo);
			int rowsUpdated = prepStmt.executeUpdate();
			System.out.println("Rows updated: " + rowsUpdated);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// Method to delete employee
	public void deleteEmployee(int empNo) {
		String query = "DELETE FROM employees WHERE emp_no = ?";
		try (Connection conn = EmployeeConnection.getConnection()) {
			PreparedStatement prepStmt = conn.prepareStatement(query);
			prepStmt.setInt(1, empNo);
			int rowsDeleted = prepStmt.executeUpdate();
			System.out.println("Rows deleted: " + rowsDeleted);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		// Accept employee number from the user
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter employee number: ");
		int empNo = sc.nextInt();
		sc.nextLine();
		
		// Fetch employee details
		EmployeeTest et = new EmployeeTest();
		System.out.println("Fetching employee details...");
		et.fetchEmployee(empNo);
		
		// Accept new salary from the user
		System.out.println("Enter new salary: ");
		double newSal = sc.nextDouble();
		sc.nextLine();
		System.out.println("Updating salary...");
		et.updateEmployee(empNo, newSal);
		System.out.println("Salary updated!");
		
		// Fetch employee details again
		System.out.println("Fetching employee details after update...");
		et.fetchEmployee(empNo);
		
		// Delete employee
		System.out.println("Deleting employee...");
		et.deleteEmployee(empNo);
		System.out.println("Employee deleted!");
		
		// Fetch employee details again
		System.out.println("Fetching employee details after delete...");
		et.fetchEmployee(empNo);
		sc.close();
	}
}
