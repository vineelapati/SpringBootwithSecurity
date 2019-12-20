package com.sams.assertmanagement.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author SPSOFT
 *
 */
@Document(collection="loginDetails")
public class LoginDetails implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Id
	private String loginId;
	
	private String userId;
	
	private Date loginTime;
	

	public LoginDetails(String userId, Date loginTime) {
		
		this.userId = userId;
		this.loginTime = loginTime;
	}

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
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the loginTime
	 */
	public Date getLoginTime() {
		return loginTime;
	}

	/**
	 * @param loginTime the loginTime to set
	 */
	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}

}
