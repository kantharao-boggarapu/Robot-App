package com.robot.constants;

import org.springframework.beans.factory.annotation.Value;

public enum Robot_Type {

	@Value("Land")
	LAND, 
	
	@Value("Flying")
	FLYING
}
