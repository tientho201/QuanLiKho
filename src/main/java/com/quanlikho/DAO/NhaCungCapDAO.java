package com.quanlikho.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.quanlikho.Connect.ConnectJDBC;
import com.quanlikho.DTO.NhaCungCapDTO;

public class NhaCungCapDAO {
    private ConnectJDBC connection = new ConnectJDBC();
    private final String CHECK_REFERENCED_QUERY = "SELECT COUNT(*) FROM PhieuNhap, PhieuXuat WHERE MaNCC = ?";
    private ConnectJDBC connectJDBC;

    public NhaCungCapDAO() {
        this.connectJDBC = new ConnectJDBC();
    }

    public ArrayList<NhaCungCapDTO> list() {
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

    public void add(NhaCungCapDTO ncc) {
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

    public void update(NhaCungCapDTO ncc) {
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

    public void delete(String maNCC) {
        ConnectJDBC connection = new ConnectJDBC();
        String sql = "DELETE FROM NhaCungCap WHERE MaNCC = '" + maNCC + "'";
        System.out.println(sql);
        connection.executeUpdate(sql);
    }

    public boolean checkDataIsReferenced(String maNCC) {
        try (Connection connection = connectJDBC.getConnection();
                PreparedStatement statement = connection.prepareStatement(CHECK_REFERENCED_QUERY)) {
            statement.setString(1, maNCC);
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