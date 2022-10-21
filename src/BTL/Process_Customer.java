package BTL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

public class Process_Customer {
	Connection cn;
	
	public static Connection getCon() {
		Connection cn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost/hotel_management", "root", "06102002");
		}
		catch(ClassNotFoundException | SQLException e) {
			
		}
		return cn;
	}
	
	public ArrayList<String> getListNameRoom(){
		Connection cn = getCon();
		String sql = "Select nameRoom from hotel_management.room";
		ArrayList<String> lsr = new ArrayList<>();
		try {
			PreparedStatement ps = (PreparedStatement)cn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				lsr.add(rs.getString("nameRoom"));
			}
		}
		catch(SQLException e) {
			
		}
		return lsr;
	}
	
	public ArrayList<Vector<Object>> getListCustomer(){
		Connection cn = getCon();
		String sql = "Select idCustomer, nameCustomer, identityCardCustomer, nationalityCustomer, genderCustomer, ageCustomer, "
				+ "contactCustomer, room.nameRoom, dateCheckIn, dateCheckOut from hotel_management.customer join hotel_management.room on customer.idRoom = room.idRoom";
		ArrayList<Vector<Object>> lsc = new ArrayList<>();
		try {
			PreparedStatement ps = (PreparedStatement)cn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Vector<Object> c = new Vector<>();
				c.add(rs.getString("idCustomer"));
				c.add(rs.getString("nameCustomer"));
				c.add(rs.getString("identityCardCustomer"));
				c.add(rs.getString("nationalityCustomer"));
				c.add(rs.getString("genderCustomer"));
				c.add(rs.getInt("ageCustomer"));
				c.add(rs.getString("contactCustomer"));
				c.add(rs.getString("nameRoom"));
				c.add(rs.getString("dateCheckIn"));
				c.add(rs.getString("dateCheckOut"));
				lsc.add(c);
			}
		}
		catch(SQLException e) {
			
		}
		return lsc;
	}
	
	public Vector<Object> findCustomer_byID(String idCustomer) {
		Connection cn = getCon();
		String sql = "Select idCustomer, nameCustomer, identityCardCustomer, nationalityCustomer, genderCustomer, ageCustomer, contactCustomer, room.nameRoom, "
				+ "dateCheckIn, dateCheckOut from hotel_management.customer join hotel_management.room on customer.idRoom = room.idRoom and idCustomer = ?";
		Vector<Object> customer = new Vector<>();
		try {
			PreparedStatement ps = (PreparedStatement)cn.prepareStatement(sql);
			ps.setString(1, idCustomer);
			ResultSet rs = ps.executeQuery();
			rs.next();
			customer.add(rs.getString("idCustomer"));
			customer.add(rs.getString("nameCustomer"));
			customer.add(rs.getString("identityCardCustomer"));
			customer.add(rs.getString("nationalityCustomer"));
			customer.add(rs.getString("genderCustomer"));
			customer.add(rs.getInt("ageCustomer"));
			customer.add(rs.getString("contactCustomer"));
			customer.add(rs.getString("nameRoom"));
			customer.add(rs.getString("dateCheckIn"));
			customer.add(rs.getString("dateCheckOut"));
		}
		catch(SQLException e) {
			
		}
		return customer;
	}
	
	public boolean insertCustomer(String idCustomer, String nameCustomer, String identityCardCustomer, String nationalityCustomer,
			boolean genderCustomer, int ageCustomer, String contactCustomer, String idRoom, String dateCheckIn, String dateCheckOut) {
		Connection cn = getCon();
		String sql = "Insert into hotel_management.customer values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		int n = 0;
		try {
			PreparedStatement ps = (PreparedStatement)cn.prepareStatement(sql);
			ps.setString(1, idCustomer);
			ps.setString(2, nameCustomer);
			ps.setString(3, identityCardCustomer);
			ps.setString(4, nationalityCustomer);
			if(genderCustomer == true)
				ps.setString(5, "Nam");
			else
				ps.setString(5, "Nu");
			ps.setInt(6, ageCustomer);
			ps.setString(7, contactCustomer);
			ps.setString(8, idRoom);
			ps.setString(9, dateCheckIn);
			ps.setString(10, dateCheckOut);
			n = ps.executeUpdate();
		}
		catch(SQLException e) {
			
		}
		return n > 0;
	}
	
	public boolean changedStateRoom(String nameRoom, String stateRoom) {
		Connection cn = getCon();
		String sql = "Update hotel_management.room set stateRoom = ? where nameRoom = ?";
		int n = 0;
		try {
			PreparedStatement ps = (PreparedStatement)cn.prepareStatement(sql);
			ps.setString(1, stateRoom);
			ps.setString(2, nameRoom);
			n = ps.executeUpdate();
		}
		catch(SQLException e) {
			
		}
		return n > 0;
	}
	
	public boolean checkStateRoomA(String nameRoom) {
		Connection cn = getCon();
		String sql = "Select stateRoom from hotel_management.room where nameRoom = ?";
		try {
			PreparedStatement ps = (PreparedStatement)cn.prepareStatement(sql);
			ps.setString(1, nameRoom);
			ResultSet rs = ps.executeQuery();
			rs.next();
			if(rs.getString("stateRoom").equals("Unavailable"))
				return false;
		}
		catch(SQLException e) {
			
		}
		return true;
	}
	
	public boolean updateCustomer(String idCustomer, String nameCustomer, String identityCardCustomer, String nationalityCustomer,
			boolean genderCustomer, int ageCustomer, String contactCustomer, String idRoom, String dateCheckIn, String dateCheckOut) {
		Connection cn = getCon();
		String sql = "Update hotel_management.customer set nameCustomer = ?, identityCardCustomer = ?, nationalityCustomer = ?, genderCustomer = ?, "
				+ "ageCustomer = ?, contactCustomer = ?, idRoom = ?, dateCheckIn = ?, dateCheckOut = ? where idCustomer = ?";
		int n = 0;
		try {
			PreparedStatement ps = (PreparedStatement)cn.prepareStatement(sql);
			ps.setString(1, nameCustomer);
			ps.setString(2, identityCardCustomer);
			ps.setString(3, nationalityCustomer);
			if(genderCustomer)
				ps.setString(4, "Nam");
			else
				ps.setString(4, "Nu");
			ps.setInt(5, ageCustomer);
			ps.setString(6, contactCustomer);
			ps.setString(7, idRoom);
			ps.setString(8, dateCheckIn);
			ps.setString(9, dateCheckOut);
			ps.setString(10, idCustomer);
			n = ps.executeUpdate();
		}
		catch(SQLException e) {
			
		}
		return n > 0;
	}
	
	public boolean deleteCustomer(String idCustomer) {
		Connection cn = getCon();
		String sql = "Delete from hotel_management.customer where idCustomer = ?";
		int n = 0;
		try {
			PreparedStatement ps = (PreparedStatement)cn.prepareStatement(sql);
			ps.setString(1, idCustomer);
			n = ps.executeUpdate();
		}
		catch(SQLException e) {
			
		}
		return n > 0;
	}
	
	public boolean clearCustomer() {
		Connection cn = getCon();
		String sql = "Delete from hotel_management.customer";
		int n = 0;
		try {
			PreparedStatement ps = (PreparedStatement)cn.prepareStatement(sql);
			n = ps.executeUpdate();
		}
		catch(SQLException e) {
			
		}
		return n > 0;
	}
	
	public ArrayList<String> getIDRoom_byNameRoom(String nameRoom){
		Connection cn = getCon();
		String sql = "Select idRoom from hotel_management.room where nameRoom = ?";
		ArrayList<String> lsid = new ArrayList<>();
		try {
			PreparedStatement ps = (PreparedStatement)cn.prepareStatement(sql);
			ps.setString(1, nameRoom);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				lsid.add(rs.getString("idRoom"));
			}
		}
		catch(SQLException e) {
			
		}
		return lsid;
	}
	
	public static void main(String[] args) {
		System.out.println(getCon());

	}
}
