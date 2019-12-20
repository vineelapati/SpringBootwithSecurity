package com.sams.assertmanagement.repository;

import com.sams.assertmanagement.model.LoginDetails;

/**
 * @author SPSOFT
 *
 */
public interface ILoginDetailsDAO 
{

	/**
	 * Save the login details
	 * @param loginDetails
	 * @return LoginDetails object
	 * @throws Exception
	 */
	public LoginDetails saveLoginDetails(LoginDetails loginDetails) throws Exception;

}
