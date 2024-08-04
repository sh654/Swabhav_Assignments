package com.SerializableDeserializable.model;

import java.io.Serializable;

public class Student implements Serializable {
	
	private String name;
	// iF we want to make a variable to save from serialization we use transient var
	transient private String email;
	private int age;
	private String address;
	
	
	public Student(String name, String email, int age, String address){
		this.name = name;
		this.email = email;
		this.age = age;
		this.address = address;
	}
	
	public Student() {
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public void displayName() {
		System.out.println("hi my name is :" +this.name);
	}
}
