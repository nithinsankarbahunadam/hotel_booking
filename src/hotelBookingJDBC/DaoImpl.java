package hotelBookingJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.jdbc.CallableStatement;

import hotelBooking.model.Registration;

public class DaoImpl {

	static String dbURL = "jdbc:mysql://localhost:3306/hotel";
	static String username = "root";
	static String password = "12569";

	public static String saveRegistration(Registration reg) {

		String response = null;
		int status = 0;
		String BLOG = "Insert into hotel.hotel" + "(id, First_Name, Last_Name, "
				+ "Arrival_Date,Arrival_Time,No_of_Adults,Room_Type,Contact_Email,Contact_Number,Created_Date,Contact_Description,notes) "
				+ "values (?,?,?,?,?,?,?,?,?,?,?,?)";
		try (Connection conn = DriverManager.getConnection(dbURL, username, password);
				java.sql.CallableStatement cs = conn.prepareCall(BLOG);) {

			cs.setInt(1, reg.getId());
			cs.setString(2, reg.getFirstName());
			cs.setString(3, reg.getLastName());
			cs.setString(4, reg.getArrivalDate());
			cs.setString(5, reg.getArrivalTime());
			cs.setString(6, reg.getNoOfAdults());
			cs.setString(7, reg.getRoomType());
			cs.setString(8, reg.getContactEmail());
			cs.setString(9, reg.getContactNumber());
			cs.setString(10, reg.getCreatedDate());
			cs.setString(11, reg.getContactDescription());
			cs.setString(12, String.valueOf("-----"));
			status = cs.executeUpdate();

			if (status > 0) {
				response = "Success";
			} else {
				response = "Failure";
			}

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return response;
	}

	public static List<Registration> getAllRegistrations() {
		// TODO Auto-generated method stub
		String query = "select * from hotel.hotel order by created_date desc";

		List<Registration> list = null;
		try (Connection conn = DriverManager.getConnection(dbURL, username, password);
				PreparedStatement ps = conn.prepareStatement(query);) {
			list = new ArrayList<Registration>();

			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {

					Registration reg = new Registration();
					reg.setId(rs.getInt("id"));
					reg.setFirstName(rs.getString("First_Name"));
					reg.setLastName(rs.getString("Last_Name"));
					reg.setArrivalDate(rs.getString("Arrival_Date"));
					reg.setArrivalTime(rs.getString("Arrival_Time"));
					reg.setNoOfAdults(rs.getString("No_of_Adults"));
					reg.setRoomType(rs.getString("Room_Type"));
					reg.setContactEmail(rs.getString("Contact_email"));
					reg.setContactNumber(rs.getString("Contact_Number"));
					reg.setCreatedDate(rs.getString("Created_Date"));
					reg.setCreatedDate(rs.getString("Contact_Description"));
					list.add(reg);

				}
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return list;
	}

	public static String updateRegistration(Registration reg) {

		String response = null;
		int status = 0;
		String BLOG = "Update hotel.hotel SET  First_Name=?, Last_Name=?, \r\n"
				+ "Arrival_Date=?, Arrival_Time=?, No_of_Adults=?, Room_Type=?,Contact_Email=?, Contact_Number=?, Contact_Description=? where First_Name=?";
		try (Connection conn = DriverManager.getConnection(dbURL, username, password);
				java.sql.CallableStatement cs = conn.prepareCall(BLOG);) {

			cs.setString(1, reg.getFirstName());
			cs.setString(2, reg.getLastName());
			cs.setString(3, reg.getArrivalDate());
			cs.setString(4, reg.getArrivalTime());
			cs.setString(5, reg.getNoOfAdults());
			cs.setString(6, reg.getRoomType());
			cs.setString(7, reg.getContactEmail());
			cs.setString(8, reg.getContactNumber());
			cs.setString(9, reg.getCreatedDate());
			cs.setString(10, reg.getFirstName());
			
			status = cs.executeUpdate();

			if (status > 0) {
				response = "Success";
			} else {
				response = "Failure";
			}

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return response;
	}

	public static Registration getRegistrationByType(String type) {

		String query = "select * from hotel.hotel where First_Name=?";

		Registration reg = null;
		try (Connection conn = DriverManager.getConnection(dbURL, username, password);
				PreparedStatement ps = conn.prepareStatement(query);) {

			ps.setString(1, type);

			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {

					reg = new Registration();
					reg.setId(rs.getInt("id"));
					reg.setFirstName(rs.getString("First_Name"));
					reg.setLastName(rs.getString("Last_Name"));
					reg.setArrivalDate(rs.getString("Arrival_Date"));
					reg.setArrivalTime(rs.getString("Arrival_Time"));
					reg.setNoOfAdults(rs.getString("No_of_Adults"));
					reg.setRoomType(rs.getString("Room_Type"));
					reg.setContactEmail(rs.getString("Contact_Email"));
					reg.setContactNumber(rs.getString("Contact_Number"));
					reg.setCreatedDate(rs.getString("Created_Date"));
					reg.setContactDescription(rs.getString("Contact_Description"));

				}
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return reg;
	}

	public static String deleteRegistrationbyId(String type) {

		String response = null;
		int status = 0;
		String BLOG = "delete from hotel.hotel where First_Name=?";
		try (Connection conn = DriverManager.getConnection(dbURL, username, password);
				java.sql.CallableStatement cs = conn.prepareCall(BLOG);) {

			cs.setString(1, type);

			status = cs.executeUpdate();

			if (status > 0) {
				response = "Records Deleted Succssfully";
			} else {
				response = "Fail to delete";
			}

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return response;
	}

}
