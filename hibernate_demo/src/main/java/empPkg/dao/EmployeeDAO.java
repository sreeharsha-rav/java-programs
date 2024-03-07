package empPkg.dao;

import empPkg.entity.Address;

// A simple Data Access Object (DAO) interface for Employee entity
public interface EmployeeDAO {
	public void createEmployee(String empName, float empSal, Address address);

	public void readEmployee(int empId);

	public void readAllEmployees();

	public void updateEmployee(int empId, String empName, float empSal, Address address);

	public void deleteEmployee(int empId);
}
