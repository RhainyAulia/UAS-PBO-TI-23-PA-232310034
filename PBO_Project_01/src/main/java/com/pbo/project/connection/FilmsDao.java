package com.pbo.project.connection;

import java.sql.Connection;		
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pbo.project.Film;


public class FilmsDao {
	private String Insquery = "insert into films(Name_Film,Genre,Actor,Director,link_film) values(?,?,?,?,?)";
	private String selectName = "select Name_Film from films";
	private String selectFilm = "select Id_Film, Name_Film, Genre, Actor, Director, link_film from films";
	private String recFilm = "select * from films where (genre = ? or genre = ?) or actor like ?";
	private String DeleteFilm = "delete from films where Id_Film = ?";
	private String UpdateFilm = "update films set Name_Film = ?, Genre = ?, Actor = ?, Director = ?, link_film = ? where Id_Film = ?";
	private String searchFilm = "select * from films where Id_Film = ? or Name_Film like ? or Genre = ? or Actor like ? or Director like ?";
	
	public void insertFilm(Film film) throws Exception{
		Connection con = new ConnectionDb().Connectdb();
		
		PreparedStatement in = con.prepareStatement(Insquery);
		
		in.setString(1, film.getName_Film());
		in.setString(2, film.getGenre());
		in.setString(3, film.getActor());
		in.setString(4, film.getDirector());
		in.setString(5, film.getLink());
		
		in.executeUpdate();
		
		con.close();
	}
	
	public void removeFilm(String id) throws Exception{
		if (id == null) {
	        return;
	    }
	    
	    Connection con = new ConnectionDb().Connectdb();
	    PreparedStatement Hps = con.prepareStatement(DeleteFilm);
	    Hps.setString(1, id);
	    Hps.executeUpdate();
	    
	    con.close();
	}
	
	public void updated(Film film) throws SQLException {
	    Connection con = new ConnectionDb().Connectdb();
	    PreparedStatement psUpdate = con.prepareStatement(UpdateFilm);
	    
	    psUpdate.setString(1, film.getName_Film());
	    psUpdate.setString(2, film.getGenre());
	    psUpdate.setString(3, film.getActor());
	    psUpdate.setString(4, film.getDirector());
	    psUpdate.setString(5, film.getName_Film());
	    psUpdate.setString(6, film.getId_film());
	    
	    psUpdate.executeUpdate();
	    
	    con.close();
	}
	
	public List<Film> findByNameFilm() throws Exception{
		List<Film> hasil = new ArrayList<>();
	    Connection Connect = new ConnectionDb().Connectdb();
	    PreparedStatement FilmSearch = Connect.prepareStatement(selectName);
	    ResultSet rs = FilmSearch.executeQuery();

	    while (rs.next()) {
	    	Film film = konversiFilm(rs);
	        hasil.add(film);
	    }

	    Connect.close();
	    return hasil;
	}
	
	private Film konversiFilm(ResultSet rs) throws SQLException {
		Film film = new Film();
		film.setName_Film(rs.getString("Name_Film"));
	    return film;
	}
	
	public List<Film> showFilm() throws Exception{
		List<Film> hasil = new ArrayList<>();
	    Connection Connect = new ConnectionDb().Connectdb();
	    PreparedStatement FilmSearch = Connect.prepareStatement(selectFilm);
	    ResultSet rsi = FilmSearch.executeQuery();

	    while (rsi.next()) {
	    	Film film = konversiFilms(rsi);
	        hasil.add(film);
	    }

	    Connect.close();
	    return hasil;
	}
	
	public List<Film> showRecFilm(String genre1, String genre2, String actor) throws Exception{
		List<Film> hasil = new ArrayList<>();
	    Connection Connect = new ConnectionDb().Connectdb();
	    PreparedStatement FilmSearch = Connect.prepareStatement(recFilm);
	    FilmSearch.setString(1, genre1);
	    FilmSearch.setString(2, genre2);
	    FilmSearch.setString(3, "%" + actor + "%");
	    ResultSet rsi = FilmSearch.executeQuery();

	    while (rsi.next()) {
	    	Film film1 = konversiFilms1(rsi);
	        hasil.add(film1);
	    }

	    Connect.close();
	    return hasil;
	}
	
	private Film konversiFilms1(ResultSet rsi) throws SQLException {
		Film film = new Film();
		film.setId_film(rsi.getString("Id_Film"));
		film.setName_Film(rsi.getString("Name_Film"));
		film.setGenre(rsi.getString("Genre"));
		film.setActor(rsi.getString("Actor"));
		film.setDirector(rsi.getString("Director"));
		film.setLink(rsi.getString("link_film"));
	    return film;
	}
	
	public List<Film> searchFilm1(Film films) throws Exception{
		String NameFilm, Actor, Director;
		List<Film> hasil = new ArrayList<>();
	    Connection Connect = new ConnectionDb().Connectdb();
	    PreparedStatement FilmSearch = Connect.prepareStatement(searchFilm);
	    
	    if(films.getName_Film().isEmpty()) {
	    	NameFilm = null;
	    }else {
	    	NameFilm = "%" + films.getName_Film()  + "%";
	    }
	    if(films.getActor().isEmpty()) {
	    	Actor = null;
	    }else {
	    	Actor = "%" + films.getActor()  + "%";
	    }
	    if(films.getDirector().isEmpty()) {
	    	Director = null;
	    }else {
	    	Director = "%" + films.getDirector()  + "%";
	    }
	    
	    System.out.println("------------------------------");
	    System.out.println(films.getId_film());
	    System.out.println(NameFilm);
	    System.out.println(films.getGenre());
	    System.out.println(Actor);
	    System.out.println(Director);
	    FilmSearch.setString(1, films.getId_film());
	    FilmSearch.setString(2, NameFilm);
	    FilmSearch.setString(3, films.getGenre());
	    FilmSearch.setString(4, Actor);
	    FilmSearch.setString(5, Director);
	    
	    ResultSet rsi = FilmSearch.executeQuery();

	    while (rsi.next()) {
	    	Film film = konversiFilms(rsi);
	        hasil.add(film);
	    }

	    Connect.close();
	    return hasil;
	}
	
	private Film konversiFilms(ResultSet rsi) throws SQLException {
		Film film = new Film();
		film.setId_film(rsi.getString("Id_Film"));
		film.setName_Film(rsi.getString("Name_Film"));
		film.setGenre(rsi.getString("Genre"));
		film.setActor(rsi.getString("Actor"));
		film.setDirector(rsi.getString("Director"));
		film.setLink(rsi.getString("link_film"));
	    return film;
	}
}
