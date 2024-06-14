package djd.boot.employee.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import djd.boot.employee.service.models.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
