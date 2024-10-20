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
@Table(name = "EMP_GRDE_MASTR")
public class EmployeeGradeMaster extends AbstractEntityClass{
	
	@Column(name="GRADE", nullable = false, unique = true, length = 50)	
	private String grade;
	
	@Column(name="GRADE_DISCRIPTION", nullable = false, unique = true, length = 255)	
	private String gradeDiscription;
	
	
	@Column(name="CREATED_BY_USR", nullable = false)
	private String createdByUser;
	
	@Column(name="CREATED_DATE", nullable = false)
	private LocalDateTime createdDate;
	
	@Column(name="UPDATED_BY_USR")
	private String updatedByUser;

	@Column(name="UPDATED_DATE")
	private LocalDateTime updatedDate;
	
	
	@OneToMany(mappedBy = "grade", fetch = FetchType.LAZY)
	private List<Employee> employees;


	public EmployeeGradeMaster() {
		super();
	}


	public String getGrade() {
		return grade;
	}


	public void setGrade(String grade) {
		this.grade = grade;
	}


	public String getGradeDiscription() {
		return gradeDiscription;
	}


	public void setGradeDiscription(String gradeDiscription) {
		this.gradeDiscription = gradeDiscription;
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
		return Objects.hash(grade);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeeGradeMaster other = (EmployeeGradeMaster) obj;
		return Objects.equals(grade, other.grade);
	}


	@Override
	public String toString() {
		return "EmployeeGradeMaster [grade=" + grade + ", gradeDiscription=" + gradeDiscription + "]";
	}
	
	
	
}
