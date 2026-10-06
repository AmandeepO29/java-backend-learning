package in.strikes.hibernateDemo.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class Address {
    private String houseNo;
    private String street;
    private String city;
    private String state;
    private String pincode;

    public Address(String houseNo, String street, String city, String state, String pincode) {
        this.houseNo = houseNo;
        this.street = street;
        this.city = city;
        this.state = state;
        this.pincode = pincode;
    }

    public Address() {

    }
}
