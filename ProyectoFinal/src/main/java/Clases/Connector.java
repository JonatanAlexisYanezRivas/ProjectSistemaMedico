package Clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {

	private final String bd = "sistemaMedico";
	private final String user = "root";
	private final String pass = "Root";
	private final String url = "jdbc:mysql://localhost:3306/"+bd;
	private Connection con = null;
	
	 public Connection getConexion(){
	        try {
	        	Class.forName("com.mysql.cj.jdbc.Driver");
	            con = DriverManager.getConnection(url, user, pass);
	        } catch (ClassNotFoundException | SQLException ex) {
	        	System.out.println("Error: " + ex);
	        }
	         return con;
	    }
}
