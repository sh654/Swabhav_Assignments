package com.techlabs.model;

public class Employee {

//	employeeId, name, salaray
	
	private int employeeId;
	private String employeeName;
	private int salary;
	
	public Employee(int employeeId, String employeeName, int salary) {
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.salary = salary;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	public int getEmployeeId() {
		return this.employeeId;
	}
	
	public String getEmployeeName() {
		return this.employeeName;
	}
	
	public int getSalary() {
		return this.salary;
	}
	
	public void displayEmployeeDetails() {
		System.out.println("Employee Id: "+ this.getEmployeeId());
		System.out.println("Employee Name: "+ this.getEmployeeName());
		System.out.println("Employee Salary: "+ this.getSalary());
	}
}
