package com.quanlikho.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class DoiMatKhau extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField passwordFieldHienTai;
	private JPasswordField passwordFieldMoi;
	private JPasswordField passwordFieldXacNhan;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DoiMatKhau frame = new DoiMatKhau();
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
	public DoiMatKhau() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 419, 661);
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 64));
		panel.setBounds(0, 0, 421, 126);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ĐỔI MẬT KHẨU");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(10, 10, 401, 106);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Mật khẩu hiện tại");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(62, 148, 227, 33);
		contentPane.add(lblNewLabel_1);
		
		passwordFieldHienTai = new JPasswordField();
		passwordFieldHienTai.setBounds(62, 191, 279, 33);
		contentPane.add(passwordFieldHienTai);
		
		JLabel lblNewLabel_1_1 = new JLabel("Mật khẩu mới");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(62, 255, 227, 33);
		contentPane.add(lblNewLabel_1_1);
		
		passwordFieldMoi = new JPasswordField();
		passwordFieldMoi.setBounds(62, 298, 279, 33);
		contentPane.add(passwordFieldMoi);
		
		passwordFieldXacNhan = new JPasswordField();
		passwordFieldXacNhan.setBounds(62, 411, 279, 33);
		contentPane.add(passwordFieldXacNhan);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Xác nhận mật khẩu mới");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1.setBounds(62, 368, 227, 33);
		contentPane.add(lblNewLabel_1_1_1);
		
		JButton btnNewButton = new JButton("Xác Nhận");
		btnNewButton.setIcon(new ImageIcon(DoiMatKhau.class.getResource("/com/quanlikho/Item/updated_24.png")));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 27));
		btnNewButton.setBounds(66, 488, 275, 44);
		contentPane.add(btnNewButton);
	}

}
