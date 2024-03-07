package empPkg.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Embedded;

@Entity
@Table(name = "employees")
public class Employee { // Employee POJO class entity
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "emp_id")
	private int empId;
	@Column(name = "emp_name")
	private String empName;
	@Column(name = "emp_sal")
	private float empSal;
	@Embedded
	private Address address;
	
	// Default constructor
	public Employee() {
	}
	
	// Parameterized constructor
	public Employee(String empName, float empSal, Address address) {
		this.empName = empName;
		this.empSal = empSal;
		this.address = address;
	}
	
	// Getters and setters
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
	
	public float getEmpSal() {
		return empSal;
	}
	
	public void setEmpSal(float empSal) {
		this.empSal = empSal;
	}
	
	public Address getAddress() {
		return address;
	}
	
	public void setAddress(Address address) {
		this.address = address;
	}
	
	// toString method
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empSal=" + empSal + ", address=" + address
				+ "]";
	}
}
