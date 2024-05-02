package com.quanlikho.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DoiThongTin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldTenDangNhap;
	private JTextField textFieldEmail;
	private JTextField textFieldRole;
	private JPasswordField passwordField;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DoiThongTin frame = new DoiThongTin();
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
	public DoiThongTin() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 555, 756);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 64));
		panel.setBounds(0, 0, 623, 103);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CẬP NHẬT THÔNG TIN");
		lblNewLabel.setBounds(0, 5, 541, 98);
		panel.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBackground(new Color(0, 128, 64));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNewLabel_1 = new JLabel("Tên Đăng Nhập");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(118, 128, 124, 26);
		contentPane.add(lblNewLabel_1);
		
		textFieldTenDangNhap = new JTextField();
		textFieldTenDangNhap.setEnabled(false);
		textFieldTenDangNhap.setEditable(false);
		textFieldTenDangNhap.setBounds(118, 164, 273, 40);
		contentPane.add(textFieldTenDangNhap);
		textFieldTenDangNhap.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Email");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(118, 230, 124, 26);
		contentPane.add(lblNewLabel_1_1);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(118, 266, 273, 39);
		contentPane.add(textFieldEmail);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Chức vụ");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_1.setBounds(118, 539, 124, 26);
		contentPane.add(lblNewLabel_1_1_1);
		
		textFieldRole = new JTextField();
		textFieldRole.setColumns(10);
		textFieldRole.setBounds(118, 581, 273, 40);
		contentPane.add(textFieldRole);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Mật Khẩu");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_1_1.setBounds(118, 436, 124, 26);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(118, 472, 273, 40);
		contentPane.add(passwordField);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(118, 374, 273, 39);
		contentPane.add(textField);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Họ và Tên");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_2.setBounds(118, 338, 124, 26);
		contentPane.add(lblNewLabel_1_1_2);
		
		JButton btnNewButton = new JButton("Cập Nhật");
		btnNewButton.setIcon(new ImageIcon(DoiThongTin.class.getResource("/com/quanlikho/Item/change_24.png")));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(39, 649, 190, 48);
		contentPane.add(btnNewButton);
		
		JButton btniMtKhu = new JButton("Đổi Mật Khẩu");
		btniMtKhu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DoiMatKhau doiMatKhau = new DoiMatKhau();
				doiMatKhau.setVisible(true);
			}
		});
		btniMtKhu.setIcon(new ImageIcon(DoiThongTin.class.getResource("/com/quanlikho/Item/updated_24.png")));
		btniMtKhu.setFont(new Font("Tahoma", Font.BOLD, 16));
		btniMtKhu.setBounds(303, 649, 190, 48);
		contentPane.add(btniMtKhu);
	}
}
