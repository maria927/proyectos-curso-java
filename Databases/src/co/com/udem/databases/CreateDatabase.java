package co.com.udem.databases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDatabase {
	
	static final String JDBC_DRIVER = "org.h2.Driver"; //Para conectarse a h2
	static final String DB_URL = "jdbc:h2:~/test";
	static final String USER= "sa";
	static final String PASSWORD= "";
	
	public static void main(String[] args) {
	
		Connection conn = null;
		Statement stmt = null;
		
		
		try {
			//Paso 1: Registrar driver
			Class.forName(JDBC_DRIVER);
			
			//Paso 2: Hacer la conexión
			conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
			stmt = conn.createStatement();
			String sql = "CREATE TABLE REGISTRO "+
						 "(ID INTEGER not NULL, "+
						 "NOMBRE VARCHAR(255), "+
						 "APELLIDO VARCHAR(255), "+
						 "EDAD INTEGER, "+
						 "PRIMARY KEY (ID))";
			stmt.executeUpdate(sql);
			stmt.close();
			conn.close();
			
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally //Si se generó excepción, de todas maneras para por el finally
		{
			if(stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		}
		

	}

}
