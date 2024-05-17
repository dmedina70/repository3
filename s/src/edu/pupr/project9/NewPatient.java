package edu.pupr.project9;

import java.awt.EventQueue;
import java.sql.Date;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

public class NewPatient extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
    private JTextField txtFirstName;
    private JTextField txtLastName;
    private JTextField txtDob;
    private JTextField txtSsn;
    private JTextField txtPhoneNo;
    private JTextField txtAddress1;
    private JTextField txtAddress2;
    private JTextField txtCity;
    private JTextField txtZipCode;
    private JTextField txtAllergy1;
    private JTextField txtAllergy3;
    private JTextField txtPhoto;
    private String photo;
    
    PatientQuery query = new PatientQuery();
    private JTextField txtAllergy2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewPatient frame = new NewPatient();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public NewPatient() {
		setTitle("Add New Patient");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 526, 693);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JLabel lblFirstName = new JLabel("First Name:");
		
		JLabel lblLastName = new JLabel("Last Name:");
		
		JLabel lblDateOfBirth = new JLabel("Date Of Birth:");
		
		JLabel lblSocialSecurityssn = new JLabel("Social Security (ssn):");
		
		JLabel lblPhoneNumber = new JLabel("Phone Number:");
		
		JLabel lblAddress = new JLabel("Address 1:");
		
		JLabel lblAddress2 = new JLabel("Address 2:");
		
		JLabel lblCity = new JLabel("City:");
		
		JLabel lblZipCode = new JLabel("Zip Code:");
		
		JLabel lblAllergy = new JLabel("Allergy 1:");
		
		JLabel lblAllergy2 = new JLabel("Allergy 2:");
		
		JLabel lblAllergy_2 = new JLabel("Allergy 3:");
		
		JLabel lblPhoto = new JLabel("Photo:");
		
		txtFirstName = new JTextField();
		txtFirstName.setColumns(10);
		
		txtLastName = new JTextField();
		txtLastName.setColumns(10);
		
		txtDob = new JTextField();
		txtDob.setColumns(10);
		
		txtSsn = new JTextField();
		txtSsn.setColumns(10);
		
		txtPhoneNo = new JTextField();
		txtPhoneNo.setColumns(10);
		
		txtAddress1 = new JTextField();
		txtAddress1.setColumns(10);
		
		txtAddress2 = new JTextField();
		txtAddress2.setColumns(10);
		
		txtCity = new JTextField();
		txtCity.setColumns(10);
		
		txtZipCode = new JTextField();
		txtZipCode.setColumns(10);
		
		txtAllergy1 = new JTextField();
		txtAllergy1.setColumns(10);
		
		txtAllergy2 = new JTextField();
		txtAllergy2.setColumns(10);
		
		txtAllergy3 = new JTextField();
		txtAllergy3.setColumns(10);
		
		txtPhoto = new JTextField();
		txtPhoto.setEnabled(false);
		txtPhoto.setEditable(false);
		txtPhoto.setColumns(10);
		
		JButton btnSearchPhoto = new JButton("Search Photo");
		btnSearchPhoto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
                FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG Images", "jpg");
                fileChooser.setFileFilter(filter);
                int result = fileChooser.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    String fileName = selectedFile.getName();
                    if (fileName.length() > 40) {
                        fileName = fileName.substring(0, 40);
                    }
                    txtPhoto.setText(fileName);
                }
            }
        });
		
		JButton btnAddPatient = new JButton("Add Patient");
		btnAddPatient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 savePatient();
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(42)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblAllergy2, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtAllergy2))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblAllergy, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtAllergy1))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblZipCode, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtZipCode))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblCity, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtCity))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblAddress2)
									.addGap(18)
									.addComponent(txtAddress2))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblAddress)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(txtAddress1))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblPhoneNumber)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(txtPhoneNo))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblSocialSecurityssn)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtSsn))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblFirstName)
										.addComponent(lblLastName)
										.addComponent(lblDateOfBirth))
									.addGap(24)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
										.addComponent(txtFirstName, GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
										.addComponent(txtLastName)
										.addComponent(txtDob)))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblPhoto, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblAllergy_2, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(txtPhoto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(btnSearchPhoto))
										.addComponent(txtAllergy3)))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(84)
							.addComponent(btnAddPatient, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(211, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(27)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFirstName)
						.addComponent(txtFirstName, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLastName)
						.addComponent(txtLastName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDateOfBirth)
						.addComponent(txtDob, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSocialSecurityssn)
						.addComponent(txtSsn, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPhoneNumber)
						.addComponent(txtPhoneNo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAddress)
						.addComponent(txtAddress1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAddress2)
						.addComponent(txtAddress2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCity)
						.addComponent(txtCity, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblZipCode)
						.addComponent(txtZipCode, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAllergy)
						.addComponent(txtAllergy1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAllergy2)
						.addComponent(txtAllergy2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAllergy_2)
						.addComponent(txtAllergy3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(24)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtPhoto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPhoto)
						.addComponent(btnSearchPhoto))
					.addGap(18)
					.addComponent(btnAddPatient)
					.addContainerGap(79, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	 private void savePatient() {
		 
		 if (txtFirstName.getText().isEmpty()) {
		        JOptionPane.showMessageDialog(null, "First Name cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
		        txtFirstName.requestFocus();
		        return;
		    }
		 
		 if (txtLastName.getText().isEmpty()) {
		        JOptionPane.showMessageDialog(null, "Last Name cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
		        txtLastName.requestFocus();
		        return;
		    }
		 if (txtDob.getText().isEmpty()) {
		        JOptionPane.showMessageDialog(null, "Date of Birth cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
		        txtDob.requestFocus();
		        return;
		    }
		 if (txtSsn.getText().isEmpty()) {
		        JOptionPane.showMessageDialog(null, "SSN cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
		        txtSsn.requestFocus();
		        return;
		    }
		    
		    // Check if the SSN is the correct length
		    if (txtSsn.getText().length() != 9) {
		        JOptionPane.showMessageDialog(null, "SSN must be 9 digits long.", "Error", JOptionPane.ERROR_MESSAGE);
		        txtSsn.requestFocus();
		        return;
		    }
		    
		    if (txtPhoneNo.getText().isEmpty()) {
		        JOptionPane.showMessageDialog(null, "Phone Number cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
		        txtPhoneNo.requestFocus();
		        return;
		    }
		    if (txtAddress1.getText().isEmpty()) {
		        JOptionPane.showMessageDialog(null, "Address 1 cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
		        txtAddress1.requestFocus();
		        return;
		    }
		    if (txtCity.getText().isEmpty()) {
		        JOptionPane.showMessageDialog(null, "City cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
		        txtCity.requestFocus();
		        return;
		    }
		    if (txtZipCode.getText().isEmpty()) {
		        JOptionPane.showMessageDialog(null, "Zip Code cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
		        txtZipCode.requestFocus();
		        return;
		    }

		    try {
		        // Validate and parse the date
		        Date dob = Date.valueOf(txtDob.getText());

		        // Create a new Patient object using the information from the text fields
		        Patient patient = new Patient(
		            txtSsn.getText(),
		            txtFirstName.getText(),
		            txtLastName.getText(),
		            dob,
		            txtPhoneNo.getText(),
		            txtAddress1.getText(),
		            txtAddress2.getText(),
		            txtCity.getText(),
		            txtZipCode.getText(),
		            txtAllergy1.getText(),
		            txtAllergy2.getText(),
		            txtAllergy3.getText(),
		            photo // Assuming photo is handled elsewhere
		        );

		        // Call the addNewPatient method from your query object to add the new patient
		        query.addNewPatient(patient);
		     // Clear the fields after successful addition
		        clearFields();
		        JOptionPane.showMessageDialog(null, "Patient added successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);

		    } catch (IllegalArgumentException ex) {
		        JOptionPane.showMessageDialog(null, "Invalid date format. Please enter the date in YYYY-MM-DD format.", "Error", JOptionPane.ERROR_MESSAGE);
		        txtDob.requestFocus();
		        txtDob.setText("");
		    }
	 }

	    private void clearFields() {
	    	txtFirstName.setText("");
	        txtLastName.setText("");
	        txtDob.setText("");
	        txtSsn.setText("");
	        txtPhoneNo.setText("");
	        txtAddress1.setText("");
	        txtAddress2.setText("");
	        txtCity.setText("");
	        txtZipCode.setText("");
	        txtAllergy1.setText("");
	        txtAllergy2.setText("");
	        txtAllergy3.setText("");
	        txtPhoto.setText("");
	    }
}
