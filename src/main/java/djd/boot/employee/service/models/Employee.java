package djd.boot.employee.service.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;

@Entity
//@JsonFilter("mobileFilter")
public class Employee {
	@JsonProperty("id")
	@Id
	@Column(name = "id")
	@GeneratedValue
    private long employeeId;

	@NotBlank(message = "Name cannot be blank.")
    private String name;
	
	@NotBlank(message = "Role cannot be blank.")
    private String role;
	
	@NotBlank(message = "Department cannot be blank.")
    private String department;
	
	@NotBlank
	@Column(name = "mobile_no")
	private String mobileNo;
	
	@OneToMany(mappedBy = "employee")
	@JsonIgnore
	private List<Address> addesses;
	
	public Employee(String name, String role, String department, String mobileNo) {
		super();
		this.name = name;
		this.role = role;
		this.department = department;
		this.mobileNo = mobileNo;
	}
	
	public Employee() {
		
	}
	
	public long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(employeeId, other.employeeId);
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public List<Address> getAddesses() {
		return addesses;
	}

	public void setAddesses(List<Address> addesses) {
		this.addesses = addesses;
	}
	
	public void addAddress(Address address) {
		if(this.getAddesses() == null) {
			this.setAddesses(new ArrayList<Address>());
		}
		
		this.getAddesses().add(address);
	}
}
