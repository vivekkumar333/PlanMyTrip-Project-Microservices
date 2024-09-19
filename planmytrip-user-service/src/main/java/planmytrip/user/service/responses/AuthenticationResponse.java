package planmytrip.user.service.responses;

import com.assessment.entity.Role;

public class AuthenticationResponse {
	private String accessToken;
	
	

	public AuthenticationResponse() {
		super();
	}

	

	public AuthenticationResponse(String accessToken) {
		super();
		this.accessToken = accessToken;
	}



	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}


}
