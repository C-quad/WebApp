package com.scheduler.WebApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.scheduler.WebApp.model.Users;


@RestController
public class WebController 
{
	
    /**
     * This is a simple example of how the HTTP API works.
     * It returns a String "OK" in the HTTP response.
     * To try it, run the web application locally,
     * in your web browser, type the link:
     *  http://localhost:8080/cs480/ping
     */
    @RequestMapping(value = "/cs480/ping", method = RequestMethod.GET)
    String healthCheck() {
        // You can replace this with other string,
        // and run the application locally to check your changes
        // with the URL: http://localhost:8080/
        return "OK";
    }
    
    
    @RequestMapping( value ="/data", 
    				method = RequestMethod.POST, 
    				produces = MediaType.APPLICATION_JSON_VALUE)
    public void insertNewEmployee(Users newEmployee)
    {
    	
    }
    	
    	
    
    
    
    
    	
} 
	