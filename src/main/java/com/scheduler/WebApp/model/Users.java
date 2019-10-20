package com.scheduler.WebApp.model;

import java.util.UUID;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Users 
{
	
	private final Integer employeeId; 
	private final String firstName; 
	private final String lastName; 
	private boolean managerStatus = false;
	
	//Constructor
	public Users(
			@JsonProperty("eomployeeID")Integer employeeId, 
			@JsonProperty("firstName")String firstName,
			@JsonProperty("lastName")String lastName,
			@JsonProperty("managerStatus")boolean managerStatus
				)
				{
				    this.employeeId = employeeId;
			        this.firstName = firstName;
			        this.lastName = lastName;
			        this.managerStatus = managerStatus;
					
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
	public int getEmployeeId()
	{
		return employeeId;
	}
	
	
	/*
	public void setEmployeeId(int employeeId)
	{
		this.employeeId = employeeId;
	}
	
	*/
	
	public String getFirstName()
	{
		return firstName;
	}
	
	
	/*
	public void setFirstName(String firstName) 
	{
		this.firstName = firstName;
	}
	
	*/
	
	public String getLastName()
	{
		return lastName;
	}
	
	
	/*
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	*/
	
	public boolean isManager(boolean managerStatus) {
		return this.managerStatus;
	}

	
	
	@Override
    public String toString() {
        return String.format(
                "Employee[id=%s, firstName='%s', lastName='%s']",
                employeeId, firstName, lastName);
    }

}

