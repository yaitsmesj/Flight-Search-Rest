package com.nagarro.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.nagarro.Repository.LoginDao;
import com.nagarro.model.User;
import com.nagarro.model.UserRole;

@Service("loginService")
public class LoginService implements UserDetailsService {

	@Autowired
	private LoginDao loginDao;

	private List<GrantedAuthority> buildUserAuthority(Set<UserRole> userRoles) {

		Set<GrantedAuthority> setAuths = new HashSet<>();

		for (UserRole userRole : userRoles) {
			System.out.println(userRole.getRole());
			setAuths.add(new SimpleGrantedAuthority(userRole.getRole()));
		}
		List<GrantedAuthority> result = new ArrayList<GrantedAuthority>(setAuths);

		return result;
	}

	private UserDetails buildUserForAuthentication(User user, List<GrantedAuthority> authorities) {

		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				user.isEnabled(), true, true, true, authorities);

	}

	public LoginDao getLoginDao() {
		return loginDao;
	}

	@Transactional
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = loginDao.findByUserName(username);
		List<GrantedAuthority> authorities = buildUserAuthority(loginDao.findUserRole(username));
		UserDetails userDetails = buildUserForAuthentication(user, authorities);
		return userDetails;
	}

	public void setLoginDao(LoginDao loginDao) {
		this.loginDao = loginDao;
	}

}
