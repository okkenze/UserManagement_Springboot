package com.oakscode.usermanagementapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oakscode.usermanagementapi.model.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users,Integer>{
	Users findById(int id);

}
