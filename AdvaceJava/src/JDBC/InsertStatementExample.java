package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertStatementExample {
	private static final String InsertTableSQL= "INSERT INTO Users1 " + 
			"VALUES (1,'Pramod','pramod@gmail.com','India',123)," + 
			"(2,'Deepa','deepa@gmail.com','India',123)," +
			"(3,'Tom','top@gmail.com','India',123);";
	
	public static void main(String[]args) throws SQLException{
		InsertStatementExample insertTableExample =new InsertStatementExample();
		insertTableExample.insertTable();
		// TODO Auto-generated method stub

	}
	public void insertTable() throws SQLException {
		System.out.println(InsertTableSQL);
		try (Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/ebookshop","root","root");
			
			Statement statement = connection.createStatement();){
			
			int r=statement.executeUpdate(InsertTableSQL);
			System.out.println("No of insertions:="+r);
		}catch(SQLException e) {
			System.out.println(e);
		}
	}
	}


