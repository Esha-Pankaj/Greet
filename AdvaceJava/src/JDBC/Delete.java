package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Delete {
	private static final String DeleteTableSQL= "delete from Users1 where id = 3;";
	
	public static void main(String[]args) throws SQLException{
		Delete del =new Delete();
		del.deleteRecord();
		// TODO Auto-generated method stub

	}
	public void deleteRecord() throws SQLException {
		System.out.println(DeleteTableSQL);
		try (Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/ebookshop","root","root");
			
			Statement statement = connection.createStatement();){
			
			int r=statement.executeUpdate(DeleteTableSQL);
			System.out.println("No of deleted from users1:="+r);
		}catch(SQLException e) {
			System.out.println(e);
		}
	}
	}






