package com.scheduler.WebApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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
	
	@RequestMapping( value = "/loginCredentials", method = RequestMethod.POST)
	public void checkLoginInformation(@RequestParam(value = "mail") String email,
			@RequestParam(value = "pass") String password) {
		System.out.println(email + " " + password);
	}
	
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
    
    
    
    //JS will loop through all events present on client side memory, passing 
    //the event's title, start time, end time, and current index number to know if we're at the first or last event
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
    					  "{"
    					+ "\n\"title\" : \"" + title + "\","
    					+ "\n\"start\" : \""+ start + "\","
    					+ "\n\"end\" : \"" + end + "\""
    					+ "\n}", index, lastIndex);
    	//At this point fullEventString should contain entire calendar
    	if(index == lastIndex) {
    		System.out.println(fullEventString);
    		
    		Users user = employeeServices.getEmployeeByFirstName("Alice");
    		
    		System.out.println(user.getFirstName());

        	employeeServices.availability(fullEventString, user);
        	
    		System.out.println(user.getEventBlocks());

        	
    	}
    	
    	
    }
    
    //Method that appends new event content based on index to our current string
    public String appendEventString(String content, int index, int lastIndex) {
    	String eventString = content;
    	
    	//If the event is both our first and last event
    	if(index == lastIndex && index == 0) {
    		eventString = "[\n" + content + "\n]";
        //If the event is the first event but not the last
    	} else if(index == 0) {
        	eventString = "[\n" + content + ",\n";
    	//If the event is neither first nor last; a middle event
    	} else if(index != 0 && index != lastIndex) {
    		return eventString + ",\n";
    	//If the event is the last event
    	} else if(index == lastIndex) {
    		eventString = content + "\n]";
    	}
    	//Return formatted string
		return eventString;
    }
    
    //Method that passes string of events to client-side calendar
    @RequestMapping(value = "/loadEvents", method = RequestMethod.POST)
    public @ResponseBody String loadEvents() {
    	System.out.println(fullEventString);
    	
    	Users user = employeeServices.getEmployeeByFirstName("Alice");
		return user.getEventBlocks();
    }
}

