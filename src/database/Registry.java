package database;

import java.util.HashMap;
import java.util.Map;
import database.BookGateway;

public class Registry {
	private static Map<Integer, BookGateway> bookGateway = new HashMap<>();

	public static BookGateway getbook(int id) {
		return bookGateway.get(id);
	}
	
	public static void addbook(BookGateway book) {
		Registry.bookGateway.put(book.getId(), book);
	}
}
