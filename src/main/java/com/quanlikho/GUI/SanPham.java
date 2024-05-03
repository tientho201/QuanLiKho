package com.quanlikho.GUI;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Desktop;

import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.quanlikho.BUS.LoaiBUS;
import com.quanlikho.BUS.NhaSanXuatBUS;
import com.quanlikho.BUS.SanPhamBUS;
import com.quanlikho.DTO.DaiLiDTO;
import com.quanlikho.DTO.LoaiDTO;
import com.quanlikho.DTO.NhaCungCapDTO;
import com.quanlikho.DTO.NhaSanXuatDTO;
import com.quanlikho.DTO.SanPhamDTO;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.AbstractButton;
import javax.swing.BoxLayout;
import java.awt.Rectangle;
import java.awt.Font;
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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class SanPham extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTable table;
	private JComboBox<String> comboBox;
	private JTextField textFieldMaSP;
	private JTextField textFieldTenSP;
	private JTextField textFieldSoLuong;
	private JTextField textFieldGia;
	private JTextArea textAreaGhiChu;
	private JComboBox<String> comboBoxMaLoai;
	private JComboBox<String> comboBoxMaNSX;
	private SanPhamBUS spBUS;
	private LoaiBUS loaiBUS;
	private NhaSanXuatBUS nsxBUS;
	private JComboBox<String> comboBoxTrangThai;

	public SanPham() {
		this.spBUS = new SanPhamBUS();
		this.loaiBUS = new LoaiBUS(); // Initialize loaiBUS properly
		this.nsxBUS = new NhaSanXuatBUS();
		initComponents();
		initTable(spBUS.getList());
		setcomboBoxTrangThai();
		addMouseListenerToTable();
	}

	public void initComponents() {
		setLayout(null);
		setBounds(0, 0, 1068, 693);
		// Panel chứa các nút chức năng và tìm kiếm
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1068, 70);
		add(panel);

		// Panel chứa các nút chức năng
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Chức năng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.X_AXIS));

		JButton btnThem = new JButton("Thêm",
				new ImageIcon(getClass().getResource("/com/quanlikho/Item/icons8_add_40px.png")));
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Them();
			}
		});
		panel_2.add(btnThem);

		JButton btnXoa = new JButton("Xoá",
				new ImageIcon(getClass().getResource("/com/quanlikho/Item/icons8_delete_40px.png")));
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Xoa();
			}
		});
		panel_2.add(btnXoa);

		JButton btnSua = new JButton("Sửa",
				new ImageIcon(getClass().getResource("/com/quanlikho/Item/icons8_edit_40px.png")));
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sua();
			}
		});
		panel_2.add(btnSua);

		JButton btnNhap = new JButton("Nhập Excel",
				new ImageIcon(getClass().getResource("/com/quanlikho/Item/icons8_xls_40px.png")));
		btnNhap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NhapExcel();
			}
		});
		panel_2.add(btnNhap);

		JButton btnXuat = new JButton("Xuất Excel",
				new ImageIcon(getClass().getResource("/com/quanlikho/Item/icons8_xls_40px.png")));
		btnXuat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				XuatExcel();
			}
		});
		btnXuat.setHorizontalAlignment(SwingConstants.LEADING);
		panel_2.add(btnXuat);

		// Panel chứa ô tìm kiếm
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Tìm kiếm", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setLayout(null);

		String[] options = { "Tất cả", "Mã sản phẩm", "Tên sản phẩm", "Số lượng", "Giá", "Mã loại", "Mã NSX",
				"Ghi chú" };
		comboBox = new JComboBox(options);
		comboBox.setBounds(22, 21, 112, 33);
		panel_1.add(comboBox);

		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selectedOption = comboBox.getSelectedItem().toString(); // Lấy giá trị được chọn từ comboBox
				String keyword = textField.getText().trim(); // Lấy từ khóa tìm kiếm từ textField
				if (!selectedOption.equals("Tất cả") && keyword.isEmpty()) {
					// Xóa dữ liệu trong bảng
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					model.setRowCount(0);
					return;
				}
				ArrayList<SanPhamDTO> searchResult = spBUS.search(selectedOption, keyword);

				// Cập nhật bảng hiển thị
				initTable(searchResult);
			}
		});

		textField = new JTextField();
		textField.setBounds(144, 21, 187, 33);
		panel_1.add(textField);
		textField.setColumns(10);
		// Trong phương thức initComponents():
		textField.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				searchAndUpdateTable();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				searchAndUpdateTable();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				searchAndUpdateTable();
			}
		});

		// Thêm phương thức searchAndUpdateTable():

		JButton btnReset = new JButton("Làm mới");
		btnReset.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnReset.setBounds(352, 20, 112, 33);
		btnReset.setIcon(new ImageIcon(SanPham.class.getResource("/com/quanlikho/Item/icons8_reset_25px_1.png")));
		panel_1.add(btnReset);
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Reload();
			}
		});

		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		panel.add(panel_2);
		panel.add(panel_1);

		// Bảng hiển thị dữ liệu
		table = new JTable(new DefaultTableModel(new Object[][] {},
				new String[] { "Mã sản phẩm", "Tên sản phẩm", "Số lượng", "Giá", "Mã loại", "Mã NSX", "Ghi chú" }));
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 70, 1068, 443);
		add(scrollPane);

		// Các ô nhập liệu
		textFieldMaSP = new JTextField();
		textFieldMaSP.setBounds(136, 525, 138, 32);
		add(textFieldMaSP);
		textFieldMaSP.setColumns(10);

		textFieldTenSP = new JTextField();
		textFieldTenSP.setColumns(10);
		textFieldTenSP.setBounds(136, 593, 138, 32);
		add(textFieldTenSP);

		JLabel lblNewLabel = new JLabel("Tên sản phẩm");
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 589, 130, 32);
		add(lblNewLabel);

		JLabel lblMSnPhm = new JLabel("Mã sản phẩm");
		lblMSnPhm.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblMSnPhm.setBounds(10, 523, 116, 28);
		add(lblMSnPhm);

		JLabel lblSLng = new JLabel("Số lượng");
		lblSLng.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblSLng.setBounds(10, 655, 109, 28);
		add(lblSLng);

		JLabel lblGi = new JLabel("Giá");
		lblGi.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblGi.setBounds(342, 523, 95, 32);
		add(lblGi);

		textFieldSoLuong = new JTextField();
		textFieldSoLuong.setColumns(10);
		textFieldSoLuong.setBounds(136, 651, 138, 32);
		add(textFieldSoLuong);

		textFieldGia = new JTextField();
		textFieldGia.setColumns(10);
		textFieldGia.setBounds(472, 523, 184, 34);
		add(textFieldGia);

		JLabel lblMLoi = new JLabel("Mã loại");
		lblMLoi.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblMLoi.setBounds(342, 591, 109, 28);
		add(lblMLoi);

		JLabel lblSLng_1_1 = new JLabel("Mã NSX");
		lblSLng_1_1.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblSLng_1_1.setBounds(342, 655, 95, 28);
		add(lblSLng_1_1);

		comboBoxMaLoai = new JComboBox<String>();
		comboBoxMaLoai.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBoxMaLoai.setBounds(472, 590, 184, 37);
		add(comboBoxMaLoai);

		comboBoxMaNSX = new JComboBox<String>();
		comboBoxMaNSX.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBoxMaNSX.setBounds(472, 648, 184, 37);
		add(comboBoxMaNSX);

		JLabel lblGhiCh = new JLabel("Ghi chú");
		lblGhiCh.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblGhiCh.setBounds(741, 587, 130, 37);
		add(lblGhiCh);

		textAreaGhiChu = new JTextArea();
		textAreaGhiChu.setBounds(564, 46, 85, 112);
		textAreaGhiChu.setLineWrap(true);
		textAreaGhiChu.setWrapStyleWord(true);
		JScrollPane scrollPane1 = new JScrollPane(textAreaGhiChu);
		scrollPane1.setBounds(869, 593, 168, 90);
		scrollPane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane1.setAutoscrolls(true);
		add(scrollPane1);

		JLabel lblSLng_1_1_1 = new JLabel("Trạng Thái");
		lblSLng_1_1_1.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblSLng_1_1_1.setBounds(741, 529, 95, 28);
		add(lblSLng_1_1_1);

		comboBoxTrangThai = new JComboBox<String>();
		comboBoxTrangThai.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBoxTrangThai.setModel(new DefaultComboBoxModel(new String[] { "Kinh doanh", "Ngừng kinh doanh" }));
		comboBoxTrangThai.setBounds(869, 526, 168, 37);
		add(comboBoxTrangThai);

		// Thêm dữ liệu vào ComboBox Mã loại
		List<LoaiDTO> loaiObjects = loaiBUS.getList();
		for (LoaiDTO loai : loaiObjects) {
			comboBoxMaLoai.addItem(loai.getMaLoai());
		}

		// Thêm dữ liệu vào ComboBox Mã NSX
		List<NhaSanXuatDTO> nsxObjects = nsxBUS.getList();
		for (NhaSanXuatDTO nsx : nsxObjects) {
			comboBoxMaNSX.addItem(nsx.getMaNSX());
		}
	}

	private boolean KiemTraTrong() {
		if (textFieldMaSP.getText().isEmpty()) {
			textFieldMaSP.requestFocus();
			return false;
		} else if (textFieldTenSP.getText().isEmpty()) {
			textFieldTenSP.requestFocus();
			return false;
		} else if (textFieldSoLuong.getText().isEmpty()) {
			textFieldSoLuong.requestFocus();
			return false;
		} else if (textFieldGia.getText().isEmpty()) {
			textFieldGia.requestFocus();
			return false;
		} else if (comboBoxMaLoai.getSelectedIndex() == -1) {
			JOptionPane.showMessageDialog(null, "Vui lòng chọn Mã loại", "Thông báo", JOptionPane.WARNING_MESSAGE);
			return false;
		} else if (comboBoxMaNSX.getSelectedIndex() == -1) {
			JOptionPane.showMessageDialog(null, "Vui lòng chọn Mã NSX", "Thông báo", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		return true;
	}

	public void Reload() {
		textFieldMaSP.setText("");
		textFieldMaSP.setEditable(true);
		textFieldMaSP.setEnabled(true);
		textFieldTenSP.setText("");
		textFieldSoLuong.setText("");
		comboBoxMaLoai.setSelectedIndex(-1); // Reset giá trị của ComboBoxMaLoai
		comboBoxMaNSX.setSelectedIndex(-1); // Reset giá trị của ComboBoxMaNSX
		textFieldGia.setText("");
		textAreaGhiChu.setText("");

		textFieldMaSP.requestFocus();

		ArrayList<SanPhamDTO> listsp = spBUS.list();
		initTable(listsp);
	}

	public void initTable(ArrayList<SanPhamDTO> listsp) {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Mã sản phẩm");
		model.addColumn("Tên sản phẩm");
		model.addColumn("Số lượng");
		model.addColumn("Giá");
		model.addColumn("Mã loại");
		model.addColumn("Mã NSX");
		model.addColumn("Ghi chú");
		model.addColumn("Trạng thái");
		for (SanPhamDTO sp : listsp) {
			if (sp.getEnable() == 1) {
				model.addRow(new Object[] { sp.getMaSP(), sp.getTenSP(), sp.getSoLuong(), sp.getGia(), sp.getMaLoai(),
						sp.getMaNSX(), sp.getGhiChu(), "Kinh doanh" });
			} else {
				model.addRow(new Object[] { sp.getMaSP(), sp.getTenSP(), sp.getSoLuong(), sp.getGia(), sp.getMaLoai(),
						sp.getMaNSX(), sp.getGhiChu(), "Ngừng kinh doanh" });
			}
		}

		table.setModel(model);
		table.setAutoCreateRowSorter(true);
	}

	public void Them() {
		if (KiemTraTrong()) {
			if (!spBUS.checkMaSP(textFieldMaSP.getText())) {
				String masp = textFieldMaSP.getText();
				String tensp = textFieldTenSP.getText();
				int soLuong = Integer.parseInt(textFieldSoLuong.getText());
				int gia = Integer.parseInt(textFieldGia.getText());
				String maLoai = comboBoxMaLoai.getSelectedItem().toString();
				String maNSX = comboBoxMaNSX.getSelectedItem().toString();
				String ghiChusp = textAreaGhiChu.getText();
				String trangthai = comboBoxTrangThai.getSelectedItem().toString();
				if (trangthai.equals("Kinh doanh")) {
					SanPhamDTO sp = new SanPhamDTO(masp, tensp, soLuong, gia, maLoai, maNSX, ghiChusp, 1);
					spBUS.add(sp);

				} else {
					SanPhamDTO sp = new SanPhamDTO(masp, tensp, soLuong, gia, maLoai, maNSX, ghiChusp, 0);
					spBUS.add(sp);
				}
				JOptionPane.showMessageDialog(null, "Thêm thành công", "Thông báo", JOptionPane.DEFAULT_OPTION);
				Reload();
			} else {
				JOptionPane.showMessageDialog(null, "Mã sản phẩm bị trùng", "Thông báo", JOptionPane.DEFAULT_OPTION);
			}
		}
	}

	public void Sua() {
		if (KiemTraTrong()) {
			String masp = textFieldMaSP.getText();
			String tensp = textFieldTenSP.getText();
			int soLuong = Integer.parseInt(textFieldSoLuong.getText());
			int gia = Integer.parseInt(textFieldGia.getText());
			String maLoai = comboBoxMaLoai.getSelectedItem().toString();
			String maNSX = comboBoxMaNSX.getSelectedItem().toString();
			String ghiChusp = textAreaGhiChu.getText();

			String trangthai = comboBoxTrangThai.getSelectedItem().toString();
			if (trangthai.equals("Kinh doanh")) {
				SanPhamDTO sp = new SanPhamDTO(masp, tensp, soLuong, gia, maLoai, maNSX, ghiChusp, 1);
				spBUS.update(sp);

			} else {
				SanPhamDTO sp = new SanPhamDTO(masp, tensp, soLuong, gia, maLoai, maNSX, ghiChusp, 0);
				spBUS.update(sp);
			}

			JOptionPane.showMessageDialog(null, "Sửa thành công", "Thông báo", JOptionPane.DEFAULT_OPTION);
			Reload();
		}
	}

	private void Xoa() {
		if (textFieldMaSP.getText() != null && !textFieldMaSP.getText().isEmpty()) {
			if (spBUS.checkDataIsReferenced(textFieldMaSP.getText())) {
				JOptionPane.showMessageDialog(null,
						"Không thể xoá sản phẩm này vì có dữ liệu liên quan trong bảng khác.", "Thông báo",
						JOptionPane.WARNING_MESSAGE);
			} else {
				spBUS.delete(textFieldMaSP.getText());
				JOptionPane.showMessageDialog(null, "Xóa thành công", "Thông báo", JOptionPane.DEFAULT_OPTION);
				Reload();
			}
		} else {
			JOptionPane.showMessageDialog(null, "Vui lòng chọn một sản phẩm để xóa", "Thông báo",
					JOptionPane.DEFAULT_OPTION);
		}
	}

	public void addMouseListenerToTable() {
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				int index = table.getSelectedRow();
				if (index >= 0) {
					textFieldMaSP.setText((String) table.getValueAt(index, 0));
					textFieldTenSP.setText((String) table.getValueAt(index, 1));

					// Chuyển đổi kiểu dữ liệu String thành số và gán vào textFieldSoLuong
					textFieldSoLuong.setText(String.valueOf(table.getValueAt(index, 2)));

					// Chuyển đổi kiểu dữ liệu String thành số và gán vào textFieldGia
					textFieldGia.setText(String.valueOf(table.getValueAt(index, 3)));

					textAreaGhiChu.setText((String) table.getValueAt(index, 6));

					String maloai = (String) table.getValueAt(index, 4);
					String maNSX = (String) table.getValueAt(index, 5);
					String trangthai = (String) table.getValueAt(index, 7);

					// Chọn mục tương ứng trong combobox
					comboBoxMaLoai.setSelectedItem(maloai);
					comboBoxMaNSX.setSelectedItem(maNSX);
					comboBoxTrangThai.setSelectedItem(trangthai);

					textFieldMaSP.setEditable(false);
					textFieldMaSP.setEnabled(false);
				}
			}
		});
	}

	public void setcomboBoxTrangThai() {
		DefaultComboBoxModel model = new DefaultComboBoxModel();
		model.addElement("Kinh doanh");
		model.addElement("Ngừng kinh doanh");
		comboBoxTrangThai.setModel(model);
	}

	private void searchAndUpdateTable() {
		String selectedOption = comboBox.getSelectedItem().toString();
		String keyword = textField.getText().trim();

		// Kiểm tra nếu chọn mục khác "Tất cả" và không có từ khóa tìm kiếm thì không
		// hiển thị bảng
		if (!selectedOption.equals("Tất cả") && keyword.isEmpty()) {
			// Không cần thực hiện tìm kiếm, chỉ cần xóa dữ liệu trong bảng
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			model.setRowCount(0);
			return;
		}

		// Thực hiện tìm kiếm
		ArrayList<SanPhamDTO> searchResult = spBUS.search(selectedOption, keyword);

		// Cập nhật bảng hiển thị
		initTable(searchResult);
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
		// Import excel

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
					String maSP = excelRow.getCell(0).getStringCellValue();
					String tenSP = excelRow.getCell(1).getStringCellValue();
					int SoLuong = Integer.valueOf(excelRow.getCell(2).getStringCellValue());
					int Gia = Integer.valueOf(excelRow.getCell(3).getStringCellValue());
					String MaLoai = excelRow.getCell(4).getStringCellValue();
					String MaNSX = excelRow.getCell(5).getStringCellValue();
					String GhiChu = excelRow.getCell(6).getStringCellValue();
					String trangThai = excelRow.getCell(7).getStringCellValue();

					if (loaiBUS.checkMaLoai(MaLoai)) {
						JOptionPane.showMessageDialog(null, "Mã Loại không tồn tại!", "Thông báo",
								JOptionPane.DEFAULT_OPTION);
						return;
					} else {
						if (nsxBUS.checkMaNSX(MaNSX)) {
							JOptionPane.showMessageDialog(null, "Nhà Sản Xuất không tồn tại!", "Thông báo",
									JOptionPane.DEFAULT_OPTION);
							return;
						} else {
							if (!spBUS.checkMaSP(maSP)) {
								if (trangThai.equals("Kinh doanh")) {
									SanPhamDTO spDTO = new SanPhamDTO(maSP, tenSP, SoLuong, Gia, MaLoai, MaNSX, GhiChu,
											1);
									spBUS.add(spDTO);
								} else {
									SanPhamDTO spDTO = new SanPhamDTO(maSP, tenSP, SoLuong, Gia, MaLoai, MaNSX, GhiChu,
											0);
									spBUS.add(spDTO);
								}

							} else {
								if (trangThai.equals("Kinh doanh")) {
									SanPhamDTO spDTO = new SanPhamDTO(maSP, tenSP, SoLuong, Gia, MaLoai, MaNSX, GhiChu,
											1);
									spBUS.update(spDTO);
								} else {
									SanPhamDTO spDTO = new SanPhamDTO(maSP, tenSP, SoLuong, Gia, MaLoai, MaNSX, GhiChu,
											0);
									spBUS.update(spDTO);
								}
							}
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
