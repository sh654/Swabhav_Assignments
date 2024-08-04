package com.techlabs.iterator.model;

import java.util.List;

public class Company implements Aggregate<Employee>{

	private List<Employee> employees;
	
	public Company(List<Employee> employees) {
		this.employees = employees;
	}
	
	@Override
	public Iterator<Employee> createIterator() {
		// TODO Auto-generated method stub
		return new ConcreteIterator(employees);
	}

}
