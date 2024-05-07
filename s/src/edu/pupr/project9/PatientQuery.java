package edu.pupr.project9;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PatientQuery {
    private static final String URL = "jdbc:mysql://localhost:3306/patients";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "mimitoadmin";

    private Connection connection = null;
    private PreparedStatement displayAllPatient = null;
    private PreparedStatement getPatientBySsn = null;
    private PreparedStatement updatePatientInformation = null;

    public PatientQuery() {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            displayAllPatient = connection.prepareStatement("SELECT * FROM patients.patient");
            getPatientBySsn = connection.prepareStatement("SELECT * FROM patients.patient Where ssn = ?");
            updatePatientInformation = connection.prepareStatement(
            	    "UPDATE patients.patient " +
            	    "SET " +
            	    "    FirstName = ?, " +
            	    "    LastName = ?, " +
            	    "    dob = ?, " +
            	    "    phoneNo = ?, " +
            	    "    address1 = ?, " +
            	    "    address2 = ?, " +
            	    "    city = ?, " +
            	    "    zipcode = ?, " +
            	    "    allergy1 = ?, " +
            	    "    allergy2 = ?, " +
            	    "    allergy3 = ?, " +
            	    "    photo = ? " +
            	    "WHERE ssn = ?;"
            	);

        } catch (SQLException e) {
            System.err.println("Connection error to Database");
            e.printStackTrace();
            System.exit(1);
        }
    }
    
    public void updatePatientInformation(Patient patient) {
        try {
            updatePatientInformation.setString(1, patient.getFirstName());
            updatePatientInformation.setString(2, patient.getLastName());
            updatePatientInformation.setDate(3, (Date) patient.getDob());
            updatePatientInformation.setString(4, patient.getPhoneNumber());
            updatePatientInformation.setString(5, patient.getAddress1());
            updatePatientInformation.setString(6, patient.getAddress2());
            updatePatientInformation.setString(7, patient.getCity());
            updatePatientInformation.setString(8, patient.getZipcode());
            updatePatientInformation.setString(9, patient.getAllergy1());
            updatePatientInformation.setString(10, patient.getAllegry2());
            updatePatientInformation.setString(11, patient.getAllegry3());
            updatePatientInformation.setString(12, patient.getPhoto());
            updatePatientInformation.setString(13, patient.getSsn());

            int rowsAffected = updatePatientInformation.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Patient information updated successfully.");
            } else {
                System.out.println("No patient with the given SSN found.");
            }
        } catch (SQLException e) {
            System.err.println("Error updating patient information: " + e.getMessage());
        }
    }

    
    public Patient searchForPatientBySsn(String ssn) {
        Patient result = null;
        ResultSet rs = null; 

        try {
            getPatientBySsn.setString(1, ssn); // Corrected index to 1

            rs = getPatientBySsn.executeQuery();

            if (rs.next()) { // Move cursor to the first row
                result = new Patient(
                    rs.getString("ssn"),
                    rs.getString("FirstName"),
                    rs.getString("LastName"),
                    rs.getDate("dob"),
                    rs.getString("phoneNo"),
                    rs.getString("address1"),
                    rs.getString("address2"),
                    rs.getString("city"),
                    rs.getString("zipcode"),
                    rs.getString("allergy1"),
                    rs.getString("allergy2"),
                    rs.getString("allergy3"),
                    rs.getString("photo")
                );
            }
        } catch (SQLException e) {
            System.err.println("Error in DB: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return result;
    }


    public List<Patient> getAllPatient() {
        List<Patient> patients = new ArrayList<>();
        ResultSet rs = null;

        try {
            rs = displayAllPatient.executeQuery();
            while (rs.next()) {
            	Patient patient = new Patient(
                        rs.getString("ssn"),
                        rs.getString("FirstName"),
                        rs.getString("LastName"),
                        rs.getDate("dob"),
                        rs.getString("phoneNo"),
                        rs.getString("address1"),
                        rs.getString("address2"),
                        rs.getString("city"),
                        rs.getString("zipcode"),
                        rs.getString("allergy1"),
                        rs.getString("allergy2"),
                        rs.getString("allergy3"),
                        rs.getString("photo")
                );
                patients.add(patient); // Add the retrieved patient to the list
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close resources in finally block
            try {
                if (rs != null) rs.close();
                if (displayAllPatient != null) displayAllPatient.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return patients;
    }
}
