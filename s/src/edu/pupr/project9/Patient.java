package edu.pupr.project9;

import java.util.Date;

public class Patient {
	
	private String ssn;
	private String firstName;
	private String lastName;
	private Date dob;
	private String phoneNumber;
	private String address1;
	private String address2;
	private String city;
	private String zipcode;
	private String allergy1;
	private String allegry2;
	private String allegry3;
	private String photo;
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getAllergy1() {
		return allergy1;
	}
	public void setAllergy1(String allergy1) {
		this.allergy1 = allergy1;
	}
	public String getAllegry2() {
		return allegry2;
	}
	public void setAllegry2(String allegry2) {
		this.allegry2 = allegry2;
	}
	public String getAllegry3() {
		return allegry3;
	}
	public void setAllegry3(String allegry3) {
		this.allegry3 = allegry3;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public Patient(String ssn, String firstName, String lastName, Date dob, String phoneNumber, String address1,
			String address2, String city, String zipcode, String allergy1, String allegry2, String allegry3,
			String photo) {
		super();
		this.ssn = ssn;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.phoneNumber = phoneNumber;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.zipcode = zipcode;
		this.allergy1 = allergy1;
		this.allegry2 = allegry2;
		this.allegry3 = allegry3;
		this.photo = photo;
	}
	
	
	
	

}
