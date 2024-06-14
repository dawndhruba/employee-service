package djd.boot.employee.service;

import djd.boot.employee.service.models.Address;

public interface AddressService {
	Address addAddress(Address address);
	Address getAddress(long id);
	Address updateAddress(Address address);
	void deleteAddress(long id);
}
