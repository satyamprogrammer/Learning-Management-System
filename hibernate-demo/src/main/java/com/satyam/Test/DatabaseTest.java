package com.satyam.Test;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String jdbcUrl = "jdbc:mysql://localhost:3306/hb?useSSL=false";
		String user = "bboard";
		String pass = "bboard";
		
		try {
			System.out.println("Connecting to database: " + jdbcUrl);
			Connection myconn = DriverManager.getConnection(jdbcUrl, user, pass);
			System.out.println("Connection Successful");
		}
		catch(Exception exc) {
			exc.printStackTrace();
		}
	}

}
