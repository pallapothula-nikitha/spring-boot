package com.example.demo.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Trader;
import com.example.demo.repositories.TraderRepository;
import com.example.demo.service.TraderService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/trading/traders")
public class TraderController {
	@Autowired
	private TraderService traderService;
	
	@Autowired
	private TraderRepository traderRepository;
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	//@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Trader> create(@RequestBody Trader t) {
//		Trader exists= traderRepository.findByEmail(t.getEmail());
//		if(exists==null) {
//		traderService.registerTrader(t);
//		return new ResponseEntity<>(HttpStatus.CREATED);
//		}
//		
//		return ResponseEntity.status(400).build();
		
		if(traderService.existsByEmail(t.getEmail())) {
			return ResponseEntity.badRequest().build();
		}
		
		traderService.registerTrader(t);
		URI location = ServletUriComponentsBuilder
			    .fromCurrentRequest()
			    .path("/{id}")
			    .buildAndExpand(t.getId())
			    .toUri();
			return ResponseEntity.created(location).build();
	}
	
	@RequestMapping(value="/all",method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public List<Trader> getAll(){
		return traderService.getAllByAsc();
	}
	
	@RequestMapping(method=RequestMethod.GET)
	//@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Trader> findByEmail(@RequestParam("email") String email) {
		Trader t= traderService.findByEmail(email);
		if (t==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(t,HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.PUT)
	//@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Trader> putMethodName( @RequestBody Trader t) {
		//TODO: process PUT request
		
		Trader tra= traderService.updateTrader(t);
		if(tra==null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok().build();
	}
	
	@RequestMapping(value="/add", method=RequestMethod.PUT)
	//@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Trader> addTraderByBalance(@RequestBody Trader t) {
		Trader tr= traderService.addTrader(t);
		if(tr==null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(tr);
	}

}
