package planmytrip.user.service.configs;

import java.util.Collections;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import planmytrip.user.service.constraints.UserServiceConstraints;
import planmytrip.user.service.entities.User;
import planmytrip.user.service.repositories.UserRepository;

@Service
public class CustomeUserDetailsService implements UserDetailsService{
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	UserServiceConstraints userServiceConstraints;

	@Override
	public UserDetails loadUserByUsername(String username) throws BadCredentialsException {

		Optional<User> user = userRepo.findByUserName(username);
		if(!user.isPresent()) {
			throw new BadCredentialsException("Oops, User Authentication has been failed!! Username: "+username+" is not found.");
//			throw new UsernameNotFoundException("Oops! User not found with the username: "+username);
		}else if(user.get().getStatus().getStatusName().equals(userServiceConstraints.STATUS_LOCKED)){
			throw new BadCredentialsException("Oops, User Authentication has been failed!! Username: "+username+" is locked.");
		}else if(user.get().getStatus().getStatusName().equals(userServiceConstraints.STATUS_BLOCKED)){
			throw new BadCredentialsException("Oops, User Authentication has been failed!! Username: "+username+" is blocked.");
		}else if(user.get().getStatus().getStatusName().equals(userServiceConstraints.STATUS_REVOKED)){
			throw new BadCredentialsException("Oops, User Authentication has been failed!! Username: "+username+" is revoked.");
		}else if(user.get().getStatus().getStatusName().equals(userServiceConstraints.STATUS_DORMANT)){
			throw new BadCredentialsException("Oops, User Authentication has been failed!! Username: "+username+" is dormant.");
		}
		
		return new org.springframework.security.core.userdetails.User(user.get().getUserName(),user.get().getPassword(), true, true, true, true, Collections.singletonList(new SimpleGrantedAuthority("ROLE_"+user.get().getRole().getRoleName())));
	}

}
