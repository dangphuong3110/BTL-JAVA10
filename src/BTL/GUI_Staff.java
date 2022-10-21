package BTL;

import java.awt.EventQueue;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

//import org.jdatepicker.impl.JDatePanelImpl;
//import org.jdatepicker.impl.JDatePickerImpl;
//import org.jdatepicker.impl.UtilDateModel;

import com.toedter.calendar.JDateChooser;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTabbedPane;
import javax.swing.JSplitPane;
import javax.swing.JInternalFrame;
import javax.swing.JDesktopPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.awt.SystemColor;

public class GUI_Staff extends JFrame {
	Vector<String> columns = new Vector<>();
	Vector<Vector<Object>> rows = new Vector<>();
	DefaultTableModel dtm = new DefaultTableModel();
	Process_Project pp = new Process_Project();
	private JPanel contentPane;
	private JTable tb_staff;
	private JTextField tf_id;
	private JTextField tf_name;
	private JTextField tf_salary;
	private JTextField tf_contact;
	private JRadioButton rd_nam = new JRadioButton("Nam");
	private JRadioButton rd_nu = new JRadioButton("Nữ");
	private JTextField tf_position;
	private JOptionPane jOP_Message = new JOptionPane();
	private JOptionPane jOP_Check = new javax.swing.JOptionPane();
	private JDateChooser dC_birthofday;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_Staff frame = new GUI_Staff();
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
	public GUI_Staff() {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage("C:\\Users\\Admin\\Documents\\jav2\\BTL_10\\BTL-JAVA10\\src\\images\\staff1.png"));
		setTitle("Quản lý nhân viên");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 616);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 255, 255));
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setFont(new Font("Serif", Font.PLAIN, 20));
		panel_1.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Th\u00F4ng tin nh\u00E2n vi\u00EAn", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null,
				new Color(0, 0, 0)));
		panel_1.setBounds(4, 45, 433, 477);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Mã nhân viên");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(10, 44, 96, 25);
		panel_1.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Họ tên");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(10, 79, 96, 25);
		panel_1.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Chức vụ");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_2.setBounds(10, 114, 96, 25);
		panel_1.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_3 = new JLabel("Lương");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_3.setBounds(10, 149, 96, 25);
		panel_1.add(lblNewLabel_1_3);

		JLabel lblNewLabel_1_4 = new JLabel("Ngày sinh");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_4.setBounds(10, 184, 96, 25);
		panel_1.add(lblNewLabel_1_4);

		JLabel lblNewLabel_1_5 = new JLabel("Giới tính");
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_5.setBounds(10, 219, 96, 25);
		panel_1.add(lblNewLabel_1_5);

		JLabel lblNewLabel_1_6 = new JLabel("Số điện thoại");
		lblNewLabel_1_6.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_6.setBounds(10, 254, 96, 25);
		panel_1.add(lblNewLabel_1_6);

		JButton bt_insert = new JButton("Thêm");
		bt_insert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int sala = Integer.parseInt(tf_salary.getText());
					insert(tf_id.getText(), tf_name.getText(), tf_position.getText(), sala,
							dC_birthofday.getDate() + "", rd_nam.isSelected(), tf_contact.getText());
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Thông tin nhập vào chưa chính xác. Yêu cầu kiểm tra lại!",
							"Thông báo", JOptionPane.INFORMATION_MESSAGE);
				}
				getListStaff();
			}
		});
		bt_insert.setBounds(10, 324, 108, 30);
		panel_1.add(bt_insert);
		bt_insert.setIcon(new ImageIcon("C:\\Users\\Admin\\Documents\\jav2\\BTL_10\\BTL-JAVA10\\src\\images\\add.png"));
		bt_insert.setFont(new Font("Tahoma", Font.PLAIN, 12));

		JButton bt_update = new JButton("Chỉnh sửa");
		bt_update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int sala = Integer.parseInt(tf_salary.getText());
					update(tf_id.getText(), tf_name.getText(), tf_position.getText(), sala,
							dC_birthofday.getDate() + "", rd_nam.isSelected(), tf_contact.getText());
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Thông tin nhập vào chưa chính xác. Yêu cầu kiểm tra lại!",
							"Thông báo", JOptionPane.INFORMATION_MESSAGE);
				}
				getListStaff();
			}
		});
		bt_update.setBounds(154, 324, 119, 30);
		panel_1.add(bt_update);
		bt_update.setIcon(
				new ImageIcon("C:\\Users\\Admin\\Documents\\jav2\\BTL_10\\BTL-JAVA10\\src\\images\\update.png"));
		bt_update.setFont(new Font("Tahoma", Font.PLAIN, 12));

		JButton bt_delete = new JButton("Xóa");
		bt_delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete(tf_id.getText());
			}
		});
		bt_delete.setBounds(315, 324, 108, 30);
		panel_1.add(bt_delete);
		bt_delete.setIcon(
				new ImageIcon("C:\\Users\\Admin\\Documents\\jav2\\BTL_10\\BTL-JAVA10\\src\\images\\delete.png"));
		bt_delete.setFont(new Font("Tahoma", Font.PLAIN, 12));

		tf_contact = new JTextField();
		tf_contact.setBounds(116, 259, 174, 19);
		panel_1.add(tf_contact);
		tf_contact.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tf_contact.setColumns(10);
		buttonGroup.add(rd_nam);
		rd_nam.setBounds(116, 221, 66, 21);
		panel_1.add(rd_nam);

		rd_nam.setFont(new Font("Tahoma", Font.PLAIN, 12));
		buttonGroup.add(rd_nu);
		rd_nu.setBounds(224, 221, 66, 21);
		panel_1.add(rd_nu);

		rd_nu.setFont(new Font("Tahoma", Font.PLAIN, 12));

		tf_salary = new JTextField();
		tf_salary.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tf_salary.setBounds(116, 154, 174, 19);
		panel_1.add(tf_salary);
		tf_salary.setColumns(10);

		tf_name = new JTextField();
		tf_name.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tf_name.setBounds(116, 84, 174, 19);
		panel_1.add(tf_name);
		tf_name.setColumns(10);

		tf_id = new JTextField();
		tf_id.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tf_id.setBounds(116, 49, 174, 19);
		panel_1.add(tf_id);
		tf_id.setColumns(10);

		JButton bt_search = new JButton("Tìm kiếm");
		bt_search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				search_name(tf_name.getText());
			}
		});
		bt_search.setBounds(315, 49, 108, 30);
		panel_1.add(bt_search);
		bt_search.setIcon(new ImageIcon("D:\\Java_62TH5\\Java2022_62TH5\\conssAPP\\BTL_10\\src\\image\\zoom.png"));
		bt_search.setFont(new Font("Tahoma", Font.PLAIN, 12));

		tf_position = new JTextField();
		tf_position.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tf_position.setColumns(10);
		tf_position.setBounds(116, 119, 174, 19);
		panel_1.add(tf_position);

		JButton bt_clear = new JButton("Clear");
		bt_clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tf_id.setText("");
				tf_name.setText("");
				tf_position.setText("");
				tf_salary.setText("");
				dC_birthofday.setDate(null);
				buttonGroup.remove(rd_nam);
				buttonGroup.remove(rd_nu);
				rd_nam.setSelected(false);
				rd_nu.setSelected(false);
				buttonGroup.add(rd_nam);
				buttonGroup.add(rd_nu);
				tf_contact.setText("");
				tf_id.setEnabled(true);
			}
		});
		bt_clear.setIcon(
				new ImageIcon("C:\\Users\\Admin\\Documents\\jav2\\BTL_10\\BTL-JAVA10\\src\\images\\clear.png"));
		bt_clear.setFont(new Font("Tahoma", Font.PLAIN, 12));
		bt_clear.setBounds(77, 389, 101, 30);
		panel_1.add(bt_clear);

		JButton bt_exit = new JButton("Thoát");
		bt_exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exitForm();
			}
		});
		bt_exit.setIcon(new ImageIcon("C:\\Users\\Admin\\Documents\\jav2\\BTL_10\\BTL-JAVA10\\src\\images\\exit.png"));
		bt_exit.setFont(new Font("Tahoma", Font.PLAIN, 12));
		bt_exit.setBounds(250, 389, 101, 30);
		panel_1.add(bt_exit);

		dC_birthofday = new JDateChooser();
		dC_birthofday.getCalendarButton().setFont(new Font("Tahoma", Font.PLAIN, 15));
		dC_birthofday.setDateFormatString("yyyy-MM-dd");
		dC_birthofday.setBounds(116, 190, 174, 19);
		panel_1.add(dC_birthofday);

		tb_staff = new JTable();
		tb_staff.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tb_staff.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int select = tb_staff.getSelectedRow();
				if (select != -1) {
					Vector<Object> tb = rows.get(select);
					tf_id.setText(tb.get(0) + "");
					tf_name.setText(tb.get(1) + "");
					tf_position.setText(tb.get(2) + "");
					tf_salary.setText(tb.get(3) + "");
					dC_birthofday.setDate((Date) tb.get(4));
					if (tb.get(5).equals("Nam"))
						rd_nam.setSelected(true);
					else
						rd_nu.setSelected(true);
					tf_contact.setText(tb.get(6) + "");
					tf_id.setEnabled(false);
				}

			}
		});
		tb_staff.setBounds(447, 99, 809, 363);
		contentPane.add(tb_staff);

		JButton bt_list = new JButton("Tất cả danh sách");
		bt_list.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getListStaff();
			}
		});
		bt_list.setBackground(SystemColor.text);
		bt_list.setFont(new Font("Tahoma", Font.PLAIN, 12));
		bt_list.setBounds(1115, 70, 141, 21);
		contentPane.add(bt_list);

		columns.add("ID");
		columns.add("Name");
		columns.add("Position");
		columns.add("Salary");
		columns.add("Dateofbirth");
		columns.add("Gender");
		columns.add("Contact");
		getListStaff();
	}

	public void getListStaff() {
		dtm.setRowCount(0);
		for (int i = 0; i < pp.getListStaff().size(); i++) {
			Vector<Object> s = (Vector<Object>) pp.getListStaff().get(i);
			Vector<Object> tbrow = new Vector<>();
			tbrow.add(s.get(0));
			tbrow.add(s.get(1));
			tbrow.add(s.get(2));
			tbrow.add(s.get(3));
			tbrow.add(s.get(4));
			tbrow.add(s.get(5));
			tbrow.add(s.get(6));
			rows.add(tbrow);
		}
		dtm.setDataVector(rows, columns);
		dtm.insertRow(0, columns);
		tb_staff.setModel(dtm);
	}

	// Thêm bản ghi
	public void insert(String id, String name, String position, int salary, String dateofbirth, boolean gender,
			String contact) {
		id = tf_id.getText();
		name = tf_name.getText();
		position = tf_position.getText();
		salary = Integer.parseInt(tf_salary.getText());
		dateofbirth = new SimpleDateFormat("yyyy/MM/dd").format(dC_birthofday.getDate());
		gender = false;
		if (rd_nam.isSelected())
			gender = true;
		contact = tf_contact.getText();
		if (pp.insertStaff(id, name, position, salary, dateofbirth, gender, contact))
			JOptionPane.showMessageDialog(null, "Thêm thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
		else
			JOptionPane.showMessageDialog(null, "Bạn đang gặp vấn đề với chức năng này!", "Thông báo",
					JOptionPane.INFORMATION_MESSAGE);
	}

	// Chỉnh sửa bản ghi
	public void update(String id, String name, String position, int salary, String dateofbirth, boolean gender,
			String contact) {
		id = tf_id.getText();
		name = tf_name.getText();
		position = tf_position.getText();
		salary = Integer.parseInt(tf_salary.getText());
		dateofbirth = new SimpleDateFormat("yyyy-MM-dd").format(dC_birthofday.getDate());
		gender = false;
		if (rd_nam.isSelected())
			gender = true;
		contact = tf_contact.getText();
		if (pp.updateStaff(id, name, position, salary, dateofbirth, gender, contact))
			JOptionPane.showMessageDialog(null, "Cập nhật thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
		else
			JOptionPane.showMessageDialog(null, "Bạn đang gặp vấn đề với chức năng này!", "Thông báo",
					JOptionPane.INFORMATION_MESSAGE);
	}

	// Xóa bản ghi
	public void delete(String id) {
		id = tf_id.getText();
		int[] selectedRow = tb_staff.getSelectedRows();
		if (selectedRow.length == 1) {
			if (JOptionPane.showConfirmDialog(null, "Bạn chắc chắn muốn xóa dòng này không?", "Question",
					JOptionPane.YES_NO_CANCEL_OPTION) == 0) {
				if (pp.delete(id)) {
					getListStaff();
					JOptionPane.showMessageDialog(null, "Xóa thành công", "Message", JOptionPane.INFORMATION_MESSAGE);
					tf_id.setText("");
					tf_name.setText("");
					tf_position.setText("");
					tf_salary.setText("");
					dC_birthofday.setDate(null);
					buttonGroup.remove(rd_nam);
					buttonGroup.remove(rd_nu);
					rd_nam.setSelected(false);
					rd_nu.setSelected(false);
					buttonGroup.add(rd_nam);
					buttonGroup.add(rd_nu);
					tf_contact.setText("");
					tf_id.setEnabled(true);
				} else {
					JOptionPane.showMessageDialog(null, "Xóa thất bại", "Message", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		} else {
			if (JOptionPane.showConfirmDialog(null, "Bạn chắc chắn muốn xóa dòng này không?", "Question",
					JOptionPane.YES_NO_CANCEL_OPTION) == 0) {
				int check = 0;
				for (int i : selectedRow) {
					id = rows.get(i - check).get(0).toString();
					if (pp.delete(id))
						getListStaff();
					check++;
				}
				if (check > 0) {
					JOptionPane.showMessageDialog(null, "Xóa thành công", "Message", JOptionPane.INFORMATION_MESSAGE);
					tf_id.setText("");
					tf_name.setText("");
					tf_position.setText("");
					tf_salary.setText("");
					dC_birthofday.setDate(null);
					buttonGroup.remove(rd_nam);
					buttonGroup.remove(rd_nu);
					rd_nam.setSelected(false);
					rd_nu.setSelected(false);
					buttonGroup.add(rd_nam);
					buttonGroup.add(rd_nu);
					tf_contact.setText("");
					tf_id.setEnabled(true);
				} else {
					JOptionPane.showMessageDialog(null, "Xóa thất bại", "Message", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}

	}

	// Tìm kiếm theo tên
	public void search_name(String name) {
		dtm.setRowCount(0);
		for (int i = 0; i < pp.search_byname(name).size(); i++) {
			Vector<Object> st = (Vector<Object>) pp.search_byname(name).get(i);
			Vector<Object> tbrow = new Vector<>();
			tbrow.add(st.get(0));
			tbrow.add(st.get(1));
			tbrow.add(st.get(2));
			tbrow.add(st.get(2));
			tbrow.add(st.get(4));
			tbrow.add(st.get(5));
			tbrow.add(st.get(6));
			rows.add(tbrow);
		}
		dtm.setDataVector(rows, columns);
		dtm.insertRow(0, columns);
		tb_staff.setModel(dtm);
	}

	public void exitForm() {
		if (jOP_Check.showConfirmDialog(null, "Bạn có muốn thoát không?", "Thoát",
				jOP_Check.YES_NO_CANCEL_OPTION) == 0) {
			this.setVisible(false);
			GUI_FrameMain e = new GUI_FrameMain();
			e.setVisible(true);
		}
	}
}
