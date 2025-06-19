package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class esha1 {
	private static final String createTableSQL = "create table USers1(id int(3) primary key,"+"name varchar(20), email varchar(20),"+ "country varchar(20),password varchar(20));";
	

	public static void main(String[] args) throws SQLException {
		esha1 createTableExample=new esha1();
		createTableExample.createTable();
		// TODO Auto-generated method stub

	}
	public void createTable() throws SQLException {
		System.out.println(createTableSQL);
		try (Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/ebookshop","root","root");
			
			Statement statement = connection.createStatement();){
			
			statement.execute(createTableSQL);
		}catch(SQLException e) {
			System.out.println(e);
		}
	}
	
	

}
