package com.sams.assertmanagement.repository.impl;

import org.springframework.stereotype.Repository;

import com.sams.assertmanagement.common.AbstractDAO;
import com.sams.assertmanagement.model.LoginDetails;
import com.sams.assertmanagement.repository.ILoginDetailsDAO;

/**
 * @author SPSOFT
 *
 */
@Repository
public class LoginDetailsDAOImpl extends AbstractDAO<LoginDetails, String> implements ILoginDetailsDAO {

	@Override
	public LoginDetails saveLoginDetails(LoginDetails loginDetails) throws Exception 
	{
		return save(loginDetails);
	}
}
