package BTL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

public class Process_Room {
	Connection cn;

	public static Connection getCon() {
		Connection cn = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost/hotel_management", "root", "06102002");
		} catch (ClassNotFoundException | SQLException e) {

		}
		return cn;
	}
	
	public ArrayList<Vector<Object>> getListIdNameStaff() {
		Connection cn = getCon();
		String sql = "Select nameStaff, idStaff from hotel_management.staff";
		ArrayList<Vector<Object>> ls_staff = new ArrayList<>();
		try {
			PreparedStatement ps = (PreparedStatement) cn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Vector<Object> r = new Vector<>();
				r.add(rs.getString("nameStaff"));
				r.add(rs.getString("idStaff"));
				ls_staff.add(r);
				
			}
		} catch (SQLException e) {

		}
		return ls_staff;
	}
	public ArrayList<Vector<Object>> getListIdNameService() {
		Connection cn = getCon();
		String sql = "Select nameService, idService from hotel_management.service";
		ArrayList<Vector<Object>> ls_service = new ArrayList<>();
		try {
			PreparedStatement ps = (PreparedStatement) cn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Vector<Object> r = new Vector<>();
				r.add(rs.getString("nameService"));
				r.add(rs.getString("idService"));
				ls_service.add(r);
				
			}
		} catch (SQLException e) {

		}
		return ls_service;
	}
	public ArrayList<Object> getListIdService(String nameService) {
		Connection cn = getCon();
		String sql = "Select idService from hotel_management.service where nameService = ?";
		ArrayList<Object> ls_service = new ArrayList<>();
		try {
			PreparedStatement ps = (PreparedStatement) cn.prepareStatement(sql);
			ps.setString(1, nameService);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				
				ls_service.add(rs.getString("idService"));
				
			}
		} catch (SQLException e) {

		}
		return ls_service;
	}
	public ArrayList<Object> getListIdStaff(String nameStaff) {
		Connection cn = getCon();
		String sql = "Select idStaff from hotel_management.staff where nameStaff = ?";
		ArrayList<Object> ls_staff = new ArrayList<>();
		try {
			PreparedStatement ps = (PreparedStatement) cn.prepareStatement(sql);
			ps.setString(1, nameStaff);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				
				ls_staff.add(rs.getString("idStaff"));
				
			}
		} catch (SQLException e) {

		}
		return ls_staff;
	}
	public Room getRoomById(String idRoom) {
		Connection cn = getCon();
		String sql = "Select * from hotel_management.room where idRoom =?";
		Room r = new Room();
		try {
			PreparedStatement ps = (PreparedStatement) cn.prepareStatement(sql);
			ps.setString(1, idRoom);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				r.setIdRoom(rs.getString("idRoom"));
				r.setNameRoom(rs.getString("nameRoom"));
				r.setTypeRoom(rs.getString("typeRoom"));
				int temp = Integer.parseInt(rs.getString("priceRoom"));
				r.setPriceRoom(temp);
				r.setNoteRoom(rs.getString("noteRoom"));
				r.setStateRoom(rs.getString("stateRoom"));
				r.setIdStaff(rs.getString("idStaff"));
				r.setIdService(rs.getString("idService"));
			}
		}catch(SQLException e) {
			
		}
		return r;
	}
	public ArrayList<Object> getListIdRoom() {
		Connection cn = getCon();
		String sql = "Select idRoom from hotel_management.room";
		ArrayList<Object> ls_room = new ArrayList<>();
		try {
			PreparedStatement ps = (PreparedStatement) cn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ls_room.add(rs.getString("idRoom"));
			}
		} catch (SQLException e) {

		}
		return ls_room;
	}
	public ArrayList<Vector<Object>> getListRoom() {
		Connection cn = getCon();
		String sql = "Select idRoom, nameRoom, typeRoom ,priceRoom, stateRoom,noteRoom, staff.nameStaff , service.nameService from hotel_management.room, hotel_management.staff, hotel_management.service where room.idStaff= staff.idStaff and service.idService = room.idService ";
		ArrayList<Vector<Object>> ls_room = new ArrayList<>();
		try {
			PreparedStatement ps = (PreparedStatement) cn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Vector<Object> r = new Vector<>();
				r.add(rs.getString("idRoom"));
				r.add(rs.getString("nameRoom"));
				r.add(rs.getString("typeRoom"));
				r.add(rs.getInt("priceRoom"));
				r.add(rs.getString("stateRoom"));
				r.add(rs.getString("noteRoom"));
				r.add(rs.getString("nameStaff"));
				r.add(rs.getString("nameService"));
				ls_room.add(r);
			}
		} catch (SQLException e) {

		}
		return ls_room;
	}
	public boolean deleteRoom(String idRoom) {
		Connection cn = getCon();
		String sql = "Delete from room where idRoom = ?";
		try {
			PreparedStatement ps = (PreparedStatement) cn.prepareStatement(sql);
			ps.setString(1, idRoom);
			ps.executeUpdate();
			cn.close();
		} catch (SQLException e) {
			return false;
		}
		return true;

	}

	public boolean insertRoom(String idRoom, String nameRoom, String typeRoom, int priceRoom, String stateRoom,
			String noteRoom, String idStaff, String idService) {
		Connection cn = getCon();
		String sql = "Insert into room values (?,?,?,?,?,?,?,?)";

		try {
			PreparedStatement ps = (PreparedStatement) cn.prepareStatement(sql);
			ps.setString(1, idRoom);
			ps.setString(2, nameRoom);
			ps.setString(3, typeRoom);
			String temp = Integer.toString(priceRoom);
			ps.setString(4, temp);
			ps.setString(5, stateRoom);
			ps.setString(6, noteRoom);
			ps.setString(7, idStaff);
			ps.setString(8, idService);
			ps.executeUpdate();
			cn.close();
		} catch (SQLException e) {
			return false;
		}
		return true;
	}

	public boolean updateRoom(String idRoom, String nameRoom, String typeRoom, int priceRoom, String stateRoom,
			String noteRoom, String idStaff, String idService) {
		Connection cn = getCon();
		String sql = "Update room set nameRoom = ?, typeRoom = ?, priceRoom = ?, stateRoom = ?, noteRoom = ?, idStaff = ?, idService =? where idRoom = ?";
		try {
			PreparedStatement ps = (PreparedStatement) cn.prepareStatement(sql);

			ps.setString(1, nameRoom);
			ps.setString(2, typeRoom);
			String temp = Integer.toString(priceRoom);
			ps.setString(3, temp);
			ps.setString(4, stateRoom);
			ps.setString(5, noteRoom);
			ps.setString(6, idStaff);
			ps.setString(7, idService);
			ps.setString(8, idRoom);
			ps.executeUpdate();
			cn.close();
		} catch (SQLException e) {
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(getCon());
	}
}
