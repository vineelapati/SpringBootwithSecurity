package com.sams.assertmanagement.repository;

import java.util.List;

import com.sams.assertmanagement.model.User;

/**
 * @author SPSOFT
 *
 */
public interface IUserDAO {

	/**
	 * Save the user details
	 * 
	 * @param user user object
	 * @return created user
	 * @throws Exception
	 */
	public User saveUser(User user) throws Exception;
	
	/**
	 * Save the User details
	 * @param user
	 * @return
	 */
	public User updateUser(User user)throws Exception;
	
	/**
	 * Save the User details
	 * @param user
	 * @return
	 */
	public void deleteUser(User user)throws Exception;
	
	/**
	 * get the all User details
	 * @param user
	 * @return
	 */
	public List<User> getAllUserDetails()throws Exception;
	
	/**
	 * get a User details
	 * @param user
	 * @return
	 */
	public User getUserDetails(String id)throws Exception;
	
	/**
	 * verify a User login details
	 * @param user
	 * @return
	 */
	public User verifyUserLoginDetails(String loginId, String passWord) throws Exception;
	
	/**
	 * get a User details based on login id
	 * @param user
	 * @return
	 */
	public User getUserDetailsByLoginId(String loginId) throws Exception;

}
