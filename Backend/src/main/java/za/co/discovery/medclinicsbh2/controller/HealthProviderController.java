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
import za.co.discovery.medclinicsbh2.service.HealthProviderService;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/healthprovider")
@CrossOrigin(origins = "http://localhost:4200/")
public class HealthProviderController {

    @Autowired
    private HealthProviderService healthProviderService;

    @PostMapping("/add")
    public ResponseEntity<List<HealthProvider>> addHealthProvider(@RequestBody HealthProvider healthProvider){
        try{
            healthProviderService.add(healthProvider);
            return new ResponseEntity<>(healthProviderService.listAll(), HttpStatus.OK);
        } catch (HibernateException e){
            return new ResponseEntity(e, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/listAll")
    public ResponseEntity<List<HealthProvider>> healthProviders(){
        return new ResponseEntity<>(healthProviderService.listAll(), HttpStatus.OK);
    }

    @GetMapping("/listAll/{id}")
    public ResponseEntity<HealthProvider> findHealthProviderById(@PathVariable Integer id){
        try {
            HealthProvider healthProvider = healthProviderService.getHealthProviderById(id);
            return new ResponseEntity(healthProvider, HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<List<HealthProvider>> deleteHealthProvider(@PathVariable Integer id){
        try {
            healthProviderService.deleteHealthProviderById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        return new ResponseEntity(healthProviderService.listAll(),HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateHealthProvider(@RequestBody HealthProvider healthProvider,@PathVariable Integer id){
        try {
            healthProvider.setHealthProviderId(id);
            healthProviderService.add(healthProvider);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
