package com.eric.elis.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.eric.elis.entity.Servers;

public interface ServersRepository extends JpaRepository<Servers, Long> {

	@Query("SELECT server.serverName FROM  Servers server INNER JOIN server.environment as environment where server.environment.id =:envName")
	//@Query("FROM Servers server where server.environment.id =:envName")
	public List<Object[]> getServersByEnvironment(Long envName);

}
