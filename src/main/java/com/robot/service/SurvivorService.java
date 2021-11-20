package com.robot.service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.robot.entity.Survivor;
import com.robot.model.Robot;
import com.robot.model.SurvivorPercentage;
import com.robot.repo.SurvivorRepository;

@Service
public class SurvivorService {

	@Autowired
	private SurvivorRepository survivorRepository;

	public Survivor saveSurvivor(Survivor survivor)  {
		return survivorRepository.save(survivor);
	}

	public Survivor updateSurvivor(Long id, Survivor survivor) {
		Optional<Survivor> optOldSurvivor = survivorRepository.findById(id);
		if (optOldSurvivor.isPresent()) {
			Survivor oldSurvivor = optOldSurvivor.get();
			oldSurvivor.setLatitude(survivor.getLatitude());
			oldSurvivor.setLongitude(survivor.getLongitude());
			return survivorRepository.save(oldSurvivor);
		} else {
			return null;
		}
	}

	public Survivor infectedSurvivor(Long id) {
		Optional<Survivor> optOldSurvivor = survivorRepository.findById(id);
		if (optOldSurvivor.isPresent()) {
			Survivor oldSurvivor = optOldSurvivor.get();
			oldSurvivor.setInfected(true);
			return survivorRepository.save(oldSurvivor);
		} else {
			return null;
		}
	}


	public List<Survivor> getAllSurvivors() {
		return survivorRepository.findAll();
	}

	public List<Survivor> addSurvivors(List<Survivor> survivors) {
		return survivorRepository.saveAll(survivors);
	}

	public List<Robot> getRobots() {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<List<Robot>> robots = restTemplate.exchange("https://robotstakeover20210903110417.azurewebsites.net/robotcpu", HttpMethod.GET , null, new ParameterizedTypeReference<List<Robot>>() {});
		List<Robot> robotsList = robots.getBody().stream()
				.sorted(Comparator.comparing(Robot::getCategory))
				.collect(Collectors.toList());
		return robotsList;
	}

	public List<Survivor> getInfectedSurvivors() {
		return survivorRepository.findByInfectedTrue();
	}

	public List<Survivor> getNonInfectedSurvivors() {
		return survivorRepository.findByInfectedFalse();
	}

	public SurvivorPercentage getSurvivorPercentages() {
		float allSurvivors = survivorRepository.findAll().size();
		float infectedCount = survivorRepository.findByInfectedTrue().size();
		float nonInfectedCount = allSurvivors - infectedCount;
		SurvivorPercentage percentage = new SurvivorPercentage();
		percentage.setInfected((infectedCount/allSurvivors)*100);
		percentage.setNonInfected((nonInfectedCount/allSurvivors)*100);	
		return percentage;
	}

}
