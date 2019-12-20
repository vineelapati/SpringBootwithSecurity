package com.sams.assertmanagement.repository.impl;

import java.util.List;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.sams.assertmanagement.common.AbstractDAO;
import com.sams.assertmanagement.model.User;
import com.sams.assertmanagement.repository.IUserDAO;

/**
 * @author SPSOFT
 *
 */
@Repository
public class UserDAOImpl extends AbstractDAO<User, String> implements IUserDAO
{

	@Override
	public User saveUser(User user) throws Exception 
	{
		return save(user);
	}

	@Override
	public User updateUser(User user) throws Exception {
		
		Query query = new Query();
		query.addCriteria(Criteria.where("userId").is(user.getUserId()));
		Update update = new Update();
		update.set("emailId", user.getEmailId());
		//remove the createdDate field
		update.unset("createdDate");

		return update(query, update);
	}

	@Override
	public void deleteUser(User user) throws Exception {
		delete(user);
	}

	@Override
	public List<User> getAllUserDetails() throws Exception {
		return findAll();
	}

	@Override
	public User getUserDetails(String id) throws Exception {
		return findById(id);
	}
	
	@Override
	public User verifyUserLoginDetails(String loginId, String passWord) throws Exception {
		Query query = new Query();
		query.addCriteria(Criteria.where("loginId").is(loginId) //
				.and("password").is(passWord));
		return findOne(query);
	}
	
	@Override
	public User getUserDetailsByLoginId(String loginId) throws Exception {
		Query query = new Query();
		query.addCriteria(Criteria.where("loginId").is(loginId));
		return findOne(query);
	}
}
