package com.oakscode.usermanagementapi.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



//@jakarta.persistence.Table(name="USERS_TBL")
@Entity
@Data
@AllArgsConstructor(staticName="build")
@NoArgsConstructor
public class Users {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int id;
	
	private  String firstName;
	
	private String lastName;
	
	private String email;
	
	private String phone;
	
	private String gender;
	
	private Date dateOfBirth;
	
	private String nationality;
	
	private int roleId;
	

}
