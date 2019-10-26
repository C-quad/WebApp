package com.scheduler.WebApp.controller;

import java.util.List;
import java.util.UUID;

import org.apache.tomcat.jni.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.scheduler.WebApp.model.Users;
import com.scheduler.WebApp.service.EmployeeServices;


@RestController
public class WebController 
{
	@Autowired
	private EmployeeServices employeeServices; 
	
	//Using a static string field to ensure we end up with only one string
	private static String fullEventString = "";
	
	
	
	// Add an employee to the database
    @RequestMapping( value = "/addEmployee", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE )
    public String insertNewEmployee(@RequestBody Users employee)
    {
    	employeeServices.addEmployee(employee);
    	
    	return employee.toString();
    }	
    
    
    //Gets all employees from the database
    @RequestMapping(value = "/displayAllEmployees", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Users> getAllEmployees()
    {
    	return employeeServices.getAllEmployees();
    }
    
    /*
    
    //update employee
    @RequestMapping( value = "/updateEmployee", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE )
    public String Update(Users employee)
    {
    	System.out.println(employee.getFirstName());
		System.out.println(employee.getLastName());
    	
    	employee = employeeServices.updateEmployeeInfo(employee.getFirstName(), employee.getLastName(),employee.isManager());
    	
    	return employee.toString();
    }
    
    */
    
    //Delete employee
    @RequestMapping(value = "/deleteEmployee", method = RequestMethod.POST)
    public String delteEmployee(@RequestParam String firstName)
    { 
    	employeeServices.delete(firstName);
    	return "Deleted" + firstName; 
    }
  

    //Gets first name / last name input from test-input page
    @RequestMapping(value = "/name", method = RequestMethod.POST)
    public void getNames(@RequestParam(value = "id") String firstName, @RequestParam(value = "id2") String lastName) {
		System.out.println("First Name: " + firstName + " Last Name: " + lastName);
    }
    
    //Gets all values (First name, last name, email, password) from registration page
    @RequestMapping(value = "/checkCredentials", method = RequestMethod.POST)
    public void getCredentials(@RequestParam(value = "fname") String firstName, @RequestParam(value = "lname") String lastName,
    		@RequestParam(value = "em") String email, @RequestParam(value = "pass") String password,
    		@RequestParam(value = "repass") String repassword) {
    	System.out.println("First Name: " + firstName);
    	System.out.println("Last Name: " + lastName);
    	System.out.println("Email: " + email);
    	System.out.println("Pw: " + password);
    	System.out.println("RE:Pw: " + repassword);
    }
    
    //For loop in JS will loop through all events present on client side memory, passing 
    //the event's title, start time, end time, and current index number in the for loop,
    //This method will call another method to compile a complete JSON formatted calendar event string
    @RequestMapping(value = "/getEvents", method = RequestMethod.POST)
    public void getEvents(@RequestParam(value = "title") String title, @RequestParam(value = "start") String start, 
    		@RequestParam(value = "end") String end, @RequestParam(value = "index") int index,
    		@RequestParam(value = "lastIndex") int lastIndex) {
    	
    	//Empties previous string if we're going through a new array, indicated by index 0
    	if(index == 0) {
    		fullEventString = "";
    	}
    	
    	//Append new event's attributes at current index to the string
    	fullEventString = fullEventString + appendEventString(
    					  "\t{"
    					+ "\n\t\t\"title\" : \"" + title + "\","
    					+ "\n\t\t\"start\" : \""+ start + "\","
    					+ "\n\t\t\"end\" : \"" + end + "\""
    					+ "\n\t}", index, lastIndex);
    	
    	//At this point fullEventString should contain entire calendar
    	if(index == lastIndex) {
    		System.out.println(fullEventString);
    	}
    }
    
    //Method that appends new event content based on index to our current string
    public String appendEventString(String content, int index, int lastIndex) {
    	String eventString = content;
    	//Appends [ bracket at the beginning of the string
    	
    	if(index == 0) {
        	eventString = "[\n" + content + ",\n";
        //Appends content in the middle
    	} else if(index != 0 && index != lastIndex) {
    		return eventString + ",\n";
    	//Appends ] bracket at the end of the string
    	} else if(index == lastIndex) {
    		eventString = content + "\n]";
    	}
    	//Return formatted string
		return eventString;
    }
}

