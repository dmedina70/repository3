package edu.pupr.project9;

import java.sql.Connection;
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

    public PatientQuery() {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            displayAllPatient = connection.prepareStatement("SELECT * FROM patients.patient");
        } catch (SQLException e) {
            System.err.println("Connection error to Database");
            e.printStackTrace();
            System.exit(1);
        }
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
