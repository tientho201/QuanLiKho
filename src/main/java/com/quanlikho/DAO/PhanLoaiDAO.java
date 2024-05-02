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
import com.quanlikho.DTO.NhaCungCapDTO;
import com.quanlikho.DTO.NhaSanXuatDTO;

public class PhanLoaiDAO {
	private ConnectJDBC connection = new ConnectJDBC();
	private final String CHECK_REFERENCED_QUERY = 
		    "SELECT COUNT(*) FROM PhieuNhap, PhieuXuat, SanPham " +
		    "WHERE (PhieuNhap.MaNCC = ? OR PhieuXuat.MaNCC = ? OR " +
		    "(SanPham.MaLoai = ? OR SanPham.MaNSX = ?))";

    public PhanLoaiDAO() {
    	 this.connection = new ConnectJDBC();
    }

    public ArrayList<NhaCungCapDTO> listNCC() {
        ArrayList<NhaCungCapDTO> ds = new ArrayList<NhaCungCapDTO>();
        try {
            String sql = "SELECT * FROM NhaCungCap ";
            ResultSet rs = connection.executeQuery(sql);
            while (rs.next()) {
                String maNCC = rs.getString("MaNCC");
                String tenNCC = rs.getString("TenNCC");
                String diaChiNCC = rs.getString("DiaChiNCC");
                String soDienThoaiNCC = rs.getString("SDTNCC");
                String ghiChuNCC = rs.getString("GhiChu");
                NhaCungCapDTO nhaCungCapDTO = new NhaCungCapDTO(maNCC, tenNCC, diaChiNCC, soDienThoaiNCC, ghiChuNCC);
                ds.add(nhaCungCapDTO);
            }
            rs.close();
            connection.disConnect();
        } catch (SQLException e) {
            Logger.getLogger(NhaCungCapDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return ds;
    }

    public void addNCC(NhaCungCapDTO ncc) {
        ConnectJDBC connection = new ConnectJDBC();
        String sql = "INSERT INTO NhaCungCap  VALUES(";
        sql += "'" + ncc.getMaNCC() + "',";
        sql += "N'" + ncc.getTenNCC() + "',";
        sql += "N'" + ncc.getDiaChiNCC() + "',";
        sql += "N'" + ncc.getSDTNCC() + "',";
        sql += "N'" + ncc.getGhiChu() + "');";
        System.out.println(sql);
        connection.executeUpdate(sql);
    }

    public void updateNCC(NhaCungCapDTO ncc) {
        ConnectJDBC connection = new ConnectJDBC();
        String sql = "UPDATE NhaCungCap SET ";
        sql += "TenNCC = N'" + ncc.getTenNCC() + "', ";
        sql += "DiaChiNCC = N'" + ncc.getDiaChiNCC() + "', ";
        sql += "GhiChu = N'" + ncc.getGhiChu() + "', ";
        sql += "SDTNCC = '" + ncc.getSDTNCC() + "' ";
        sql += "WHERE MaNCC = '" + ncc.getMaNCC() + "';";
        System.out.println(sql);
        connection.executeUpdate(sql);
    }

    public void deleteNCC(String maNCC) {
        ConnectJDBC connection = new ConnectJDBC();
        String sql = "DELETE FROM NhaCungCap WHERE MaNCC = '" + maNCC + "'";
        System.out.println(sql);
        connection.executeUpdate(sql);
    }

    public boolean checkDataIsReferenced_NCC(String maNCC) {
        try (Connection conn = connection.getConnection();
                PreparedStatement statement = conn.prepareStatement(CHECK_REFERENCED_QUERY)) {
            statement.setString(1, maNCC);
            statement.setString(2, maNCC); // Bổ sung thêm mã nhà cung cấp cho các cột có tham chiếu
            statement.setString(3, maNCC); // Bổ sung thêm mã nhà cung cấp cho các cột có tham chiếu
            statement.setString(4, maNCC); // Bổ sung thêm mã nhà cung cấp cho các cột có tham chiếu
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
    public ArrayList<NhaSanXuatDTO> listNSX() {
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

    public void addNSX(NhaSanXuatDTO NhaSanXuat) {
        ConnectJDBC connection = new ConnectJDBC();
        String sql = "INSERT INTO NhaSanXuat  VALUES(";
        sql += "'" + NhaSanXuat.getMaNSX() + "',";
        sql += "N'" + NhaSanXuat.getTenNSX() + "');";
        System.out.println(sql);
        connection.executeUpdate(sql);
    }

    public void updateNSX(NhaSanXuatDTO NhaSanXuat) {
        ConnectJDBC connection = new ConnectJDBC();
        String sql = "UPDATE NhaSanXuat SET ";
        sql += "TenNSX = N'" + NhaSanXuat.getTenNSX() + "' ";
        sql += "WHERE MaNSX = '" + NhaSanXuat.getMaNSX() + "'";
        System.out.println(sql);
        connection.executeUpdate(sql);
    }

    public void deleteNSX(String maNhaSanXuat) {
        ConnectJDBC connection = new ConnectJDBC();
        String sql = "DELETE FROM NhaSanXuat WHERE MaNSX = '" + maNhaSanXuat + "'";
        System.out.println(sql);
        connection.executeUpdate(sql);
    }

    public boolean checkDataIsReferenced_NSX(String maNhaSanXuat) {
        try (Connection conn = connection.getConnection();
             PreparedStatement statement = conn.prepareStatement(CHECK_REFERENCED_QUERY)) {
            statement.setString(1, maNhaSanXuat);
            statement.setString(2, maNhaSanXuat);
            statement.setString(3, maNhaSanXuat);
            statement.setString(4, maNhaSanXuat);
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

    
    public ArrayList<LoaiDTO> listLoai() {
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

    public void addLoai(LoaiDTO loai) {
        ConnectJDBC connection = new ConnectJDBC();
        String sql = "INSERT INTO Loai (MaLoai, TenLoai) VALUES ";
        sql += "('" + loai.getMaLoai() + "', N'" + loai.getTenLoai() + "')";
        System.out.println(sql);
        connection.executeUpdate(sql);
    }

    public void updateLoai(LoaiDTO loai) {
        try {
            String sql = "UPDATE Loai SET ";
            sql += "TenLoai = N'" + loai.getTenLoai() + "' ";
            sql += "WHERE MaLoai = '" + loai.getMaLoai() + "'";
            System.out.println(sql);
            connection.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connection.disConnect();
        }
    }

    public void deleteLoai(String maLoai) {
        ConnectJDBC connection = new ConnectJDBC();
        String sql = "DELETE FROM Loai WHERE MaLoai = '" + maLoai + "'";
        System.out.println(sql);
        connection.executeUpdate(sql);
    }

    public boolean checkDataIsReferenced_Loai(String maLoai) {
        try (Connection conn = connection.getConnection();
                PreparedStatement statement = conn.prepareStatement(CHECK_REFERENCED_QUERY)) {
            // Thiết lập giá trị cho các tham số của truy vấn SQL
            statement.setString(1, maLoai);
            statement.setString(2, maLoai);
            statement.setString(3, maLoai);
            statement.setString(4, maLoai);
            
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

