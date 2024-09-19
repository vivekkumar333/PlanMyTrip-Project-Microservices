package planmytrip.user.service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import planmytrip.user.service.entities.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
