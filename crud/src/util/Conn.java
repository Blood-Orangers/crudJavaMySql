package util;

import java.sql.*;

public class Conn {
	public static Connection getConn() throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/connJava", "firstUser", "12345");
			
		}catch(SQLException error) {
			System.err.println("Have a beetle: " + error);
		}
		
		return conn;
	}
}
