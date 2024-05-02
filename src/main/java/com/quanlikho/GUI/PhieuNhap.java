package com.quanlikho.GUI;



import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.BorderLayout;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.BoxLayout;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.Rectangle;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JFormattedTextField;
import java.awt.Font;
import java.awt.Component;

public class PhieuNhap extends JPanel {
	// public static void main(String[] args) {
	// 	JFrame frame = new JFrame("Ứng dụng nhập hàng");
    //     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    //     // Tạo một instance của panel NhapHang
    //     PhieuNhap PhieuNhapPanel = new PhieuNhap();
        
    //     // Thêm panel vào frame
    //     frame.getContentPane().add(PhieuNhapPanel);

    //     // Thiết lập kích thước của frame và hiển thị nó
    //     frame.setSize(1280, 850);
    //     frame.setVisible(true);
	// }

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JComboBox comboBox;

	/**
	 * Create the panel.
	 */
	public PhieuNhap() {
        // Đặt kích thước cho JPanel
		setBounds(0,0, 1068, 693);
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
        
        JButton btnThem = new JButton("Xem chi tiết", new ImageIcon(PhieuNhap.class.getResource("/com/quanlikho/Item/icons8_eye_40px.png")));
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
        comboBox.setBounds(22, 26, 137, 28);
        panel_1.add(comboBox);
        
        textField = new JTextField();
        textField.setBounds(171, 27, 122, 28);
        panel_1.add(textField);
        textField.setColumns(10);
        
        JButton btnReset = new JButton("Làm mới");
        btnReset.setBounds(322, 24, 122, 33);
        btnReset.setIcon(new ImageIcon(NhaCungCap.class.getResource("/com/quanlikho/Item/icons8_reset_25px_1.png")));
        panel_1.add(btnReset);
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.add(panel_2);
        panel.add(panel_1);
        
        JPanel panel_3 = new JPanel();
        add(panel_3, BorderLayout.CENTER);
        panel_3.setLayout(null);
        
        JPanel panel_1_1 = new JPanel();
        panel_1_1.setBounds(0, 10, 515, 68);
        panel_1_1.setLayout(null);
        panel_1_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "L\u1ECDc theo ng\u00E0y", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
        panel_3.add(panel_1_1);
        
        JFormattedTextField formattedTextField = new JFormattedTextField();
        formattedTextField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        formattedTextField.setBounds(78, 28, 147, 27);
        panel_1_1.add(formattedTextField);
        
        JLabel lblNewLabel = new JLabel("Từ ngày");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel.setBounds(10, 31, 71, 17);
        panel_1_1.add(lblNewLabel);
        
        JFormattedTextField formattedTextField_1 = new JFormattedTextField();
        formattedTextField_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        formattedTextField_1.setBounds(343, 28, 147, 27);
        panel_1_1.add(formattedTextField_1);
        
        JLabel lblnNgy = new JLabel("Đến ngày");
        lblnNgy.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblnNgy.setBounds(246, 33, 71, 17);
        panel_1_1.add(lblnNgy);
        
        JPanel panel_1_1_1 = new JPanel();
        panel_1_1_1.setLayout(null);
        panel_1_1_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "L\u1ECDc theo gi\u00E1", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
        panel_1_1_1.setBounds(525, 10, 543, 68);
        panel_3.add(panel_1_1_1);
        
        JLabel lblT = new JLabel("Từ");
        lblT.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblT.setBounds(10, 31, 71, 17);
        panel_1_1_1.add(lblT);
        
        JLabel lbln = new JLabel("Đến");
        lbln.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lbln.setBounds(252, 31, 71, 17);
        panel_1_1_1.add(lbln);
        
        JFormattedTextField formattedTextField_1_2 = new JFormattedTextField();
        formattedTextField_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        formattedTextField_1_2.setBounds(61, 26, 147, 27);
        panel_1_1_1.add(formattedTextField_1_2);
        
        JFormattedTextField formattedTextField_1_2_1 = new JFormattedTextField();
        formattedTextField_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        formattedTextField_1_2_1.setBounds(333, 26, 147, 27);
        panel_1_1_1.add(formattedTextField_1_2_1);
        
        JTable table = new JTable(new DefaultTableModel(
            	new Object[][] {
            	},
            	new String[] {
            		"STT", "Mã phiếu nhập", "Nhà cung cấp", "Thời gian tạo", "Tổng tiền"
            	}
            ));
            JScrollPane scrollPane = new JScrollPane(table); // Đặt table vào trong JScrollPane
            panel_3.add(scrollPane);
            scrollPane.setBounds(0, 81, 1064, 519);
        
	}
}
