package djd.boot.employee.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import djd.boot.employee.service.models.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
}


