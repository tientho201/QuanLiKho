package com.quanlikho.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.border.MatteBorder;
import com.quanlikho.BUS.*;


public class NVNhapHang extends JFrame {
	Color DefaultColor = new Color(0, 128, 64);
	Color ClickedColor = Color.GRAY;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel PanelPhieuNhap;
	private JPanel PanelNhapHang;
	private JPanel PanelTonKho;
	private JPanel Paneldangxuat;
	private JPanel Paneldoithongtin;
	private JPanel MainContent;
	
	private NhapHang nhapHang;
	private PhieuNhap phieuNhap;
	
	private TonKho tonKho ; 
	
	private DoiThongTin doiThongTin ;
	
	public JLabel lblTen;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
							.getInstalledLookAndFeels()) {
						if ("Nimbus".equals(info.getName())) {
							javax.swing.UIManager.setLookAndFeel(info.getClassName());
							break;
						}
					}
					final NVNhapHang frame = new NVNhapHang();
					frame.setVisible(true);
					frame.addWindowListener(new WindowAdapter() {
					    public void windowClosing(WindowEvent e) {
					        int result = JOptionPane.showConfirmDialog(frame,
					                "Bạn có chắc muốn thoát?",
					                "Xác nhận",
					                JOptionPane.YES_NO_OPTION,
					                JOptionPane.QUESTION_MESSAGE);
					        if (result == JOptionPane.YES_OPTION) {
					            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					        } else {
					            frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
					        }
					    }
					});
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public NVNhapHang() {

		
//		panel.setBounds(20, 10, 317, 750);
//		panel_1.setBounds(327,10,1180,750);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1406, 735);
		setTitle("Nhân Viên Nhập Hàng");
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setResizable(false);

		setContentPane(contentPane);
		contentPane.setLayout(null);

		MainContent = new JPanel();
		MainContent.setBounds(325, 5, 1180, 750);
		MainContent.setBackground(new Color(255, 255, 255));

		contentPane.add(MainContent);
		MainContent.setLayout(null);

		NhapHang pf = new NhapHang();
		pf.setBounds(0, 0, 1180, 693);
		MainContent.add(pf);

		JPanel panel = new JPanel();
		panel.setBounds(5, 5, 317, 690);
		panel.setBackground(new Color(0, 128, 64));

		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("XIN CHÀO");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 10, 297, 47);
		panel.add(lblNewLabel);

		lblTen = new JLabel("");
		lblTen.setForeground(new Color(255, 255, 255));
		lblTen.setHorizontalAlignment(SwingConstants.CENTER);
		lblTen.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblTen.setBounds(93, 47, 214, 47);
		panel.add(lblTen);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(255, 255, 255)));
		lblNewLabel_2.setBounds(0, 89, 317, 13);
		panel.add(lblNewLabel_2);

		PanelPhieuNhap = new JPanel();
		PanelPhieuNhap.setLayout(null);
		PanelPhieuNhap.setBorder(null);
		PanelPhieuNhap.setBackground(new Color(0, 128, 64));
		PanelPhieuNhap.setBounds(10, 173, 297, 37);
		panel.add(PanelPhieuNhap);
		PanelPhieuNhap.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		PanelPhieuNhap.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				PhieuNhapMousePressed(e);
			}

			public void mouseClicked(MouseEvent e) {
				PhieuNhapMouseClicked(e);
			}
		});
		
		
		JLabel lblPhieuNhap = new JLabel("PHIẾU NHẬP");
		lblPhieuNhap.setBounds(57, 0, 166, 37);
		PanelPhieuNhap.add(lblPhieuNhap);
		lblPhieuNhap.setIcon(new ImageIcon(Admin.class.getResource("/com/quanlikho/Item/gift-voucher_24.png")));
		lblPhieuNhap.setHorizontalAlignment(SwingConstants.LEFT);
		lblPhieuNhap.setForeground(Color.WHITE);
		lblPhieuNhap.setFont(new Font("Verdana", Font.BOLD, 15));

		PanelNhapHang = new JPanel();
		PanelNhapHang.setLayout(null);
		PanelNhapHang.setBorder(null);
		PanelNhapHang.setBackground(new Color(0, 128, 64));
		PanelNhapHang.setBounds(10, 122, 297, 37);
		panel.add(PanelNhapHang);
		PanelNhapHang.setBackground(ClickedColor);
		PanelNhapHang.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		PanelNhapHang.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				NhapHangMousePressed(e);
			}

			public void mouseClicked(MouseEvent e) {
				NhapHangMouseClicked(e);
			}
		});

		JLabel lblNhapHang = new JLabel("NHẬP HÀNG");
		lblNhapHang.setIcon(new ImageIcon(Admin.class.getResource("/com/quanlikho/Item/PhieuNhap_24.png")));
		lblNhapHang.setHorizontalAlignment(SwingConstants.LEFT);
		lblNhapHang.setForeground(Color.WHITE);
		lblNhapHang.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNhapHang.setBounds(56, 0, 160, 37);
		PanelNhapHang.add(lblNhapHang);

		PanelTonKho = new JPanel();
		PanelTonKho.setLayout(null);
		PanelTonKho.setBorder(null);
		PanelTonKho.setBackground(new Color(0, 128, 64));
		PanelTonKho.setBounds(10, 220, 297, 37);
		panel.add(PanelTonKho);
		PanelTonKho.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		PanelTonKho.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				TonKhoMousePressed(e);
			}

			public void mouseClicked(MouseEvent e) {
				TonKhoMouseClicked(e);
			}
		});

		JLabel lblTongKho = new JLabel("TỒN KHO");
		lblTongKho.setIcon(new ImageIcon(Admin.class.getResource("/com/quanlikho/Item/tongkho_24.png")));
		lblTongKho.setHorizontalAlignment(SwingConstants.LEFT);
		lblTongKho.setForeground(Color.WHITE);
		lblTongKho.setFont(new Font("Verdana", Font.BOLD, 15));
		lblTongKho.setBounds(57, 0, 166, 37);
		PanelTonKho.add(lblTongKho);

		JLabel lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(255, 255, 255)));
		lblNewLabel_2_1.setBounds(0, 580, 317, 13);
		panel.add(lblNewLabel_2_1);

		Paneldangxuat = new JPanel();
		Paneldangxuat.setLayout(null);
		Paneldangxuat.setBorder(null);
		Paneldangxuat.setBackground(new Color(0, 128, 64));
		Paneldangxuat.setBounds(10, 649, 297, 37);
		panel.add(Paneldangxuat);
		Paneldangxuat.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		Paneldangxuat.addMouseListener(new MouseAdapter() {
		    public void mousePressed(MouseEvent e) {
		        int result = JOptionPane.showConfirmDialog(null,
		                "Bạn có chắc muốn đăng xuất?",
		                "Xác nhận",
		                JOptionPane.YES_NO_OPTION,
		                JOptionPane.QUESTION_MESSAGE);
		        if(result == JOptionPane.YES_OPTION){
		            setVisible(false);
		            login Login = new login();
		            Login.setVisible(true);
		        }
		    }
		});
			
		JLabel lbldangxuat = new JLabel("ĐĂNG XUẤT");
		lbldangxuat.setIcon(new ImageIcon(Admin.class.getResource("/com/quanlikho/Item/logout_24.png")));
		lbldangxuat.setHorizontalAlignment(SwingConstants.LEFT);
		lbldangxuat.setForeground(Color.WHITE);
		lbldangxuat.setFont(new Font("Verdana", Font.BOLD, 15));
		lbldangxuat.setBounds(57, 0, 166, 37);
		Paneldangxuat.add(lbldangxuat);

		Paneldoithongtin = new JPanel();
		Paneldoithongtin.setLayout(null);
		Paneldoithongtin.setBorder(null);
		Paneldoithongtin.setBackground(new Color(0, 128, 64));
		Paneldoithongtin.setBounds(10, 603, 297, 37);
		panel.add(Paneldoithongtin);
		Paneldoithongtin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		
		
		JLabel lblDoiThongTin = new JLabel("ĐỔI THÔNG TIN");
		lblDoiThongTin.setBounds(57, 0, 199, 37);
		Paneldoithongtin.add(lblDoiThongTin);
		lblDoiThongTin.setIcon(new ImageIcon(Admin.class.getResource("/com/quanlikho/Item/doimatkhau_24.png")));
		lblDoiThongTin.setHorizontalAlignment(SwingConstants.LEFT);
		lblDoiThongTin.setForeground(Color.WHITE);
		lblDoiThongTin.setFont(new Font("Verdana", Font.BOLD, 15));
		Paneldoithongtin.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				DoiThongTinMousePressed(e);
			}

		
		});
		
		JLabel lblNewLabel_1 = new JLabel("Xin Chào:");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel_1.setBounds(10, 47, 89, 47);
		panel.add(lblNewLabel_1);

	}

	public void NhapHangMousePressed(MouseEvent evt) {

		PanelPhieuNhap.setBackground(DefaultColor);
		PanelNhapHang.setBackground(ClickedColor);

		PanelTonKho.setBackground(DefaultColor);

		Paneldoithongtin.setBackground(DefaultColor);

	
		MainContent.removeAll();
		nhapHang = new NhapHang();
		MainContent.add(nhapHang).setVisible(true);
		MainContent.revalidate();
		MainContent.repaint();
		nhapHang.txtVvjvjv_1.setText(lblTen.getText());

	}

	public void NhapHangMouseClicked(MouseEvent evt) {
		// TODO add your handling code here:
		MainContent.removeAll();
		nhapHang = new NhapHang();
		MainContent.add(nhapHang).setVisible(true);
		MainContent.revalidate();
		MainContent.repaint();
		nhapHang.txtVvjvjv_1.setText(lblTen.getText());
	}

	public void PhieuNhapMousePressed(MouseEvent evt) {

		PanelPhieuNhap.setBackground(ClickedColor);
		PanelNhapHang.setBackground(DefaultColor);
	
		PanelTonKho.setBackground(DefaultColor);
	
		Paneldoithongtin.setBackground(DefaultColor);
	
	
		MainContent.removeAll();
		phieuNhap = new PhieuNhap();
		
		MainContent.add(phieuNhap).setVisible(true);
		MainContent.revalidate();
		MainContent.repaint();

	}

	public void PhieuNhapMouseClicked(MouseEvent evt) {
		// TODO add your handling code here:
		MainContent.removeAll();
		phieuNhap = new PhieuNhap();
		MainContent.add(phieuNhap).setVisible(true);
		MainContent.revalidate();
		MainContent.repaint();
	}
	public void TonKhoMousePressed(MouseEvent evt) {

		PanelPhieuNhap.setBackground(DefaultColor);
		PanelNhapHang.setBackground(DefaultColor);

		PanelTonKho.setBackground(ClickedColor);

		Paneldoithongtin.setBackground(DefaultColor);
	
	
		MainContent.removeAll();
		tonKho = new TonKho();
		MainContent.add(tonKho).setVisible(true);
		MainContent.revalidate();
		MainContent.repaint();

	}

	public void TonKhoMouseClicked(MouseEvent evt) {
		// TODO add your handling code here:
		MainContent.removeAll();
		tonKho = new TonKho();
		MainContent.add(tonKho).setVisible(true);
		MainContent.revalidate();
		MainContent.repaint();
	}
	public void DoiThongTinMousePressed(MouseEvent evt) {

		PanelPhieuNhap.setBackground(DefaultColor);
		PanelNhapHang.setBackground(DefaultColor);
		
		PanelTonKho.setBackground(DefaultColor);
		
		Paneldoithongtin.setBackground(ClickedColor);
	
		doiThongTin = new DoiThongTin();
		doiThongTin.setVisible(true);
		
		AccountBUS accBUSupdate = new AccountBUS();
		if (accBUSupdate.getList() == null)
			accBUSupdate.list();
		doiThongTin.textFieldTenDangNhap.setText(lblTen.getText());
		doiThongTin.textFieldHovaTen.setText(accBUSupdate.PutOnHovaTen(lblTen.getText()));
	
		doiThongTin.textFieldEmail.setText(accBUSupdate.PutOnEmail(lblTen.getText()));
		doiThongTin.textFieldRole.setText(accBUSupdate.PutOnRole(lblTen.getText()));
	}
	
}
