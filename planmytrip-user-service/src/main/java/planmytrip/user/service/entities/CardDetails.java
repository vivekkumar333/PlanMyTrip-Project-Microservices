package planmytrip.user.service.entities;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name="CRD_DETLS_TBL")
public class CardDetails extends AbstractEntityClass{
	
	@Column(name="CRD_NAME", nullable = false, updatable = false, length = 200)
	private String cardName;

	@Column(name="CRD_HOLDR_NAME", nullable = false, updatable = false, length = 255)
	private String cardHolderName;

	@Column(name="CRD_NUMBR", nullable = false, updatable = false, length = 16)
	private Long cardNumber;

	@Column(name="CRD_EXPIRY_DATE", nullable = false, updatable = false, length = 5)
	private String cardExpiryDate;

	@Column(name="SECURTY_CODE", nullable = false, updatable = false, length = 3)
	private String securityCode;
	
	@ManyToOne(cascade = CascadeType.ALL, targetEntity = User.class)
	@JoinColumn(name = "USR_NAME", referencedColumnName ="USR_NAME", foreignKey = @ForeignKey(name="fk_CRD_USR_NAME"), nullable = false)
	private User user;

	public String getCardName() {
		return cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	public String getCardHolderName() {
		return cardHolderName;
	}

	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}

	public Long getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(Long cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getCardExpiryDate() {
		return cardExpiryDate;
	}

	public void setCardExpiryDate(String cardExpiryDate) {
		this.cardExpiryDate = cardExpiryDate;
	}

	public String getSecurityCode() {
		return securityCode;
	}

	public void setSecurityCode(String securityCode) {
		this.securityCode = securityCode;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cardExpiryDate == null) ? 0 : cardExpiryDate.hashCode());
		result = prime * result + ((cardHolderName == null) ? 0 : cardHolderName.hashCode());
		result = prime * result + ((cardName == null) ? 0 : cardName.hashCode());
		result = prime * result + ((cardNumber == null) ? 0 : cardNumber.hashCode());
		result = prime * result + ((securityCode == null) ? 0 : securityCode.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CardDetails other = (CardDetails) obj;
		if (cardExpiryDate == null) {
			if (other.cardExpiryDate != null)
				return false;
		} else if (!cardExpiryDate.equals(other.cardExpiryDate))
			return false;
		if (cardHolderName == null) {
			if (other.cardHolderName != null)
				return false;
		} else if (!cardHolderName.equals(other.cardHolderName))
			return false;
		if (cardName == null) {
			if (other.cardName != null)
				return false;
		} else if (!cardName.equals(other.cardName))
			return false;
		if (cardNumber == null) {
			if (other.cardNumber != null)
				return false;
		} else if (!cardNumber.equals(other.cardNumber))
			return false;
		if (securityCode == null) {
			if (other.securityCode != null)
				return false;
		} else if (!securityCode.equals(other.securityCode))
			return false;
		return true;
	}

	
	
	
}
