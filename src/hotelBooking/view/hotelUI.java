package hotelBooking.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import hotelBooking.model.Registration;
import hotelBookingJDBC.DaoImpl;

public class hotelUI {

	private JFrame frmHotelBooking;
	private JTextField custIdTF;
	private JTextField custNameTF;
	private JTextField paytermTF;
	private JTextField addressTF;
	private JTextField companyTF;
	private JButton nextBtn;
	private JButton previousBtn;
	private JButton addBtn;
	private JButton updateBtn;
	private JButton deleteBtn;
	private JButton resetBtn;
	private JButton firstBtn;
	private JButton lastBtn;
	private JButton updateBtn_1;
	private JLabel companyLbl_2;
	private JTextField textField_1;
	private JLabel companyLbl_3;
	private JTextField textField_2;
	private JLabel companyLbl_4;
	private JTextField textField_3;
	private JLabel companyLbl_5;
	private JTextField textField_4;
	private CustListener custListener;
	private Registration reg;
	private JTextField type_1;
	private JButton deleteBtn_1;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					hotelUI window = new hotelUI();
					window.frmHotelBooking.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 *
	 * @throws IOException
	 */
	public hotelUI() throws IOException {
		reg = new Registration();
		custListener = new CustListener();
		initialize();
	}

	/**
	 * Initialize the contents of the frame. Sets all of the components and linked
	 * to an action listener that handles the control
	 *
	 * @throws IOException
	 */
	private void initialize() throws IOException {
		frmHotelBooking = new JFrame();
		frmHotelBooking.setBounds(100, 100, 570, 500);
		frmHotelBooking.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmHotelBooking.getContentPane().setLayout(null);
//		 String path = "/Users/jayanth/Desktop/blonde.jpg";
//	        File file = new File(path);
//	        BufferedImage image = ImageIO.read(file);
//
//	        JLabel label1 = new JLabel(new ImageIcon(image.getScaledInstance(500, 500, 100)));
//
//		 frame.setContentPane(label1);

		JLabel name = new JLabel("First Name:");
		name.setBounds(15, 41, 78, 16);
		frmHotelBooking.getContentPane().add(name);

		custIdTF = new JTextField();
		custIdTF.setBounds(107, 39, 143, 22);
		frmHotelBooking.getContentPane().add(custIdTF);

		custIdTF.setColumns(10);

		JLabel address = new JLabel("Last Name:");
		address.setBounds(286, 41, 77, 16);
		frmHotelBooking.getContentPane().add(address);

		custNameTF = new JTextField();
		custNameTF.setBounds(369, 39, 148, 22);
		custNameTF.setColumns(10);
		frmHotelBooking.getContentPane().add(custNameTF);

		JLabel location = new JLabel("Arrival Date");
		location.setBounds(15, 77, 78, 16);
		frmHotelBooking.getContentPane().add(location);

		paytermTF = new JTextField();
		paytermTF.setBounds(106, 71, 144, 22);
		paytermTF.setColumns(10);
		frmHotelBooking.getContentPane().add(paytermTF);

		JLabel number = new JLabel("Arrival Time");
		number.setBounds(285, 77, 78, 16);
		frmHotelBooking.getContentPane().add(number);

		addressTF = new JTextField();
		addressTF.setBounds(370, 71, 147, 22);
		addressTF.setColumns(10);
		frmHotelBooking.getContentPane().add(addressTF);

		JLabel subject = new JLabel("No of Adults :");
		subject.setBounds(15, 103, 78, 16);
		frmHotelBooking.getContentPane().add(subject);

		companyTF = new JTextField();
		companyTF.setBounds(107, 103, 143, 22);
		companyTF.setColumns(10);
		frmHotelBooking.getContentPane().add(companyTF);

		updateBtn = new JButton("UPDATE");
		updateBtn.setFont(new Font("Tahoma", Font.BOLD, 13));
		updateBtn.setBounds(281, 364, 102, 25);
		frmHotelBooking.getContentPane().add(updateBtn);
		updateBtn.addActionListener(custListener);

		deleteBtn = new JButton("DELETE");
		deleteBtn.setFont(new Font("Tahoma", Font.BOLD, 13));
		deleteBtn.setBounds(281, 399, 102, 25);
		deleteBtn.addActionListener(custListener);
		frmHotelBooking.getContentPane().add(deleteBtn);

		JLabel email = new JLabel("Contact Email:");
		email.setBounds(16, 158, 119, 16);
		frmHotelBooking.getContentPane().add(email);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(143, 157, 376, 22);
		frmHotelBooking.getContentPane().add(textField_1);

		JLabel type = new JLabel("Contact Number :");
		type.setBounds(15, 203, 120, 16);
		frmHotelBooking.getContentPane().add(type);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(143, 199, 376, 22);
		frmHotelBooking.getContentPane().add(textField_2);

		JLabel created = new JLabel("Room Type :");
		created.setBounds(286, 103, 77, 16);
		frmHotelBooking.getContentPane().add(created);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(368, 103, 149, 22);
		frmHotelBooking.getContentPane().add(textField_3);

		JLabel date = new JLabel("Created Date:");
		date.setBounds(16, 241, 119, 16);
		frmHotelBooking.getContentPane().add(date);

		addBtn =new JButton("ADD");
		addBtn.setFont(new Font("Tahoma", Font.BOLD, 13));
		addBtn.setBounds(143, 364, 107, 25);
		frmHotelBooking.getContentPane().add(addBtn);
		addBtn.addActionListener(custListener);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(141, 241, 376, 22);
		frmHotelBooking.getContentPane().add(textField_4);

		updateBtn_1 = new JButton("GET");

		updateBtn_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		updateBtn_1.setBounds(143, 399, 107, 25);
		updateBtn_1.addActionListener(custListener);
		frmHotelBooking.getContentPane().add(updateBtn_1);

		resetBtn = new JButton("RESET");

		resetBtn.setFont(new Font("Tahoma", Font.BOLD, 13));
		resetBtn.setBounds(193, 329, 173, 25);
		frmHotelBooking.getContentPane().add(resetBtn);
		
		JLabel lblContactDescription = new JLabel("Contact Description");
		lblContactDescription.setBounds(16, 285, 119, 16);
		frmHotelBooking.getContentPane().add(lblContactDescription);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(141, 284, 376, 22);
		frmHotelBooking.getContentPane().add(textField);
		resetBtn.addActionListener(custListener);
		frmHotelBooking.setLocationRelativeTo(null);
		frmHotelBooking.setResizable(false);
		frmHotelBooking.setTitle("Hotel Booking");

	}

