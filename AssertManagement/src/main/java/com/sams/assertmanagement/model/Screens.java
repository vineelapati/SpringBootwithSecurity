/**
 * 
 */
package com.sams.assertmanagement.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author SPSOFT
 *
 */
@Document(collection="screen")
public class Screens implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String screenId;

	private String screenName;

	private String screenDescription;

	/**
	 * @return the screenId
	 */
	public String getScreenId() {
		return screenId;
	}

	/**
	 * @param screenId
	 *            the screenId to set
	 */
	public void setScreenId(String screenId) {
		this.screenId = screenId;
	}

	/**
	 * @return the screenName
	 */
	public String getScreenName() {
		return screenName;
	}

	/**
	 * @param screenName
	 *            the screenName to set
	 */
	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	/**
	 * @return the screenDescription
	 */
	public String getScreenDescription() {
		return screenDescription;
	}

	/**
	 * @param screenDescription
	 *            the screenDescription to set
	 */
	public void setScreenDescription(String screenDescription) {
		this.screenDescription = screenDescription;
	}

}
