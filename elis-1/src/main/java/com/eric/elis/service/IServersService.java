package com.eric.elis.service;

import java.lang.Long;
import java.util.List;

import com.eric.elis.entity.Servers;

public interface IServersService {
	Long saveServers(Servers servers);
	void updateServers(Servers servers);
	void deleteServers(Long id);
	Servers getOneServers(Long id);
	List<Servers> getAllServerss();
	public List<Object[]> getServersByEnvironment(Long envName);
}
