package planmytrip.user.service.entities;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import ch.qos.logback.core.status.Status;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@jakarta.persistence.Entity
@Table(name="ROLE_MASTER")
public class RoleMaster{
	
	@Id
	@Column(name="ROLE_ID", unique = true, nullable = false, updatable = false, length = 5)
	private Long roleId;
	
	@Column(name="ROLE_NAME", unique = true, nullable = false, updatable = false, length = 255)
	private String roleName;
	
	@Column(name="CREATED_BY_USR", nullable = false)
	private String createdByUser;
	
	@Column(name="CREATED_DATE", nullable = false)
	private LocalDateTime createdDate;
	
	@Column(name="UPDATED_BY_USR")
	private String updatedByUser;

	@Column(name="UPDATED_DATE")
	private LocalDateTime updatedDate;
	
// 	ACTIVE / INACTIVE
	@ManyToOne(cascade = CascadeType.ALL, targetEntity = StatusMaster.class)
	@JoinColumn(name = "STATUS", referencedColumnName = "ID", foreignKey = @ForeignKey(name="fk_STATUS_ID"))
	private StatusMaster status;


	public Long getRoleId() {
		return roleId;
	}


	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}


	public String getRoleName() {
		return roleName;
	}


	public void setRoleName(String roleName) {
		this.roleName = roleName;
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


	public StatusMaster getStatus() {
		return status;
	}


	public void setStatus(StatusMaster status) {
		this.status = status;
	}


	
	
	
	/*
	 * Role_ID:	1 	= 	ADMIN
	 * Role_ID 	2 	= 	Maker
	 * ROLE_ID 	3 	=	Checker
	 * Role_ID:	4 	= 	EMPLOYEE
	 * Role_ID: 5 	= 	Manager
	 * Role_ID: 6 	= 	Customer
	 * 
	 * **/
}
