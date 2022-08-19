package com.casestudy.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "Booking")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Booking {
	
	@Transient
    public static final String SEQUENCE_NAME = "tickets_sequence";
	
	@Id
	private long pnr;
	private String username;
	private String trainId;
	private String name;
	private String date;
	private int seats;
	private String source;
	private String destination;
	private String quota;
	private int totalFare;
	
	
}
