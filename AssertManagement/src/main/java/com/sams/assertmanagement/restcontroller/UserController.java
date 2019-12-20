/**
 * 
 */
package com.sams.assertmanagement.restcontroller;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sams.assertmanagement.exceptions.ApplicationException;
import com.sams.assertmanagement.exceptions.BadRequestException;
import com.sams.assertmanagement.exceptions.NotFoundException;
import com.sams.assertmanagement.model.User;
import com.sams.assertmanagement.parameters.UserParameter;
import com.sams.assertmanagement.services.IUserService;

/**
 * @author SPSOFT
 *
 */
@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private IUserService userService;

	/**
	 * Create the user details
	 * 
	 * @param userParameter
	 * @throws Exception
	 */
	@PostMapping("/create")
	public String createUser(@RequestBody(required = true) UserParameter userParameter) throws Exception {
		validateParameters(userParameter);

		try {
			return userService.save(userParameter);
		} catch (Exception e) {
			throw new ApplicationException("Internal server issue", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * get all user details
	 * 
	 * @param userParameter
	 * @throws Exception
	 */
	@GetMapping
	public List<User> getAllUsers() throws Exception {
		try {

			return userService.loadAllUserDetails();

		} catch (Exception e) {
			throw new ApplicationException("Internal server issue", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * get the user details by id
	 * 
	 * @param userParameter
	 * @throws Exception
	 */
	@GetMapping("/{userId}")
	public User getUser(@NotNull @PathVariable("userId") String id) throws Exception {
		try {

			return userService.loadUserDetails(id);

		} catch (Exception e) {
			throw new ApplicationException("Internal server issue", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * get the user details by id
	 * 
	 * @param userParameter
	 * @throws Exception
	 */
	@PutMapping("/{userId}")
	public ResponseEntity<User> updateUser(@PathVariable(required = true) String userId,
			@RequestBody(required = true) UserParameter userParameter) throws Exception {
		validateParameters(userParameter);

		try {
			User user = new User(userParameter);
			user.setUserId(userId);
			User updatedUser = userService.update(user);
			return new ResponseEntity<User>(updatedUser, HttpStatus.OK);
		} catch (Exception e) {
			throw new ApplicationException("Internal server issue", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * get the all user details
	 * 
	 * @param userParameter
	 * @throws Exception
	 */
	@DeleteMapping("/{userId}")
	public ResponseEntity<String> deleteUser(@NotNull @PathVariable("userId") String id) throws Exception {
		try {
			User user = userService.loadUserDetails(id);
			if (user != null) {
				userService.delete(user);
				return new ResponseEntity<String>(HttpStatus.OK);
			} else {
				throw new NotFoundException("Given user id not exist in the system", HttpStatus.NOT_FOUND);
			}

		} catch (Exception e) {
			throw new ApplicationException("Internal server issue", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	private void validateParameters(UserParameter userParameter) {
		if (StringUtils.isBlank(userParameter.getFirstName())) {
			throw new BadRequestException("First name is mandatory.", HttpStatus.BAD_REQUEST);
		}
		if (StringUtils.isBlank(userParameter.getLastName())) {
			throw new BadRequestException("Last name is mandatory.", HttpStatus.BAD_REQUEST);
		}
		if (StringUtils.isBlank(userParameter.getPhoneNumber())) {
			throw new BadRequestException("Phone number is mandatory.", HttpStatus.BAD_REQUEST);
		}
		if (StringUtils.isBlank(userParameter.getEmailId())) {
			throw new BadRequestException("Email Id is mandatory.", HttpStatus.BAD_REQUEST);
		}
	}
}
