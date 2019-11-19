package com.scheduler.WebApp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.scheduler.WebApp.model.Users;

@Repository
public interface EmployeeRepository extends MongoRepository<Users, String>  {

	@Override
	void delete(Users deleted);
	
	public Users findByFirstName(String firstName);
	public Users findByEmail(String Email);
    
    //public List<Users> findByLastName(String lastName);
    
    
    
    
    
    }
