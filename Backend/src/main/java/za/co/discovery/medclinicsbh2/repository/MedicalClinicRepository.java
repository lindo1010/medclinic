package za.co.discovery.medclinicsbh2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.discovery.medclinicsbh2.entity.MedicalClinic;

@Repository
public interface MedicalClinicRepository extends JpaRepository<MedicalClinic,Integer> {
}
