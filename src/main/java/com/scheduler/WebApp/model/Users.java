package com.scheduler.WebApp.model;

import java.util.Set;

import java.util.UUID;

import javax.management.relation.Role;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonProperty;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;




@Document(collection = "employee")
public class Users 
{

	@Autowired
	//BCryptPasswordEncoder bcrypt;
	
	@Id
	 public ObjectId _id;
	
    @Indexed
    private String firstName;
	private ObjectId userId; 
	private String employeeId; 
	private String email;
	private String password; 
	private String lastName; 
	private Boolean managerStatus;

	private String eventBlocks;

	

	//Constructor
	
	public Users()
	{
		
	}
	
	
	public Users(
			@JsonProperty("employeeID")ObjectId _id,
			@JsonProperty("firstName")String firstName,
			@JsonProperty("lastName")String lastName,
			@JsonProperty("managerStatus")Boolean managerStatus,
			@JsonProperty("email")String email,
			@JsonProperty("password")String password,
			@JsonProperty("password")String eventBlocks
			
				)
				{
					//bcrypt = new BCryptPasswordEncoder();
					this._id = _id;
					this.userId = _id; 
				    this.employeeId = get_id();
			        this.firstName = firstName;
			        this.lastName = lastName;
			        this.managerStatus = managerStatus;
			        this.email = email; 
			        this.password =  password; //bcrypt.encode(password);
			        this.eventBlocks = eventBlocks;

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
	
	public String get_id()
	{ 
		return _id.toHexString(); 
	}
	
	public Object get_Obid()
	{
		return _id; 
	}
	
	public void set_id(ObjectId _id)
	{ 
		this._id = _id; 
	
	}
	
	public String getEmployeeId()
	{
		return employeeId;
	}
	
	public void setEmployeeId(String employeeId)
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

	public ObjectId getUserId() {
		return userId;
	}


	public void setUserId(ObjectId userId) {
		this.userId = userId;
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

