/**
 * 
 */
package com.sams.assertmanagement.parameters;

import java.io.Serializable;

/**
 * @author SPSOFT
 *
 */
public class LoginDetailParameter implements Serializable
{

	private static final long serialVersionUID = 1L;
	
	private String loginId;
	
	private String password;

	/**
	 * @return the loginId
	 */
	public String getLoginId() {
		return loginId;
	}

	/**
	 * @param loginId the loginId to set
	 */
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
}
