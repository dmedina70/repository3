package edu.pupr;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JInternalFrame;
import java.awt.Panel;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.UIManager;
import javax.swing.JRadioButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import java.awt.Choice;
import javax.swing.JButton;
import java.awt.Canvas;
import javax.swing.ImageIcon;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ButtonGroup;
import javax.swing.border.EtchedBorder;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EmployeeFrame extends JFrame {
	
	private static final DecimalFormat df = new DecimalFormat("0.00");
	
	private ArrayList<Employee> employeeList;

	private static final long serialVersionUID = 1L;
	private JComboBox<String> saludationComboBox;
	private JPanel contentPane;
	private JTextField hourPayText;
	private JTextField weekPaymentText;
	private JTextField yearPaymentText;
	private JTextField idText;
	private JTextField ssnText;
	private JTextField firstNameText;
	private JTextField lastNameText;
	private JTextField maidenNameText;
	private JLabel lblYearPayment;
	private JLabel lblWeekPayment;
	private JLabel lblHourPay;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	
	@SuppressWarnings("unused")
	//Validate fields are not empty
	private boolean validateFields() {
	    if (idText.getText().isEmpty()) {
	        showMessage("ID field is empty");
	        return false;
	    } else if (firstNameText.getText().isEmpty()) {
	        showMessage("First Name field is empty");
	        return false;
	    } else if (lastNameText.getText().isEmpty()) {
	        showMessage("Last Name field is empty");
	        return false;
	    } else if (maidenNameText.getText().isEmpty()) {
	        showMessage("Maiden Name field is empty");
	        return false;
	    } else if (hourPayText.getText().isEmpty()) {
	        showMessage("Hourly Pay field is empty");
	        return false;
	    } else if (buttonGroup.getSelection() == null) {
	        showMessage("Please select an earning type");
	        return false;
	    }
	    return true;
	}

	// Method to display error messages
	private void showMessage(String message) {
	    JOptionPane.showMessageDialog(new JFrame(), message, "Dialog", JOptionPane.ERROR_MESSAGE);
	}
	
	private void createEmployee() {
	    try {
	        // Parse input fields to create Employee object
	        int id = Integer.parseInt(idText.getText());
	        String ssn = ssnText.getText();
	        String saludation = (String) saludationComboBox.getSelectedItem();
	        String firstName = firstNameText.getText();
	        String lastName = lastNameText.getText();
	        String maidenName = maidenNameText.getText();
	        int earningType = buttonGroup.getSelection().getMnemonic();
	        double hourPay = Double.parseDouble(hourPayText.getText());

	        // Check if the ID already exists in the employeeList
	        boolean idExists = false;
	        for (Employee emp : employeeList) {
	            if (emp.getId() == id) {
	                idExists = true;
	                break;
	            }
	        }

	        if (idExists) {
	            JOptionPane.showMessageDialog(new JFrame(), "Employee with ID " + id + " already exists.", "Duplicate ID", JOptionPane.ERROR_MESSAGE);
	        } else {
	            // Create the Employee object
	            Employee employee = new Employee(id, ssn, saludation, firstName, lastName, maidenName, earningType, hourPay);

	            // Add the Employee object to the list
	            employeeList.add(employee);

	            // Reset input fields
	            idText.setText("");
	            saludationComboBox.setSelectedIndex(0);
	            firstNameText.setText("");
	            lastNameText.setText("");
	            maidenNameText.setText("");
	            buttonGroup.clearSelection();
	            hourPayText.setText("");
	            weekPaymentText.setText("");
	            yearPaymentText.setText("");
	            ssnText.setText("");

	            // Print employee information
	            System.out.println("Employee added: " + employee.toString());

	            // Display success message
	            JOptionPane.showMessageDialog(new JFrame(), "Information was entered successfully", "Dialog", JOptionPane.INFORMATION_MESSAGE);
	        }
	    } catch (NumberFormatException ex) {
	        JOptionPane.showMessageDialog(new JFrame(), "Invalid input. Please enter valid numeric values.", "Dialog", JOptionPane.ERROR_MESSAGE);
	    }
	}


	  
	  private void hideHourlyComponent() {
		  //hide the componet when salary radio is selected
		  weekPaymentText.setVisible(false);
	      yearPaymentText.setVisible(false);
	      lblWeekPayment.setVisible(false);
	      lblYearPayment.setVisible(false);
	      lblHourPay.setText("Salary:");
	      hourPayText.setText(null);
	      weekPaymentText.setText("");
	        yearPaymentText.setText("");

	      
	  }
	  
	  private void unhideHourlyComponet() {
		//unhide the componet when salary radio is unselected
		  weekPaymentText.setVisible(true);
	      yearPaymentText.setVisible(true);
	      lblWeekPayment.setVisible(true);
	      lblYearPayment.setVisible(true);
	      lblHourPay.setText("Hour Pay:");
	      hourPayText.setText(null);
	      weekPaymentText.setText("");
	        yearPaymentText.setText("");

	  }
	  
	

	


	public EmployeeFrame() {
		
		employeeList = new ArrayList<>();
		
		
		setTitle("Add Employee");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 557, 514);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 120, 215), 6));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		hourPayText = new JTextField();
		hourPayText.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
			    if(hourPayText.getText().isEmpty()) {
			        // Handle case where hourPayText is empty
			    } else {
			        try {
			            double hourPay = Double.parseDouble(hourPayText.getText());
			            if (hourPay <= 0) {
			                JOptionPane.showMessageDialog(new JFrame(), "Number can't be less than or equal to 0", "Dialog", JOptionPane.ERROR_MESSAGE);
			                hourPayText.setText("");
			                weekPaymentText.setText("");
						    yearPaymentText.setText("");
			            } else {
			                double weekPayment = hourPay * 40;
			                double yearPayment = weekPayment * 52;
			                weekPaymentText.setText(String.valueOf(df.format(weekPayment)));
			                yearPaymentText.setText(String.valueOf(df.format(yearPayment)));
			            }
			        } catch (NumberFormatException ex) {
			            JOptionPane.showMessageDialog(new JFrame(), "Invalid input. Please enter a valid number.", "Dialog", JOptionPane.ERROR_MESSAGE);
			        }
			    }
			}
		});
		hourPayText.setColumns(10);
		
		 lblHourPay = new JLabel("Hour Pay:");
		
		 lblWeekPayment = new JLabel("<html><p>Week</br> Payment:</p></html>");
		lblWeekPayment.setHorizontalAlignment(SwingConstants.LEFT);
		
		weekPaymentText = new JTextField();
		weekPaymentText.setEnabled(false);
		weekPaymentText.setColumns(10);
		
		lblYearPayment = new JLabel("<html><p>Year</br> Payment:</p></html>");
		lblYearPayment.setHorizontalAlignment(SwingConstants.LEFT);
		
		yearPaymentText = new JTextField();
		yearPaymentText.setEnabled(false);
		yearPaymentText.setColumns(10);
		GroupLayout gl_panel_1_1 = new GroupLayout(panel_1_1);
		gl_panel_1_1.setHorizontalGroup(
			gl_panel_1_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1_1.createSequentialGroup()
					.addGap(20)
					.addGroup(gl_panel_1_1.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel_1_1.createSequentialGroup()
							.addComponent(lblHourPay)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(hourPayText, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1_1.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_1_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1_1.createSequentialGroup()
									.addComponent(lblYearPayment, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(yearPaymentText, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_1_1.createSequentialGroup()
									.addComponent(lblWeekPayment, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(weekPaymentText, 0, 0, Short.MAX_VALUE)))))
					.addContainerGap(61, Short.MAX_VALUE))
		);
		gl_panel_1_1.setVerticalGroup(
			gl_panel_1_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblHourPay)
						.addComponent(hourPayText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1_1.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblWeekPayment, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
						.addComponent(weekPaymentText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1_1.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblYearPayment, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
						.addComponent(yearPaymentText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_1_1.setLayout(gl_panel_1_1);
		
		JLabel lblNewLabel_1 = new JLabel("ID:");
		
		idText = new JTextField();
		idText.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Saludation");
		
		saludationComboBox = new JComboBox();
		saludationComboBox.setModel(new DefaultComboBoxModel(new String[] {"Darth", "Sr", "Mr", "Ing", "Dr"}));
		
		JLabel lblNewLabel_2_1 = new JLabel("SSN:");
		
		ssnText = new JTextField();
		ssnText.setColumns(10);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("First Name:");
		
		JLabel lblNewLabel_2_1_2 = new JLabel("Last Name:");
		
		JLabel lblNewLabel_2_1_3 = new JLabel("Mother 's Last Name:");
		
		firstNameText = new JTextField();
		firstNameText.setColumns(10);
		
		lastNameText = new JTextField();
		lastNameText.setColumns(10);
		
		maidenNameText = new JTextField();
		maidenNameText.setColumns(10);
		
		
		
		
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			if(validateFields()) {
				createEmployee();
			}

			   
			}

		});
		
		
		
		
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 EmployeeDriver.closeFrame();
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(24)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(27)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel_2_1_2)
									.addGap(18)
									.addComponent(lastNameText, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel_1)
									.addGap(34)
									.addComponent(idText, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel_2_1_3)
									.addGap(18)
									.addComponent(maidenNameText, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
									.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
										.addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(ssnText, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE))
									.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
										.addComponent(lblNewLabel_2_1_1)
										.addGap(18)
										.addComponent(firstNameText, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel_2)
									.addGap(18)
									.addComponent(saludationComboBox, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(41)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(panel_1_1, GroupLayout.PREFERRED_SIZE, 281, GroupLayout.PREFERRED_SIZE)
								.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
									.addGap(31)
									.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
									.addGap(32)))))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(19)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_1)
								.addComponent(idText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_2)
								.addComponent(saludationComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_2_1)
								.addComponent(ssnText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_2_1_1)
								.addComponent(firstNameText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_2_1_2)
								.addComponent(lastNameText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_2_1_3)
								.addComponent(maidenNameText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addGap(32)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(panel_1_1, GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\user\\Downloads\\Jonathan-Rey-Star-Wars-Characters-Vader-02.128.png"));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(37, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(lblNewLabel_3, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
		);
		panel.setLayout(gl_panel);
		
		JRadioButton salariedRadio = new JRadioButton("Salaried");
		salariedRadio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hideHourlyComponent();
			}
		});
		salariedRadio.setMnemonic(1);
		buttonGroup.add(salariedRadio);
		salariedRadio.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JRadioButton hourlyRadio = new JRadioButton("Hourly");
		hourlyRadio.setSelected(true);
		hourlyRadio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				unhideHourlyComponet();
			}
		});
		hourlyRadio.setMnemonic(2);
		buttonGroup.add(hourlyRadio);
		hourlyRadio.setFont(new Font("Tahoma", Font.BOLD, 11));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(hourlyRadio)
						.addComponent(salariedRadio))
					.addContainerGap(52, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(20)
					.addComponent(salariedRadio)
					.addGap(18)
					.addComponent(hourlyRadio)
					.addContainerGap(40, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		contentPane.setLayout(gl_contentPane);
		
		
		
	}
	
	
	
}

