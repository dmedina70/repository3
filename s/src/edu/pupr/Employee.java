package edu.pupr;

public class Employee {
	
	private int id;
	private String ssn;
	private String saludation;
	private String firstName;
	private String lastName;
	private String maidenName;
	private int earningType;
	private double earning;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public String getSaludation() {
		return saludation;
	}
	public void setSaludation(String saludation) {
		this.saludation = saludation;
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
	public String getMaidenName() {
		return maidenName;
	}
	public void setMaidenName(String maidenName) {
		this.maidenName = maidenName;
	}

	public int getEarningType() {
		return earningType;
	}
	public void setEarningType(int earningType) {
		this.earningType = earningType;
	}
	public double getEarning() {
		return earning;
	}
	public void setEarning(double earning) {
		this.earning = earning;
	}
	
	public Employee(int id, String ssn, String saludation, String firstName, String lastName, String maidenName,
			int earningType, double earning) {
		this.id = id;
		this.ssn = ssn;
		this.saludation = saludation;
		this.firstName = firstName;
		this.lastName = lastName;
		this.maidenName = maidenName;
		this.earningType = earningType;
		this.earning = earning;
		

	}
	
	
	
	@Override
	public String toString() {
	    return "Employee:\n" +
	           "id=" + id + ",\n" +
	           "salutation=" + saludation + ",\n" +
	           "firstName=" + firstName + ",\n" +
	           "lastName=" + lastName + ",\n" +
	           "maidenName=" + maidenName + ",\n" +
	           "ssn=" + ssn + ",\n" +
	           "earning_type=" + earningType + ",\n" +
	           "earnings=" + earning;
	}


}
