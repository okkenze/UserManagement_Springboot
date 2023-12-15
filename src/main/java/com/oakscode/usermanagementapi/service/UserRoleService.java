package com.oakscode.usermanagementapi.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oakscode.usermanagementapi.exception.UserNotFoundException;
import com.oakscode.usermanagementapi.model.UserRoles;
import com.oakscode.usermanagementapi.repository.UserRolesRepository;

@Service
public class UserRoleService {
	
	@Autowired
	private UserRolesRepository userRepo;
	
	
	public UserRoles getUserRole(int roleId) throws UserNotFoundException{
		
		UserRoles user =userRepo.findById(roleId);
		
		if(user != null) {
			return user;
		}
			else {
			throw new UserNotFoundException("user role not found with "+roleId);
		}
		
	}

}
