package rgr.util;



import java.sql.DriverManager;

import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.math.BigDecimal;
//import java.security.NoSuchAlgorithmException;
//import java.security.spec.InvalidKeySpecException;
import java.sql.SQLException;

public class PostgresConnector {

	private static java.sql.Connection connection;
	private static PostgresConnector pgc = new PostgresConnector( );
	private PostgresConnector(){ }
	public static PostgresConnector getInstance( ) {      return pgc;}
	public static java.sql.Connection getConnection(){ 
		try {
			if(connection==null || connection.isClosed()){ connection=init();}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return connection;
	}
	
	public static void doUpdate(String sql){
		try{			
			connection = getConnection();		
			PreparedStatement prepstmt = connection.prepareStatement(sql);   
			prepstmt.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

	private static java.sql.Connection init(){
		connection = null;
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException "+e+"<br />");
			System.out.println("Where is your PostgreSQL JDBC Driver? Include in your library path!<br />");
		}
		try {	
			connection = DriverManager.getConnection(
					
			"jdbc:postgresql://aa1w2fh7xu35vbl.cngclcqagnfu.us-west-2.rds.amazonaws.com:5432/ebdb?user=rgrsiteuser&password=shadrach99");
			/*
				
					"jdbc:postgresql://127.0.0.1:5432/testDataOne", 
					"postgres",
					"Saturn5");
			
			*/
			
			//acurecord.cowdurfgakww.us-west-2.rds.amazonaws.com:5432/iatl?user=acusiteuser&password=shadrach99
			
			
			
			//messages.append("connection succeeded <br />");
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console<br />");
			e.printStackTrace();
		}
		if (connection == null) {
			System.out.println("Failed to make connection!\n");
		}
		return connection;
	}

	
	
}

