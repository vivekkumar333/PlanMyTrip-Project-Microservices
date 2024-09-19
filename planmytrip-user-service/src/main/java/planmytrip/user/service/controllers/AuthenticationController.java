package planmytrip.user.service.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assessment.jwt.config.JwtTokenProvider;
import com.assessment.jwt.config.CustomeUserDetailsService;
import com.assessment.request.AuthenticationRequest;
import com.assessment.response.AuthenticationResponse;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthenticationController {

	@PostMapping("/login")
	public ResponseEntity<?> authenticateUser(@RequestBody planmytrip.user.service.requests.AuthenticationRequest authReq){
		try {
			// Authenticate the user
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authReq.getUserName(), authReq.getPassword()));
		
			 // Generate JWT token
			UserDetails userDetails = customerUserDetails.loadUserByUsername(authReq.getUserName());
			String token = jwtTokenProvider.generateToken(userDetails);
			
			return ResponseEntity.ok(new AuthenticationResponse(token));
		}catch(AuthenticationException ex) {
			ex.printStackTrace();
			System.out.println("AuthenticationController -- User Authentication has been failed!");
			throw ex;
	//		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Authentication failed! Invalid username or Password");
		}
		
		
		
	}
	
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	planmytrip.user.service.configs.CustomeUserDetailsService customerUserDetails;
	
	@Autowired
	JwtTokenProvider jwtTokenProvider;
}
