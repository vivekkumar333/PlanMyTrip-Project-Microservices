package planmytrip.user.service.controllers;

import java.util.Set;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assessment.exception.OASInternalServerException;
import com.assessment.exception.OASResourcesConflictException;
import com.assessment.exception.ResourceNotFoundOASException;
import com.assessment.request.UserRequest;
import com.assessment.response.UserResponse;
import com.assessment.service.UserService;

@RequestMapping("/user")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

	@Autowired
	UserService userService;
	
	@PostMapping("/create")
	public ResponseEntity<UserResponse> saveUserRequest(@RequestBody UserRequest userReq) throws  OASResourcesConflictException,OASInternalServerException,ConstraintViolationException{
		try {
			return ResponseEntity.ok(userService.saveUserRequest(userReq));
		}catch(OASResourcesConflictException | OASInternalServerException|ConstraintViolationException ex ) {
			throw ex;
		}
	}
	
	@GetMapping("/getList")
	public Set<UserResponse> getAllUsers() throws OASInternalServerException{
		try {
			return userService.getAllUsers();
		}catch(OASInternalServerException ex) {
			
			throw ex;
		}
	}
	
	@GetMapping("/get/{id}")
	public UserResponse getUserById(@PathVariable("id") String userId) throws ResourceNotFoundOASException,OASInternalServerException{
		try {
			return userService.fetchUserById(userId);
		}catch(OASInternalServerException | ResourceNotFoundOASException ex) {
			throw ex;
		}catch(RuntimeException ex) {
			ex.printStackTrace();
			throw new OASInternalServerException("UserController - /user/{id} : Exception while fetching User based on Username") ;
		}
	}
	
}
