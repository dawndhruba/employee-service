package djd.boot.employee.service.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import djd.boot.employee.service.exceptions.EmployeeServiceException;
import djd.boot.employee.service.models.Employee;

@Component
public class EmployeeServiceDAOImpl implements EmployeeServiceDAO {
	
	static {
		EMP_LIST.add(new Employee("1001", "Aron", "Manager", "AppsDev"));
		EMP_LIST.add(new Employee("1002", "Brad", "Developer", "AppsDev"));
		EMP_LIST.add(new Employee("1003", "Caroline", "Facility Manager", "Facility"));
		EMP_LIST.add(new Employee("1004", "David", "Security Specialist", "Security"));
		EMP_LIST.add(new Employee("1005", "Emil", "Talent Advisor", "HR"));
		EMP_LIST.add(new Employee("1006", "Flynn", "Senior Developer", "AppsDev"));
	}

	@Override
	public Employee getEmployeeById(String empId) {
		Optional<Employee> empOpt = EMP_LIST.stream().filter(emp -> empId.equals(emp.getEmployeeId())).findFirst();
		Employee emp = empOpt.orElse(null);
		
		if(emp == null) {
			throw new EmployeeServiceException("No employee exists with id:" + empId);
		}
		
		return emp;
	}

	@Override
	public List<Employee> getAllEmployees() {
		return EMP_LIST;
	}

	@Override
	public void deleteEmployee(String empId) {
		EMP_LIST.removeIf(emp -> empId.equals(emp.getEmployeeId()));
	}

	@Override
	public Employee addEmployee(Employee employee) {
		EMP_LIST.add(employee);
		return employee;
	}

}
