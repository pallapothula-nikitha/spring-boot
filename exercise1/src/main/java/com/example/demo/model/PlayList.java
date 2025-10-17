package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="playlists")
public class PlayList {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private int tracksCount;
	
	public PlayList() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PlayList(String n,int t) {
		name=n;
		tracksCount=t;
	}

	public PlayList(Integer id, String name, int tracksCount) {
		super();
		this.id = id;
		this.name = name;
		this.tracksCount = tracksCount;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTracksCount() {
		return tracksCount;
	}

	public void setTracksCount(int tracksCount) {
		this.tracksCount = tracksCount;
	}

}
