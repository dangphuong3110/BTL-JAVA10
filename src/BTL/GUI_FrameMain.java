package BTL;

import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import java.awt.Color;

public class GUI_FrameMain extends JFrame {

	private JPanel contentPane;
	GUI_Room g;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_FrameMain frame = new GUI_FrameMain();
					
					
					frame.setVisible(true);
					//frame.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("C:\\Users\\Admin\\Documents\\jav2\\BTL_10\\BTL-JAVA10\\src\\BTL\\test.jpg")))));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI_FrameMain() {
		setTitle("Phần mềm quản lý khách sạn");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 877, 592);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(255, 255, 255));
		menuBar.setBounds(10, 10, 177, 22);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Quản Lý");
		mnNewMenu.setBackground(Color.BLACK);
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Phòng");
		mntmNewMenuItem.setIcon(new ImageIcon("D:\\room.png"));
		mntmNewMenuItem.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				try {
					g = new GUI_Room();
					TurnOnOffFrame();
					g.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
					//gr.show();
				}catch(Exception e1){
			        e1.printStackTrace();
				} 
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Dịch Vụ");
		mntmNewMenuItem_1.setIcon(new ImageIcon("D:\\service.png"));
		mntmNewMenuItem_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				try {
					GUI_Service g = new GUI_Service();
					//TurnOnOffFrame();
					g.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
					g.show();
				}catch(Exception e1){
			        e1.printStackTrace();
				} 
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Hóa Đơn");
		mntmNewMenuItem_2.setIcon(new ImageIcon("D:\\bill.png"));
		mntmNewMenuItem_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				try {
					GUI_Bill g = new GUI_Bill();
					g.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
					g.show();
				}catch(Exception e1){
			        e1.printStackTrace();
				} 
			}
		});
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Khách Hàng");
		mntmNewMenuItem_3.setIcon(new ImageIcon("D:\\customer.png"));
		mntmNewMenuItem_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				try {
					GUI_Customer g = new GUI_Customer();
					g.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
					g.show();
				}catch(Exception e1){
			        e1.printStackTrace();
				} 
			}
		});
		mnNewMenu.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Nhân Viên");
		mntmNewMenuItem_4.setIcon(new ImageIcon("D:\\staff1.png"));
		mntmNewMenuItem_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				try {
					GUI_Staff g = new GUI_Staff();
					g.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
					g.show();
				}catch(Exception e1){
			        e1.printStackTrace();
				} 
			}
		});
		mnNewMenu.add(mntmNewMenuItem_4);
		
		JMenu mnNewMenu_1 = new JMenu("Thống Kê");
		mnNewMenu_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					GUI_Statistical g = new GUI_Statistical();
					g.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
					g.show();
				}catch(Exception e1){
			        e1.printStackTrace();
				} 
			}
		});
		menuBar.add(mnNewMenu_1);
		
		JMenu mnNewMenu_2 = new JMenu("Thoát");
		mnNewMenu_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		menuBar.add(mnNewMenu_2);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Admin\\Documents\\jav2\\BTL_10\\BTL-JAVA10\\src\\BTL\\test.jpg"));
		lblNewLabel.setBounds(10, 10, 843, 535);
		contentPane.add(lblNewLabel);
		 
		
	}
	public void TurnOnOffFrame() {
		this.setVisible(false);
		g.setVisible(true);
	}
}
