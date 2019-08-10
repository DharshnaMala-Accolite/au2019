package com.example.SpringBoot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @Column(name = "address")
    private String address;
    
    @Column(name = "pincode")
    private String zip;

    @Column(name = "state")
    private String state;
    
    public Address(String address, String pincode, String state) {
  		this.address = address;
  		this.zip = pincode;
  		this.state = state;
  	}
   
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setId(long id) {
		this.id = id;
	}
	public long getId() {
		return id;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAddress() {
		return address;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getZip() {
		return zip;
	}

	@Override
	public String toString() {
		return "Address :"+"\nid=" + id + "\n address=" + address + "\n zip=" + zip + "\nstate=" + state ;
	}

}
