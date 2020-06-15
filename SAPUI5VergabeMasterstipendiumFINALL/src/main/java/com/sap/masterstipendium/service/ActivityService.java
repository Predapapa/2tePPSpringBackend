package com.sap.masterstipendium.service;

import java.util.List;
import java.util.UUID;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import com.sap.masterstipendium.model.Activity;
import com.sap.masterstipendium.repository.ActivityRepository;

@Service
public class ActivityService {

	private ActivityRepository activityRepository;
	
	public ActivityService(ActivityRepository activityRepository) {
		this.activityRepository = activityRepository;
	}
	
	public void createActivity(final Activity activity) {
		if (!activityRepository.existsActivityById(activity.getId())) {
			activityRepository.save(activity);
		} else {
			throw new EntityExistsException("Could not save the activity entity with the id " + activity.getId() + " because it already exists.");
		}
	}
	
	public List<Activity> getActivitesFromStudent(String username) {
		return activityRepository.getAllActivitiesFromUsername(username);
	}
	
	public Activity getActivityById(String id) {
		return activityRepository.findActivityById(id);
	}
	
	public Activity updateActivity(final Activity activity) {
		if (activityRepository.existsActivityById(activity.getId())) {
			return activityRepository.save(activity);
		} else {
			throw new EntityNotFoundException("Could not update activity entity because it does not exist.");
		}
	}

	public void deleteActivity(String id) {
		if (activityRepository.existsActivityById(id)) {
			activityRepository.deleteActivityById(id);
		} else {
			throw new EntityNotFoundException("Could not delete activity with the id " + id +" because it does not exist.");
		}
	}
}
