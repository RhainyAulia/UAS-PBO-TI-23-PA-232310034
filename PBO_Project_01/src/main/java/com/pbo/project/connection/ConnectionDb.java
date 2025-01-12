package com.pbo.project.connection;

import java.sql.Connection;	
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDb {
private Connection connect;
	
	public Connection Connectdb() throws SQLException{
		String Host = "localhost:3306";
		String NmDb = "platform_streamdb";
		String User = "root";
		String Pass = "";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		
		Connection connect = DriverManager.getConnection("jdbc:mysql://" + Host+"/"+ NmDb , User , Pass);
		return connect;
	}
	
	public Connection close() throws SQLException{
		connect.close();
		
		return connect;
	}
}
