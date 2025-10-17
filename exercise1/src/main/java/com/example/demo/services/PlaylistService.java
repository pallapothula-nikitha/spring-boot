package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.model.PlayList;
import com.example.demo.repo.PlayListRepository;

@Service
public class PlaylistService {
	
	@Autowired
	private PlayListRepository playlistRepository;
	
	public PlaylistService(PlayListRepository p) {
		playlistRepository =p;
	}
	
	public PlayList addPlaylist(PlayList p) {
		return playlistRepository.save(p);
	}
	
	public List<PlayList> getAllByAsc(){
		List<PlayList> p = playlistRepository.findAll(Sort.by(Sort.Direction.DESC,"id"));
		return p;
	}
	
	public Optional<PlayList> getById(Integer id) {
		return playlistRepository.findById(id);
	}
	
	public void delete(Integer id) {
		 playlistRepository.deleteById(id);
	}
}
