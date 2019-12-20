/**
 * 
 */
package com.sams.assertmanagement.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sams.assertmanagement.exceptions.ApplicationException;
import com.sams.assertmanagement.parameters.LoginDetailParameter;
import com.sams.assertmanagement.services.ILoginDetailsService;

/**
 * @author SPSOFT
 *
 */
@RestController
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private ILoginDetailsService loginDetailsService;

	@PostMapping("signin")
	public String signIn(@RequestBody(required = true) LoginDetailParameter loginDetailParameter) throws Exception 
	{
		try {
			return loginDetailsService.loadLoginDetails(loginDetailParameter);

		} catch (Exception e) {
			throw new ApplicationException("Internal server issue", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
