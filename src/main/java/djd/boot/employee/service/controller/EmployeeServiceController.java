package djd.boot.employee.service.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import djd.boot.employee.service.configuration.EmployeeServiceConfigProperties;
import djd.boot.employee.service.models.Employee;

@RestController
public class EmployeeServiceController {
	
	@Autowired
	private EmployeeServiceConfigProperties config;
	
	@GetMapping("employees")
	public List<Employee> getEmployees() {
		List<Employee> empList = new ArrayList<Employee>();	
		
		Employee emp1 = new Employee("1001", "John Deer", "Developer", "AppsDev" + config.getLegalEmployer());
		Employee emp2 = new Employee("1002", "Drake Paul", "Administrator", "Facility" + config.getLegalEntity());
		Employee emp3 = new Employee("1003", "John Deer", "Security Specialist", "Security");
		Employee emp4 = new Employee("1004", "Riley Fox", "Senior Developer", "AppsDev");
		
		empList.add(emp1);
		empList.add(emp2);
		empList.add(emp3);
		empList.add(emp4);
		
		return empList;
	}

	public EmployeeServiceConfigProperties getConfig() {
		return config;
	}

	public void setConfig(EmployeeServiceConfigProperties config) {
		this.config = config;
	}
}
