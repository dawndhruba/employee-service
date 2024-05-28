package djd.boot.employee.service.models;

public class Employee {
    private String employeeId;
    private String name;
    private String role;
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
}
