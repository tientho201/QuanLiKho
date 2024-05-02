package com.quanlikho.GUI;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

import com.quanlikho.BUS.NhaCungCapBUS;
import com.quanlikho.BUS.PhanLoaiBUS;
import com.quanlikho.DTO.LoaiDTO;
import com.quanlikho.DTO.NhaCungCapDTO;
import com.quanlikho.DTO.NhaSanXuatDTO;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.AbstractButton;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class PhanLoai extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField_NCC;
	private JTextField textFieldNSX;
	private JTextField textField_Loai;
	private JTable table;
	private JTextField textField_maNSX;
	private JTextField textField_tenNSX;
	private JTextField textField_maLoai;
	private JTextField textField_tenLoai;
	private JTextField textFieldMaNCC;
	private JTextField textFieldTenNCC;
	private JTextField textField_SDT;
	private JTextField textFieldDiaChi;
	private JTextArea textArea;
	private JScrollPane scrollPane1_2;
	private PhanLoaiBUS phanLoaiBUS = new PhanLoaiBUS();
	private JComboBox comboBox_NCC;
	private JComboBox comboBoxNSX;
	private JComboBox comboBox_Loai;
	private JButton btnResetLoai;
	private JButton btnThemLoai;
	private JButton btnXoaLoai;
	private JButton btnSuaLoai;
	private JButton btnnhapexcelnsx;
	private AbstractButton btnxuatexcelnsx;
	private JButton btnResetNSX;
	private JButton btnThemNSX;
	private JButton btnXoaNSX;
	private JButton btnSuaNSX;
	private AbstractButton btnNewButton_1;
	private JButton btnNewButton;
	private JTable tableNSX;
	private JTable table_1;
	private JTable tableLoai;

	/**
	 * Create the panel.
	 */
	public PhanLoai() {
		if (phanLoaiBUS.getListNCC() == null) {
            phanLoaiBUS.listNCC();
		}
		if (phanLoaiBUS.getListNSX() == null) {
            phanLoaiBUS.listNSX();
		}
		if (phanLoaiBUS.getListLoai() == null) {
            phanLoaiBUS.listLoai();
		}
		initComponents();
        initTable(phanLoaiBUS.getListNCC());
        initTableNSX(phanLoaiBUS.getListNSX());
        initTableLoai(phanLoaiBUS.getListLoai());
        addMouseListenerToTable();
        addMouseListenerToTableNSX();
        addMouseListenerToTableLoai();
	}
        public void initComponents() {
		setBounds(0,0, 1068, 693);
        setLayout(null);
        
        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setBounds(10, 7, 1048, 676);
        add(tabbedPane);
        
        JPanel panel_4 = new JPanel();
        tabbedPane.addTab("Nhà Sản Xuất", null, panel_4, null);
        panel_4.setLayout(null);
        
        JPanel panel_5 = new JPanel();
        panel_5.setBorder(new TitledBorder(null, "Ch\u1EE9c n\u0103ng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel_5.setBounds(0, 10, 610, 70);
        panel_4.add(panel_5);
        panel_5.setLayout(new GridLayout(1, 0, 0, 0));
        
        btnThemNSX = new JButton("Thêm");
        btnThemNSX.setFont(new Font("Tahoma", Font.PLAIN, 12));
        btnThemNSX.setIcon(new ImageIcon(PhanLoai.class.getResource("/com/quanlikho/Item/icons8_add_40px.png")));
        btnThemNSX.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        panel_5.add(btnThemNSX);
        
        btnXoaNSX = new JButton("Xóa");
        btnXoaNSX.setIcon(new ImageIcon(PhanLoai.class.getResource("/com/quanlikho/Item/icons8_delete_40px.png")));
        btnXoaNSX.setFont(new Font("Tahoma", Font.PLAIN, 12));
        panel_5.add(btnXoaNSX);
        
        btnSuaNSX = new JButton("Sửa");
        btnSuaNSX.setIcon(new ImageIcon(PhanLoai.class.getResource("/com/quanlikho/Item/icons8_edit_40px.png")));
        btnSuaNSX.setFont(new Font("Tahoma", Font.PLAIN, 12));
        panel_5.add(btnSuaNSX);
        
        btnNewButton_1 = new JButton("Nhập Excel");
        btnNewButton_1.setIcon(new ImageIcon(PhanLoai.class.getResource("/com/quanlikho/Item/logo_excel_32.png")));
        btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
        panel_5.add(btnNewButton_1);
        
        btnNewButton = new JButton("Xuất Excel");
        btnNewButton.setIcon(new ImageIcon(PhanLoai.class.getResource("/com/quanlikho/Item/logo_excel_32.png")));
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 10));
        panel_5.add(btnNewButton);
        
        JPanel panel_5_1 = new JPanel();
        panel_5_1.setBorder(new TitledBorder(null, "T\u00ECm ki\u1EBFm", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel_5_1.setBounds(611, 10, 432, 70);
        panel_4.add(panel_5_1);
        panel_5_1.setLayout(null);
        
        String[] optionsnsx = {"Tất cả","Mã nhà sản xuất", "Tên nhà sản xuất"};
        comboBoxNSX = new JComboBox(optionsnsx);
        comboBoxNSX.setBounds(11, 21, 123, 32);
        panel_5_1.add(comboBoxNSX);
        
        textFieldNSX = new JTextField();
        textFieldNSX.setBounds(143, 21, 178, 31);
        panel_5_1.add(textFieldNSX);
        textFieldNSX.setColumns(10);
        
        btnResetNSX = new JButton("");
        btnResetNSX.setIcon(new ImageIcon(PhanLoai.class.getResource("/com/quanlikho/Item/icons8_reset_25px_1.png")));
        btnResetNSX.setBounds(331, 20, 85, 36);
        panel_5_1.add(btnResetNSX);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(4, 82, 1033, 411);
        panel_4.add(scrollPane);

        // Sử dụng tableNSX thay vì table
        tableNSX = new JTable(new DefaultTableModel(
            new Object[][] {},
            new String[] { "Mã nhà sản xuất", "Tên nhà sản xuất" }
        ));
        scrollPane.setViewportView(tableNSX);

        
        JPanel panelInput = new JPanel();
        panelInput.setLayout(null);
        panelInput.setBorder(new TitledBorder(null, "Thông tin nhà sản xuất", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panelInput.setBounds(3, 499, 1038, 148);
        panel_4.add(panelInput);
        
        JLabel lblMaNSX = new JLabel("Mã nhà sản xuất:");
        lblMaNSX.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblMaNSX.setBounds(65, 64, 130, 20);
        panelInput.add(lblMaNSX);
        
        textField_maNSX = new JTextField();
        textField_maNSX.setBounds(205, 58, 150, 35);
        panelInput.add(textField_maNSX);
        
        JLabel lblTenNSX = new JLabel("Tên nhà sản xuất:");
        lblTenNSX.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblTenNSX.setBounds(421, 58, 130, 35);
        panelInput.add(lblTenNSX);
        
        textField_tenNSX = new JTextField();
        textField_tenNSX.setBounds(561, 58, 150, 35);
        panelInput.add(textField_tenNSX);
        
        btnThemNSX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ThemNSX();
			}
		});
        
        btnXoaNSX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				XoaNSX();
			}
		});
        
        btnSuaNSX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SuaNSX();
			}
		});
        
        btnResetNSX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReloadNSX();
			}
		});
        textFieldNSX.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                searchAndUpdateTableNSX();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                searchAndUpdateTableNSX();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                searchAndUpdateTableNSX();
            }
        });

        comboBoxNSX.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedOption = comboBoxNSX.getSelectedItem().toString();
                String keyword = textFieldNSX.getText().trim();
                
                // Kiểm tra nếu chọn mục khác "Tất cả" và không có từ khóa tìm kiếm thì không hiển thị bảng
                if (!selectedOption.equals("Tất cả") && keyword.isEmpty()) {
                    // Xóa dữ liệu trong bảng
                    DefaultTableModel model = (DefaultTableModel) tableNSX.getModel();
                    model.setRowCount(0);
                    return;
                }
                
                // Thực hiện tìm kiếm
                ArrayList<NhaSanXuatDTO> searchResult = phanLoaiBUS.searchNSX(selectedOption, keyword);
                
                // Cập nhật bảng hiển thị
                initTableNSX(searchResult);
            }
        });

        
       
        
        JPanel panel_3 = new JPanel();
        tabbedPane.addTab("Loại Sản Phẩm", null, panel_3, null);
        panel_3.setLayout(null);
        
        JPanel panel_5_2 = new JPanel();
        panel_5_2.setBorder(new TitledBorder(null, "Ch\u1EE9c n\u0103ng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel_5_2.setBounds(1, 9, 610, 70);
        panel_3.add(panel_5_2);
        panel_5_2.setLayout(new GridLayout(1, 0, 0, 0));
        
        btnThemLoai = new JButton("Thêm");
        btnThemLoai.setIcon(new ImageIcon(PhanLoai.class.getResource("/com/quanlikho/Item/icons8_add_40px.png")));
        btnThemLoai.setFont(new Font("Tahoma", Font.PLAIN, 12));
        panel_5_2.add(btnThemLoai);
        
        btnXoaLoai = new JButton("Xóa");
        btnXoaLoai.setIcon(new ImageIcon(PhanLoai.class.getResource("/com/quanlikho/Item/icons8_delete_40px.png")));
        btnXoaLoai.setFont(new Font("Tahoma", Font.PLAIN, 12));
        panel_5_2.add(btnXoaLoai);
        
        btnSuaLoai = new JButton("Sửa");
        btnSuaLoai.setIcon(new ImageIcon(PhanLoai.class.getResource("/com/quanlikho/Item/icons8_edit_40px.png")));
        btnSuaLoai.setFont(new Font("Tahoma", Font.PLAIN, 12));
        panel_5_2.add(btnSuaLoai);
        
        btnnhapexcelnsx = new JButton("Nhập Excel");
        btnnhapexcelnsx.setIcon(new ImageIcon(PhanLoai.class.getResource("/com/quanlikho/Item/logo_excel_32.png")));
        btnnhapexcelnsx.setFont(new Font("Tahoma", Font.PLAIN, 10));
        panel_5_2.add(btnnhapexcelnsx);
        
        btnxuatexcelnsx = new JButton("Xuất Excel");
        btnxuatexcelnsx.setIcon(new ImageIcon(PhanLoai.class.getResource("/com/quanlikho/Item/logo_excel_32.png")));
        btnxuatexcelnsx.setFont(new Font("Tahoma", Font.PLAIN, 10));
        panel_5_2.add(btnxuatexcelnsx);
        
        JPanel panel_5_1_1 = new JPanel();
        panel_5_1_1.setLayout(null);
        panel_5_1_1.setBorder(new TitledBorder(null, "T\u00ECm ki\u1EBFm", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel_5_1_1.setBounds(612, 9, 430, 70);
        panel_3.add(panel_5_1_1);
        
        String[] optionsloai = {"Tất cả","Mã loại", "Tên loại"};
        comboBox_Loai = new JComboBox(optionsloai);
        comboBox_Loai.setBounds(11, 21, 123, 32);
        panel_5_1_1.add(comboBox_Loai);
        
        textField_Loai = new JTextField();
        textField_Loai.setColumns(10);
        textField_Loai.setBounds(143, 21, 178, 31);
        panel_5_1_1.add(textField_Loai);
        
        btnResetLoai = new JButton("");
        btnResetLoai.setIcon(new ImageIcon(PhanLoai.class.getResource("/com/quanlikho/Item/icons8_reset_25px_1.png")));
        btnResetLoai.setBounds(331, 20, 85, 36);
        panel_5_1_1.add(btnResetLoai);
        
        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(4, 82, 1035, 407);
        panel_3.add(scrollPane_1);
        
        tableLoai = new JTable(new DefaultTableModel(
            	new Object[][] {
            	},
            	new String[] {
            		"Mã loại", "Tên loại"
            	}
            ));
        scrollPane_1.setViewportView(tableLoai);
        
        JPanel panelInput_1 = new JPanel();
        panelInput_1.setLayout(null);
        panelInput_1.setBorder(new TitledBorder(null, "Thông tin nhà cung cấp", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panelInput_1.setBounds(4, 496, 1038, 148);
        panel_3.add(panelInput_1);
        
        JLabel lblMaloai = new JLabel("Mã loại:");
        lblMaloai.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblMaloai.setBounds(64, 59, 130, 20);
        panelInput_1.add(lblMaloai);
        
        textField_maLoai = new JTextField();
        textField_maLoai.setBounds(204, 53, 150, 35);
        panelInput_1.add(textField_maLoai);
        
        JLabel lblTenloai = new JLabel("Tên loại:");
        lblTenloai.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblTenloai.setBounds(420, 53, 130, 35);
        panelInput_1.add(lblTenloai);
        
        textField_tenLoai = new JTextField();
        textField_tenLoai.setBounds(560, 53, 150, 35);
        panelInput_1.add(textField_tenLoai);
        
     // Thêm sự kiện cho nút Thêm Loại
        btnThemLoai.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ThemLoai();
            }
        });

        // Thêm sự kiện cho nút Xóa Loại
        btnXoaLoai.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                XoaLoai();
            }
        });

        // Thêm sự kiện cho nút Sửa Loại
        btnSuaLoai.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SuaLoai();
            }
        });

        // Thêm sự kiện cho nút Reset Loại
        btnResetLoai.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ReloadLoai();
            }
        });

        // Thêm sự kiện cho ô nhập liệu Loại
        textField_Loai.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                searchAndUpdateTableLoai();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                searchAndUpdateTableLoai();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                searchAndUpdateTableLoai();
            }
        });

        comboBox_Loai.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedOption = comboBox_Loai.getSelectedItem().toString();
                String keyword = textField_Loai.getText().trim();
                
                // Kiểm tra nếu chọn mục khác "Tất cả" và không có từ khóa tìm kiếm thì không hiển thị bảng
                if (!selectedOption.equals("Tất cả") && keyword.isEmpty()) {
                    // Xóa dữ liệu trong bảng
                    DefaultTableModel model = (DefaultTableModel) tableLoai.getModel();
                    model.setRowCount(0);
                    return;
                }
                		ArrayList<LoaiDTO> searchResult = phanLoaiBUS.searchLoai(selectedOption, keyword);
		                
		                // Cập nhật bảng hiển thị
		                initTableLoai(searchResult);
		            }
		        });
   
        
        JPanel panel = new JPanel();
        tabbedPane.addTab("Nhà Cung Cấp", null, panel, null);
        panel.setLayout(null);
        
        JPanel panel_2 = new JPanel();
        panel_2.setBounds(0, 10, 585, 70);
        panel.add(panel_2);
        panel_2.setBorder(new TitledBorder(null, "Ch\u1EE9c n\u0103ng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.X_AXIS));
        
        JButton btnThem_NCC = new JButton("Thêm", new ImageIcon(getClass().getResource("/com/quanlikho/Item/icons8_add_40px.png")));
        panel_2.add(btnThem_NCC);
        
        JButton btnXoa_NCC = new JButton("Xoá", new ImageIcon(getClass().getResource("/com/quanlikho/Item/icons8_delete_40px.png")));
        panel_2.add(btnXoa_NCC);
        
        JButton btnSua_NCC = new JButton("Sửa", new ImageIcon(getClass().getResource("/com/quanlikho/Item/icons8_edit_40px.png")));
        panel_2.add(btnSua_NCC);
        
        JButton btnNhap_NCC = new JButton("Nhập Excel", new ImageIcon(getClass().getResource("/com/quanlikho/Item/icons8_xls_40px.png")));
        panel_2.add(btnNhap_NCC);
        
        JButton btnXuat_NCC = new JButton("Xuất Excel", new ImageIcon(getClass().getResource("/com/quanlikho/Item/icons8_xls_40px.png")));
        btnXuat_NCC.setHorizontalAlignment(SwingConstants.LEADING);
        panel_2.add(btnXuat_NCC);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBounds(595, 10, 448, 70);
        panel.add(panel_1);
        panel_1.setLayout(null);
        panel_1.setBorder(new TitledBorder(null, "T\u00ECm ki\u1EBFm", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        
        String[] options = {"Tất cả","Mã nhà cung cấp", "Tên nhà cung cấp", "Địa chỉ", "Số điện thoại", "Ghi chú"};
        comboBox_NCC = new JComboBox(options);
        comboBox_NCC.setBounds(22, 26, 137, 28);
        panel_1.add(comboBox_NCC);
        
        textField_NCC = new JTextField();
        textField_NCC.setColumns(10);
        textField_NCC.setBounds(196, 26, 137, 28);
        panel_1.add(textField_NCC);
       
        
        JButton btnReset = new JButton("");
        btnReset.setIcon(new ImageIcon(PhanLoai.class.getResource("/com/quanlikho/Item/icons8_reset_25px_1.png")));
        btnReset.setBounds(354, 26, 84, 28);
        panel_1.add(btnReset);
        
        table = new JTable(new DefaultTableModel(
            	new Object[][] {
            	},
            	new String[] {
            		"Mã nhà cung cấp", "Tên nhà cung cấp", "Số điện thoại", "Địa chỉ", "Ghi chú"
            	}
            ));
        
        JScrollPane scrollPane_2 = new JScrollPane(table);
        scrollPane_2.setBounds(1, 84, 1040, 405);
        panel.add(scrollPane_2);
        
        JPanel panelInput_2 = new JPanel();
        panelInput_2.setLayout(null);
        panelInput_2.setBorder(new TitledBorder(null, "Thông tin nhà cung cấp", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panelInput_2.setBounds(2, 495, 1038, 148);
        panel.add(panelInput_2);
        
        JLabel lblMaNCC = new JLabel("Mã nhà cung cấp:");
        lblMaNCC.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblMaNCC.setBounds(67, 26, 130, 20);
        panelInput_2.add(lblMaNCC);
        
        textFieldMaNCC = new JTextField();
        textFieldMaNCC.setBounds(207, 20, 150, 35);
        panelInput_2.add(textFieldMaNCC);
        
        JLabel lblTenNCC = new JLabel("Tên nhà cung cấp:");
        lblTenNCC.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblTenNCC.setBounds(423, 20, 130, 35);
        panelInput_2.add(lblTenNCC);
        
        textFieldTenNCC = new JTextField();
        textFieldTenNCC.setBounds(563, 20, 150, 35);
        panelInput_2.add(textFieldTenNCC);
        
        JLabel lblSDT = new JLabel("Số điện thoại:");
        lblSDT.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblSDT.setBounds(67, 85, 130, 35);
        panelInput_2.add(lblSDT);
        
        textField_SDT = new JTextField();
        textField_SDT.setColumns(10);
        textField_SDT.setBounds(207, 86, 150, 35);
        panelInput_2.add(textField_SDT);
        
        JLabel lblDiaChi = new JLabel("Địa chỉ:");
        lblDiaChi.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblDiaChi.setBounds(424, 84, 130, 35);
        panelInput_2.add(lblDiaChi);
        
        textFieldDiaChi = new JTextField();
        textFieldDiaChi.setColumns(10);
        textFieldDiaChi.setBounds(563, 86, 150, 35);
        panelInput_2.add(textFieldDiaChi);
        
        JLabel lblGhiChu = new JLabel("Ghi chú:");
        lblGhiChu.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblGhiChu.setBounds(793, 68, 130, 20);
        panelInput_2.add(lblGhiChu);
        
        textArea = new JTextArea();
        textArea.setBounds(150, 82, 150, 55);

        scrollPane1_2 = new JScrollPane(textArea);
        scrollPane1_2.setBounds(880, 37, 143, 81);
        panelInput_2.add(scrollPane1_2);
        
        btnThem_NCC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Them();
			}
		});
        
        btnXoa_NCC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Xoa();
			}
		});
        
        btnSua_NCC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sua();
			}
		});
        
        btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Reload();
			}
		});
        textField_NCC.getDocument().addDocumentListener(new DocumentListener() {
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

        comboBox_NCC.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedOption = comboBox_NCC.getSelectedItem().toString();
                String keyword = textField_NCC.getText().trim();
                
                // Kiểm tra nếu chọn mục khác "Tất cả" và không có từ khóa tìm kiếm thì không hiển thị bảng
                if (!selectedOption.equals("Tất cả") && keyword.isEmpty()) {
                    // Xóa dữ liệu trong bảng
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    model.setRowCount(0);
                    return;
                }
                
                // Thực hiện tìm kiếm
                ArrayList<NhaCungCapDTO> searchResult = phanLoaiBUS.searchNCC(selectedOption, keyword);
                
                // Cập nhật bảng hiển thị
                initTable(searchResult);
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
	private boolean KiemTraTrongNSX() {
	    if (textField_maNSX.getText().isEmpty()) {
	    	textField_maNSX.requestFocus();
	        return false;
	    } else if (textField_tenNSX.getText().isEmpty()) {
	    	textField_tenNSX.requestFocus();
	        return false;
	    }
	    return true;
	}
	private boolean KiemTraTrongLoai() {
	    if (textField_maLoai.getText().isEmpty()) {
	    	textField_maLoai.requestFocus();
	        return false;
	    } else if (textField_tenLoai.getText().isEmpty()) {
	    	textField_tenLoai.requestFocus();
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
	    textArea.setText("");

	    // Focus vào trường mã NCC
	    textFieldMaNCC.requestFocus();
	    
	    // Tải lại dữ liệu từ cơ sở dữ liệu
	    PhanLoaiBUS phanLoaiBUS = new PhanLoaiBUS();
	    ArrayList<NhaCungCapDTO> listNCC = phanLoaiBUS.listNCC();
	    
	    // Hiển thị dữ liệu lên bảng
	    initTable(listNCC);
	}
	public void ReloadNSX() {
	    // Xóa nội dung của các trường nhập liệu
	    textField_maNSX.setText("");
	    textField_maNSX.setEditable(true);
	    textField_maNSX.setEnabled(true);
	    textField_tenNSX.setText("");

	    // Focus vào trường mã NSX
	    textField_maNSX.requestFocus();

	    // Tải lại dữ liệu từ cơ sở dữ liệu
	    PhanLoaiBUS phanLoaiBUS = new PhanLoaiBUS();
	    ArrayList<NhaSanXuatDTO> listNSX = phanLoaiBUS.listNSX();

	    // Hiển thị dữ liệu lên bảng nhà sản xuất
	    initTableNSX(listNSX);
	}

	private void initTableNSX(ArrayList<NhaSanXuatDTO> listNSX) {
	    DefaultTableModel model = new DefaultTableModel();
	    model.addColumn("Mã NSX");
	    model.addColumn("Tên NSX");
	    
	    for (NhaSanXuatDTO nsx : listNSX) {
	        model.addRow(new Object[] { nsx.getMaNSX(), nsx.getTenNSX() });
	    }
	    
	    // Sử dụng tableNSX thay vì table
	    tableNSX.setModel(model);
	    tableNSX.setAutoCreateRowSorter(true);
	}

	public void ReloadLoai() {
		textField_maLoai.setText("");
		textField_maLoai.setEditable(true);
		textField_maLoai.setEnabled(true);
	    textField_tenLoai.setText("");
	    

	    // Focus vào trường mã NCC
	    textField_maLoai.requestFocus();
	    
	    // Tải lại dữ liệu từ cơ sở dữ liệu
	    PhanLoaiBUS phanLoaiBUS = new PhanLoaiBUS();
	    ArrayList<LoaiDTO> listLoai = phanLoaiBUS.listLoai();
	    
	    // Hiển thị dữ liệu lên bảng
	    initTableLoai(listLoai);
	}
	private void initTableLoai(ArrayList<LoaiDTO> listLoai) {
		DefaultTableModel model = new DefaultTableModel();
	    model.addColumn("Mã Loại");
	    model.addColumn("Tên Loại");
	    
	    for (LoaiDTO loai : listLoai) {
	        model.addRow(new Object[] { loai.getMaLoai(), loai.getTenLoai() });
	    }
	    
	    tableLoai.setModel(model);
	    tableLoai.setAutoCreateRowSorter(true);
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
	    	if(!phanLoaiBUS.checkMaNCC(textFieldMaNCC.getText())) {
	        String maNCC = textFieldMaNCC.getText();
	        String tenNCC = textFieldTenNCC.getText();
	        String diaChiNCC = textFieldDiaChi.getText();
	        String soDienThoaiNCC = textField_SDT.getText();
	        String ghiChuNCC = textArea.getText();

	        NhaCungCapDTO ncc = new NhaCungCapDTO(maNCC, tenNCC, diaChiNCC, soDienThoaiNCC, ghiChuNCC);
	        phanLoaiBUS.addNCC(ncc);
	        JOptionPane.showMessageDialog(null, "Thêm thành công", "Thông báo", JOptionPane.DEFAULT_OPTION);
	        Reload();
	    }else {
	    	JOptionPane.showMessageDialog(null, "Mã nhà cung cấp bị trùng","Thông báo", JOptionPane.DEFAULT_OPTION);
	    }
	} else {
        // Hiển thị thông báo nếu có trường dữ liệu trống
        JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ thông tin", "Thông báo", JOptionPane.DEFAULT_OPTION);
    }
	}
	public void ThemNSX() {
	    // Kiểm tra các trường dữ liệu có trống không
	    if (KiemTraTrongNSX()) {
	        // Kiểm tra xem mã nhà sản xuất đã tồn tại chưa
	        if(!phanLoaiBUS.checkMaNSX(textField_maNSX.getText())) {
	            String maNSX = textField_maNSX.getText();
	            String tenNSX = textField_tenNSX.getText();

	            // Tạo đối tượng NhaSanXuatDTO
	            NhaSanXuatDTO nsx = new NhaSanXuatDTO(maNSX, tenNSX);

	            // Thêm nhà sản xuất vào cơ sở dữ liệu thông qua lớp PhanLoaiBUS
	            phanLoaiBUS.addNSX(nsx);

	            // Hiển thị thông báo thành công
	            JOptionPane.showMessageDialog(null, "Thêm nhà sản xuất thành công", "Thông báo", JOptionPane.DEFAULT_OPTION);

	            // Tải lại bảng
	            ReloadNSX();
	        } else {
	            // Hiển thị thông báo nếu mã nhà sản xuất đã tồn tại
	            JOptionPane.showMessageDialog(null, "Mã nhà sản xuất bị trùng", "Thông báo", JOptionPane.DEFAULT_OPTION);
	        }
	    } else {
	        // Hiển thị thông báo nếu có trường dữ liệu trống
	        JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ thông tin", "Thông báo", JOptionPane.DEFAULT_OPTION);
	    }
	}

	public void ThemLoai() {
	    // Kiểm tra các trường dữ liệu có trống không
	    if (KiemTraTrongLoai()) {
	        // Kiểm tra xem mã loại đã tồn tại chưa
	        if(!phanLoaiBUS.checkMaLoai(textField_maLoai.getText())) {
	            String maLoai = textField_maLoai.getText();
	            String tenLoai = textField_tenLoai.getText();

	            // Tạo đối tượng LoaiDTO
	            LoaiDTO loai = new LoaiDTO(maLoai, tenLoai);

	            // Thêm loại vào cơ sở dữ liệu thông qua lớp PhanLoaiBUS
	            phanLoaiBUS.addLoai(loai);

	            // Hiển thị thông báo thành công
	            JOptionPane.showMessageDialog(null, "Thêm loại thành công", "Thông báo", JOptionPane.DEFAULT_OPTION);

	            // Tải lại bảng
	            ReloadLoai();
	        } else {
	            // Hiển thị thông báo nếu mã loại đã tồn tại
	            JOptionPane.showMessageDialog(null, "Mã loại bị trùng", "Thông báo", JOptionPane.DEFAULT_OPTION);
	        }
	    } else {
	        // Hiển thị thông báo nếu có trường dữ liệu trống
	        JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ thông tin", "Thông báo", JOptionPane.DEFAULT_OPTION);
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
	        phanLoaiBUS.updateNCC(ncc);
	        JOptionPane.showMessageDialog(null, "Sửa thành công", "Thông báo", JOptionPane.DEFAULT_OPTION);
	        Reload();
	    }
	}

	private void Xoa() {
	    if (textFieldMaNCC.getText() != null && !textFieldMaNCC.getText().isEmpty()) {
	        // Kiểm tra xem có ràng buộc khóa ngoại hay không
	        if (phanLoaiBUS.checkDataIsReferenced_NCC(textFieldMaNCC.getText())) {
	            JOptionPane.showMessageDialog(null, "Không thể xoá nhà cung cấp này vì có dữ liệu liên quan trong bảng khác.", "Thông báo", JOptionPane.WARNING_MESSAGE);
	        } else {
	            // Xoá nhà cung cấp nếu không có ràng buộc khóa ngoại
	            phanLoaiBUS.deleteNCC(textFieldMaNCC.getText());
	            JOptionPane.showMessageDialog(null, "Xóa thành công", "Thông báo", JOptionPane.DEFAULT_OPTION);
	            Reload();
	        }
	    } else {
	        JOptionPane.showMessageDialog(null, "Vui lòng chọn một nhà cung cấp để xóa", "Thông báo", JOptionPane.DEFAULT_OPTION);
	    }
	}
	public void SuaNSX() {
	    if (KiemTraTrongNSX()) {
	        String maNSX = textField_maNSX.getText();
	        String tenNSX = textField_tenNSX.getText();

	        // Tạo đối tượng NhaSanXuatDTO
	        NhaSanXuatDTO nsx = new NhaSanXuatDTO(maNSX, tenNSX);

	        // Sửa thông tin nhà sản xuất trong cơ sở dữ liệu thông qua lớp PhanLoaiBUS
	        phanLoaiBUS.updateNSX(nsx);

	        // Hiển thị thông báo thành công
	        JOptionPane.showMessageDialog(null, "Sửa nhà sản xuất thành công", "Thông báo", JOptionPane.DEFAULT_OPTION);

	        // Tải lại bảng
	        ReloadNSX();
	    }
	}

	public void XoaNSX() {
	    if (textField_maNSX.getText() != null && !textField_maNSX.getText().isEmpty()) {
	        // Kiểm tra xem có ràng buộc khóa ngoại hay không
	        if (phanLoaiBUS.checkDataIsReferenced_NSX(textField_maNSX.getText())) {
	            JOptionPane.showMessageDialog(null, "Không thể xoá nhà sản xuất này vì có dữ liệu liên quan trong bảng khác.", "Thông báo", JOptionPane.WARNING_MESSAGE);
	        } else {
	            // Xoá nhà sản xuất nếu không có ràng buộc khóa ngoại
	            phanLoaiBUS.deleteNSX(textField_maNSX.getText());
	            JOptionPane.showMessageDialog(null, "Xóa nhà sản xuất thành công", "Thông báo", JOptionPane.DEFAULT_OPTION);
	            ReloadNSX();
	        }
	    } else {
	        JOptionPane.showMessageDialog(null, "Vui lòng chọn một nhà sản xuất để xóa", "Thông báo", JOptionPane.DEFAULT_OPTION);
	    }
	}

	public void SuaLoai() {
	    if (KiemTraTrongLoai()) {
	        String maLoai = textField_maLoai.getText();
	        String tenLoai = textField_tenLoai.getText();

	        // Tạo đối tượng LoaiDTO
	        LoaiDTO loai = new LoaiDTO(maLoai, tenLoai);

	        // Sửa thông tin loại trong cơ sở dữ liệu thông qua lớp PhanLoaiBUS
	        phanLoaiBUS.updateLoai(loai);

	        // Hiển thị thông báo thành công
	        JOptionPane.showMessageDialog(null, "Sửa loại thành công", "Thông báo", JOptionPane.DEFAULT_OPTION);

	        // Tải lại bảng
	        ReloadLoai();
	    }
	}

	public void XoaLoai() {
	    if (textField_maLoai.getText() != null && !textField_maLoai.getText().isEmpty()) {
	        // Kiểm tra xem có ràng buộc khóa ngoại hay không
	        if (phanLoaiBUS.checkDataIsReferenced_Loai(textField_maLoai.getText())) {
	            JOptionPane.showMessageDialog(null, "Không thể xoá loại này vì có dữ liệu liên quan trong bảng khác.", "Thông báo", JOptionPane.WARNING_MESSAGE);
	        } else {
	            // Xoá loại nếu không có ràng buộc khóa ngoại
	            phanLoaiBUS.deleteLoai(textField_maLoai.getText());
	            JOptionPane.showMessageDialog(null, "Xóa loại thành công", "Thông báo", JOptionPane.DEFAULT_OPTION);
	            ReloadLoai();
	        }
	    } else {
	        JOptionPane.showMessageDialog(null, "Vui lòng chọn một loại để xóa", "Thông báo", JOptionPane.DEFAULT_OPTION);
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

	public void addMouseListenerToTableNSX() {
	    tableNSX.addMouseListener(new MouseAdapter() {
	        @Override
	        public void mouseClicked(MouseEvent evt) {
	            int index = tableNSX.getSelectedRow();
	            if (index >= 0) {
	                // Lấy dữ liệu từ hàng được chọn và hiển thị trên các thành phần giao diện
	                String maNSX = (String) tableNSX.getValueAt(index, 0);
	                String tenNSX = (String) tableNSX.getValueAt(index, 1);

	                // Hiển thị dữ liệu trên các thành phần giao diện
	                textField_maNSX.setText(maNSX);
	                textField_tenNSX.setText(tenNSX);
	            }
	        }
	    });
	}


	
	public void addMouseListenerToTableLoai() {
	    tableLoai.addMouseListener(new MouseAdapter() {
	        @Override
	        public void mouseClicked(MouseEvent evt) {
	            int index = tableLoai.getSelectedRow(); // Thay đổi từ table thành tableLoai
	            if (index >= 0) { 
	                // Lấy dữ liệu từ hàng được chọn và hiển thị trên các thành phần giao diện
	                String maLoai = (String) tableLoai.getValueAt(index, 0);
	                String tenLoai = (String) tableLoai.getValueAt(index, 1);

	                // Hiển thị dữ liệu trên các thành phần giao diện
	                textField_maLoai.setText(maLoai);
	                textField_tenLoai.setText(tenLoai);
	            }
	        }
	    });
	}



	private void searchAndUpdateTable() {
	    String selectedOption = comboBox_NCC.getSelectedItem().toString();
	    String keyword = textField_NCC.getText().trim();
	    
	    // Kiểm tra nếu chọn mục khác "Tất cả" và không có từ khóa tìm kiếm thì không hiển thị bảng
	    if (!selectedOption.equals("Tất cả") && keyword.isEmpty()) {
	        // Không cần thực hiện tìm kiếm, chỉ cần xóa dữ liệu trong bảng
	        DefaultTableModel model = (DefaultTableModel) table.getModel();
	        model.setRowCount(0);
	        return;
	    }
	    
	    // Thực hiện tìm kiếm
	    ArrayList<NhaCungCapDTO> searchResult = phanLoaiBUS.searchNCC(selectedOption, keyword);
	    
	    // Cập nhật bảng hiển thị
	    initTable(searchResult);
	}
	
	private void searchAndUpdateTableNSX() {
	    String selectedOption = comboBoxNSX.getSelectedItem().toString();
	    String keyword = textFieldNSX.getText().trim();
	    
	    // Kiểm tra nếu chọn mục khác "Tất cả" và không có từ khóa tìm kiếm thì không hiển thị bảng
	    if (!selectedOption.equals("Tất cả") && keyword.isEmpty()) {
	        // Không cần thực hiện tìm kiếm, chỉ cần xóa dữ liệu trong bảng
	        DefaultTableModel model = (DefaultTableModel) tableNSX.getModel();
	        model.setRowCount(0);
	        return;
	    }
	    
	    // Thực hiện tìm kiếm
	    ArrayList<NhaSanXuatDTO> searchResult = phanLoaiBUS.searchNSX(selectedOption, keyword);
	    
	    // Cập nhật bảng hiển thị
	    initTableNSX(searchResult);
	}

	private void searchAndUpdateTableLoai() {
	    String selectedOption = comboBox_Loai.getSelectedItem().toString();
	    String keyword = textField_Loai.getText().trim();
	    
	    // Kiểm tra nếu chọn mục khác "Tất cả" và không có từ khóa tìm kiếm thì không hiển thị bảng
	    if (!selectedOption.equals("Tất cả") && keyword.isEmpty()) {
	        // Không cần thực hiện tìm kiếm, chỉ cần xóa dữ liệu trong bảng
	        DefaultTableModel model = (DefaultTableModel) tableLoai.getModel();
	        model.setRowCount(0);
	        return;
	    }
	    
	    // Thực hiện tìm kiếm
	    ArrayList<LoaiDTO> searchResult = phanLoaiBUS.searchLoai(selectedOption, keyword);
	    
	    // Cập nhật bảng hiển thị
	    initTableLoai(searchResult);
	}
}