package com.travactory.recruitment.junior.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customers")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(columnDefinition = "VARCHAR(256)")
	private String firstName;
	@Column(columnDefinition = "VARCHAR(256)")
	private String lastName;
	@Column(columnDefinition = "VARCHAR(256)")
	private String email;
	@Column(columnDefinition = "VARCHAR(1)")
	private String gender;
	@Column(columnDefinition = "TIMESTAMP")
	private Date dateOfBirth;
	
	public Integer getId() {
		return id;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getEmail() {
		return email;
	}

	public String getGender() {
		String genderFullName;
		switch (gender) {
        case "M":
        	genderFullName = "Male";
            break;
        case "F":
        	genderFullName = "Female";
            break;
        default:
        	genderFullName = "Unknown gender " + gender;
		}
		return genderFullName;
	}
}
