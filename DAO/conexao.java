package main_package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexao {

	public Connection GetConnection() {
		try {
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/northwind", "root", "");
		}
		catch(SQLException e) {
			e.getMessage();
			
			return null;
		}
	}
	
}