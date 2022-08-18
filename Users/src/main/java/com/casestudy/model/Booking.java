package com.casestudy.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Booking {
	
	@Transient
    public static final String SEQUENCE_NAME = "tickets_sequence";
	
	@Id
	private long pnr;
	@NotEmpty(message = "username cannot be empty")
	private String username;
	@NotEmpty(message = "Id cannot be empty")
	private String trainId;
	@NotEmpty(message = "name cannot be empty")
	private String name;
	@NotEmpty(message = "date cannot be empty")
	private String date;
	@NotNull(message="seats cannot be empty")
	@Max(value = 6)
	@Min(value = 1)
	private int seats;
	@NotEmpty(message = "source cannot be empty")
	private String source;
	@NotEmpty(message = "destination cannot be empty")
	private String destination;
	@NotEmpty(message = "quota cannot be empty")
	private String quota;
	@NotNull(message="Fare cannot be empty")
	private int totalFare;
	
//	public Booking() {
//		
//	}
//	
//	public Booking(long pnr, String username, String trainId, String name, String date, int seats, String source, String destination,
//			String quota, int totalFare) {
//		super();
//		this.pnr = pnr;
//		this.username = username;
//		this.trainId = trainId;
//		this.name = name;
//		this.date = date;
//		this.seats = seats;
//		this.source = source;
//		this.destination = destination;
//		this.quota = quota;
//		this.totalFare = totalFare;
//	}
//
//	public long getPnr() {
//		return pnr;
//	}
//
//	public void setPnr(long pnr) {
//		this.pnr = pnr;
//	}
//
//	public String getUsername() {
//		return username;
//	}
//
//	public void setUsername(String username) {
//		this.username = username;
//	}
//
//	public String getTrainId() {
//		return trainId;
//	}
//
//	public void setTrainId(String trainId) {
//		this.trainId = trainId;
//	}
//
//	public String getDate() {
//		return date;
//	}
//
//	public void setDate(String date) {
//		this.date = date;
//	}
//	
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public int getTotalFare() {
//		return totalFare;
//	}
//
//	public void setTotalFare(int totalFare) {
//		this.totalFare = totalFare;
//	}
//
//	public int getSeats() {
//		return seats;
//	}
//
//	public void setSeats(int seats) {
//		this.seats = seats;
//	}
//
//	public String getSource() {
//		return source;
//	}
//
//	public void setSource(String source) {
//		this.source = source;
//	}
//
//	public String getDestination() {
//		return destination;
//	}
//
//	public void setDestination(String destination) {
//		this.destination = destination;
//	}
//
//	public String getQuota() {
//		return quota;
//	}
//
//	public void setQuota(String quota) {
//		this.quota = quota;
//	}
	
}
