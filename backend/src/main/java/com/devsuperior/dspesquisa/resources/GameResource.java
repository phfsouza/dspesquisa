package com.devsuperior.dspesquisa.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dspesquisa.dto.GameDTO;
import com.devsuperior.dspesquisa.services.GameService;

// REST CONTROLLER IMPLEMENTATION
@RestController
// INFORM THE PRIMARY ROUTE OF THE RESOURCE
@RequestMapping(value = "/games")
public class GameResource {

	@Autowired
	private GameService service;
	
	// TO INFORM THAT WILL BE A GET MAPPING
	@GetMapping
	// GET ENDPOINT CREATION
	public ResponseEntity<List<GameDTO>> findAll(){
		List<GameDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
}
