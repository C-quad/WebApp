package com.scheduler.WebApp.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.scheduler.WebApp.model.Users;
import com.scheduler.WebApp.repository.EmployeeRepository;
import com.scheduler.WebApp.service.EmployeeServices;


@Controller
public class WebController 
{
	@Autowired
	private EmployeeServices employeeServices; 
	
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	
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
    
    
    
    //JS will loop through all events present on client side memory, passing 
    //the event's title, start time, end time, and current index number to know if we're at the first or last event
    //This method will call another method to compile a complete JSON formatted calendar event string
    @RequestMapping(value = "/getEvents", method = RequestMethod.POST)
    public void getEvents(@RequestParam(value = "title") String title, @RequestParam(value = "start") String start, 
    		@RequestParam(value = "end") String end, @RequestParam(value = "index") int index,
    		@RequestParam(value = "lastIndex") int lastIndex, @RequestParam(value = "color") String color, @RequestParam(value = "employee") String name) {
    	//Empties previous string if we're going through a new array, indicated by index 0
    	if(index == 0) {
    		fullEventString = "";
    	}
    	
    	//Append new event's attributes at current index to the string
    	fullEventString = fullEventString + appendEventString(
    					  "{"
    					+ "\n\"title\" : \"" + title + "\","
    					+ "\n\"start\" : \""+ start + "\","
    					+ "\n\"end\" : \"" + end + "\","
    					+ "\n\"color\" : \"" + color + "\","
    					+ "\n}", index, lastIndex);
    	//At this point fullEventString should contain entire calendar
    	if(index == lastIndex) {
    		
    		Users user = employeeRepository.findByFirstName(name);
    		
    		
        	employeeServices.availability(fullEventString,user);
        	
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
    public @ResponseBody String loadEvents( @RequestParam(value = "employee") String name) throws FileNotFoundException {
    	System.out.println(" inside load events" );
    	Users user = employeeRepository.findByFirstName(name);
    	System.out.println(name + " inside load events" );
		return user.getEventBlocks();
    }
    
    

	@RequestMapping("/weekly-calendar.html")
	public void scheduleEmployeeDetails(Model model) {
		model.addAttribute("employeeList", employeeRepository.findByFirstName("Manager"));
		
	}
	

	@RequestMapping("/employee.html")
	public String employeeDetails(Model model) {
		model.addAttribute("employeeList", employeeRepository.findAll());
		
		System.out.print(employeeRepository.findAll());
		return "employee";
	}
	

	
	@RequestMapping(value="/weekly-calendar.html", method=RequestMethod.POST)
	public void getEditPerson(@RequestParam("employeeId") String employeeId, Model model) {
	    Map<String,Object> map = new HashMap<>();
	    
	    Users employee =  employeeRepository.findByEmail(employeeId);
	    map.put("Name", employee.getFirstName());
		model.addAttribute("employeeList", employee);
		
		
	    // Set view.      
	    
	} 
	
    
}

