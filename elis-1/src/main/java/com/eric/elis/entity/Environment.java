package com.eric.elis.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "environment_tab")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Environment {

	@Id
	@Column(name = "environment_tab_id" )
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "environment_tab_envName")
	private String envName;
}
