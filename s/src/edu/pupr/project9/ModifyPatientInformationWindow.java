package edu.pupr.project9;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.net.URL;
import java.sql.Date;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.Color;

public class ModifyPatientInformationWindow extends JFrame {

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
	private JButton btnUpdate;
	private JButton btnUpdatePhoto;
	private Patient results;
	private String photo;
	
	PatientQuery query = new PatientQuery();
	private JTextField txtPhoto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModifyPatientInformationWindow frame = new ModifyPatientInformationWindow();
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
	public ModifyPatientInformationWindow() {
		setTitle("Modify Patient Information");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 867, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JButton btnSearchSsn = new JButton("Search ssn");
		btnSearchSsn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				String ssn = JOptionPane.showInputDialog("Enter SSN to search");
				results = query.searchForPatientBySsn(ssn);
				
				// Check if the user pressed cancel or closed the dialog
			    if (ssn == null) {
			        return; // Do nothing
			    }
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
					allergy2Txt.setText(results.getAllergy2());
					allergy3Txt.setText(results.getAllergy3());
					address2Txt.setText(results.getAddress2());;
					txtPhoto.setText(photo);
					
					btnUpdate.setVisible(true);
					btnUpdatePhoto.setVisible(true);
					
				}
				
			}
		});
		
		btnUpdate = new JButton("Update");
		btnUpdate.setVisible(false);
		btnUpdate.addActionListener(new ActionListener() {
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
			        results.setAllergy2(allergy2Txt.getText()); // Set allergy 2
			        results.setAllergy3(allergy3Txt.getText()); // Set allergy 3
			        results.setPhoto(photo); //Set Photo
			        
			        
			        updatePatientFromUI(results);
			        
			        btnUpdate.setVisible(false);
			        btnUpdatePhoto.setVisible(false);
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
		
	    btnUpdatePhoto = new JButton("Update Photo");
	    btnUpdatePhoto.setVisible(false);
		btnUpdatePhoto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter(
				    "PNG File", "png");
				chooser.setFileFilter(filter);
				int returnVal = chooser.showOpenDialog(null);
				if(returnVal == JFileChooser.APPROVE_OPTION) {
				       photo = chooser.getSelectedFile().getName();
				       txtPhoto.setText(photo);
				}
			}
		});
		
		JLabel lblPhoto = new JLabel("Photo");
		
		txtPhoto = new JTextField();
		txtPhoto.setEnabled(false);
		txtPhoto.setColumns(10);
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
							.addComponent(btnSearchSsn)
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
								.addComponent(lblNewLabel_6)
								.addComponent(lblNewLabel_8))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(address2Txt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(50)
									.addComponent(lblPhoto)
									.addGap(18)
									.addComponent(txtPhoto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(7)
									.addComponent(btnUpdatePhoto))
								.addComponent(cityTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(zipCodeTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(16)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnUpdate)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel_10_1)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(allergy3Txt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
					.addGap(45))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(25)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(ssnTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel)
								.addComponent(lblNewLabel_6)
								.addComponent(address2Txt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPhoto)
								.addComponent(btnUpdatePhoto)
								.addComponent(txtPhoto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
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
							.addComponent(lblNewLabel_10_1)))
					.addPreferredGap(ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSearchSsn)
						.addComponent(btnUpdate))
					.addGap(56))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	private void resetFields() {
	    ssnTxt.setText("");
	    firstNameTxt.setText("");
	    lastNameTxt.setText("");
	    dobTxt.setText("");
	    phoneNumberTxt.setText("");
	    address1Txt.setText("");
	    address2Txt.setText("");
	    cityTxt.setText("");
	    zipCodeTxt.setText("");
	    allergy1Txt.setText("");
	    allergy2Txt.setText("");
	    allergy3Txt.setText("");
	}
	
	public void updatePatientFromUI(Patient pantient) {
	    try {
	        query.updatePatientInformation(pantient);
	    } catch (Exception e) {
	        e.printStackTrace();
	        JOptionPane.showMessageDialog(null, "Error updating patient information: " + e.getMessage());
	    }
	}
}
