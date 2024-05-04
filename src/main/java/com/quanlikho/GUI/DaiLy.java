package com.quanlikho.GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import java.util.regex.PatternSyntaxException;

import javax.swing.JFileChooser;
import javax.swing.AbstractButton;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import com.quanlikho.BUS.*;
import com.quanlikho.DTO.*;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DaiLy extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTable table;
	private DaiLiBUS dlBUS = new DaiLiBUS();
	private JTextField textFieldMaDaiLy;
	private JTextField textFieldTenDaiLy;
	private JTextField textFieldSoDienThoai;
	private JComboBox comboBoxTrangThai;
	private JTextField textFieldDiaChi;
	private JComboBox comboBox;

	/**
	 * Create the panel.
	 */
	public DaiLy() {
		if (dlBUS.getList() == null) {
			dlBUS.list();
		}
		initComponents();
		setcomboBoxTrangThai();
		initTable(dlBUS.getList());
	}

	public void initComponents() {
		setLayout(null);
		setBounds(0, 0, 1068, 693);
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
				NhapExcel();
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

		 comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Mã đại lý", "Tên đại lý"}));
		comboBox.setBounds(30, 45, 158, 41);
		panel.add(comboBox);

		textField = new JTextField();
		textField.setBounds(218, 45, 219, 41);
		panel.add(textField);
		textField.setColumns(10);

		textField.getDocument().addDocumentListener((DocumentListener) new DocumentListener() {
	            @Override
	            public void insertUpdate(DocumentEvent e) {
	            	timKiem();
	            }

	            @Override
	            public void removeUpdate(DocumentEvent e) {
	            	timKiem();
	            }

				@Override
				public void changedUpdate(DocumentEvent e) {
					// TODO Auto-generated method stub
					
				}
	        });
		
		JButton btnLamMoi = new JButton("Làm mới");
		btnLamMoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Reload();
			}
		});
		btnLamMoi.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		btnLamMoi.setIcon(new ImageIcon(TaiKhoan.class.getResource("/com/quanlikho/Item/reload_32.png")));
		btnLamMoi.setBounds(461, 43, 139, 43);
		panel.add(btnLamMoi);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 140, 1048, 409);
		add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] { {}, {}, {}, }, new String[] {}));
		scrollPane.setViewportView(table);

		textFieldMaDaiLy = new JTextField();
		textFieldMaDaiLy.setBounds(133, 582, 204, 28);
		add(textFieldMaDaiLy);
		textFieldMaDaiLy.setColumns(10);

		JLabel lblNewLabel = new JLabel("Mã đại lý");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 579, 113, 28);
		add(lblNewLabel);

		JLabel lblHVTn = new JLabel("Tên đại lý");
		lblHVTn.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblHVTn.setBounds(10, 633, 113, 28);
		add(lblHVTn);

		textFieldTenDaiLy = new JTextField();
		textFieldTenDaiLy.setColumns(10);
		textFieldTenDaiLy.setBounds(133, 636, 204, 28);
		add(textFieldTenDaiLy);

		JLabel lblVaiTr = new JLabel("Địa chỉ");
		lblVaiTr.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblVaiTr.setBounds(381, 633, 113, 28);
		add(lblVaiTr);

		JLabel lblEmail = new JLabel("Số điện thoại");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEmail.setBounds(381, 582, 113, 28);
		add(lblEmail);

		textFieldSoDienThoai = new JTextField();
		textFieldSoDienThoai.setColumns(10);
		textFieldSoDienThoai.setBounds(504, 582, 204, 28);
		add(textFieldSoDienThoai);

		JLabel lblTrngThi = new JLabel("Trạng thái");
		lblTrngThi.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTrngThi.setBounds(747, 582, 113, 28);
		add(lblTrngThi);

		comboBoxTrangThai = new JComboBox();
		comboBoxTrangThai.setBounds(870, 581, 188, 28);
		add(comboBoxTrangThai);

		textFieldDiaChi = new JTextField();
		textFieldDiaChi.setColumns(10);
		textFieldDiaChi.setBounds(504, 640, 204, 28);
		add(textFieldDiaChi);
	}

	public void initTable(ArrayList<DaiLiDTO> list) {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Mã Đại Lý");
		model.addColumn("Tên Đại Lý");
		model.addColumn("Số Điện Thoại");
		model.addColumn("Địa Chỉ");
		model.addColumn("Trạng thái");
		for (DaiLiDTO dl : list) {
			if (dl.getEnable() == 0) {
				model.addRow(new Object[] { dl.getMaDL() , dl.getTenDL() , dl.getSDT() , dl.getDiaChi(), "Tạm dừng" });

			}
			if (dl.getEnable() == 1) {
				model.addRow(new Object[] { dl.getMaDL() , dl.getTenDL() , dl.getSDT() , dl.getDiaChi(), "Hoạt động" });

			}
		}
		this.table.setModel(model);
		table.setAutoCreateRowSorter(true);

		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				int index = table.getSelectedRow();
				textFieldMaDaiLy.setText((String) table.getValueAt(index, 0));
				textFieldMaDaiLy.setEditable(false);
				textFieldMaDaiLy.setEnabled(false);
				textFieldTenDaiLy.setText(String.valueOf(table.getValueAt(index, 1)));
				textFieldSoDienThoai.setText(String.valueOf(table.getValueAt(index, 2)));
				textFieldDiaChi.setText(String.valueOf(table.getValueAt(index, 3)));
				String selectedTrangThai = String.valueOf(table.getValueAt(index, 4));
				comboBoxTrangThai.setSelectedItem(selectedTrangThai);
			}
		});

	}

	public void setcomboBoxTrangThai() {
		DefaultComboBoxModel model = new DefaultComboBoxModel();
		model.addElement("Hoạt động");
		model.addElement("Tạm dừng");
		comboBoxTrangThai.setModel(model);
	}

	private boolean KiemTraTrong() {
		if (textFieldMaDaiLy.getText() == null || textFieldMaDaiLy.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Mã đại lý không được trống!", "Thông báo", JOptionPane.DEFAULT_OPTION);
			textFieldMaDaiLy.requestFocus();
			return false;
		}
		if (textFieldTenDaiLy.getText() == null || textFieldTenDaiLy.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Tên đại lý không được trống!", "Thông báo",
					JOptionPane.DEFAULT_OPTION);
			textFieldTenDaiLy.requestFocus();
			return false;
		}

		if (textFieldSoDienThoai.getText() == null || textFieldSoDienThoai.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Số điện thoại không được trống!", "Thông báo",
					JOptionPane.DEFAULT_OPTION);
			textFieldSoDienThoai.requestFocus();
			return false;
		}
		if (textFieldDiaChi.getText() == null || textFieldDiaChi.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Địa chỉ không được trống!", "Thông báo", JOptionPane.DEFAULT_OPTION);
			textFieldDiaChi.requestFocus();
			return false;
		}
		return true;
	}

	public void Reload() {
		textFieldMaDaiLy.setText("");
		textFieldMaDaiLy.setEditable(true);
		textFieldMaDaiLy.setEnabled(true);
		textFieldTenDaiLy.setText("");
		textFieldSoDienThoai.setText("");
		comboBoxTrangThai.setSelectedIndex(0);
		textFieldDiaChi.setText("");
		textField.setText("");
		comboBox.setSelectedIndex(0);
		DaiLiBUS dlBUSreload = new DaiLiBUS();
		if (dlBUSreload.getList() == null) {
			dlBUSreload.list();
		}
		initTable(dlBUSreload.getList());
	}


	public void Sua() {
		String trangThai = (String) comboBoxTrangThai.getSelectedItem();
		if (KiemTraTrong()) {
			if (trangThai.equals("Hoạt động")) {
				DaiLiDTO dlDTO = new DaiLiDTO(textFieldMaDaiLy.getText() , textFieldTenDaiLy.getText() , textFieldSoDienThoai.getText() , textFieldDiaChi.getText(), 1  );
				dlBUS.update(dlDTO);
			} else {
				DaiLiDTO dlDTO = new DaiLiDTO(textFieldMaDaiLy.getText() , textFieldTenDaiLy.getText() , textFieldSoDienThoai.getText() , textFieldDiaChi.getText(), 0 );
				dlBUS.update(dlDTO);
			}
			JOptionPane.showMessageDialog(null, "Sửa thành công", "Thông báo", JOptionPane.DEFAULT_OPTION);
			Reload();
		}
	}

	private void Xoa() {
		if (KiemTraTrong()) {
			dlBUS.delete(textFieldMaDaiLy.getText());
			JOptionPane.showMessageDialog(null, "Xóa thành công", "Thông báo", JOptionPane.DEFAULT_OPTION);
			Reload();
		}
	}
	public void Them() {

		String trangThai = (String) comboBoxTrangThai.getSelectedItem();
		if (KiemTraTrong()) {
			if (!dlBUS.checkMaDL(textFieldMaDaiLy.getText())) {

				if (trangThai.equals("Hoạt động")) {
					DaiLiDTO dlDTO = new DaiLiDTO(textFieldMaDaiLy.getText() , textFieldTenDaiLy.getText() , textFieldSoDienThoai.getText() , textFieldDiaChi.getText(), 1  );
					dlBUS.add(dlDTO);
				} else {
					DaiLiDTO dlDTO = new DaiLiDTO(textFieldMaDaiLy.getText() , textFieldTenDaiLy.getText() , textFieldSoDienThoai.getText() , textFieldDiaChi.getText(), 0  );
					dlBUS.add(dlDTO);
				}
				JOptionPane.showMessageDialog(null, "Thêm thành công", "Thông báo", JOptionPane.DEFAULT_OPTION);
				Reload();
			} else {
				JOptionPane.showMessageDialog(null, "Tên đăng nhập bị trùng", "Thông báo", JOptionPane.DEFAULT_OPTION);
			}
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
	                    String maDaiLy = excelRow.getCell(0).getStringCellValue();
	                    String tenDaiLy = excelRow.getCell(1).getStringCellValue();
	                    String sdt =  excelRow.getCell(2).getStringCellValue();
	                    String diaChi = excelRow.getCell(3).getStringCellValue();
	                    String trangThai = excelRow.getCell(4).getStringCellValue();
	                    if (!dlBUS.checkMaDL(maDaiLy)) {
	                    	if (trangThai.equals("Hoạt động")) {
	                    		DaiLiDTO dlDTO = new DaiLiDTO(maDaiLy , tenDaiLy , sdt , diaChi, 1  );
	                    		dlBUS.add(dlDTO);
	                    	} else {
	                    		DaiLiDTO dlDTO = new DaiLiDTO(maDaiLy , tenDaiLy , sdt , diaChi, 0  );
	                    		dlBUS.add(dlDTO);
	                    	}
	                    	
	                    }else {
	                    	if (trangThai.equals("Hoạt động")) {
	                    		DaiLiDTO dlDTO = new DaiLiDTO(maDaiLy , tenDaiLy , sdt , diaChi, 1  );
	                    		dlBUS.update(dlDTO);
	                    	} else {
	                    		DaiLiDTO dlDTO = new DaiLiDTO(maDaiLy , tenDaiLy , sdt , diaChi, 0  );
	                    		dlBUS.update(dlDTO);
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
	  public void timKiem() {
		  	String text = textField.getText();
	        int columnIndex = comboBox.getSelectedIndex(); 
	       
	        TableRowSorter<? extends TableModel> sorter = (TableRowSorter<? extends TableModel>) table.getRowSorter();

	        if (sorter == null) {
	            sorter = new TableRowSorter<>(table.getModel());
	            table.setRowSorter(sorter);
	        }

	        if (text.trim().length() == 0) {
	            sorter.setRowFilter(null);
	        } else {
	            try {
	                sorter.setRowFilter(RowFilter.regexFilter("(?i)" + text, columnIndex));
	            } catch (PatternSyntaxException ex) {
	                ex.printStackTrace();
	            }
	        }
	  }
}