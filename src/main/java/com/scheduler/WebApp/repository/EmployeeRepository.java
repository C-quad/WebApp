package com.scheduler.WebApp.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.Query;

import com.scheduler.WebApp.model.Users;


public interface EmployeeRepository extends MongoRepository<Users, String>  {
	 

	void delete(Users deleted);
	
	public Users findByFirstName(String firstName);
	public Users findByEmail(String Email);
    
    //public List<Users> findByLastName(String lastName);
	
	@Query("{firstName : ?0}")
    public Users findByNFirstName(String name);
	

	
    }
