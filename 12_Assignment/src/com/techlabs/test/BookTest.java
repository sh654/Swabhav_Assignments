package com.techlabs.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.techlabs.model.Book;
import com.techlabs.model.BookComperator;

public class BookTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in); 
		System.out.println("Enter the ");
		List<Book> books = new ArrayList<Book>(); 
		
		bookTitle(books, scanner);
		// 
		System.out.println("Original list of students:");
		printDetails(books);
		
		//Sorting first Author, Title then price;
		System.out.println("Sorting first by Author, Title and last By Price");
		compareSort1(books);
		printDetails(books);
		
		// 2 sort 
		System.out.println("Sorting first by Publication Year, Price, Author");
		compareSort2(books);
		printDetails(books);
	}
	
	public static void bookTitle(List<Book> books, Scanner scanner) {
		int size = scanner.nextInt();
		for(int i=0; i<size; i++) {
			
			System.out.println("Enter book title: ");
			String title = scanner.next();
			System.out.println("Enter book Author : ");
			String author = scanner.next();
			System.out.println("Enter price of book: ");
			double price = scanner.nextDouble();
			System.out.println("Enter year of publication: ");
			int publication_year = scanner.nextInt();
			
			books.add(new Book(title, author, price, publication_year));
		}
	}
	
	public static void printDetails(List<Book> books) {
		for(Book book : books) {
			System.out.println(book);
		}
	}
	
	public static void compareSort1(List<Book> books) {
		books.sort(new BookComperator.BookAuthor().thenComparing(new BookComperator.BookTitle()).thenComparing(new BookComperator.BookPrice()));
	}
	
	
	public static void compareSort2(List<Book> books) {
		books.sort(new BookComperator.BookPulicationYear().thenComparing(new BookComperator.BookPrice()).thenComparing(new BookComperator.BookAuthor()));
	}
}

