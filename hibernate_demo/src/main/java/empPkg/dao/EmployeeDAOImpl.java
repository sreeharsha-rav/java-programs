package empPkg.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import empPkg.entity.Employee;
import empPkg.entity.Address;
import util.HibernateUtil;
import java.util.ArrayList;


// A simple Data Access Object (DAO) implementation for Employee entity
public class EmployeeDAOImpl implements EmployeeDAO {
	@Override
	public void createEmployee(String empName, float empSal, Address address) {
		try {
			// Create an Employee object
			Employee emp = new Employee(empName, empSal, address);
			// Initialize Session and Transaction objects
			Session session = HibernateUtil.buildSessionFactory().openSession();
			Transaction tx = session.getTransaction();
			tx.begin();
			// Save the Employee object
			session.persist(emp);
			tx.commit();
			// Close the Session
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void readEmployee(int empId) {
		try {
			// Initialize Session object
			Session session = HibernateUtil.buildSessionFactory().openSession();
			// Read an Employee object
			Employee emp = session.get(Employee.class, empId);
			// check if the Employee object exists
			if (emp == null) {
				System.out.println("Employee with ID " + empId + " does not exist");
			} else {
				// Display the Employee object
				System.out.println("Employee ID: " + emp.getEmpId());
				System.out.println("Employee Name: " + emp.getEmpName());
				System.out.println("Employee Salary: " + emp.getEmpSal());
				System.out
						.println("Employee Address: " + emp.getAddress().getStreet() + ", " + emp.getAddress().getCity()
								+ ", " + emp.getAddress().getState() + ", " + emp.getAddress().getZip());
			}
			// Close the Session
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void readAllEmployees() {
		try {
			// Initialize Session object
			Session session = HibernateUtil.buildSessionFactory().openSession();
			// Read all Employee objects
			ArrayList<Employee> employees = (ArrayList<Employee>) session.createQuery("FROM Employee", Employee.class).getResultList();
			// check if the Employee objects exist
			if (employees.isEmpty()) {
				System.out.println("No Employee records found");
			} else {
				// Display the Employee objects
				for (Employee emp : employees) {
					System.out.println("Employee ID: " + emp.getEmpId());
					System.out.println("Employee Name: " + emp.getEmpName());
					System.out.println("Employee Salary: " + emp.getEmpSal());
					System.out.println(
							"Employee Address: " + emp.getAddress().getStreet() + ", " + emp.getAddress().getCity()
									+ ", " + emp.getAddress().getState() + ", " + emp.getAddress().getZip());
					System.out.println();
				}
			}
			// Close the Session
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void updateEmployee(int empId, String empName, float empSal, Address address) {
		try {
			// Initialize Session and Transaction objects
			Session session = HibernateUtil.buildSessionFactory().openSession();
			Transaction tx1 = session.getTransaction();
			tx1.begin();
			// Read an Employee object
			Employee emp = session.get(Employee.class, empId);
			tx1.commit();
			// check if the Employee object exists
			if (emp == null) {
				System.out.println("Employee with ID " + empId + " does not exist");
			} else {
				// Initialize Transaction object
				Transaction tx2 = session.getTransaction();
				tx2.begin();
				// Update the Employee object
				emp.setEmpName(empName);
				emp.setEmpSal(empSal);
				emp.setAddress(address);
				session.merge(emp);
				tx2.commit();
				System.out.println("Employee with ID " + empId + " updated successfully");
			}
			// Close the Session
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void deleteEmployee(int empId) {
		try {
			// Initialize Session and Transaction objects
			Session session = HibernateUtil.buildSessionFactory().openSession();
			Transaction tx1 = session.getTransaction();
			tx1.begin();
			// Read an Employee object
			Employee emp = session.get(Employee.class, empId);
			tx1.commit();
			// check if the Employee object exists
			if (emp == null) {
				System.out.println("Employee with ID " + empId + " does not exist");
			} else {
				// Initialize Transaction object
				Transaction tx2 = session.getTransaction();
				tx2.begin();
				// Delete the Employee object
				session.remove(emp);
				tx2.commit();
				System.out.println("Employee with ID " + empId + " deleted successfully");
			}
			// Close the Session
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
