package com.sams.assertmanagement.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sams.assertmanagement.exceptions.NotFoundException;
import com.sams.assertmanagement.jwtutils.JwtTokenProvider;
import com.sams.assertmanagement.parameters.LoginDetailParameter;
import com.sams.assertmanagement.repository.IUserDAO;
import com.sams.assertmanagement.services.ILoginDetailsService;

/**
 * @author SPSOFT
 *
 */
@Service
@Transactional
public class LoginDetailsServiceImpl implements ILoginDetailsService {
	@Autowired
	private IUserDAO userDao;

	@Autowired
	private JwtTokenProvider jwtTokenProvider;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Override
	public String loadLoginDetails(LoginDetailParameter loginDetailParameter) throws Exception 
	{
		String loginId = loginDetailParameter.getLoginId();
		String passWord = loginDetailParameter.getPassword();
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginId, passWord));
			return jwtTokenProvider.createToken(loginId, userDao.getUserDetailsByLoginId(loginId).getRoles());
		} 
		catch (AuthenticationException e) {
			throw new NotFoundException("Given user not exist in the system", HttpStatus.NOT_FOUND);
		}

		// return userDao.verifyUserLoginDetails(loginId, passWord);
	}
}
