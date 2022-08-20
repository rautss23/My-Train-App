package com.casestudy.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casestudy.controller.TrainController;
import com.casestudy.model.TrainDetails;
import com.casestudy.repository.TrainRepository;

@Service
public class TrainService {

	@Autowired
	private TrainRepository trainRepository;
	
	private Logger logger = LoggerFactory.getLogger(TrainController.class);

	
	public List<TrainDetails> getAllTrains(){
		logger.info("Inside getAllTrains!!!");
		List<TrainDetails> trains = new ArrayList<>();
		logger.info("Fetching....!");
		trainRepository.findAll().forEach(trains::add);
		logger.info("All Trains!1");
		return trains;
	}
	
	public TrainDetails addTrains(TrainDetails trains) {
		logger.info("Inside Add Trains");
		trainRepository.save(trains);
		logger.info("Train Added!!");
		return trains;
	}
	

	
	public List<TrainDetails> checkTrains(String source, String destination){
		logger.info("Fetching Train from source to destination!! ");
		return trainRepository.findAllBySourceAndDestination(source,destination);
		
	}

	public List<TrainDetails> getTrainByName(String search) {
		logger.info("Fetching train by name!");
		return trainRepository.findAllByName(search);
	}
	
	public TrainDetails getTrainById(String search) {
		logger.info("Inside get Trains by ID !!");
		Optional<TrainDetails> optTrain = trainRepository.findById(search);
		logger.info("Found Train By Id!!");
		return optTrain.get();
	}

	public void updateTrain(TrainDetails trainDetails) {
		logger.info("Train Updated!!");
		trainRepository.save(trainDetails);
		
	}

	public String removeTrain(String trainId) {
		logger.info("Train Removed!!");
		trainRepository.deleteById(trainId);
		return "Train Deleted Successfully";
	}
	
	
}