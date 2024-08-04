package com.techlabs.iterator.test;

import java.util.ArrayList;
import java.util.List;

import com.techlabs.iterator.model.Company;
import com.techlabs.iterator.model.Employee;
import com.techlabs.iterator.model.Iterator;

public class IteratorTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Employee> employees = new ArrayList<>();
		
		employees.add(new Employee("Anata", 5000));
		employees.add(new Employee("Bagga", 4500));
		employees.add(new Employee("Samana", 6000));
		
		Company company = new Company(employees);
		Iterator<Employee> iterator = company.createIterator();
		
		double totalSalary = 0;
		while(iterator.hasNext()) {
			totalSalary += iterator.next().getSalary();
		}
		
		System.out.println("Total Salary : "+ totalSalary);
	}

}
