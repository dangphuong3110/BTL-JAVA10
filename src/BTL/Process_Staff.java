package BTL;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

public class Process_Staff {
	Connection cn ;

	// Kết nối SQL
	static public Connection getCon() {
		Connection cn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_management", "root", "06102002");
		} catch (ClassNotFoundException | SQLException e) {
		}
		return cn;
	}

	// Lấy bản ghi trong cơ sở dữ liệu
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
	public static void main(String[] args) {
		System.out.println(getCon());
	}
}
