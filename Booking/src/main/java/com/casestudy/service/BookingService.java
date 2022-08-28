package com.casestudy.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.casestudy.controller.BookingController;
import com.casestudy.model.Booking;
import com.casestudy.model.TrainDetails;
import com.casestudy.model.Users;
import com.casestudy.repository.BookingRepository;

@Service
public class BookingService {
	
	@Autowired
	private BookingRepository bookingRepository;

	@Autowired
	SequenceGeneratorService sequenceGeneratorService;
	
	@Autowired
	private RestTemplate restTemplate;
	
	private Logger logger = LoggerFactory.getLogger(BookingService.class);
	
	public List<Booking> getAllTickets() {
		return bookingRepository.findAll();
	}
	
	public Booking reserveTicket(Booking book) {
		logger.info("Inside Reserve Ticket !");
		book.setPnr(sequenceGeneratorService.generateSequence(Booking.SEQUENCE_NAME));
		bookingRepository.save(book);
		updateSeats(book);
		updateMyBookings(book);
		logger.info("Ticket Booked!");
		return book;
	}
	
	public void cancelTicket(long pnr) {
		cancelSeats(pnr);
		cancelMyBookings(pnr);
		logger.info("Ticket Cancelled!!");
		bookingRepository.deleteById(pnr);
	}

	public void updateSeats(Booking book) {
		
		TrainDetails train = restTemplate.getForObject("http://TrainInformation/trainSearchById/"+ book.getTrainId(), TrainDetails.class);
		train.setSeatsLeft(train.getSeatsLeft() - book.getSeats());
		logger.info("Train Updated!!");
		restTemplate.put("http://TrainInformation/updateTrain/", train);			     
	}
	
	public void updateMyBookings(Booking book) {
		logger.info("Inside Update my Booking!!");
		Users user = restTemplate.getForObject("http://Users/getUser/" + book.getUsername(), Users.class);
		List<Booking> ticket = user.getBookings();
		ticket.add(book);
		user.setBookings(ticket);
		logger.info("Booking Updated!");
		restTemplate.put("http://Users/updateUser", user);
	}
	
	public void cancelMyBookings(long pnr) {
		Booking book = bookingRepository.findByPnr(pnr);
		logger.info("Inside Cancel My Ticket !");
		Users user = restTemplate.getForObject("http://Users/getUser/" + book.getUsername(), Users.class);
		List<Booking> ticket = new ArrayList<>(user.getBookings());
		for( int count = 0; count < ticket.size(); count++) {
			if(ticket.get(count).getPnr()==book.getPnr()) {
				ticket.remove(count);
			}
		}
		logger.info("Ticket Cancelled!");
		user.setBookings(ticket);
		restTemplate.put("http://Users/updateUser", user);
	}
	
	public void cancelSeats(long pnr) {

		Booking book = bookingRepository.findByPnr(pnr);
		
		TrainDetails train = restTemplate.getForObject("http://TrainInformation/trainSearchById/"+ book.getTrainId(), TrainDetails.class);
		train.setSeatsLeft(train.getSeatsLeft() + book.getSeats());
		logger.info("Seats Updated!");
		restTemplate.put("http://TrainInformation/updateTrain/", train);
    
	}
	
	
	
}
