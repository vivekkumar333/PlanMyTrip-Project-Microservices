package planmytrip.user.service.exceptions;

import java.time.LocalDateTime;

import javax.validation.ConstraintViolationException;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException.BadRequest;
import org.springframework.web.client.HttpServerErrorException.InternalServerError;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.fasterxml.jackson.annotation.JacksonInject.Value;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

@RestControllerAdvice
public class OnlineAssessmentServiceExceptionInterceptor {

	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(InternalServerError.class)
	public final ResponseEntity<OASExceptionApiResponse> handelInternalServerError(InternalServerError ex) {
		return new ResponseEntity<OASExceptionApiResponse>(
				new OASExceptionApiResponse(ex.getMessage(),"Internal server error", true, LocalDateTime.now()),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(OASConstraintViolationException.class)
	public final ResponseEntity<OASExceptionApiResponse> handelConstantVoilationException(OASConstraintViolationException ex) {
		return new ResponseEntity<OASExceptionApiResponse>(
				new OASExceptionApiResponse(ex.getMessage(),ex.getError(), true, LocalDateTime.now()), HttpStatus.BAD_REQUEST);
	}

	@ResponseStatus(value = HttpStatus.CONFLICT)
	@ExceptionHandler(OASResourcesConflictException.class)
	public final ResponseEntity<OASExceptionApiResponse> handelResourceConflicException(OASResourcesConflictException ex) {
		return new ResponseEntity<OASExceptionApiResponse>(
				new OASExceptionApiResponse(ex.getMessage(),"Resource conflict in Database" ,true, LocalDateTime.now()), HttpStatus.CONFLICT);
	}

	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ExceptionHandler(ResourceNotFoundOASException.class)
	public final ResponseEntity<OASExceptionApiResponse> handelResourceNotFoundException(ResourceNotFoundOASException ex) {
		return new ResponseEntity<OASExceptionApiResponse>(
				new OASExceptionApiResponse(ex.getMessage(),ex.getError(), true, LocalDateTime.now()), HttpStatus.BAD_REQUEST);
	}
	
	
	
	@ResponseStatus(value = HttpStatus.UNAUTHORIZED)
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<OASExceptionApiResponse> handelAuthenticationException(Exception ex) {
		ResponseEntity<OASExceptionApiResponse> exResp = null;

		if (ex instanceof InternalAuthenticationServiceException) {
			exResp = new ResponseEntity<OASExceptionApiResponse>(
					new OASExceptionApiResponse(ex.getMessage(),"Bad Credentials", true, LocalDateTime.now()), HttpStatus.UNAUTHORIZED);
		}
		
		if (ex instanceof BadCredentialsException) {
			exResp = new ResponseEntity<OASExceptionApiResponse>(
					new OASExceptionApiResponse("Oops, User Authentication has been failed!! Incorrect Password","Bad Credentials", true, LocalDateTime.now()), HttpStatus.UNAUTHORIZED);
		}

		if (ex instanceof OASExpiredJwtException) {
			exResp = new ResponseEntity<OASExceptionApiResponse>(
					new OASExceptionApiResponse(ex.getMessage(),"jwt-Token Expired", true, LocalDateTime.now()), HttpStatus.UNAUTHORIZED);
		}

		if (ex instanceof SignatureException) {
			exResp = new ResponseEntity<OASExceptionApiResponse>(
					new OASExceptionApiResponse(ex.getMessage(),"Bad jwt-token Signature", true, LocalDateTime.now()), HttpStatus.UNAUTHORIZED);
		}

		if (ex instanceof MalformedJwtException) {
			exResp = new ResponseEntity<OASExceptionApiResponse>(
					new OASExceptionApiResponse(ex.getMessage(),null, true, LocalDateTime.now()), HttpStatus.UNAUTHORIZED);
		}

		if (ex instanceof UnsupportedJwtException) {
			exResp = new ResponseEntity<OASExceptionApiResponse>(
					new OASExceptionApiResponse(ex.getMessage(),null, true, LocalDateTime.now()), HttpStatus.UNAUTHORIZED);
		}

		if (ex instanceof IllegalArgumentException) {
			exResp = new ResponseEntity<OASExceptionApiResponse>(
					new OASExceptionApiResponse(ex.getMessage(),null, true, LocalDateTime.now()), HttpStatus.UNAUTHORIZED);
		}

		if (ex instanceof DisabledException) {
			exResp = new ResponseEntity<OASExceptionApiResponse>(
					new OASExceptionApiResponse(ex.getMessage(),"User is Disabled" ,true, LocalDateTime.now()), HttpStatus.UNAUTHORIZED);
		}

		return exResp;
	}

}
