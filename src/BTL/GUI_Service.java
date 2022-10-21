package BTL;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.EtchedBorder;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GUI_Service extends JFrame {

	private JPanel contentPane;
	private JTextField tf_idService;
	private JTextField tf_nameService;
	private JTextField tf_priceService;
	private JTable tb_Service;
	private DefaultTableModel dtm = new DefaultTableModel();
	private Vector<String> columns = new Vector<>();
	private Vector<Vector<Object>> rows = new Vector<>();
	private Process_Service ps = new Process_Service();
	private ArrayList<Service> lss;
	private JOptionPane jOP_Check = new javax.swing.JOptionPane();
	private JOptionPane jOP_Message = new JOptionPane();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_Service frame = new GUI_Service();
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
	public GUI_Service() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 942, 418);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Th\u00F4ng tin d\u1ECBch v\u1EE5", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(22, 31, 361, 318);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lb_idService = new JLabel("Mã dịch vụ");
		lb_idService.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lb_idService.setBounds(32, 60, 85, 21);
		panel_1.add(lb_idService);
		
		tf_idService = new JTextField();
		tf_idService.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tf_idService.setColumns(10);
		tf_idService.setBounds(146, 61, 154, 19);
		panel_1.add(tf_idService);
		
		JLabel lb_nameService = new JLabel("Tên dịch vụ");
		lb_nameService.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lb_nameService.setBounds(32, 109, 85, 21);
		panel_1.add(lb_nameService);
		
		tf_nameService = new JTextField();
		tf_nameService.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tf_nameService.setColumns(10);
		tf_nameService.setBounds(146, 110, 154, 19);
		panel_1.add(tf_nameService);
		
		JLabel lb_priceService = new JLabel("Giá dịch vụ");
		lb_priceService.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lb_priceService.setBounds(32, 157, 85, 21);
		panel_1.add(lb_priceService);
		
		tf_priceService = new JTextField();
		tf_priceService.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tf_priceService.setColumns(10);
		tf_priceService.setBounds(146, 158, 154, 19);
		panel_1.add(tf_priceService);
		
		JButton btn_Insert = new JButton("Thêm");
		btn_Insert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertService();
			}
		});
		btn_Insert.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btn_Insert.setBounds(127, 217, 109, 21);
		panel_1.add(btn_Insert);
		
		JButton btn_Update = new JButton("Sửa");
		btn_Update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateService();
			}
		});
		btn_Update.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btn_Update.setBounds(246, 217, 103, 21);
		panel_1.add(btn_Update);
		
		JButton btn_Exit = new JButton("Thoát");
		btn_Exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exitForm();
			}
		});
		btn_Exit.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btn_Exit.setBounds(246, 248, 103, 21);
		panel_1.add(btn_Exit);
		
		JButton btn_Clear = new JButton("Clear");
		btn_Clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearInput();
			}
		});
		btn_Clear.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btn_Clear.setBounds(127, 248, 109, 21);
		panel_1.add(btn_Clear);
		
		JButton btn_Delete = new JButton("Xóa");
		btn_Delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteService();
			}
		});
		btn_Delete.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btn_Delete.setBounds(10, 248, 103, 21);
		panel_1.add(btn_Delete);
		
		JButton btn_Find = new JButton("Tìm kiếm");
		btn_Find.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				findService_byID(tf_idService.getText());
			}
		});
		btn_Find.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btn_Find.setBounds(10, 218, 103, 21);
		panel_1.add(btn_Find);
		
		tb_Service = new JTable();
		tb_Service.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int selectedRow = tb_Service.getSelectedRow();
				
				if(selectedRow != -1) {
					Vector<Object> row = rows.get(selectedRow);
					tf_idService.setText(row.get(0).toString());
					tf_idService.enable(false);
					tf_nameService.setText(row.get(1).toString());
					tf_priceService.setText(row.get(2).toString());
				}
				if(selectedRow == 0) {
					getListService();
					tf_idService.setText("");
					tf_idService.enable(true);
					tf_nameService.setText("");
					tf_priceService.setText("");
				}
			}
		});
		tb_Service.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tb_Service.setBounds(403, 31, 500, 316);
		contentPane.add(tb_Service);
		
		columns.add("Mã dịch vụ");
		columns.add("Tên dịch vụ");
		columns.add("Giá dịch vụ");
		
		getListService();
	}

	private void getListService() {
		dtm.setNumRows(0);
		lss = ps.getListService();
		for(int i = 0; i < lss.size(); i++) {
			Service s = (Service)lss.get(i);
			Vector<Object> tbRow = new Vector<>();
			tbRow.add(s.getIdService());
			tbRow.add(s.getNameService());
			tbRow.add(s.getPriceService());
			rows.add(tbRow);
		}
		dtm.setDataVector(rows, columns);
		dtm.insertRow(0, columns);
		tb_Service.setModel(dtm);
	}
	
	public void findService_byID(String idService) {
		if(tf_idService.getText().equals("")) {
			JOptionPane.showConfirmDialog(null, "Vui lòng nhập ID khách hàng cần tìm!", "Thông báo", JOptionPane.CLOSED_OPTION);
		}
		else if(ps.findService_byID(idService) == null) {
			jOP_Message.showConfirmDialog(null, "Không có dịch vụ cần tìm!", "Thông báo", JOptionPane.CLOSED_OPTION);
			}
			else {
				if(jOP_Check.showConfirmDialog(null, "Bạn có tìm kiếm dịch vụ theo mã này?", "Tìm kiếm khách hàng", jOP_Check.YES_NO_CANCEL_OPTION) == 0) {
					dtm.setNumRows(0);
					Service s = ps.findService_byID(idService);
					Vector<Object> tbRow = new Vector<>();
					tbRow.add(s.getIdService());
					tbRow.add(s.getNameService());
					tf_nameService.setText(s.getNameService());
					tbRow.add(s.getPriceService());
					tf_priceService.setText(s.getPriceService()+"");
					rows.add(tbRow);
					dtm.setDataVector(rows, columns);
					dtm.insertRow(0, columns);
					tb_Service.setModel(dtm);
				}
			}
	}
	
	public void insertService() {
		if(tf_idService.getText().equals("") || tf_nameService.getText().equals("") || tf_priceService.getText().equals(""))
			JOptionPane.showConfirmDialog(null, "Vui lòng nhập đủ thông tin dịch vụ!", "Thông báo", JOptionPane.CLOSED_OPTION);
		else {
			String idService = tf_idService.getText();
			String nameService = tf_nameService.getText();
			int priceService = Integer.parseInt(tf_priceService.getText());
			if(jOP_Check.showConfirmDialog(null, "Bạn có muốn thêm dịch vụ này?", "Thêm dịch vụ", jOP_Check.YES_NO_CANCEL_OPTION) == 0){
				if(ps.insertService(idService, nameService, priceService)) {
					getListService();
					tf_idService.setText("");
					tf_nameService.setText("");
					tf_priceService.setText("");
					jOP_Message.showMessageDialog(null, "Thêm dịch vụ thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
				}
				else
					jOP_Message.showMessageDialog(null, "Mã dịch vụ bị trùng!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
	
	public void updateService() {
		if(tf_idService.getText().equals("") || tf_nameService.getText().equals("") || tf_priceService.getText().equals(""))
			JOptionPane.showConfirmDialog(null, "Vui lòng nhập đủ thông tin dịch vụ!", "Thông báo", JOptionPane.CLOSED_OPTION);
		else {
			String idService = tf_idService.getText();
			String nameService = tf_nameService.getText();
			int priceService = Integer.parseInt(tf_priceService.getText());
			if(jOP_Check.showConfirmDialog(null, "Bạn có muốn cập nhật thông tin dịch vụ này?", "Thêm dịch vụ", jOP_Check.YES_NO_CANCEL_OPTION) == 0){
				if(ps.updateService(idService, nameService, priceService)) {
					getListService();
					tf_idService.setText("");
					tf_idService.enable(true);
					tf_nameService.setText("");
					tf_priceService.setText("");
					jOP_Message.showMessageDialog(null, "Cập nhật thông tin dịch vụ thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
				}
				else
					jOP_Message.showMessageDialog(null, "Cập nhật thông tin dịch vụ không thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
	
	public void deleteService() {

		jOP_Message.showMessageDialog(null, "Không khả dụng! Xóa dịch vụ sẽ làm ảnh hưởng rất nhiều tới dữ liệu của phần mềm. Chọn thêm hoặc sửa để sử dụng!!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void clearInput() {
		if(jOP_Check.showConfirmDialog(null, "Bạn có muốn xóa tất cả ô nhập dữ liệu không?", "Xóa ô nhập", jOP_Check.YES_NO_CANCEL_OPTION) == 0){
			getListService();
			tf_idService.setText("");
			tf_idService.enable(true);
			tf_nameService.setText("");
			tf_priceService.setText("");
			jOP_Message.showMessageDialog(null, "Xóa ô nhập dữ liệu thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	public void exitForm() {
		if(jOP_Check.showConfirmDialog(null, "Bạn có muốn thoát chương trình quản lý dịch vụ không?","Thoát", jOP_Check.YES_NO_CANCEL_OPTION) == 0)
			System.exit(0);
	}
}
