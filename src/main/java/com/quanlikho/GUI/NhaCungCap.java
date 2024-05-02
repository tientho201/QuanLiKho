package com.quanlikho.GUI;



import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.BoxLayout;
import javax.swing.table.DefaultTableModel;

import com.quanlikho.BUS.NhaCungCapBUS;
import com.quanlikho.BUS.NhaCungCapBUS;
import com.quanlikho.DTO.NhaCungCapDTO;

import javax.swing.JScrollPane;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JTextArea;
import java.awt.Font;

public class NhaCungCap extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTable table;
	private JComboBox comboBox;
	private JTextField textFieldMaNCC;
	private JTextField textFieldTenNCC;
	private JTextField textFieldDiaChi;
	private JTextField textField_SDT;
	private JScrollPane scrollPane1;
	private JTextArea textArea;
	private NhaCungCapBUS nccBUS = new NhaCungCapBUS();

	/**
	 * Create the panel.
	 */
	public NhaCungCap() {
		if (nccBUS.getList() == null) {
            nccBUS.list();
        }
        initComponents();
        initTable(nccBUS.getList());
        addMouseListenerToTable();
    }

    public void initComponents() {
        // Đặt kích thước cho JPanel
		setBounds(0,0, 1068, 693);
        setLayout(null);
        
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 1068, 70);
 
        add(panel);
        
        JPanel panel_2 = new JPanel();
        panel_2.setBorder(new TitledBorder(null, "Ch\u1EE9c n\u0103ng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.X_AXIS));
        
        JButton btnThem = new JButton("Thêm", new ImageIcon(getClass().getResource("/com/quanlikho/Item/icons8_add_40px.png")));
        panel_2.add(btnThem);
        
        JButton btnXoa = new JButton("Xoá", new ImageIcon(getClass().getResource("/com/quanlikho/Item/icons8_delete_40px.png")));
        panel_2.add(btnXoa);
        
        JButton btnSua = new JButton("Sửa", new ImageIcon(getClass().getResource("/com/quanlikho/Item/icons8_edit_40px.png")));
        panel_2.add(btnSua);
        
        JButton btnNhap = new JButton("Nhập Excel", new ImageIcon(getClass().getResource("/com/quanlikho/Item/icons8_xls_40px.png")));
        panel_2.add(btnNhap);
        
        JButton btnXuat = new JButton("Xuất Excel", new ImageIcon(getClass().getResource("/com/quanlikho/Item/icons8_xls_40px.png")));
        btnXuat.setHorizontalAlignment(SwingConstants.LEADING);
        panel_2.add(btnXuat);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBorder(new TitledBorder(null, "T\u00ECm ki\u1EBFm", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel_1.setLayout(null);
        
        String[] options = {"Tất cả","Mã nhà cung cấp", "Tên nhà cung cấp", "Địa chỉ", "Số điện thoại", "Ghi chú"};
        comboBox = new JComboBox(options);
        comboBox.setBounds(22, 26, 137, 28);
        panel_1.add(comboBox);
        comboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedOption = comboBox.getSelectedItem().toString(); // Lấy giá trị được chọn từ comboBox
                String keyword = textField.getText(); // Lấy từ khóa tìm kiếm từ textField
                ArrayList<NhaCungCapDTO> searchResult = nccBUS.search(selectedOption, keyword); // Thực hiện tìm kiếm
                initTable(searchResult); // Cập nhật bảng với kết quả tìm kiếm
            }
        });
        
        textField = new JTextField();
        textField.setBounds(196, 26, 137, 28);
        panel_1.add(textField);
        textField.setColumns(10);
        
        
     // Thêm bộ lắng nghe sự kiện vào textfield tìm kiếm
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

       

        
        JButton btnReset = new JButton("Làm mới");
        btnReset.setBounds(354, 26, 119, 28);
        btnReset.setIcon(new ImageIcon(NhaCungCap.class.getResource("/com/quanlikho/Item/icons8_reset_25px_1.png")));
        panel_1.add(btnReset);
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.add(panel_2);
        panel.add(panel_1);
        
        table = new JTable(new DefaultTableModel(
        	new Object[][] {
        	},
        	new String[] {
        		"Mã nhà cung cấp", "Tên nhà cung cấp", "Số điện thoại", "Địa chỉ", "Ghi chú"
        	}
        ));
        JScrollPane scrollPane = new JScrollPane(table); // Đặt table vào trong JScrollPane
        scrollPane.setBounds(0, 70, 1068, 464);
        add(scrollPane); 
        
        JPanel panelInput = new JPanel();
        panelInput.setBounds(0, 545, 1068, 148);
        panelInput.setBorder(new TitledBorder(null, "Thông tin nhà cung cấp", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panelInput.setLayout(null);

        // Text field và label cho Mã nhà cung cấp
        JLabel lblMaNCC = new JLabel("Mã nhà cung cấp:");
        lblMaNCC.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblMaNCC.setBounds(67, 26, 130, 20);
        panelInput.add(lblMaNCC);
        textFieldMaNCC = new JTextField();
        textFieldMaNCC.setBounds(207, 20, 150, 35);
        panelInput.add(textFieldMaNCC);

        // Text field và label cho Tên nhà cung cấp
        JLabel lblTenNCC = new JLabel("Tên nhà cung cấp:");
        lblTenNCC.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblTenNCC.setBounds(423, 20, 130, 35);
        panelInput.add(lblTenNCC);
        textFieldTenNCC = new JTextField();
        textFieldTenNCC.setBounds(563, 20, 150, 35);
        panelInput.add(textFieldTenNCC);

        // Text field và label cho Số điện thoại
        JLabel lblSDT = new JLabel("Số điện thoại:");
        lblSDT.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblSDT.setBounds(67, 85, 130, 35);
        panelInput.add(lblSDT);
        
        textField_SDT = new JTextField();
        textField_SDT.setBounds(207, 86, 150, 35);
        panelInput.add(textField_SDT);
        textField_SDT.setColumns(10);

        // Text field và label cho Địa chỉ
        JLabel lblDiaChi = new JLabel("Địa chỉ:");
        lblDiaChi.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblDiaChi.setBounds(423, 85, 130, 35);
        panelInput.add(lblDiaChi);
        
        textFieldDiaChi = new JTextField();
        textFieldDiaChi.setBounds(563, 86, 150, 35);
        panelInput.add(textFieldDiaChi);
        textFieldDiaChi.setColumns(10);

        // Text field và label cho Ghi chú
        JLabel lblGhiChu = new JLabel("Ghi chú:");
        lblGhiChu.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblGhiChu.setBounds(793, 68, 130, 20);
        panelInput.add(lblGhiChu);

        // Thêm panelInput vào JPanel chính
        add(panelInput);
        textArea = new JTextArea();
        textArea.setBounds(150, 82, 150, 55);

        // Tạo JScrollPane và chứa JTextArea
        scrollPane1 = new JScrollPane(textArea);
        scrollPane1.setBounds(880, 37, 150, 81);
        panelInput.add(scrollPane1);    
        
        btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Them();
			}
		});
        
        btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Xoa();
			}
		});
        
        btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sua();
			}
		});
        
        btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Reload();
			}
		});
	}
	private boolean KiemTraTrong() {
	    if (textFieldMaNCC.getText().isEmpty()) {
	        textFieldMaNCC.requestFocus();
	        return false;
	    } else if (textFieldTenNCC.getText().isEmpty()) {
	        textFieldTenNCC.requestFocus();
	        return false;
	    } else if (textFieldDiaChi.getText().isEmpty()) {
	        textFieldDiaChi.requestFocus();
	        return false;
	    } else if (textField_SDT.getText().isEmpty()) {
	        textField_SDT.requestFocus();
	        return false;
	    }
	    return true;
	}

	public void Reload() {
	    // Xóa nội dung của các trường nhập liệu
	    textFieldMaNCC.setText("");
	    textFieldMaNCC.setEditable(true);
	    textFieldMaNCC.setEnabled(true);
	    textFieldTenNCC.setText("");
	    textFieldDiaChi.setText("");
	    textField_SDT.setText("");

	    // Focus vào trường mã NCC
	    textFieldMaNCC.requestFocus();
	    
	    // Tải lại dữ liệu từ cơ sở dữ liệu
	    NhaCungCapBUS nhaCungCapBUS = new NhaCungCapBUS();
	    ArrayList<NhaCungCapDTO> listNCC = nhaCungCapBUS.list();
	    
	    // Hiển thị dữ liệu lên bảng
	    initTable(listNCC);
	}
	public void initTable(ArrayList<NhaCungCapDTO> listNCC) {
	    DefaultTableModel model = new DefaultTableModel();
	    model.addColumn("Mã NCC");
	    model.addColumn("Tên NCC");
	    model.addColumn("Địa chỉ");
	    model.addColumn("Số điện thoại");
	    model.addColumn("Ghi chú");
	    
	    for (NhaCungCapDTO ncc : listNCC) {
	        model.addRow(new Object[] { ncc.getMaNCC(), ncc.getTenNCC(), ncc.getDiaChiNCC(), ncc.getSDTNCC(), ncc.getGhiChu() });
	    }
	    
	    table.setModel(model);
	    table.setAutoCreateRowSorter(true);
	    
	}
	public void Them() {
	    if (KiemTraTrong()) {
	    	if(!nccBUS.checkMaNCC(textFieldMaNCC.getText())) {
	        String maNCC = textFieldMaNCC.getText();
	        String tenNCC = textFieldTenNCC.getText();
	        String diaChiNCC = textFieldDiaChi.getText();
	        String soDienThoaiNCC = textField_SDT.getText();
	        String ghiChuNCC = textArea.getText();

	        NhaCungCapDTO ncc = new NhaCungCapDTO(maNCC, tenNCC, diaChiNCC, soDienThoaiNCC, ghiChuNCC);
	        nccBUS.add(ncc);
	        JOptionPane.showMessageDialog(null, "Thêm thành công", "Thông báo", JOptionPane.DEFAULT_OPTION);
	        Reload();
	    }else {
	    	JOptionPane.showMessageDialog(null, "Mã nhà cung cấp bị trùng","Thông báo", JOptionPane.DEFAULT_OPTION);
	    }
	}
	}

	public void Sua() {
	    if (KiemTraTrong()) {
	        String maNCC = textFieldMaNCC.getText();
	        String tenNCC = textFieldTenNCC.getText();
	        String diaChiNCC = textFieldDiaChi.getText();
	        String soDienThoaiNCC = textField_SDT.getText();
	        String ghiChuNCC = textArea.getText();

	        NhaCungCapDTO ncc = new NhaCungCapDTO(maNCC, tenNCC, diaChiNCC, soDienThoaiNCC, ghiChuNCC);
	        nccBUS.update(ncc);
	        JOptionPane.showMessageDialog(null, "Sửa thành công", "Thông báo", JOptionPane.DEFAULT_OPTION);
	        Reload();
	    }
	}

	private void Xoa() {
	    if (textFieldMaNCC.getText() != null && !textFieldMaNCC.getText().isEmpty()) {
	        // Kiểm tra xem có ràng buộc khóa ngoại hay không
	        if (nccBUS.checkDataIsReferenced(textFieldMaNCC.getText())) {
	            JOptionPane.showMessageDialog(null, "Không thể xoá nhà cung cấp này vì có dữ liệu liên quan trong bảng khác.", "Thông báo", JOptionPane.WARNING_MESSAGE);
	        } else {
	            // Xoá nhà cung cấp nếu không có ràng buộc khóa ngoại
	            nccBUS.delete(textFieldMaNCC.getText());
	            JOptionPane.showMessageDialog(null, "Xóa thành công", "Thông báo", JOptionPane.DEFAULT_OPTION);
	            Reload();
	        }
	    } else {
	        JOptionPane.showMessageDialog(null, "Vui lòng chọn một nhà cung cấp để xóa", "Thông báo", JOptionPane.DEFAULT_OPTION);
	    }
	}

	public void addMouseListenerToTable() {
        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                int index = table.getSelectedRow();
                if (index >= 0) { // Kiểm tra xem có hàng nào được chọn không
                    // Lấy dữ liệu từ hàng được chọn và hiển thị trên các thành phần giao diện
                    textFieldMaNCC.setText((String) table.getValueAt(index, 0));
                    textFieldTenNCC.setText((String) table.getValueAt(index, 1));
                    textFieldDiaChi.setText((String) table.getValueAt(index, 2));
                    textField_SDT.setText((String) table.getValueAt(index, 3));
                    textFieldMaNCC.setEditable(false);
    				textFieldMaNCC.setEnabled(false);
					textArea.setText((String) table.getValueAt(index, 4));
                }
            }
        });
	}
	private void searchAndUpdateTable() {
        String selectedOption = comboBox.getSelectedItem().toString();
        String keyword = textField.getText().trim();
        
        // Thực hiện tìm kiếm
        ArrayList<NhaCungCapDTO> searchResult = nccBUS.search(selectedOption, keyword);
        
        // Cập nhật bảng hiển thị
        initTable(searchResult);
    }
}