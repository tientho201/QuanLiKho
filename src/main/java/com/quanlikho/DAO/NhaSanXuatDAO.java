package com.quanlikho.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.quanlikho.Connect.ConnectJDBC;
import com.quanlikho.DTO.NhaSanXuatDTO;

public class NhaSanXuatDAO {
	 private ConnectJDBC connection = new ConnectJDBC();
	    private final String CHECK_REFERENCED_QUERY = "SELECT COUNT(*) FROM SanPham WHERE MaNSX = ?";
	    private ConnectJDBC connectJDBC;

	    public NhaSanXuatDAO() {
	        this.connectJDBC = new ConnectJDBC();
	    }
	    public ArrayList<NhaSanXuatDTO> list() {
	        ArrayList<NhaSanXuatDTO> ds = new ArrayList<NhaSanXuatDTO>();
	        try {
	            String sql = "SELECT * FROM NhaSanXuat ";
	            ResultSet rs = connection.executeQuery(sql);
	            while (rs.next()) {
	                String maNhaSanXuat = rs.getString("MaNSX");
	                String tenNhaSanXuat = rs.getString("TenNSX");
	                NhaSanXuatDTO NhaSanXuatDTO = new NhaSanXuatDTO(maNhaSanXuat, tenNhaSanXuat);
	                ds.add(NhaSanXuatDTO);
	            }
	            rs.close();
	            connection.disConnect();
	        } catch (SQLException e) {
	            Logger.getLogger(NhaSanXuatDAO.class.getName()).log(Level.SEVERE, null, e);
	        }
	        return ds;
	    }

	    public void add(NhaSanXuatDTO NhaSanXuat) {
	        ConnectJDBC connection = new ConnectJDBC();
	        String sql = "INSERT INTO NhaSanXuat  VALUES(";
	        sql += "'" + NhaSanXuat.getMaNSX() + "',";
	        sql += "N'" + NhaSanXuat.getTenNSX() + "');";
	        System.out.println(sql);
	        connection.executeUpdate(sql);
	    }

	    public void update(NhaSanXuatDTO NhaSanXuat) {
	        ConnectJDBC connection = new ConnectJDBC();
	        String sql = "UPDATE NhaSanXuat SET ";
	        sql += "TenNSX = N'" + NhaSanXuat.getTenNSX() + "', ";
	        sql += "WHERE MaNSX = '" + NhaSanXuat.getMaNSX() + "';";
	        System.out.println(sql);
	        connection.executeUpdate(sql);
	    }

	    public void delete(String maNhaSanXuat) {
	        ConnectJDBC connection = new ConnectJDBC();
	        String sql = "DELETE FROM NhaSanXuat WHERE MaNSX = '" + maNhaSanXuat + "'";
	        System.out.println(sql);
	        connection.executeUpdate(sql);
	    }

	    public boolean checkDataIsReferenced(String maNhaSanXuat) {
	        try (Connection connection = connectJDBC.getConnection();
	                PreparedStatement statement = connection.prepareStatement(CHECK_REFERENCED_QUERY)) {
	            statement.setString(1, maNhaSanXuat);
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

