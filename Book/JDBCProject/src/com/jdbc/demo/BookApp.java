package com.jdbc.demo;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

class Exit extends Thread
{
	public  void run()
	{
		System.out.println("Please wait Logging off ");
		try{
		Thread.sleep(2000);
		}catch(InterruptedException e){
			System.out.println(e);
		}
		System.out.println("\nLogged out successfully!");
	}
}

public class BookApp {
	private static  int id;
	private static String author;
	private static String title;
	private static double price;
	private static int quantity;
	
	public static void createTable()
	{
		Scanner sc=new Scanner(System.in);
		
		try(Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/book_info","root","root")){
		System.out.print("Enter the table name :");
		String tablename=sc.next();
		
		String query="create table if not exists "+tablename+"(book_id int primary key, "
					+ "author varchar(20),title varchar(20),quantity int,price int)";
		
		DatabaseMetaData md=(DatabaseMetaData) con.getMetaData(); 
		ResultSet rs=md.getTables(null, null, tablename, null) ;
		if(!rs.next())
		{
			PreparedStatement stmt=con.prepareStatement(query);
			stmt.executeUpdate();
			System.out.println("Table created Successfully");
		}
		else{
			System.out.println("Table already Exist");
		}
		
		}catch(Exception e) {
				System.out.println(e);		
		}  
	}
	

	public static void insertData()
	{
			Scanner sc=new Scanner(System.in);
		
			try(Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/book_info","root","root")){
			System.out.print("Enter the number of books you want to Insert :");
			int numOfBooks=sc.nextInt();
			
			for(int j=1 ; j<=numOfBooks ; j++) {
			System.out.println("Enter the Book-"+j+" Details :");
			System.out.print("Enter Book ID :");
			id=sc.nextInt();
			System.out.print("Enter Book Author :");
			author=sc.next();
			System.out.print("Enter Book Title :");
			title=sc.next();
			System.out.print("Enter Book Quantity :");
			quantity=sc.nextInt();
			System.out.print("Enter Book Price :");
			price=sc.nextDouble();
			
			PreparedStatement stmt=con.prepareStatement("insert into books values(?,?,?,?,?)");
			stmt.setInt(1,id);
			stmt.setString(2,author); 
			stmt.setString(3,title); 
			stmt.setInt(4,quantity);
			stmt.setDouble(5,price);
			
			  
			int i=stmt.executeUpdate();  
			System.out.println("Records added Successfully");  
			
			}// end of for loop
			}catch(Exception e) {
					System.out.println(e);
					
			}  
	}
	
	public static void fetchingData()
	{
		try(Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/book_info","root","root")){
			
			System.out.println("The Book Details are listed below :");
			System.out.println("..................................");
			
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from books");  			
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t" 
								  +rs.getInt(4)+"\t"+rs.getDouble(5));  			
			}
			
			}catch(Exception e) {
					System.out.println(e);
			}
	}
	
	public static void updateData()
	{
		Scanner sc=new Scanner(System.in);
		
		try(Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/book_info","root","root")){
		
		System.out.println("Update the Book Details :");
		
		System.out.print("Enter Book ID :");
		id=sc.nextInt();
		System.out.print("Enter Book Quantity to Update :");
		quantity=sc.nextInt();

		PreparedStatement stmt=con.prepareStatement("update books set quantity=? where book_id=?");  
		stmt.setInt(1,id);
		stmt.setInt(2,quantity);  
		  
		int i=stmt.executeUpdate();  
		System.out.println(i+" Records updated Successfully");   
		
		}catch(Exception e) {
				System.out.println(e);
		}  
		
	}
	
	public static void deleteData()
	{
		Scanner sc=new Scanner(System.in);
		
		try(Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/book_info","root","root")){
		
		System.out.print("Enter Book ID to delete :");
		id=sc.nextInt();
		
		PreparedStatement stmt=con.prepareStatement("delete from books where book_id=?");  
		stmt.setInt(1,id);  
		  
		int i=stmt.executeUpdate();  
		System.out.println(i+" Records deleted successfully");  
	 
		
		}catch(Exception e) {
				System.out.println(e);
		}  
	}
	
	public static void main(String[] args) {
		
		Scanner scan=new Scanner(System.in);
		Exit exit=new Exit();
		int choice;
		do{
			System.out.println();
			System.out.println("Select the below options to Continue :");
			System.out.println(" 1) Create a Table  \n 2) Insert \n 3) Display \n 4) Update \n 5) Delete \n 6) Exit");
			System.out.print("Enter your Choice :");
			choice=scan.nextInt();
			switch(choice)
			{
				case 1 : createTable();
						 break;
				
				case 2 : insertData();
					 	 break;
			
				case 3 : fetchingData();
						 break;
			
				case 4 : updateData();
			 		 	 break;
	
				case 5 : deleteData();
			 		 	 break;
			 	
				case 6 : exit.start();
						 break;
				
			 		 	 
				default :System.out.println("Invalid Input!!");
			         	 break;			 
			}
		}while(choice!=6);
	}
}
























