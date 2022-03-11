package com.satyam.Test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestDBServlet
 */
@WebServlet("/TestDBServlet")
public class TestDBServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest requsest, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// setup connection variables
		String user = "bboard";
		String pass = "bboard";
		String jdbcUrl = "jdbc:mysql://localhost:3306/sch_blackboard?useSSL=false";
		String driver = "com.mysql.jdbc.Driver";
		// get connection
		try {
			PrintWriter out = response.getWriter();
			out.println("Connecting db");
			
			Class.forName(driver);
			Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);
			out.println("SUCCESS!!");
			myConn.close();
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}

}
