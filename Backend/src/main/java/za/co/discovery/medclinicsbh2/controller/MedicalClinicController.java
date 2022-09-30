package za.co.discovery.medclinicsbh2.controller;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.co.discovery.medclinicsbh2.entity.HealthProvider;
import za.co.discovery.medclinicsbh2.entity.MedicalClinic;
import za.co.discovery.medclinicsbh2.service.MedicalClinicService;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/medicalclinic")
@CrossOrigin(origins = "http://localhost:4200/")
public class MedicalClinicController {

    @Autowired
    MedicalClinicService medicalClinicService;

    @PostMapping("/add")
    public ResponseEntity<List<MedicalClinic>> addMedicalClinic(@RequestBody MedicalClinic medicalClinic){
        try {
            medicalClinicService.add(medicalClinic);
            return new ResponseEntity(medicalClinicService.listAll(),HttpStatus.OK);
        } catch (HibernateException ex) {
            return new ResponseEntity(ex, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/listAll")
    public ResponseEntity<List<MedicalClinic>> patientList(){
        return new ResponseEntity<>(medicalClinicService.listAll(), HttpStatus.OK);
    }

    @GetMapping("/listAll/{id}")
    public ResponseEntity findMedClinicById(@PathVariable Integer id){
        try {
            MedicalClinic medicalClinic = medicalClinicService.getMedicalClinicById(id);
            return new ResponseEntity(medicalClinic, HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<List<HealthProvider>> deleteMedClinic(@PathVariable Integer id){
        try {
            medicalClinicService.deleteMedClinicById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        return new ResponseEntity(medicalClinicService.listAll(),HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateMedClinic(@RequestBody MedicalClinic medicalClinic,@PathVariable Integer id){
        try {
            medicalClinic.setId(id);
            medicalClinicService.add(medicalClinic);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
