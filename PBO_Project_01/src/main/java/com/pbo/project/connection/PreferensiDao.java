package com.pbo.project.connection;

import java.sql.Connection;		
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pbo.project.PrefensiFilm;

public class PreferensiDao {
	private String insertPreferensi = "insert into preferensi(id_user, preferensi_genre, preferensi_actor) values(?,?,?)";
	private String showPreferensi = "select preferensi_genre, preferensi_actor from preferensi where id_user = ?";
	private String showUser = "select id_user from preferensi";
	
	public void insertPreferen(ArrayList<String> preGenre, ArrayList<String> preActor, int id) throws Exception {
	    if (preGenre == null || preGenre.isEmpty()) {
	        throw new IllegalArgumentException("Genre list cannot be empty");
	    }
	    if (preActor == null || preActor.isEmpty()) {
	        throw new IllegalArgumentException("Actor list cannot be empty");
	    }

	    int maxSize = Math.max(preGenre.size(), preActor.size());
	    Connection con = new ConnectionDb().Connectdb();
	    PreparedStatement in = con.prepareStatement(insertPreferensi);

	    for (int i = 0; i < maxSize; i++) {
	        String opt = preGenre.get(i);
	        String act = preActor.get(i);
	        in.setInt(1, id);
	        in.setString(2, opt);
	        in.setString(3, act);
	        in.addBatch();
	    }

	    in.executeBatch();
	    con.close();
	}

	
	public List<PrefensiFilm> showRecFilm(int id) throws Exception{
		List<PrefensiFilm> hasil = new ArrayList<>();
	    Connection Connect = new ConnectionDb().Connectdb();
	    PreparedStatement recSearch = Connect.prepareStatement(showPreferensi);
	    recSearch.setInt(1, id);
	    ResultSet rsi = recSearch.executeQuery();

	    while (rsi.next()) {
	    	PrefensiFilm preferensi = konversiFilms(rsi);
	        hasil.add(preferensi);
	    }

	    Connect.close();
	    return hasil;
	}
	
	private PrefensiFilm konversiFilms(ResultSet rsi) throws SQLException {
		PrefensiFilm preferensi = new PrefensiFilm();
		preferensi.setPre_genre(rsi.getString("preferensi_genre"));
		preferensi.setPre_actor(rsi.getString("preferensi_actor"));
	    return preferensi;
	}
	
	public List<PrefensiFilm> Added_Pre_User() throws Exception{
		List<PrefensiFilm> hasil = new ArrayList<>();
		Connection Connect = new ConnectionDb().Connectdb();
		PreparedStatement CurUser = Connect.prepareStatement(showUser);
		ResultSet rs = CurUser.executeQuery();
		
		while (rs.next()) {
			PrefensiFilm usr = konversiPreUser(rs);
	        hasil.add(usr);
	    }
		
		Connect.close();
		return hasil;
	}
	
	private PrefensiFilm konversiPreUser(ResultSet rs1) throws SQLException {
		PrefensiFilm user = new PrefensiFilm();
		user.setId_user(rs1.getInt("id_user"));
		return user;
	}
}
