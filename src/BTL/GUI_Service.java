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
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class GUI_Service extends JFrame {

	private JPanel contentPane;
	private JTextField tf_idService;
	private JTextField tf_nameService;
	private JTextField tf_priceService;
	private JTable tb_Service;
	private DefaultTableModel dtm = new DefaultTableModel();
	private Vector<String> columns = new Vector<>();
	private Vector<Vector<Object>> rows = new Vector<>();
	private Process_Project pp = new Process_Project();
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
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage("C:\\Users\\Admin\\Documents\\jav2\\BTL_10\\BTL-JAVA10\\src\\images\\service.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 942, 418);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Th\u00F4ng tin d\u1ECBch v\u1EE5", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null,
				new Color(0, 0, 0)));
		panel_1.setBounds(22, 31, 361, 318);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lb_idService = new JLabel("M?? d???ch v???");
		lb_idService.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lb_idService.setBounds(32, 60, 85, 21);
		panel_1.add(lb_idService);

		tf_idService = new JTextField();
		tf_idService.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tf_idService.setColumns(10);
		tf_idService.setBounds(146, 61, 154, 19);
		panel_1.add(tf_idService);

		JLabel lb_nameService = new JLabel("T??n d???ch v???");
		lb_nameService.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lb_nameService.setBounds(32, 109, 85, 21);
		panel_1.add(lb_nameService);

		tf_nameService = new JTextField();
		tf_nameService.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tf_nameService.setColumns(10);
		tf_nameService.setBounds(146, 110, 154, 19);
		panel_1.add(tf_nameService);

		JLabel lb_priceService = new JLabel("Gi?? d???ch v???");
		lb_priceService.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lb_priceService.setBounds(32, 157, 85, 21);
		panel_1.add(lb_priceService);

		tf_priceService = new JTextField();
		tf_priceService.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tf_priceService.setColumns(10);
		tf_priceService.setBounds(146, 158, 154, 19);
		panel_1.add(tf_priceService);

		JButton btn_Insert = new JButton("Th??m");
		btn_Insert
				.setIcon(new ImageIcon("C:\\Users\\Admin\\Documents\\jav2\\BTL_10\\BTL-JAVA10\\src\\images\\add.png"));
		btn_Insert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertService();
			}
		});
		btn_Insert.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btn_Insert.setBounds(127, 217, 109, 21);
		panel_1.add(btn_Insert);

		JButton btn_Update = new JButton("S???a");
		btn_Update.setIcon(
				new ImageIcon("C:\\Users\\Admin\\Documents\\jav2\\BTL_10\\BTL-JAVA10\\src\\images\\update.png"));
		btn_Update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateService();
			}
		});
		btn_Update.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btn_Update.setBounds(246, 217, 103, 21);
		panel_1.add(btn_Update);

		JButton btn_Exit = new JButton("Tho??t");
		btn_Exit.setIcon(new ImageIcon("C:\\Users\\Admin\\Documents\\jav2\\BTL_10\\BTL-JAVA10\\src\\images\\exit.png"));
		btn_Exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exitForm();
			}
		});
		btn_Exit.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btn_Exit.setBounds(246, 248, 103, 21);
		panel_1.add(btn_Exit);

		JButton btn_Clear = new JButton("Clear");
		btn_Clear.setIcon(
				new ImageIcon("C:\\Users\\Admin\\Documents\\jav2\\BTL_10\\BTL-JAVA10\\src\\images\\clear.png"));
		btn_Clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearInput();
			}
		});
		btn_Clear.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btn_Clear.setBounds(127, 248, 109, 21);
		panel_1.add(btn_Clear);

		JButton btn_Delete = new JButton("X??a");
		btn_Delete.setIcon(
				new ImageIcon("C:\\Users\\Admin\\Documents\\jav2\\BTL_10\\BTL-JAVA10\\src\\images\\delete.png"));
		btn_Delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteService();
			}
		});
		btn_Delete.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btn_Delete.setBounds(10, 248, 103, 21);
		panel_1.add(btn_Delete);

		JButton btn_Find = new JButton("T??m ki???m");
		btn_Find.setIcon(new ImageIcon("C:\\Users\\Admin\\Documents\\jav2\\BTL_10\\BTL-JAVA10\\src\\images\\search.png"));
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

				if (selectedRow != -1) {
					Vector<Object> row = rows.get(selectedRow);
					tf_idService.setText(row.get(0).toString());
					tf_idService.enable(false);
					tf_nameService.setText(row.get(1).toString());
					tf_priceService.setText(row.get(2).toString());
				}
				if (selectedRow == 0) {
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

		columns.add("M?? d???ch v???");
		columns.add("T??n d???ch v???");
		columns.add("Gi?? d???ch v???");

		getListService();
	}

	private void getListService() {
		dtm.setNumRows(0);
		lss = pp.getListService();
		for (int i = 0; i < lss.size(); i++) {
			Service s = (Service) lss.get(i);
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
		if (tf_idService.getText().equals("")) {
			JOptionPane.showConfirmDialog(null, "Vui l??ng nh???p ID kh??ch h??ng c???n t??m!", "Th??ng b??o",
					JOptionPane.CLOSED_OPTION);
		} else if (pp.findService_byID(idService) == null) {
			jOP_Message.showConfirmDialog(null, "Kh??ng c?? d???ch v??? c???n t??m!", "Th??ng b??o", JOptionPane.CLOSED_OPTION);
		} else {
			if (jOP_Check.showConfirmDialog(null, "B???n c?? t??m ki???m d???ch v??? theo m?? n??y?", "T??m ki???m kh??ch h??ng",
					jOP_Check.YES_NO_CANCEL_OPTION) == 0) {
				dtm.setNumRows(0);
				Service s = pp.findService_byID(idService);
				Vector<Object> tbRow = new Vector<>();
				tbRow.add(s.getIdService());
				tbRow.add(s.getNameService());
				tf_nameService.setText(s.getNameService());
				tbRow.add(s.getPriceService());
				tf_priceService.setText(s.getPriceService() + "");
				rows.add(tbRow);
				dtm.setDataVector(rows, columns);
				dtm.insertRow(0, columns);
				tb_Service.setModel(dtm);
			}
		}
	}

	public void insertService() {
		if (tf_idService.getText().equals("") || tf_nameService.getText().equals("")
				|| tf_priceService.getText().equals(""))
			JOptionPane.showConfirmDialog(null, "Vui l??ng nh???p ????? th??ng tin d???ch v???!", "Th??ng b??o",
					JOptionPane.CLOSED_OPTION);
		else {
			String idService = tf_idService.getText();
			String nameService = tf_nameService.getText();
			int priceService = Integer.parseInt(tf_priceService.getText());
			if (jOP_Check.showConfirmDialog(null, "B???n c?? mu???n th??m d???ch v??? n??y?", "Th??m d???ch v???",
					jOP_Check.YES_NO_CANCEL_OPTION) == 0) {
				if (pp.insertService(idService, nameService, priceService)) {
					getListService();
					tf_idService.setText("");
					tf_nameService.setText("");
					tf_priceService.setText("");
					jOP_Message.showMessageDialog(null, "Th??m d???ch v??? th??nh c??ng!", "Th??ng b??o",
							JOptionPane.INFORMATION_MESSAGE);
				} else
					jOP_Message.showMessageDialog(null, "M?? d???ch v??? b??? tr??ng!", "Th??ng b??o",
							JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}

	public void updateService() {
		if (tf_idService.getText().equals("") || tf_nameService.getText().equals("")
				|| tf_priceService.getText().equals(""))
			JOptionPane.showConfirmDialog(null, "Vui l??ng nh???p ????? th??ng tin d???ch v???!", "Th??ng b??o",
					JOptionPane.CLOSED_OPTION);
		else {
			String idService = tf_idService.getText();
			String nameService = tf_nameService.getText();
			int priceService = Integer.parseInt(tf_priceService.getText());
			if (jOP_Check.showConfirmDialog(null, "B???n c?? mu???n c???p nh???t th??ng tin d???ch v??? n??y?", "Th??m d???ch v???",
					jOP_Check.YES_NO_CANCEL_OPTION) == 0) {
				if (pp.updateService(idService, nameService, priceService)) {
					getListService();
					tf_idService.setText("");
					tf_idService.enable(true);
					tf_nameService.setText("");
					tf_priceService.setText("");
					jOP_Message.showMessageDialog(null, "C???p nh???t th??ng tin d???ch v??? th??nh c??ng!", "Th??ng b??o",
							JOptionPane.INFORMATION_MESSAGE);
				} else
					jOP_Message.showMessageDialog(null, "C???p nh???t th??ng tin d???ch v??? kh??ng th??nh c??ng!", "Th??ng b??o",
							JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}

	public void deleteService() {

		jOP_Message.showMessageDialog(null,
				"Kh??ng kh??? d???ng! X??a d???ch v??? s??? l??m ???nh h?????ng r???t nhi???u t???i d??? li???u c???a ph???n m???m. Ch???n th??m ho???c s???a ????? s??? d???ng!!",
				"Th??ng b??o", JOptionPane.INFORMATION_MESSAGE);
	}

	public void clearInput() {
		if (jOP_Check.showConfirmDialog(null, "B???n c?? mu???n x??a t???t c??? ?? nh???p d??? li???u kh??ng?", "X??a ?? nh???p",
				jOP_Check.YES_NO_CANCEL_OPTION) == 0) {
			getListService();
			tf_idService.setText("");
			tf_idService.enable(true);
			tf_nameService.setText("");
			tf_priceService.setText("");
			jOP_Message.showMessageDialog(null, "X??a ?? nh???p d??? li???u th??nh c??ng!", "Th??ng b??o",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public void exitForm() {
		if (jOP_Check.showConfirmDialog(null, "B???n c?? mu???n tho??t kh??ng?", "Tho??t",
				jOP_Check.YES_NO_CANCEL_OPTION) == 0) {
			this.setVisible(false);
			GUI_FrameMain e = new GUI_FrameMain();
			e.setVisible(true);
		}
	}
}
