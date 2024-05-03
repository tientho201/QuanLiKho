package com.quanlikho.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.quanlikho.Connect.ConnectJDBC;
import com.quanlikho.DTO.SanPhamDTO;

public class SanPhamDAO {
	private ConnectJDBC connection = new ConnectJDBC();
	 private ConnectJDBC connectJDBC;
	
	public SanPhamDAO() {
		this.connectJDBC = new ConnectJDBC();
	}
	
	public ArrayList<SanPhamDTO> list(){
		ArrayList<SanPhamDTO> ds = new ArrayList<SanPhamDTO>();
		try {
			String sql = "SELECT * FROM SanPham " ; 
			ResultSet rs = connection.executeQuery(sql);
			while(rs.next()) {
				String maSP = rs.getString("MaSP");
				String tenSP = rs.getString("TenSP");
				int soLuong = rs.getInt("SoLuong");
				int gia = rs.getInt("Gia"); 
				String maLoai = rs.getString("MaLoai") ; 
				String maNSX = rs.getString("MaNSX");
				String ghiChu = rs.getString("GhiChu");
				int enable = rs.getInt("Enable");
				SanPhamDTO sanPhamDTO = new SanPhamDTO(maSP , tenSP , soLuong , gia , maLoai , maNSX , ghiChu , enable);
				ds.add(sanPhamDTO);
			}
			rs.close();
			connection.disConnect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, e);
		}
		return ds ; 
	}
	public void add(SanPhamDTO sp) {
	    String sql = "INSERT INTO SanPham (MaSP, TenSP, SoLuong, Gia, MaLoai, MaNSX, GhiChu , Enable) VALUES (?, ?, ?, ?, ?, ?, ? , ?)";
	    try (Connection connection = connectJDBC.getConnection();
	            PreparedStatement statement = connection.prepareStatement(sql)) {
	        statement.setString(1, sp.getMaSP());
	        statement.setString(2, sp.getTenSP());
	        statement.setInt(3, sp.getSoLuong());
	        statement.setInt(4, sp.getGia());
	        statement.setString(5, sp.getMaLoai());
	        statement.setString(6, sp.getMaNSX());
	        statement.setString(7, sp.getGhiChu());
	        statement.setInt(8, sp.getEnable());
	        statement.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	public void update(SanPhamDTO sp) {
		String sql = "UPDATE SanPham SET TenSP = ?, SoLuong = ?, Gia = ?, MaLoai = ?, MaNSX = ?, GhiChu = ? , Enable = ?  WHERE MaSP = ?";
	    try (Connection connection = connectJDBC.getConnection();
	            PreparedStatement statement = connection.prepareStatement(sql)) {
	        statement.setString(1, sp.getTenSP());
	        statement.setInt(2, sp.getSoLuong());
	        statement.setInt(3, sp.getGia());
	        statement.setString(4, sp.getMaLoai());
	        statement.setString(5, sp.getMaNSX());
	        statement.setString(6, sp.getGhiChu());
	        statement.setInt(7, sp.getEnable());
	        statement.setString(8, sp.getMaSP());
	        statement.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	public void delete(String maSP) {
	    if (checkDataIsReferenced(maSP)) {
	        System.out.println("Data is referenced");
	        return;
	    }
	    String sqlPX = "UPDATE ChiTietPX SET MaSP = NULL WHERE MaSP = ?";
	    String sqlPN = "UPDATE ChiTietPN SET MaSP = NULL WHERE MaSP = ?";
	    String sqlSanPham = "DELETE FROM SanPham WHERE MaSP = ?";
	    try (Connection connection = connectJDBC.getConnection();
	            PreparedStatement statementPX = connection.prepareStatement(sqlPX);
	            PreparedStatement statementPN = connection.prepareStatement(sqlPN);
	            PreparedStatement statementSanPham = connection.prepareStatement(sqlSanPham)) {
	        connection.setAutoCommit(false);
	        statementPX.setString(1, maSP);
	        statementPX.executeUpdate();
	        statementPN.setString(1, maSP);
	        statementPN.executeUpdate();
	        statementSanPham.setString(1, maSP);
	        statementSanPham.executeUpdate();
	        connection.commit();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	public boolean checkDataIsReferenced(String maSP) {
		String CHECK_REFERENCED_QUERY = "SELECT COUNT(*) FROM ChiTietPN WHERE MaSP = ? UNION SELECT COUNT(*) FROM ChiTietPX WHERE MaSP = ?";
	    try (Connection connection = connectJDBC.getConnection();
	            PreparedStatement statement = connection.prepareStatement(CHECK_REFERENCED_QUERY)) {
	        statement.setString(1, maSP);
	        statement.setString(2, maSP); // Thêm tham số để kết nối với bảng PhieuXuat
	        ResultSet resultSet = statement.executeQuery();
	        if (resultSet.next()) {
	            int count = resultSet.getInt(1);
	            return count > 0; // Trả về true nếu có dữ liệu tham chiếu, ngược lại trả về false
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return false; // Trong trường hợp có lỗi xảy ra
	}

}
