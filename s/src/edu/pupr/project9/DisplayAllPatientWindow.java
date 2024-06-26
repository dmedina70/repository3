package edu.pupr.project9;

import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class DisplayAllPatientWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	PatientQuery query = new PatientQuery();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DisplayAllPatientWindow frame = new DisplayAllPatientWindow();
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
	public DisplayAllPatientWindow() {
		setTitle("Display All Patient");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1310, 649);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		List<Patient> result = query.getAllPatient();
		String[] columnNames = {"ssn", "firstname", "lastname", "dob", "phone number", "address1", "address2", "city", "photo"};
		Object[][] rowData = new Object[result.size()][columnNames.length];

		// Populate rowData with data from the result list
		for (int i = 0; i < result.size(); i++) {
		    Patient patient = result.get(i);
		    rowData[i][0] = patient.getSsn();
		    rowData[i][1] = patient.getFirstName();
		    rowData[i][2] = patient.getLastName();
		    rowData[i][3] = patient.getDob();
		    rowData[i][4] = patient.getPhoneNumber();
		    rowData[i][5] = patient.getAddress1();
		    rowData[i][6] = patient.getAddress2();
		    rowData[i][7] = patient.getCity();
		    rowData[i][8] = patient.getPhoto();
		}

		// Create the DefaultTableModel with column names and rowData
		DefaultTableModel model = new DefaultTableModel(rowData, columnNames);


		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 1243, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(31, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 460, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(129, Short.MAX_VALUE))
		);
		
		table = new JTable(model);
		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
	}
}
