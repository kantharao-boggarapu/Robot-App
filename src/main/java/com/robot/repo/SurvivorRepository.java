package com.robot.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.robot.entity.Survivor;

@Repository
public interface SurvivorRepository extends JpaRepository<Survivor, Long> {

	public List<Survivor> findByInfectedTrue();
	
	public List<Survivor> findByInfectedFalse();
}
