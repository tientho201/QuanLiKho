package com.quanlikho.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import com.quanlikho.Connect.ConnectJDBC;
import com.quanlikho.DTO.*;

public class ThongKeDAO {
	private ConnectJDBC connection = new ConnectJDBC();
	public ThongKeDAO() {

	}
	public ArrayList<ThongKeDTO> list() {
		ArrayList<ThongKeDTO> ds = new ArrayList<ThongKeDTO>();
		try {
			String sql = "SELECT sp.MaSP, sp.TenSP, "
		             + "IFNULL(nhap.TongSoLuongNhap, 0) AS TongSoLuongNhap, "
		             + "IFNULL(xuat.TongSoLuongXuat, 0) AS TongSoLuongXuat "
		             + "FROM SanPham sp "
		             + "LEFT JOIN (SELECT MaSP, SUM(SoLuong) AS TongSoLuongNhap FROM ChiTietPN GROUP BY MaSP) nhap "
		             + "ON sp.MaSP = nhap.MaSP "
		             + "LEFT JOIN (SELECT MaSP, SUM(SoLuong) AS TongSoLuongXuat FROM ChiTietPX GROUP BY MaSP) xuat "
		             + "ON sp.MaSP = xuat.MaSP "
		             + "LIMIT 0, 25;";
			ResultSet rs = connection.executeQuery(sql);
			while (rs.next()) {
				String MaSP = rs.getString("MaSP");
				String TenSP = rs.getString("TenSP");
				int TongSoLuongNhap = rs.getInt("TongSoLuongNhap");
				int TongSoLuongXuat = rs.getInt("TongSoLuongXuat");
				ThongKeDTO tkDTO = new ThongKeDTO(MaSP , TenSP ,TongSoLuongNhap , TongSoLuongXuat );
				ds.add(tkDTO);
			}
			rs.close();
			connection.disConnect();
		} catch (SQLException ex) {
			//Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
		}
		return ds;
	}
}
