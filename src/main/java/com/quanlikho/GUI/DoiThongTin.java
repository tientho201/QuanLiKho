package com.quanlikho.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.quanlikho.BUS.*;

import com.quanlikho.DTO.*;
public class DoiThongTin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField textFieldTenDangNhap;
	public JTextField textFieldEmail;
	public JTextField textFieldRole;
	public JTextField textFieldHovaTen;
	private AccountBUS accBUS = new AccountBUS();
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
		setBounds(100, 100, 555, 707);
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
		lblNewLabel_1_1.setBounds(118, 346, 124, 26);
		contentPane.add(lblNewLabel_1_1);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(118, 399, 273, 39);
		contentPane.add(textFieldEmail);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Chức vụ");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_1.setBounds(118, 450, 124, 26);
		contentPane.add(lblNewLabel_1_1_1);
		
		textFieldRole = new JTextField();
		textFieldRole.setEnabled(false);
		textFieldRole.setEditable(false);
		textFieldRole.setColumns(10);
		textFieldRole.setBounds(118, 502, 273, 40);
		contentPane.add(textFieldRole);
		
		textFieldHovaTen = new JTextField();
		textFieldHovaTen.setColumns(10);
		textFieldHovaTen.setBounds(118, 280, 273, 39);
		contentPane.add(textFieldHovaTen);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Họ và Tên");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_2.setBounds(118, 228, 124, 26);
		contentPane.add(lblNewLabel_1_1_2);
		
		JButton btnNewButton = new JButton("Cập Nhật");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				XacNhan();
			}
		});
		btnNewButton.setIcon(new ImageIcon(DoiThongTin.class.getResource("/com/quanlikho/Item/change_24.png")));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(39, 601, 190, 48);
		contentPane.add(btnNewButton);
		
		JButton btniMtKhu = new JButton("Đổi Mật Khẩu");
		btniMtKhu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doiMatKhau();
			}
		});
		btniMtKhu.setIcon(new ImageIcon(DoiThongTin.class.getResource("/com/quanlikho/Item/updated_24.png")));
		btniMtKhu.setFont(new Font("Tahoma", Font.BOLD, 16));
		btniMtKhu.setBounds(301, 601, 190, 48);
		contentPane.add(btniMtKhu);
	}
	public void XacNhan() {
		if(accBUS.getList() == null) accBUS.list();
		if(KiemTraTrong()) {
			AccountDTO accDTO = new AccountDTO(textFieldTenDangNhap.getText() , textFieldHovaTen.getText() , textFieldEmail.getText() , accBUS.PutOnPassword(textFieldTenDangNhap.getText()) , textFieldRole.getText() , 1 );
			accBUS.updateAcc(accDTO);
			JOptionPane.showMessageDialog(null, "Đổi thông tin thành công!", "Thông báo", JOptionPane.WARNING_MESSAGE);
			this.hide();
		}
		
	}
	public void doiMatKhau() {
	
		AccountBUS accBUSupdate = new AccountBUS();
		if (accBUSupdate.getList() == null)
			accBUSupdate.list();
		DoiMatKhau doiMatKhau = new DoiMatKhau();
		doiMatKhau.setVisible(true);
		doiMatKhau.passwordFieldHienTai.setText(accBUSupdate.PutOnPassword(textFieldTenDangNhap.getText()));
		doiMatKhau.lblTenDangNhap.setText(textFieldTenDangNhap.getText());
	}
	private boolean KiemTraTrong() {
		if (textFieldTenDangNhap.getText() == null || textFieldTenDangNhap.getText().equals("")) {
		
			JOptionPane.showMessageDialog(null, "Tên đăng nhập không được trống!", "Thông báo", JOptionPane.WARNING_MESSAGE);
			textFieldTenDangNhap.requestFocus();
			return false;
		}
		if (textFieldHovaTen.getText() == null || textFieldHovaTen.getText().equals("")) {
			
			JOptionPane.showMessageDialog(null, "Họ và tên không được trống!", "Thông báo", JOptionPane.WARNING_MESSAGE);
			textFieldHovaTen.requestFocus();
			return false;
		}
		

		if (textFieldRole.getText() == null || textFieldRole.getText().equals("")) {
		
			JOptionPane.showMessageDialog(null, "Chức vụ không được trống!", "Thông báo", JOptionPane.WARNING_MESSAGE);
			textFieldRole.requestFocus();
			return false;
		}
		return true;
	}
}
