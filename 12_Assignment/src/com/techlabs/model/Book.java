package com.techlabs.model;

public class Book {

	private String title;
	private String author;
	private double price;
	private int publication_year;
	
	public Book(String title, String author, double price, int publication_year) {
		super();
		this.title = title;
		this.author = author;
		this.price = price;
		this.publication_year = publication_year;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getPublication_year() {
		return publication_year;
	}
	public void setPublication_year(int publication_year) {
		this.publication_year = publication_year;
	}


	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", price=" + price + ", publication_year="
				+ publication_year + "]";
	}
	
	
}
