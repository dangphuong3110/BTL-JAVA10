package BTL;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Vector;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class GUI_Customer extends JFrame {

	private JPanel contentPane;
	private JTable tb_Customer;
	private DefaultTableModel dtm = new DefaultTableModel();
	private Vector<String> columns = new Vector<>();
	private Vector<Vector<Object>> rows = new Vector<>();
	private Process_Customer pc = new Process_Customer();
	private ArrayList<Vector<Object>> lsc;
	private ArrayList<String> lsr, lsid;
	private JTextField tf_idCustomer, tf_nameCustomer, tf_identityCardCustomer, tf_nationalityCustomer, tf_ageCustomer, tf_contactCustomer;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JComboBox cb_nameRoom = new JComboBox();
	private JRadioButton rb_male = new JRadioButton("Nam");
	private JRadioButton rb_female = new JRadioButton("Nữ");
	private JOptionPane jOP_Check = new javax.swing.JOptionPane();
	private JOptionPane jOP_Message = new JOptionPane();
	private JComboBox cb_idRoom = new JComboBox();
	private JDateChooser dc_dateCheckIn;
	private JDateChooser dc_dateCheckOut;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_Customer frame = new GUI_Customer();
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
	public GUI_Customer() {
		setTitle("Quản lý khách hàng");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1124, 648);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 255, 255));
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pn_Customer = new JPanel();
		pn_Customer.setFont(new Font("Serif", Font.PLAIN, 20));
		pn_Customer.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Th\u00F4ng tin kh\u00E1ch h\u00E0ng", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		pn_Customer.setBounds(25, 32, 398, 551);
		contentPane.add(pn_Customer);
		pn_Customer.setLayout(null);
		
		JLabel lb_idCustomer = new JLabel("Mã khách hàng");
		lb_idCustomer.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lb_idCustomer.setBounds(28, 30, 85, 21);
		pn_Customer.add(lb_idCustomer);
		
		JLabel lb_nameCustomer = new JLabel("Tên khách hàng");
		lb_nameCustomer.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lb_nameCustomer.setBounds(28, 73, 100, 21);
		pn_Customer.add(lb_nameCustomer);
		
		JLabel lb_identityCardCustomer = new JLabel("Chứng minh nhân dân");
		lb_identityCardCustomer.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lb_identityCardCustomer.setBounds(28, 115, 139, 21);
		pn_Customer.add(lb_identityCardCustomer);
		
		JLabel lb_nationalityCustomer = new JLabel("Quốc tịch");
		lb_nationalityCustomer.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lb_nationalityCustomer.setBounds(28, 153, 85, 21);
		pn_Customer.add(lb_nationalityCustomer);
		
		JLabel lb_genderCustomer = new JLabel("Giới tính");
		lb_genderCustomer.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lb_genderCustomer.setBounds(28, 195, 85, 21);
		pn_Customer.add(lb_genderCustomer);
		
		JLabel lb_ageCustomer = new JLabel("Tuổi");
		lb_ageCustomer.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lb_ageCustomer.setBounds(28, 234, 85, 21);
		pn_Customer.add(lb_ageCustomer);
		
		JLabel lb_contactCustomer = new JLabel("Số điện thoại");
		lb_contactCustomer.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lb_contactCustomer.setBounds(28, 275, 85, 21);
		pn_Customer.add(lb_contactCustomer);
		
		JLabel lb_nameRoom = new JLabel("Tên phòng");
		lb_nameRoom.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lb_nameRoom.setBounds(28, 319, 85, 21);
		pn_Customer.add(lb_nameRoom);
		
		tf_idCustomer = new JTextField();
		tf_idCustomer.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tf_idCustomer.setBounds(191, 31, 154, 19);
		pn_Customer.add(tf_idCustomer);
		tf_idCustomer.setColumns(10);
		
		tf_nameCustomer = new JTextField();
		tf_nameCustomer.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tf_nameCustomer.setColumns(10);
		tf_nameCustomer.setBounds(191, 74, 154, 19);
		pn_Customer.add(tf_nameCustomer);
		
		tf_identityCardCustomer = new JTextField();
		tf_identityCardCustomer.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tf_identityCardCustomer.setColumns(10);
		tf_identityCardCustomer.setBounds(191, 116, 154, 19);
		pn_Customer.add(tf_identityCardCustomer);
		
		tf_nationalityCustomer = new JTextField();
		tf_nationalityCustomer.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tf_nationalityCustomer.setColumns(10);
		tf_nationalityCustomer.setBounds(191, 154, 154, 19);
		pn_Customer.add(tf_nationalityCustomer);
		
		tf_ageCustomer = new JTextField();
		tf_ageCustomer.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tf_ageCustomer.setColumns(10);
		tf_ageCustomer.setBounds(191, 235, 154, 19);
		pn_Customer.add(tf_ageCustomer);
		
		tf_contactCustomer = new JTextField();
		tf_contactCustomer.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tf_contactCustomer.setColumns(10);
		tf_contactCustomer.setBounds(191, 276, 154, 19);
		pn_Customer.add(tf_contactCustomer);
		cb_nameRoom.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				getIDRoomToCbb(cb_nameRoom.getSelectedItem() + "");
			}
		});
		cb_nameRoom.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		cb_nameRoom.setBounds(191, 319, 154, 21);
		pn_Customer.add(cb_nameRoom);
		
		buttonGroup.add(rb_male);
		rb_male.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rb_male.setBounds(191, 195, 74, 21);
		pn_Customer.add(rb_male);
	
		buttonGroup.add(rb_female);
		rb_female.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rb_female.setBounds(271, 195, 74, 21);
		pn_Customer.add(rb_female);
		
		JButton btn_Insert = new JButton("Thêm");
		btn_Insert.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btn_Insert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertCustomer();
			}
		});
		btn_Insert.setIcon(new ImageIcon("F:\\Meap\\Documents\\TLU-Sophomore2021_2022\\LTWin\\BTL_NguyenDangPhuong_2051063453\\them.png"));
		btn_Insert.setBounds(145, 485, 109, 21);
		pn_Customer.add(btn_Insert);
		
		JButton btn_Update = new JButton("Sửa");
		btn_Update.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btn_Update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateCustomer();
			}
		});
		btn_Update.setIcon(new ImageIcon("F:\\Meap\\Documents\\TLU-Sophomore2021_2022\\LTWin\\BTL_NguyenDangPhuong_2051063453\\icon-sua.png"));
		btn_Update.setBounds(264, 485, 103, 21);
		pn_Customer.add(btn_Update);
		
		JButton btn_Delete = new JButton("Xóa");
		btn_Delete.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btn_Delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteCustomer();
			}
		});
		btn_Delete.setIcon(new ImageIcon("F:\\Meap\\Documents\\TLU-Sophomore2021_2022\\LTWin\\BTL_NguyenDangPhuong_2051063453\\delete.png"));
		btn_Delete.setBounds(28, 516, 103, 21);
		pn_Customer.add(btn_Delete);
		
		JButton btn_Clear = new JButton("Clear");
		btn_Clear.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btn_Clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearInput();
			}
		});
		btn_Clear.setIcon(new ImageIcon("F:\\Meap\\Documents\\TLU-Sophomore2021_2022\\LTWin\\BTL_NguyenDangPhuong_2051063453\\clear2.png"));
		btn_Clear.setBounds(145, 516, 109, 21);
		pn_Customer.add(btn_Clear);
		
		JButton btn_Exit = new JButton("Thoát");
		btn_Exit.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btn_Exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exitForm();
			}
		});
		btn_Exit.setIcon(new ImageIcon("F:\\Meap\\Documents\\TLU-Sophomore2021_2022\\LTWin\\BTL_NguyenDangPhuong_2051063453\\icon-xoa.png"));
		btn_Exit.setBounds(264, 516, 103, 21);
		pn_Customer.add(btn_Exit);
		
		JLabel lb_idRoom = new JLabel("Mã phòng");
		lb_idRoom.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lb_idRoom.setBounds(28, 359, 85, 22);
		pn_Customer.add(lb_idRoom);
		
		cb_idRoom.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cb_idRoom.setBounds(191, 360, 154, 21);
		pn_Customer.add(cb_idRoom);
		
		JLabel lb_dateCheckIn = new JLabel("Ngày thuê phòng");
		lb_dateCheckIn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lb_dateCheckIn.setBounds(28, 400, 120, 22);
		pn_Customer.add(lb_dateCheckIn);
		
		dc_dateCheckIn = new JDateChooser();
		dc_dateCheckIn.setDateFormatString("yyyy/MM/dd");
		dc_dateCheckIn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		dc_dateCheckIn.setBounds(191, 403, 154, 19);
		pn_Customer.add(dc_dateCheckIn);
		
		JLabel lb_dateCheckOut = new JLabel("Ngày trả phòng");
		lb_dateCheckOut.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lb_dateCheckOut.setBounds(28, 440, 120, 22);
		pn_Customer.add(lb_dateCheckOut);
		
		dc_dateCheckOut = new JDateChooser();
		dc_dateCheckOut.setDateFormatString("yyyy/MM/dd");
		dc_dateCheckOut.setFont(new Font("Tahoma", Font.PLAIN, 12));
		dc_dateCheckOut.setBounds(191, 443, 154, 19);
		pn_Customer.add(dc_dateCheckOut);
		
		JButton btn_Find = new JButton("Tìm kiếm");
		btn_Find.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				findCustomer_byID(tf_idCustomer.getText());
			}
		});
		btn_Find.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btn_Find.setBounds(28, 486, 103, 21);
		pn_Customer.add(btn_Find);
		
		tb_Customer = new JTable();
		tb_Customer.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tb_Customer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int selectedRow = tb_Customer.getSelectedRow();
				
				if(selectedRow != -1 && selectedRow != 0) {
					Vector<Object> row = rows.get(selectedRow);
					tf_idCustomer.setText(row.get(0).toString());
					tf_idCustomer.enable(false);
					tf_nameCustomer.setText(row.get(1).toString());
					tf_identityCardCustomer.setText(row.get(2).toString());
					tf_nationalityCustomer.setText(row.get(3).toString());
					if(row.get(4).toString().equals("Nam")) {
						rb_male.setSelected(true);
					}
					else
						rb_female.setSelected(true);
					tf_ageCustomer.setText(row.get(5).toString());
					tf_contactCustomer.setText(row.get(6).toString());
					boolean check = true;
					for(int i = 0; i < cb_nameRoom.getItemCount(); i++)
						if(cb_nameRoom.getItemAt(i).toString().equals(row.get(7).toString()))
							check = false;
					if(check)
						cb_nameRoom.addItem(row.get(7));
					cb_nameRoom.setSelectedItem(row.get(7).toString());
					SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
					try {
						Date dateCheckIn = formatter.parse(row.get(8).toString());
						dc_dateCheckIn.setDate(dateCheckIn);
						Date dateCheckOut = formatter.parse(row.get(9).toString());
						dc_dateCheckOut.setDate(dateCheckOut);
					} catch (ParseException e1) {
					
					}
				}
	
				if(selectedRow == 0) {
					tf_idCustomer.setText("");
					tf_idCustomer.enable(true);
					tf_nameCustomer.setText("");
					tf_identityCardCustomer.setText("");
					tf_nationalityCustomer.setText("");
					rb_male.setSelected(false);
					rb_female.setSelected(false);
					tf_ageCustomer.setText("");
					tf_contactCustomer.setText("");
					cb_nameRoom.setSelectedIndex(0);
					dc_dateCheckIn.setDate(null);
					dc_dateCheckOut.setDate(null);
					getListCustomer();
					getNameRoomToCbb();
				}
			}
		});
		tb_Customer.setBounds(433, 86, 653, 421);
		contentPane.add(tb_Customer);
		
		columns.add("Mã KH");
		columns.add("Tên KH");
		columns.add("CMND");
		columns.add("Quốc tịch");
		columns.add("Giới tính");
		columns.add("Tuổi");
		columns.add("SĐT");
		columns.add("Tên phòng");
		columns.add("Ngày thuê");
		columns.add("Ngày trả");
		
		getListCustomer();
		getNameRoomToCbb();
	}

	private void getNameRoomToCbb() {
		lsr = pc.getListNameRoom();
		cb_nameRoom.removeAllItems();
		for(int i = 0; i < lsr.size(); i++)
			if(pc.checkStateRoomA(lsr.get(i)))
				cb_nameRoom.addItem(lsr.get(i));
	}

	private void getListCustomer() {
		dtm.setNumRows(0);
		lsc = pc.getListCustomer();
		for(int i = 0; i < lsc.size(); i++) {
			Vector<Object> tbRow = lsc.get(i);
			rows.add(tbRow);
		}
		dtm.setDataVector(rows, columns);
		dtm.insertRow(0, columns);
		tb_Customer.setModel(dtm);
	}
	
	public void findCustomer_byID(String idCustomer) {
		if(tf_idCustomer.getText().equals("")) {
			JOptionPane.showConfirmDialog(null, "Vui lòng nhập ID khách hàng cần tìm!", "Thông báo", JOptionPane.CLOSED_OPTION);
		}
		else if(pc.findCustomer_byID(idCustomer).size() == 0) {
			jOP_Message.showConfirmDialog(null, "Không có khách hàng cần tìm!", "Thông báo", JOptionPane.CLOSED_OPTION);
			}
			else{
				if(jOP_Check.showConfirmDialog(null, "Bạn có tìm kiếm khách hàng theo mã này?", "Tìm kiếm khách hàng", jOP_Check.YES_NO_CANCEL_OPTION) == 0){
					Vector<Object> customer = pc.findCustomer_byID(idCustomer);
					dtm.setNumRows(0);
					rows.add(customer);
					dtm.setDataVector(rows, columns);
					dtm.insertRow(0, columns);
					tb_Customer.setModel(dtm);
					tf_nameCustomer.setText(rows.get(1).get(1).toString());
					tf_identityCardCustomer.setText(rows.get(1).get(2).toString());
					tf_nationalityCustomer.setText(rows.get(1).get(3).toString());
					if(rows.get(1).get(4).toString().equals("Nam"))
						rb_male.setSelected(true);
					else
						rb_female.setSelected(true);
					tf_ageCustomer.setText(rows.get(1).get(5).toString());
					tf_contactCustomer.setText(rows.get(1).get(6).toString());
					cb_nameRoom.removeAllItems();
					cb_nameRoom.addItem(rows.get(1).get(7));
					cb_nameRoom.setSelectedItem(rows.get(1).get(7).toString());
					SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
					try {
						Date dateCheckIn = formatter.parse(rows.get(1).get(8).toString());
						dc_dateCheckIn.setDate(dateCheckIn);
						Date dateCheckOut = formatter.parse(rows.get(1).get(9).toString());
						dc_dateCheckOut.setDate(dateCheckOut);
					} catch (ParseException e1) {
						
					}
				}
			}
	}
	
	public void insertCustomer() {
		if(tf_idCustomer.getText().equals("") || tf_nameCustomer.getText().equals("") || tf_identityCardCustomer.getText().equals("") || tf_nationalityCustomer.getText().equals("") || 
				(rb_male.isSelected()==false && rb_female.isSelected()==false) || tf_ageCustomer.getText().equals("") || tf_contactCustomer.getText().equals("") || 
				cb_nameRoom.getSelectedItem().toString().equals("") || dc_dateCheckIn.getDate() == null || dc_dateCheckOut.getDate() == null)
			jOP_Message.showConfirmDialog(null, "Vui lòng nhập đủ thông tin khách hàng!", "Thông báo", JOptionPane.CLOSED_OPTION);
		else {
			String idCustomer = tf_idCustomer.getText();
			String nameCustomer = tf_nameCustomer.getText();
			String identityCardCustomer = tf_identityCardCustomer.getText();
			String nationalityCustomer = tf_nationalityCustomer.getText();
			boolean genderCustomer = rb_male.isSelected();
			String ageCustomer = tf_ageCustomer.getText();
			String contactCustomer = tf_contactCustomer.getText();
			String idRoom = cb_idRoom.getSelectedItem() + "";
			String nameRoom = cb_nameRoom.getSelectedItem() + "";
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			String dateCheckIn = formatter.format(dc_dateCheckIn.getDate());
			String dateCheckOut = formatter.format(dc_dateCheckOut.getDate());
			if(jOP_Check.showConfirmDialog(null, "Bạn có muốn thêm khách hàng này?", "Thêm khách hàng", jOP_Check.YES_NO_CANCEL_OPTION) == 0){
				if(pc.insertCustomer(idCustomer, nameCustomer, identityCardCustomer, nationalityCustomer, genderCustomer, Integer.parseInt(ageCustomer), contactCustomer, idRoom, dateCheckIn, dateCheckOut) && pc.changedStateRoom(nameRoom, "Unavailable")) {
					getListCustomer();
					getNameRoomToCbb();
					tf_idCustomer.setText("");
					tf_nameCustomer.setText("");
					tf_identityCardCustomer.setText("");
					tf_nationalityCustomer.setText("");
					rb_male.setSelected(false);
					rb_female.setSelected(false);
					tf_ageCustomer.setText("");
					tf_contactCustomer.setText("");
					cb_nameRoom.setSelectedIndex(0);
					dc_dateCheckIn.setDate(null);
					dc_dateCheckOut.setDate(null);
					jOP_Message.showMessageDialog(null, "Thêm khách hàng thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
				}
				else
					jOP_Message.showMessageDialog(null, "Mã khách hàng bị trùng!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
	public void updateCustomer() {
		if(tf_idCustomer.getText().equals("") || tf_nameCustomer.getText().equals("") || tf_identityCardCustomer.getText().equals("") || tf_nationalityCustomer.getText().equals("") || 
				(rb_male.isSelected()==false && rb_female.isSelected()==false) || tf_ageCustomer.getText().equals("") || tf_contactCustomer.getText().equals("") || 
				cb_nameRoom.getSelectedItem().toString().equals("") || dc_dateCheckIn.getDate() == null || dc_dateCheckOut.getDate() == null)
			jOP_Message.showConfirmDialog(null, "Vui lòng nhập đủ thông tin khách hàng!", "Thông báo", JOptionPane.CLOSED_OPTION);
		else {
			String idCustomer = tf_idCustomer.getText();
			String nameCustomer = tf_nameCustomer.getText();
			String identityCardCustomer = tf_identityCardCustomer.getText();
			String nationalityCustomer = tf_nationalityCustomer.getText();
			boolean genderCustomer = rb_male.isSelected();
			int ageCustomer = Integer.parseInt(tf_ageCustomer.getText());
			String contactCustomer = tf_contactCustomer.getText();
			String idRoom = cb_idRoom.getSelectedItem() + "";
			String nameRoom = cb_nameRoom.getSelectedItem() + "";
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			String dateCheckIn = formatter.format(dc_dateCheckIn.getDate());
			String dateCheckOut = formatter.format(dc_dateCheckOut.getDate());
			int selectedRow = tb_Customer.getSelectedRow();
			Vector<Object> row = rows.get(selectedRow);
			if(jOP_Check.showConfirmDialog(null, "Bạn có muốn cập nhật thông tin khách hàng này?", "Cập nhật khách hàng", jOP_Check.YES_NO_CANCEL_OPTION) == 0){
				if(pc.updateCustomer(idCustomer, nameCustomer, identityCardCustomer, nationalityCustomer, genderCustomer,ageCustomer, contactCustomer, idRoom, dateCheckIn, dateCheckOut) && pc.changedStateRoom(row.get(7).toString(), "Available") && pc.changedStateRoom(nameRoom, "Unavailable")) {
					getListCustomer();
					getNameRoomToCbb();
					tf_idCustomer.setText("");
					tf_idCustomer.enable(true);
					tf_nameCustomer.setText("");
					tf_identityCardCustomer.setText("");
					tf_nationalityCustomer.setText("");
					rb_male.setSelected(false);
					rb_female.setSelected(false);
					tf_ageCustomer.setText("");
					tf_contactCustomer.setText("");
					cb_nameRoom.setSelectedIndex(0);
					dc_dateCheckIn.setDate(null);
					dc_dateCheckOut.setDate(null);
					jOP_Message.showMessageDialog(null, "Cập nhật thông tin khách hàng thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
				}
				else
					jOP_Message.showMessageDialog(null, "Cập nhật thông tin khách hàng không thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
	
	public void deleteCustomer() {
		int[] selectedRow = tb_Customer.getSelectedRows();
		if(selectedRow.length == 1) {
			if(jOP_Check.showConfirmDialog(null, "Bạn có muốn xóa khách hàng này?","Xóa khách hàng", jOP_Check.YES_NO_CANCEL_OPTION) == 0) {
				String idCustomer = rows.get(selectedRow[0]).get(0).toString();
				if(pc.deleteCustomer(idCustomer)) {
					getListCustomer();
					getNameRoomToCbb();
					tf_idCustomer.setText("");
					tf_idCustomer.enable(true);
					tf_nameCustomer.setText("");
					tf_identityCardCustomer.setText("");
					tf_nationalityCustomer.setText("");
					rb_male.setSelected(false);
					rb_female.setSelected(false);
					tf_ageCustomer.setText("");
					tf_contactCustomer.setText("");
					cb_nameRoom.setSelectedIndex(0);
					dc_dateCheckIn.setDate(null);
					dc_dateCheckOut.setDate(null);
					jOP_Message.showMessageDialog(null, "Xóa khách hàng thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
				}
				else
					jOP_Message.showMessageDialog(null, "Xóa khách hàng không thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		else {
			if(jOP_Check.showConfirmDialog(null, "Bạn có muốn xóa các khách hàng này?","Xóa khách hàng", jOP_Check.YES_NO_CANCEL_OPTION) == 0) {
				int check = 0;
				for(int i : selectedRow) {
					String idCustomer = rows.get(i - check).get(0).toString();
					if(pc.deleteCustomer(idCustomer)) {
						getListCustomer();
						getNameRoomToCbb();
						check++;
					}
				}	
				if(check > 0) {
					jOP_Message.showMessageDialog(null, "Xóa các khách hàng đã chọn thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
					tf_idCustomer.setText("");
					tf_idCustomer.enable(true);
					tf_nameCustomer.setText("");
					tf_identityCardCustomer.setText("");
					tf_nationalityCustomer.setText("");
					rb_male.setSelected(false);
					rb_female.setSelected(false);
					tf_ageCustomer.setText("");
					tf_contactCustomer.setText("");
					cb_nameRoom.setSelectedIndex(0);
					dc_dateCheckIn.setDate(null);
					dc_dateCheckOut.setDate(null);
				}
				else
					jOP_Message.showMessageDialog(null, "Xóa khách hàng không thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
	
	public void clearInput() {
		if(jOP_Check.showConfirmDialog(null, "Bạn có muốn xóa tất cả ô nhập dữ liệu không?","Xóa ô nhập", jOP_Check.YES_NO_CANCEL_OPTION) == 0) {
			getListCustomer();
			getNameRoomToCbb();
			tf_idCustomer.setText("");
			tf_idCustomer.enable(true);
			tf_nameCustomer.setText("");
			tf_identityCardCustomer.setText("");
			tf_nationalityCustomer.setText("");
			buttonGroup.remove(rb_male);
			buttonGroup.remove(rb_female);
			rb_male.setSelected(false);
			rb_female.setSelected(false);
			buttonGroup.add(rb_male);
			buttonGroup.add(rb_female);
			tf_ageCustomer.setText("");
			tf_contactCustomer.setText("");
			cb_nameRoom.setSelectedIndex(0);
			dc_dateCheckIn.setDate(null);
			dc_dateCheckOut.setDate(null);
			jOP_Message.showMessageDialog(null, "Xóa ô nhập dữ liệu thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	public void getIDRoomToCbb(String nameRoom) {
		lsid = pc.getIDRoom_byNameRoom(nameRoom);
		cb_idRoom.removeAllItems();
		for(int i = 0; i < lsid.size(); i++)
			cb_idRoom.addItem(lsid.get(i));
	}
	
	public void exitForm() {
		if(jOP_Check.showConfirmDialog(null, "Bạn có muốn thoát chương trình quản lý khách hàng không?","Thoát", jOP_Check.YES_NO_CANCEL_OPTION) == 0)
			System.exit(0);
	}
}
