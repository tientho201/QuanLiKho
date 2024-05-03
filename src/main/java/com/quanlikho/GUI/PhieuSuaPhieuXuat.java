package com.quanlikho.GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.quanlikho.Connect.*;

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

public class PhieuSuaPhieuXuat extends JDialog {


	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldMaPhieu;
	private JTextField textFieldMaNCC;
	private JTextField textFieldThoiGian;
	private JTextField textFieldNguoiTao;
	private JTextField textFieldTongTien;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			PhieuSuaPhieuXuat dialog = new PhieuSuaPhieuXuat();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public PhieuSuaPhieuXuat() {
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
				JLabel lblNewLabel = new JLabel("Sửa phiếu xuất");
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
		textFieldMaPhieu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldMaPhieu.setBounds(245, 106, 184, 36);
		contentPanel.add(textFieldMaPhieu);
		textFieldMaPhieu.setColumns(10);
		
		textFieldMaNCC = new JTextField();
		textFieldMaNCC.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldMaNCC.setColumns(10);
		textFieldMaNCC.setBounds(245, 164, 184, 36);
		contentPanel.add(textFieldMaNCC);
		
		textFieldThoiGian = new JTextField();
		textFieldThoiGian.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldThoiGian.setColumns(10);
		textFieldThoiGian.setBounds(245, 225, 184, 36);
		contentPanel.add(textFieldThoiGian);
		
		textFieldNguoiTao = new JTextField();
		textFieldNguoiTao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldNguoiTao.setColumns(10);
		textFieldNguoiTao.setBounds(245, 287, 184, 36);
		contentPanel.add(textFieldNguoiTao);
		
		textFieldTongTien = new JTextField();
		textFieldTongTien.setEnabled(false);
		textFieldTongTien.setEditable(false);
		textFieldTongTien.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldTongTien.setColumns(10);
		textFieldTongTien.setBounds(245, 354, 184, 36);
		contentPanel.add(textFieldTongTien);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnNewButton = new JButton("Lưu");
				btnNewButton.addActionListener(new ActionListener() {
  				public void actionPerformed(ActionEvent e) {
					luuDuLieuVaoCSDL();
					dispose();
				}
			});
				buttonPane.add(btnNewButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	private void luuDuLieuVaoCSDL() {
		try {
			ConnectJDBC connectJDBC = new ConnectJDBC();
			Connection connection = connectJDBC.getConnection();
			String sql = "UPDATE PhieuNhap SET MaNCC=?, NgayNhap=?, TenDangNhap=? WHERE MaPN=?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, textFieldMaNCC.getText());
			statement.setString(2, textFieldThoiGian.getText());
			statement.setString(3, textFieldNguoiTao.getText());
			statement.setString(4, textFieldMaPhieu.getText());
			int rowsAffected = statement.executeUpdate();
			if (rowsAffected > 0) {
				 JOptionPane.showMessageDialog(null, "Đã cập nhật thành không", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Cập nhật không thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
				// Xử lý khi có lỗi xảy ra trong quá trình cập nhật dữ liệu
			}
			
			statement.close();
			connection.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Xử lý khi có lỗi xảy ra trong quá trình thực hiện câu lệnh SQL
		}
	}
	public void loadData(String maPhieuNhap) {
        try {
            ConnectJDBC connectJDBC = new ConnectJDBC();
            Connection connection = connectJDBC.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM PhieuNhap WHERE MaPN = ?");
            statement.setString(1, maPhieuNhap);
            ResultSet resultSet = statement.executeQuery();
            
            if (resultSet.next()) {
                String maPN = resultSet.getString("MaPN");
                String maNCC = resultSet.getString("MaNCC");
                String ngayNhap = resultSet.getString("NgayNhap");
                String nguoiTao = resultSet.getString("TenDangNhap");
                int tongTien = resultSet.getInt("TongTien");
                
                // Hiển thị thông tin lên các trường JTextField
                textFieldMaPhieu.setText(maPN);
                textFieldMaNCC.setText(maNCC);
                textFieldThoiGian.setText(ngayNhap);
                textFieldNguoiTao.setText(nguoiTao);
                textFieldTongTien.setText(String.valueOf(tongTien));
            }
            
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            // Xử lý khi có lỗi xảy ra
        }
    }
}
