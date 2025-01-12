package com.pbo.project.connection;

import java.sql.Connection;	
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.pbo.project.User;

public class UserDao {
	private String InsertQuery = "insert into user(Username, Email, status, Password)"+"values(?,?,?,?)";
	private String SelectUser = "select Username, Password from user";
	private String SelectIdUserCur = "select Id_User from user where Username = ?";
	private String SelectbyEmail = "Select Username, Password from user where Email = ?";
	private String selectId = "select id_user, status from user where Username = ? and Password = ?";
	
	public void insertUser(User user) throws Exception{
		Connection con = new ConnectionDb().Connectdb();
		
		PreparedStatement in = con.prepareStatement(InsertQuery);
		
		in.setString(1, user.getUsername());
		in.setString(2, user.getEmail());
		in.setString(3, user.getStatus());
		in.setString(4, user.getPassword());
		
		in.executeUpdate();
		
		con.close();
	}
	
	public List<User> selectId(String user, String pass) throws Exception{
	    List<User> hasil = new ArrayList<>();
		Connection con = new ConnectionDb().Connectdb();
		PreparedStatement searchId = con.prepareStatement(selectId);
		searchId.setString(1, user);
		searchId.setString(2, pass);
		ResultSet rs = searchId.executeQuery();
		
		while (rs.next()) {
	    	User user1 = konversiCurUser(rs);
	        hasil.add(user1);
	    }

	    con.close();
	    return hasil;
	}
	
	public List<User> currentUser(User user) throws Exception{
		List<User> hasil = new ArrayList<>();
		Connection Connect = new ConnectionDb().Connectdb();
		PreparedStatement CurUser = Connect.prepareStatement(SelectIdUserCur);
		CurUser.setString(1, user.getUsername());
		ResultSet rs = CurUser.executeQuery();
		
		while (rs.next()) {
	    	User usr = konversiCurUser(rs);
	        hasil.add(usr);
	    }
		
		Connect.close();
		return hasil;
	}
	
	private User konversiCurUser(ResultSet rs1) throws SQLException {
		User user = new User();
		user.setId_user(rs1.getInt("Id_User"));
		user.setStatus(rs1.getString("status"));
		return user;
	}
	
	public List<User> findByUser() throws Exception{
		List<User> hasil = new ArrayList<>();
	    Connection Connect = new ConnectionDb().Connectdb();
	    PreparedStatement UserSearch = Connect.prepareStatement(SelectUser);
	    ResultSet rs = UserSearch.executeQuery();

	    while (rs.next()) {
	    	User user = konversiUser(rs);
	        hasil.add(user);
	    }

	    Connect.close();
	    return hasil;
	}
	
	private User konversiUser(ResultSet rs) throws SQLException {
		User user = new User();
		user.setUsername(rs.getString("Username"));
		user.setPassword(rs.getString("Password"));
	    return user;
	}
	
	public List<User> findUserbyEmail(String email) throws Exception {
	    List<User> hasil = new ArrayList<>();
	    Connection con = new ConnectionDb().Connectdb();
	    PreparedStatement psCariSemua = con.prepareStatement(SelectbyEmail);
	    psCariSemua.setString(1, email);
	    ResultSet rs = psCariSemua.executeQuery();

	    while (rs.next()) {
	    	User user1 = konversiUser(rs);
	        hasil.add(user1);
	    }

	    con.close();
	    return hasil;
	}
}
