package planmytrip.user.service.constraints;

import org.springframework.stereotype.Component;

@Component
public class UserServiceConstraints {

// User Status Constraints
	public static final String STATUS_ACTIVE = "ACTIVE";
	public static final String STATUS_INACTIVE = "INACTIVE";
	public static final String STATUS_BLOCKED = "BLOCKED";
	public static final String STATUS_REVOKED = "REVOKED";
	public static final String STATUS_LOCKED = "LOCKED";
	public static final String STATUS_DORMANT = "DORMANT";

// User Status Constraints
	public static final String ROLE_SYSTEM = "SYSTEM";
	public static final String ROLE_ADMIN = "ADMIN";
	public static final String ROLE_EMPLOYEE = "EMPLOYEE";
	public static final String ROLE_USER = "USER";
	public static final String ROLE_STAFF = "STAFF";
}
