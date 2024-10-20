package planmytrip.user.service.entities;

import java.util.Objects;

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

	
	@Column(name="HOUSE_ADDRES",nullable = false,  length = 200)
	// House no., AppartmentName / Building Name
	private String houseAddr;
	
	@Column(name="STREET_NAME",nullable = false,  length = 50)
	private String streetName;

	@Column(name="LANDMARK",  length = 200)
	private String landMark;

	@Column(name="CITY", nullable = false, length = 50)
	private String city;

	@Column(name="PINCODE", nullable = false, length = 20)
	private Integer pincode;

	@Column(name="STATE", nullable = false, length = 50)
	private String state;

	@Column(name="COUNTRY", nullable = false, length = 50)
	private String country;
	
	@ManyToOne(cascade = CascadeType.ALL, targetEntity = Customer.class)
	@JoinColumn(name = "CUSTOMER_ID", referencedColumnName ="ID", foreignKey = @ForeignKey(name="fk_ADDR_CUSTMR_ID"), nullable = false )
	private Customer customer;
	
// Address will be like below : 
// houseNo + streetName + Landmark + city name + state name + pincode + country name
		
	
	public Address() {
		super();
	}

	
	
	public String getHouseAddr() {
		return houseAddr;
	}

	public void setHouseAddr(String houseAddr) {
		this.houseAddr = houseAddr;
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

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	@Override
	public int hashCode() {
		return Objects.hash(city, customer, houseAddr, landMark, streetName);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		return Objects.equals(city, other.city) && Objects.equals(customer, other.customer)
				&& Objects.equals(houseAddr, other.houseAddr) && Objects.equals(landMark, other.landMark)
				&& Objects.equals(streetName, other.streetName);
	}



	@Override
	public String toString() {
		return "Address [houseAddr=" + houseAddr + ", streetName=" + streetName + ", landMark=" + landMark + ", city="
				+ city + ", pincode=" + pincode + ", customer=" + customer + "]";
	}

	
}
