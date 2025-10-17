package com.example.demo.service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.model.Trader;
import com.example.demo.repositories.TraderRepository;

@Service
public class TraderService {

	@Autowired
	private TraderRepository traderRepository;
	
	public boolean existsByEmail(String e) {
		Trader t= traderRepository.findByEmail(e);
		if(t==null)
			return false;
		return true;
	}
	
	public void registerTrader(Trader t) {
		Timestamp now = new Timestamp(System.currentTimeMillis());
		t.setCreatedAt(now);
		t.setUpdatedAt(now);
		traderRepository.save(t);
	}
	
	public List<Trader> getAllByAsc(){
		return traderRepository.findAll(Sort.by(Sort.Direction.ASC,"id"));
	}
	
	public Trader findByEmail(String e) {
		Trader t = traderRepository.findByEmail(e);
		if(t==null)
			return null;
	
		return t;
	}
	
	public Trader updateTrader(Trader t) {
		Trader tr= traderRepository.findByEmail(t.getEmail());
		if(tr==null)
			return null;
		tr.setName(t.getName());
		tr.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
		return traderRepository.save(tr);
	}
	
	public Trader addTrader(Trader t) {
		Trader tr=traderRepository.findByEmail(t.getEmail());
		if(tr==null)
			return null;
		tr.setBalance(t.getBalance());
		tr.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
		return traderRepository.save(tr);
	}
}
