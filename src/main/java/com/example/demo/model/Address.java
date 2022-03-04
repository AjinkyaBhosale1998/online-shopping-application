package com.example.demo.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Entity
@Table(name="adress")
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
  private String addressId;
  private String streetNo;
  private String buildingName;
  private String city;
  
  public Address() {
	super();
}
public Address(String addressId, String streetNo, String buildingName, String city, String state, String country,
		String pincode) {
	super();
	this.addressId = addressId;
	this.streetNo = streetNo;
	this.buildingName = buildingName;
	this.city = city;
	this.state = state;
	this.country = country;
	this.pincode = pincode;
}
@Override
public String toString() {
	return "Address [addressId=" + addressId + ", streetNo=" + streetNo + ", buildingName=" + buildingName + ", city="
			+ city + ", state=" + state + ", country=" + country + ", pincode=" + pincode + "]";
}
@Override
public int hashCode() {
	return Objects.hash(addressId, buildingName, city, country, pincode, state, streetNo);
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Address other = (Address) obj;
	return Objects.equals(addressId, other.addressId) && Objects.equals(buildingName, other.buildingName)
			&& Objects.equals(city, other.city) && Objects.equals(country, other.country)
			&& Objects.equals(pincode, other.pincode) && Objects.equals(state, other.state)
			&& Objects.equals(streetNo, other.streetNo);
}
private String state;
  private String country;
  private String pincode;
public String getAddressId() {
	return addressId;
}
public void setAddressId(String addressId) {
	this.addressId = addressId;
}
public String getStreetNo() {
	return streetNo;
}
public void setStreetNo(String streetNo) {
	this.streetNo = streetNo;
}
public String getBuildingName() {
	return buildingName;
}
public void setBuildingName(String buildingName) {
	this.buildingName = buildingName;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}
public String getCountry() {
	return country;
}
public void setCountry(String country) {
	this.country = country;
}
public String getPincode() {
	return pincode;
}
public void setPincode(String pincode) {
	this.pincode = pincode;
}
  
  
}
