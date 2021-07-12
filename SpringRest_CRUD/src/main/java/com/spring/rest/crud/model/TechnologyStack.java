package com.spring.rest.crud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Technology_Stack")
public class TechnologyStack {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "technology_name")
	private String technologyName;
	
	@Column(name = "version")
	private String version;
	
	
	public TechnologyStack() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TechnologyStack(Long id, String technologyName, String version) {
		super();
		this.id = id;
		this.technologyName = technologyName;
		this.version = version;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTechnologyName() {
		return technologyName;
	}

	public void setTechnologyName(String technologyName) {
		this.technologyName = technologyName;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
	
	
	

}
