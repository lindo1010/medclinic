package za.co.discovery.medclinicsbh2.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="MEDICAL_CLINIC")
public class MedicalClinic implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "MEDICAL_CLINIC_ID")
    private Integer id;

    @Column(name = "MEDICAL_CLINIC_NAME")
    private String medicalClinicName;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "NUMBER_OF_BEDS")
    private Integer numberOfBeds;

    public MedicalClinic() {
    }

    public MedicalClinic(Integer id,String medicalClinicName, String address, Integer numberOfBeds) {
        this.id = id;
        this.medicalClinicName = medicalClinicName;
        this.address = address;
        this.numberOfBeds = numberOfBeds;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMedicalClinicName() {
        return medicalClinicName;
    }

    public void setMedicalClinicName(String medicalClinicName) {
        this.medicalClinicName = medicalClinicName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getNumberOfBeds() {
        return numberOfBeds;
    }

    public void setNumberOfBeds(Integer numberOfBeds) {
        this.numberOfBeds = numberOfBeds;
    }

    @Override
    public String toString() {
        return "MedicalClinic{" +
                "medicalClinicName='" + medicalClinicName + '\'' +
                ", address='" + address + '\'' +
                ", numberOfBeds=" + numberOfBeds +
                '}';
    }
}
