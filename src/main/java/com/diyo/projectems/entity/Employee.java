package com.diyo.projectems.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="ems_employee")
@AllArgsConstructor
@NoArgsConstructor
public class Employee implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	private String email;
	
	@Column(name="birth_date")
	private LocalDate birthDate;
	
	@Column(name="phone_number")
	private String phoneNumber;
	
	private  BigInteger salary;
	
	
	@OneToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="address_id",referencedColumnName = "id")
	private Address address;
	

	@ManyToOne
    @JoinColumn(name="department_id")
	@JsonIgnoreProperties("employeeList")
    private Department department;
	
	@Transient
	private  int age;
	
}
