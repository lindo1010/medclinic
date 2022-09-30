package za.co.discovery.medclinicsbh2.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="HEALTH_PROVIDER")
public class HealthProvider implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "HEALTH_PROVIDER_ID")
    private Integer healthProviderId;

    @Column(name = "HEALTH_PROVIDER_NAME")
    private String healthProviderName;

    @Column(name = "MEDICAL_CLINIC_NAME")
    private String clinicName;

    public HealthProvider() {
    }

    public HealthProvider(Integer healthProviderId, String healthProviderName, String clinicName) {
        this.healthProviderId = healthProviderId;
        this.healthProviderName = healthProviderName;
        this.clinicName = clinicName;
    }

    public Integer getHealthProviderId() {
        return healthProviderId;
    }

    public void setHealthProviderId(Integer healthProviderId) {
        this.healthProviderId = healthProviderId;
    }

    public String getHealthProviderName() {
        return healthProviderName;
    }

    public void setHealthProviderName(String healthProviderName) {
        this.healthProviderName = healthProviderName;
    }

    public String getClinicName() {
        return clinicName;
    }

    public void setClinicName(String clinicName) {
        this.clinicName = clinicName;
    }

    @Override
    public String toString() {
        return "HealthProvider{" +
                "healthProviderId=" + healthProviderId +
                ", healthProviderName='" + healthProviderName + '\'' +
                ", clinicName='" + clinicName + '\'' +
                '}';
    }
}
