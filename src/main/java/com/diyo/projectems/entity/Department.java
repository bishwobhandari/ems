package com.diyo.projectems.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="department")
public class Department {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name="name")
	private String name;
	
	
	@Column(name="code")
	private String code;
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="department", orphanRemoval=true)
	@JsonIgnoreProperties("department")
	private List<Employee> employeeList = new ArrayList<>();


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public List<Employee> getEmployeeList() {
		return employeeList;
	}
	
	
	
	
	    
}
