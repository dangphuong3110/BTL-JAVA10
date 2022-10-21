package BTL;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import com.mysql.cj.xdevapi.Result;

public class Process_Bill {
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
	
	// truyền dữ liệu ở table Bill sang Arraylist
	public ArrayList<Vector<Object>> getListBill(){
		Connection cn = getCon();
		String sql = "Select bill.idBill, nameStaff, nameRoom, dateBill, total from staff, room, bill where bill.idStaff = staff.idStaff and bill.idRoom = room.idRoom;";
		ArrayList<Vector<Object>> B = new ArrayList<>();
		try {
			PreparedStatement ps = cn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Vector<Object> b = new Vector<>();
				b.add(rs.getString("idBill"));
				b.add(rs.getString("nameStaff"));
				b.add(rs.getString("nameRoom"));
				b.add(rs.getString("dateBill"));
				b.add(rs.getDouble("total"));
				B.add(b);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return B;
	}
	
	// Insert Bill
	public boolean insertBill(String idbill, String namestaff, String nameroom, String dateBill, double total){
		Connection cn = getCon();
		String sql = "INSERT INTO `hotel_management`.`bill` (`idBill`, `idStaff`, `idRoom`, `dateBill`,`total`) VALUES (?, (select idStaff from hotel_management.Staff where nameStaff = ?), (select idRoom from hotel_management.Room where nameRoom = ?), ?, ?)";
		int n=0;
		try {
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setString(1, idbill);
			ps.setString(2, namestaff);
			ps.setString(3, nameroom);
			ps.setString(4, dateBill);
			ps.setDouble(5, total);
			n=ps.executeUpdate();
			
		} catch (SQLException e) {
			
		}
		return n>0;
	}
	
	// Update Bill
	public boolean updateBill(String idbill, String namestaff, String nameroom, String datebill, double total) {
		Connection cn = getCon();
		String sql = "UPDATE `hotel_management`.`bill` SET `idStaff` = (Select idStaff from hotel_management.Staff where nameStaff = ?), `idRoom` = (Select idRoom from hotel_management.Room where nameRoom = ?), `dateBill` = ?, `total` = ? WHERE (`idBill` = ?);";
		int n=0;
		try {
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setString(1, namestaff);
			ps.setString(2, nameroom);
			ps.setString(3, datebill);
			ps.setDouble(4, total);
			ps.setString(5, idbill);
			
			n = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n>0;
	}
	
	// Delete Bill
	public boolean delBill(String idbill, String namestaff, String nameroom) {
		Connection cn = getCon();
		String sql = "DELETE FROM `hotel_management`.`bill`  WHERE (`idBill` = ?) and `idStaff` = (Select idStaff from hotel_management.Staff where nameStaff = ?) and `idRoom` = (Select idRoom from hotel_management.Room where nameRoom = ?);";
		int n=0;
		try {
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setString(1, idbill);
			ps.setString(2, namestaff);
			ps.setString(3, nameroom);
				
			n = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n>0;
	}
	
	// Find Bill
	public Vector<Object> findBill(String idbill) {
		Connection cn = getCon();
		String sql = "Select bill.idBill, nameStaff, nameRoom, dateBill, total from staff, room, bill where bill.idStaff = staff.idStaff and bill.idRoom = room.idRoom and bill.idBill = ?";
		Vector<Object> fb = new Vector<>();
		try {
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setString(1, idbill);
			ResultSet rs = ps.executeQuery();
			rs.next();
			fb.add(rs.getString("idBill"));
			fb.add(rs.getString("nameStaff"));
			fb.add(rs.getString("nameRoom"));
			fb.add(rs.getString("dateBill"));
			fb.add(rs.getDouble("total"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		}
		return fb;
	}
	
	
	public boolean changeStateRoomA(String idRoom) {
		Connection cn = getCon();
		String sql = "Update hotel_management.room set stateRoom = ? where idRoom = ?";
		int n = 0;
		try {
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setString(1, "Available");
			ps.setString(2, idRoom);
			n = ps.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}
	
	public boolean changeStateRoomU(String nameRoom) {
		Connection cn = getCon();
		String sql = "Update hotel_management.room set stateRoom = ? where nameRoom = ?";
		int n = 0;
		try {
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setString(1, "Unavailable");
			ps.setString(2, nameRoom);
			n = ps.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}
	
	public ArrayList<Staff> findingStaff(){
		Connection cn = getCon();
		String sql = "select staff.nameStaff from staff;";
		ArrayList<Staff> b = new ArrayList<>();
		try {
			PreparedStatement ps = cn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Staff s = new Staff();
				s.setNameStaff(rs.getString("nameStaff"));
				b.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return b;
	}
	
	public ArrayList<String> finding_nameRoom(String idStaff){
		Connection cn = getCon();
		String sql = "Select nameRoom from hotel_management.room where idStaff = ? and stateRoom = ?";
		ArrayList<String> b = new ArrayList<>();
		try {
			PreparedStatement ps = (PreparedStatement)cn.prepareStatement(sql);
			ps.setString(1, idStaff);
			ps.setString(2, "Unavailable");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				b.add(rs.getString("nameRoom"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return b;
	}
	
	public ArrayList<String> finding_idRoom(String nameRoom){
		Connection cn = getCon();
		String sql = "select idRoom from room where nameRoom = ?";
		ArrayList<String> ls = new ArrayList<>();
		try {
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setString(1, nameRoom);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				ls.add(rs.getString("idRoom"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return ls;
	}
	
	public ArrayList<String> finding_idStaff(String nameStaff){
		Connection cn = getCon();
		String sql = "select idStaff from staff where nameStaff = ?;";
		ArrayList<String> ls = new ArrayList<>();
		try {
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setString(1, nameStaff);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				ls.add(rs.getString("idStaff"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return ls;
	}
	
	public String getDateCheckOut(String idRoom) {
		Connection cn = getCon();
		String sql = "Select dateCheckOut from hotel_management.room, hotel_management.customer where room.idRoom = customer.idRoom and room.idRoom = ?";
		String dateCheckOut = "";
		try {
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setString(1, idRoom);
			ResultSet rs = ps.executeQuery();
			rs.next();
			dateCheckOut = rs.getString("dateCheckOut");
		}
		catch(SQLException e) {
			
		}
		return dateCheckOut;
	}
	
	static public Vector<Object> totalMoney(String idroom){
		Connection cn = getCon();
		String sql = "Select priceRoom, priceService, datediff(dateCheckOut, dateCheckIn) as `numberDay`  from hotel_management.room, hotel_management.customer, hotel_management.service "
				+ "where room.idRoom = customer.idRoom and room.idService = service.idService and room.idRoom = ?;";
		Vector<Object> tm = new Vector<>();
		try {
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setString(1, idroom);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				
				tm.add(rs.getString("priceRoom"));
				tm.add(rs.getString("priceService"));
				tm.add(rs.getString("numberDay"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tm;
	}
}
