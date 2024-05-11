package com.quanlikho.GUI;


import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import com.quanlikho.Connect.*;
import com.quanlikho.controller.*;
import javax.swing.ImageIcon;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.HorizontalAlignment;
import com.itextpdf.layout.properties.UnitValue;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFileChooser;

public class ChiTietPhieuXuat extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private JLabel lblNewLabelMaPhieu;
    private JLabel lblNewLabelNhaCungCap; 
    private JLabel lblNewLabelNguoiTao;
    private JLabel lblNewLabelNgayTao;
	private JLabel lblNewLabelTongTien;


    public void hienThiChiTietPhieuXuat(String maPhieuXuat, String tenNhaCungCap, String ngayTao, String tongTien) {
        lblNewLabelMaPhieu.setText(maPhieuXuat);
		lblNewLabelNhaCungCap.setText(tenNhaCungCap); 
		lblNewLabelNgayTao.setText(ngayTao);
		lblNewLabelTongTien.setText(tongTien);
    }

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ChiTietPhieuXuat dialog = new ChiTietPhieuXuat("");
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Create the dialog.
	 */
	public ChiTietPhieuXuat(String maPX) {
		
		setBounds(100, 100, 850, 500);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 64));
		panel.setBounds(0, 0, 836, 57);
		contentPanel.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("CHI TIẾT PHIẾU XUẤT");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBackground(new Color(0, 128, 64));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 57, 836, 98);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Mã phiếu:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(20, 10, 154, 35);
		panel_1.add(lblNewLabel_1);
		
		lblNewLabelMaPhieu = new JLabel("");
		lblNewLabelMaPhieu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabelMaPhieu.setBounds(184, 10, 154, 35);
		panel_1.add(lblNewLabelMaPhieu);
		
		JLabel lblNhCungCp = new JLabel("Nhà Cung Cấp");
		lblNhCungCp.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNhCungCp.setBounds(20, 55, 154, 35);
		panel_1.add(lblNhCungCp);
		
		lblNewLabelNhaCungCap = new JLabel("");
		lblNewLabelNhaCungCap.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabelNhaCungCap.setBounds(184, 55, 154, 35);
		panel_1.add(lblNewLabelNhaCungCap);
		
		JLabel lblNgiTo = new JLabel("Người tạo");
		lblNgiTo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNgiTo.setBounds(468, 10, 154, 35);
		panel_1.add(lblNgiTo);
		
		lblNewLabelNguoiTao = new JLabel("");
		lblNewLabelNguoiTao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabelNguoiTao.setBounds(638, 10, 154, 35);
		panel_1.add(lblNewLabelNguoiTao);
		
		JLabel lblNgyTo = new JLabel("Ngày tạo");
		lblNgyTo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNgyTo.setBounds(468, 55, 154, 35);
		panel_1.add(lblNgyTo);
		
		lblNewLabelNgayTao = new JLabel("");
		lblNewLabelNgayTao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabelNgayTao.setBounds(638, 55, 154, 35);
		panel_1.add(lblNewLabelNgayTao);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 165, 815, 229);
		contentPanel.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
			},
			new String[] {
				"STT", "Mã sản phẩm", "Tên sản phẩm", "Số lượng", "Đơn giá", "Thành tiền"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(0).setMinWidth(40);
		table.getColumnModel().getColumn(0).setMaxWidth(100);
		table.getColumnModel().getColumn(1).setPreferredWidth(200);
		table.getColumnModel().getColumn(1).setMinWidth(200);
		panel_2.add(table);
		JScrollPane scrollPane = new JScrollPane(table);
		panel_2.add(scrollPane);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(9, 406, 816, 47);
		contentPanel.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Tổng tiền:");
		lblNewLabel_2.setForeground(new Color(255, 0, 0));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setBounds(0, 0, 95, 47);
		panel_3.add(lblNewLabel_2);

		lblNewLabelTongTien = new JLabel("0");
		lblNewLabelTongTien.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabelTongTien.setForeground(Color.RED);
		lblNewLabelTongTien.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabelTongTien.setBounds(99, 0, 170, 47);
		panel_3.add(lblNewLabelTongTien);

		JLabel lblVnd = new JLabel("VND");
		lblVnd.setHorizontalAlignment(SwingConstants.CENTER);
		lblVnd.setForeground(Color.RED);
		lblVnd.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblVnd.setBounds(268, 0, 66, 47);
		panel_3.add(lblVnd);
		
		JButton btnNewPDF = new JButton("Xuất PDF");
		btnNewPDF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  WritePDF writepdf = new WritePDF();
			       writepdf.writePhieuXuat(maPX, lblNewLabelNguoiTao.getText());
			}
		});
		btnNewPDF.setIcon(new ImageIcon(ChiTietPhieuXuat.class.getResource("/com/quanlikho/Item/pdf.png")));
		btnNewPDF.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewPDF.setBounds(640, 0, 142, 47);
		panel_3.add(btnNewPDF);
		loadDataToTable(maPX);
		
	}

	private void loadDataToTable(String maPhieuXuat) {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("STT");
		model.addColumn("Mã sản phẩm");
		model.addColumn("Tên sản phẩm");
		model.addColumn("Số lượng");
		model.addColumn("Đơn giá");
		model.addColumn("Thành tiền");
		try {
			ConnectJDBC con = new ConnectJDBC();
			Connection connection = con.getConnection();
			String query = "SELECT MaSP, SoLuong FROM ChiTietPX WHERE MaPX = ?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, maPhieuXuat);
			ResultSet resultSet = statement.executeQuery();
	
			int stt = 1;
			while (resultSet.next()) {
				String maSanPham = resultSet.getString("MaSP");
				int soLuong = resultSet.getInt("SoLuong");
				String queryProduct = "SELECT TenSP, Gia FROM SanPham WHERE MaSP = ?";
				PreparedStatement statementProduct = connection.prepareStatement(queryProduct);
				statementProduct.setString(1, maSanPham);
				ResultSet resultSetProduct = statementProduct.executeQuery();
	
				if (resultSetProduct.next()) {
					String tenSanPham = resultSetProduct.getString("TenSP");
					double donGia = resultSetProduct.getDouble("Gia");
					double thanhTien = soLuong * donGia;
	
					model.addRow(new Object[]{stt++, maSanPham, tenSanPham, soLuong, donGia, thanhTien});
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		table.setModel(model);

		try {
			ConnectJDBC con = new ConnectJDBC();
			Connection connection = con.getConnection();
	
			String query = "SELECT TenDangNhap FROM PhieuXuat WHERE MaPX = ?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, maPhieuXuat);
			ResultSet resultSet = statement.executeQuery();
	
			if (resultSet.next()) {
				String nguoiTao = resultSet.getString("TenDangNhap");
				lblNewLabelNguoiTao.setText(nguoiTao);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}

	    public static void exportToPDF(JTable table, String filePath) {
	        try {
	            PdfWriter writer = new PdfWriter(filePath);
	            PdfDocument pdf = new PdfDocument(writer);
	            Document document = new Document(pdf);
	            document.setMargins(20, 20, 20, 20);

	            Table pdfTable = new Table(table.getColumnCount());
	            pdfTable.setWidth(UnitValue.createPercentValue(100));

	            DefaultTableModel model = (DefaultTableModel) table.getModel();
	            for (int row = 0; row < model.getRowCount(); row++) {
	                for (int column = 0; column < model.getColumnCount(); column++) {
	                    pdfTable.addCell(new Cell().add(new com.itextpdf.layout.element.Paragraph(model.getValueAt(row, column).toString())));
	                }
	            }

	            for (int i = 0; i < table.getColumnCount(); i++) {
	                pdfTable.setHorizontalAlignment(HorizontalAlignment.CENTER);
	            }

	            document.add(pdfTable);
	            document.close();

	            JOptionPane.showMessageDialog(null, "Exported successfully to " + filePath);
	        } catch (FileNotFoundException e) {
	            JOptionPane.showMessageDialog(null, "Error exporting to PDF: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	        }
	    }
	
	
}
