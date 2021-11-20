package com.robot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.robot.entity.Survivor;
import com.robot.model.Robot;
import com.robot.model.SurvivorPercentage;
import com.robot.service.SurvivorService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/")
public class RobotController {

	@Autowired
	private SurvivorService survivorService;
	
	@ApiOperation(
            value = "Get all survivor.",
            notes = "Retrieves the all survivors available for to a caller.",
            response = Survivor.class
    )
	@GetMapping(value = "/allsurvivor", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Survivor> getAllSurvivors() {
		return survivorService.getAllSurvivors();
	}
	@ApiOperation(
            value = "Add survivor.",
            notes = "Add survivor to the Database.",
            response = Survivor.class
    )
	@PostMapping(value = "/addsurvivor", 
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Survivor> addSurvivor(@RequestBody Survivor survivor) {
		return new ResponseEntity<>(survivorService.saveSurvivor(survivor), HttpStatus.CREATED);
	}
	@ApiOperation(
            value = "Add All survivors.",
            notes = "Add All survivors to the Database.",
            response = Survivor.class
    )
	@PostMapping(value = "/add/allsurvivors", 
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<Survivor> addSurvivors(@RequestBody List<Survivor> survivors) {
		return survivorService.addSurvivors(survivors);
	}
	@ApiOperation(
            value = "Update survivor location.",
            notes = "Update survivor location to the Database Based on ID.",
            response = Survivor.class)
    
	@PutMapping(value = "/updatelocation/{id}", 
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Survivor> updateSurvivor(@PathVariable("id") long id, @RequestBody Survivor survivor) {
		Survivor response = survivorService.updateSurvivor(id, survivor);
		if (response != null)
			return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	@ApiOperation(
            value = "Flag survivor as infected.",
            notes = "Flag survivor as infected as True.",
            response = Survivor.class)
    
	@PutMapping(value = "/infect-survivor/{id}", 
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	
	public ResponseEntity<Survivor> infectedSurvivor(@PathVariable("id") long id) {
		Survivor response = survivorService.infectedSurvivor(id);
		if (response != null)
			return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	@ApiOperation(
            value = "List of robots Connect to the Robot CPU system.",
            notes = "List of robots sorting according to Category.",
            response = Robot.class)
	@GetMapping(value = "/allrobots", 
			produces = MediaType.APPLICATION_JSON_VALUE)
			
	public List<Robot> getAllRobots() {
		return survivorService.getRobots();
	}
	
	@ApiOperation(
            value = "List of infected survivors.",
            notes = "Infected survivors.",
            response = Survivor.class)
	
	@GetMapping(value = "/all/infected/survivors", 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Survivor> getInfectedSurvivors() {
		return survivorService.getInfectedSurvivors();
	}
	
	@ApiOperation(value = "List of non-infected survivors.",notes = "Non-infected survivors.",response = Survivor.class)
	
	@GetMapping(value = "/all/noninfected-survivors",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Survivor> getNonInfectedSurvivors() {
		return survivorService.getNonInfectedSurvivors();
	}
	
	@ApiOperation(value = "Percentage of infected survivors and Non-infected survivors .",notes = "Percentage of survivors .",response = SurvivorPercentage.class)
	
	@GetMapping(value = "/survivor/percentages", 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public SurvivorPercentage getSurvivorPercentages() {
		return survivorService.getSurvivorPercentages();
	}

}
