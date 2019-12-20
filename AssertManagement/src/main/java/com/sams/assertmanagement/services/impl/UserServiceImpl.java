package com.sams.assertmanagement.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sams.assertmanagement.jwtutils.JwtTokenProvider;
import com.sams.assertmanagement.model.User;
import com.sams.assertmanagement.parameters.UserParameter;
import com.sams.assertmanagement.repository.IUserDAO;
import com.sams.assertmanagement.services.IUserService;

/**
 * @author SPSOFT
 *
 */
@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private JwtTokenProvider jwtTokenProvider;

	@Autowired
	private IUserDAO userDao;

	@Override
	public String save(UserParameter userParameter) throws Exception {

		User user = new User(userParameter);
		user.setPassword(passwordEncoder.encode(userParameter.getPassWord()));
		userDao.saveUser(user);
		return jwtTokenProvider.createToken(user.getLoginId(), user.getRoles());
	}

	@Override
	public User update(User user) throws Exception {
		return userDao.updateUser(user);
	}

	@Override
	public void delete(User user) throws Exception {
		userDao.deleteUser(user);
	}

	@Override
	public List<User> loadAllUserDetails() throws Exception {
		return userDao.getAllUserDetails();
	}

	@Override
	public User loadUserDetails(String id) throws Exception {
		return userDao.getUserDetails(id);
	}

}
