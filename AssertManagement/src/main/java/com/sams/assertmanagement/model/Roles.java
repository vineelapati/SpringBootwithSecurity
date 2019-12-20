/**
 * 
 */
package com.sams.assertmanagement.model;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;

/**
 * @author SPSOFT
 *
 */
@Document(collection="role")
public class Roles implements Serializable, GrantedAuthority
{

	private static final long serialVersionUID = 1L;
	
	@Id
	private String roleId;
	
	private String roleName;
	
	private String description;
	
	private List<Screens> screens ;

	/**
	 * @return the roleId
	 */
	public String getRoleId() {
		return roleId;
	}

	/**
	 * @param roleId the roleId to set
	 */
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	/**
	 * @return the roleName
	 */
	public String getRoleName() {
		return roleName;
	}

	/**
	 * @param roleName the roleName to set
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the screens
	 */
	public List<Screens> getScreens() {
		return screens;
	}

	/**
	 * @param screens the screens to set
	 */
	public void setScreens(List<Screens> screens) {
		this.screens = screens;
	}

	@Override
	public String getAuthority() {
		return roleName;
	}
	
}
