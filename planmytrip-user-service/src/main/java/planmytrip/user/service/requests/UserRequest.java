package planmytrip.user.service.requests;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;

public class UserRequest {
	
	@NotNull(message = "UserName field cannot be blank")
	private String userName;
	
	@NotNull(message = "User Passowrd field cannot be blank")
	private String password;
		
	@NotNull(message = "User FirstName field cannot be blank")
	private String firstName;
	
	@NotNull(message = "User MiddleName field cannot be blank")
	private String middleName;
	
	@NotNull(message = "User LastName field cannot be blank")
	private String lastName;
	
	
	@Email(message = "Please enter a valid email address, With Email id lenght-255 Char are allowed with one @ Symbol")	
	@NotNull(message = "Email field cannot be blank")
	private String email;
	
	private String countryCode;
	
	private String phone;
	
	private MultipartFile file;
	
	private LocalDate dob;
	
	@NotNull(message = "User Role_ID field cannot be blank")
	private Long roleId;

	
	public UserRequest() {
		super();
	}

	
	
	public MultipartFile getFile() {
		return file;
	}



	public void setFile(MultipartFile file) {
		this.file = file;
	}



	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}



	public String getMiddleName() {
		return middleName;
	}



	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}



	public String getCountryCode() {
		return countryCode;
	}



	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}



	public LocalDate getDob() {
		return dob;
	}



	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	
	

}
