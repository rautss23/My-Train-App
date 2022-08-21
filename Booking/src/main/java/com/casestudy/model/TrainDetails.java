package com.casestudy.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

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
	@NotEmpty(message = "Name cannot be empty")
	private String name;
	@NotEmpty(message = "Source cannot be empty")
	private String source;
	@NotEmpty(message = "Destination cannot be empty")
	private String destination;
	@NotNull(message = "Depa. time cannot be empty")
	private int departureTime;
	@NotNull(message = "arrival time cannot be empty")
	private int arrivalTime;
	@NotNull(message = "duration cannot be empty")
	private int duration;
	@NotNull(message = "seats cannot be empty")
	private int seatsLeft;
	@NotNull(message = "fare(g) cannot be empty")
	private int generalFare;
	@NotNull(message = "fare(l) cannot be empty")
	private int ladiesFare;
	
	
}
