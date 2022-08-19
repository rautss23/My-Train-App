package com.casestudy.model;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrainDetails {
	@Id
	private String trainId;
	private String name;
	private String source;
	private String destination;
	private int departureTime;
	private int arrivalTime;
	private int duration;
	private String date;
	private int seatsLeft;
	private int generalFare;
	private int ladiesFare;
	
	
}
