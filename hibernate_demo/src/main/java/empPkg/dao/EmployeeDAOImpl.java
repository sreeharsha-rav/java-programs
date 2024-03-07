package empPkg.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import empPkg.entity.Employee;
import util.HibernateUtil;
import java.util.ArrayList;

// A simple Data Access Object (DAO) implementation for Employee entity
public class EmployeeDAOImpl implements EmployeeDAO {
	@Override
	public void createEmployee(String empName, float empSal) {
		try {
			// Initialize the session and transaction
			Session session = HibernateUtil.buildSessionFactory().openSession();
			Transaction tx = session.getTransaction();
			tx.begin();
			// Create a new employee
			Employee employee = new Employee(empName, empSal);
			session.persist(employee);
			System.out.println(employee);
			System.out.println("Employee created successfully!");
			tx.commit();
			session.close();
		} catch (Exception e) {
            e.printStackTrace();
		}
	}

	@Override
	public void readEmployee(int empId) {
		try {
			// Initialize the session and transaction
			Session session = HibernateUtil.buildSessionFactory().openSession();
			Transaction tx = session.getTransaction();
			tx.begin();
			Employee employee = session.get(Employee.class, empId);
			// Check if the employee exists
			if (employee == null) {
				System.out.println("Employee not found!");
			} else {
				System.out.println("Employee found!");
				System.out.println(employee);
				System.out.println("Employee read successfully!");
			}
			tx.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void readAllEmployees() {
		try {
			// Initialize the session and transaction
			Session session = HibernateUtil.buildSessionFactory().openSession();
			ArrayList<Employee> employees = (ArrayList<Employee>) session.createQuery("from Employee", Employee.class).list();
			// Check if there are any employees
			if (employees.isEmpty()) {
				System.out.println("No employees found!");
			} else {
				System.out.println("Employees found!");
				for (Employee employee : employees) {
					System.out.println(employee);
				}
				System.out.println("Employees read successfully!");
			}
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateEmployee(int empId, String empName, float empSal) {
		try {
			// Use a session to get the employee
			Session session = HibernateUtil.buildSessionFactory().openSession();
			Transaction tx = session.getTransaction();
			tx.begin();
			Employee employee = session.get(Employee.class, empId);
			tx.commit();
			session.close();
			// Check if the employee exists
			if (employee == null) {
				System.out.println("Employee not found!");
			} else {
				// Use a session to update the employee
				session = HibernateUtil.buildSessionFactory().openSession();
				tx = session.getTransaction();
				tx.begin();
				// Update the employee
				employee.setEmpName(empName);
				employee.setEmpSal(empSal);
				session.merge(employee);
				System.out.println(employee);
				System.out.println("Employee updated successfully!");
				tx.commit();
				session.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteEmployee(int empId) {
		try {
			// Initialize the session and transaction
			Session session = HibernateUtil.buildSessionFactory().openSession();
			Transaction tx = session.getTransaction();
			tx.begin();
			Employee employee = session.get(Employee.class, empId);
			// Check if the employee exists
			if (employee == null) {
				System.out.println("Employee not found!");
			} else {
				// Delete the employee
				session.remove(employee);
				System.out.println(employee);
				System.out.println("Employee deleted successfully!");
			}
			tx.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
