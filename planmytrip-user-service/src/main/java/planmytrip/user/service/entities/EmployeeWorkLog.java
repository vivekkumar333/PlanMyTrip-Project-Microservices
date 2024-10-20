package planmytrip.user.service.entities;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Set;

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
@Table(name="EMP_WORK_LOG_TAB")
public class EmployeeWorkLog extends AbstractEntityClass{
	
	@Column(name="EMP_NAME", nullable = false, length = 255)
	private String firstName;
	
	@Column(name="LST_NAME", length = 255)
	private String lastName;
	
	@ManyToOne(cascade = CascadeType.ALL, targetEntity = GenderMaster.class)
	@JoinColumn(name = "GENDER_ID", foreignKey = @ForeignKey(name="fk_EMP_GENDER_ID"), referencedColumnName = "ID", nullable = false)
	private Long gender;
	
	@Column(name="EMAIL_ID", unique = true, nullable = false, length = 255)
	private String email;
	
	@Column(name="PHONE_NO", unique = true,  length = 50)
	private String phoneNo;
	
	@Column(name="PSSWRD", nullable = false, length = 255)
	private String password;

	@ManyToOne(cascade = CascadeType.ALL, targetEntity = RoleMaster.class)
	@JoinColumn(name = "ROLE_ID", referencedColumnName = "ID", foreignKey = @ForeignKey(name="fk_EMP_ROLE_ID"))
	private RoleMaster role;
	
	@ManyToOne(cascade = CascadeType.ALL, targetEntity = StatusMaster.class)
	@JoinColumn(name = "STATUS_ID", referencedColumnName = "ID", foreignKey = @ForeignKey(name="fk_EMP_STATUS_ID"))
	private StatusMaster status;

	@ManyToOne(cascade = CascadeType.ALL, targetEntity = EmployeeGradeMaster.class)
	@JoinColumn(name = "GRADE_ID", referencedColumnName = "ID", foreignKey = @ForeignKey(name="fk_EMP_GRADE_ID"))
	private EmployeeGradeMaster grade;
	
	
	@ManyToOne(cascade = CascadeType.ALL, targetEntity = JobProfileMaster.class)
	@JoinColumn(name = "JOB_PROFILE_ID", referencedColumnName = "ID", foreignKey = @ForeignKey(name="fk_EMP_JPROFILE_ID"))
	private JobProfileMaster jobProfile;
	
	@Column(name="STATE", nullable = false, length = 50)
	private String state;
	
	@Column(name="REMARKS", length = 1000)
	private String remarks;
	
	
	@Column(name="CREATED_BY_MAKER", nullable = false)
	private String createdByMaker;
	
	@Column(name="CREATED_MAKER_DATE", nullable = false)
	private LocalDateTime createdMakerDate;
	
	@Column(name="APPROVED_BY_CHECKER", nullable = false)
	private String approvedByChecker;
	
	@Column(name="APPROVED_CHECKER_DATE", nullable = false)
	private LocalDateTime approvedCheckerDate;
	
	
	public EmployeeWorkLog() {
		super();
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

	public Long getGender() {
		return gender;
	}

	public void setGender(Long gender) {
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

	public EmployeeGradeMaster getGrade() {
		return grade;
	}

	public void setGrade(EmployeeGradeMaster grade) {
		this.grade = grade;
	}

	public JobProfileMaster getJobProfile() {
		return jobProfile;
	}

	public void setJobProfile(JobProfileMaster jobProfile) {
		this.jobProfile = jobProfile;
	}

	
	
}
