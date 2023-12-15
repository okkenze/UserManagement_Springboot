package com.oakscode.usermanagementapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oakscode.usermanagementapi.exception.UserNotFoundException;
import com.oakscode.usermanagementapi.model.Users;
import com.oakscode.usermanagementapi.repository.UsersRepository;
import com.oakscode.usermanagementapi.usersDTO.usersDTO;

@Service
public class UsersService {
	
	@Autowired
	private UsersRepository repo;
	

	
		public Users addUser(usersDTO users){
		
			
			Users user = Users.build(0, users.getFirstName(), users.getLastName(), users.getEmail(), users.getPhone(), users.getGender(), users.getDateOfBirth(), users.getNationality(), users.getRoleId());
				
				return repo.save(user);
				
		}


		public Users getUser(int id) throws UserNotFoundException{
			Users user = repo.findById(id);
			if(user !=null) {
				
				return user;
			}
			else 
			{
				throw new UserNotFoundException("user not found with "+id);
			}
			
		}
		
		
		public List<Users> getAllUsers(){
			return repo.findAll();
		}
		
		
		public Users updateUser(usersDTO users, int id) throws UserNotFoundException {
			
			Users existingUser = repo.findById(id);
			if(existingUser !=null) {
				existingUser.setFirstName(users.getFirstName());
				existingUser.setLastName(users.getLastName());
				existingUser.setEmail(users.getEmail());
				existingUser.setPhone(users.getPhone());
				existingUser.setGender(users.getGender());
				existingUser.setDateOfBirth(users.getDateOfBirth());
				existingUser.setNationality(users.getNationality());
				repo.save(existingUser);
				return existingUser;
			}
			else 
			{
				throw new UserNotFoundException("user not found with "+id);
			}
		} 
		
		public String deleteUser(int id) throws UserNotFoundException {
			Users existingUser = repo.findById(id);
			if(existingUser != null) {
				
				repo.deleteById(id);
				return "User with id "+id+ " deleted suceesfully";
			}
			else 
			{
				throw new UserNotFoundException("user not found with "+id);
			}
		}
		
		
		public String deleteMultipleUsers(List<Integer> id) throws UserNotFoundException {
			
			List<Users> existingUsers = repo.findAllById(id);
			if(existingUsers.size() > 0) {
				 repo.deleteAllById(id);
				 return "Users deleted successfully";
			}
			else 
			{
				throw new UserNotFoundException("List of ids not found");
			}	
			
			
		}

}
