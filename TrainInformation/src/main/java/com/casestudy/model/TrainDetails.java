package com.casestudy.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection="TrainDetails")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrainDetails {
	@Id
	private String trainId;
	private String name;
	private String source;
	private String destination;
	private int departureTime;
	private int arrivalTime;
	private int duration;
	//private String date;
	private int seatsLeft;
	private int generalFare;
	private int ladiesFare;
	
	
	
}
