package planmytrip.user.service.exceptions;


public class OASExpiredJwtException extends RuntimeException {

	public OASExpiredJwtException(String string) {
		super(string);
	}

}
