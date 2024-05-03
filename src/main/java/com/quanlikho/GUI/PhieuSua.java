package com.quanlikho.GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.quanlikho.Connect.*;
import com.quanlikho.BUS.*;
import com.quanlikho.DTO.*;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PhieuSua extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldMaPhieu;
	private JTextField textFieldMaNCC;
	private JTextField textFieldThoiGian;
	private JTextField textFieldNguoiTao;
	private JTextField textFieldTongTien;
	private PhieuNhapHangBUS pnhBUS = new PhieuNhapHangBUS();
	private ChiTietPhieuNhapBUS ctpnBUS = new ChiTietPhieuNhapBUS();
	private PhieuNhap phieuNhapGUI;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		PhieuNhap phieuNhapGUI =new PhieuNhap();
		try {
			PhieuSua dialog = new PhieuSua("","","","","",phieuNhapGUI);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public PhieuSua(String MaPN, String MaNCC, String ngayTao, String nguoiTao, String tongTien, PhieuNhap phieuNhapGUI) {
		this.phieuNhapGUI= phieuNhapGUI;
		setBounds(100, 100, 537, 512);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBackground(new Color(0, 128, 64));
			panel.setBounds(0, 0, 523, 79);
			contentPanel.add(panel);
			panel.setLayout(new BorderLayout(0, 0));
			{
				JLabel lblNewLabel = new JLabel("Sửa phiếu nhập");
				lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel.setForeground(new Color(255, 255, 255));
				lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 26));
				panel.add(lblNewLabel);
			}
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Mã phiếu nhập");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewLabel_1.setBounds(94, 106, 111, 36);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Mã nhà cung cấp");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewLabel_1.setBounds(94, 164, 111, 36);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Thời gian tạo ");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewLabel_1.setBounds(94, 225, 111, 36);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Người tạo");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewLabel_1.setBounds(94, 287, 111, 36);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Tổng tiền");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewLabel_1.setBounds(94, 354, 111, 36);
			contentPanel.add(lblNewLabel_1);
		}
		
		textFieldMaPhieu = new JTextField();
		textFieldMaPhieu.setEnabled(false);
		textFieldMaPhieu.setEditable(false);
		textFieldMaPhieu.setText(MaPN);
		textFieldMaPhieu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldMaPhieu.setBounds(245, 106, 184, 36);
		contentPanel.add(textFieldMaPhieu);
		textFieldMaPhieu.setColumns(10);
		
		textFieldMaNCC = new JTextField();
		textFieldMaNCC.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldMaNCC.setText(MaNCC);
		textFieldMaNCC.setColumns(10);
		textFieldMaNCC.setBounds(245, 164, 184, 36);
		contentPanel.add(textFieldMaNCC);
		
		textFieldThoiGian = new JTextField();
		textFieldThoiGian.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldThoiGian.setText(ngayTao);
		textFieldThoiGian.setColumns(10);
		textFieldThoiGian.setBounds(245, 225, 184, 36);
		contentPanel.add(textFieldThoiGian);
		
		textFieldNguoiTao = new JTextField();
		textFieldNguoiTao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldNguoiTao.setText(nguoiTao);
		textFieldNguoiTao.setColumns(10);
		textFieldNguoiTao.setBounds(245, 287, 184, 36);
		contentPanel.add(textFieldNguoiTao);
		
		textFieldTongTien = new JTextField();
		textFieldTongTien.setEnabled(false);
		textFieldTongTien.setEditable(false);
		textFieldTongTien.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldTongTien.setText(tongTien);
		textFieldTongTien.setColumns(10);
		textFieldTongTien.setBounds(245, 354, 133, 36);
		contentPanel.add(textFieldTongTien);
		
		JLabel lblNewLabel_2 = new JLabel("VND");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(384, 354, 45, 36);
		contentPanel.add(lblNewLabel_2);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnNewButton = new JButton("Lưu");
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String maPhieuNhap = textFieldMaPhieu.getText();
						String maNhaCungCap = textFieldMaNCC.getText();
						String thoiGian = textFieldThoiGian.getText();
						String nguoiTao = textFieldNguoiTao.getText();
						String tongTien = textFieldTongTien.getText();
						
						// Kiểm tra xem các trường nhập liệu có rỗng không
						if (maPhieuNhap.isEmpty() || maNhaCungCap.isEmpty() || thoiGian.isEmpty() || nguoiTao.isEmpty() || tongTien.isEmpty()) {
							JOptionPane.showMessageDialog(PhieuSua.this, "Vui lòng điền đầy đủ thông tin", "Thông báo", JOptionPane.WARNING_MESSAGE);
							return; // Không thực hiện các hành động tiếp theo nếu có trường nào rỗng
						}
					
						// Tiếp tục thực hiện các hành động khác nếu không có trường nào rỗng
						PhieuNhapHangDTO phieuNhap = new PhieuNhapHangDTO(maPhieuNhap, maNhaCungCap, nguoiTao, thoiGian, Integer.parseInt(tongTien));
					
						if (pnhBUS.getList() == null) {
							pnhBUS.list();
						}
						if (ctpnBUS.getList() == null) {
							ctpnBUS.list();
						}
					
						pnhBUS.update(phieuNhap);
						JOptionPane.showMessageDialog(PhieuSua.this, "Đã lưu thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
						// Gọi phương thức reloadTable của đối tượng phieuNhapGUI
						phieuNhapGUI.reloadTable();
						dispose();
					}
				});
				
				buttonPane.add(btnNewButton);
			}
			{
			JButton cancelButton = new JButton("Cancel");
			cancelButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// Close the dialog without saving any changes
					dispose();
				}
			});
			buttonPane.add(cancelButton);
			}
		}
	}
}
