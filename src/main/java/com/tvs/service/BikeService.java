package com.tvs.service;

import java.util.List;

import com.tvs.entity.BikeEntity;

public interface BikeService {
	
	
	public List<BikeEntity> getAllBikes();
	
	public BikeEntity insertBike(BikeEntity entity);
	
	public void updateBike(BikeEntity entity);
	
	public void deleteBike(int bikeId);
	
	public BikeEntity getBikeDetails(int bikeId);

}
