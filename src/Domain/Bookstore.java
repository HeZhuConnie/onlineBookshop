package Domain;
import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Bookstore {
	
	private ArrayList<Book> books = new ArrayList<Book>();
	private ArrayList<Book> selectedBooks = 
			new ArrayList<Book>();
	private Cart mycart = new Cart(selectedBooks);
	
	public static void main(String args[]) {
		
	}
	
	// retireve all books from DB, send them to View (JSP)
	public ArrayList<Book> viewBooks() {
		return this.books;
	}
	
	// view details for selected book
	public Book viewDetail(int id) {
		return this.books.get(id);
	}
	
	// add book to cart
	public void addToCart(int id) {
		String title = this.books.get(id).title;
		String auth = this.books.get(id).author;
		float price = this.books.get(id).price;
		int copies = this.books.get(id).copies;
		
		Book bookA = new Book(id, title, auth, price,copies);
		this.selectedBooks.add(bookA);
	}
	
	// show cart content
	public void showCart() {
		int noOfSelected = selectedBooks.size();
		
		for(int j=0; j<noOfSelected; j++) {
			int bookID = selectedBooks.get(j).id;
			String bookTitle = selectedBooks.get(j).title;
			String bookAuth = selectedBooks.get(j).author;
			float bookPrice = selectedBooks.get(j).price;
			int bookCopies = selectedBooks.get(j).copies;
			
			System.out.println("Book" + bookID + " " + bookTitle + " " + bookAuth + " " + bookPrice + " " + bookCopies);
		}
	}
	
	// generate invoice 
	public int generateInvoice() {
		int totalCost = 0;
		for(int j=0; j<selectedBooks.size();j++) {
			totalCost += selectedBooks.get(j).price;
		}
		return totalCost;
	}
	
	
	// update a customer's order history
	public void updateHistory() {
		
	}
}

