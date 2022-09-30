package za.co.discovery.medclinicsbh2.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="ADDRESS")
public class Address implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ADDRESS_ID")
    private Integer addressId;

    @Column(name = "HOUSE_NUMBER")
    private String houseNumber;

    @Column(name = "ADDRESS_LINE_1")
    private String firstAddressLine;

    @Column(name = "ADDRESS_LINE_2")
    private String secondAddressLine;

    @Column(name = "SURBUB")
    private String surbub;

    @Column(name = "POSTAL_CODE")
    private String postalCode;

    public Address() {
    }

    public Address(Integer addressId, String houseNumber, String firstAddressLine, String secondAddressLine, String surbub, String postalCode) {
        this.addressId = addressId;
        this.houseNumber = houseNumber;
        this.firstAddressLine = firstAddressLine;
        this.secondAddressLine = secondAddressLine;
        this.surbub = surbub;
        this.postalCode = postalCode;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getFirstAddressLine() {
        return firstAddressLine;
    }

    public void setFirstAddressLine(String firstAddressLine) {
        this.firstAddressLine = firstAddressLine;
    }

    public String getSecondAddressLine() {
        return secondAddressLine;
    }

    public void setSecondAddressLine(String secondAddressLine) {
        this.secondAddressLine = secondAddressLine;
    }

    public String getSurbub() {
        return surbub;
    }

    public void setSurbub(String surbub) {
        this.surbub = surbub;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressId=" + addressId +
                ", houseNumber='" + houseNumber + '\'' +
                ", firstAddressLine='" + firstAddressLine + '\'' +
                ", secondAddressLine='" + secondAddressLine + '\'' +
                ", surbub='" + surbub + '\'' +
                ", postalCode='" + postalCode + '\'' +
                '}';
    }
}

