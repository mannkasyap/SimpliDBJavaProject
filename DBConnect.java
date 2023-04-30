package com.databseconnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnect {
	
	//public static String SelectQuery = "select * from products";
	public static String ShowOrders = "select * from orders";
	
	public static void main(String args[]) throws SQLException {
		
		// ------------ STEP 1 -- create DB connections -----------
		// create DB connection object and connect to DB using JDBC driver
		// JDBC Driver API is the mode of communication between Java Application <>JDBC Driver<>Database
		// connect to host machine IPand port- here its localhost:3306
		// database is amazon_db followed by ID and pwd to login to MySQL Database
		// add exceptions SQLException
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/amazon_db","root","Me@sqlserver");
		
		// -----------STEP 2 -- Call the SQL query-------------
		// Use PreparedStatement object to run the sql query
		// PreparedStatement stmt = con.prepareStatement(SelectQuery);
		
		// ------ STEP 3 -- capture the result set output
		//
		// ResultSet rs = stmt.executeQuery();
		
		/* //------ STEP 4 -- show the valuein one column in the table
		//
		rs.next();
		System.out.println(rs.getString("product_name"));
		*/
		
		// ------- STEP 4 (a) - to print all values inside table
		// use getInt() that uses column numbers/order 
		
		PreparedStatement stmt1 = con.prepareStatement(ShowOrders);
		ResultSet rs1 = stmt1.executeQuery();
		while(rs1.next()) {
			
			System.out.println(rs1.getInt(1)+ " "+rs1.getInt(2)+ " "+rs1.getInt(3));
			
		}
		
		// STEP 5 -- Close the DB connection
		// 
		con.close();
		
		
		
		
		
	}

}
