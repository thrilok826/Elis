package com.eric.elis.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.eric.elis.entity.Environment;

public interface EnvironmentReposiotory extends JpaRepository<Environment, Long> {
	@Query("SELECT id,envName FROM Environment ")
	List<Object[]> getEnvIdAndName();
	
	@Query("FROM Environment server where server.envName =:id")
	Environment getEnvironmentIdByEnvName(String id);
	
	/*
	 * @Query("SELECT id,envName FROM Environment ") List<Object[]>
	 * getEnvIdAndName();
	 */
}
