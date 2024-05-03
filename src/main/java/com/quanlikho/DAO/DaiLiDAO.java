package com.quanlikho.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.quanlikho.Connect.ConnectJDBC;
import com.quanlikho.DTO.DaiLiDTO;

public class DaiLiDAO {
	private ConnectJDBC connection = new ConnectJDBC();

	public DaiLiDAO() {

	}

	public ArrayList<DaiLiDTO> list() {
		ArrayList<DaiLiDTO> ds = new ArrayList<DaiLiDTO>();
		try {
			String sql = "SELECT * FROM DaiLi ";
			ResultSet rs = connection.executeQuery(sql);
			while (rs.next()) {
				String MaDL = rs.getString("MaDL");
				String TenDL = rs.getString("TenDL");
				String SDT = rs.getString("SDT");
				String DiaChi = rs.getString("DiaChi");
				int Enable = rs.getInt("Enable");
				DaiLiDTO daiLiDTO = new DaiLiDTO(MaDL, TenDL, SDT, DiaChi, Enable);
				ds.add(daiLiDTO);
			}
			rs.close();
			connection.disConnect();
		} catch (SQLException ex) {
			Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
		}
		return ds;
	}

	public void add(DaiLiDTO dl) {
		ConnectJDBC connection = new ConnectJDBC();
		String sql = "INSERT INTO DaiLi  VALUES(";
		sql += "'" + dl.getMaDL() + "',";
		sql += "N'" + dl.getTenDL() + "',";
		sql += "N'" + dl.getSDT() + "',";
		sql += "N'" + dl.getDiaChi() + "',";
		sql += "" + dl.getEnable() + ");";
		System.out.println(sql);
		connection.executeUpdate(sql);
	}

	public void update(DaiLiDTO dl) {
		ConnectJDBC connection = new ConnectJDBC();
		String sql = "UPDATE DaiLi SET ";
		sql += "TenDL = N'" + dl.getTenDL() + "', ";
		sql += "SDT = N'" + dl.getSDT() + "', ";
		sql += "DiaChi = N'" + dl.getDiaChi() + "', ";
		sql += "Enable = " + dl.getEnable() + " ";
		sql += "Where MaDL = '" + dl.getMaDL() + "';";
		System.out.println(sql);
		connection.executeUpdate(sql);
	}

	public void delete(String MaDL) {
		ConnectJDBC connection = new ConnectJDBC();
		String sqlDL = "DELETE FROM DaiLi  WHERE MaDL='" + MaDL + "'";
		connection.executeUpdate(sqlDL);
	}


}
