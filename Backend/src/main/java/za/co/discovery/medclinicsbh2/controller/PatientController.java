package za.co.discovery.medclinicsbh2.controller;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.co.discovery.medclinicsbh2.entity.Patient;
import za.co.discovery.medclinicsbh2.service.PatientService;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private PatientService patientService;


    @PostMapping("/add")
    public ResponseEntity<List<Patient>> addPatient(@RequestBody Patient patient){
        try {
            patientService.add(patient);
            return new ResponseEntity<>(patientService.listAll(),HttpStatus.OK);
        } catch (HibernateException ex) {
            return new ResponseEntity(ex, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/listAll")
    public ResponseEntity<List<Patient>> patientList(){
        return new ResponseEntity<>(patientService.listAll(), HttpStatus.OK);
    }

    @GetMapping("/listAll/{id}")
    public ResponseEntity<Patient> findById(@PathVariable Integer id){
        try {
            Optional<Patient> patient = patientService.getPatientById(id);
            return new ResponseEntity(patient, HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<List<Patient>> deletePatient(@PathVariable Integer id){
        try {
            patientService.deletePatientById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(patientService.listAll(), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updatePatient(@RequestBody Patient patient, @PathVariable Integer id){
        try{
            patient.setPatientId(id);
            patientService.add(patient);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
