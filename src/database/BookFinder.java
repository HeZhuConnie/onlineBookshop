package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookFinder {
	private static final String findAvaliableBooksStatement = 
			"SELECT * from books WHERE copies > 0";
	private static final String findAllBooksStatement = 
			"SELECT * from books";
	
	public List<BookGateway> findAvaliableBooks(){
		List<BookGateway> result = new ArrayList<>();
		try {
			PreparedStatement stmt = DBConnection.prepare(findAvaliableBooksStatement);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				
				// workshop 03, constructing BookGateway without load() method
				System.out.println(rs.getInt(1));
				int id = rs.getInt(1);
				String titleArg = rs.getString(2);
				String authorArg = rs.getString(3);
				float priceArg = rs.getFloat(4);
				int qtyArg = rs.getInt(5);
				result.add(new BookGateway(id,titleArg, authorArg, priceArg,qtyArg));
			}
		
		} catch(Exception e) {
			System.out.println(e.getMessage());
		} 
		return result;
	}
	
	public List<BookGateway> findAllBooks(){
		List<BookGateway> result = new ArrayList<>();
		try {
			PreparedStatement stmt = DBConnection.prepare(findAllBooksStatement);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				System.out.println(rs.getInt(1));
				int id = rs.getInt(1);
				String titleArg = rs.getString(2);
				String authorArg = rs.getString(3);
				float priceArg = rs.getFloat(4);
				int qtyArg = rs.getInt(5);
				result.add(new BookGateway(id,titleArg, authorArg, priceArg,qtyArg));
			}
		} catch(Exception e) {
			
		}
		return result;
	}
	
	public static BookGateway load(ResultSet rs) throws SQLException{
		
		//BookGateway result = 
		
		int id = rs.getInt(1);
		String titleArg = rs.getString(2);
		String authorArg = rs.getString(3);
		float priceArg = rs.getFloat(4);
		int qtyArg = rs.getInt(5);
		
		return null;
		
		
	}
}
