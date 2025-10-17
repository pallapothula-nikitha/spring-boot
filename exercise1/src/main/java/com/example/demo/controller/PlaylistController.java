package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.PlayList;
import com.example.demo.services.PlaylistService;

@RestController
@RequestMapping("/v1/playlists")
public class PlaylistController {
	
	@Autowired
	private PlaylistService playlistService;
	
	@GetMapping
	public List<PlayList> getAll(){
		return playlistService.getAllByAsc();
	}
	
	@PostMapping
	public ResponseEntity<PlayList> createList(@RequestBody PlayList p) {
		return ResponseEntity.status(201).body(playlistService.addPlaylist(p));
	}
	
	@GetMapping("/{playlistId}")
	public Optional<PlayList> getById(@PathVariable Integer playlistId) {
		return playlistService.getById(playlistId);
	}
	
	@DeleteMapping("/{playlistId}")
	public ResponseEntity<Void> deleteById(@PathVariable Integer playlistId) {
		playlistService.delete(playlistId);
		//return ResponseEntity.status(204).build();
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

}
