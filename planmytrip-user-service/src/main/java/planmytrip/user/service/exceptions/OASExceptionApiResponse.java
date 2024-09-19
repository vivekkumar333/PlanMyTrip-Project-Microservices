package planmytrip.user.service.exceptions;

import java.time.LocalDateTime;

public class OASExceptionApiResponse {
	private String message;
	private String error;
	private boolean response;
	private LocalDateTime currentTimeStamp;
	
	public OASExceptionApiResponse() {}
	
	public OASExceptionApiResponse(String message,String error, boolean response, LocalDateTime currentTimeStamp) {
		super();
		this.message = message;
		this.error = error;
		this.response = response;
		this.currentTimeStamp = currentTimeStamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isResponse() {
		return response;
	}

	public void setResponse(boolean response) {
		this.response = response;
	}

	public LocalDateTime getCurrentTimeStamp() {
		return currentTimeStamp;
	}

	public void setCurrentTimeStamp(LocalDateTime currentTimeStamp) {
		this.currentTimeStamp = currentTimeStamp;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
	
	
}