	class CustListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent ev) {
			String ac = ev.getActionCommand();

			switch (ac) {

			case "ADD":
				addCust();
				break;
			case "UPDATE":
				updateCust();
				break;
			case "GET":
				getCust();
				break;
			case "DELETE":
				deleteCust();
				break;
			case "RESET":
				resetForm();

			}
		}

//          Add customer record to database from form fields
		private void addCust() {

			reg.setFirstName(custIdTF.getText());
			reg.setLastName(custNameTF.getText());
			reg.setArrivalDate(paytermTF.getText());
			reg.setArrivalTime(addressTF.getText());
			reg.setNoOfAdults(companyTF.getText());
			reg.setRoomType(textField.getText());
			reg.setContactEmail(textField_1.getText());
			reg.setContactNumber(textField_2.getText());
			reg.setCreatedDate(textField_3.getText());
			reg.setContactDescription(textField_4.getText());
			if (DaoImpl.saveRegistration(reg) == "Success") {
				JOptionPane.showMessageDialog(null, "Reservation Successful", null, JOptionPane.INFORMATION_MESSAGE);

			} else {
				JOptionPane.showMessageDialog(null, "Reservation Unsucessful", null, JOptionPane.INFORMATION_MESSAGE);
			}

		}

		private void updateCust() {



			reg.setFirstName(custIdTF.getText());
			reg.setLastName(custNameTF.getText());
			reg.setArrivalDate(paytermTF.getText());
			reg.setArrivalTime(addressTF.getText());
			reg.setNoOfAdults(companyTF.getText());
			reg.setRoomType(textField.getText());
			reg.setContactEmail(textField_1.getText());
			reg.setContactNumber(textField_2.getText());
			reg.setCreatedDate(textField_3.getText());
			reg.setContactDescription(textField_4.getText());

			if (DaoImpl.updateRegistration(reg) == "Success") {
				JOptionPane.showMessageDialog(null, "Updated Successfully", null, JOptionPane.INFORMATION_MESSAGE);

			} else {
				JOptionPane.showMessageDialog(null, "Failed to Update", null, JOptionPane.INFORMATION_MESSAGE);
			}

		}

		private void getCust() {

		     

		      String result = JOptionPane.showInputDialog(
		               "Please Enter Name ");

			if(custIdTF.getText() != null) {

				Registration reg = DaoImpl.getRegistrationByType(result);
				custIdTF.setText(reg.getFirstName());
				custNameTF.setText(reg.getLastName());
				paytermTF.setText(reg.getArrivalDate());
				addressTF.setText(reg.getArrivalTime());
				companyTF.setText(reg.getNoOfAdults());
				textField.setText(reg.getRoomType());
				textField_1.setText(reg.getContactEmail());
				textField_2.setText(reg.getContactNumber());
				textField_3.setText(reg.getCreatedDate());
				textField_4.setText(reg.getContactDescription());
			}
		}

		private void deleteCust() {

		
			String result = JOptionPane.showInputDialog(
		               "Please Enter Name ");

			if(result != null) {

			if (DaoImpl.deleteRegistrationbyId(result) == "Records Deleted Succssfully") {
				JOptionPane.showMessageDialog(null, "Records Deleted Succssfully", null,
						JOptionPane.INFORMATION_MESSAGE);

			} else {
				JOptionPane.showMessageDialog(null, "Failed to Delete", null, JOptionPane.INFORMATION_MESSAGE);

			 }
			}
		}

		private void resetForm() {

			custIdTF.setText("");
			custNameTF.setText("");
			paytermTF.setText("");
			addressTF.setText("");
			companyTF.setText("");
			textField.setText("");
			textField_1.setText("");
			textField_2.setText("");
			textField_3.setText("");
			textField_4.setText("");

		}

	}
}
