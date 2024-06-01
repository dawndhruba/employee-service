package djd.boot.employee.service.models;

import java.util.Objects;

import jakarta.validation.constraints.NotBlank;

public class Employee {
	@NotBlank(message = "EmployeeId cannot be blank.")
    private String employeeId;

	@NotBlank(message = "Name cannot be blank.")
    private String name;
	
	@NotBlank(message = "Role cannot be blank.")
    private String role;
	
	@NotBlank(message = "Department cannot be blank.")
    private String department;
    
	public Employee(String employeeId, String name, String role, String department) {
		super();
		this.employeeId = employeeId;
		this.name = name;
		this.role = role;
		this.department = department;
	}
	
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
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
}
