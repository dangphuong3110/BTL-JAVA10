package BTL;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Vector;

import javax.naming.spi.DirStateFactory.Result;

import com.mysql.cj.xdevapi.PreparableStatement;

public class Process_Statistical {
	private Connection cn;
	
	public static Connection getCon() {
		Connection cn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 cn = DriverManager.getConnection("jdbc:mysql://localhost/hotel_management","root","06102002");
		}catch(ClassNotFoundException | SQLException e) {
			
		}
		
		return cn;
	}
	
//	public ArrayList<Vector<Object>> getList_byMonthOrYear(String month, String year){
//		Connection cn = getCon();
//		ArrayList<Vector<Object>> lst = new ArrayList<>();
//		String sql = "select *  from bill where month(dateBill) = ? or year(dateBill) = ? ;";
//		try {
//			PreparedStatement ps = (PreparedStatement) cn.prepareStatement(sql);
//			ps.setString(1, month);
//			ps.setString(2, year);
//			ResultSet rs = ps.executeQuery();
//			while(rs.next()) {
//				Vector<Object> z = new Vector<>();
//				z.add(rs.getString("idBill"));
//				z.add(rs.getString("idStaff"));
//				z.add(rs.getString("idRoom"));
//				z.add(rs.getDate("dateBill"));
//				z.add(rs.getString("total"));
//				lst.add(z);
//			}
//		}catch(SQLException e) {
//		}
//		return lst;
//	}
	
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
//			Customer x = new Customer(rs.getString("idCustomer"),rs.getString("nameCustomer"),rs.getString("identityCardCustomer"), rs.getString("nationalityCustomer"),rs.getString("contactCustomer"),rs.getDate("dateCheckIn"),rs.getDate("dateCheckOut"), rs.getString("genderCustomer").equals("Name")? false : true, rs.getInt("ageCustomer") );
			c.setIdCustomer(rs.getString("idCustomer"));
			c.setNameCustomer(rs.getString("nameCustomer"));
//			c.setIdentityCardCustomer(rs.getString("identityCardCustomer"));
			c.setNationalityCustomer(rs.getString("nationalityCustomer"));
			String gender = rs.getString("genderCustomer");
			boolean g = false;
			if(gender.equals("Nu"))
				g = true;
			c.setGenderCustomer(g);
			c.setAgeCustomer(rs.getInt("ageCustomer"));
//			c.setContactCustomer(rs.getString("contactCustomer"));
//			c.setDateCheckIn(rs.getDate("dateCheckIn"));
//			c.setDateCheckOut(rs.getDate("dateCheckOut"));
			
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
		Calendar cal = Calendar.getInstance();
		System.out.println(cal.get(Calendar.DAY_OF_MONTH));
		System.out.println(cal.get(Calendar.MONTH));
	}
	
}
