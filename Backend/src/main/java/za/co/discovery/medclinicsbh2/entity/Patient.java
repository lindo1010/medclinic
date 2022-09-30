package za.co.discovery.medclinicsbh2.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="PATIENT")
public class Patient implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PATIENT_ID")
    private Integer patientId;

    @Column(name = "PATIENT_NAME")
    private String patientName;

    @Column(name = "MEDICAL_CLINIC_ID")
    private Integer medClinicId;

    @Column(name = "HEALTH_PROVIDER_ID")
    private  Integer healthProvId;

    public Patient() {
    }

    public Patient(Integer patientId, String patientName, Integer medClinicId, Integer healthProvId) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.medClinicId = medClinicId;
        this.healthProvId = healthProvId;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public Integer getMedClinicId() {
        return medClinicId;
    }

    public void setMedClinicId(Integer medClinicId) {
        this.medClinicId = medClinicId;
    }

    public Integer getHealthProvId() {
        return healthProvId;
    }

    public void setHealthProvId(Integer healthProvId) {
        this.healthProvId = healthProvId;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "patientId=" + patientId +
                ", patientName='" + patientName + '\'' +
                ", medClinicId=" + medClinicId +
                ", healthProvId=" + healthProvId +
                '}';
    }
}
