package com.sams.assertmanagement.services;

import java.util.List;

import com.sams.assertmanagement.model.User;
import com.sams.assertmanagement.parameters.UserParameter;

/**
 * 
 * @author SPSOFT
 *
 */
public interface IUserService {

	/**
	 * Save the User details
	 * @param userParameter
	 * @return JWT token
	 */
	public String save(UserParameter userParameter)throws Exception;
	
	/**
	 * Save the User details
	 * @param user
	 * @return
	 */
	public User update(User user)throws Exception;
	
	/**
	 * Save the User details
	 * @param user
	 * @return
	 */
	public void delete(User user)throws Exception;
	
	/**
	 * get the all User details
	 * @param user
	 * @return
	 */
	public List<User> loadAllUserDetails()throws Exception;
	
	/**
	 * get a User details
	 * @param user
	 * @return
	 */
	public User loadUserDetails(String id)throws Exception;

}
