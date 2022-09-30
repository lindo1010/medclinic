package za.co.discovery.medclinicsbh2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.discovery.medclinicsbh2.entity.HealthProvider;
import za.co.discovery.medclinicsbh2.repository.HealthProviderRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
public class HealthProviderService {

    @Autowired
    HealthProviderRepository healthProviderRepository;

    public void add(HealthProvider healthProvider){
        healthProviderRepository.saveAndFlush(healthProvider);
    }

    public List<HealthProvider> listAll(){
        return healthProviderRepository.findAll();
    }

    public HealthProvider getHealthProviderById(Integer healthProviderId){
        return healthProviderRepository.findById(healthProviderId).get();
    }

    public boolean deleteHealthProviderById(Integer healthProviderId){
        if(healthProviderRepository.existsById(healthProviderId)){
            healthProviderRepository.deleteById(healthProviderId);
            return true;
        }
        else{
            throw new NoSuchElementException("Record does not exist");
        }
    }
}
