package co.com.udem.databases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class QueryDatabase {

	static final String JDBC_DRIVER = "org.h2.Driver"; //Para conectarse a h2
	static final String DB_URL = "jdbc:h2:~/test";
	static final String USER= "sa";
	static final String PASSWORD= "";
	
	public static void main(String[] args) {
		Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try{
           // STEP 1: Register JDBC driver
           Class.forName(JDBC_DRIVER);
          
           // STEP 2: Open a connection
           System.out.println("Connecting to a selected database...");
           conn = DriverManager.getConnection(DB_URL,USER,PASSWORD);
           //conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/server~/test",USER,PASS);
           System.out.println("Connected database successfully...");
          
           // STEP 3: Execute a query
           stmt = conn.createStatement();
           String sql = "SELECT ID, NOMBRE, APELLIDO, EDAD FROM Registro";
            rs= stmt.executeQuery(sql);
           while (rs.next()) {
			int id = rs.getInt("ID");
			String nombre = rs.getString("NOMBRE");
			String apellido = rs.getString("APELLIDO");
			int edad = rs.getInt("EDAD");
			
			System.out.println("*ID: "+id+" *NOMBRE: "+nombre+" *APELLIDO: "+apellido+" *EDAD: "+edad);
           }
          
           // STEP 4: Clean-up environment
           rs.close();
           stmt.close();
           conn.close();
        } catch(SQLException se) {
           // Handle errors for JDBC
           se.printStackTrace();
        } catch(Exception e) {
           // Handle errors for Class.forName
           e.printStackTrace();
        } finally {
           // finally block used to close resources
           try {
              if(stmt!=null) stmt.close();
           } catch(SQLException se2) {
           } // nothing we can do
           try {
              if(conn!=null) conn.close();
           } catch(SQLException se) {
              se.printStackTrace();
           } // end finally try
           
           try {
               if(rs!=null) rs.close();
            } catch(SQLException se) {
               se.printStackTrace();
            } 
          
        } // end try
        System.out.println("Goodbye!");

	}

}
