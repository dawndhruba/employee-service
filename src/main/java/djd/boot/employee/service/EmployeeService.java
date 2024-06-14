package djd.boot.employee.service;

import java.util.List;

import djd.boot.employee.service.models.Employee;

public interface EmployeeService {
	Employee addEmployee(Employee employee);
	Employee getEmployee(long employeeId);
	Employee updateEmployee(Employee employee);
	void deleteEmployee(long employeeId);
	List<Employee> getAllEmployees();
}
