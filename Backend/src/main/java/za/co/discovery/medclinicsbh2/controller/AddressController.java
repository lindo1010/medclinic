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
import za.co.discovery.medclinicsbh2.entity.Address;
import za.co.discovery.medclinicsbh2.service.AddressService;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    AddressService addressService;

    @PostMapping("/add")
    public ResponseEntity<List<Address>> addAddress(@RequestBody Address address){
        try {
            addressService.add(address);
            return new ResponseEntity<>(addressService.listAddress(),HttpStatus.OK);
        } catch (HibernateException ex) {
            return new ResponseEntity(ex, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/listAll")
    public ResponseEntity<List<Address>> addressList(){
        return new ResponseEntity<>(addressService.listAddress(), HttpStatus.OK);
    }

    @GetMapping("/listAll/{addressId}")
    public ResponseEntity<Address> findById(@PathVariable Integer addressId){
        try {
            Optional<Address> address = addressService.getAddress(addressId);
            return new ResponseEntity(address, HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{addressId}")
    public ResponseEntity<List<Address>> deleteAddress(@PathVariable Integer addressId){
        try {
            addressService.deleteAddressById(addressId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(addressService.listAddress(),HttpStatus.OK);
    }

    @PutMapping("/update/{addressId}")
    public ResponseEntity<?> updateAddress(@RequestBody Address address,@PathVariable Integer addressId){
        try {
            address.setAddressId(addressId);
            addressService.add(address);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
