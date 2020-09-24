package com.devsuperior.dspesquisa.resources;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dspesquisa.dto.RecordDTO;
import com.devsuperior.dspesquisa.dto.RecordInsertDTO;
import com.devsuperior.dspesquisa.services.RecordService;

// REST CONTROLLER IMPLEMENTATION
@RestController
// INFORM THE PRIMARY ROUTE OF THE RESOURCE
@RequestMapping(value = "/records")
public class RecordResource {

	@Autowired
	private RecordService service;
	
	// TO INFORM THAT WILL BE A POST MAPPING
	@PostMapping
	// POST ENDPOINT CREATION
	public ResponseEntity<RecordDTO> insert(@RequestBody RecordInsertDTO dto) {
		
		RecordDTO newDTO = service.insert(dto);
		return ResponseEntity.ok().body(newDTO);
	}
	
	// TO INFORM THAT WILL BE A GET MAPPING
	@GetMapping
	// GET ENDPOINT CREATION
	public ResponseEntity<Page<RecordDTO>> findAll(
			@RequestParam(value = "min", defaultValue = "") String min,
			@RequestParam(value = "max", defaultValue = "") String max,
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "0") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "moment") String orderBy,
			@RequestParam(value = "direction", defaultValue = "DESC") String direction) {
		
		Instant minDate = ("".equals(min) ? null : Instant.parse(min));
		Instant maxDate = ("".equals(max) ? null : Instant.parse(max));
		
		if (linesPerPage == 0) {
			linesPerPage = Integer.MAX_VALUE;
		}
		
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		
		Page<RecordDTO> list = service.findByMoments(minDate, maxDate, pageRequest);
		return ResponseEntity.ok().body(list);
	}
}
