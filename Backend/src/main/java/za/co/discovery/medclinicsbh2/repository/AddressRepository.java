package za.co.discovery.medclinicsbh2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.discovery.medclinicsbh2.entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address,Integer> {
}
