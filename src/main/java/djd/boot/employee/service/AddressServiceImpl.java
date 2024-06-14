package djd.boot.employee.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import djd.boot.employee.service.models.Address;
import djd.boot.employee.service.repository.AddressRepository;

@Service
public class AddressServiceImpl implements AddressService {
	
	@Autowired
	private AddressRepository repository;

	@Override
	public Address addAddress(Address address) {
		return repository.save(address);
	}

	@Override
	public Address getAddress(long id) {
		Optional<Address> address = repository.findById(id);
		return address.get();
	}

	@Override
	public Address updateAddress(Address address) {
		return repository.save(address);
	}

	@Override
	public void deleteAddress(long id) {
		repository.deleteById(id);
	}

}
