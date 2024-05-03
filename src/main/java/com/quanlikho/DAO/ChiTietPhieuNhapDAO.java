package com.quanlikho.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.quanlikho.DTO.*;
import com.quanlikho.Connect.*;
public class ChiTietPhieuNhapDAO {
	private ConnectJDBC connection = new ConnectJDBC();

	public ChiTietPhieuNhapDAO() {

	}
	public ArrayList<ChiTietPhieuNhapDTO> list() {
		ArrayList<ChiTietPhieuNhapDTO> ds = new ArrayList<ChiTietPhieuNhapDTO>();
		try {
			String sql = "SELECT * FROM ChiTietPN  ";
			ResultSet rs = connection.executeQuery(sql);
			while (rs.next()) {
				String MaSP = rs.getString("MaSP");
				String MaPNH = rs.getString("MaPN");
				int DonGiaNhap = rs.getInt("DonGiaNhap");
				int SoLuong = rs.getInt("SoLuong");
				ChiTietPhieuNhapDTO ctpnDTO = new  ChiTietPhieuNhapDTO(MaSP , MaPNH , DonGiaNhap , SoLuong );
				ds.add(ctpnDTO);
			}
			rs.close();
			connection.disConnect();
		} catch (SQLException ex) {
			//Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
		}
		return ds;
	}
	public void update(ChiTietPhieuNhapDTO ctpn) {
		ConnectJDBC connection = new ConnectJDBC();
		String sql = "UPDATE ChiTietPN SET ";
		sql += "DonGiaNhap = " + ctpn.getDonGiaNhap() + ", ";
		sql += "SoLuong = " + ctpn.getSoLuong() + ", ";
		sql += "Where MaSP = '" + ctpn.getMaSP() + "' AND  MaPN = '" + ctpn.getMaPNH() +"';" ;
		System.out.println(sql);
		connection.executeUpdate(sql);
	}
	public void add(ChiTietPhieuNhapDTO ctpn) {
		ConnectJDBC connection = new ConnectJDBC();
		String sql = "INSERT INTO ChiTietPN  VALUES(";
		sql += "'" +  ctpn.getMaSP()+ "',";
		sql += "'" +  ctpn.getMaPNH()+ "',";
		sql += "" +  ctpn.getDonGiaNhap()+ ",";
		sql += "" +  ctpn.getSoLuong()+ ";";
		System.out.println(sql);
		connection.executeUpdate(sql);
		
	}

	public void delete(String MaPNH ) {
		ConnectJDBC connection = new ConnectJDBC();
		String sql = "DELETE FROM ChiTietPN WHERE MaPN = '" + MaPNH   ;
		System.out.println(sql);
		connection.executeUpdate(sql);
	}
}
