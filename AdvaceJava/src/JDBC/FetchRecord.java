package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FetchRecord {
	public static void main(String[]args) {
		getResultByColumnName();
	}
	static void getResultByColumnName() {
try (Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/ebookshop","root","root");
				
				Statement statement = connection.createStatement();){
				
				ResultSet rs=statement.executeQuery("select * from users1");
				while(rs.next()) {
					System.out.print(rs.getInt("id"));
					System.out.print("\t");
					System.out.print(rs.getString("name"));
					System.out.print("\t");
					System.out.println(rs.getInt("password"));
				}
}
			
			catch(SQLException e) {
				System.out.println(e);
			}
	}
}
		
		
	


