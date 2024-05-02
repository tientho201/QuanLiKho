package com.quanlikho.GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.border.TitledBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;

public class NhapHang extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField txtVvjvjv;
	private JTextField txtVvjvjv_1;
	private JTable table_1;
	private JLabel lblNewLabel_3;
	private JTextField textField_2;
	private JButton btnNewButton_1;
	private JLabel lblNewLabel_4;
	private JButton btnNewButton_2;
	private JLabel lblNewLabel_5;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;
	private JButton btnNewButton_5;

	/**
	 * Create the panel.
	 */
	public NhapHang() {
		setBounds(0,0, 1068, 693);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "T\u00ECm ki\u1EBFm", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(25, 10, 490, 83);
		add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(10, 24, 297, 29);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Làm mới");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setIcon(new ImageIcon(NhapHang.class.getResource("/com/quanlikho/Item/icons8_reset_25px_1.png")));
		btnNewButton.setBounds(332, 23, 121, 29);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Mã phiếu nhập");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(548, 22, 127, 30);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nhà cung cấp");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(548, 55, 160, 44);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Người tạo phiếu");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(548, 95, 171, 44);
		add(lblNewLabel_2);
		
		txtVvjvjv = new JTextField();
		txtVvjvjv.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtVvjvjv.setBounds(758, 23, 300, 30);
		add(txtVvjvjv);
		txtVvjvjv.setColumns(10);
		
		txtVvjvjv_1 = new JTextField();
		txtVvjvjv_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtVvjvjv_1.setColumns(10);
		txtVvjvjv_1.setBounds(758, 103, 300, 30);
		add(txtVvjvjv_1);
		
		JTable table = new JTable(new DefaultTableModel(
	        	new Object[][] {
	        	},
	        	new String[] {
	        			"Mã máy", "Tên máy", "Số lượng", "Đơn giá"
	        	}
	        ));
	        JScrollPane scrollPane = new JScrollPane(table); // Đặt table vào trong JScrollPane
	        scrollPane.setBounds(25, 111, 491, 551);
	        add(scrollPane, BorderLayout.CENTER); // Thêm JScrollPane chứa table vào vị trí CENTER của JPanel
		
	        table_1 = new JTable(new DefaultTableModel(
	            	new Object[][] {
	            	},
	            	new String[] {
	            		"STT", "Mã SP", "Tên SP", "Số lượng", "Đơn giá"
	            	}
	            ));
	            JScrollPane scrollPane_1 = new JScrollPane(table_1); // Đặt table vào trong JScrollPane
	            scrollPane_1.setBounds(548, 149, 510, 458);
	            add(scrollPane_1, BorderLayout.CENTER); // Thêm JScrollPane chứa table vào vị trí CENTER của JPanel
		
		lblNewLabel_3 = new JLabel("Số lượng");
		lblNewLabel_3.setForeground(new Color(255, 0, 0));
		lblNewLabel_3.setBackground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(46, 696, 81, 24);
		add(lblNewLabel_3);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_2.setBounds(126, 693, 97, 31);
		add(textField_2);
		textField_2.setColumns(10);
		
		btnNewButton_1 = new JButton("Thêm");
		btnNewButton_1.setBackground(new Color(247, 234, 148));
		btnNewButton_1.setIcon(new ImageIcon(NhapHang.class.getResource("/com/quanlikho/Item/plus.png")));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.setBounds(231, 694, 109, 30);
		add(btnNewButton_1);
		
		lblNewLabel_4 = new JLabel("Thành tiền");
		lblNewLabel_4.setForeground(Color.RED);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4.setBackground(Color.WHITE);
		lblNewLabel_4.setBounds(597, 696, 81, 24);
		add(lblNewLabel_4);
		
		btnNewButton_2 = new JButton("Nhập hàng");
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_2.setBackground(new Color(247, 234, 148));
		btnNewButton_2.setBounds(977, 693, 127, 30);
		add(btnNewButton_2);
		
		lblNewLabel_5 = new JLabel("10000000");
		lblNewLabel_5.setForeground(new Color(255, 0, 0));
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_5.setBounds(795, 695, 127, 27);
		add(lblNewLabel_5);
		
		btnNewButton_3 = new JButton("Nhập excel");
		btnNewButton_3.setBackground(new Color(255, 255, 255));
		btnNewButton_3.setIcon(new ImageIcon(NhapHang.class.getResource("/com/quanlikho/Item/sheet.png")));
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_3.setBounds(548, 628, 160, 34);
		add(btnNewButton_3);
		
		btnNewButton_4 = new JButton("Sửa số lượng");
		btnNewButton_4.setBackground(new Color(255, 255, 255));
		btnNewButton_4.setIcon(new ImageIcon(NhapHang.class.getResource("/com/quanlikho/Item/pencil.png")));
		btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_4.setBounds(737, 628, 137, 34);
		add(btnNewButton_4);
		
		btnNewButton_5 = new JButton("Xóa sản phẩm");
		btnNewButton_5.setBackground(new Color(255, 255, 255));
		btnNewButton_5.setIcon(new ImageIcon(NhapHang.class.getResource("/com/quanlikho/Item/recycle-bin.png")));
		btnNewButton_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_5.setBounds(898, 628, 160, 34);
		add(btnNewButton_5);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(758, 63, 300, 30);
		add(comboBox);

	}
}
