package com.quanlikho.GUI;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Cursor;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.border.MatteBorder;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;

import com.quanlikho.BUS.*;

public class login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textfiledTenDangNhap;
	private JPasswordField passwordField;
	private JLabel lblThongBao;
	private AccountBUS accountBUS = new AccountBUS();
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
					login frame = new login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public login() {
		if (accountBUS.getList() == null) {
			accountBUS.list();
		}
		initComponents();
		
	}
	public void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1054, 652);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 255, 128));
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel(
				"<html><center><img src='" + login.class.getResource("/com/quanlikho/Item/user-interface_128.png") +"'><br>LOGIN</br></center></html>");
//		lblNewLabel.setIcon(new ImageIcon(login.class.getResource("/com/quanlikho/Item/user-interface_128.png")));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		panel.add(lblNewLabel, BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 0));
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Tên Đăng Nhập");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(33, 89, 225, 73);
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(33, 247, 225, 73);
		panel_1.add(lblNewLabel_1_1);
		
		textfiledTenDangNhap = new JTextField();
		textfiledTenDangNhap.setForeground(new Color(255, 255, 255));
		textfiledTenDangNhap.setBackground(new Color(0, 0, 0));
		textfiledTenDangNhap.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		textfiledTenDangNhap.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textfiledTenDangNhap.setBounds(33, 155, 444, 61);
		panel_1.add(textfiledTenDangNhap);
		
		JButton btnDangNhap = new JButton("Đăng Nhập");
		btnDangNhap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DangNhap();
			}
		});
		btnDangNhap.setFont(new Font("Segoe UI Black", Font.BOLD, 22));
		btnDangNhap.setBounds(33, 491, 444, 48);
		panel_1.add(btnDangNhap);
		
		passwordField = new JPasswordField();
		passwordField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		passwordField.setForeground(new Color(255, 255, 255));
		passwordField.setBackground(new Color(0, 0, 0));
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		passwordField.setBounds(33, 314, 444, 61);
		panel_1.add(passwordField);
		
		lblThongBao = new JLabel("");
		lblThongBao.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblThongBao.setForeground(new Color(255, 0, 0));
		lblThongBao.setBounds(33, 408, 444, 48);
		panel_1.add(lblThongBao);
		
		textfiledTenDangNhap.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				passwordField.requestFocusInWindow(); // Di chuyển focus đến textField2
			}
		});
		btnDangNhap.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0),
				"enter");
		btnDangNhap.getActionMap().put("enter", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Thực hiện hành động tương tự khi nhấn nút "Enter Button"
				DangNhap();
			}
		});

	}
	public void DangNhap() {
		String tenDangNhapValue = textfiledTenDangNhap.getText();
		String matKhauValue = new String(passwordField.getPassword());
		if (KiemTraRong() == true) {
			if (accountBUS.checkPassword(tenDangNhapValue,matKhauValue) && accountBUS.checkEnable(tenDangNhapValue) == 1 ) {
				lblThongBao.setText("");
				
				JFrame frame = new JFrame("JOptionPane showMessageDialog");
				JOptionPane.showMessageDialog(frame, "Xin chào " + accountBUS.PutOnTenDangNhap(tenDangNhapValue) + " !",
						"", JOptionPane.INFORMATION_MESSAGE);
				if (accountBUS.PutOnRole(tenDangNhapValue).equals("QuanLyKho")) {
					QuanLyKho qlk = new QuanLyKho();
					qlk.setVisible(true);
					qlk.lblTen.setText(accountBUS.PutOnTenDangNhap(tenDangNhapValue));
				}
				if (accountBUS.PutOnRole(tenDangNhapValue).equals("Admin")) {
					Admin admin = new Admin();
					admin.setVisible(true);
					admin.lblTen.setText(accountBUS.PutOnTenDangNhap(tenDangNhapValue));
				}
				if (accountBUS.PutOnRole(tenDangNhapValue).equals("NhapHang")) {
					NVNhapHang nvNhapHang = new NVNhapHang();
					nvNhapHang.setVisible(true);
					nvNhapHang.lblTen.setText(accountBUS.PutOnTenDangNhap(tenDangNhapValue));
				}
				if (accountBUS.PutOnRole(tenDangNhapValue).equals("XuatHang")) {
					NVXuatHang nvXuatHang = new NVXuatHang();
					nvXuatHang.setVisible(true);
					nvXuatHang.lblTen.setText(accountBUS.PutOnTenDangNhap(tenDangNhapValue));
				}
				this.hide();
			}else {
				lblThongBao.setText("Mật khẩu không chính xác");
			}
		}
	}
	public boolean KiemTraRong() {
		String matKhauValue = new String(passwordField.getPassword());
		if (textfiledTenDangNhap.getText().equals("") || textfiledTenDangNhap.getText() == null) {
			lblThongBao.setText("Tên đăng nhập không được bỏ trống!");
			textfiledTenDangNhap.requestFocus();
			return false;
		}
		if (matKhauValue.equals("") || matKhauValue == null) {
			lblThongBao.setText("Mật khẩu không được bỏ trống!");
			passwordField.requestFocus();
			return false;
		}
		return true ; 
	}
}
