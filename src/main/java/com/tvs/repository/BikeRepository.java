package com.tvs.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.tvs.entity.BikeEntity;

@Repository
public interface BikeRepository extends JpaRepository<BikeEntity, Integer> {

	
	  @Query("SELECT r from BikeEntity r WHERE r.bikeName=:bikeName ")
	  public Optional<BikeEntity> findByName(@Param("bikeName") String bikeName);
}
