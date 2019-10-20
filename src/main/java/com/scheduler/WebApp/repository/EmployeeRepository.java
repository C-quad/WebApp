package com.scheduler.WebApp.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.scheduler.WebApp.model.Users;

@Repository
public interface EmployeeRepository extends MongoRepository<Users, String> {

    public Users findByFirstName(String firstName);
    
    public List<Users> findByLastName(String lastName);
    
  //  int insertNewEmployee(UUID employeeID, Users employee ); 
    
  //  int deleteEmployee(UUID employeeID);
    
    
    
    }
