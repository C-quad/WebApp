package com.scheduler.WebApp.controller;

import java.util.UUID;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.scheduler.WebApp.model.CreateUser;
import com.scheduler.WebApp.model.Users;
import com.scheduler.WebApp.service.EmployeeServices;

@RestController
public class LoginAndRegister 
{
	@Autowired
	private EmployeeServices employeeServices;

	  //Gets all values (First name, last name, email, password) from registeration page
    @RequestMapping(value = "/check/Credentials", method = RequestMethod.POST)
    public void getCredentials(
    						@RequestParam(value = "fname") String firstName, @RequestParam(value = "lname") String lastName,
    						@RequestParam(value = "em") String email, @RequestParam(value = "pass") String password,
    						@RequestParam(value = "repass") String repassword) 
    {
    	System.out.println("First Name: " + firstName);
    	System.out.println("Last Name: " + lastName);
    	System.out.println("Email: " + email);
    	System.out.println("Pw: " + password);
    	System.out.println("RE:Pw: " + repassword);
    	
    	
    	CreateUser newEmployee = new CreateUser(firstName, lastName, email, password, repassword);
    	
    	//Conditional statements 
    	
    	//check if user already exists 
    	
    	// check of password are equal to each other 
    	
    	// send responses back to the frontend and explain type of error 
    	
    	employeeServices.addEmployee(new Users(ObjectId.get(), newEmployee.getFirstName(), newEmployee.getLastName(), false, newEmployee.getEmail(), newEmployee.getPassword(), newEmployee.getCheckPassword()));
   
    	
    }
    
    
    
     //login page 
    /*
	@RequestMapping( value = "/login.html", method = RequestMethod.POST)
	public void checkLoginInformation(@RequestParam(value = "mail") String email, @RequestParam(value = "pass") String password) 
	{
		System.out.println(email + " " + password);
		
	}
    
   
	@RequestMapping( value = "/login.html", method = RequestMethod.POST)
    public redirec 
    */
		
}
