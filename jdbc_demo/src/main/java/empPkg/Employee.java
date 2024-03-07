package empPkg;

// Employee POJO class
public class Employee {
	int empId;
	String empName;
	double empSalary;
	
	public Employee(int empId, String empName, double empSalary) {
		this.empId = empId;
		this.empName = empName;
		this.empSalary = empSalary;
	}
	
	// Getters and Setters
	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}
	
	public String getEmpName() {
		return empName;
	}
	
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	
	public double getEmpSalary() {
		return empSalary;
	}
	
	public void setEmpSalary(double empSalary) {
		this.empSalary = empSalary;
	}
	
	// toString method
	@Override
	public String toString() {
		return "{" 
				+ "empId = " + empId 
				+ ", empName = " + empName 
				+ ", empSalary = " + empSalary
				+ "}";
	}
	
}
