package BTL;

import java.awt.EventQueue; 
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.UIManager;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.xml.crypto.Data;

import com.toedter.calendar.JDateChooser;



import javax.swing.border.EtchedBorder;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
//import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class GUI_Bill extends JFrame {

	private JPanel contentPane;
	private JTable tb_Bill;
	private JTextField tf_Bill;
	private JComboBox cb_nameStaff = new JComboBox();
	private JComboBox cb_nameRoom = new JComboBox();
	private JDateChooser dateChooser;
	private JOptionPane jOP_Check = new javax.swing.JOptionPane();
	private JOptionPane jOP_Message = new JOptionPane();
	private JComboBox cb_idStaff = new JComboBox();
	private JComboBox cb_idRoom = new JComboBox();

	private Vector<String> columns = new Vector<>();
	private Vector<Vector<Object>> rows = new Vector<>();
	private DefaultTableModel dtm = new DefaultTableModel();
	private ArrayList<Vector<Object>> B = new ArrayList<>();
	private Process_Bill pb = new Process_Bill();
	private ArrayList<Staff> s;
	private ArrayList<String> lsnr, lsids, lsidr;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_Bill frame = new GUI_Bill();
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
	public GUI_Bill() {
		setTitle("Thông tin hóa đơn");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 960, 505);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Th\u00F4ng tin h\u00F3a \u0111\u01A1n", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		panel_2.setBounds(21, 42, 341, 398);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JButton btn_Insert = new JButton("Thêm");
		btn_Insert.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btn_Insert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// them
				insertBill();
			}
		});
		btn_Insert.setSelectedIcon(new ImageIcon("C:\\Users\\Hi Windows 10\\Pictures\\Camera Roll\\307250204_598143505384664_999337979866899336_n.png"));
		btn_Insert.setBounds(24, 282, 85, 21);
		panel_2.add(btn_Insert);
		
		JButton btn_Update = new JButton("Sửa");
		btn_Update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateBill();
			}
		});
		btn_Update.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btn_Update.setBounds(125, 282, 85, 21);
		panel_2.add(btn_Update);
		
		JButton btn_Clear = new JButton("Clear");
		btn_Clear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btn_Clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
			}
		});
		btn_Clear.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btn_Clear.setBounds(125, 325, 85, 21);
		panel_2.add(btn_Clear);
		
		JButton btn_Delete = new JButton("Xóa");
		btn_Delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteBill();
			}
		});
		btn_Delete.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btn_Delete.setBounds(231, 282, 85, 21);
		panel_2.add(btn_Delete);
		
		JButton btn_Exit = new JButton("Thoát");
		btn_Exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// thoat
				if(jOP_Check.showConfirmDialog(null, "Bạn có muốn thoát chương trình?", "Thoát", jOP_Check.YES_NO_OPTION) == 0) {
					System.exit(0);
				}
				
			}
		});
		btn_Exit.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btn_Exit.setBounds(231, 325, 85, 21);
		panel_2.add(btn_Exit);
		
		JLabel lblNewLabel = new JLabel("Mã hóa đơn");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(30, 39, 92, 21);
		panel_2.add(lblNewLabel);
		
		JLabel lblMNhnVin = new JLabel("Tên nhân viên");
		lblMNhnVin.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMNhnVin.setBounds(30, 80, 92, 21);
		panel_2.add(lblMNhnVin);
		
		JLabel lblMPhng = new JLabel("Tên phòng");
		lblMPhng.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMPhng.setBounds(30, 154, 92, 21);
		panel_2.add(lblMPhng);
		
		JLabel lblNgy = new JLabel("Ngày");
		lblNgy.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNgy.setBounds(30, 214, 92, 21);
		panel_2.add(lblNgy);
		
		tf_Bill = new JTextField();
		tf_Bill.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tf_Bill.setBounds(125, 42, 163, 19);
		panel_2.add(tf_Bill);
		tf_Bill.setColumns(10);
		
		cb_nameStaff.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				// itemstateChange ten nhan vien
				display_idStaff(cb_nameStaff.getSelectedItem().toString());
			}
		});
		cb_nameStaff.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cb_nameStaff.setBounds(125, 82, 163, 21);
		panel_2.add(cb_nameStaff);
		
		cb_nameRoom.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				// itemstateChanged ma phong
				if(cb_nameRoom.getSelectedItem() != null)
					display_idRoom(cb_nameRoom.getSelectedItem().toString());
				else
					cb_idRoom.removeAllItems();
			}
		});
		cb_nameRoom.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cb_nameRoom.setBounds(125, 154, 163, 21);
		panel_2.add(cb_nameRoom);
		
		dateChooser = new JDateChooser();
		dateChooser.getCalendarButton().setFont(new Font("Tahoma", Font.PLAIN, 15));
		dateChooser.setDateFormatString("yyyy-MM-dd");
		dateChooser.setBounds(125, 216, 163,19);
		panel_2.add(dateChooser);
		
		JLabel lblNewLabel_1 = new JLabel("ID nhân viên");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(30, 126, 79, 13);
		panel_2.add(lblNewLabel_1);
		cb_idStaff.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				// itemStateChanged ten phong
				if(cb_idStaff.getSelectedItem() != null)
					display_nameRoom(cb_idStaff.getSelectedItem() + "");
			}
		});
		cb_idStaff.setBounds(125, 123, 163, 21);
		panel_2.add(cb_idStaff);
		
		JLabel lblNewLabel_2 = new JLabel("ID phòng");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(30, 189, 79, 13);
		panel_2.add(lblNewLabel_2);
		cb_idRoom.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(cb_idRoom.getSelectedItem() != null) {
					String dateCheckOut = pb.getDateCheckOut(cb_idRoom.getSelectedItem().toString());
					SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
					if(dateCheckOut.equals("")==false) {
						try {
							Date date = formatter.parse(dateCheckOut);
							dateChooser.setDate(date);
						}
						catch (ParseException e1) {
							e1.printStackTrace();
						}
					}
				}
				else {
					dateChooser.setDate(null);
				}
			}
		});
		cb_idRoom.setBounds(125, 185, 163, 21);
		panel_2.add(cb_idRoom);
		
		JButton btn_Find = new JButton("Tìm kiếm");
		btn_Find.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// button Search
				findBill();
			}
		});
		btn_Find.setBounds(24, 326, 85, 21);
		panel_2.add(btn_Find);
		
		
		tb_Bill = new JTable();
		tb_Bill.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// click table
				int row = tb_Bill.getSelectedRow();
				if(row != -1 && row != 0) {
					Vector<Object> tb = rows.get(row);	
					tf_Bill.setText(tb.get(0)+"");
					cb_nameStaff.setSelectedItem(tb.get(1)+"");
					boolean check = true;
					for(int i = 0; i < cb_nameRoom.getItemCount(); i++)
						if(cb_nameRoom.getItemAt(i).toString().equals(tb.get(2).toString()))
							check = false;
					if(check)
						cb_nameRoom.addItem(tb.get(2));
					cb_nameRoom.setSelectedItem(tb.get(2)+"");
					SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
					Date date;
					try {
						date = formatter.parse(tb.get(3)+"");
						dateChooser.setDate(date);
					}
					catch (ParseException e1) {
						e1.printStackTrace();
					}
					
//					tf_Total.setText(tb.get(4)+"");
					tf_Bill.enable(false);
				}
				if(row == 0) {
					tf_Bill.setText("");
					if(cb_nameRoom.getItemCount() > 0)
						cb_nameRoom.setSelectedIndex(0);
					dateChooser.setDate(null);
				}
			}
		});
		tb_Bill.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tb_Bill.setBounds(391, 64, 545, 357);
		contentPane.add(tb_Bill);
	
		columns.add("Mã hóa đơn");
		columns.add("Tên nhân viên");
		columns.add("Tên phòng");
		columns.add("Ngày");
		columns.add("Giá hóa đơn");
		
		getAllBill();
		// combobox nameStaff
		s = pb.findingStaff();
		for(int i=0; i<s.size(); i++) {
			int count = 0;
			for(int j=i+1; j<s.size(); j++)
				if(s.get(i).getNameStaff().equals(s.get(j).getNameStaff()))
					count++;
			if(count == 0)
				cb_nameStaff.addItem(s.get(i).getNameStaff());
		}	
	}
	
	private void getAllBill() {
		dtm.setNumRows(0);
		B = pb.getListBill();
		for(int i=0; i<B.size(); i++) {
			Vector<Object> b = B.get(i);
			Vector<Object> tbrow = new Vector<>();
			tbrow.add(b.get(0));
			tbrow.add(b.get(1));
			tbrow.add(b.get(2));
			tbrow.add(b.get(3));
			tbrow.add(b.get(4));
			rows.add(tbrow);
		}
		dtm.setDataVector(rows, columns);
		dtm.insertRow(0, columns);
		tb_Bill.setModel(dtm);
	}
	
	private void insertBill() {
		String idbill = tf_Bill.getText();
		String namestaff = cb_nameStaff.getSelectedItem().toString();
		String nameroom = cb_nameRoom.getSelectedItem().toString();

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String date = formatter.format(dateChooser.getDate()).toString();
		
		String idroom  = cb_idRoom.getSelectedItem().toString();
		
		double total = 0;
		Vector<Object> t = pb.totalMoney(idroom);
		//if(!(t.get(0)+"").equals("")) {
			total = Double.parseDouble(t.get(0)+"")*Double.parseDouble(t.get(2)+"")+Double.parseDouble(t.get(1)+""); 
			
			if(jOP_Check.showConfirmDialog(null, "Bạn có muốn thêm hóa đơn này?", "Thêm hóa đơn", jOP_Check.YES_NO_CANCEL_OPTION) == 0){
				if(pb.insertBill(idbill, namestaff, nameroom, date, total) && pb.changeStateRoomA(idroom)) {
					getAllBill();
					display_nameRoom(cb_idStaff.getSelectedItem().toString());
					jOP_Message.showMessageDialog(null, "Thêm mới hóa đơn thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
					clear();
				}
				else 
					jOP_Message.showMessageDialog(null, "Thêm mới hóa đơn không thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
			}
			
		//}
		
	}
	
	private void updateBill() {
		String idbill = tf_Bill.getText();
		String idstaff = cb_idStaff.getSelectedItem().toString();
		String namestaff = cb_nameStaff.getSelectedItem().toString();
		String nameroom = cb_nameRoom.getSelectedItem().toString();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String date = formatter.format(dateChooser.getDate()).toString();
		String idroom  = cb_idRoom.getSelectedItem().toString();
		double total = 0;
		Vector<Object> t = pb.totalMoney(idroom);
		total = Double.parseDouble(t.get(0)+"")*Double.parseDouble(t.get(2)+"")+Double.parseDouble(t.get(1)+""); 
		if(jOP_Check.showConfirmDialog(null, "Bạn có muốn cập nhật thông tin hóa đơn này?", "Cập nhật hóa đơn", jOP_Check.YES_NO_CANCEL_OPTION) == 0) {
			int selectedRow = tb_Bill.getSelectedRow();
			Vector<Object> row = rows.get(selectedRow);
			if(pb.updateBill(idbill, namestaff, nameroom, date, total) && pb.changeStateRoomU(row.get(2).toString()) && pb.changeStateRoomA(idroom)) {
				getAllBill();
				clear();
				cb_nameRoom.removeItem(nameroom);
				//tf_Total.setText("");
				jOP_Message.showMessageDialog(null, "Cập nhật thông tin hóa đơn thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
			}
			else {
				jOP_Message.showMessageDialog(null, "Cập nhật thông tin hóa đơn không thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
	
	public void deleteBill() {
		String idbill = tf_Bill.getText();
		String namestaff = cb_nameStaff.getSelectedItem()+"";
		String nameroom = cb_nameRoom.getSelectedItem()+"";
		
		if(jOP_Check.showConfirmDialog(null, "Bạn có muốn xóa thông tin hóa đơn này?", "Xóa hóa đơn", jOP_Check.YES_NO_CANCEL_OPTION) == 0) {
			if(pb.delBill(idbill, namestaff, nameroom) == true) {
				getAllBill();
				tf_Bill.setText("");
				tf_Bill.enable(true);
				cb_nameStaff.setSelectedIndex(0);
				cb_nameRoom.setSelectedIndex(0);
				cb_idRoom.setSelectedIndex(0);
				cb_idStaff.setSelectedIndex(0);
				dateChooser.setDate(null);
				//tf_Total.setText("");
				jOP_Message.showMessageDialog(null, "Xóa hóa đơn thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
			}
			else {
				jOP_Message.showMessageDialog(null, "Xóa hóa đơn không thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
	
	public void findBill() {
		String idBill = tf_Bill.getText();
		
		Vector<Object> a = new Vector<>();
		Vector<Object> tbrow = new Vector<>();
		a = pb.findBill(idBill);
		if(a.size()>0) {
			tbrow.add(a.get(0));
			tbrow.add(a.get(1));
			tbrow.add(a.get(2));
			tbrow.add(a.get(3));
			tbrow.add(a.get(4));
			dtm.setNumRows(0);
			dtm.insertRow(0, columns);
			
			jOP_Message.showMessageDialog(null, "Tìm kiếm thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
		}else {
			jOP_Message.showMessageDialog(null, "Không tìm thấy hóa đơn!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
			getAllBill();
		}
		rows.add(tbrow);	
		dtm.setDataVector(rows, columns);
		
		tb_Bill.setModel(dtm);	
	}
	
	private void clear() {
		tf_Bill.setText("");
		tf_Bill.enable(true);
		if(cb_nameRoom.getItemCount() > 0)
			cb_nameRoom.setSelectedIndex(0);
		if(cb_nameStaff.getItemCount() > 0)
			cb_nameStaff.setSelectedIndex(0);
		if(cb_idRoom.getItemCount() > 0)
			cb_idRoom.setSelectedIndex(0);
		if(cb_idStaff.getItemCount() > 0)
			cb_idStaff.setSelectedIndex(0);
		//tf_Total.setText("");
//		formatter.format(dateChooser.getDate()).toString();
	}
	
	public void display_idStaff(String nameStaff) {
		lsids = pb.finding_idStaff(nameStaff);
		cb_idStaff.removeAllItems();
		for(int i=0; i<lsids.size(); i++) 
			cb_idStaff.addItem(lsids.get(i));
	}
	
	public void display_nameRoom(String idStaff) {
		lsnr = pb.finding_nameRoom(idStaff);
		cb_nameRoom.removeAllItems();
		for(int i=0; i<lsnr.size(); i++) {
			int count = 0;
			for(int j=i+1; j<lsnr.size (); j++) {
				if(lsnr.get(i).equals(lsnr.get(j)))
					count++;
			}
			if(count == 0){
				cb_nameRoom.addItem(lsnr.get(i));
			}
		}
	}	
	
	public void display_idRoom(String nameRoom) {
		lsidr = pb.finding_idRoom(nameRoom);
		cb_idRoom.removeAllItems();
		for(int i=0; i<lsidr.size(); i++) {
			cb_idRoom.addItem(lsidr.get(i));
		}
	}
}

