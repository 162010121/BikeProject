package com.tvs.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tvs.entity.BikeEntity;
import com.tvs.exception.BikeNotFoundException;
import com.tvs.repository.BikeRepository;
import com.tvs.service.BikeService;

@RestController
public class BikeController {

	@Autowired
	BikeService service;

	@Autowired
	BikeRepository repository;

	@GetMapping("/allBikes")
	public ResponseEntity<?> getAllBikes() throws BikeNotFoundException {
		if (!repository.findAll().isEmpty()) {
			return new ResponseEntity<>(service.getAllBikes(), HttpStatus.OK);

		}
		throw new BikeNotFoundException("Bikes Not Found");
	}

	@PostMapping("/addBike")
	public ResponseEntity<?> insertBike(@RequestBody BikeEntity entity) throws BikeNotFoundException {

		Optional<BikeEntity> opt = repository.findByName(entity.getBikeName());

		if (opt.isPresent()) {
			throw new BikeNotFoundException("Bike Already Exists");
		} else {
			repository.save(entity);
			return new ResponseEntity<>("Bike Aded in the lise", HttpStatus.OK);
		}
	}

	@PutMapping("/updateBike/{bikeId}")
	public ResponseEntity<?> updateBike(@RequestBody BikeEntity entity) throws BikeNotFoundException {
		if (repository.existsById(entity.getBikeId())) {
			service.updateBike(entity);
			return new ResponseEntity<>("BikeId" + entity.getBikeId() + "Updated Succeccfully", HttpStatus.ACCEPTED);
		}

		throw new BikeNotFoundException("BikeId" + entity.getBikeId() + "Bike Is Not Found");

	}

	@DeleteMapping("/deleteBike/{bikeId}")
	public ResponseEntity<String> deleteBike(@PathVariable("bikeId") int bikeId) throws BikeNotFoundException {
		Optional<BikeEntity> opt = repository.findById(bikeId);

		if (opt.isPresent()) {
			service.deleteBike(bikeId);
			return new ResponseEntity<>("BikeId" + bikeId + "is deleted succes", HttpStatus.OK);

		} else {
			throw new BikeNotFoundException("Bike" + bikeId + "is not found");

		}
	}
}
