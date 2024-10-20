package planmytrip.user.service.entities;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@jakarta.persistence.Entity
@Table(name="STATUS_MASTER")
public class StatusMaster extends AbstractEntityClass{
	
	
	
	@Column(name="STATUS_NAME", nullable = false, unique = true, length = 50)	
	private String statusName;
	
	/*
	 * STATUS:  1 = ACTIVE     // CUSTOMER | ROLE | EMP  (Default)
	 * STATUS: 2 = INACTIVE	   // ROLE	
	 * STATUS:  3 = BLOCKED   	// EMP | CUSTOMER
	 * STATUS:  5 =DEACTIVATE		// EMP - CUSTOMER
	 * STATUS:  5 =DORMANT		// EMP
	 * 
	 * **/
	
	@Column(name="CREATED_BY_USR", nullable = false)
	private String createdByUser;
	
	@Column(name="CREATED_DATE", nullable = false)
	private LocalDateTime createdDate;
	
	@Column(name="UPDATED_BY_USR")
	private String updatedByUser;

	@Column(name="UPDATED_DATE")
	private LocalDateTime updatedDate;

	@OneToMany(fetch = FetchType.LAZY,mappedBy = "status")
	private List<Employee> employees;
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "status")
	private List<RoleMaster> roles;
	
	
	public StatusMaster() {
		super();
	}

	

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
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



	public List<RoleMaster> getRoles() {
		return roles;
	}



	public void setRoles(List<RoleMaster> roles) {
		this.roles = roles;
	}



	@Override
	public int hashCode() {
		return Objects.hash(statusName);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StatusMaster other = (StatusMaster) obj;
		return Objects.equals(statusName, other.statusName);
	}



	@Override
	public String toString() {
		return "StatusMaster [statusName=" + statusName + "]";
	}
	
	
	
	
	
}
