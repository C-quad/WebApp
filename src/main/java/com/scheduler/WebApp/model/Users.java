package com.scheduler.WebApp.model;

import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import com.fasterxml.jackson.annotation.JsonProperty;



@Document
public class Users 
{
	
	@Id
	private UUID employeeId; 
	private String firstName; 
	private String lastName; 
	private Boolean managerStatus;
	private String eventBlocks;
	
	//Constructor
	public Users(
			@JsonProperty("employeeID")UUID employeeId, 
			@JsonProperty("firstName")String firstName,
			@JsonProperty("lastName")String lastName,
			@JsonProperty("managerStatus")Boolean managerStatus
				)
				{
				    this.employeeId = employeeId;
			        this.firstName = firstName;
			        this.lastName = lastName;
			        this.managerStatus = managerStatus;
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

}

