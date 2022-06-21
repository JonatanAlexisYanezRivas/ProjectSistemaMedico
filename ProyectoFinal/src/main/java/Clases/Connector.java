package Clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {

	private final String bd = "bdSistemaMedico";
	private final String user = "root";
	private final String pass = "Root";
	private final String url = "jdbc:mysql://localhost:3306/"+bd;
	private Connection con = null;
	
	public Connection getConnection() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Dirver");
			con = DriverManager.getConnection(url,user,pass);
		}catch (SQLException | ClassNotFoundException ex) {
			System.out.println(ex);
		}
		
		return con;
	}
}
