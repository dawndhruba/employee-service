package djd.boot.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import djd.boot.employee.service.exceptions.EmployeeServiceException;
import djd.boot.employee.service.models.Employee;
import djd.boot.employee.service.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository repository;

	@Override
	public Employee addEmployee(Employee employee) {
		return repository.save(employee);
	}

	@Override
	public Employee getEmployee(long employeeId) {
		Employee employee = repository.findById(employeeId).get();
		
		if(employee == null) {
			throw new EmployeeServiceException("Could not find an employee with ID");
		}
		
		return employee;
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		return repository.save(employee);
	}

	@Override
	public void deleteEmployee(long employeeId) {
		repository.deleteById(employeeId);;
	}

	@Override
	public List<Employee> getAllEmployees() {
		return repository.findAll();
	}

}
