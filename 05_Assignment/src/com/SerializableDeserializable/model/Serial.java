package com.SerializableDeserializable.model;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Serial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
		//create object of student
		Student student = new Student("Shivam", "shivampdh2105@gmail.com", 22, "Thane");
		
		//write data to file
		FileOutputStream fos = new FileOutputStream("ob.txt"); //state is saved in ob as byte code 
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		//how to serialize 
		oos.writeObject(student);
		
		oos.close();
		fos.close();
		
		System.out.println("Object state is transfered to file ob");
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

}
