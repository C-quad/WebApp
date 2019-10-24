package com.scheduler.WebApp;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.scheduler.WebApp.model.Users;
import com.scheduler.WebApp.repository.EmployeeRepository;


@SpringBootApplication
public class App 
//implements CommandLineRunner
{

	
    //@Autowired
    //private EmployeeRepository repository;
    
	public static void main(String[] args) throws Exception 
	{
		SpringApplication.run(App.class, args);
	}
	
	/*
	   public void run(String... args) throws Exception {

		    
	        repository.deleteAll();

	        // save a couple of customers
	        repository.save(new Users( 1, "Alice", "Smith", false));	
	        repository.save(new Users( 2, "Bob", "Smith", false));

	        // fetch all customers
	        System.out.println("Customers found with findAll():");
	        System.out.println("-------------------------------");
	        for (Users user : repository.findAll()) {
	            System.out.println(user);
	        }
	        System.out.println();

	        // fetch an individual customer
	        System.out.println("Customer found with findByFirstName('Alice'):");
	        System.out.println("--------------------------------");
	        System.out.println(repository.findByFirstName("Alice"));

	        System.out.println("Customers found with findByLastName('Smith'):");
	        System.out.println("--------------------------------");
	        for (Users user : repository.findByLastName("Smith")) {
	            System.out.println(user);
	        }
	        

	    }
	    */
	
}
