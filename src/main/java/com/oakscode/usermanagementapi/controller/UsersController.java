package com.oakscode.usermanagementapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oakscode.usermanagementapi.exception.UserNotFoundException;
import com.oakscode.usermanagementapi.model.Users;
import com.oakscode.usermanagementapi.service.UserRoleService;
import com.oakscode.usermanagementapi.service.UsersService;
import com.oakscode.usermanagementapi.usersDTO.usersDTO;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/")
//@PreAuthorize("hasRole('ADMIN')")
//@SecurityRequirement(name="api_key")
public class UsersController {
	
	@Autowired
	private UserRoleService uservice;
	@Autowired
	private UsersService service;
	
	
	@PostMapping("users/addUsers")
	public ResponseEntity<Users> addUsers(@RequestBody @Valid usersDTO usersDto) throws UserNotFoundException{
		uservice.getUserRole(usersDto.getRoleId());
		return new ResponseEntity<Users>(service.addUser(usersDto), HttpStatus.CREATED);
		
	}
	
	@GetMapping("users/{id}")
	public ResponseEntity<Users> getUserById(@PathVariable int id)throws UserNotFoundException {
		return ResponseEntity.ok(service.getUser(id));
		
	}
	
	@GetMapping("users/getAllUsers")
	public ResponseEntity<List<Users>> getAllUsers(){
		
		return ResponseEntity.ok(service.getAllUsers());
	}
	@PutMapping("users/updateUser/{id}")
	public ResponseEntity<Users> updateUser(@PathVariable int id, @RequestBody @Valid usersDTO users) throws UserNotFoundException{
		
		uservice.getUserRole(users.getRoleId());
		return ResponseEntity.ok(service.updateUser(users, id));
		
	}
	
	
	@DeleteMapping("users/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable int id) throws UserNotFoundException{
		return ResponseEntity.ok(service.deleteUser(id));
	}
	
	@DeleteMapping("users/deleteMultipleUsers")
	public ResponseEntity<String> deleteMultipleUsers(@RequestBody List<Integer> id) throws UserNotFoundException{
		return ResponseEntity.ok(service.deleteMultipleUsers(id));
		
	}

}
