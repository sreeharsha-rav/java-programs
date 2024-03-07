package empPkg;

public interface EmployeeDAO {
	public void insertEmployee(Employee emp);
	public void readEmployee(int empId);
	public void updateEmployee(int empId);
	public void deleteEmployee(int empId);
}
