package com.quanlikho.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.border.MatteBorder;
import com.quanlikho.BUS.*;

public class Admin extends JFrame {
	Color DefaultColor = new Color(0, 128, 64);
	Color ClickedColor = Color.GRAY;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel PanelSanPham;
	private JPanel PanelPhieuNhap;
	private JPanel PanelPhanLoai;
	private JPanel PanelNhapHang;
	private JPanel PanelXuatHang;
	private JPanel PanelPhieuXuat;
	private JPanel PanelThongKe;
	private JPanel PanelTonKho;
	private JPanel Paneldangxuat;
	private JPanel Paneldoithongtin;
	private JPanel MainContent;
	private PhanLoai phanLoai;
	private SanPham sanPham;
	private NhapHang nhapHang;
	private PhieuNhap phieuNhap;
	private PhieuXuat phieuXuat;
	private ThongKe thongKe;
	private TonKho tonKho;
	private XuatHang xuatHang;

	private DaiLy daiLy;
	public JLabel lblTen;
	private JPanel PanelAccount;
	private JLabel lblAccount;
	private TaiKhoan taiKhoan;
	private JPanel PanelDaiLy;
	private JLabel lbliL;

	private DoiThongTin doiThongTin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
							.getInstalledLookAndFeels()) {
						if ("Nimbus".equals(info.getName())) {
							javax.swing.UIManager.setLookAndFeel(info.getClassName());
							break;
						}
					}
					final Admin frame = new Admin();
					frame.setVisible(true);
					frame.addWindowListener(new WindowAdapter() {
						public void windowClosing(WindowEvent e) {
							int result = JOptionPane.showConfirmDialog(frame, "Bạn có chắc muốn thoát?", "Xác nhận",
									JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
							if (result == JOptionPane.YES_OPTION) {
								frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
							} else {
								frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
							}
						}
					});
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Admin() {

//		panel.setBounds(20, 10, 317, 750);
//		panel_1.setBounds(327,10,1180,750);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1406, 735);
		setTitle("Admin");
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setResizable(false);

		setContentPane(contentPane);
		contentPane.setLayout(null);

		MainContent = new JPanel();
		MainContent.setBounds(325, 5, 1180, 750);
		MainContent.setBackground(new Color(255, 255, 255));

		contentPane.add(MainContent);
		MainContent.setLayout(null);

		SanPham pf = new SanPham();
		pf.setBounds(0, 0, 1180, 693);
		MainContent.add(pf);

		JPanel panel = new JPanel();
		panel.setBounds(5, 5, 317, 690);
		panel.setBackground(new Color(0, 128, 64));

		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("XIN CHÀO");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 10, 297, 47);
		panel.add(lblNewLabel);

		lblTen = new JLabel("");
		lblTen.setForeground(new Color(255, 255, 255));
		lblTen.setHorizontalAlignment(SwingConstants.LEFT);
		lblTen.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblTen.setBounds(93, 47, 214, 47);
		panel.add(lblTen);

		PanelSanPham = new JPanel();
		PanelSanPham.setBackground(new Color(0, 128, 64));
		PanelSanPham.setBounds(10, 112, 297, 37);
		panel.add(PanelSanPham);
		PanelSanPham.setLayout(null);
		PanelSanPham.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		PanelSanPham.setBackground(ClickedColor);
		PanelSanPham.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				SanPhamMousePressed(e);
			}

			public void mouseClicked(MouseEvent e) {
				SanPhamMouseClicked(e);
			}
		});

		JLabel lblSanPham = new JLabel("SẢN PHẨM");
		lblSanPham.setIcon(new ImageIcon(Admin.class.getResource("/com/quanlikho/Item/delivery-box_24.png")));
		lblSanPham.setForeground(new Color(255, 255, 255));
		lblSanPham.setFont(new Font("Verdana", Font.BOLD, 15));
		lblSanPham.setHorizontalAlignment(SwingConstants.LEFT);
		lblSanPham.setBounds(54, 0, 138, 37);
		PanelSanPham.add(lblSanPham);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(255, 255, 255)));
		lblNewLabel_2.setBounds(0, 89, 317, 13);
		panel.add(lblNewLabel_2);

		PanelPhieuNhap = new JPanel();
		PanelPhieuNhap.setLayout(null);
		PanelPhieuNhap.setBorder(null);
		PanelPhieuNhap.setBackground(new Color(0, 128, 64));
		PanelPhieuNhap.setBounds(10, 253, 297, 37);
		panel.add(PanelPhieuNhap);
		PanelPhieuNhap.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		PanelPhieuNhap.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				PhieuNhapMousePressed(e);
			}

			public void mouseClicked(MouseEvent e) {
				PhieuNhapMouseClicked(e);
			}
		});

		JLabel lblPhieuNhap = new JLabel("PHIẾU NHẬP");
		lblPhieuNhap.setBounds(57, 0, 166, 37);
		PanelPhieuNhap.add(lblPhieuNhap);
		lblPhieuNhap.setIcon(new ImageIcon(Admin.class.getResource("/com/quanlikho/Item/gift-voucher_24.png")));
		lblPhieuNhap.setHorizontalAlignment(SwingConstants.LEFT);
		lblPhieuNhap.setForeground(Color.WHITE);
		lblPhieuNhap.setFont(new Font("Verdana", Font.BOLD, 15));

		PanelPhanLoai = new JPanel();
		PanelPhanLoai.setLayout(null);
		PanelPhanLoai.setBorder(null);
		PanelPhanLoai.setBackground(new Color(0, 128, 64));
		PanelPhanLoai.setBounds(10, 159, 297, 37);
		panel.add(PanelPhanLoai);
		PanelPhanLoai.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		PanelPhanLoai.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				NhaCungCapMousePressed(e);
			}

			public void mouseClicked(MouseEvent e) {
				NhaCungCapMouseClicked(e);
			}
		});
		JLabel lblPhanLoai = new JLabel("PHÂN LOẠI");
		lblPhanLoai.setIcon(new ImageIcon(Admin.class.getResource("/com/quanlikho/Item/data-classification_24.png")));
		lblPhanLoai.setHorizontalAlignment(SwingConstants.LEFT);
		lblPhanLoai.setForeground(Color.WHITE);
		lblPhanLoai.setFont(new Font("Verdana", Font.BOLD, 15));
		lblPhanLoai.setBounds(56, 0, 186, 37);
		PanelPhanLoai.add(lblPhanLoai);

		PanelNhapHang = new JPanel();
		PanelNhapHang.setLayout(null);
		PanelNhapHang.setBorder(null);
		PanelNhapHang.setBackground(new Color(0, 128, 64));
		PanelNhapHang.setBounds(10, 206, 297, 37);
		panel.add(PanelNhapHang);
		PanelNhapHang.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		PanelNhapHang.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				NhapHangMousePressed(e);
			}

			public void mouseClicked(MouseEvent e) {
				NhapHangMouseClicked(e);
			}
		});

		JLabel lblNhapHang = new JLabel("NHẬP HÀNG");
		lblNhapHang.setIcon(new ImageIcon(Admin.class.getResource("/com/quanlikho/Item/PhieuNhap_24.png")));
		lblNhapHang.setHorizontalAlignment(SwingConstants.LEFT);
		lblNhapHang.setForeground(Color.WHITE);
		lblNhapHang.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNhapHang.setBounds(56, 0, 160, 37);
		PanelNhapHang.add(lblNhapHang);

		PanelXuatHang = new JPanel();
		PanelXuatHang.setLayout(null);
		PanelXuatHang.setBorder(null);
		PanelXuatHang.setBackground(new Color(0, 128, 64));
		PanelXuatHang.setBounds(10, 300, 297, 37);
		panel.add(PanelXuatHang);
		PanelXuatHang.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		PanelXuatHang.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				XuatHangMousePressed(e);
			}

			public void mouseClicked(MouseEvent e) {
				XuatHangMouseClicked(e);
			}
		});

		JLabel lblXuatHang = new JLabel("XUẤT HÀNG");
		lblXuatHang.setIcon(new ImageIcon(Admin.class.getResource("/com/quanlikho/Item/XuatHang_24.png")));
		lblXuatHang.setHorizontalAlignment(SwingConstants.LEFT);
		lblXuatHang.setForeground(Color.WHITE);
		lblXuatHang.setFont(new Font("Verdana", Font.BOLD, 15));
		lblXuatHang.setBounds(57, 0, 166, 37);
		PanelXuatHang.add(lblXuatHang);

		PanelPhieuXuat = new JPanel();
		PanelPhieuXuat.setLayout(null);
		PanelPhieuXuat.setBorder(null);
		PanelPhieuXuat.setBackground(new Color(0, 128, 64));
		PanelPhieuXuat.setBounds(10, 347, 297, 37);
		panel.add(PanelPhieuXuat);
		PanelPhieuXuat.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		PanelPhieuXuat.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				PhieuXuatMousePressed(e);
			}

			public void mouseClicked(MouseEvent e) {
				PhieuXuatMouseClicked(e);
			}
		});

		JLabel lblPhieuXuat = new JLabel("PHIẾU XUẤT");
		lblPhieuXuat.setIcon(new ImageIcon(Admin.class.getResource("/com/quanlikho/Item/bill_24.png")));
		lblPhieuXuat.setHorizontalAlignment(SwingConstants.LEFT);
		lblPhieuXuat.setForeground(Color.WHITE);
		lblPhieuXuat.setFont(new Font("Verdana", Font.BOLD, 15));
		lblPhieuXuat.setBounds(57, 0, 166, 37);
		PanelPhieuXuat.add(lblPhieuXuat);

		PanelThongKe = new JPanel();
		PanelThongKe.setLayout(null);
		PanelThongKe.setBorder(null);
		PanelThongKe.setBackground(new Color(0, 128, 64));
		PanelThongKe.setBounds(10, 441, 297, 37);
		panel.add(PanelThongKe);
		PanelThongKe.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		PanelThongKe.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				ThongKeMousePressed(e);
			}

			public void mouseClicked(MouseEvent e) {
				ThongKeMouseClicked(e);
			}
		});
		JLabel lblThongKe = new JLabel("THỐNG KÊ");
		lblThongKe.setIcon(new ImageIcon(Admin.class.getResource("/com/quanlikho/Item/thongke_24.png")));
		lblThongKe.setHorizontalAlignment(SwingConstants.LEFT);
		lblThongKe.setForeground(Color.WHITE);
		lblThongKe.setFont(new Font("Verdana", Font.BOLD, 15));
		lblThongKe.setBounds(57, 0, 166, 37);
		PanelThongKe.add(lblThongKe);

		PanelTonKho = new JPanel();
		PanelTonKho.setLayout(null);
		PanelTonKho.setBorder(null);
		PanelTonKho.setBackground(new Color(0, 128, 64));
		PanelTonKho.setBounds(10, 394, 297, 37);
		panel.add(PanelTonKho);
		PanelTonKho.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		PanelTonKho.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				TonKhoMousePressed(e);
			}

			public void mouseClicked(MouseEvent e) {
				TonKhoMouseClicked(e);
			}
		});

		JLabel lblTongKho = new JLabel("TỒN KHO");
		lblTongKho.setIcon(new ImageIcon(Admin.class.getResource("/com/quanlikho/Item/tongkho_24.png")));
		lblTongKho.setHorizontalAlignment(SwingConstants.LEFT);
		lblTongKho.setForeground(Color.WHITE);
		lblTongKho.setFont(new Font("Verdana", Font.BOLD, 15));
		lblTongKho.setBounds(57, 0, 166, 37);
		PanelTonKho.add(lblTongKho);

		JLabel lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(255, 255, 255)));
		lblNewLabel_2_1.setBounds(0, 580, 317, 13);
		panel.add(lblNewLabel_2_1);

		Paneldangxuat = new JPanel();
		Paneldangxuat.setLayout(null);
		Paneldangxuat.setBorder(null);
		Paneldangxuat.setBackground(new Color(0, 128, 64));
		Paneldangxuat.setBounds(10, 649, 297, 37);
		panel.add(Paneldangxuat);
		Paneldangxuat.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		Paneldangxuat.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn đăng xuất?", "Xác nhận",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (result == JOptionPane.YES_OPTION) {
					setVisible(false);
					login Login = new login();
					Login.setVisible(true);
				}
			}
		});

		JLabel lbldangxuat = new JLabel("ĐĂNG XUẤT");
		lbldangxuat.setIcon(new ImageIcon(Admin.class.getResource("/com/quanlikho/Item/logout_24.png")));
		lbldangxuat.setHorizontalAlignment(SwingConstants.LEFT);
		lbldangxuat.setForeground(Color.WHITE);
		lbldangxuat.setFont(new Font("Verdana", Font.BOLD, 15));
		lbldangxuat.setBounds(57, 0, 166, 37);
		Paneldangxuat.add(lbldangxuat);

		Paneldoithongtin = new JPanel();
		Paneldoithongtin.setLayout(null);
		Paneldoithongtin.setBorder(null);
		Paneldoithongtin.setBackground(new Color(0, 128, 64));
		Paneldoithongtin.setBounds(10, 603, 297, 37);
		panel.add(Paneldoithongtin);
		Paneldoithongtin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

		JLabel lblDoiThongTin = new JLabel("ĐỔI THÔNG TIN");
		lblDoiThongTin.setBounds(57, 0, 199, 37);
		Paneldoithongtin.add(lblDoiThongTin);
		lblDoiThongTin.setIcon(new ImageIcon(Admin.class.getResource("/com/quanlikho/Item/doimatkhau_24.png")));
		lblDoiThongTin.setHorizontalAlignment(SwingConstants.LEFT);
		lblDoiThongTin.setForeground(Color.WHITE);
		lblDoiThongTin.setFont(new Font("Verdana", Font.BOLD, 15));
		Paneldoithongtin.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				DoiThongTinMousePressed(e);
			}

		});

		PanelAccount = new JPanel();
		PanelAccount.setLayout(null);
		PanelAccount.setBorder(null);
		PanelAccount.setBackground(new Color(0, 128, 64));
		PanelAccount.setBounds(10, 539, 297, 37);
		panel.add(PanelAccount);
		PanelAccount.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		PanelAccount.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				AccountMousePressed(e);
			}

			public void mouseClicked(MouseEvent e) {
				AccountMouseClicked(e);
			}
		});

		lblAccount = new JLabel("TÀi KHOẢN");
		lblAccount.setIcon(new ImageIcon(Admin.class.getResource("/com/quanlikho/Item/accountable_24.png")));
		lblAccount.setHorizontalAlignment(SwingConstants.LEFT);
		lblAccount.setForeground(Color.WHITE);
		lblAccount.setFont(new Font("Verdana", Font.BOLD, 15));
		lblAccount.setBounds(57, 0, 166, 37);
		PanelAccount.add(lblAccount);

		PanelDaiLy = new JPanel();
		PanelDaiLy.setLayout(null);
		PanelDaiLy.setBorder(null);
		PanelDaiLy.setBackground(new Color(0, 128, 64));
		PanelDaiLy.setBounds(10, 492, 297, 37);
		panel.add(PanelDaiLy);
		PanelDaiLy.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				DaiLyMousePressed(e);
			}

			public void mouseClicked(MouseEvent e) {
				DaiLyMouseClicked(e);
			}
		});

		lbliL = new JLabel("ĐẠI LÝ");
		lbliL.setIcon(new ImageIcon(Admin.class.getResource("/com/quanlikho/Item/company_24.png")));
		lbliL.setHorizontalAlignment(SwingConstants.LEFT);
		lbliL.setForeground(Color.WHITE);
		lbliL.setFont(new Font("Verdana", Font.BOLD, 15));
		lbliL.setBounds(57, 0, 166, 37);
		PanelDaiLy.add(lbliL);

		JLabel lblNewLabel_1 = new JLabel("Xin Chào:");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel_1.setBounds(10, 47, 89, 47);
		panel.add(lblNewLabel_1);

	}

	public void SanPhamMousePressed(MouseEvent evt) {
		PanelSanPham.setBackground(ClickedColor);
		PanelPhieuNhap.setBackground(DefaultColor);
		PanelNhapHang.setBackground(DefaultColor);
		PanelXuatHang.setBackground(DefaultColor);
		PanelPhieuXuat.setBackground(DefaultColor);
		PanelPhanLoai.setBackground(DefaultColor);
		PanelTonKho.setBackground(DefaultColor);
		PanelThongKe.setBackground(DefaultColor);
		Paneldoithongtin.setBackground(DefaultColor);
		PanelAccount.setBackground(DefaultColor);
		PanelDaiLy.setBackground(DefaultColor);
		MainContent.removeAll();
		sanPham = new SanPham();
		MainContent.add(sanPham).setVisible(true);
		MainContent.revalidate();
		MainContent.repaint();

	}

	public void SanPhamMouseClicked(MouseEvent evt) {
		// TODO add your handling code here:
		MainContent.removeAll();
		sanPham = new SanPham();
		MainContent.add(sanPham).setVisible(true);
		MainContent.revalidate();
		MainContent.repaint();
	}

	public void NhaCungCapMousePressed(MouseEvent evt) {
		PanelSanPham.setBackground(DefaultColor);
		PanelPhieuNhap.setBackground(DefaultColor);
		PanelNhapHang.setBackground(DefaultColor);
		PanelXuatHang.setBackground(DefaultColor);
		PanelPhieuXuat.setBackground(DefaultColor);
		PanelPhanLoai.setBackground(ClickedColor);
		PanelTonKho.setBackground(DefaultColor);
		PanelThongKe.setBackground(DefaultColor);
		Paneldoithongtin.setBackground(DefaultColor);
		PanelAccount.setBackground(DefaultColor);
		PanelDaiLy.setBackground(DefaultColor);
		MainContent.removeAll();
		phanLoai = new PhanLoai();
		MainContent.add(phanLoai).setVisible(true);
		MainContent.revalidate();
		MainContent.repaint();

	}

	public void NhaCungCapMouseClicked(MouseEvent evt) {
		// TODO add your handling code here:
		MainContent.removeAll();
		phanLoai = new PhanLoai();
		MainContent.add(phanLoai).setVisible(true);
		MainContent.revalidate();
		MainContent.repaint();
	}

	public void NhapHangMousePressed(MouseEvent evt) {
		PanelSanPham.setBackground(DefaultColor);
		PanelPhieuNhap.setBackground(DefaultColor);
		PanelNhapHang.setBackground(ClickedColor);
		PanelXuatHang.setBackground(DefaultColor);
		PanelPhieuXuat.setBackground(DefaultColor);
		PanelPhanLoai.setBackground(DefaultColor);
		PanelTonKho.setBackground(DefaultColor);
		PanelThongKe.setBackground(DefaultColor);
		Paneldoithongtin.setBackground(DefaultColor);
		PanelAccount.setBackground(DefaultColor);
		PanelDaiLy.setBackground(DefaultColor);
		MainContent.removeAll();
		nhapHang = new NhapHang();
		MainContent.add(nhapHang).setVisible(true);
		MainContent.revalidate();
		MainContent.repaint();
		nhapHang.txtVvjvjv_1.setText(lblTen.getText());

	}

	public void NhapHangMouseClicked(MouseEvent evt) {
		// TODO add your handling code here:
		MainContent.removeAll();
		nhapHang = new NhapHang();
		MainContent.add(nhapHang).setVisible(true);
		MainContent.revalidate();
		MainContent.repaint();
		nhapHang.txtVvjvjv_1.setText(lblTen.getText());
	}

	public void PhieuNhapMousePressed(MouseEvent evt) {
		PanelSanPham.setBackground(DefaultColor);
		PanelPhieuNhap.setBackground(ClickedColor);
		PanelNhapHang.setBackground(DefaultColor);
		PanelXuatHang.setBackground(DefaultColor);
		PanelPhieuXuat.setBackground(DefaultColor);
		PanelPhanLoai.setBackground(DefaultColor);
		PanelTonKho.setBackground(DefaultColor);
		PanelThongKe.setBackground(DefaultColor);
		Paneldoithongtin.setBackground(DefaultColor);
		PanelAccount.setBackground(DefaultColor);
		PanelDaiLy.setBackground(DefaultColor);
		MainContent.removeAll();
		phieuNhap = new PhieuNhap();

		MainContent.add(phieuNhap).setVisible(true);
		MainContent.revalidate();
		MainContent.repaint();

	}

	public void PhieuNhapMouseClicked(MouseEvent evt) {
		// TODO add your handling code here:
		MainContent.removeAll();
		phieuNhap = new PhieuNhap();
		MainContent.add(phieuNhap).setVisible(true);
		MainContent.revalidate();
		MainContent.repaint();
	}

	public void PhieuXuatMousePressed(MouseEvent evt) {
		PanelSanPham.setBackground(DefaultColor);
		PanelPhieuNhap.setBackground(DefaultColor);
		PanelNhapHang.setBackground(DefaultColor);
		PanelXuatHang.setBackground(DefaultColor);
		PanelPhieuXuat.setBackground(ClickedColor);
		PanelPhanLoai.setBackground(DefaultColor);
		PanelTonKho.setBackground(DefaultColor);
		PanelThongKe.setBackground(DefaultColor);
		Paneldoithongtin.setBackground(DefaultColor);
		PanelAccount.setBackground(DefaultColor);
		PanelDaiLy.setBackground(DefaultColor);
		MainContent.removeAll();
		phieuXuat = new PhieuXuat();
		MainContent.add(phieuXuat).setVisible(true);
		MainContent.revalidate();
		MainContent.repaint();

	}

	public void PhieuXuatMouseClicked(MouseEvent evt) {
		// TODO add your handling code here:
		MainContent.removeAll();
		phieuXuat = new PhieuXuat();
		MainContent.add(phieuXuat).setVisible(true);
		MainContent.revalidate();
		MainContent.repaint();
	}

	public void ThongKeMousePressed(MouseEvent evt) {
		PanelSanPham.setBackground(DefaultColor);
		PanelPhieuNhap.setBackground(DefaultColor);
		PanelNhapHang.setBackground(DefaultColor);
		PanelXuatHang.setBackground(DefaultColor);
		PanelPhieuXuat.setBackground(DefaultColor);
		PanelPhanLoai.setBackground(DefaultColor);
		PanelTonKho.setBackground(DefaultColor);
		PanelThongKe.setBackground(ClickedColor);
		Paneldoithongtin.setBackground(DefaultColor);
		PanelAccount.setBackground(DefaultColor);
		PanelDaiLy.setBackground(DefaultColor);
		MainContent.removeAll();
		thongKe = new ThongKe();
		MainContent.add(thongKe).setVisible(true);
		MainContent.revalidate();
		MainContent.repaint();

	}

	public void ThongKeMouseClicked(MouseEvent evt) {
		// TODO add your handling code here:
		MainContent.removeAll();
		thongKe = new ThongKe();
		MainContent.add(thongKe).setVisible(true);
		MainContent.revalidate();
		MainContent.repaint();
	}

	public void TonKhoMousePressed(MouseEvent evt) {
		PanelSanPham.setBackground(DefaultColor);
		PanelPhieuNhap.setBackground(DefaultColor);
		PanelNhapHang.setBackground(DefaultColor);
		PanelXuatHang.setBackground(DefaultColor);
		PanelPhieuXuat.setBackground(DefaultColor);
		PanelPhanLoai.setBackground(DefaultColor);
		PanelTonKho.setBackground(ClickedColor);
		PanelThongKe.setBackground(DefaultColor);
		Paneldoithongtin.setBackground(DefaultColor);
		PanelAccount.setBackground(DefaultColor);
		PanelDaiLy.setBackground(DefaultColor);
		MainContent.removeAll();
		tonKho = new TonKho();
		MainContent.add(tonKho).setVisible(true);
		MainContent.revalidate();
		MainContent.repaint();

	}

	public void TonKhoMouseClicked(MouseEvent evt) {
		// TODO add your handling code here:
		MainContent.removeAll();
		tonKho = new TonKho();
		MainContent.add(tonKho).setVisible(true);
		MainContent.revalidate();
		MainContent.repaint();
	}

	public void XuatHangMousePressed(MouseEvent evt) {
		PanelSanPham.setBackground(DefaultColor);
		PanelPhieuNhap.setBackground(DefaultColor);
		PanelNhapHang.setBackground(DefaultColor);
		PanelXuatHang.setBackground(ClickedColor);
		PanelPhieuXuat.setBackground(DefaultColor);
		PanelPhanLoai.setBackground(DefaultColor);
		PanelTonKho.setBackground(DefaultColor);
		PanelThongKe.setBackground(DefaultColor);
		Paneldoithongtin.setBackground(DefaultColor);
		PanelAccount.setBackground(DefaultColor);
		PanelDaiLy.setBackground(DefaultColor);
		MainContent.removeAll();
		xuatHang = new XuatHang();
		MainContent.add(xuatHang).setVisible(true);
		MainContent.revalidate();
		MainContent.repaint();
		xuatHang.txtVvjvjv_1.setText(lblTen.getText());
	}

	public void XuatHangMouseClicked(MouseEvent evt) {
		// TODO add your handling code here:
		MainContent.removeAll();
		xuatHang = new XuatHang();
		MainContent.add(xuatHang).setVisible(true);
		MainContent.revalidate();
		MainContent.repaint();
		xuatHang.txtVvjvjv_1.setText(lblTen.getText());
	}

	public void DoiThongTinMousePressed(MouseEvent evt) {
		PanelSanPham.setBackground(DefaultColor);
		PanelPhieuNhap.setBackground(DefaultColor);
		PanelNhapHang.setBackground(DefaultColor);
		PanelXuatHang.setBackground(DefaultColor);
		PanelPhieuXuat.setBackground(DefaultColor);
		PanelPhanLoai.setBackground(DefaultColor);
		PanelTonKho.setBackground(DefaultColor);
		PanelThongKe.setBackground(DefaultColor);
		Paneldoithongtin.setBackground(ClickedColor);
		PanelAccount.setBackground(DefaultColor);
		PanelDaiLy.setBackground(DefaultColor);
		doiThongTin = new DoiThongTin();
		doiThongTin.setVisible(true);
		AccountBUS accBUS = new AccountBUS();
		if (accBUS.getList() == null)
			accBUS.list();
		doiThongTin.textFieldTenDangNhap.setText(lblTen.getText());
		doiThongTin.textFieldHovaTen.setText(accBUS.PutOnHovaTen(lblTen.getText()));
	
		doiThongTin.textFieldEmail.setText(accBUS.PutOnEmail(lblTen.getText()));
		doiThongTin.textFieldRole.setText(accBUS.PutOnRole(lblTen.getText()));

	}

	public void AccountMousePressed(MouseEvent evt) {
		PanelSanPham.setBackground(DefaultColor);
		PanelPhieuNhap.setBackground(DefaultColor);
		PanelNhapHang.setBackground(DefaultColor);
		PanelXuatHang.setBackground(DefaultColor);
		PanelPhieuXuat.setBackground(DefaultColor);
		PanelPhanLoai.setBackground(DefaultColor);
		PanelTonKho.setBackground(DefaultColor);
		PanelThongKe.setBackground(DefaultColor);
		Paneldoithongtin.setBackground(DefaultColor);
		PanelAccount.setBackground(ClickedColor);
		PanelDaiLy.setBackground(DefaultColor);
		MainContent.removeAll();
		taiKhoan = new TaiKhoan();
		MainContent.add(taiKhoan).setVisible(true);
		MainContent.revalidate();
		MainContent.repaint();

	}

	public void AccountMouseClicked(MouseEvent evt) {
		// TODO add your handling code here:
		MainContent.removeAll();
		taiKhoan = new TaiKhoan();
		MainContent.add(taiKhoan).setVisible(true);
		MainContent.revalidate();
		MainContent.repaint();
	}

	public void DaiLyMousePressed(MouseEvent evt) {
		PanelSanPham.setBackground(DefaultColor);
		PanelPhieuNhap.setBackground(DefaultColor);
		PanelNhapHang.setBackground(DefaultColor);
		PanelXuatHang.setBackground(DefaultColor);
		PanelPhieuXuat.setBackground(DefaultColor);
		PanelPhanLoai.setBackground(DefaultColor);
		PanelTonKho.setBackground(DefaultColor);
		PanelThongKe.setBackground(DefaultColor);
		Paneldoithongtin.setBackground(DefaultColor);
		PanelAccount.setBackground(DefaultColor);
		PanelDaiLy.setBackground(ClickedColor);
		MainContent.removeAll();
		daiLy = new DaiLy();
		MainContent.add(daiLy).setVisible(true);
		MainContent.revalidate();
		MainContent.repaint();

	}

	public void DaiLyMouseClicked(MouseEvent evt) {
		// TODO add your handling code here:
		MainContent.removeAll();
		daiLy = new DaiLy();
		MainContent.add(daiLy).setVisible(true);
		MainContent.revalidate();
		MainContent.repaint();
	}

}
