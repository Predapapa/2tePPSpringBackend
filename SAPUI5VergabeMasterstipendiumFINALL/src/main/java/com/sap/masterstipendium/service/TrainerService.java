package com.sap.masterstipendium.service;
import java.util.List;
import java.util.UUID;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import com.sap.masterstipendium.model.Trainer;
import com.sap.masterstipendium.repository.TrainerRepository;

@Service
public class TrainerService {
	
	private TrainerRepository trainerRepository;
	
	public TrainerService(TrainerRepository trainerRepository) {
		this.trainerRepository = trainerRepository;
	}
	
	public void createTrainer(final Trainer trainer) {
		if (!trainerRepository.existsTrainerByUsername(trainer.getUsername())) {
			trainerRepository.save(trainer);
		} else {
			throw new EntityExistsException("Could not save Trainer entity with username " + trainer.getUsername() + " . An entity with that username already exists.");
		}
	}
	
	public void deleteTrainer(String username) {
		if (trainerRepository.existsTrainerByUsername(username)) {
			trainerRepository.deleteTrainerByUsername(username);
		} else {
			throw new EntityNotFoundException("Could not delete Trainer entity with username " + username + " because the Trainer entity does not exist.");
		}
	}
	
	public Trainer findTrainer(String username) {
		return trainerRepository.findTrainerByUsername(username);
	}
	
	public List<Trainer> getAll() {
		return trainerRepository.getAll();
	}
}
