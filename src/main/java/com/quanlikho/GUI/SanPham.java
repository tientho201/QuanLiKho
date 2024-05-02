package com.quanlikho.GUI;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

import com.quanlikho.BUS.LoaiBUS;
import com.quanlikho.BUS.NhaSanXuatBUS;
import com.quanlikho.BUS.SanPhamBUS;
import com.quanlikho.DTO.LoaiDTO;
import com.quanlikho.DTO.NhaCungCapDTO;
import com.quanlikho.DTO.NhaSanXuatDTO;
import com.quanlikho.DTO.SanPhamDTO;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
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
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

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

    public SanPham() {
    	this.spBUS = new SanPhamBUS();
        this.loaiBUS = new LoaiBUS(); // Initialize loaiBUS properly
        this.nsxBUS = new NhaSanXuatBUS();
    	initComponents();
    	initTable(spBUS.getList());
    	addMouseListenerToTable();
    }

    public void initComponents() {
    	setLayout(null);

    	// Panel chứa các nút chức năng và tìm kiếm
    	JPanel panel = new JPanel();
    	panel.setBounds(0, 0, 1068, 70);
    	add(panel);

    	// Panel chứa các nút chức năng
    	JPanel panel_2 = new JPanel();
    	panel_2.setBorder(new TitledBorder(null, "Chức năng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
    	panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.X_AXIS));

    	JButton btnThem = new JButton("Thêm", new ImageIcon(getClass().getResource("/com/quanlikho/Item/icons8_add_40px.png")));
    	btnThem.addActionListener(new ActionListener() {
    	    public void actionPerformed(ActionEvent e) {
    	        Them();
    	    }
    	});
    	panel_2.add(btnThem);

    	JButton btnXoa = new JButton("Xoá", new ImageIcon(getClass().getResource("/com/quanlikho/Item/icons8_delete_40px.png")));
    	btnXoa.addActionListener(new ActionListener() {
    	    public void actionPerformed(ActionEvent e) {
    	        Xoa();
    	    }
    	});
    	panel_2.add(btnXoa);

    	JButton btnSua = new JButton("Sửa", new ImageIcon(getClass().getResource("/com/quanlikho/Item/icons8_edit_40px.png")));
    	btnSua.addActionListener(new ActionListener() {
    	    public void actionPerformed(ActionEvent e) {
    	        Sua();
    	    }
    	});
    	panel_2.add(btnSua);

    	JButton btnNhap = new JButton("Nhập Excel", new ImageIcon(getClass().getResource("/com/quanlikho/Item/icons8_xls_40px.png")));
    	panel_2.add(btnNhap);

    	JButton btnXuat = new JButton("Xuất Excel", new ImageIcon(getClass().getResource("/com/quanlikho/Item/icons8_xls_40px.png")));
    	btnXuat.setHorizontalAlignment(SwingConstants.LEADING);
    	panel_2.add(btnXuat);

    	// Panel chứa ô tìm kiếm
    	JPanel panel_1 = new JPanel();
    	panel_1.setBorder(new TitledBorder(null, "Tìm kiếm", TitledBorder.LEADING, TitledBorder.TOP, null, null));
    	panel_1.setLayout(null);

    	String[] options = {"Tất cả","Mã sản phẩm", "Tên sản phẩm", "Số lượng", "Giá","Mã loại", "Mã NSX", "Ghi chú"};
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
    	textField.setBounds(144, 21, 131, 33);
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
    	


    	JButton btnReset = new JButton("");
    	btnReset.setBounds(285, 21, 57, 33);
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
    	table = new JTable(new DefaultTableModel(
    	        new Object[][] {},
    	        new String[] {"Mã sản phẩm", "Tên sản phẩm", "Số lượng", "Giá", "Mã loại", "Mã NSX", "Ghi chú"}));
    	JScrollPane scrollPane = new JScrollPane(table);
    	scrollPane.setBounds(0, 70, 1068, 468);
    	add(scrollPane);

    	// Các ô nhập liệu
    	textFieldMaSP = new JTextField();
    	textFieldMaSP.setBounds(136, 548, 138, 32);
    	add(textFieldMaSP);
    	textFieldMaSP.setColumns(10);

    	textFieldTenSP = new JTextField();
    	textFieldTenSP.setColumns(10);
    	textFieldTenSP.setBounds(136, 626, 138, 32);
    	add(textFieldTenSP);

    	JLabel lblNewLabel = new JLabel("Tên sản phẩm");
    	lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 15));
    	lblNewLabel.setBounds(10, 622, 130, 32);
    	add(lblNewLabel);

    	JLabel lblMSnPhm = new JLabel("Mã sản phẩm");
    	lblMSnPhm.setFont(new Font("Segoe UI", Font.BOLD, 15));
    	lblMSnPhm.setBounds(10, 548, 116, 28);
    	add(lblMSnPhm);

    	JLabel lblSLng = new JLabel("Số lượng");
    	lblSLng.setFont(new Font("Segoe UI", Font.BOLD, 15));
    	lblSLng.setBounds(302, 552, 109, 28);
    	add(lblSLng);

    	JLabel lblGi = new JLabel("Giá");
    	lblGi.setFont(new Font("Segoe UI", Font.BOLD, 15));
    	lblGi.setBounds(302, 626, 95, 32);
    	add(lblGi);

    	textFieldSoLuong = new JTextField();
    	textFieldSoLuong.setColumns(10);
    	textFieldSoLuong.setBounds(399, 548, 138, 32);
    	add(textFieldSoLuong);

    	textFieldGia = new JTextField();
    	textFieldGia.setColumns(10);
    	textFieldGia.setBounds(399, 626, 138, 32);
    	add(textFieldGia);

    	JLabel lblMLoi = new JLabel("Mã loại");
    	lblMLoi.setFont(new Font("Segoe UI", Font.BOLD, 15));
    	lblMLoi.setBounds(568, 552, 109, 28);
    	add(lblMLoi);

    	JLabel lblSLng_1_1 = new JLabel("Mã NSX");
    	lblSLng_1_1.setFont(new Font("Segoe UI", Font.BOLD, 15));
    	lblSLng_1_1.setBounds(568, 630, 95, 28);
    	add(lblSLng_1_1);

    	comboBoxMaLoai = new JComboBox<String>();
    	comboBoxMaLoai.setBounds(661, 547, 138, 37);
    	add(comboBoxMaLoai);

    	comboBoxMaNSX = new JComboBox<String>();
    	comboBoxMaNSX.setBounds(661, 623, 138, 37);
    	add(comboBoxMaNSX);

    	JLabel lblGhiCh = new JLabel("Ghi chú");
    	lblGhiCh.setFont(new Font("Segoe UI", Font.BOLD, 15));
    	lblGhiCh.setBounds(833, 548, 130, 37);
    	add(lblGhiCh);

    	textAreaGhiChu = new JTextArea();
    	textAreaGhiChu.setBounds(564, 46, 85, 112);
    	textAreaGhiChu.setLineWrap(true);
    	textAreaGhiChu.setWrapStyleWord(true);
    	JScrollPane scrollPane1 = new JScrollPane(textAreaGhiChu);
    	scrollPane1.setBounds(833, 595, 225, 70);
    	scrollPane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    	scrollPane1.setAutoscrolls(true);
    	add(scrollPane1);

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

    	for (SanPhamDTO sp : listsp) {
    	    model.addRow(new Object[] { sp.getMaSP(), sp.getTenSP(), sp.getSoLuong(), sp.getGia(), sp.getMaLoai(), sp.getMaNSX(), sp.getGhiChu() });
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

    	        SanPhamDTO sp = new SanPhamDTO(masp, tensp, soLuong, gia, maLoai, maNSX, ghiChusp);
    	        spBUS.add(sp);
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

    	    SanPhamDTO sp = new SanPhamDTO(masp, tensp, soLuong, gia, maLoai, maNSX, ghiChusp);
    	    spBUS.update(sp);
    	    JOptionPane.showMessageDialog(null, "Sửa thành công", "Thông báo", JOptionPane.DEFAULT_OPTION);
    	    Reload();
    	}
    }

    private void Xoa() {
    	if (textFieldMaSP.getText() != null && !textFieldMaSP.getText().isEmpty()) {
    	    if (spBUS.checkDataIsReferenced(textFieldMaSP.getText())) {
    	        JOptionPane.showMessageDialog(null, "Không thể xoá sản phẩm này vì có dữ liệu liên quan trong bảng khác.", "Thông báo", JOptionPane.WARNING_MESSAGE);
    	    } else {
    	        spBUS.delete(textFieldMaSP.getText());
    	        JOptionPane.showMessageDialog(null, "Xóa thành công", "Thông báo", JOptionPane.DEFAULT_OPTION);
    	        Reload();
    	    }
    	} else {
    	    JOptionPane.showMessageDialog(null, "Vui lòng chọn một sản phẩm để xóa", "Thông báo", JOptionPane.DEFAULT_OPTION);
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

                    // Chọn mục tương ứng trong combobox
                    comboBoxMaLoai.setSelectedItem(maloai);
                    comboBoxMaNSX.setSelectedItem(maNSX);

                    textFieldMaSP.setEditable(false);
                    textFieldMaSP.setEnabled(false);
                }
            }
        });
    }
    private void searchAndUpdateTable() {
	    String selectedOption = comboBox.getSelectedItem().toString();
	    String keyword = textField.getText().trim();
	    
	    // Kiểm tra nếu chọn mục khác "Tất cả" và không có từ khóa tìm kiếm thì không hiển thị bảng
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

}
