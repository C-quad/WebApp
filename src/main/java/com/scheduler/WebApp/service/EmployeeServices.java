package com.scheduler.WebApp.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.data.mongodb.core.query.Update;
import com.scheduler.WebApp.model.Users;
import com.scheduler.WebApp.repository.EmployeeRepository;


@Service 

public class EmployeeServices 
{	
	@Autowired
	private EmployeeRepository employeeRepository;
	 @Autowired
	  private MongoTemplate mongoTemplate;
	
	 
	 
	public EmployeeServices(EmployeeRepository employeeRepository)
	{
		
		this.employeeRepository = employeeRepository;
		employeeRepository.deleteAll();
		employeeRepository.insert(new Users(ObjectId.get(), "Manager", "IMTHEBOSS", false, "bMan@gmail.com", "Passowrd",""));
		employeeRepository.insert(new Users(ObjectId.get(), "Alice", "Smith", false, "aSmith@gmail.com", "Password", ""));	
		employeeRepository.insert(new Users(ObjectId.get(), "Bob", "Smith", false, "bSmith@gmail.com", "Passowrd",""));
		employeeRepository.insert(new Users(ObjectId.get(), "Eric", "Long", false, "elong@gmail.com", "Passowrd",""));
		employeeRepository.insert(new Users(ObjectId.get(), "Derik", "Sicks", false, "dSicks@gmail.com", "Passowrd",""));
		employeeRepository.insert(new Users(ObjectId.get(), "Tommy", "Bingue", false, "tBingue@gmail.com", "Passowrd",""));
	
	}
	
	
	
	// Add employee to database 
	public Users addEmployee(Users employee)
	{
	//	employee.setEmployeeId(ObjectId.toHexString());
	
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
	public void updateEmployeeInfo(Users employee)
	{

		
		employeeRepository.deleteAll();
		employeeRepository.insert(new Users(ObjectId.get(), "Manager", "IMTHEBOSS", false, "bMan@gmail.com", "Passowrd",employee.getEventBlocks()));
		employeeRepository.insert(new Users(ObjectId.get(), "Alice", "Smith", false, "aSmith@gmail.com", "Password", employee.getEventBlocks()));	
		employeeRepository.insert(new Users(ObjectId.get(), "Bob", "Smith", false, "bSmith@gmail.com", "Passowrd",employee.getEventBlocks()));
		employeeRepository.insert(new Users(ObjectId.get(), "Eric", "Long", false, "elong@gmail.com", "Passowrd",employee.getEventBlocks()));
		employeeRepository.insert(new Users(ObjectId.get(), "Derik", "Sicks", false, "dSicks@gmail.com", "Passowrd",employee.getEventBlocks()));
		employeeRepository.insert(new Users(ObjectId.get(), "Tommy", "Bingue", false, "tBingue@gmail.com", "Passowrd",employee.getEventBlocks()));
	}
	
	
	//Delete employee
	public void delete(String firstName)
	{
		Users employee = employeeRepository.findByFirstName(firstName);
		employeeRepository.delete(employee);
		
	}
	
		
	// insert availability
	public void availability(String schedule, Users employee)
	{ 
		
		System.out.println(employee.getEmployeeId() + " Are they the same" + employee.getUserId() );
		
		
		employee.setEventBlocks(schedule);
		updateEmployeeInfo(employee);

	}
	
	public Users getEmployeeById(Users employeeFind)
	{
		System.out.print("////////// " + employeeFind.get_id()+ " ////////////");
		Optional<Users> employee = employeeRepository.findById("5de5e94d3681334ee83a6838");
		
		return employee.get();
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