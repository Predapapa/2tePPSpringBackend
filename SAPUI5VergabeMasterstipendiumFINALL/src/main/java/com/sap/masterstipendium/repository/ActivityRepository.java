package com.sap.masterstipendium.repository;
import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sap.masterstipendium.model.Activity;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Integer> {
	
	@Transactional
	public void deleteActivityById(@Param("ID")String id);
	
	public Activity findActivityById(String id);
	
	@Query ("SELECT a FROM ACTIVITY a WHERE a.username LIKE:USERNAME")
	List<Activity> getAllActivitiesFromUsername(@Param("USERNAME")String username);
	
	public boolean existsActivityById(String id);
	
	
	
	
	
}

