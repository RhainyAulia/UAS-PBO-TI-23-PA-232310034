package com.pbo.project;

import java.util.List;

public class PrefensiFilm {
	List<String> genreOpt;
	public List<String> getGenreOpt() {
		return genreOpt;
	}
	public void setGenreOpt(List<String> genreOpt) {
		this.genreOpt = genreOpt;
	}
	 public int getId_preferensi() {
		return id_preferensi;
	}
	public void setId_preferensi(int id_preferensi) {
		this.id_preferensi = id_preferensi;
	}
	public String getPre_genre() {
		return pre_genre;
	}
	public void setPre_genre(String pre_genre) {
		this.pre_genre = pre_genre;
	}
	public String getPre_actor() {
		return pre_actor;
	}
	public void setPre_actor(String pre_actor) {
		this.pre_actor = pre_actor;
	}
	private int id_preferensi, id_user;
	public int getId_user() {
		return id_user;
	}
	public void setId_user(int id_user) {
		this.id_user = id_user;
	}
	private String pre_genre, pre_actor;
}
