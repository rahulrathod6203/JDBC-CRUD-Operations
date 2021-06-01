package com.jdbc.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCExample {
	
	public static void jdbcSteps(){
		
		try{ 
			// STEP 1: Register the Driver Class
			//Class.forName("com.mysql.jdbc.Driver");  
			
			// STEP 2: Establish Connection
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/book_info","root","root");  
			
			// STEP 3: Create statement
			Statement stmt=con.createStatement();  
			
			// STEP 4: Execute the queries
			ResultSet rs=stmt.executeQuery("select * from books");  
			
			//Displaying the data from DataBase
			while(rs.next()){
			
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" \t "+rs.getString(3) +rs.getInt(4)+" \t "+rs.getDouble(5));  
				// STEP 5: Close the Connection
				//con.close();  
			}
		  }
		catch(Exception e){ 
			System.out.println(e);
		}  
	}

	public static void main(String[] args) {
		jdbcSteps();
		

	}

}
