package com.sams.assertmanagement.jwtutils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sams.assertmanagement.exceptions.ApplicationException;
import com.sams.assertmanagement.model.User;
import com.sams.assertmanagement.repository.IUserDAO;

@Service
public class AssetUserDetails implements UserDetailsService {

  @Autowired
  private IUserDAO userDAO;

  @Override
  public UserDetails loadUserByUsername(String loginId) throws UsernameNotFoundException {
    User user;
	try {
		user = userDAO.getUserDetailsByLoginId(loginId);
	} catch (Exception e) {
		throw new ApplicationException("Internal server issue",HttpStatus.INTERNAL_SERVER_ERROR);
	}

    if (user == null) {
      throw new UsernameNotFoundException("User login id '" + loginId + "' not found");
    }

    return org.springframework.security.core.userdetails.User//
        .withUsername(loginId)//
        .password(user.getPassword())//
        .authorities(user.getRoles())//
        .accountExpired(false)//
        .accountLocked(false)//
        .credentialsExpired(false)//
        .disabled(false)//
        .build();
  }

}
