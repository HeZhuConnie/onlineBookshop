package database;
import java.sql.*;

public class DBConnection {
	// JDBC driver name and database URL
	private static final String DB_CONNECTION = "jdbc:postgresql://localhost:5432/bookshop";
	
	// Database credentials
	
	private static final String DB_USER = "postgres";
	private static final String DB_PASSWORD = "Hehe3250413";
	
	static Connection dbConnection = null;
	
	public static PreparedStatement prepare(String stm) throws SQLException{
		PreparedStatement preparedStatement = null;
		try {
			Connection dbConnection = getDBConnection();
			preparedStatement = dbConnection.prepareStatement(stm);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return preparedStatement;
	}

	private static Connection getDBConnection() {
		// TODO Auto-generated method stub
		try {
			// register JDBC driver
			DriverManager.deregisterDriver(new org.postgresql.Driver());
			// open a connection
			dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
			dbConnection.setAutoCommit(false);
			
			return dbConnection;
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
}
