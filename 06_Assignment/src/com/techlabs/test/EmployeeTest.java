package com.techlabs.test;

import java.util.Scanner;

import com.techlabs.model.Employee;

public class EmployeeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//Employee employee = new Employee();
		
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("enter size of your array: ");
		int size = scanner.nextInt();
		
		Employee employee[] = new Employee[size];
		for(int i=0; i<employee.length; i++) {
			System.out.println("Enter Employee Id: ");
			int id = scanner.nextInt();
			
			System.out.println("Enter Name: ");
			String  name = scanner.next();
			
			System.out.println("Enter Salary: ");
			int salary = scanner.nextInt();
			
			employee[i] = new Employee(id, name, salary);
		}
		
		for(int i =0; i<employee.length; i++) {
			employee[i].displayEmployeeDetails();
		}
		
		/*
		employee.setEmployeeId(id);
		employee.setEmployeeName(name);
		employee.setSalary(salary);
		*/
		/*
		System.out.println("Id of Employee: " + employee.getEmployeeId());
		System.out.println("Id of Employee: " + employee.getEmployeeName());
		System.out.println("Id of Employee: " + employee.getSalary());
		*/
		
	}

}
