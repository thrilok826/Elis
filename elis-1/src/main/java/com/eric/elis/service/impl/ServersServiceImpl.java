package com.eric.elis.service.impl;

import java.lang.Long;
import java.lang.Override;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eric.elis.entity.Servers;
import com.eric.elis.repo.ServersRepository;
import com.eric.elis.service.IServersService;

@Service
public class ServersServiceImpl implements IServersService {
	@Autowired
	private ServersRepository repo;

	@Override
	@Transactional
	public Long saveServers(Servers servers) {
		return repo.save(servers).getId();
	}

	@Override
	@Transactional
	public void updateServers(Servers servers) {
		repo.save(servers);
	}

	@Override
	@Transactional
	public void deleteServers(Long id) {
		repo.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Servers getOneServers(Long id) {
		return repo.findById(id).get();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Servers> getAllServerss() {
		return repo.findAll();
	}

	@Override
	public List<Object[]> getServersByEnvironment(Long envName) {
		List<Object[]> list = repo.getServersByEnvironment(envName);
		return list;
	}
}
