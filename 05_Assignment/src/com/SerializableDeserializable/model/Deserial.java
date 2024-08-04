package com.SerializableDeserializable.model;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Deserial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			
			FileInputStream fis = new FileInputStream("ob.txt"); //reference of serialization
			ObjectInputStream ois = new ObjectInputStream(fis);//to read object of stream
			
			Student student = (Student)ois.readObject();
			student.displayName(); // to check my Student reference is able to retrieve data from Student
			
			System.out.println(student.getName());
			System.out.println(student.getEmail());
			System.out.println(student.getAge());
			System.out.println(student.getAddress());
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

}
