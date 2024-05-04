package com.quanlikho.GUI;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.Component;
import java.awt.Desktop;

import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.quanlikho.BUS.*;
import com.quanlikho.DTO.*;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TaiKhoan extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTable table;
	private AccountBUS accBUS = new AccountBUS();
	private JTextField textFieldTenDangNhap;
	private JTextField textFieldHovaTen;
	private JTextField textFieldEmail;
	private JComboBox comboBoxTrangThai;
	private JComboBox comboBoxVaiTro;
	private JPasswordField passwordField;

	/**
	 * Create the panel.
	 */
	public TaiKhoan() {
		if (accBUS.getList() == null) {
			accBUS.list();
		}
		initComponents();
		setcomboBoxVaiTro(accBUS.getList());
		setcomboBoxTrangThai(accBUS.getList());
		initTable(accBUS.getList());
	}

	public void initComponents() {
		setLayout(null);
		setBounds(0,0, 1068, 693);
		JToolBar toolBar = new JToolBar();
		toolBar.setBorder(
				new TitledBorder(null, "Ch\u1EE9c n\u0103ng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		toolBar.setBounds(10, 10, 415, 120);
		toolBar.setRollover(true);
		toolBar.setFloatable(false);
		add(toolBar);

		JButton btnThem = new JButton("Thêm");
		btnThem.setIcon(new ImageIcon(TaiKhoan.class.getResource("/com/quanlikho/Item/add-user_32.png")));
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Them();
			}
		});
		btnThem.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		btnThem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btnThem.setFocusable(false);
		btnThem.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		btnThem.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
		toolBar.add(btnThem);

		JButton btnXoa = new JButton("Xóa");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Xoa();
			}
		});
		btnXoa.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnXoa.setIcon(new ImageIcon(TaiKhoan.class.getResource("/com/quanlikho/Item/remove-user_32.png")));
		btnXoa.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnXoa.setHorizontalTextPosition(SwingConstants.CENTER);
		btnXoa.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		btnXoa.setFocusable(false);
		toolBar.add(btnXoa);

		JButton btnSua = new JButton("Sửa");
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sua();
			}
		});
		btnSua.setIcon(new ImageIcon(TaiKhoan.class.getResource("/com/quanlikho/Item/user-avatar_32.png")));
		btnSua.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnSua.setHorizontalTextPosition(SwingConstants.CENTER);
		btnSua.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		btnSua.setFocusable(false);
		toolBar.add(btnSua);

		JButton btnDatlai = new JButton("Đặt lại");
		btnDatlai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Reload();
			}
		});
		btnDatlai.setIcon(new ImageIcon(TaiKhoan.class.getResource("/com/quanlikho/Item/refresh_32.png")));
		btnDatlai.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnDatlai.setHorizontalTextPosition(SwingConstants.CENTER);
		btnDatlai.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		btnDatlai.setFocusable(false);
		toolBar.add(btnDatlai);
		toolBar.addSeparator();

		JButton btnNhapExcel = new JButton("Nhập Excel");
		btnNhapExcel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNhapExcel.setIcon(new ImageIcon(TaiKhoan.class.getResource("/com/quanlikho/Item/logo_excel_32.png")));
		btnNhapExcel.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnNhapExcel.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNhapExcel.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		btnNhapExcel.setFocusable(false);
		toolBar.add(btnNhapExcel);

		JButton btnXuatExcel = new JButton("Xuất Excel");
		btnXuatExcel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				XuatExcel();
			}
		});
		btnXuatExcel.setIcon(new ImageIcon(TaiKhoan.class.getResource("/com/quanlikho/Item/sheets_32.png")));
		btnXuatExcel.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnXuatExcel.setHorizontalTextPosition(SwingConstants.CENTER);
		btnXuatExcel.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		btnXuatExcel.setFocusable(false);
		toolBar.add(btnXuatExcel);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "T\u00ECm ki\u1EBFm", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		panel.setBounds(435, 10, 623, 120);
		add(panel);
		panel.setLayout(null);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(30, 45, 158, 41);
		panel.add(comboBox);

		textField = new JTextField();
		textField.setBounds(218, 45, 219, 41);
		panel.add(textField);
		textField.setColumns(10);

		JButton btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		btnLamMoi.setIcon(new ImageIcon(TaiKhoan.class.getResource("/com/quanlikho/Item/reload_32.png")));
		btnLamMoi.setBounds(461, 43, 139, 43);
		panel.add(btnLamMoi);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 150, 1048, 409);
		add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null }, { null, null, null, null, null },
						{ null, null, null, null, null }, },
				new String[] { "T\u00EAn \u0111\u0103ng nh\u1EADp", "H\u1ECD v\u00E0 t\u00EAn", "Email", "Vai tr\u00F2",
						"Tr\u1EA1ng th\u00E1i" }));
		scrollPane.setViewportView(table);

		textFieldTenDangNhap = new JTextField();
		textFieldTenDangNhap.setBounds(133, 582, 204, 28);
		add(textFieldTenDangNhap);
		textFieldTenDangNhap.setColumns(10);

		JLabel lblNewLabel = new JLabel("Tên đăng nhập");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 579, 113, 28);
		add(lblNewLabel);

		JLabel lblHVTn = new JLabel("Họ và tên");
		lblHVTn.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblHVTn.setBounds(10, 633, 113, 28);
		add(lblHVTn);

		textFieldHovaTen = new JTextField();
		textFieldHovaTen.setColumns(10);
		textFieldHovaTen.setBounds(133, 636, 204, 28);
		add(textFieldHovaTen);

		JLabel lblVaiTr = new JLabel("Vai trò");
		lblVaiTr.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblVaiTr.setBounds(381, 633, 113, 28);
		add(lblVaiTr);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEmail.setBounds(381, 582, 113, 28);
		add(lblEmail);

		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(504, 582, 204, 28);
		add(textFieldEmail);

		comboBoxVaiTro = new JComboBox();
		comboBoxVaiTro.setBounds(504, 635, 204, 28);
		add(comboBoxVaiTro);

		JLabel lblTrngThi = new JLabel("Trạng thái");
		lblTrngThi.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTrngThi.setBounds(747, 633, 113, 28);
		add(lblTrngThi);

		comboBoxTrangThai = new JComboBox();
		comboBoxTrangThai.setBounds(870, 635, 188, 28);
		add(comboBoxTrangThai);

		JLabel lblMatkhau = new JLabel("Mật khẩu");
		lblMatkhau.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMatkhau.setBounds(747, 579, 113, 28);
		add(lblMatkhau);

		passwordField = new JPasswordField();
		passwordField.setBounds(870, 582, 188, 28);
		add(passwordField);
	}

	public void initTable(ArrayList<AccountDTO> acclist) {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Tên đăng nhập");
		model.addColumn("Họ và tên");
		model.addColumn("Email");
		model.addColumn("Mật khẩu");
		model.addColumn("Vai trò");
		model.addColumn("Trạng thái");
		for (AccountDTO acc : acclist) {
			if (acc.getEnable() == 0) {
				model.addRow(new Object[] { acc.getTenDangNhap(), acc.getHovaTen(), acc.getEmail(), acc.getPassword(),
						acc.getRole(), "Tạm dừng" });

			}
			if (acc.getEnable() == 1) {
				model.addRow(new Object[] { acc.getTenDangNhap(), acc.getHovaTen(), acc.getEmail(), acc.getPassword(),
						acc.getRole(), "Hoạt động" });

			}
		}
		this.table.setModel(model);
		table.setAutoCreateRowSorter(true);
		table.getColumnModel().getColumn(3).setCellRenderer(new PasswordRenderer());
		 table.getColumnModel().getColumn(3).setCellEditor(new PasswordEditor(new JPasswordField()));
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				int index = table.getSelectedRow();
				textFieldTenDangNhap.setText((String) table.getValueAt(index, 0));
				textFieldTenDangNhap.setEditable(false);
				textFieldTenDangNhap.setEnabled(false);
				textFieldHovaTen.setText(String.valueOf(table.getValueAt(index, 1)));
				textFieldEmail.setText(String.valueOf(table.getValueAt(index, 2)));
				passwordField.setText(String.valueOf(table.getValueAt(index, 3)));
				String selectedVaiTro = String.valueOf(table.getValueAt(index, 4));
				comboBoxVaiTro.setSelectedItem(selectedVaiTro);
				String selectedTrangThai = String.valueOf(table.getValueAt(index, 5));
				comboBoxTrangThai.setSelectedItem(selectedTrangThai);
			}
		});

	}

	public void setcomboBoxVaiTro(ArrayList<AccountDTO> acclist) {
		DefaultComboBoxModel model = new DefaultComboBoxModel();
		model.addElement("Admin");
		model.addElement("QuanLyKho");
		model.addElement("NhapHang");
		model.addElement("XuatHang");
		comboBoxVaiTro.setModel(model);
	}

	public void setcomboBoxTrangThai(ArrayList<AccountDTO> acclist) {
		DefaultComboBoxModel model = new DefaultComboBoxModel();
		model.addElement("Hoạt động");
		model.addElement("Tạm dừng");

		comboBoxTrangThai.setModel(model);
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
		
		if (passwordField.getText() == null || passwordField.getText().equals("")) {
			
			JOptionPane.showMessageDialog(null, "Mật khẩu không được trống!", "Thông báo", JOptionPane.WARNING_MESSAGE);
			passwordField.requestFocus();
			return false;
		}
		return true;
	}

	public void Reload() {
		textFieldTenDangNhap.setText("");
		textFieldTenDangNhap.setEditable(true);
		textFieldTenDangNhap.setEnabled(true);
		textFieldHovaTen.setText("");
		textFieldEmail.setText("");
		comboBoxTrangThai.setSelectedIndex(0);
		comboBoxVaiTro.setSelectedIndex(0);
		
		passwordField.setText("");
		AccountBUS accBUSreload = new AccountBUS();
		if (accBUSreload.getList() == null) {
			accBUSreload.list();
		}
		setcomboBoxVaiTro(accBUSreload.getList());
		setcomboBoxTrangThai(accBUSreload.getList());
		initTable(accBUSreload.getList());
	}

	public void Them() {
		String vaiTro = (String) comboBoxVaiTro.getSelectedItem();
		String trangThai = (String) comboBoxTrangThai.getSelectedItem();
		if (KiemTraTrong()) {
			if (!accBUS.checkTenDangNhap(textFieldTenDangNhap.getText())) {

				if (trangThai.equals("Hoạt động")) {
					AccountDTO accountDTO = new AccountDTO(textFieldTenDangNhap.getText(), textFieldHovaTen.getText(),
							textFieldEmail.getText(), passwordField.getText(), vaiTro, 1);
					accBUS.addAcc(accountDTO);
				} else {
					AccountDTO accountDTO = new AccountDTO(textFieldTenDangNhap.getText(), textFieldHovaTen.getText(),
							textFieldEmail.getText(), passwordField.getText(), vaiTro, 0);
					accBUS.addAcc(accountDTO);
				}
				JOptionPane.showMessageDialog(null, "Thêm thành công", "Thông báo", JOptionPane.DEFAULT_OPTION);
				Reload();
			} else {
				JOptionPane.showMessageDialog(null, "Tên đăng nhập bị trùng", "Thông báo", JOptionPane.DEFAULT_OPTION);
			}
		}
	}

	public void Sua() {
		String vaiTro = (String) comboBoxVaiTro.getSelectedItem();
		String trangThai = (String) comboBoxTrangThai.getSelectedItem();
		if (KiemTraTrong()) {
			if (trangThai.equals("Hoạt động")) {
				AccountDTO accountDTO = new AccountDTO(textFieldTenDangNhap.getText(), textFieldHovaTen.getText(),
						textFieldEmail.getText(), passwordField.getText(), vaiTro, 1);
				accBUS.updateAcc(accountDTO);
			} else {
				AccountDTO accountDTO = new AccountDTO(textFieldTenDangNhap.getText(), textFieldHovaTen.getText(),
						textFieldEmail.getText(), passwordField.getText(), vaiTro, 0);
				accBUS.updateAcc(accountDTO);
			}
			JOptionPane.showMessageDialog(null, "Sửa thành công", "Thông báo", JOptionPane.DEFAULT_OPTION);
			Reload();
		}
	}

	private void Xoa() {
		if (KiemTraTrong()) {
			accBUS.delete(textFieldTenDangNhap.getText());
			JOptionPane.showMessageDialog(null, "Xóa thành công", "Thông báo", JOptionPane.DEFAULT_OPTION);
			Reload();
		}
	}
	// TableCellRenderer để hiển thị mật khẩu dưới dạng dấu "*"
	static class PasswordRenderer extends DefaultTableCellRenderer {
		@Override
		protected void setValue(Object value) {
			if (value instanceof String) {
				String password = (String) value;
				// Chuyển đổi mật khẩu thành chuỗi "*" có cùng độ dài
				StringBuilder maskedPassword = new StringBuilder();
				for (int i = 0; i < password.length(); i++) {
					maskedPassword.append("*");
				}
				value = maskedPassword.toString();
			}
			super.setValue(value);
		}
	}
	// TableCellEditor để hiển thị và chỉnh sửa mật khẩu
	static class PasswordEditor extends DefaultCellEditor {
	    public PasswordEditor(JPasswordField passwordField) {
	        super(passwordField);
	    }

	    @Override
	    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
	        if (value instanceof String) {
	            ((JPasswordField)editorComponent).setText((String)value);
	        }
	        return super.getTableCellEditorComponent(table, value, isSelected, row, column);
	    }

	    @Override
	    public Object getCellEditorValue() {
	        return new String(((JPasswordField) editorComponent).getPassword());
	    }
	}
	private void XuatExcel() {                                            
        // TODO add your handling code here:
        try {
            JFileChooser jFileChooser = new JFileChooser();
            jFileChooser.showSaveDialog(this);
            File saveFile = jFileChooser.getSelectedFile();
            if (saveFile != null) {
                saveFile = new File(saveFile.toString() + ".xlsx");
                Workbook wb = new XSSFWorkbook();
                Sheet sheet = wb.createSheet("Đại Lý");

                Row rowCol = sheet.createRow(0);
                for (int i = 0; i < table.getColumnCount(); i++) {
                    Cell cell = rowCol.createCell(i);
                    cell.setCellValue(table.getColumnName(i));
                }

                for (int j = 0; j < table.getRowCount(); j++) {
                    Row row = sheet.createRow(j + 1);
                    for (int k = 0; k < table.getColumnCount(); k++) {
                        Cell cell = row.createCell(k);
                        if (table.getValueAt(j, k) != null) {
                            cell.setCellValue(table.getValueAt(j, k).toString());
                        }

                    }
                }
                FileOutputStream out = new FileOutputStream(new File(saveFile.toString()));
                wb.write(out);
                wb.close();
                out.close();
                openFile(saveFile.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }   
	  private void NhapExcel() {                                            
	        // TODO add your handling code here:
	        //Import excel

	        File excelFile;
	        FileInputStream excelFIS = null;
	        BufferedInputStream excelBIS = null;
	        XSSFWorkbook excelJTableImport = null;
	        JFileChooser jf = new JFileChooser();
	        int result = jf.showOpenDialog(null);
	        jf.setDialogTitle("Open file");
	        Workbook workbook = null;
	        if (result == JFileChooser.APPROVE_OPTION) {
	            try {
	                excelFile = jf.getSelectedFile();
	                excelFIS = new FileInputStream(excelFile);
	                excelBIS = new BufferedInputStream(excelFIS);
	                excelJTableImport = new XSSFWorkbook(excelBIS);
	                XSSFSheet excelSheet = excelJTableImport.getSheetAt(0);
	                for (int row = 1; row <= excelSheet.getLastRowNum(); row++) {
	                    XSSFRow excelRow = excelSheet.getRow(row);
	                    String TenDangNhap = excelRow.getCell(0).getStringCellValue();
	                    String hovaten = excelRow.getCell(1).getStringCellValue();
	                    String email = excelRow.getCell(2).getStringCellValue();
	                    String Password = excelRow.getCell(3).getStringCellValue();
	                    String role = excelRow.getCell(4).getStringCellValue();
	                    String trangThai = excelRow.getCell(5).getStringCellValue();
	                    if (!accBUS.checkTenDangNhap(TenDangNhap)) {
	                    	if (trangThai.equals("Hoạt động")) {
	                    		AccountDTO accDTO  = new AccountDTO(TenDangNhap ,hovaten , email , Password , role , 1  );
	                    		accBUS.addAcc(accDTO);
	                    	} else {
	                    		AccountDTO accDTO  = new AccountDTO(TenDangNhap ,hovaten , email , Password , role , 0  );
	                    		accBUS.addAcc(accDTO);
	                    	}
	                    	
	                    }else {
	                    	if (trangThai.equals("Hoạt động")) {
	                    		AccountDTO accDTO  = new AccountDTO(TenDangNhap ,hovaten , email , Password , role , 1  );
	                    		accBUS.updateAcc(accDTO);
	                    	} else {
	                    		AccountDTO accDTO  = new AccountDTO(TenDangNhap ,hovaten , email , Password , role , 0  );
	                    		accBUS.updateAcc(accDTO);
	                    	}
	                    }
	            
	                    DefaultTableModel table_acc = (DefaultTableModel) table.getModel();
	                    table_acc.setRowCount(0);
	                    Reload();
	                	
	                }
	                JOptionPane.showMessageDialog(null, "Nhập Excel thành công!", "Thông báo", JOptionPane.DEFAULT_OPTION);
	            } catch (FileNotFoundException ex) {
	                Logger.getLogger(DaiLy.class.getName()).log(Level.SEVERE, null, ex);
	            } catch (IOException ex) {
	                Logger.getLogger(DaiLy.class.getName()).log(Level.SEVERE, null, ex);
	            }
	        }
	  }
	  private void openFile(String file) {
	        try {
	            File path = new File(file);
	            Desktop.getDesktop().open(path);
	        } catch (IOException e) {
	            System.out.println(e);
	        }
	    }
}
