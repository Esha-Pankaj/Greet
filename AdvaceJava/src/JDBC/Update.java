package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Update {
	
	
		private static final String UpdateTableSQL= "update Users1 set name = \"Esha\" where id =2";
		
		public static void main(String[]args) throws SQLException{
			Update update =new Update();
			update.updateRecord();
			// TODO Auto-generated method stub

		}
		public void updateRecord() throws SQLException {
			System.out.println(UpdateTableSQL);
			try (Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/ebookshop","root","root");
				
				Statement statement = connection.createStatement();){
				
				int r=statement.executeUpdate(UpdateTableSQL);
				System.out.println("No of insertions:="+r);
			}catch(SQLException e) {
				System.out.println(e);
			}
		}
		}




