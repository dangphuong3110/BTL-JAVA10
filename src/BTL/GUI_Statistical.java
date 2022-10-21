package BTL;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.TextField;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.Scrollbar;
import javax.swing.JScrollBar;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.EtchedBorder;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ButtonGroup;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
public class GUI_Statistical extends JFrame {
	
	private JPanel contentPane;
	private JTable table;
	private JTextField tf_year;
	private Vector<Vector<Object>> rows = new Vector<>();
	private Vector<String> columns1 = new Vector<>();
	private Vector<String> columns2 = new Vector<>();
	private Vector<String> columns3 = new Vector<>();
	private Vector<String> columns4 = new Vector<>();
	private DefaultTableModel dtm = new DefaultTableModel();
	private Process_Project pp = new Process_Project();
	private Customer c = new Customer();
	private ArrayList<Vector<Object>> lst = new ArrayList<>();
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField tf_nameCustomer;
	private JTextField tf_ageCustomer;
	private JTextField tf_genderCustomer;
	private JTextField tf_nationalityCustomer;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_Statistical frame = new GUI_Statistical();
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
	public GUI_Statistical() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1137, 616);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Th\u1ED1ng k\u00EA", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(24, 30, 382, 513);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel = new JLabel("Tháng");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(53, 62, 59, 29);
		panel_1.add(lblNewLabel);

		JComboBox cb_Thang = new JComboBox();
		cb_Thang.setModel(new DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
		cb_Thang.setBounds(103, 67, 150, 21);
		panel_1.add(cb_Thang);

		JRadioButton rb_doanhThu = new JRadioButton("Thống kê doanh thu");
		rb_doanhThu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});
		buttonGroup.add(rb_doanhThu);
		rb_doanhThu.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rb_doanhThu.setBounds(39, 25, 157, 21);
		panel_1.add(rb_doanhThu);

		JRadioButton rb_khachHang = new JRadioButton("Thống kê khách hàng");
		rb_khachHang.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tf_year.setText("");

			}
		});
		buttonGroup.add(rb_khachHang);
		rb_khachHang.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rb_khachHang.setBounds(39, 188, 157, 21);
		panel_1.add(rb_khachHang);

		JRadioButton rb_phongTrong = new JRadioButton("Thống kê bao nhiêu phòng trống");
		rb_phongTrong.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tf_year.setText("");

			}
		});
		buttonGroup.add(rb_phongTrong);
		rb_phongTrong.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rb_phongTrong.setBounds(39, 327, 230, 21);
		panel_1.add(rb_phongTrong);
		
		JRadioButton rb_checkOut = new JRadioButton("Thống kê những phòng đến hạn trả");
		buttonGroup.add(rb_checkOut);
		rb_checkOut.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rb_checkOut.setBounds(39, 375, 275, 21);
		panel_1.add(rb_checkOut);

		JButton btnNewButton = new JButton("Thống kê");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tf_nameCustomer.setText("");
				tf_ageCustomer.setText("");
				tf_nationalityCustomer.setText("");
				tf_genderCustomer.setText("");
				
				if (rb_doanhThu.isSelected())
					getList_byMonthAndYear(cb_Thang.getSelectedItem() + "", tf_year.getText());
				if(rb_khachHang.isSelected())
					getList_Customer() ;
				if(rb_phongTrong.isSelected())
					getList_Room();
				if(rb_checkOut.isSelected())
					getCustomer_checkOut();

			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(75, 448, 105, 23);
		panel_1.add(btnNewButton);

		JLabel lblNm = new JLabel("Năm");
		lblNm.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNm.setBounds(53, 114, 59, 29);
		panel_1.add(lblNm);

		tf_year = new JTextField();
		tf_year.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				boolean check = true;
				for(int i = 0; i < tf_year.getText().toString().length(); i++) {
					if(tf_year.getText().toString().charAt(i) < '0'  || tf_year.getText().toString().charAt(i) > '9')
						check = false;
				}
				if(check == false)
					JOptionPane.showConfirmDialog(null, "Năm phải nhập số!", "Thông báo", JOptionPane.CLOSED_OPTION);
			}
		});
		tf_year.setColumns(10);
		tf_year.setBounds(103, 120, 150, 19);
		panel_1.add(tf_year);
		
		JLabel lblHTn = new JLabel("Họ Tên");
		lblHTn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblHTn.setBounds(53, 215, 45, 29);
		panel_1.add(lblHTn);
		
		JLabel lblTui = new JLabel("Tuổi");
		lblTui.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTui.setBounds(53, 264, 35, 29);
		panel_1.add(lblTui);
		
		tf_nameCustomer = new JTextField();
		tf_nameCustomer.setColumns(10);
		tf_nameCustomer.setBounds(103, 221, 116, 19);
		panel_1.add(tf_nameCustomer);
		
		tf_ageCustomer = new JTextField();
		tf_ageCustomer.setColumns(10);
		tf_ageCustomer.setBounds(103, 270, 116, 19);
		panel_1.add(tf_ageCustomer);
		
		JLabel lblGiiTnh = new JLabel("Giới Tính");
		lblGiiTnh.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblGiiTnh.setBounds(229, 215, 59, 29);
		panel_1.add(lblGiiTnh);
		
		JLabel lblQucTch = new JLabel("Quốc Tịch");
		lblQucTch.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblQucTch.setBounds(229, 266, 59, 29);
		panel_1.add(lblQucTch);
		
		tf_genderCustomer = new JTextField();
		tf_genderCustomer.setColumns(10);
		tf_genderCustomer.setBounds(292, 221, 80, 19);
		panel_1.add(tf_genderCustomer);
		
		tf_nationalityCustomer = new JTextField();
		tf_nationalityCustomer.setColumns(10);
		tf_nationalityCustomer.setBounds(292, 270, 80, 19);
		panel_1.add(tf_nationalityCustomer);
		
		


		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int selectedRow = table.getSelectedRow();
				
				if(selectedRow != -1) {
					Vector<Object> row = rows.get(selectedRow);
					if(rb_khachHang.isSelected())
						getCustomer(row.get(0).toString());
				}
				
			}
		});
		table.setBounds(418, 92, 672, 385);
		contentPane.add(table);
		
		tf_nameCustomer.setEditable(false);
		tf_ageCustomer.setEditable(false);
		tf_nationalityCustomer.setEditable(false);
		tf_genderCustomer.setEditable(false);
		
		JButton btn_exit = new JButton("Thoát");
		btn_exit.setIcon(new ImageIcon("C:\\Users\\Admin\\Documents\\jav2\\BTL_10\\BTL-JAVA10\\src\\images\\exit.png"));
		btn_exit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				exitForm();
			}
		});
		btn_exit.setBounds(203, 448, 96, 23);
		panel_1.add(btn_exit);

		columns2.add("Mã khách hàng");
		columns2.add("Chứng minh thư");
		columns2.add("Số điện thoại");
		columns2.add("Mã Phòng");
		columns2.add("Ngày nhận phòng");
		columns2.add("Ngày trả phòng");

		
		columns1.add("Mã hoá đơn");
		columns1.add("Mã nhân viên");
		columns1.add("Mã phòng");
		columns1.add("Thời gian thanh toán");
		columns1.add("Tổng tiền");
		
		columns3.add("Mã phòng");
		columns3.add("Tên phòng");
		columns3.add("Loại phòng");
		columns3.add("Giá phòng");
		columns3.add("Trạng thái");
		columns3.add("ghi chú");
		columns3.add("Mã nhân viên");
		columns3.add("Mã dịch vụ");

		columns4.add("Mã khách");
		columns4.add("Tên khách");
		columns4.add("Chứng minh thư");
		columns4.add("Mã phòng");
		columns4.add("Ngày nhận phòng");
		columns4.add("Ngày trả phòng");
		
	}


	private void getList_byMonthAndYear(String month, String year) {
		dtm.setNumRows(0);
		
		
		lst = pp.getList_byMonthAndYear(month, year);
		for (int i = 0; i < lst.size(); i++) {
			Vector<Object> x = lst.get(i);
			Vector<Object> tbrow = new Vector<>();
			tbrow.add(x.get(0));
			tbrow.add(x.get(1));
			tbrow.add(x.get(2));
			tbrow.add(x.get(3));
			tbrow.add(x.get(4));

			rows.add(tbrow);

		}
		dtm.setDataVector(rows, columns1);
		dtm.insertRow(0, columns1);
		table.setModel(dtm);
	}

	private void getList_Customer() {
		dtm.setNumRows(0);
		
		
		lst = pp.getList_Customer();
		for (int i = 0; i < lst.size(); i++) {
			Vector<Object> x = lst.get(i);
			Vector<Object> tbrow = new Vector<>();
			tbrow.add(x.get(0));
			tbrow.add(x.get(2));
			tbrow.add(x.get(6));
			tbrow.add(x.get(7));
			tbrow.add(x.get(8));
			tbrow.add(x.get(9));

			rows.add(tbrow);

		}
		dtm.setDataVector(rows, columns2);
		dtm.insertRow(0, columns2);
		table.setModel(dtm);
	}
	
	private void getList_Room() {
		dtm.setNumRows(0);
		lst = pp.getList_room();
		for (int i = 0; i < lst.size(); i++) {
			Vector<Object> x = lst.get(i);
			Vector<Object> tbrow = new Vector<>();
			tbrow.add(x.get(0));
			tbrow.add(x.get(1));
			tbrow.add(x.get(2));
			tbrow.add(x.get(3));
			tbrow.add(x.get(4));
			tbrow.add(x.get(5));
			tbrow.add(x.get(6));
			tbrow.add(x.get(7));
			rows.add(tbrow);

		}
		dtm.setDataVector(rows, columns3);
		dtm.insertRow(0, columns3);
		table.setModel(dtm);
	}
	
	public void getCustomer(String idCustomer) {
		c = pp.get_Customer(idCustomer);
		tf_nameCustomer.setText(c.getNameCustomer());
		tf_ageCustomer.setText(c.getAgeCustomer()+"");
		tf_nationalityCustomer.setText(c.getNationalityCustomer());
		if(c.isGenderCustomer()==false) 
			tf_genderCustomer.setText("nam");
		else
			tf_genderCustomer.setText("Nu");
	}
	
	public void getCustomer_checkOut() {
		dtm.setNumRows(0);
		lst = pp.getList_CustomerCheckOut();
		for(int i=0;i<lst.size();i++) {
			Vector<Object> x = lst.get(i);
			Vector<Object> tbrow = new Vector<>();
			tbrow.add(x.get(0));
			tbrow.add(x.get(1));
			tbrow.add(x.get(2));
			tbrow.add(x.get(3));
			tbrow.add(x.get(4));
			tbrow.add(x.get(5));
			rows.add(tbrow);
		}
	
		dtm.setDataVector(rows, columns4);
		dtm.insertRow(0, columns4);
		table.setModel(dtm);
	}
	public void exitForm() {
		if(JOptionPane.showConfirmDialog(null, "Bạn có muốn thoát không?","Thoát", JOptionPane.YES_NO_CANCEL_OPTION) == 0) {
			this.setVisible(false);
			GUI_FrameMain e = new GUI_FrameMain();
			e.setVisible(true);
		}
	}
}
