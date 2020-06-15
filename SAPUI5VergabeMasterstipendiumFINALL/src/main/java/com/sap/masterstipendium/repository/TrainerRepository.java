package com.sap.masterstipendium.repository;
import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sap.masterstipendium.model.Trainer;


@Repository
public interface TrainerRepository extends JpaRepository<Trainer, Integer> {

	@Transactional
	public void deleteTrainerByUsername(@Param("USERNAME")String username);
	
	public Trainer findTrainerByUsername(String username);
	
	public boolean existsTrainerByUsername(String username);

	@Query ("SELECT t FROM TRAINER t ORDER BY t.lname ASC")
	List<Trainer> getAll();
	
	
}