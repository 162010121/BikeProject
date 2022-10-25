package com.tvs.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tvs.entity.BikeEntity;
import com.tvs.repository.BikeRepository;
import com.tvs.service.BikeService;


@Service
public class BikeServiceImpl implements BikeService{

	@Autowired
	private BikeRepository repository;
	
	@Override
	public List<BikeEntity> getAllBikes() {
		
		return repository.findAll();
	}

	@Override
	public BikeEntity insertBike(BikeEntity entity) {
		
		return repository.save(entity);
	}

	@Override
	public void updateBike(BikeEntity entity) {
		// TODO Auto-generated method stub
	
		repository.save(entity);
	}

	@Override
	public void deleteBike(int bikeId) {
		// TODO Auto-generated method stub
		repository.deleteById(bikeId);
	}

	@Override
	public BikeEntity getBikeDetails(int bikeId) {
		
		return repository.findById(bikeId).get();
	}

}
