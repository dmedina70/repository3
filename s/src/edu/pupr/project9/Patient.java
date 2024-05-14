package edu.pupr.project9;

import java.util.Date;

/**
 * The Patient class represents a patient with various attributes such as SSN, name, date of birth, contact information, address, allergies, and photo.
 */
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
	private String allergy2;
	private String allergy3;
	private String photo;

	/**
	 * Gets the SSN of the patient.
	 * @return the SSN
	 */
	public String getSsn() {
		return ssn;
	}

	/**
	 * Sets the SSN of the patient.
	 * @param ssn the SSN to set
	 */
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	/**
	 * Gets the first name of the patient.
	 * @return the first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the first name of the patient.
	 * @param firstName the first name to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Gets the last name of the patient.
	 * @return the last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the last name of the patient.
	 * @param lastName the last name to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Gets the date of birth of the patient.
	 * @return the date of birth
	 */
	public Date getDob() {
		return dob;
	}

	/**
	 * Sets the date of birth of the patient.
	 * @param dob the date of birth to set
	 */
	public void setDob(Date dob) {
		this.dob = dob;
	}

	/**
	 * Gets the phone number of the patient.
	 * @return the phone number
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * Sets the phone number of the patient.
	 * @param phoneNumber the phone number to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * Gets the primary address of the patient.
	 * @return the primary address
	 */
	public String getAddress1() {
		return address1;
	}

	/**
	 * Sets the primary address of the patient.
	 * @param address1 the primary address to set
	 */
	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	/**
	 * Gets the secondary address of the patient.
	 * @return the secondary address
	 */
	public String getAddress2() {
		return address2;
	}

	/**
	 * Sets the secondary address of the patient.
	 * @param address2 the secondary address to set
	 */
	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	/**
	 * Gets the city of the patient's address.
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * Sets the city of the patient's address.
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * Gets the zipcode of the patient's address.
	 * @return the zipcode
	 */
	public String getZipcode() {
		return zipcode;
	}

	/**
	 * Sets the zipcode of the patient's address.
	 * @param zipcode the zipcode to set
	 */
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	/**
	 * Gets the first allergy of the patient.
	 * @return the first allergy
	 */
	public String getAllergy1() {
		return allergy1;
	}

	/**
	 * Sets the first allergy of the patient.
	 * @param allergy1 the first allergy to set
	 */
	public void setAllergy1(String allergy1) {
		this.allergy1 = allergy1;
	}

	/**
	 * Gets the second allergy of the patient.
	 * @return the second allergy
	 */
	public String getAllergy2() {
		return allergy2;
	}

	/**
	 * Sets the second allergy of the patient.
	 * @param allergy2 the second allergy to set
	 */
	public void setAllergy2(String allergy2) {
		this.allergy2 = allergy2;
	}

	/**
	 * Gets the third allergy of the patient.
	 * @return the third allergy
	 */
	public String getAllergy3() {
		return allergy3;
	}

	/**
	 * Sets the third allergy of the patient.
	 * @param allergy3 the third allergy to set
	 */
	public void setAllergy3(String allergy3) {
		this.allergy3 = allergy3;
	}

	/**
	 * Gets the photo of the patient.
	 * @return the photo
	 */
	public String getPhoto() {
		return photo;
	}

	/**
	 * Sets the photo of the patient.
	 * @param photo the photo to set
	 */
	public void setPhoto(String photo) {
		this.photo = photo;
	}

	/**
	 * Constructs a new Patient with the specified details.
	 *
	 * @param ssn the SSN of the patient
	 * @param firstName the first name of the patient
	 * @param lastName the last name of the patient
	 * @param dob the date of birth of the patient
	 * @param phoneNumber the phone number of the patient
	 * @param address1 the primary address of the patient
	 * @param address2 the secondary address of the patient
	 * @param city the city of the patient's address
	 * @param zipcode the zipcode of the patient's address
	 * @param allergy1 the first allergy of the patient
	 * @param allergy2 the second allergy of the patient
	 * @param allergy3 the third allergy of the patient
	 * @param photo the photo of the patient
	 */
	public Patient(String ssn, String firstName, String lastName, Date dob, String phoneNumber, String address1,
	               String address2, String city, String zipcode, String allergy1, String allergy2, String allergy3,
	               String photo) {
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
		this.allergy2 = allergy2;
		this.allergy3 = allergy3;
		this.photo = photo;
	}
}
