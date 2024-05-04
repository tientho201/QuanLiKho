package com.quanlikho.GUI;


import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.BorderLayout;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.BoxLayout;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.quanlikho.Connect.*;
import com.quanlikho.DAO.*;

import javax.swing.JScrollPane;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JFormattedTextField;
import java.awt.Font;
import java.awt.Component;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class PhieuXuat extends JPanel {
	// public static void main(String[] args) {
	// 	JFrame frame = new JFrame("Ứng dụng xuất hàng");
    //     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    //     // Tạo một instance của panel XuatHang
    //     PhieuXuat PhieuXuatPanel = new PhieuXuat();
        
    //     // Thêm panel vào frame
    //     frame.getContentPane().add(PhieuXuatPanel);

    //     // Thiết lập kích thước của frame và hiển thị nó
    //     frame.setSize(1280, 850);
    //     frame.setVisible(true);
	// }

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JComboBox comboBox;
    private DefaultTableModel tableModel;
    private JTable table;
    private JButton btnXemChiTiet;
    private ChiTietPhieuXuat chiTietPhieuXuatDialog;
    private JFormattedTextField fromDateField;
    private JFormattedTextField toDateField;
    private JFormattedTextField minPriceField;
    private JFormattedTextField maxPriceField;

	/**
	 * Create the panel.
	 */
	public PhieuXuat() {
        
        // Đặt kích thước cho JPanel
		setBounds(0, 0, 1068, 693);
        setLayout(new BorderLayout(0, 0));
        
        JPanel panel = new JPanel();
        panel.setBounds(new Rectangle(0, 0, 1180, 70));
        add(panel, BorderLayout.NORTH);
        
        JPanel panel_2 = new JPanel();
        panel_2.setBorder(new TitledBorder(null, "Ch\u1EE9c n\u0103ng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.X_AXIS));
        
        JButton btnXoa = new JButton("Xoá", new ImageIcon(getClass().getResource("/com/quanlikho/Item/icons8_delete_40px.png")));
        panel_2.add(btnXoa);
        
        JButton btnSua = new JButton("Sửa", new ImageIcon(getClass().getResource("/com/quanlikho/Item/icons8_edit_40px.png")));
        panel_2.add(btnSua);
        
        JButton btnThem = new JButton("Xem chi tiết", new ImageIcon(PhieuXuat.class.getResource("/com/quanlikho/Item/icons8_eye_40px.png")));
        btnThem.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        panel_2.add(btnThem);
        
        JButton btnNhap = new JButton("Nhập Excel", new ImageIcon(getClass().getResource("/com/quanlikho/Item/icons8_xls_40px.png")));
        panel_2.add(btnNhap);
        
        JButton btnXuat = new JButton("Xuất Excel", new ImageIcon(getClass().getResource("/com/quanlikho/Item/icons8_xls_40px.png")));
        btnXuat.setHorizontalAlignment(SwingConstants.LEADING);
        panel_2.add(btnXuat);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBorder(new TitledBorder(null, "T\u00ECm ki\u1EBFm", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel_1.setLayout(null);
        
        comboBox = new JComboBox();
        comboBox.setBounds(22, 26, 112, 28);
        panel_1.add(comboBox);
        
        textField = new JTextField();
        textField.setBounds(161, 26, 166, 28);
        panel_1.add(textField);
        textField.setColumns(10);
        
        JButton btnReset = new JButton("Làm mới");
        btnReset.setBounds(337, 24, 112, 33);
        btnReset.setIcon(new ImageIcon(PhieuXuat.class.getResource("/com/quanlikho/Item/icons8_reset_25px_1.png")));
        panel_1.add(btnReset);
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.add(panel_2);
        panel.add(panel_1);
        
        JPanel panel_3 = new JPanel();
        add(panel_3, BorderLayout.CENTER);
        panel_3.setLayout(null);
        
        JPanel panel_1_1 = new JPanel();
        panel_1_1.setBounds(0, 10, 553, 68);
        panel_1_1.setLayout(null);
        panel_1_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "L\u1ECDc theo ng\u00E0y", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
        panel_3.add(panel_1_1);
        
        fromDateField = new JFormattedTextField(new SimpleDateFormat("yyyy-MM-dd"));
        fromDateField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        fromDateField.setBounds(78, 28, 160, 27);
        panel_1_1.add(fromDateField);
        
        JLabel lblNewLabel = new JLabel("Từ ngày");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel.setBounds(10, 31, 71, 17);
        panel_1_1.add(lblNewLabel);
        
        toDateField = new JFormattedTextField(new SimpleDateFormat("yyyy-MM-dd"));
        toDateField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        toDateField.setBounds(309, 28, 176, 27);
        panel_1_1.add(toDateField);
        
        JLabel lblnNgy = new JLabel("Đến ngày");
        lblnNgy.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblnNgy.setBounds(241, 33, 71, 17);
        panel_1_1.add(lblnNgy);
        
        JButton btnNewButtonLoc = new JButton("Lọc");
        btnNewButtonLoc.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnNewButtonLoc.setBounds(488, 29, 55, 25);
        panel_1_1.add(btnNewButtonLoc);
        
        JPanel panel_1_1_1 = new JPanel();
        panel_1_1_1.setLayout(null);
        panel_1_1_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "L\u1ECDc theo gi\u00E1", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
        panel_1_1_1.setBounds(563, 10, 505, 68);
        panel_3.add(panel_1_1_1);
        
        minPriceField = new JFormattedTextField();
        minPriceField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        minPriceField.setBounds(39, 28, 127, 27);
        panel_1_1_1.add(minPriceField);
        
        JLabel lblT = new JLabel("Từ");
        lblT.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblT.setBounds(10, 33, 35, 17);
        panel_1_1_1.add(lblT);
        
        maxPriceField = new JFormattedTextField();
        maxPriceField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        maxPriceField.setBounds(233, 28, 127, 27);
        panel_1_1_1.add(maxPriceField);
        
        JLabel lbln = new JLabel("Đến");
        lbln.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lbln.setBounds(186, 33, 55, 17);
        panel_1_1_1.add(lbln);
        
        JButton btnNewButtonLoc_1 = new JButton("Lọc");
        btnNewButtonLoc_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnNewButtonLoc_1.setBounds(406, 29, 55, 25);
        panel_1_1_1.add(btnNewButtonLoc_1);
        
        table = new JTable();
            JScrollPane scrollPane = new JScrollPane(table); // Đặt table vào trong JScrollPane
            panel_3.add(scrollPane);
            scrollPane.setBounds(0, 88, 1068, 525);
            // Khởi tạo DefaultTableModel với các cột tương ứng
        tableModel = new DefaultTableModel(new Object[]{"STT", "Mã phiếu xuất", "Nhà cung cấp", "Thời gian tạo","Đại lí", "Tổng tiền"}, 0);

        // Truy vấn dữ liệu từ bảng PhieuXuat và thêm vào DefaultTableModel
        try {
        	 ConnectJDBC connectJDBC = new ConnectJDBC();
            Connection connection = connectJDBC.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM PhieuXuat");
            ResultSet resultSet = statement.executeQuery();

            int stt = 1;
            while (resultSet.next()) {
                String maPX = resultSet.getString("MaPX");
                String maNCC = resultSet.getString("MaNCC");
                String ngayXuat = resultSet.getString("ThoiGianTao");
                
                String maDL = resultSet.getString("MaDL");
                int tongTien = resultSet.getInt("TongTien");

                // Thêm dòng mới vào DefaultTableModel
                tableModel.addRow(new Object[]{stt, maPX, maNCC, ngayXuat, maDL, tongTien});
                stt++;
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        table.setModel(tableModel);
        btnXoa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    String maPX = (String) tableModel.getValueAt(selectedRow, 1);
                    int option = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn xóa phiếu xuất này không?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
                    if (option == JOptionPane.YES_OPTION) {
                        try {
                            ConnectJDBC connectJDBC = new ConnectJDBC();
                            Connection connection = connectJDBC.getConnection();
                            PreparedStatement deleteChiTietStatement = connection.prepareStatement("DELETE FROM ChiTietPX WHERE MaPX = ?");
                            deleteChiTietStatement.setString(1, maPX);
                            deleteChiTietStatement.executeUpdate();
                            deleteChiTietStatement.close();
                            PreparedStatement deletePhieuXuatStatement = connection.prepareStatement("DELETE FROM PhieuXuat WHERE MaPX = ?");
                            deletePhieuXuatStatement.setString(1, maPX);
                            deletePhieuXuatStatement.executeUpdate();
                            deletePhieuXuatStatement.close();
                            connection.close();
                            tableModel.removeRow(selectedRow);
                            
                            JOptionPane.showMessageDialog(null, "Đã xóa phiếu xuất thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                            JOptionPane.showMessageDialog(null, "Xóa phiếu xuất không thành công!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn một hàng để xóa!", "Thông báo", JOptionPane.WARNING_MESSAGE);
                }
            }
        }); 
        
        
btnThem.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            Object maPhieuXuatObj = tableModel.getValueAt(selectedRow, 1);
            Object maNhaCungCapObj = tableModel.getValueAt(selectedRow, 2);
            Object ngayTaoObj = tableModel.getValueAt(selectedRow, 3);
            Object tongTienObj = tableModel.getValueAt(selectedRow, 5);

            if (maPhieuXuatObj != null ) {
                String maPhieuXuat = maPhieuXuatObj.toString();
                String maNhaCungCap = maNhaCungCapObj.toString();
                String ngayTao = ngayTaoObj.toString();
                String tongTien = tongTienObj.toString();

                chiTietPhieuXuatDialog = new ChiTietPhieuXuat(maPhieuXuat);
                chiTietPhieuXuatDialog.hienThiChiTietPhieuXuat(maPhieuXuat, maNhaCungCap, ngayTao, tongTien);
                chiTietPhieuXuatDialog.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Dữ liệu không hợp lệ.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn một phiếu xuất để xem!", "Thông báo", JOptionPane.WARNING_MESSAGE);
        }
    }
});


        
        btnNhap.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Chọn tệp Excel");
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Tệp Excel", "xlsx");
        fileChooser.setFileFilter(filter);

        int userSelection = fileChooser.showOpenDialog(null);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToImport = fileChooser.getSelectedFile();
            try {
                FileInputStream fileInputStream = new FileInputStream(fileToImport);
                Workbook workbook = new XSSFWorkbook(fileInputStream);
                Sheet sheet = workbook.getSheetAt(0); // Lấy sheet đầu tiên
                Iterator<Row> iterator = sheet.iterator();
                DefaultTableModel model = (DefaultTableModel) table.getModel();

                while (iterator.hasNext()) {
                    Row currentRow = iterator.next();
                    // Bỏ qua dòng tiêu đề (nếu cần)
                    if (currentRow.getRowNum() == 0) {
                        continue;
                    }

                    // Lấy dữ liệu từ các ô trong dòng hiện tại
                    String maPX = currentRow.getCell(0).getStringCellValue();
                    String maNCC = currentRow.getCell(1).getStringCellValue();
                    String ngayXuat = currentRow.getCell(2).getStringCellValue();
                    String tongTien = currentRow.getCell(3).getStringCellValue();

                    // Thêm dữ liệu vào table
                    model.addRow(new Object[]{maPX, maNCC, ngayXuat, tongTien});
                }

                workbook.close();
                fileInputStream.close();
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Không tìm thấy tệp Excel.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            } catch (IOException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Lỗi khi đọc tệp Excel.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
});

        
      btnXuat.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        try {
            Workbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet("PhieuXuat");

            Row headerRow = sheet.createRow(0);
            for (int i = 0; i < table.getColumnCount(); i++) {
                headerRow.createCell(i).setCellValue(table.getColumnName(i));
            }

            for (int row = 0; row < table.getRowCount(); row++) {
                Row excelRow = sheet.createRow(row + 1);
                for (int col = 0; col < table.getColumnCount(); col++) {
                    Object value = table.getValueAt(row, col);
                    if (value != null) {
                        excelRow.createCell(col).setCellValue(value.toString());
                    } else {
                        excelRow.createCell(col).setCellValue(""); // Gán giá trị rỗng nếu giá trị là null
                    }
                }
            }

            String excelFilePath = "PhieuXuat.xlsx";
            FileOutputStream fileOut = new FileOutputStream(excelFilePath);
            workbook.write(fileOut);
            fileOut.close();
            workbook.close();

            JOptionPane.showMessageDialog(null, "Dữ liệu đã được xuất thành công vào file Excel.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Xuất dữ liệu vào file Excel thất bại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }
});


        
        btnNewButtonLoc.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String fromDate = fromDateField.getText();
                String toDate = toDateField.getText();
                try {
                    ConnectJDBC connectJDBC = new ConnectJDBC();
                    Connection connection = connectJDBC.getConnection();
                    PreparedStatement statement = connection.prepareStatement("SELECT * FROM PhieuXuat WHERE ThoiGianTao BETWEEN ? AND ?");
                    statement.setString(1, fromDate);
                    statement.setString(2, toDate);
                    ResultSet resultSet = statement.executeQuery();
                    tableModel.setRowCount(0);
                    int stt = 1;
                    while (resultSet.next()) {
                        String maPX = resultSet.getString("MaPX");
                        String maNCC = resultSet.getString("MaNCC");
                        String ngayXuat = resultSet.getString("ThoiGianTao");
                        int tongTien = resultSet.getInt("TongTien");
                        tableModel.addRow(new Object[]{stt, maPX, maNCC, ngayXuat, tongTien});
                        stt++;
                    }
        
                    resultSet.close();
                    statement.close();
                    connection.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        btnNewButtonLoc_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int minPrice = Integer.parseInt(minPriceField.getText());
                    int maxPrice = Integer.parseInt(maxPriceField.getText());
                    
                    ConnectJDBC connectJDBC = new ConnectJDBC();
                    Connection connection = connectJDBC.getConnection();
                    PreparedStatement statement = connection.prepareStatement("SELECT * FROM PhieuXuat WHERE TongTien BETWEEN ? AND ?");
                    statement.setInt(1, minPrice);
                    statement.setInt(2, maxPrice);
                    ResultSet resultSet = statement.executeQuery();
                    tableModel.setRowCount(0);
                    int stt = 1;
                    while (resultSet.next()) {
                        String maPX = resultSet.getString("MaPX");
                        String maNCC = resultSet.getString("MaNCC");
                        String ngayXuat = resultSet.getString("ThoiGianTao");
                        int tongTien = resultSet.getInt("TongTien");
                        tableModel.addRow(new Object[]{stt, maPX, maNCC, ngayXuat, tongTien});
                        stt++;
                    }
        
                    resultSet.close();
                    statement.close();
                    connection.close();
                } catch (NumberFormatException ex) {
                    // Xử lý khi xuất không phải là số
                    JOptionPane.showMessageDialog(null, "Dữ liệu không hợp lệ. Vui lòng xuất số.", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        
        String[] searchOptions = {"Tìm kiếm", "Mã phiếu xuất", "Mã nhà cung cấp"};
        for (String option : searchOptions) {
            comboBox.addItem(option);
        }
        textField.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                performSearch();
            }
        });

        btnReset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                minPriceField.setValue(""); // Gán giá trị rỗng
                maxPriceField.setValue(""); // Gán giá trị rỗng
                comboBox.setSelectedItem("Tìm kiếm");
                textField.setText("");
                fromDateField.setValue(null); 
                toDateField.setValue(null);
                reloadTable();
            }
        });
       
        btnSua.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    String maPhieuXuat = (String) tableModel.getValueAt(selectedRow, 1);
                    PhieuSuaPhieuXuat phieuSua = new PhieuSuaPhieuXuat();
                    phieuSua.loadData(maPhieuXuat);
                    phieuSua.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                    phieuSua.setVisible(true);
                    phieuSua.addWindowListener(new java.awt.event.WindowAdapter() {
                        @Override
                        public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                            reloadTable();
                        }
                    });
                } else {
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn một phiếu xuất để sửa!", "Thông báo", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        
    }
        
        

  



	private void performSearch() {
        String selectedOption = (String) comboBox.getSelectedItem();
        String searchText = textField.getText().trim();
        try {
            ConnectJDBC connectJDBC = new ConnectJDBC();
            Connection connection = connectJDBC.getConnection();
            PreparedStatement statement = null;
            ResultSet resultSet = null;
            if (selectedOption.equals("Mã phiếu xuất")) {
                statement = connection.prepareStatement("SELECT * FROM PhieuXuat WHERE MaPX LIKE ?");
            } else if (selectedOption.equals("Mã nhà cung cấp")) {
                statement = connection.prepareStatement("SELECT * FROM PhieuXuat WHERE MaNCC LIKE ?");
            } else if (selectedOption.equals("Thời gian tạo")) {
                statement = connection.prepareStatement("SELECT * FROM PhieuXuat WHERE ThoiGianTao LIKE ?");
            }
            if (statement != null) {
                statement.setString(1, "%" + searchText + "%");
                resultSet = statement.executeQuery();
                tableModel.setRowCount(0); // Xóa dữ liệu hiện tại trong bảng
    
                int stt = 1;
                while (resultSet.next()) {
                    String maPX = resultSet.getString("MaPX");
                    String maNCC = resultSet.getString("MaNCC");
                    String ngayXuat = resultSet.getString("ThoiGianTao");
                    int tongTien = resultSet.getInt("TongTien");
                    // Thêm dòng mới vào mô hình bảng
                    tableModel.addRow(new Object[]{stt, maPX, maNCC, ngayXuat, tongTien});
                    stt++;
                }
            }
            if (resultSet != null) resultSet.close();
            if (statement != null) statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    

    private void reloadTable() {
        tableModel.setRowCount(0);
        try {
            ConnectJDBC connectJDBC = new ConnectJDBC();
            Connection connection = connectJDBC.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM PhieuXuat");
            ResultSet resultSet = statement.executeQuery();

            int stt = 1;
            while (resultSet.next()) {
                String maPX = resultSet.getString("MaPX");
                String maNCC = resultSet.getString("MaNCC");
                String ngayXuat = resultSet.getString("ThoiGianTao");
                String maDL = resultSet.getString("MaDL");
                int tongTien = resultSet.getInt("TongTien");
                tableModel.addRow(new Object[]{stt, maPX, maNCC, ngayXuat, maDL, tongTien});
                stt++;
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        table.setModel(tableModel);

    }
    
    
}
