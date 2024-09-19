package planmytrip.user.service.entities;

import java.util.List;

import org.antlr.v4.runtime.misc.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


// ToDO::	Reservation and Guest Table should suppose to maintain at Reservation Microservices End. 
//@Entity
//@Table(name="GUEST_TBL")
public class Guest extends AbstractEntityClass{

	@Column(name="NAME", nullable = false, length = 500)
	private String Name;
	
	@Column(name="GENDER", length = 1, nullable = false)
	// Male : M, Female : F
	private char gender;

// ToDo:: Will be uncommented during Reservation Micorservice development
	
//	@ManyToOne(cascade=CascadeType.ALL, targetEntity = Address.class)
//	@JoinColumn(name="fk_ADDR_ID", referencedColumnName = "ID", foreignKey = @ForeignKey(name="fk_ADDR_ID"))
//	private Address address;
//	
//	@Column(name="RESERVATION_ID", length = 255, nullable = false)
//	private String reservationId;

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

//	public Address getAddress() {
//		return address;
//	}
//
//	public void setAddress(Address address) {
//		this.address = address;
//	}
//
//	public String getReservationId() {
//		return reservationId;
//	}
//
//	public void setReservationId(String reservationId) {
//		this.reservationId = reservationId;
//	}

	
}
