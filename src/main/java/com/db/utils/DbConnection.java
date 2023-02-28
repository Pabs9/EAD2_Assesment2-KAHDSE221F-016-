package com.db.utils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbConnection {
//	throws ClassNotFoundException, SQLException
	public static Connection connectDB() throws SQLException, ClassNotFoundException  {
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver loaded");
		
		String con_string = "jdbc:mysql://127.0.0.1:3306/employeemanagement";
		Connection con = DriverManager.getConnection(con_string,"root", "");
		System.out.println("Connection established");
	       return con;
			
	}	
	
    

}
