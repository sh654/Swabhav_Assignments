package com.techlabs.model;

public class BookApp {

//	 Book(bookId, name, author, price).  Constructors. Getters, setters.
//	  - Create a test class to create n number of books and display books in descending order of price
//}
	
	private int bookId;
	private String bookName;
	private String bookAuthor;
	private double bookPrice;
	
	public BookApp(int bookId, String bookName, String bookAuthor, double bookPrice) {
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
		this.bookPrice = bookPrice;
	}
	
	public int getBookId() {
		return this.bookId;
	}
	
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	
	public String getBookAuthor() {
		return this.bookAuthor;
	}
	
	public void setbookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	
	public String getBookName() {
		return this.bookName;
	}
	
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	
	public double getBookPrice() {
		return this.bookPrice;
	}
	
	public void setBookPrice(double bookPrice) {
		this.bookPrice = bookPrice;
	}
	
	public void boookDetails() {
		System.out.println("Your Book Id: "+getBookId());
		System.out.println("Book Name: "+getBookName());
		System.out.println("Book Author: "+getBookAuthor());
		System.out.println("Book Price: ₹"+getBookPrice());
	}
	
	public static BookApp[] sortedBooksPrice(BookApp[] prices) {
		BookApp lowprice = prices[0];
//		double lowprice = prices[0].getBookPrice();
		if(prices.length==0) {
			return null;
		}
		else {
			for(BookApp price: prices) {
				if(lowprice.getBookPrice() > price.getBookPrice()) {
					lowprice = price;
				}
			}
			
		}
		return prices;
	}
}
