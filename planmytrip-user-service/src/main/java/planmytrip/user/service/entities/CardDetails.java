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
	
	@ManyToOne(cascade = CascadeType.ALL, targetEntity = Customer.class)
	@JoinColumn(name = "CUSTOMER_ID", referencedColumnName ="ID", foreignKey = @ForeignKey(name="fk_CRD_CUSTMER_ID"), nullable = false)
	private Customer customer;

	
	public CardDetails() {
		super();
	}

	
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

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

	@Override
	public int hashCode() {
		return Objects.hash(cardName, cardNumber);
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
		return Objects.equals(cardName, other.cardName) && Objects.equals(cardNumber, other.cardNumber);
	}

	
}
