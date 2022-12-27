package Util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {
	static Connection con = null;

	public static Connection createConnection() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/phonebook", "root", "mySQL@12345");
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}

		return con;
	}

}
