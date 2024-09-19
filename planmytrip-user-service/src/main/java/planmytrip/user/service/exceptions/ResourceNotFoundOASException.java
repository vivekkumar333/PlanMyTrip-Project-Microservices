package planmytrip.user.service.exceptions;

public class ResourceNotFoundOASException extends RuntimeException {

	private String error; 
	private String message;
	
	public ResourceNotFoundOASException(String error, String message) {
		super(message);
		this.error=error;
		this.message=message;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
