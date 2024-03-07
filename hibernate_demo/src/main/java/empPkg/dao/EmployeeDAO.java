package empPkg.dao;

// A simple Data Access Object (DAO) interface for Employee entity
public interface EmployeeDAO {
	public void createEmployee(String empName, float empSal);

	public void readEmployee(int empId);

	public void readAllEmployees();

	public void updateEmployee(int empId, String empName, float empSal);

	public void deleteEmployee(int empId);
}
