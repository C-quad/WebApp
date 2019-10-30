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
    
    
    //Gets all values (First name, last name, email, password) from registeration page
    @RequestMapping(value = "/checkCredentials", method = RequestMethod.POST)
    public void getCredentials(@RequestParam(value = "fname") String firstName, @RequestParam(value = "lname") String lastName,
    		@RequestParam(value = "em") String email, @RequestParam(value = "pass") String password,
    		@RequestParam(value = "repass") String repassword) 
    {
    	System.out.println("First Name: " + firstName);
    	System.out.println("Last Name: " + lastName);
    	System.out.println("Email: " + email);
    	System.out.println("Pw: " + password);
    	System.out.println("RE:Pw: " + repassword);
    	
    	
    	employeeServices.addEmployee(new Users(UUID.randomUUID(), firstName, lastName, false, email, repassword) );
   
    	
    }
}

