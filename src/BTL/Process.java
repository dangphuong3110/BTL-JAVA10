package BTL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Vector;

public class Process {
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
	
	/*
	 * Process_Room
	 */
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
			while (rs.next()) {
				r.setIdRoom(rs.getString("idRoom"));
				r.setNameRoom(rs.getString("nameRoom"));
				r.setTypeRoom(rs.getString("typeRoom"));
				//int temp = Integer.parseInt(rs.getString("priceRoom"));
				r.setPriceRoom(rs.getInt("priceRoom"));
				r.setNoteRoom(rs.getString("noteRoom"));
				r.setStateRoom(rs.getString("stateRoom"));
				r.setIdStaff(rs.getString("idStaff"));
				r.setIdService(rs.getString("idService"));
			}
		} catch (SQLException e) {
		}
		return r;
	}
	public ArrayList<Vector<Object>> getRoomByTypeRoom(String typeRoom) {
		Connection cn = getCon();
		String sql = "Select * from hotel_management.room where typeRoom = ?";
		ArrayList<Vector<Object>> ls_room = new ArrayList<>();
		try {
			PreparedStatement ps = (PreparedStatement) cn.prepareStatement(sql);
			ps.setString(1, typeRoom);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Vector<Object> r = new Vector<>();
				r.add(rs.getString("idRoom"));
				r.add(rs.getString("nameRoom"));
				r.add(rs.getString("typeRoom"));
				r.add(rs.getInt("priceRoom"));
				r.add(rs.getString("stateRoom"));
				r.add(rs.getString("noteRoom"));
				r.add(rs.getString("idStaff"));
				r.add(rs.getString("idService"));
				ls_room.add(r);
			}
		} catch (SQLException e) {
		}
		return ls_room;
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
	
	/*
	 * Process_Service
	 */
	public ArrayList<Service> getListService(){
		Connection cn = getCon();
		String sql = "Select * from hotel_management.service";
		ArrayList<Service> lss = new ArrayList<>();
		try {
			PreparedStatement ps = (PreparedStatement)cn.prepareCall(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Service s = new Service(rs.getString("idService"), rs.getString("nameService"), rs.getInt("priceService"));
				lss.add(s);
			}
		}
		catch(SQLException e) {
			
		}
		return lss;
	}
	
	public Service findService_byID(String idService) {
		Connection cn = getCon();
		String sql = "Select * from hotel_management.service where idService = ?";
		Service s = null;
		try {
			PreparedStatement ps = (PreparedStatement)cn.prepareCall(sql);
			ps.setString(1, idService);
			ResultSet rs = ps.executeQuery();
			rs.next();
			s = new Service(rs.getString("idService"), rs.getString("nameService"), rs.getInt("priceService"));
		}
		catch(SQLException e) {
			
		}
		return s;
	}
	
	public boolean insertService(String idService, String nameService, int priceService) {
		Connection cn = getCon();
		String sql = "Insert into hotel_management.service values(?, ?, ?)";
		int n = 0;
		try {
			PreparedStatement ps = (PreparedStatement)cn.prepareStatement(sql);
			ps.setString(1,	idService);
			ps.setString(2, nameService);
			ps.setInt(3, priceService);
			n = ps.executeUpdate();
		}
		catch(SQLException e) {
			
		}
		return n > 0;
	}
	
	public boolean updateService(String idService, String nameService, int priceService) {
		Connection cn = getCon();
		String sql = "Update hotel_management.service set nameService = ?, priceService = ? where idService = ?";
		int n = 0;
		try {
			PreparedStatement ps = (PreparedStatement)cn.prepareStatement(sql);
			ps.setString(1,	nameService);
			ps.setInt(2, priceService);
			ps.setString(3, idService);
			n = ps.executeUpdate();
		}
		catch(SQLException e) {
			
		}
		return n > 0;
	}
	
	/*
	 * Process_Staff
	 */
	public ArrayList<Vector<Object>> getListStaff() {
		Connection con = getCon();
		String sql = "select *from hotel_management.staff ";
		ArrayList lStaff = new ArrayList<>();
		try {
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Vector<Object> st = new Vector<Object>();
				st.add(rs.getString("idStaff"));
				st.add(rs.getString("nameStaff"));
				st.add(rs.getString("positionStaff"));
				st.add(rs.getInt("salaryStaff"));
				st.add(rs.getDate("dateOfBirth"));
				st.add(rs.getString("genderStaff"));
				st.add(rs.getString("contactStaff"));
				lStaff.add(st);
			}
		} catch (SQLException e) {
		}
		return lStaff;
	}

	// Tìm kiếm theo name
	public ArrayList<Vector<Object>> search_byname(String name) {
		Connection con = getCon();
		String sql = "select *from hotel_management.staff where nameStaff=?";
		ArrayList lStaff_byname = new ArrayList<>();
		try {
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Vector<Object> st = new Vector<>();
				st.add(rs.getString("idStaff"));
				st.add(rs.getString("nameStaff"));
				st.add(rs.getString("positionStaff"));
				st.add(rs.getInt("salaryStaff"));
				st.add(rs.getDate("dateOfBirth"));
				st.add(rs.getString("genderStaff"));
				st.add(rs.getString("contactStaff"));
				lStaff_byname.add(st);
			}
		} catch (SQLException e) {
		}
		return lStaff_byname;
	}

	// Thêm bản ghi
	public boolean insertStaff(String id, String name, String position, int salary, String dateofbirth, boolean gender,
			String contact) {
		Connection con = getCon();
		String sql = "insert into hotel_management.staff (idStaff, nameStaff, positionStaff, salaryStaff, dateOfBirth, genderStaff, contactStaff) values (?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, name);
			ps.setString(3, position);
			ps.setInt(4, salary);
			ps.setString(5, dateofbirth);
			if (gender == true)
				ps.setString(6, "Nam");
			else
				ps.setString(6, "Nữ");
			ps.setString(7, contact);
			ps.executeUpdate();
			con.close();
			return true;
		} catch (SQLException e) {
			return false;
		}
	}

	// Chỉnh sửa bản ghi
	public boolean updateStaff(String id, String name, String position, int salary, String dateofbirth, boolean gender,
			String contact) {
		Connection con = getCon();
		String sql = "update hotel_management.staff set nameStaff=?, positionStaff=?, salaryStaff=?, dateOfBirth=?, genderStaff=?, contactStaff=? where idStaff=?";
		try {
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, position);
			ps.setInt(3, salary);
			ps.setString(4, dateofbirth);
			if (gender == true)
				ps.setString(5, "Nam");
			else
				ps.setString(5, "Nữ");
			ps.setString(6, contact);
			ps.setString(7, id);
			ps.executeUpdate();
			con.close();
			return true;
		} catch (SQLException e) {
			return false;
		}
	}

	// Xóa bản ghi
	public boolean delete(String id) {
		Connection con = getCon();
		String sql = "Delete from hotel_management.staff where idStaff =?";
		try {
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1, id);
			ps.executeUpdate();
			con.close();
			return true;
		} catch (SQLException e) {
			return false;
		}
	}
	
	/*
	 * Process_Customer
	 */
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
	
	/*
	 * Process_Bill
	 */
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
	
	/*
	 * Process_Statistical
	 */
	public ArrayList<Vector<Object>> getList_byMonthAndYear(String month, String year){
		Connection cn = getCon();
		ArrayList<Vector<Object>> lst = new ArrayList<>();
		String sql = "Select * from bill where month(dateBill) = ? and year(dateBill) = ?";
		try {
			PreparedStatement ps = (PreparedStatement) cn.prepareStatement(sql);
			ps.setString(1, month);
			ps.setString(2, year);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Vector<Object> z = new Vector<>();
				z.add(rs.getString("idBill"));
				z.add(rs.getString("idStaff"));
				z.add(rs.getString("idRoom"));
				z.add(rs.getDate("dateBill"));
				z.add(rs.getString("total"));
				lst.add(z);
			}
		}catch(SQLException e) {
		}
		return lst;
	}
	
	public ArrayList<Vector<Object>> getList_Customer(){
		Connection cn = getCon();
		ArrayList<Vector<Object>> lst = new ArrayList<>();
		String sql = "SELECT * FROM hotel_management.customer;";
		
		try {
			PreparedStatement ps = (PreparedStatement) cn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Vector<Object> z = new Vector<>();
				z.add(rs.getString("idCustomer"));
				z.add(rs.getString("nameCustomer"));
				z.add(rs.getString("identityCardCustomer"));
				z.add(rs.getString("nationalityCustomer"));
				z.add(rs.getString("genderCustomer"));
				z.add(rs.getInt("ageCustomer"));
				z.add(rs.getString("contactCustomer"));
				z.add(rs.getString("idRoom"));
				z.add(rs.getDate("dateCheckIn"));
				z.add(rs.getDate("dateCheckOut"));
				lst.add(z);
			}
		}catch(SQLException e) {
			
		}
		return lst;
	}
	
	public Customer get_Customer(String idCustomer){
		Connection cn = getCon();
		Customer c = new Customer();
		String sql = "SELECT * FROM hotel_management.customer where idCustomer = ?;";
		
		try {
			PreparedStatement ps = (PreparedStatement) cn.prepareStatement(sql);
			ps.setString(1, idCustomer);
			ResultSet rs = ps.executeQuery();
			rs.next();
			c.setIdCustomer(rs.getString("idCustomer"));
			c.setNameCustomer(rs.getString("nameCustomer"));
			c.setNationalityCustomer(rs.getString("nationalityCustomer"));
			String gender = rs.getString("genderCustomer");
			boolean g = false;
			if(gender.equals("Nu"))
				g = true;
			c.setGenderCustomer(g);
			c.setAgeCustomer(rs.getInt("ageCustomer"));	
		}catch(SQLException e) {
			
		}
		return c;
	}
	
	public ArrayList<Vector<Object>> getList_room(){
		Connection cn = getCon();
		ArrayList<Vector<Object>> lst = new ArrayList<>();
		String sql = "select * from room where room.stateRoom = \"Available\";";
		
		try {
			PreparedStatement ps = (PreparedStatement) cn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Vector<Object> z = new Vector<>();
				z.add(rs.getString("idRoom"));
				z.add(rs.getString("nameRoom"));
				z.add(rs.getString("typeRoom"));
				z.add(rs.getInt("priceRoom"));
				z.add(rs.getString("stateRoom"));
				z.add(rs.getString("noteRoom"));
				z.add(rs.getString("idStaff"));
				z.add(rs.getString("idService"));
				lst.add(z);
			}
		}catch(SQLException e) {
			
		}
		return lst;
	} 
	
	public ArrayList<Vector<Object>> getList_CustomerCheckOut(){
		Connection cn = getCon();
		ArrayList<Vector<Object>> lst = new ArrayList<>();
		Calendar cal = Calendar.getInstance();
		String sql = "SELECT idCustomer, nameCustomer,identityCardCustomer, idRoom, dateCheckIn, dateCheckOut FROM hotel_management.customer"
				+ " where day(dateCheckOut) = ? and month(dateCheckOut) = ?";
		try {
			PreparedStatement ps = (PreparedStatement) cn.prepareStatement(sql);
			ps.setInt(1, cal.get(Calendar.DAY_OF_MONTH));
			ps.setInt(2, cal.get(Calendar.MONTH)+1);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Vector<Object> z = new Vector<>();
				z.add(rs.getString("idCustomer"));
				z.add(rs.getString("nameCustomer"));
				z.add(rs.getString("identityCardCustomer"));
				z.add(rs.getString("idRoom"));
				z.add(rs.getDate("dateCheckIn"));
				z.add(rs.getDate("dateCheckOut"));
				lst.add(z);
			}
		}catch(SQLException e) {
		}
		return lst;
	}
	public static void main(String[] args) {
		//System.out.println(getRoomByTypeRoom("Normal").size());
	}
}
