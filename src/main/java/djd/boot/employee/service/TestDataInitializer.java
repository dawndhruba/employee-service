package djd.boot.employee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import djd.boot.employee.service.models.Address;
import djd.boot.employee.service.models.Employee;
import djd.boot.employee.service.repository.AddressRepository;
import djd.boot.employee.service.repository.EmployeeRepository;

@Component
public class TestDataInitializer implements CommandLineRunner {

	@Autowired
	private EmployeeRepository employeeRepo;
	
	@Autowired
	private AddressRepository addressRepo;

	@Override
	public void run(String... args) throws Exception {
		// NOT NEEDED WHILE USING MYSQL AS THE DATA IS PERSISTED, UNLIKE H2
		
//		Employee emp1 = new Employee("Aman", "Manager", "AppsDev", "7845235678");
//		Employee emp2 = new Employee("Brad", "Developer", "AppsDev", "9986562357");
//		Employee emp3 = new Employee("Caroline", "Facility Manager", "Facility", "8857564230");
//		Employee emp4 = new Employee("David", "Security Specialist", "Security", "7787556565");
//		Employee emp5 = new Employee("Emil", "Talent Advisor", "HR", "8899577445");
//		Employee emp6 = new Employee("Flynn", "Senior Developer", "AppsDev", "9896465646");
//		
//		employeeRepo.save(emp1);
//		employeeRepo.save(emp2);
//		employeeRepo.save(emp3);
//		employeeRepo.save(emp4);
//		employeeRepo.save(emp5);
//		employeeRepo.save(emp6);
		
		//employeeRepo.flush();
		
		
		// NOT NEEDED WHILE USING MYSQL AS THE DATA IS PERSISTED, UNLIKE H2
		
//		Address add1 = new Address("Home", "1 Street One", 887755l, "India");
//		add1.setEmployee(emp1);
//		addressRepo.save(add1);
//		
//		Address add2 = new Address("Office", "2 Street One", 997799l, "India");
//		add2.setEmployee(emp2);
//		addressRepo.save(add2);
//
//		Address add3 = new Address("Home", "3 Street One", 996633l, "India");
//		add3.setEmployee(emp3);
//		addressRepo.save(add3);
//		
//		Address add4 = new Address("Home", "4 Street One", 778822l, "India");
//		add4.setEmployee(emp4);
//		addressRepo.save(add4);
//		
//		Address add5 = new Address("Office", "5 Street One", 663344l, "India");
//		add5.setEmployee(emp5);
//		addressRepo.save(add5);
//		
//		Address add6 = new Address("Office", "6 Street One", 331144l, "India");
//		add6.setEmployee(emp6);
//		addressRepo.save(add6);
//
//		Address add7 = new Address("Home", "7 Street One", 110022l, "India");
//		add7.setEmployee(emp2);
//		addressRepo.save(add7);
//
//		Address add8 = new Address("Home", "8 Street One", 880033l, "India");
//		add8.setEmployee(emp5);
//		addressRepo.save(add8);
//		
//		Address add9 = new Address("Home", "9 Street One", 330022l, "India");
//		add9.setEmployee(emp6);
//		addressRepo.save(add9);
	}
}
