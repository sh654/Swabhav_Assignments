package com.techlabs.iterator.model;

public class Employee {

	private String name;
	private double salary;
	
	public Employee(String name, double salary) {
		super();
		this.name = name;
		this.salary = salary;
	}
	
	
	public double getSalary() {
		return salary;
	}
}
