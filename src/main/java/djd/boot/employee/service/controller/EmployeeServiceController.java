package djd.boot.employee.service.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import djd.boot.employee.service.configuration.EmployeeServiceConfigProperties;
import djd.boot.employee.service.dao.EmployeeServiceDAO;
import djd.boot.employee.service.exceptions.EmployeeServiceException;
import djd.boot.employee.service.exceptions.ErrorDetails;
import djd.boot.employee.service.exceptions.MessageDetail;
import djd.boot.employee.service.models.Employee;
import jakarta.validation.Valid;

@RestController
public class EmployeeServiceController {
	
	private EmployeeServiceConfigProperties config;
	private EmployeeServiceDAO empDao;
	
	@Autowired
	public EmployeeServiceController(EmployeeServiceConfigProperties config, EmployeeServiceDAO empDao) {
		this.config = config;
		this.empDao = empDao;
	}
	
	@GetMapping("employees/configs")
	public List<String> getConfigs() {
		List<String> configs = new ArrayList<String>();
		configs.add(config.getLegalEmployer());
		configs.add(config.getLegalEntity());
		
		return configs;
	}

	@GetMapping("employees")
	public List<Employee> getEmployees() {
		return empDao.getAllEmployees();
	}
	
	@GetMapping(path = "/employees/{id}")
	public Employee getEmployeeById(@PathVariable String id) {
		return empDao.getEmployeeById(id);
	}
	
	@PostMapping(path = "/employees")
	public ResponseEntity<Employee> addEmployee(@Valid @RequestBody Employee employee) {
		Employee addedEmp = empDao.addEmployee(employee);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(addedEmp.getEmployeeId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping(path = "/employees/{id}")
	public ResponseEntity<Object> deleteEmployee(@PathVariable String id) {
		empDao.deleteEmployee(id);
		return ResponseEntity.noContent().build();
	}
	
	@ExceptionHandler(value = EmployeeServiceException.class)
	public final ResponseEntity<ErrorDetails> handleEmployeeServiceException(Exception ex, WebRequest request) {
		ErrorDetails excDetails = new ErrorDetails("The requested resource does not exist.");
		excDetails.getMessages().add(new MessageDetail(ex.getMessage(), "Please rectify your search and try again."));
		
		return new ResponseEntity<ErrorDetails>(excDetails, HttpStatus.NOT_FOUND);
	}
}
