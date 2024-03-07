package empPkg;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EmployeeDAOImpl implements EmployeeDAO {
	@Override
	public void insertEmployee(Employee emp){
	// Method to insert an employee into the database
		String sqlQuery = "INSERT INTO employees VALUES(?,?,?)";
		try (Connection empConn = EmployeeConnection.getConnection()) {
			PreparedStatement ps = empConn.prepareStatement(sqlQuery);
			ps.setInt(1, emp.getEmpId());
			ps.setString(2, emp.getEmpName());
			ps.setDouble(3, emp.getEmpSalary());
			ps.executeUpdate();
			System.out.println("Employee: \n" + emp + "\n inserted successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void readEmployee(int empId) {
	// Method to read an employee from the database
		String sqlQuery = "SELECT * FROM employees WHERE empId = ?";
		try (Connection empConn = EmployeeConnection.getConnection()) {
			PreparedStatement ps = empConn.prepareStatement(sqlQuery);
			ps.setInt(1, empId);
			ResultSet rs = ps.executeQuery();
			if (!rs.isBeforeFirst()) {
				System.out.println("No data found for employee number: " + empId);
				return;
			}
			while (rs.next()) {
				int empId2 = rs.getInt("empId");
				String empName = rs.getString("empName");
				double empSalary = rs.getDouble("empSalary");
				System.out.println("Employee Number: " + empId2 + ", Employee Name: " + empName + ", Employee Salary: "
						+ empSalary);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void updateEmployee(int empId){
		// Method to update employee salary
		String sqlQuery = "UPDATE employees SET empSalary = ? WHERE empId = ?";
		try (Connection empConn = EmployeeConnection.getConnection()) {
			PreparedStatement ps = empConn.prepareStatement(sqlQuery);
			ps.setDouble(1, 50000);
			ps.setInt(2, empId);
			int rowsUpdated = ps.executeUpdate();
			// Check if rowsUpdated is valid
			if (rowsUpdated == 0) {
				System.out.println("No data found for employee number: " + empId);
				return;
			}
			System.out.println("Rows updated: " + rowsUpdated);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void deleteEmployee(int empId) {
		// Method to delete employee
		String sqlQuery = "DELETE FROM employees WHERE empId = ?";
		try (Connection empConn = EmployeeConnection.getConnection()) {
			PreparedStatement ps = empConn.prepareStatement(sqlQuery);
			ps.setInt(1, empId);
			int rowsDeleted = ps.executeUpdate();
			// Check if rowsDeleted is valid
			if (rowsDeleted == 0) {
				System.out.println("No data found for employee number: " + empId);
				return;
			}
			System.out.println("Rows deleted: " + rowsDeleted);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
