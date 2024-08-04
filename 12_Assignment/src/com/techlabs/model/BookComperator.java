package com.techlabs.model;
import java.util.Comparator;
public class BookComperator  {
	public static class BookTitle implements Comparator<Book>{
		@Override
		public int compare(Book book1, Book book2) {
			return book1.getTitle().compareTo(book2.getTitle());
		}
	}
	public static class BookAuthor implements Comparator<Book>{
		@Override
		public int compare(Book book1, Book book2) {
			return book1.getAuthor().compareTo(book2.getAuthor());
		}
	}
	public static class BookPrice implements Comparator<Book>{
		@Override
		public int compare(Book book1, Book book2) {
			if(book1.getPrice() > book2.getPrice())
				return 1;
			if(book1.getPrice() < book2.getPrice())
				return -1;
			return 0;
		}
	}
	public static class BookPulicationYear implements Comparator<Book>{
		@Override
		public int compare(Book book1, Book book2) {
			if(book1.getPublication_year() > book2.getPublication_year())
				return 1;
			if(book1.getPublication_year() < book2.getPublication_year())
				return -1;
			
			return 0;
		}
	}

}
