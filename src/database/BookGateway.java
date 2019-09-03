package database;

import java.sql.PreparedStatement;

// Row Data Gateway
public class BookGateway {
	private int id;
	private String title;
	private String author;
	private float price;
	private int copies;
	// String to update the database, sql 语法
	private static final String updateStatementString = 
			"UPDATE books " + 
					" set title = ?, author = ?, price = ?, copies = ?" +
					" where isbn = ?";
	// String to insert a new value to the database
	private static final String insertStatementString = 
			"INSERT INTO books VALUES (?,?,?,?,?)";
	
	public BookGateway(int id, String title, String author, float price, int copies) {
		super();
		this.author = author;
		this.id = id;
		this.title = title;
		this.price = price;
		this.copies = copies;
	}
	
	public int getId() {
		return id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public float getPrice() {
		return price;
	}
	
	public int getCopies() {
		return copies;
	}
	
	public void update() {
		PreparedStatement updateStatement = null;
		try {
			updateStatement = DBConnection.prepare(updateStatementString);
			updateStatement.setString(1, title);
			updateStatement.setString(2, author);
			updateStatement.setFloat(3, price);
			updateStatement.setInt(4, copies);
			updateStatement.setInt(5, id);
			
			updateStatement.execute();
		} catch (Exception e) {
			
		}
	}
	
	public void insert() {
		PreparedStatement insertStatement = null;
		try {
			insertStatement = DBConnection.prepare(insertStatementString);
			insertStatement.setString(1, title);
			insertStatement.setString(2, author);
			insertStatement.setFloat(3, price);
			insertStatement.setInt(4, copies);
			insertStatement.setInt(5, id);
			
			insertStatement.execute();
			
		}catch (Exception e) {
			
		}
		
	}
	
}
