package com.quanlikho.GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionListener;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.quanlikho.Connect.*;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class XuatHang extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField txtVvjvjv;
	public JTextField txtVvjvjv_1;
	private JTable table_1;
	private JLabel lblNewLabel_3;
	private JTextField text_SL;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JLabel lblNewLabel_4;
	private JButton btnNewButton_2;
	private JLabel labThanhTien;
	private JButton btnNewButton_4;
	private JButton btnNewButton_5;
	private int currentSTT = 1;
	private JComboBox comboBox;
        private JComboBox comboBox_1;
	private JTextField textField_5;
	private JTable table;


	/**
	 * Create the panel.
	 */
	public XuatHang() {
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
		
		btnNewButton = new JButton("Làm mới");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setIcon(new ImageIcon(XuatHang.class.getResource("/com/quanlikho/Item/icons8_reset_25px_1.png")));
		btnNewButton.setBounds(332, 23, 121, 29);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Mã phiếu xuất");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(548, 22, 127, 30);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nhà cung cấp");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(548, 55, 160, 44);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Người tạo phiếu");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(548, 147, 171, 44);
		add(lblNewLabel_2);
		
		txtVvjvjv = new JTextField();
		txtVvjvjv.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtVvjvjv.setBounds(758, 23, 300, 30);
		add(txtVvjvjv);
		txtVvjvjv.setColumns(10);
		
		txtVvjvjv_1 = new JTextField("admin");
		txtVvjvjv_1.setEditable(false);
		txtVvjvjv_1.setEnabled(false);
		txtVvjvjv_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtVvjvjv_1.setColumns(10);
		txtVvjvjv_1.setBounds(758, 161, 300, 30);
		add(txtVvjvjv_1);
		
		JTable table = new JTable(new DefaultTableModel(
	        	new Object[][] {
	        	},
	        	new String[] {
	        			"Mã sản phẩm", "Tên sản phẩm", "Số lượng", "Đơn giá"
	        	}
	        ));
	        JScrollPane scrollPane = new JScrollPane(table); 
	        scrollPane.setBounds(25, 111, 491, 500);
	        add(scrollPane, BorderLayout.CENTER); 
		
	        table_1 = new JTable(new DefaultTableModel(
	            	new Object[][] {
	            	},
	            	new String[] {
	            		"STT", "Mã SP", "Tên SP", "Số lượng", "Đơn giá"
	            	}
	            ));
	            JScrollPane scrollPane_1 = new JScrollPane(table_1); 
	            scrollPane_1.setBounds(548, 216, 510, 331);
	            add(scrollPane_1, BorderLayout.CENTER); 
		
		lblNewLabel_3 = new JLabel("Số lượng");
		lblNewLabel_3.setForeground(new Color(255, 0, 0));
		lblNewLabel_3.setBackground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(45, 641, 81, 24);
		add(lblNewLabel_3);
		
		text_SL = new JTextField("1");
		text_SL.setHorizontalAlignment(SwingConstants.CENTER);
		text_SL.setFont(new Font("Tahoma", Font.PLAIN, 14));
		text_SL.setBounds(174, 638, 97, 31);
		add(text_SL);
		text_SL.setColumns(10);
		
		btnNewButton_1 = new JButton("Thêm");
		btnNewButton_1.setEnabled(false);
		btnNewButton_1.setBackground(new Color(247, 234, 148));
		btnNewButton_1.setIcon(new ImageIcon(XuatHang.class.getResource("/com/quanlikho/Item/plus.png")));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.setBounds(373, 638, 109, 30);
		add(btnNewButton_1);
		
		lblNewLabel_4 = new JLabel("Thành tiền");
		lblNewLabel_4.setForeground(Color.RED);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4.setBackground(Color.WHITE);
		lblNewLabel_4.setBounds(585, 641, 81, 24);
		add(lblNewLabel_4);
		
		btnNewButton_2 = new JButton("Xuất hàng");
		btnNewButton_2.setEnabled(false);
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_2.setBackground(new Color(247, 234, 148));
		btnNewButton_2.setBounds(906, 638, 127, 30);
		add(btnNewButton_2);
		
		labThanhTien = new JLabel("0");
		labThanhTien.setForeground(new Color(255, 0, 0));
		labThanhTien.setFont(new Font("Tahoma", Font.BOLD, 14));
		labThanhTien.setBounds(723, 640, 146, 27);
		add(labThanhTien);
		
		btnNewButton_4 = new JButton("Sửa số lượng");
		btnNewButton_4.setEnabled(false);
		btnNewButton_4.setBackground(new Color(255, 255, 255));
		btnNewButton_4.setIcon(new ImageIcon(XuatHang.class.getResource("/com/quanlikho/Item/pencil.png")));
		btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_4.setBounds(585, 577, 137, 34);
		add(btnNewButton_4);
		
		btnNewButton_5 = new JButton("Xóa sản phẩm");
		btnNewButton_5.setBackground(new Color(255, 255, 255));
		btnNewButton_5.setIcon(new ImageIcon(XuatHang.class.getResource("/com/quanlikho/Item/recycle-bin.png")));
		btnNewButton_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_5.setBounds(878, 577, 146, 34);
		add(btnNewButton_5);
		
		comboBox = new JComboBox();
		comboBox.setBounds(758, 63, 300, 30);
		add(comboBox);
                comboBox_1 = new JComboBox();
		comboBox_1.setBounds(758, 111, 300, 36);
		add(comboBox_1);
                
                JLabel lblNewLabel_5 = new JLabel("Đại Lý");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_5.setBounds(548, 119, 65, 17);
		add(lblNewLabel_5);
		

		JLabel lblVnd = new JLabel("VND");
		lblVnd.setForeground(Color.RED);
		lblVnd.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblVnd.setBounds(912, 695, 41, 27);
		add(lblVnd);

		reloadTable(table);
	}
	/**
	 * @param table
	 */
	private void reloadTable(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0); 
        try {
            ConnectJDBC connectJDBC = new ConnectJDBC();
            Connection connection = connectJDBC.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM SanPham");
            while (rs.next()) {
                String maSP = rs.getString("MaSP");
                String tenSP = rs.getString("TenSP");
                int soLuong = rs.getInt("SoLuong");
                long donGia = rs.getLong("Gia");
                // Add a row to the table model
                model.addRow(new Object[]{maSP, tenSP, soLuong, donGia});
            }
            rs.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// Get selected row index
				int selectedRowIndex = table.getSelectedRow();
				if (selectedRowIndex != -1) { 
					Object quantity = table.getValueAt(selectedRowIndex, 2);
					if (quantity instanceof Integer) {
						int currentQuantity = (int) quantity;
						// Thực hiện các thao tác khác
						btnNewButton_1.setEnabled(true);
					}
				}
			}
		});
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRowIndex = table.getSelectedRow();
				if (selectedRowIndex != -1) { 
					Object[] rowData = new Object[table.getColumnCount()];
					for (int i = 0; i < table.getColumnCount(); i++) {
						rowData[i] = table.getValueAt(selectedRowIndex, i);
					}
					String maSP = (String) rowData[0];
					int soLuong = soLuongData(maSP);
					
					int enteredQuantity = Integer.parseInt(text_SL.getText());
				
					if(enteredQuantity < 0  ) {
						JOptionPane.showMessageDialog(XuatHang.this, "Số lượng không hợp lệ!", "Lỗi", JOptionPane.ERROR_MESSAGE);
						return ; 
					}
					if(enteredQuantity > soLuong  ) {
						JOptionPane.showMessageDialog(XuatHang.this, "Số lượng không hợp lệ!", "Lỗi", JOptionPane.ERROR_MESSAGE);
						return ; 
					}
					rowData[2] = text_SL.getText();
					long unitPrice = (long) rowData[3];
					long totalPrice = unitPrice * enteredQuantity;
		
					// Kiểm tra xem sản phẩm đã tồn tại trong table_1 chưa
					boolean productExists = false;
					DefaultTableModel model = (DefaultTableModel) table_1.getModel();
					for (int i = 0; i < model.getRowCount(); i++) {
						if (model.getValueAt(i, 1).equals(maSP)) { // Kiểm tra mã sản phẩm
							// Nếu sản phẩm đã tồn tại, chỉ cập nhật số lượng
							int currentQuantity = (int) model.getValueAt(i, 3);
							model.setValueAt(currentQuantity + enteredQuantity, i, 3); // Tăng số lượng
							model.setValueAt((long) model.getValueAt(i, 4) + totalPrice, i, 4); // Cập nhật thành tiền
							productExists = true;
							break;
						}
					}
					if (!productExists) {
						// Nếu sản phẩm chưa tồn tại, thêm mới vào table_1
						Object[] newRowData = new Object[rowData.length + 1];
						newRowData[0] = currentSTT++;
						System.arraycopy(rowData, 0, newRowData, 1, rowData.length);
						newRowData[rowData.length] = totalPrice;
						((DefaultTableModel) table_1.getModel()).addRow(newRowData);
					}
		
					labThanhTien.setText(String.valueOf(calculateTotalPrice()));
					btnNewButton_4.setEnabled(true);
					btnNewButton_2.setEnabled(true);
					text_SL.setText("1");
				}
			}
		});
		
		String MaPX = generateMaPhieuXuat();
		txtVvjvjv.setText(MaPX);

		populateComboBoxMaNCC(comboBox);
                
		populateComboBoxMaDL(comboBox_1);
		
		
		btnNewButton_4.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        int selectedRowIndex = table_1.getSelectedRow();
		        if (selectedRowIndex != -1) {
		            Object[] rowData = new Object[table.getColumnCount()];
		            for (int i = 0; i < table.getColumnCount(); i++) {
		                rowData[i] = table.getValueAt(selectedRowIndex, i);
		            }
		            String maSP = (String) table_1.getValueAt(selectedRowIndex, 1); // Assuming product code is in the second column
		            long unitPrice = getUnitPriceFromDatabase(maSP);
		            int enteredQuantity = Integer.parseInt(text_SL.getText());
		            int soLuong = soLuongData(maSP);
		            String newQuantityStr = JOptionPane.showInputDialog(XuatHang.this, "Xuất số lượng mới:", "Sửa số lượng", JOptionPane.PLAIN_MESSAGE);
		    
		            if (newQuantityStr != null && !newQuantityStr.isEmpty()) {
		                try {
		                    int newQuantity = Integer.parseInt(newQuantityStr);
		                    if (newQuantity > 0 && newQuantity <= soLuong) {
		                        long newTotalPrice = unitPrice * newQuantity;
		                        // Kiểm tra xem sản phẩm đã tồn tại trong table_1 chưa
		                        boolean productExists = false;
		                        DefaultTableModel model = (DefaultTableModel) table_1.getModel();
		                        for (int i = 0; i < model.getRowCount(); i++) {
		                            if (model.getValueAt(i, 1).equals(maSP)) { // Kiểm tra mã sản phẩm
		                                // Nếu sản phẩm đã tồn tại, chỉ cập nhật số lượng và thành tiền
		                                model.setValueAt(newQuantity, i, 3); // Cập nhật số lượng
		                                model.setValueAt(newTotalPrice, i, 4); // Cập nhật thành tiền
		                                productExists = true;
		                                break;
		                            }
		                        }
		                        if (!productExists) {
		                            // Nếu sản phẩm chưa tồn tại, thêm mới vào table_1
		                            Object[] newRowData = new Object[rowData.length];
		                            newRowData[0] = currentSTT++;
		                            System.arraycopy(rowData, 0, newRowData, 1, rowData.length);
		                            newRowData[3] = newQuantity; // Số lượng mới
		                            newRowData[4] = newTotalPrice; // Thành tiền mới
		                            model.addRow(newRowData);
		                        }
		    
		                        labThanhTien.setText(String.valueOf(calculateTotalPrice()));
		                    } else {
		                        JOptionPane.showMessageDialog(XuatHang.this, "Số lượng không hợp lệ!", "Lỗi", JOptionPane.ERROR_MESSAGE);
		                    }
		                } catch (NumberFormatException ex) {
		                    JOptionPane.showMessageDialog(XuatHang.this, "Số lượng không hợp lệ!", "Lỗi", JOptionPane.ERROR_MESSAGE);
		                }
		            } else {
		                JOptionPane.showMessageDialog(XuatHang.this, "Số lượng không hợp lệ!", "Lỗi", JOptionPane.ERROR_MESSAGE);
		            }
		        }
		    }
		});


		btnNewButton_5.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        int selectedRowIndex = table_1.getSelectedRow();
		        if (selectedRowIndex != -1) {
		            // Hiển thị hộp thoại xác nhận
		            int option = JOptionPane.showConfirmDialog(XuatHang.this, "Bạn có chắc chắn muốn xóa sản phẩm này?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
		            if (option == JOptionPane.YES_OPTION) {
		                // Xóa hàng được chọn trong table_1
		                ((DefaultTableModel) table_1.getModel()).removeRow(selectedRowIndex);
		                
		                // Cập nhật lại tổng tiền sau khi xóa hàng
		                labThanhTien.setText(String.valueOf(calculateTotalPrice()));
		            }
		        } else {
		            JOptionPane.showMessageDialog(XuatHang.this, "Hãy chọn một sản phẩm để xóa!", "Thông báo", JOptionPane.WARNING_MESSAGE);
		        }
		    }
		});


		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String searchText = textField.getText().trim();
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.setRowCount(0); 
				try {
					ConnectJDBC connectJDBC = new ConnectJDBC();
					Connection connection = connectJDBC.getConnection();
					PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM SanPham WHERE MaSP LIKE ? OR TenSP LIKE ?");
					preparedStatement.setString(1, "%" + searchText + "%");
					preparedStatement.setString(2, "%" + searchText + "%");
					ResultSet rs = preparedStatement.executeQuery();
					while (rs.next()) {
						String maSP = rs.getString("MaSP");
						String tenSP = rs.getString("TenSP");
						int soLuong = rs.getInt("SoLuong");
						long donGia = rs.getLong("Gia");
						model.addRow(new Object[]{maSP, tenSP, soLuong, donGia});
					}
					rs.close();
					preparedStatement.close();
					connection.close();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
		});

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				reloadTable(table);
			}
		});

		btnNewButton_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (table_1.getRowCount() == 0) {
					//JOptionPane.showMessageDialog(XuatHang.this, "Bảng sản phẩm đang trống. Vui lòng chọn sản phẩm trước khi nhập hàng.");
					return; 
				}
				int option = JOptionPane.showConfirmDialog(XuatHang.this, "Bạn có chắc chắn muốn xuất hàng không?", "Xác nhận xuất hàng", JOptionPane.YES_NO_OPTION);
				if (option == JOptionPane.YES_OPTION) {
					String maPhieuXuat = txtVvjvjv.getText();
					String nhaCungCap = (String) comboBox.getSelectedItem();
                                        String maDL = (String) comboBox_1.getSelectedItem();
					LocalDate thoiGianTao = LocalDate.now(); // Lấy ngày hiện tại
					String nguoiTaoPhieu = txtVvjvjv_1.getText();
					String thanhTien = labThanhTien.getText();
					ThemPhieuXuatVaoCSDL(maPhieuXuat, nhaCungCap, thoiGianTao, nguoiTaoPhieu, maDL, thanhTien);
					ThemChiTietPhieuXuatVaoCSDL(maPhieuXuat);
					reloadTable(table);
					LamRongTableVaReloadTxt();
					JOptionPane.showMessageDialog(null, "Xuất hàng thành công");
					currentSTT = 1;
					btnNewButton_1.setEnabled(true);
				} else {
					//
				}
			}
		});
		
		
	}
			
	private void LamRongTableVaReloadTxt() {
		DefaultTableModel model = (DefaultTableModel) table_1.getModel();
		model.setRowCount(0); // Xóa tất cả các dòng trong bảng table_1
	
		String MaPX = generateMaPhieuXuat();
		txtVvjvjv.setText(MaPX);
	}
	private void ThemPhieuXuatVaoCSDL(String maPhieuXuat, String nhaCungCap, LocalDate thoiGianTao, String nguoiTaoPhieu, String MaDL,  String tongTien) {
		ConnectJDBC connectJDBC = null;
		Connection connection = null;
		PreparedStatement pst = null;
		try {
			connectJDBC = new ConnectJDBC();
			connection = connectJDBC.getConnection();
			pst = connection.prepareStatement("INSERT INTO PhieuXuat (MaPX, MaNCC, ThoiGianTao, TenDangNhap, MaDL, TongTien) VALUES (?, ?, ?, ?, ?, ?)");
			pst.setString(1, maPhieuXuat);
			pst.setString(2, nhaCungCap);
			pst.setObject(3, thoiGianTao);
			pst.setString(4, nguoiTaoPhieu);
                        pst.setString(5, MaDL);
			int tongTienInt = Integer.parseInt(tongTien);
			pst.setInt(6, tongTienInt);
			pst.executeUpdate();

			pst.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	 
	private void ThemChiTietPhieuXuatVaoCSDL(String maPhieuXuat) {
		DefaultTableModel model = (DefaultTableModel) table_1.getModel();
		try {
			ConnectJDBC connectJDBC = new ConnectJDBC();
			Connection connection = connectJDBC.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO ChiTietPX (MaSP, MaPX, DonGiaXuat, SoLuong) VALUES (?, ?, ?, ?)");
			PreparedStatement updateStatement = connection.prepareStatement("UPDATE SanPham SET SoLuong = SoLuong + ? WHERE MaSP = ?");
			for (int i = 0; i < model.getRowCount(); i++) {
				String maSP = (String) model.getValueAt(i, 1); // Lấy mã sản phẩm từ cột thứ hai (index 1)
				int soLuong = Integer.parseInt(model.getValueAt(i, 3).toString()); // Chuyển đổi từ Object sang String, sau đó từ String sang int
				String donGiaXuatStr = model.getValueAt(i, 4).toString();
				int donGiaXuat = Integer.parseInt(donGiaXuatStr);
				preparedStatement.setString(1, maSP);
				preparedStatement.setString(2, maPhieuXuat);
				preparedStatement.setInt(3, donGiaXuat);
				preparedStatement.setInt(4, soLuong);
				preparedStatement.executeUpdate();
				updateStatement.setInt(1, -soLuong);
				updateStatement.setString(2, maSP);
				updateStatement.executeUpdate();
			}
			preparedStatement.close();
			updateStatement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	

	private int soLuongData(String maSP) {
		int soLuong = 0;
		try {
			ConnectJDBC connectJDBC = new ConnectJDBC();
			Connection connection = connectJDBC.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT SoLuong FROM SanPham WHERE MaSP = ?");
			preparedStatement.setString(1, maSP);
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				soLuong = rs.getInt("SoLuong");
			}
			rs.close();
			preparedStatement.close();
			connection.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return soLuong;

	}

	private String generateMaPhieuXuat() {
		String maPhieuXuat = "";
		try {
			String maxMaPhieuXuat = findMaxMaPhieuXuat();
			if (maxMaPhieuXuat != null && !maxMaPhieuXuat.isEmpty()) {
				String[] parts = maxMaPhieuXuat.split("PX"); 
				String prefix = parts[0]; 
				int number = Integer.parseInt(parts[1]); 
				if (number < 9999) { 
					number++; // Tăng số lên 1
					maPhieuXuat = prefix + "PX" + String.format("%04d", number); 
				} else {
					System.err.println("Số sau 'PX' đạt giới hạn");
				}
			} else {
				maPhieuXuat = "PX0001"; 
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return maPhieuXuat;
	}
	
	private String findMaxMaPhieuXuat() {
		String maxMaPhieuXuat = "";
		try {
			ConnectJDBC connectJDBC = new ConnectJDBC();
			Connection connection = connectJDBC.getConnection();
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT MaPX FROM PhieuXuat");
			int maxNumber = 0;
			while (rs.next()) {
				String maPhieuXuat = rs.getString("MaPX");
				int number = Integer.parseInt(maPhieuXuat.substring(2));
				if (number > maxNumber) {
					maxNumber = number;
					maxMaPhieuXuat = maPhieuXuat;
				}
			}
			rs.close();
			statement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
			// Xử lý ngoại lệ phù hợp
		}
		return maxMaPhieuXuat;
	}

	private void populateComboBoxMaNCC(JComboBox comboBox) {
		try {
			ConnectJDBC connectJDBC = new ConnectJDBC();
			Connection connection = connectJDBC.getConnection();
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT MaNCC FROM NhaCungCap");
			comboBox.removeAllItems();
			while (rs.next()) {
				String maNCC = rs.getString("MaNCC");
				comboBox.addItem(maNCC);
			}
			rs.close();
			statement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
        
        	private void populateComboBoxMaDL(JComboBox comboBox_1) {
		try {
			ConnectJDBC connectJDBC = new ConnectJDBC();
			Connection connection = connectJDBC.getConnection();
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT MaDL FROM DaiLi");
			comboBox_1.removeAllItems();
			while (rs.next()) {
				String maDL = rs.getString("MaDL");
				comboBox_1.addItem(maDL);
			}
			rs.close();
			statement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private long getUnitPriceFromDatabase(String maSP) {
		long unitPrice = 0;
		try {
			ConnectJDBC connectJDBC = new ConnectJDBC();
			Connection connection = connectJDBC.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT Gia FROM SanPham WHERE MaSP = ?");
			preparedStatement.setString(1, maSP);
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				unitPrice = rs.getLong("Gia");
			}
			rs.close();
			preparedStatement.close();
			connection.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
			// Handle exceptions appropriately
		}
		return unitPrice;
	}

	private long calculateTotalPrice() {
        long totalPrice = 0;
        DefaultTableModel model = (DefaultTableModel) table_1.getModel();
        for (int i = 0; i < model.getRowCount(); i++) {
            // Assuming "Đơn giá" is in the fourth column (index 3)
            long donGia = (long) model.getValueAt(i, 4);
            totalPrice += donGia;
        }
        return totalPrice;
    }
	
	private boolean isQuantityValid(String maSP, int newQuantity) {
        // Get the available quantity from the database
        int soLuong = soLuongData(maSP);
        return newQuantity <= soLuong;
    }

	
}


