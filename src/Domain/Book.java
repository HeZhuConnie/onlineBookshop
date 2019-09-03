package Domain;

import java.util.ArrayList;
import java.util.List;
import database.*;

public class Book {
	public int id;
	public String title;
	public String author;
	public float price;
	public int copies;
	
	
	public Book(int id, String title, String author, float price, int copies) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.price = price;
		this.copies = copies;
	}
	
	public int getId() { return id; }
	public void setId(int id) {this.id = id;}
	
	public String getTitle() { return title; }
	public void setTitle(String title) { this.title = title; }
	
	public String getAuthor() { return author; }
	public void setAuthor() { this.author = author;}
	
	public float getPrice() { return price; }
	public void setPrice(float price) {this.price = price; }
	
	public int getCopies() { return copies; }
	public void setCopies(int copies) {this.copies = copies;}
	
	public static List<Book> getAllAvaliableBooks(){
		BookFinder finder = new BookFinder();
		List<Book> result = new ArrayList<Book>();
		List<BookGateway> booksRecords = finder.findAvaliableBooks();
		
		for(BookGateway br:booksRecords) {
			Book book = new Book(br.getId(),br.getTitle(),br.getAuthor(),br.getPrice(),br.getCopies());
			result.add(book);
		}
		
		return result;
	}
	
	public static List<Book> getAllBooks(){
		BookFinder finder = new BookFinder();
		List<Book> result = new ArrayList<Book>();
		List<BookGateway> booksRecords = finder.findAllBooks();
		
		for(BookGateway br:booksRecords) {
			Book book = new Book(br.getId(),br.getTitle(),br.getAuthor(),br.getPrice(),br.getCopies());
			result.add(book);
		}
		return result;
	}

}
