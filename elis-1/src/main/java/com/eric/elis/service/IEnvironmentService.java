package com.eric.elis.service;

import java.util.List;
import java.util.Map;

import com.eric.elis.entity.Environment;

public interface IEnvironmentService {

	Long saveEnvironment(Environment environment);
	void updateEnvironment(Environment environment);
	void deleteEnvironment(Long id);
	Environment getOneEnvironment(Long id);
	List<Environment> getAllEnvironments();
	Map<Long,String> getEnvIdAndName();
	Environment getEnvironmentIdByEnvName(String envName);
	
}
