package djd.boot.employee.service.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

import djd.boot.employee.service.AddressService;
import djd.boot.employee.service.EmployeeService;
import djd.boot.employee.service.configuration.EmployeeServiceConfigProperties;
import djd.boot.employee.service.exceptions.EmployeeServiceException;
import djd.boot.employee.service.exceptions.ErrorDetails;
import djd.boot.employee.service.exceptions.MessageDetail;
import djd.boot.employee.service.models.Address;
import djd.boot.employee.service.models.Employee;
import jakarta.validation.Valid;

@RestController
public class EmployeeServiceController  {
	
	private EmployeeServiceConfigProperties config;
	private EmployeeService employeeService;
	private AddressService addressService;
	private MessageSource messageSource;
	
	@Autowired
	public EmployeeServiceController(EmployeeServiceConfigProperties config, MessageSource messageSource, EmployeeService employeeService, AddressService addressService) {
		this.config = config;
		this.messageSource = messageSource;
		this.employeeService = employeeService;
		this.addressService = addressService;
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
		return employeeService.getAllEmployees();
	}
	
	@GetMapping(path = "/employees/{id}")
	public MappingJacksonValue getEmployeeById(@PathVariable long id) {
		Employee employee = employeeService.getEmployee(id);
		
		if(employee == null) {
			throw new EmployeeServiceException("Could not find an employee with ID");
		}

		MappingJacksonValue mapping = new MappingJacksonValue(employee);
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("id", "name", "role", "department");
		FilterProvider filterProvider = new SimpleFilterProvider().addFilter("mobileFilter", filter);
		mapping.setFilters(filterProvider);
		
		return mapping;
	}
	
	@GetMapping(path = "/employees/greet")
	public String greet() {
		Locale locale = LocaleContextHolder.getLocale();
		return messageSource.getMessage("good.morning.message", null, "Default Message", locale);
	}
	
	@PostMapping(path = "/employees")
	public EntityModel<ResponseEntity<Employee>> addEmployee(@Valid @RequestBody Employee employee) {
		Employee addedEmp = employeeService.addEmployee(employee);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(addedEmp.getEmployeeId()).toUri();
		
		EntityModel<ResponseEntity<Employee>> entityModel = EntityModel.of(ResponseEntity.created(location).build());
		WebMvcLinkBuilder link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getEmployeeById(addedEmp.getEmployeeId()));
		entityModel.add(link.withRel("get-employee"));
		return entityModel;
	}
	
	@DeleteMapping(path = "/employees/{id}")
	public ResponseEntity<Object> deleteEmployee(@PathVariable long id) {
		employeeService.deleteEmployee(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(path = "/employees")
	public Employee updateEmployee(@RequestBody Employee employee) {
		return employeeService.updateEmployee(employee);
	}
	
	@GetMapping(path = "/employees/{id}/addresses")
	public List<Address> getAddressesForEmployee(@PathVariable long id) {
		Employee employee = employeeService.getEmployee(id);
		return employee.getAddesses();
	}
	
	@PostMapping(path = "/employees/{id}/addresses")
	public EntityModel<ResponseEntity<Address>> addAddressForEmployee(@PathVariable long id, @Valid @RequestBody Address address) {
		Employee employee = employeeService.getEmployee(id);
		address.setEmployee(employee);
		addressService.addAddress(address);
		
		EntityModel<ResponseEntity<Address>> entityModel = EntityModel.of(ResponseEntity.created(null).build());
		WebMvcLinkBuilder link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAddressesForEmployee(employee.getEmployeeId()));
		entityModel.add(link.withRel("get-address"));
		return entityModel;
	}
	
	@ExceptionHandler(value = EmployeeServiceException.class)
	public final ResponseEntity<ErrorDetails> handleEmployeeServiceException(Exception ex, WebRequest request) {
		ErrorDetails excDetails = new ErrorDetails("The requested resource does not exist.");
		excDetails.getMessages().add(new MessageDetail(ex.getMessage(), "Please rectify your search and try again."));
		
		return new ResponseEntity<ErrorDetails>(excDetails, HttpStatus.NOT_FOUND);
	}
}
