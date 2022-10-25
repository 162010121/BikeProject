package com.tvs.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Entity
@Table(name="BIKE_TL")
@Data
public class BikeEntity {
	
	@Id
	@GeneratedValue
	private int bikeId;
	
	@Column
	private String bikeName;
	@Column
	private Date purchaseDate;
	@Column
	private int bikeNumber;
	@Column
	private String bikeCompany;
	
	

}
