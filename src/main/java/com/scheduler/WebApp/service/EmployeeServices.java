package com.scheduler.WebApp.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.scheduler.WebApp.model.Users;
import com.scheduler.WebApp.repository.EmployeeRepository;


@Service 
public class EmployeeServices 
{	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	public EmployeeServices(EmployeeRepository employeeRepository)
	{
		
		this.employeeRepository = employeeRepository;
		employeeRepository.deleteAll();
		employeeRepository.save(new Users( UUID.randomUUID(), "Alice", "Smith", false, "aSmith@gmail.com", "Password", ""));	
		employeeRepository.save(new Users( UUID.randomUUID(), "Bob", "Smith", false, "bSmith@gmail.com", "Passowrd",""));
	
	}
	
	
	
	// Add employee to database 
	public Users addEmployee(Users employee)
	{
		employee.setEmployeeId(UUID.randomUUID());
	
		return employeeRepository.save(employee);
	}


	//Get all employees
	public List<Users> getAllEmployees()
	{
		return employeeRepository.findAll();
	}
	
	 
	
	// get employee by first name
	public Users getEmployeeByFirstName(String firstName)
	{
		return employeeRepository.findByFirstName(firstName);
				
	}
	
	
	// update employee info 
	public Users updateEmployeeInfo(String firstName, String lastName, Boolean isManager )
	{
		Users employee =  employeeRepository.findByFirstName(firstName);
		
		employee.setLastName(lastName);
		employee.setIsManager(isManager);
		
		
	
		System.out.println(employee.getFirstName());
		System.out.println(employee.getLastName());

		return  employeeRepository.save(employee);
	}
	
	
	//Delete employee
	public void delete(String firstName)
	{
		Users employee = employeeRepository.findByFirstName(firstName);
		employeeRepository.delete(employee);
		
	}
	
	
	
	// insert availability
	public Users availability(String schedule, Users employee)
	{

		
		employee.setEventBlocks(schedule);
		

		employeeRepository.deleteAll();
		employeeRepository.save(employee);
		
		
		
		return employee;
	}
	
	
	
	
	public Boolean checkIfEmailIsUsed( String email)
	{
		Users employee = employeeRepository.findByEmail(email);
		
		if (employee == null )
		{
			return false;
		}
		
		return true;
		
	}
	
	public Users getByEmail( String email)
	{
		Users employee = employeeRepository.findByEmail(email);
		
	
		return employee; 
		
	}
	
}