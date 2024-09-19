package planmytrip.user.service.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="ADDRESS_TBL")
public class Address extends AbstractEntityClass{

	
	@Column(name="HOUSE_NO",nullable = false,  length = 200)
	// House no., AppartmentName / Building Name
	private String houseNo;
	
	@Column(name="STREET_NAME",nullable = false,  length = 200)
	private String streetName;

	@Column(name="LANDMARK",  length = 200)
	private String landMark;
	
	@Column(name="EMAIL_ID", length = 255)
	private String email;
	
	@Column(name="PHONE_NO",  length = 100)
	private String phoneNo;

	@Column(name="CITY", nullable = false, length = 200)
	private String city;

	@Column(name="PINCODE", nullable = false, length = 20)
	private Integer pincode;

	@Column(name="STATE", nullable = false, length = 200)
	private String state;

	@Column(name="COUNTRY", nullable = false, length = 200)
	private String country;
	
	@ManyToOne(cascade = CascadeType.ALL, targetEntity = User.class)
	@JoinColumn(name = "USR_NAME", referencedColumnName ="USR_NAME", foreignKey = @ForeignKey(name="fk_ADDRESS_USR_NAME"), nullable = false )
	private User user;
	
	// Address will be like below : 
	// houseNo + streetName + Landmark + city name + state name + pincode + country name
	
	
	
	public String getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getLandMark() {
		return landMark;
	}

	public void setLandMark(String landMark) {
		this.landMark = landMark;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Integer getPincode() {
		return pincode;
	}

	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	

	@Override
	public String toString() {
		return "Address [houseNo=" + houseNo + ", streetName=" + streetName + ", landMark=" + landMark + ", city="
				+ city + ", pincode=" + pincode + ", state=" + state + ", country=" + country + ",user=" + user + "]";
	}
}
