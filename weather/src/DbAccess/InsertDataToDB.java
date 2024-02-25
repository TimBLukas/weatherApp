package DbAccess;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javax.swing.JOptionPane;

/**
 * A class containing all the methods to insert data into the database
 * 
 * @author TBL
 * @version 1.0
 */
public class InsertDataToDB {

	private static String dbName = "weatherapp";
	private static String url = "jdbc:mysql://127.0.0.1:3306/" + dbName + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private static String driver = "com.mysql.cj.jdbc.Driver";
	private static String username = "root";
	private static String password;
	
	static {
	    password = getPassword();
	    if (password.equals("ERROR")) {
	        JOptionPane.showMessageDialog(null, "Fehler beim Abrufen der Daten", "ERROR", JOptionPane.ERROR_MESSAGE);
	    }
	}
	
	
	/**
	 * a method to create a new user and save that user in the database
	 * 
	 * @param userName the username for the new user
	 * @param password the password for the new user
	 */
	public static void createUser(String userName, String password) {
		
		try {
			
			String sql = "INSERT INTO `weatherapp`.`tusers` (`userName`, `EncryptedPw`)"
					+ "VALUES ("
					+ "'"+ userName +"', '"
					+ password + "')";
			
			Connection connection = establishConnection();
			
			Statement statement = connection.createStatement();
			statement.executeUpdate(sql);
			
			
			try {
				
				if(connection != null) connection.close();
				if(statement != null) statement.close();
				
			}catch(SQLException e) {
				
				e.printStackTrace();
				
			}
			
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	/*
	 * a method to create a connection for the database
	 */
	public static Connection establishConnection() {
		
		Connection connection = null;
		
		try
		{

			Class.forName(driver);
				
			connection = DriverManager.getConnection(url, username, password);
			
			
		}catch(Exception e) 
		{
			System.out.println(e.getMessage());
			
		}
		
		return connection;
	}
	
	/**
	 * a method to retrieve the password
	 * 
	 * @return returns the password for the database
	 */
	
	private static String getPassword() {
		
		String pw = null;
		
		File tf = new File ("../weather/src/DbAccess/PWF");
		
		try {
			
			Scanner scanner = new Scanner(tf);
			if(scanner.hasNext()) pw = scanner.nextLine();
			
			scanner.close();
		}catch(FileNotFoundException fileNotFound) {
			
			System.out.println(fileNotFound.getMessage());
			
		}catch (Exception exception) {
			
			System.out.println(exception.getMessage());
			
		}
		
		if(pw == null) return "ERROR";
		
		return pw;
	}
}