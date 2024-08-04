package com.techlabs.test;

import java.util.Scanner;

import com.techlabs.model.BookApp;

public class BookAppTest {

	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("");
		int size = scanner.nextInt();
		
		BookApp book[] = new BookApp[size];
		
		for(int i=0; i<book.length; i++) {
			System.out.println("Enter book Id: ");
			int bookId = scanner.nextInt();
			System.out.println("Enter Name of Book: ");
			String bookName = scanner.next();
			System.out.println("Enter Name of Author: ");
			String bookAuthor = scanner.next();
			System.out.println("Enter Price of Book: ");
			double bookPrice = scanner.nextDouble();
			
			book[i] = new BookApp(bookId, bookName, bookAuthor, bookPrice);
		}
		
		for(int i=0; i<book.length; i++) {
			book[i].boookDetails();
			
		}
		
		BookApp.sortedBooksPrice(book);
		
		for(BookApp books: book) {
			books.boookDetails();
		}
	}
	
}
