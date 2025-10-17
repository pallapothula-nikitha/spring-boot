package com.example.demo.model;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table(name="track")
public class Track {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String albumName;
	private LocalDate releaseDate;
	private int playCount;
	
	public Track() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Track(Long id, String title, String albumName, LocalDate releaseDate, int playCount) {
		super();
		this.id = id;
		this.title = title;
		this.albumName = albumName;
		this.releaseDate = releaseDate;
		this.playCount = playCount;
	}
	
	public Track( String title, String albumName, LocalDate releaseDate, int playCount) {
		this.title = title;
		this.albumName = albumName;
		this.releaseDate = releaseDate;
		this.playCount = playCount;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAlbumName() {
		return albumName;
	}
	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}
	public LocalDate getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}
	public int getPlayCount() {
		return playCount;
	}
	public void setPlayCount(int playCount) {
		this.playCount = playCount;
	}
	
	
	
	

}
