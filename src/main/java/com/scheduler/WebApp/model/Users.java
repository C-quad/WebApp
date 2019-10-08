package com.scheduler.WebApp.model;

import org.springframework.data.annotation.Id;

public class Users 
{
	private int employeeId; 
	private String firstName; 
	private String lastName; 
	private boolean managerStatus;
	
	//Constructor
	public Users()
	{
		
	}
	
	public Users(int employeeId, String firstName, String lastName, boolean managerStatus) {
	    this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.managerStatus = managerStatus;
    }
	
	
	// Setters and getters 
	public int getEmployeeId()
	{
		return employeeId;
	}
	
	public void setEmployeeId(int employeeId)
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
