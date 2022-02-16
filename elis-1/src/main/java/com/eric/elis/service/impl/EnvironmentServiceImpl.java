package com.eric.elis.service.impl;

import java.lang.Long;
import java.lang.Override;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eric.elis.entity.Environment;
import com.eric.elis.repo.EnvironmentReposiotory;
import com.eric.elis.service.IEnvironmentService;
import com.eric.elis.util.MyCollectionsUtil;

@Service
public class EnvironmentServiceImpl implements IEnvironmentService {
	@Autowired
	private EnvironmentReposiotory repo;

	@Override
	public Long saveEnvironment(Environment environment) {
		return repo.save(environment).getId();
	}

	@Override
	public void updateEnvironment(Environment environment) {
		repo.save(environment);
	}

	@Override
	public void deleteEnvironment(Long id) {
		repo.deleteById(id);
	}

	@Override
	public Environment getOneEnvironment(Long id) {
		return repo.findById(id).get();
	}

	@Override
	public List<Environment> getAllEnvironments() {
		return repo.findAll();
	}

	@Override
	public Map<Long, String> getEnvIdAndName() {
		List<Object[]> list = repo.getEnvIdAndName();
		Map<Long, String> map = MyCollectionsUtil.convertToMap(list);
		return map;
	}

	@Override
	public Environment getEnvironmentIdByEnvName(String envName) {
		// TODO Auto-generated method stub
		Environment env = repo.getEnvironmentIdByEnvName(envName);

		return env;
	}

}
