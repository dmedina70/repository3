package edu.pupr.project9;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class SearchPatientWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtSsn;
	private JTextField txtFirstName;
	private JTextField txtLastName;
	private JTextField txtPhoneNo;
	private JTextField txtAddress1;
	private JTextField txtAddress2;
	private JTextField txtCity;
	private JTextField txtZipCode;
	private JTextField txtAllergy1;
	private JTextField txtAllergy2;
	private JLabel lblAllergy1;
	private JLabel lblAllergy2;
	private JLabel lblAllergy3;
	private JLabel lblPhoto;
	private JTextField txtAllergy3;
	private JTextField txtPhoto;
	PatientQuery query = new PatientQuery();
	private JLabel lblNewLabel_1;
	private JTextField txtDob;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchPatientWindow frame = new SearchPatientWindow();
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
	public SearchPatientWindow() {
		setTitle("Search Patient");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 927, 429);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("Ask for ssn");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String ssn = JOptionPane.showInputDialog("Enter SSN to search");
				Patient results = query.searchForPatientBySsn(ssn);
				
				// Check if the user pressed cancel or closed the dialog
			    if (ssn == null) {
			        return; // Do nothing
			    }
				if(results == null) {
					JOptionPane.showMessageDialog(null, "SSN not found!");
				}
				else {
				
					txtSsn.setText(results.getSsn());
					txtFirstName.setText(results.getFirstName());
					txtLastName.setText(results.getLastName());
					txtDob.setText(results.getDob().toString());
					txtPhoneNo.setText(results.getPhoneNumber());
					txtAddress1.setText(results.getAddress1());
					txtCity.setText(results.getCity());
					txtZipCode.setText(results.getZipcode());
					txtAllergy1.setText(results.getAllergy1());
					txtAllergy2.setText(results.getAllergy2());
					txtAllergy3.setText(results.getAllergy3());
					txtAddress2.setText(results.getAddress2());;
					txtPhoto.setText(results.getPhoto());
					
			}
				
			}
		});
		
		txtSsn = new JTextField();
		txtSsn.setEnabled(false);
		txtSsn.setColumns(10);
		
		JLabel lblSsn = new JLabel("SSN:");
		
		txtFirstName = new JTextField();
		txtFirstName.setEnabled(false);
		txtFirstName.setColumns(10);
		
		txtLastName = new JTextField();
		txtLastName.setEnabled(false);
		txtLastName.setColumns(10);
		
		txtPhoneNo = new JTextField();
		txtPhoneNo.setEnabled(false);
		txtPhoneNo.setColumns(10);
		
		txtAddress1 = new JTextField();
		txtAddress1.setEnabled(false);
		txtAddress1.setColumns(10);
		
		txtAddress2 = new JTextField();
		txtAddress2.setEnabled(false);
		txtAddress2.setColumns(10);
		
		txtCity = new JTextField();
		txtCity.setEnabled(false);
		txtCity.setColumns(10);
		
		JLabel lblFirstName = new JLabel("First Name:");
		
		JLabel lblLastName = new JLabel("Last Name:");
		
		JLabel lblPhoneNumber = new JLabel("Phone Number:");
		
		JLabel lblAddress1 = new JLabel("Address 1:");
		
		JLabel lblAddress2 = new JLabel("Address2:");
		
		JLabel lblCity = new JLabel("City:");
		
		txtZipCode = new JTextField();
		txtZipCode.setEnabled(false);
		txtZipCode.setColumns(10);
		
		txtAllergy1 = new JTextField();
		txtAllergy1.setEnabled(false);
		txtAllergy1.setColumns(10);
		
		txtAllergy2 = new JTextField();
		txtAllergy2.setEnabled(false);
		txtAllergy2.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Zip Code:");
		
		lblAllergy1 = new JLabel("Allergy1:");
		
		lblAllergy2 = new JLabel("Allergy2:");
		
		lblAllergy3 = new JLabel("Allergy3:");
		
		lblPhoto = new JLabel("Photo:");
		
		txtAllergy3 = new JTextField();
		txtAllergy3.setEnabled(false);
		txtAllergy3.setColumns(10);
		
		txtPhoto = new JTextField();
		txtPhoto.setEnabled(false);
		txtPhoto.setColumns(10);
		
		lblNewLabel_1 = new JLabel("Date Of Birth:");
		
		txtDob = new JTextField();
		txtDob.setEnabled(false);
		txtDob.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblSsn)
										.addComponent(lblFirstName)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
											.addComponent(lblNewLabel_1)
											.addComponent(lblLastName)))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(txtSsn, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(txtFirstName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(txtLastName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(txtDob, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblPhoneNumber)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtPhoneNo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addGap(94)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblAllergy1)
								.addComponent(lblAddress2)
								.addComponent(lblNewLabel)
								.addComponent(lblCity)
								.addComponent(lblAddress1))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(txtAddress2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtZipCode, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtAllergy1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtCity, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtAddress1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(123)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblPhoto, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblAllergy3, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblAllergy2))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(txtAllergy2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtAllergy3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtPhoto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(38)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(207, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(24)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSsn)
						.addComponent(lblAllergy2)
						.addComponent(lblAddress1)
						.addComponent(txtAddress1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtSsn, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtAllergy2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFirstName)
						.addComponent(lblAllergy3)
						.addComponent(txtAddress2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblAddress2)
						.addComponent(txtFirstName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtAllergy3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLastName)
						.addComponent(lblPhoto)
						.addComponent(txtPhoto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtCity, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCity)
						.addComponent(txtLastName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(txtZipCode, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1)
						.addComponent(txtDob, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAllergy1)
						.addComponent(txtAllergy1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPhoneNumber)
						.addComponent(txtPhoneNo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(60)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(90, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	
}
