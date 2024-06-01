package djd.boot.employee.service.dao;

import java.util.ArrayList;
import java.util.List;

import djd.boot.employee.service.models.Employee;

public interface EmployeeServiceDAO {
	List<Employee> EMP_LIST = new ArrayList<Employee>();
	
	Employee getEmployeeById(String empId);
	List<Employee> getAllEmployees();
	void deleteEmployee(String empId);
	Employee addEmployee(Employee employee);
}
