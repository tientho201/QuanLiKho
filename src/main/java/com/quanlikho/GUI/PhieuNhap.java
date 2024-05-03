package com.quanlikho.GUI;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.BorderLayout;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.BoxLayout;
import javax.swing.table.DefaultTableModel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.w3c.dom.events.MouseEvent;

import com.quanlikho.Connect.*;
import com.quanlikho.BUS.*;
import com.quanlikho.DTO.*;

import javax.swing.JScrollPane;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.Statement;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JFormattedTextField;
import java.awt.Font;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;

public class PhieuNhap extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JComboBox comboBox;
	private DefaultTableModel tableModel;
	private JTable table;
	private JButton btnXemChiTiet;
	private ChiTietPhieuNhap chiTietPhieuNhapDialog;
	private JFormattedTextField fromDateField;
	private JFormattedTextField toDateField;
	private JFormattedTextField minPriceField;
	private JFormattedTextField maxPriceField;

	private PhieuNhapHangBUS pnhBUS = new PhieuNhapHangBUS();
	private ChiTietPhieuNhapBUS ChitietPnBUS = new ChiTietPhieuNhapBUS();

	public PhieuNhap() {
		initComponetns();
		if (pnhBUS.getList() == null) {
			pnhBUS.list();
		}
		if (ChitietPnBUS.getList() == null) {
			ChitietPnBUS.list();
			;
		}
		initTableNhapHang(pnhBUS.getList(), ChitietPnBUS.getList());
	}

	public void initComponetns() {
		setBounds(0, 0, 1068, 693);
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setBounds(new Rectangle(0, 0, 1180, 70));
		add(panel, BorderLayout.NORTH);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(
				new TitledBorder(null, "Ch\u1EE9c n\u0103ng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.X_AXIS));

		JButton btnXoa = new JButton("Xoá",
				new ImageIcon(getClass().getResource("/com/quanlikho/Item/icons8_delete_40px.png")));
		panel_2.add(btnXoa);
		btnXoa.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int hangDuocChon = table.getSelectedRow();
				if (hangDuocChon >= 0) {
					String maPN = (String) table.getValueAt(hangDuocChon, 0);
					int luachon = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn xóa phiếu nhập", "Xác nhận",
							JOptionPane.YES_NO_OPTION);
					if (luachon == JOptionPane.YES_OPTION) {
						// XoaChiTietPhieuNhap(maPN);
						pnhBUS.delete(maPN);
						JOptionPane.showConfirmDialog(null, " Đã xóa phiếu nhập thành công", "Thông báo",
								JOptionPane.WARNING_MESSAGE);
						reloadTable();
					}
				} else {
					JOptionPane.showMessageDialog(null, "Vui lòng chon một hàng để xóa", "Thông báp",
							JOptionPane.WARNING_MESSAGE);
				}
			}
		});

		JButton btnSua = new JButton("Sửa",
				new ImageIcon(getClass().getResource("/com/quanlikho/Item/icons8_edit_40px.png")));
		panel_2.add(btnSua);
		btnSua.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int hangDuocChon = table.getSelectedRow();
				if (hangDuocChon >= 0) {
					String maPN = (String) table.getValueAt(hangDuocChon, 0);
					String maNCC = (String) table.getValueAt(hangDuocChon, 1);
					String ngayTao = (String) table.getValueAt(hangDuocChon, 2);
					String nguoiNhap = (String) table.getValueAt(hangDuocChon, 3);
					String tongTien = String.valueOf(table.getValueAt(hangDuocChon, 4));
					PhieuNhap phieuNhap = new PhieuNhap();
					PhieuSua ps = new PhieuSua(maPN, maNCC, ngayTao, nguoiNhap, tongTien, phieuNhap);
					ps.setVisible(true);
				}
			}
		});

		JButton btnThem = new JButton("Xem chi tiết",
				new ImageIcon(PhieuNhap.class.getResource("/com/quanlikho/Item/icons8_eye_40px.png")));
		panel_2.add(btnThem);
		btnThem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int hangDuocChon = table.getSelectedRow();
				if (hangDuocChon >= 0) {
					String maPN = (String) table.getValueAt(hangDuocChon, 0);
					String maNCC = (String) table.getValueAt(hangDuocChon, 1);
					String ngayTao = (String) table.getValueAt(hangDuocChon, 2);
					String nguoiNhap = (String) table.getValueAt(hangDuocChon, 3);
					String tongTien = String.valueOf(table.getValueAt(hangDuocChon, 4));
					ChiTietPhieuNhap ctpn = new ChiTietPhieuNhap(maPN);
					ctpn.layTuBang(maPN, maNCC, nguoiNhap, ngayTao, tongTien);
					ctpn.setVisible(true);
				}
			}
		});

		// JButton btnNhap = new JButton("Nhập Excel", new
		// ImageIcon(getClass().getResource("/Item/icons8_xls_40px.png")));
		// panel_2.add(btnNhap);

		JButton btnXuat = new JButton("Xuất Excel",
				new ImageIcon(getClass().getResource("/com/quanlikho/Item/icons8_xls_40px.png")));
		btnXuat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				XuatExcel();
			}
		});
		btnXuat.setHorizontalAlignment(SwingConstants.LEADING);
		panel_2.add(btnXuat);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(
				new TitledBorder(null, "T\u00ECm ki\u1EBFm", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setLayout(null);

		comboBox = new JComboBox();
		comboBox.setBounds(10, 26, 103, 28);
		panel_1.add(comboBox);
		String[] items = { "Tìm kiếm", "Mã phiếu nhập", "Mã nhà cung cấp", "Ngày nhập" };

		// Thêm mục vào comboBox
		for (String item : items) {
			comboBox.addItem(item);
		}

		textField = new JTextField();
		textField.setBounds(123, 27, 188, 28);
		panel_1.add(textField);
		textField.setColumns(10);

		JButton btnReset = new JButton("Làm mới");
		btnReset.setBounds(453, 27, 113, 33);
		btnReset.setIcon(new ImageIcon(PhieuNhap.class.getResource("/com/quanlikho/Item/icons8_reset_25px_1.png")));
		panel_1.add(btnReset);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		panel.add(panel_2);
		panel.add(panel_1);
		btnReset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Xóa nội dung trong các trường nhập liệu và combo box
				textField.setText("");
				comboBox.setSelectedIndex(0);
				fromDateField.setValue(null);
				toDateField.setValue(null);
				minPriceField.setText("");
				maxPriceField.setText("");

				// Reload lại bảng
				reloadTable();
			}
		});

		JButton btnTim = new JButton("Tìm");
		btnTim.setIcon(new ImageIcon(PhieuNhap.class.getResource("/com/quanlikho/Item/loupe.png")));
		btnTim.setBounds(340, 26, 80, 34);
		panel_1.add(btnTim);
		btnTim.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				timKiemPhieuNhap();
			}
		});

		JPanel panel_3 = new JPanel();
		add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(null);

		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBounds(0, 10, 553, 68);
		panel_1_1.setLayout(null);
		panel_1_1.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"L\u1ECDc theo ng\u00E0y", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_3.add(panel_1_1);

		fromDateField = new JFormattedTextField(new SimpleDateFormat("yyyy-MM-dd"));
		fromDateField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		fromDateField.setBounds(78, 28, 131, 27);
		panel_1_1.add(fromDateField);

		JLabel lblNewLabel = new JLabel("Từ ngày");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 31, 71, 17);
		panel_1_1.add(lblNewLabel);

		toDateField = new JFormattedTextField(new SimpleDateFormat("yyyy-MM-dd"));
		toDateField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		toDateField.setBounds(309, 28, 131, 27);
		panel_1_1.add(toDateField);

		JLabel lblnNgy = new JLabel("Đến ngày");
		lblnNgy.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblnNgy.setBounds(229, 33, 71, 17);
		panel_1_1.add(lblnNgy);

		JButton btnNewButtonLoc = new JButton("Lọc");
		btnNewButtonLoc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButtonLoc.setBounds(476, 29, 55, 25);
		panel_1_1.add(btnNewButtonLoc);
		btnNewButtonLoc.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String fromDate = fromDateField.getText();
				String toDate = toDateField.getText();
				filterByDate(fromDate, toDate);
			}
		});

		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setLayout(null);
		panel_1_1_1.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"L\u1ECDc theo gi\u00E1", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1_1_1.setBounds(563, 10, 505, 68);
		panel_3.add(panel_1_1_1);

		minPriceField = new JFormattedTextField();
		minPriceField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		minPriceField.setBounds(67, 28, 136, 27);
		panel_1_1_1.add(minPriceField);

		JLabel lblT = new JLabel("Từ");
		lblT.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblT.setBounds(10, 33, 35, 17);
		panel_1_1_1.add(lblT);

		maxPriceField = new JFormattedTextField();
		maxPriceField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		maxPriceField.setBounds(279, 28, 127, 27);
		panel_1_1_1.add(maxPriceField);

		JLabel lbln = new JLabel("Đến");
		lbln.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbln.setBounds(229, 33, 55, 17);
		panel_1_1_1.add(lbln);

		JButton btnNewButtonLoc_1 = new JButton("Lọc");
		btnNewButtonLoc_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButtonLoc_1.setBounds(416, 29, 55, 25);
		panel_1_1_1.add(btnNewButtonLoc_1);
		btnNewButtonLoc_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (minPriceField.getText().equals("")  ||  maxPriceField.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Vui lòng không được để trống!", "Thông báo", JOptionPane.DEFAULT_OPTION);
				}else {
					// Lấy giá trị giá tối thiểu và tối đa từ minPriceField và maxPriceField
					String minPriceStr = minPriceField.getText();
					String maxPriceStr = maxPriceField.getText();
					
					// Chuyển đổi giá trị từ chuỗi sang số thực
					double minPrice = Double.parseDouble(minPriceStr);
					double maxPrice = Double.parseDouble(maxPriceStr);
					
					// Lọc dữ liệu và cập nhật bảng hiển thị
					filterByPrice(minPrice, maxPrice);
					
				}
			}
		});

		table = new JTable();
		JScrollPane scrollPane = new JScrollPane(table); // Đặt table vào trong JScrollPane
		panel_3.add(scrollPane);
		scrollPane.setBounds(0, 74, 1068, 527);
		tableModel = new DefaultTableModel(
				new Object[] { "Mã phiếu nhập", "Mã nhà cung cấp", "Ngày nhập", "Người nhập", "Tổng tiền" }, 0);
		table.setModel(tableModel);
	}

	public void initTableNhapHang(ArrayList<PhieuNhapHangDTO> list,  ArrayList<ChiTietPhieuNhapDTO> listCTPN) {
		DefaultTableModel model = new DefaultTableModel(
				new Object[] { "Mã phiếu nhập", "Mã nhà cung cấp", "Ngày nhập", "Người nhập", "Tổng tiền" }, 0);
		for (PhieuNhapHangDTO pnh : list) {
			model.addRow(new Object[] { pnh.getMaPNH(), pnh.getMaNCC(), pnh.getNgayNhap(), pnh.getTenDangNhap(),
					pnh.getTongTien() });
		}
		this.table.setModel(model);
		table.setAutoCreateRowSorter(true);
	}

	public void XoaChiTietPhieuNhap(String maPN) {
		ChitietPnBUS.delete(maPN);
	}

	public void reloadTable() {
		pnhBUS.list();
		ChitietPnBUS.list();
		initTableNhapHang(pnhBUS.getList(), ChitietPnBUS.getList());
	}

	private void timKiemPhieuNhap() {
		// Lấy giá trị của comboBox và textField
		String timKiemTheo = (String) comboBox.getSelectedItem();
		String tuKhoa = textField.getText().trim();

		// Kiểm tra xem có dữ liệu tìm kiếm không
		if (tuKhoa.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập từ khóa tìm kiếm", "Thông báo",
					JOptionPane.WARNING_MESSAGE);
			return;
		}

		// Lấy danh sách các phiếu nhập
		ArrayList<PhieuNhapHangDTO> danhSachPhieuNhap = pnhBUS.getList();

		// Tạo danh sách mới để lưu kết quả tìm kiếm
		ArrayList<PhieuNhapHangDTO> ketQuaTimKiem = new ArrayList<>();

		// Duyệt qua từng phiếu nhập và kiểm tra điều kiện tìm kiếm
		for (PhieuNhapHangDTO pnh : danhSachPhieuNhap) {
			boolean phuHop = false;
			switch (timKiemTheo) {
			case "Mã phiếu nhập":
				phuHop = pnh.getMaPNH().equalsIgnoreCase(tuKhoa);
				break;
			case "Mã nhà cung cấp":
				phuHop = pnh.getMaNCC().equalsIgnoreCase(tuKhoa);
				break;
			case "Ngày nhập":
				phuHop = pnh.getNgayNhap().equalsIgnoreCase(tuKhoa);
				break;
			default:
				// Không làm gì nếu không phù hợp với các trường hợp trên
			}
			if (phuHop) {
				ketQuaTimKiem.add(pnh);
			}
		}

		// Cập nhật bảng hiển thị kết quả tìm kiếm
		updateTable(ketQuaTimKiem);
	}

	// Hàm cập nhật bảng hiển thị kết quả tìm kiếm
	private void updateTable(ArrayList<PhieuNhapHangDTO> ketQua) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0); // Xóa hết dữ liệu hiện tại trong bảng
		for (PhieuNhapHangDTO pnh : ketQua) {
			model.addRow(new Object[] { pnh.getMaPNH(), pnh.getMaNCC(), pnh.getNgayNhap(), pnh.getTenDangNhap(),
					pnh.getTongTien() });
		}
	}

	private void filterByDate(String fromDate, String toDate) {
		ArrayList<PhieuNhapHangDTO> danhSachPhieuNhap = pnhBUS.getList();
		ArrayList<PhieuNhapHangDTO> ketQuaLoc = new ArrayList<>();

		// Duyệt qua từng phiếu nhập và kiểm tra ngày nhập có nằm trong khoảng từ
		// fromDate đến toDate không
		for (PhieuNhapHangDTO pnh : danhSachPhieuNhap) {
			if (isDateBetween(pnh.getNgayNhap(), fromDate, toDate)) {
				ketQuaLoc.add(pnh);
			}
		}

		// Cập nhật bảng hiển thị kết quả lọc
		updateTable(ketQuaLoc);
	}

	// Phương thức kiểm tra xem ngày nhập có nằm trong khoảng từ fromDate đến toDate
	// không
	private boolean isDateBetween(String date, String fromDate, String toDate) {
		return date.compareTo(fromDate) >= 0 && date.compareTo(toDate) <= 0;
	}

	private void filterByPrice(double minPrice, double maxPrice) {
		ArrayList<PhieuNhapHangDTO> danhSachPhieuNhap = pnhBUS.getList();
		ArrayList<PhieuNhapHangDTO> ketQuaLoc = new ArrayList<>();

		// Duyệt qua từng phiếu nhập và kiểm tra tổng tiền có nằm trong khoảng từ
		// minPrice đến maxPrice không
		for (PhieuNhapHangDTO pnh : danhSachPhieuNhap) {
			int tongTien = pnh.getTongTien();
			if (tongTien >= minPrice && tongTien <= maxPrice) {
				ketQuaLoc.add(pnh);
			}
		}

		// Cập nhật bảng hiển thị kết quả lọc
		updateTable(ketQuaLoc);
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
				Sheet sheet = wb.createSheet("Phiếu Nhập");

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

	
	private void openFile(String file) {
		try {
			File path = new File(file);
			Desktop.getDesktop().open(path);
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}
