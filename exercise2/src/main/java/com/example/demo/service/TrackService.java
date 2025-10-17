package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.model.Track;
import com.example.demo.repositories.TrackRepository;

@Service
public class TrackService {
	
	@Autowired
	private TrackRepository trackRepository;
	
	public boolean findByTitle(String t) {
		return trackRepository.findByTitle(t).isPresent();
	}
	
	public List<Track> getAll(){
		return trackRepository.findAll();
	}
	
	public Track addTrack(Track t) {
		return trackRepository.save(t);
	}
	
	public Optional<Track> getById(Long id) {
		return trackRepository.findById(id);
	}
	
	public void deleteById(Long id) {
		trackRepository.deleteById(id);
	}
	
	public List<Track> getAllSortedByTitle() {
		return trackRepository.findAll(Sort.by(Sort.Direction.ASC,"title"));
	}
	public Track updateTrack(Long id, Track t) {
		return trackRepository.save(t);
	}

}
