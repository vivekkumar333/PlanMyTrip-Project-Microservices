package planmytrip.user.service.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import planmytrip.user.service.entities.User;

public interface UserRepository extends JpaRepository<User, String> {

	Optional<User> findByUserName(String username);
	
//	Optional<User> findByEmail(String email);
//	
//	Optional<User> findByPhone(String phoneNo);

}
