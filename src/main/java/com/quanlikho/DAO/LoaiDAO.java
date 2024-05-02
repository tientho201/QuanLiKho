package com.quanlikho.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.quanlikho.Connect.ConnectJDBC;
import com.quanlikho.DTO.LoaiDTO;

public class LoaiDAO {
	 private ConnectJDBC connection = new ConnectJDBC();
	    private final String CHECK_REFERENCED_QUERY = "SELECT COUNT(*) FROM SanPham WHERE MaLoai = ?";
	    private ConnectJDBC connectJDBC;

	    public LoaiDAO() {
	        this.connectJDBC = new ConnectJDBC();
	    }
	    public ArrayList<LoaiDTO> list() {
	        ArrayList<LoaiDTO> ds = new ArrayList<LoaiDTO>();
	        try {
	            String sql = "SELECT * FROM Loai ";
	            ResultSet rs = connection.executeQuery(sql);
	            while (rs.next()) {
	                String maLoai = rs.getString("MaLoai");
	                String tenLoai = rs.getString("TenLoai");
	                LoaiDTO loaiDTO = new LoaiDTO(maLoai, tenLoai);
	                ds.add(loaiDTO);
	            }
	            rs.close();
	            connection.disConnect();
	        } catch (SQLException e) {
	            Logger.getLogger(LoaiDAO.class.getName()).log(Level.SEVERE, null, e);
	        }
	        return ds;
	    }

	    public void add(LoaiDTO loai) {
	        ConnectJDBC connection = new ConnectJDBC();
	        String sql = "INSERT INTO Loai  VALUES(";
	        sql += "'" + loai.getMaLoai() + "',";
	        sql += "N'" + loai.getTenLoai() + "');";
	        System.out.println(sql);
	        connection.executeUpdate(sql);
	    }

	    public void update(LoaiDTO loai) {
	        ConnectJDBC connection = new ConnectJDBC();
	        String sql = "UPDATE Loai SET ";
	        sql += "TenLoai = N'" + loai.getTenLoai() + "', ";
	        sql += "WHERE MaLoai = '" + loai.getMaLoai() + "';";
	        System.out.println(sql);
	        connection.executeUpdate(sql);
	    }

	    public void delete(String maLoai) {
	        ConnectJDBC connection = new ConnectJDBC();
	        String sql = "DELETE FROM Loai WHERE MaLoai = '" + maLoai + "'";
	        System.out.println(sql);
	        connection.executeUpdate(sql);
	    }

	    public boolean checkDataIsReferenced(String maLoai) {
	        try (Connection connection = connectJDBC.getConnection();
	                PreparedStatement statement = connection.prepareStatement(CHECK_REFERENCED_QUERY)) {
	            statement.setString(1, maLoai);
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

