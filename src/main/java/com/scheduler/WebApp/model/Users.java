package com.scheduler.WebApp.model;

import java.util.Set;

import java.util.UUID;

import javax.management.relation.Role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;





public class Users 
{

	@Autowired
	BCryptPasswordEncoder bcrypt;
	
	@Id
	private UUID employeeId; 
	
	private String email;
	private String password; 
	private String firstName; 
	private String lastName; 
	private Boolean managerStatus;

	private String eventBlocks;

	

	//Constructor
	
	public Users()
	{
		
	}
	
	
	public Users(
			@JsonProperty("employeeID")UUID employeeId, 
			@JsonProperty("firstName")String firstName,
			@JsonProperty("lastName")String lastName,
			@JsonProperty("managerStatus")Boolean managerStatus,
			@JsonProperty("email")String email,
			@JsonProperty("password")String password
				)
				{
					bcrypt = new BCryptPasswordEncoder();
					
				    this.employeeId = employeeId;
			        this.firstName = firstName;
			        this.lastName = lastName;
			        this.managerStatus = managerStatus;
			        this.email = email; 
			        this.password = bcrypt.encode(password);
			        this.eventBlocks = "";

				}
	
	
	/*
	public Users(int employeeId, String firstName, String lastName, boolean managerStatus) {
		
	    this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.managerStatus = managerStatus;
    }
	*/ 
	
	
	// Setters and getters 
	public UUID getEmployeeId()
	{
		return employeeId;
	}
	
	public void setEmployeeId(UUID employeeId)
	{
		this.employeeId = employeeId; 

	}
	
	
	public String getFirstName()
	{
		return firstName;
	}
	
	
	
	public void setFirstName(String firstName) 
	{
		this.firstName = firstName;
	}
	
	
	
	public String getLastName()
	{
		return lastName;
	}
	
	
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
	public void setIsManager(Boolean isManager) {
		this.managerStatus = isManager;
	}
	
	
	public Boolean isManager() {
		return this.managerStatus;
	}
	
	public String getEventBlocks() {
	    return this.eventBlocks;
	}
	
	public void setEventBlocks(String eventBlocks){
	    this.eventBlocks = eventBlocks;
	}

	
	
	@Override
    public String toString() {
        return String.format(
                "Employee[id=%s, firstName='%s', lastName='%s']",
                employeeId, firstName, lastName);
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

 /* 
	public boolean isEnabled() {
		return enabled;
	}


	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	
	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

*/
	
	
}

