package com.sams.assertmanagement.services;

import com.sams.assertmanagement.parameters.LoginDetailParameter;

/**
 * @author SPSOFT
 *
 */
public interface ILoginDetailsService {

	/**
	 * load the user login details
	 * @param loginDetailParameter
	 * @return jwt token
	 * @throws Exception
	 */
	public String loadLoginDetails(LoginDetailParameter loginDetailParameter) throws Exception;

}
