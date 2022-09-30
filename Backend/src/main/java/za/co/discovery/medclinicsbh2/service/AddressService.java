package za.co.discovery.medclinicsbh2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.discovery.medclinicsbh2.entity.Address;
import za.co.discovery.medclinicsbh2.repository.AddressRepository;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Transactional
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public List<Address> listAddress(){
        return addressRepository.findAll();
    }

    public void add(Address address){
        addressRepository.saveAndFlush(address);
    }

    public Optional<Address> getAddress(Integer addressId){
        return addressRepository.findById(addressId);
    }

    public boolean deleteAddressById(Integer addressId){
        if(addressRepository.existsById(addressId)){
            addressRepository.deleteAllById(Collections.singleton(addressId));
            return true;
        }
        else{
            throw new NoSuchElementException("Record does not exist");
        }
    }
}
