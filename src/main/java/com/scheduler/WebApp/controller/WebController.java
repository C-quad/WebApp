package com.scheduler.WebApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


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
    
    //Gets first name / last name input from test-input page
    @RequestMapping(value = "/name", method = RequestMethod.POST)
    public void getNames(@RequestParam(value = "id") String firstName, @RequestParam(value = "id2") String lastName) {
		System.out.println("First Name: " + firstName + " Last Name: " + lastName);
    }
}