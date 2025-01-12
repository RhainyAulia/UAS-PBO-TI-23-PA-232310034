package com.pbo.project;


public class Film {
	
	String id_film;
	private String Name_Film, Genre, Actor, Director, link;
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getId_film() {
		return id_film;
	}
	public void setId_film(String string) {
		this.id_film = string;
	}
	public String getName_Film() {
		return Name_Film;
	}
	public void setName_Film(String name_Film) {
		Name_Film = name_Film;
	}
	public String getGenre() {
		return Genre;
	}
	public void setGenre(String genre) {
		Genre = genre;
	}
	public String getActor() {
		return Actor;
	}
	public void setActor(String actor) {
		Actor = actor;
	}
	public String getDirector() {
		return Director;
	}
	public void setDirector(String director) {
		Director = director;
	}
}
