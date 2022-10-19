package BTL;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.HierarchyListener;
import java.awt.event.HierarchyEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;

public class GUI_Room extends JFrame {

	private JPanel contentPane;
	private JTextField tf_idRoom;
	private JTextField tf_nameRoom;
	private JTextField tf_typeRoom;
	private JTextField tf_priceRoom;
	private JTextField tf_noteRoom;
	private JTextField tf_stateRoom;

	DefaultTableModel dtm = new DefaultTableModel();
	Vector<String> columns = new Vector<>();
	Vector<Vector<Object>> rows = new Vector<>();
	Process_Room pr = new Process_Room();
	ArrayList<Vector<Object>> ls_room = new ArrayList<>();
	ArrayList<Vector<Object>> ls_idRoom = new ArrayList<>();
	// JLabel lbkq = new JLabel();
	JOptionPane jOP_Check = new javax.swing.JOptionPane();
	JOptionPane jOP_Message = new JOptionPane();

	JComboBox cb_nameStaff;
	JComboBox cb_nameService;
	JComboBox cb_idstaff;
	JComboBox cb_idService ;
	String idRoom;
	String nameRoom;
	String typeRoom;
	int priceRoom;
	String stateRoom;
	String noteRoom;
	String idStaff;
	String idService;
	private JTable tb_room;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_Room frame = new GUI_Room();
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
	public GUI_Room() {
		setTitle("Quản Lý Phòng");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1340, 757);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 255, 255));
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), " ",
				TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		panel_2.setBounds(571, 70, 718, 557);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		tb_room = new JTable();
		tb_room.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int selectedRow = tb_room.getSelectedRow();
				if (selectedRow != -1) {
					tf_idRoom.setEditable(false);
					Vector<Object> row = rows.get(selectedRow);
					tf_idRoom.setText(row.get(0).toString());
					tf_nameRoom.setText(row.get(1).toString());
					tf_typeRoom.setText(row.get(2).toString());
					tf_priceRoom.setText(row.get(3).toString());
					tf_stateRoom.setText(row.get(4).toString());
					tf_noteRoom.setText(row.get(5).toString());
					cb_nameStaff.setSelectedItem(row.get(6).toString());
					cb_nameStaff.setSelectedItem(row.get(7).toString());
				}
				if (selectedRow == 0) {
					tf_idRoom.setEditable(true);
					tf_idRoom.setText("");
					tf_nameRoom.setText("");
					tf_typeRoom.setText("");
					tf_priceRoom.setText("");
					tf_stateRoom.setText("");
					tf_noteRoom.setText("");
					cb_nameStaff.setSelectedItem("NV01");
					cb_nameStaff.setSelectedItem("DV01");
				}
			}
		});
		tb_room.setBounds(10, 23, 698, 524);
		panel_2.add(tb_room);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Th\u00F4ng tin ph\u00F2ng", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		panel_3.setBounds(41, 10, 478, 649);
		contentPane.add(panel_3);
		panel_3.setLayout(null);

		JLabel lblNewLabel = new JLabel("Mã phòng");
		lblNewLabel.setBounds(40, 80, 66, 13);
		panel_3.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Tên phòng");
		lblNewLabel_1.setBounds(40, 119, 66, 13);
		panel_3.add(lblNewLabel_1);

		tf_idRoom = new JTextField();
		tf_idRoom.setBounds(180, 74, 147, 19);
		panel_3.add(tf_idRoom);
		tf_idRoom.setColumns(10);

		tf_nameRoom = new JTextField();
		tf_nameRoom.setBounds(180, 113, 147, 19);
		panel_3.add(tf_nameRoom);
		tf_nameRoom.setColumns(10);

		tf_typeRoom = new JTextField();
		tf_typeRoom.setBounds(180, 149, 147, 19);
		panel_3.add(tf_typeRoom);
		tf_typeRoom.setColumns(10);

		tf_priceRoom = new JTextField();
		tf_priceRoom.setBounds(180, 191, 147, 19);
		panel_3.add(tf_priceRoom);
		tf_priceRoom.setColumns(10);

		tf_noteRoom = new JTextField();
		tf_noteRoom.setBounds(180, 230, 147, 19);
		panel_3.add(tf_noteRoom);
		tf_noteRoom.setColumns(10);

		tf_stateRoom = new JTextField();
		tf_stateRoom.setBounds(180, 271, 147, 19);
		panel_3.add(tf_stateRoom);
		tf_stateRoom.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Loại phòng");
		lblNewLabel_2.setBounds(40, 155, 66, 13);
		panel_3.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Giá phòng");
		lblNewLabel_3.setBounds(40, 194, 66, 13);
		panel_3.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Chú thích");
		lblNewLabel_4.setBounds(40, 233, 66, 13);
		panel_3.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Tình trạng");
		lblNewLabel_5.setBounds(40, 274, 66, 13);
		panel_3.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("Tên nhân viên");
		lblNewLabel_6.setBounds(40, 311, 66, 13);
		panel_3.add(lblNewLabel_6);

		cb_nameStaff = new JComboBox();
		cb_nameStaff.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				String nameStaff = cb_nameStaff.getSelectedItem().toString();
				displayIDStaff(nameStaff);
			}
		});
		
		
		cb_nameStaff.setBounds(180, 307, 147, 21);
		panel_3.add(cb_nameStaff);

		cb_nameService = new JComboBox();
		cb_nameService.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				String nameService = cb_nameService.getSelectedItem().toString();
				displayIDService(nameService);
			}
		});
		cb_nameService.setBounds(180, 399, 147, 21);
		panel_3.add(cb_nameService);

		JLabel lblNewLabel_7 = new JLabel("Tên dịch vụ");
		lblNewLabel_7.setBounds(40, 403, 66, 13);
		panel_3.add(lblNewLabel_7);

		JButton btn_addRoom = new JButton("Thêm");
		btn_addRoom.setBounds(99, 511, 85, 21);
		panel_3.add(btn_addRoom);
		btn_addRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(null, "Do you insert this ?", "Question",
						JOptionPane.YES_NO_CANCEL_OPTION) == 0) {
					if (insert_Room()) {
						JOptionPane.showMessageDialog(null, "Successfully Inserted", "Message",
								JOptionPane.INFORMATION_MESSAGE);

					} else {
						JOptionPane.showMessageDialog(null, "Insert Failed ! idRoom is duplicated", "Message",
								JOptionPane.INFORMATION_MESSAGE);
					}
					clear();
					getAllRoom();
				}
			}
		});
		btn_addRoom.setIcon(
				new ImageIcon("C:\\Users\\Admin\\Downloads\\307250204_598143505384664_999337979866899336_n.png"));

		JButton btn_updateRoom = new JButton("Sửa");
		btn_updateRoom.setBounds(206, 511, 85, 21);
		panel_3.add(btn_updateRoom);
		btn_updateRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(null, "Do you update this ?", "Question",
						JOptionPane.YES_NO_CANCEL_OPTION) == 0) {
					if (update_Room()) {
						JOptionPane.showMessageDialog(null, "Successfully Updated", "Message",
								JOptionPane.INFORMATION_MESSAGE);

					} else {
						JOptionPane.showMessageDialog(null, "Update Failed", "Message",
								JOptionPane.INFORMATION_MESSAGE);
					}
					clear();
					getAllRoom();
				}
			}
		});
		btn_updateRoom.setIcon(
				new ImageIcon("C:\\Users\\Admin\\Downloads\\282209823_542515240754482_7892659068093757463_n.png"));

		JButton btn_clearRoom = new JButton("Clear");
		btn_clearRoom.setBounds(319, 511, 85, 21);
		panel_3.add(btn_clearRoom);
		btn_clearRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
			}
		});
		btn_clearRoom.setIcon(
				new ImageIcon("C:\\Users\\Admin\\Downloads\\308510366_1141191576788713_363128577687983386_n.png"));

		JButton btn_exitRoom = new JButton("Thoát");
		btn_exitRoom.setBounds(206, 557, 85, 21);
		panel_3.add(btn_exitRoom);
		btn_exitRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (JOptionPane.showConfirmDialog(null, "Do you exit ?", "Question",
						JOptionPane.YES_NO_CANCEL_OPTION) == 0) {
					if (JOptionPane.YES_NO_OPTION == JOptionPane.YES_OPTION) {
						// jOP_Message.showMessageDialog(null, "Successfully Deleted", "Message",
						// JOptionPane.INFORMATION_MESSAGE);

					} else {
						// jOP_Message.showMessageDialog(null, "Deleted Failed", "Message",
						// JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
		});
		btn_exitRoom.setIcon(
				new ImageIcon("C:\\Users\\Admin\\Downloads\\282624916_782808416462689_6956084271301932296_n.png"));

		JButton btn_deleteRoom = new JButton("Xóa");
		btn_deleteRoom.setBounds(99, 557, 85, 21);
		panel_3.add(btn_deleteRoom);
		btn_deleteRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				delete_Room();
			}
		});
		btn_deleteRoom.setIcon(
				new ImageIcon("C:\\Users\\Admin\\Downloads\\307204971_639879121091814_8463331429285439472_n.png"));

		JLabel lblNewLabel_8 = new JLabel("Mã nhân viên");
		lblNewLabel_8.setBounds(40, 351, 66, 13);
		panel_3.add(lblNewLabel_8);

		JLabel lblNewLabel_9 = new JLabel("Mã dịch vụ");
		lblNewLabel_9.setBounds(40, 445, 66, 13);
		panel_3.add(lblNewLabel_9);
		
		cb_idstaff = new JComboBox();
		cb_idstaff.setBounds(180, 352, 147, 21);
		panel_3.add(cb_idstaff);
		
		cb_idService = new JComboBox();
		cb_idService.setBounds(180, 441, 147, 21);
		panel_3.add(cb_idService);
		
		JButton btn_searchR = new JButton("Search");
		btn_searchR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				findRoomById();
			}
		});
		btn_searchR.setBounds(360, 76, 85, 21);
		panel_3.add(btn_searchR);

		columns.add("Mã Phòng");
		columns.add("Tên Phòng");
		columns.add("Loại Phòng");
		columns.add("Giá Phòng");
		columns.add("Chú thích");
		columns.add("Tình Trạng");
		columns.add("Tên Nhân Viên");
		columns.add("Tên Dịch Vụ");
		getAllRoom();

	}

	private void getAllRoom() {
		dtm.setNumRows(0);
		for (int i = 0; i < pr.getListRoom().size(); i++) {
			Vector<Object> r = (Vector<Object>) pr.getListRoom().get(i);
			Vector<Object> tbRow = new Vector<>();
			tbRow.add(r.get(0));
			tbRow.add(r.get(1));
			tbRow.add(r.get(2));
			tbRow.add(r.get(3));
			tbRow.add(r.get(4));
			tbRow.add(r.get(5));
			tbRow.add(r.get(6));
			tbRow.add(r.get(7));
			rows.add(tbRow);
		}
		ls_room = (ArrayList<Vector<Object>>) pr.getListIdNameStaff();
		ArrayList<Vector<Object>> ls_service = (ArrayList<Vector<Object>>) pr.getListIdNameService();
		for (int i = 0; i < ls_room.size(); i++) {
			{
				int count = 0;
				for (int j = i + 1; j < ls_room.size(); j++) {
					if (ls_room.get(i).get(1).equals(ls_room.get(j).get(1))) {
						count++;
					}

				}
				if (count == 0) {
					cb_nameStaff.addItem(ls_room.get(i).get(0));
				}
			}
		}
		for (int i = 0; i < ls_service.size(); i++) {
			{
				int count = 0;
				for (int j = i + 1; j < ls_service.size(); j++) {
					if (ls_service.get(i).get(1).equals(ls_service.get(j).get(1))) {
						count++;
					}
				}
				if (count == 0) {
					cb_nameService.addItem(ls_service.get(i).get(0));
				}
			}
		}

		dtm.setDataVector(rows, columns);
		dtm.insertRow(0, columns);
		tb_room.setModel(dtm);
	}
	public void displayIDStaff(String nameStaff) {
		ArrayList<Object> ls_idStaff = pr.getListIdStaff(nameStaff);
		cb_idstaff.removeAllItems();
		for(int i=0;i<ls_idStaff.size();i++) {
			cb_idstaff.addItem(ls_idStaff.get(i));
		}
	}
	public void displayIDService(String nameService) {
		ArrayList<Object> ls_idService = pr.getListIdService(nameService);
		cb_idService.removeAllItems();
		for(int i=0;i<ls_idService.size();i++) {
			cb_idService.addItem(ls_idService.get(i));
		}
	}
	private boolean insert_Room() {
		idRoom = tf_idRoom.getText();
		nameRoom = tf_nameRoom.getText();
		typeRoom = tf_typeRoom.getText();
		priceRoom = Integer.parseInt(tf_priceRoom.getText());
		stateRoom = tf_stateRoom.getText();
		noteRoom = tf_noteRoom.getText();
		idStaff = cb_idstaff.getSelectedItem().toString();
		idService = cb_idService.getSelectedItem().toString();
		boolean insert = pr.insertRoom(idRoom, nameRoom, typeRoom, priceRoom, stateRoom, noteRoom, idStaff, idService);
		return insert;
	}

	private boolean update_Room() {
		idRoom = tf_idRoom.getText();
		nameRoom = tf_nameRoom.getText();
		typeRoom = tf_typeRoom.getText();
		priceRoom = Integer.parseInt(tf_priceRoom.getText());
		stateRoom = tf_stateRoom.getText();
		noteRoom = tf_noteRoom.getText();
		idStaff = cb_idstaff.getSelectedItem().toString();
		idService = cb_idService.getSelectedItem().toString();
		boolean update = pr.updateRoom(idRoom, nameRoom, typeRoom, priceRoom, stateRoom, noteRoom, idStaff, idService);
		return update;
	}

	private void delete_Room() {
		int[] selectedRow = tb_room.getSelectedRows();
		if(selectedRow.length == 1) {
			idRoom = tf_idRoom.getText();
			if (JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa phòng này không?", "Xóa phòng",
					JOptionPane.YES_NO_CANCEL_OPTION) == 0) {
				if (pr.deleteRoom(idRoom)) {
					JOptionPane.showMessageDialog(null, "Xóa phòng thành công", "Thông báo",
							JOptionPane.INFORMATION_MESSAGE);

				} else {
					JOptionPane.showMessageDialog(null, "Xóa phòng thất bại", "Thông báo",
							JOptionPane.INFORMATION_MESSAGE);
				}
				clear();
				getAllRoom();
			}
			
		}
		else {
			if (JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa những phòng này không?", "Xóa nhiều phòng",
					JOptionPane.YES_NO_CANCEL_OPTION) == 0) {
				int check = 0;
				for(int i : selectedRow) {
					idRoom = rows.get(i-check).get(0).toString();
					if (pr.deleteRoom(idRoom)) {
						getAllRoom();
						check++;
					}
				}
				if(check > 0) {
					JOptionPane.showMessageDialog(null, "Xóa phòng thành công", "Thông báo",
							JOptionPane.INFORMATION_MESSAGE);
					
						getAllRoom();
						
				}
				else {
					JOptionPane.showMessageDialog(null, "Xóa phòng thất bại", "Thông báo",
							JOptionPane.INFORMATION_MESSAGE);
				clear();
				getAllRoom();
				}
			}
					
		}
	}
	private void findRoomById() {
		dtm.setNumRows(0);
		String idRoom = tf_idRoom.getText();
			Room r = (Room) pr.getRoomById(idRoom);
			Vector<Object> tbRow = new Vector<>();
			tbRow.add(r.getIdRoom());
			tbRow.add(r.getNameRoom());
			tbRow.add(r.getTypeRoom());
			tbRow.add(r.getPriceRoom());
			tbRow.add(r.getNoteRoom());
			tbRow.add(r.getStateRoom());
			tbRow.add(r.getIdStaff());
			tbRow.add(r.getIdService());
			rows.add(tbRow);
		dtm.setDataVector(rows, columns);
		dtm.insertRow(0, columns);
		tb_room.setModel(dtm);
	}
	private void clear() {
		tf_idRoom.setText("");
		tf_nameRoom.setText("");
		tf_typeRoom.setText("");
		tf_priceRoom.setText("");
		tf_stateRoom.setText("");
		tf_noteRoom.setText("");
		cb_nameStaff.setSelectedItem("NV01");
		cb_nameStaff.setSelectedItem("DV01");
	}
}
