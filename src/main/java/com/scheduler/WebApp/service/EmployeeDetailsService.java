package com.scheduler.WebApp.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
/*
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.scheduler.WebApp.model.Users;
import com.scheduler.WebApp.repository.EmployeeRepository;


@Component
public class EmployeeDetailsService  implements UserDetailsService
{

	
	@Autowired 
	private EmployeeRepository employeeRepository;
	
	@Override
	public UserDetails loadUserByUsername (String email)
	{
		Users employee = employeeRepository.findByEmail(email);
		
		
		class TEMP implements GrantedAuthority
		{
			@Override
			public String getAuthority()
			{
				return  "";
			}
		}
		
		
		
		if (employee == null)
		{
			throw new UsernameNotFoundException(email);
		}
		else
		{
			return new User(employee.getEmail(),employee.getPassword(),new ArrayList<TEMP>());
		}
		
	}
	
	
}

*/