package com.pbo.project.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.pbo.project.Feedback;

public class FeedbackDao {
	private String queryIns = "insert into umpan_balik(id_user, id_film, feedback) values(?,?,?)";
	
	public void insertFeedback(int id_user, String id_film, Feedback feedback) throws Exception{
		Connection con = new ConnectionDb().Connectdb();
		PreparedStatement in = con.prepareStatement(queryIns);
		
		in.setInt(1, id_user);
		in.setString(2, id_film);
		in.setString(3, feedback.getFeedback());
		
		in.executeUpdate();
		
		con.close();
	}
}
