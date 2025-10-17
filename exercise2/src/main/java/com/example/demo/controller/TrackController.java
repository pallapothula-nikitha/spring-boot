package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Track;
import com.example.demo.service.TrackService;

@RestController
@RequestMapping("/music/platform/v1/tracks")
public class TrackController {
	@Autowired
	private TrackService trackService;
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	//@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<String> create(@RequestBody Track t) {
	    if (trackService.findByTitle(t.getTitle())) {
	        return ResponseEntity
	                .status(HttpStatus.BAD_REQUEST)
	                .body("Track with this title already exists");
	    }

	    trackService.addTrack(t);
	    return ResponseEntity
	            .status(HttpStatus.CREATED)
	            .body("Track added successfully");
	}
/*
 * a new method
 */
//	public ResponseEntity<Track> create(@RequestBody Track t) {
//	    if (trackService.findByTitle(t.getTitle())) {
//	        return ResponseEntity
//	                .status(HttpStatus.BAD_REQUEST)
//	                .build();
//	    }
//
//	    trackService.addTrack(t);
//	    return ResponseEntity
//	            .status(HttpStatus.CREATED)
//	            .body(trackService.addTrack(t));
//	}
	
/*
 * another method
 */
	
//	public ResponseEntity<Track> create(@RequestBody Track t) {
//	    if (trackService.findByTitle(t.getTitle())) {
//	        return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
//	    }
//
//	    trackService.addTrack(t);
//	    return ResponseEntity
//	            .status(HttpStatus.CREATED)
//	            .build();
//	}
	
	@RequestMapping(value="/all", method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public List<Track> getAll() {
		return trackService.getAll();
	}
	
	@RequestMapping(value="/{trackId}", method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public Optional<Track> getById(@PathVariable Long trackId) {
		return trackService.getById(trackId);
	}
	
	@RequestMapping(value="/sorted", method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public List<Track> getAllSortedByTitle() {
		return trackService.getAllSortedByTitle();
	}
	
	@RequestMapping(value="/{trackId}", method=RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable Long trackId) {
		 trackService.deleteById(trackId);
	}
	

}
