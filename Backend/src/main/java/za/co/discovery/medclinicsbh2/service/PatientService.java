package za.co.discovery.medclinicsbh2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.discovery.medclinicsbh2.entity.Patient;
import za.co.discovery.medclinicsbh2.repository.PatientRepository;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Transactional
public class PatientService {

    @Autowired
    PatientRepository patientRepository;

    public void add(Patient patient){
        patientRepository.saveAndFlush(patient);
    }

    public List<Patient> listAll(){
        return patientRepository.findAll();
    }

    public Optional<Patient> getPatientById(Integer id){
        return patientRepository.findById(id);
    }

    public boolean deletePatientById(Integer id){
        if(patientRepository.existsById(id)){
            patientRepository.deleteAllById(Collections.singleton(id));
            return true;
        }
        else{
            throw new NoSuchElementException("Record does not exist");
        }
    }
}
