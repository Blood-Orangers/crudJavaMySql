package util;

import java.sql.*;

public class Conn {
	public static Connection getConn(){
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/connJava", "firstUser", "firstUser");
			System.out.println("Connected");
			
		}catch(SQLException error) {
			System.err.println("Have a beetle: " + error);
		}
		
		return conn;
	}
}
