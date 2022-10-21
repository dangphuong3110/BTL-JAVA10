package BTL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Process_Service {
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
	
//	public boolean deleteService(String idService) {
//		Connection cn = getCon();
//		String sql = "Delete from hotel_management.service where idService = ?";
//		int n = 0;
//		try {
//			PreparedStatement ps = (PreparedStatement)cn.prepareStatement(sql);
//			ps.setString(1, idService);
//			n = ps.executeUpdate();
//		}
//		catch(SQLException e) {
//			
//		}
//		return n > 0;
//	}
//	
//	public void deleteRoom_byIDService(String idService) {
//		Connection cn = getCon();
//		String sql = "Delete from hotel_management.room where idService = ?";
//		try {
//			PreparedStatement ps = (PreparedStatement)cn.prepareStatement(sql);
//			ps.setString(1, idService);
//			ps.executeUpdate();
//		}
//		catch(SQLException e) {
//			
//		}
//	}
}
