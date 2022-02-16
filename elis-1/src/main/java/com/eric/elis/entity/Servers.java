package com.eric.elis.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "servers_tab")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Servers {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;

	@Column(name = "servers_tab_servername_col")
	private String serverName;

	@ManyToOne
	@JoinColumn(name = "env_id_fk_col")
	private Environment environment;

}
