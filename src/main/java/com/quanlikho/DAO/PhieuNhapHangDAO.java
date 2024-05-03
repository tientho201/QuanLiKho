package com.quanlikho.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.quanlikho.DTO.*;
import com.quanlikho.Connect.*;

public class PhieuNhapHangDAO {
	private ConnectJDBC connection = new ConnectJDBC();

	public PhieuNhapHangDAO() {

	}
	public ArrayList<PhieuNhapHangDTO> list() {
		ArrayList<PhieuNhapHangDTO> ds = new ArrayList<PhieuNhapHangDTO>();
		try {
			String sql = "SELECT * FROM PhieuNhap  ";
			ResultSet rs = connection.executeQuery(sql);
			while (rs.next()) {
				String MaPNH = rs.getString("MaPN");
				String TenDangNhap = rs.getString("TenDangNhap");
				String MaNCC = rs.getString("MaNCC");
				String NgayNhap = rs.getString("NgayNhap");
				int TongTien = rs.getInt("TongTien");
			
				PhieuNhapHangDTO pnhDTO = new PhieuNhapHangDTO(MaPNH,MaNCC,TenDangNhap,NgayNhap,TongTien);
				ds.add(pnhDTO);
			}
			rs.close();
			connection.disConnect();
		} catch (SQLException ex) {
			//Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
		}
		return ds;
	}
	public void update(PhieuNhapHangDTO pnh) {
		ConnectJDBC connection = new ConnectJDBC();
		String sql = "UPDATE PhieuNhap SET ";
		sql += "MaNCC = N'" + pnh.getMaNCC() + "', ";
		sql += "TenDangNhap = N'" + pnh.getTenDangNhap() + "', ";
		sql += "NgayNhap = N'" + pnh.getNgayNhap() + "', ";
		sql += "TongTien = " + pnh.getTongTien() + " ";
		sql += "WHERE MaPN = '" + pnh.getMaPNH() + "';";
		System.out.println(sql);
		connection.executeUpdate(sql);
	}
	public void add(PhieuNhapHangDTO pnh) {
		ConnectJDBC connection = new ConnectJDBC();
		String sql = "INSERT INTO PhieuNhap  VALUES(";
		sql += "N'" +   pnh.getMaPNH() + "',";
		sql += "N'" +  pnh.getMaNCC() + "',";
		sql += "N'" + pnh.getTenDangNhap() + "',";
		sql += "N'" +  pnh.getNgayNhap() +  "',";
		sql += "" + pnh.getTongTien() + ",";
		System.out.println(sql);
		connection.executeUpdate(sql);
	}

	public void delete(String MaPNH ) {
		ConnectJDBC connection = new ConnectJDBC();
		String sql = "DELETE FROM PhieuNhap WHERE MaPN = '" + MaPNH + "'";
		String sqlCTPN = "DELETE FROM ChiTietPN WHERE MaPN = '" + MaPNH + "'";
		System.out.println(sqlCTPN);
		System.out.println(sql);
		connection.executeUpdate(sqlCTPN);
		connection.executeUpdate(sql);
	}
}
