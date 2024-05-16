package Application;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	
	public Connection getConnection() {
		try {
			return DriverManager.getConnection(
					"jdbc:sqlserver://localhost:1433;databaseName=loja;user=sa;password=123"
					);
		}
		catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
}