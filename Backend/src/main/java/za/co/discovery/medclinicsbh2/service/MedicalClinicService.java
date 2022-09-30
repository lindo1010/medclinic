package za.co.discovery.medclinicsbh2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.discovery.medclinicsbh2.entity.MedicalClinic;
import za.co.discovery.medclinicsbh2.repository.MedicalClinicRepository;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
public class MedicalClinicService {

    @Autowired
    MedicalClinicRepository medicalClinicRepository;

    public void add(MedicalClinic medicalClinic){
        medicalClinicRepository.saveAndFlush(medicalClinic);
    }

    public List<MedicalClinic> listAll(){
        return medicalClinicRepository.findAll();
    }

    public MedicalClinic getMedicalClinicById(Integer id){
        return medicalClinicRepository.findById(id).get();
    }

    public boolean deleteMedClinicById(Integer id){
        if(medicalClinicRepository.existsById(id)){
            medicalClinicRepository.deleteAllById(Collections.singleton(id));
            return true;
        }
        else{
            throw new NoSuchElementException("Record does not exist");
        }
    }
}
