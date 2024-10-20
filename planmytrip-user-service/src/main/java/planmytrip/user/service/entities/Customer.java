package planmytrip.user.service.entities;

import java.util.List;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@jakarta.persistence.Entity
@Table(name="CUSTOMER")
public class Customer extends AbstractEntityClass{
	
	@Column(name="USR_NAME", unique = true, nullable = false, updatable = false, length = 50)
	private String userName;
	
	@Column(name="FRST_NAME", nullable = false, length = 255)
	private String firstName;
	
	@Column(name="LST_NAME", length = 255)
	private String lastName;
	
	@Column(name="GENDER", length = 1, nullable = false)
	// Male : M, Female : F
	private char gender;
	
	@Column(name="EMAIL_ID", unique = true, length = 50)
	private String email;
	
	@Column(name="PHONE_NO", unique = true,  length = 20)
	private String phoneNo;
	
	@Column(name="PSSWRD", nullable = false, length = 255)
	private String password;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy = "customer")
	private List<Address> address;
	
	@OneToMany(mappedBy="customer", fetch=FetchType.LAZY)
	private Set<CardDetails> cardDetails;
	
	
	//Customer
	@ManyToOne(cascade = CascadeType.ALL, targetEntity = RoleMaster.class)
	@JoinColumn(name = "ROLE_ID", referencedColumnName = "ID", foreignKey = @ForeignKey(name="fk_CUSTMER_ROLE_ID"))
	private RoleMaster role;
	
	@ManyToOne(cascade = CascadeType.ALL, targetEntity = StatusMaster.class)
	@JoinColumn(name = "STATUS_ID", referencedColumnName = "ID", foreignKey = @ForeignKey(name="fk_CUSTMER_STATUS_ID"))
	private StatusMaster status;

	@Column(name="VERIFIED", nullable = false)
	private Boolean verified;
	

	public Customer() {
		super();
		this.verified = false;
	}



	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

	public Set<CardDetails> getCardDetails() {
		return cardDetails;
	}

	public void setCardDetails(Set<CardDetails> cardDetails) {
		this.cardDetails = cardDetails;
	}

	public RoleMaster getRole() {
		return role;
	}

	public void setRole(RoleMaster role) {
		this.role = role;
	}

	public StatusMaster getStatus() {
		return status;
	}

	public void setStatus(StatusMaster status) {
		this.status = status;
	}


	public Boolean getVerified() {
		return verified;
	}


	public void setVerified(Boolean verified) {
		this.verified = verified;
	}



	@Override
	public int hashCode() {
		return Objects.hash(userName);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return Objects.equals(userName, other.userName);
	}



	@Override
	public String toString() {
		return "Customer [userName=" + userName + ", firstName=" + firstName + ", lastName=" + lastName + ", role="
				+ role + ", status=" + status + ", verified=" + verified + "]";
	}
	
	
	
	
}
