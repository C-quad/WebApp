package com.scheduler.WebApp.model;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CreateUser 
{
	@Autowired
	//BCryptPasswordEncoder bcrypt; 
	
	
	@NotNull 
	@NotEmpty
	private String firstName;
	
	@NotNull 
	@NotEmpty
	private String lastName;
	
	@NotNull 
	@NotEmpty
	
	private String email; 
	
	@NotNull 
	@NotEmpty
	private String password;
	private String checkPassword;
	
	
	public CreateUser(String firstName, String lastName, String email,  String password, String checkPassword)
	{

		
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.checkPassword = checkPassword;
		
		//bcrypt = new BCryptPasswordEncoder();
	}

	
	
	public boolean checkPass()
	{	
		return true; //bcrypt.matches(password, checkPassword);
	}

	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getCheckPassword() {
		return checkPassword;
	}


	public void setCheckPassword(String checkPassword) {
		this.checkPassword = checkPassword;
	}
	
	
	
	
	
}
