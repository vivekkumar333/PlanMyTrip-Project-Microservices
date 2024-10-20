package planmytrip.user.service.entities;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "GENDER_MASTER")
public class GenderMaster extends AbstractEntityClass{
	
	@Column(name = "GENDER", unique = true, nullable = false, length = 20, updatable = false)
	// Male : M, Female : F
	private String gender;
	
	@Column(name="CREATED_BY_USR", nullable = false)
	private String createdByUser;
	
	@Column(name="CREATED_DATE", nullable = false)
	private LocalDateTime createdDate;
	
	@Column(name="UPDATED_BY_USR")
	private String updatedByUser;

	@Column(name="UPDATED_DATE")
	private LocalDateTime updatedDate;
	
	
	@OneToMany(mappedBy = "gender" , fetch = FetchType.LAZY)
	private List<Employee> employees;

	
	public GenderMaster() {
		super();
	}

	
	

	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getCreatedByUser() {
		return createdByUser;
	}


	public void setCreatedByUser(String createdByUser) {
		this.createdByUser = createdByUser;
	}


	public LocalDateTime getCreatedDate() {
		return createdDate;
	}


	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}


	public String getUpdatedByUser() {
		return updatedByUser;
	}


	public void setUpdatedByUser(String updatedByUser) {
		this.updatedByUser = updatedByUser;
	}


	public LocalDateTime getUpdatedDate() {
		return updatedDate;
	}


	public void setUpdatedDate(LocalDateTime updatedDate) {
		this.updatedDate = updatedDate;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}




	@Override
	public int hashCode() {
		return Objects.hash(gender);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GenderMaster other = (GenderMaster) obj;
		return Objects.equals(gender, other.gender);
	}




	@Override
	public String toString() {
		return "GenderMaster [gender=" + gender + "]";
	}

	
	
	
}
