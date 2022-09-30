package za.co.discovery.medclinicsbh2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.discovery.medclinicsbh2.entity.HealthProvider;

@Repository
public interface HealthProviderRepository extends JpaRepository<HealthProvider, Integer> {
}
