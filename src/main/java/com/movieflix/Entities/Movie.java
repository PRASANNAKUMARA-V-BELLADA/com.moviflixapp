package com.movieflix.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Movie {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	String mname;
	
	@Column(length = 2000)
	String mlink;
	
	String genre;
	String mcast;
	String mdirector;
	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Movie(int id, String mname, String mlink, String genre, String mcast, String mdirector) {
		super();
		this.id = id;
		this.mname = mname;
		this.mlink = mlink;
		this.genre = genre;
		this.mcast = mcast;
		this.mdirector = mdirector;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getMlink() {
		return mlink;
	}
	public void setMlink(String mlink) {
		this.mlink = mlink;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getMcast() {
		return mcast;
	}
	public void setMcast(String mcast) {
		this.mcast = mcast;
	}
	public String getMdirector() {
		return mdirector;
	}
	public void setMdirector(String mdirector) {
		this.mdirector = mdirector;
	}
	@Override
	public String toString() {
		return "Movie [id=" + id + ", mname=" + mname + ", mlink=" + mlink + ", genre=" + genre + ", mcast=" + mcast
				+ ", mdirector=" + mdirector + "]";
	}
	
	

}
