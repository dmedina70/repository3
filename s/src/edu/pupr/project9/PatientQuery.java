package edu.pupr.project9;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

/**
 * The PatientQuery class handles database operations related to patients,
 * including adding, updating, and retrieving patient information.
 */
public class PatientQuery {
    private static final String URL = "jdbc:mysql://localhost:3306/patients";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "mimitoadmin";

    private Connection connection = null;
    private PreparedStatement displayAllPatient = null;
    private PreparedStatement getPatientBySsn = null;
    private PreparedStatement updatePatientInformation = null;
    private PreparedStatement addPatient = null;

    /**
     * Initializes the database connection and prepares SQL statements.
     */
    public PatientQuery() {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            displayAllPatient = connection.prepareStatement("SELECT * FROM patients.patient");
            getPatientBySsn = connection.prepareStatement("SELECT * FROM patients.patient WHERE ssn = ?");
            updatePatientInformation = connection.prepareStatement(
                "UPDATE patients.patient SET " +
                "FirstName = ?, LastName = ?, dob = ?, phoneNo = ?, address1 = ?, " +
                "address2 = ?, city = ?, zipcode = ?, allergy1 = ?, allergy2 = ?, " +
                "allergy3 = ?, photo = ? WHERE ssn = ?"
            );
            addPatient = connection.prepareStatement(
                "INSERT INTO patients.patient(ssn, FirstName, LastName, dob, phoneNo, address1, " +
                "address2, city, zipcode, allergy1, allergy2, allergy3, photo) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"
            );
        } catch (SQLException e) {
            System.err.println("Connection error to Database");
            e.printStackTrace();
            System.exit(1);
        }
    }

    /**
     * Adds a new patient to the database.
     *
     * @param patient The patient to add.
     */
    public void addNewPatient(Patient patient) {
        try {
            addPatient.setString(1, patient.getSsn());
            addPatient.setString(2, patient.getFirstName());
            addPatient.setString(3, patient.getLastName());
            addPatient.setDate(4, (Date) patient.getDob());
            addPatient.setString(5, patient.getPhoneNumber());
            addPatient.setString(6, patient.getAddress1());
            addPatient.setString(7, patient.getAddress2());
            addPatient.setString(8, patient.getCity());
            addPatient.setString(9, patient.getZipcode());
            addPatient.setString(10, patient.getAllergy1());
            addPatient.setString(11, patient.getAllergy2());
            addPatient.setString(12, patient.getAllergy3());
            addPatient.setString(13, patient.getPhoto());

            addPatient.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Patient Added");
        } catch (SQLException e) {
            System.err.println("Error updating patient information: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "The social security number is already in the database");
        }
    }

    /**
     * Updates the information of an existing patient in the database.
     *
     * @param patient The patient with updated information.
     */
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
            updatePatientInformation.setString(10, patient.getAllergy2());
            updatePatientInformation.setString(11, patient.getAllergy3());
            updatePatientInformation.setString(12, patient.getPhoto());
            updatePatientInformation.setString(13, patient.getSsn());

            int rowsAffected = updatePatientInformation.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Update Completed");
            } else {
                System.out.println("No patient with the given SSN found.");
            }
        } catch (SQLException e) {
            System.err.println("Error updating patient information: " + e.getMessage());
        }
    }

    /**
     * Searches for a patient by their SSN.
     *
     * @param ssn The SSN of the patient to search for.
     * @return The patient with the given SSN, or null if not found.
     */
    public Patient searchForPatientBySsn(String ssn) {
        Patient result = null;
        ResultSet rs = null;

        try {
            getPatientBySsn.setString(1, ssn);
            rs = getPatientBySsn.executeQuery();

            if (rs.next()) {
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

    /**
     * Retrieves all patients from the database.
     *
     * @return A list of all patients.
     */
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
                patients.add(patient);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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
