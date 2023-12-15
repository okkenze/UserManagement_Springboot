package com.oakscode.usermanagementapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oakscode.usermanagementapi.model.UserRoles;

@Repository
public interface UserRolesRepository extends JpaRepository<UserRoles,Integer>{
	UserRoles findById(int roleId);
}
