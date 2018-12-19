package com.nagarro.Repository;

import java.util.Set;

import com.nagarro.model.User;
import com.nagarro.model.UserRole;

public interface LoginDao {

	User findByUserName(String username);

	Set<UserRole> findUserRole(String username);
}
