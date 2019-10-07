package com.scheduler.WebApp.model;

import org.mvel2.util.Make.String;

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
    public java.lang.String toString() {
        return "Employee info{" +
                "Employee ID: " + employeeId +
                ", First Name: " + firstName + '\'' +
                ", Last Name: " + lastName+ '\'' +
                '}';
    }
}
