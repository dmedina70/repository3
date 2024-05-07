package edu.pupr.project9;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class ModifyWindows extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField ssnTxt;
	private JTextField firstNameTxt;
	private JTextField lastNameTxt;
	private JTextField dobTxt;
	private JTextField phoneNumberTxt;
	private JTextField address1Txt;
	private JTextField cityTxt;
	private JTextField zipCodeTxt;
	private JTextField allergy1Txt;
	private JTextField allergy2Txt;
	private JTextField allergy3Txt;
	private JTextField address2Txt;
	private Patient results;
	
	PatientQuery query = new PatientQuery();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModifyWindows frame = new ModifyWindows();
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
	public ModifyWindows() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 757, 394);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("Search ssn");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ssn = JOptionPane.showInputDialog("Enter SSN to search");
				results = query.searchForPatientBySsn(ssn);
				if(results == null) {
					JOptionPane.showMessageDialog(null, "SSN not found!");
				}
				else {
					ssnTxt.setText(results.getSsn());
					firstNameTxt.setText(results.getFirstName());
					lastNameTxt.setText(results.getLastName());
					dobTxt.setText(results.getDob().toString());
					phoneNumberTxt.setText(results.getPhoneNumber());
					address1Txt.setText(results.getAddress1());
					cityTxt.setText(results.getCity());
					zipCodeTxt.setText(results.getZipcode());
					allergy1Txt.setText(results.getAllergy1());
					allergy2Txt.setText(results.getAllegry2());
					allergy3Txt.setText(results.getAllegry3());
					address2Txt.setText(results.getAddress2());;
					
				}
				
			}
		});
		
		JButton btnNewButton_1 = new JButton("Update");
		btnNewButton_1.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		     
		    
		        results.setFirstName(firstNameTxt.getText()); // Set first name
		        results.setLastName(lastNameTxt.getText()); // Set last name
		        results.setDob(Date.valueOf(dobTxt.getText())); // Set date of birth (ensure format is yyyy-mm-dd)
		        results.setPhoneNumber(phoneNumberTxt.getText()); // Set phone number
		        results.setAddress1(address1Txt.getText()); // Set address line 1
		        results.setAddress2(address2Txt.getText()); // Set address line 2
		        results.setCity(cityTxt.getText()); // Set city
		        results.setZipcode(zipCodeTxt.getText()); // Set zipcode
		        results.setAllergy1(allergy1Txt.getText()); // Set allergy 1
		        results.setAllegry2(allergy2Txt.getText()); // Set allergy 2
		        results.setAllegry3(allergy3Txt.getText()); // Set allergy 3
		        
		        // Assuming you have a method to handle the update with a patient object
		        updatePatientFromUI(results);
		    }
		});


		
		ssnTxt = new JTextField();
		ssnTxt.setEditable(false);
		ssnTxt.setColumns(10);
		
		firstNameTxt = new JTextField();
		firstNameTxt.setColumns(10);
		
		lastNameTxt = new JTextField();
		lastNameTxt.setColumns(10);
		
		dobTxt = new JTextField();
		dobTxt.setColumns(10);
		
		phoneNumberTxt = new JTextField();
		phoneNumberTxt.setColumns(10);
		
		address1Txt = new JTextField();
		address1Txt.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("SSN :");
		
		JLabel lblNewLabel_1 = new JLabel("First Name :");
		
		JLabel lblNewLabel_2 = new JLabel("Last Name :");
		
		JLabel lblNewLabel_3 = new JLabel("DOB :");
		
		JLabel lblNewLabel_4 = new JLabel("Phone Number :");
		
		JLabel lblNewLabel_5 = new JLabel("Addres 1 :");
		
		cityTxt = new JTextField();
		cityTxt.setColumns(10);
		
		zipCodeTxt = new JTextField();
		zipCodeTxt.setColumns(10);
		
		allergy1Txt = new JTextField();
		allergy1Txt.setColumns(10);
		
		allergy2Txt = new JTextField();
		allergy2Txt.setColumns(10);
		
		allergy3Txt = new JTextField();
		allergy3Txt.setColumns(10);
		
		address2Txt = new JTextField();
		address2Txt.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Addres 2 :");
		
		JLabel lblNewLabel_7 = new JLabel("City :");
		
		JLabel lblNewLabel_8 = new JLabel("Zip Code :");
		
		JLabel lblNewLabel_9 = new JLabel("allergy1");
		
		JLabel lblNewLabel_10 = new JLabel("allergy2");
		
		JLabel lblNewLabel_10_1 = new JLabel("allergy3");
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 6));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(10, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addGap(23)
										.addComponent(lblNewLabel))
									.addGroup(gl_contentPane.createSequentialGroup()
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(lblNewLabel_1))
									.addGroup(gl_contentPane.createSequentialGroup()
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(lblNewLabel_2)))
								.addComponent(lblNewLabel_3)
								.addComponent(lblNewLabel_4)
								.addComponent(lblNewLabel_5))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(firstNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(address1Txt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(phoneNumberTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(dobTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lastNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(ssnTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(91))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnNewButton)
							.addGap(43)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(14)
							.addComponent(lblNewLabel_10)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(allergy2Txt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(14)
							.addComponent(lblNewLabel_9)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(allergy1Txt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel_7)
								.addComponent(lblNewLabel_8)
								.addComponent(lblNewLabel_6))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(address2Txt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(cityTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(zipCodeTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(16)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnNewButton_1)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel_10_1)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(allergy3Txt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
					.addGap(27)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)
					.addGap(121))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(14)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(ssnTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel)
										.addComponent(lblNewLabel_6)
										.addComponent(address2Txt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(firstNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_1)
										.addComponent(lblNewLabel_7)
										.addComponent(cityTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(lastNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_2)
										.addComponent(lblNewLabel_8)
										.addComponent(zipCodeTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(dobTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_3))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(phoneNumberTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_4)))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(allergy1Txt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_9))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(allergy2Txt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_10))))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_5)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
									.addComponent(address1Txt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(allergy3Txt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblNewLabel_10_1)))))
					.addPreferredGap(ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addGap(56))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	public void updatePatientFromUI(Patient pantient) {
	    try {
	      // Assuming the 'query' object is an instance that has the updatePatientInformation method
	        query.updatePatientInformation(pantient);
	    } catch (Exception e) {
	        e.printStackTrace();
	        JOptionPane.showMessageDialog(null, "Error updating patient information: " + e.getMessage());
	    }
	}

}
