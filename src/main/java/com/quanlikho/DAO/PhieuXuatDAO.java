package com.quanlikho.DAO;

import java.sql.Timestamp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;



import com.quanlikho.Connect.*;
import com.quanlikho.DTO.*;


public class PhieuXuatDAO implements DAOInterface<PhieuXuatDTO>{
    public static PhieuXuatDAO getInstance(){
        return new PhieuXuatDAO();
    }
    @Override

    public int insert(PhieuXuatDTO t){
        int ketQua=0;
        try {
            ConnectJDBC connect = new ConnectJDBC();
            String sql = "INSERT INTO PhieuXuat (MaPX, MaNCC, NgayXuat, TenDangXuat, TongTien) VALUES(?,?,?,?,?)";
            PreparedStatement pst = connect.getConnection().prepareStatement(sql);
            pst.setString(1,t.getMaPhieu());
            pst.setString(2, t.getNhaCungCap());
            pst.setTimestamp(3, t.getThoiGianTao());
            pst.setString(4, t.getNguoiTao());           
            pst.setDouble(5, t.getTongTien());
            ketQua=pst.executeUpdate();
            connect.disConnect();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;       
    }

    @Override
    public int update(PhieuXuatDTO t) {
        int ketQua = 0;
        try {
            ConnectJDBC con = new ConnectJDBC();
            String sql = "UPDATE PhieuXuat SET 	MaNCC=?, ThoiGianTao=?, 	TenDangNhap=?, MaDL =?, TongTien = ? WHERE MaPX=?";
            PreparedStatement pst =con.getConnection().prepareStatement(sql);
            pst.setString(1, t.getMaPhieu());
            pst.setTimestamp(2, t.getThoiGianTao());
            pst.setString(3, t.getNguoiTao());
            pst.setString(4, t.getNhaCungCap());
            pst.setDouble(5, t.getTongTien());
            pst.setString(6, t.getMaPhieu());
            ketQua = pst.executeUpdate();
            con.disConnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }
    @Override
    public int delete(PhieuXuatDTO t){
        int ketQua=0;
        try {
            ConnectJDBC con = new ConnectJDBC();
            con.Connect();
            String sql = "DELETE FROM PhieuXuat WHERE MaPX=?";
            PreparedStatement pst =con.getConnection().prepareStatement(sql);
            pst.setString(1, t.getMaPhieu());
            ketQua = pst.executeUpdate();
            con.disConnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }
    @Override
    public ArrayList<PhieuXuatDTO> selectAll(){
        ArrayList<PhieuXuatDTO> ketQua = new ArrayList<PhieuXuatDTO>();
        try {
            ConnectJDBC con = new ConnectJDBC();
            String sql =" SELECT * FROM PhieuXuat ORDER BY ThoiGianTao DESC";
            PreparedStatement pst = con.getConnection().prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String maPhieu = rs.getString("MaPX");
                String maNhaCungCap= rs.getString("MaNCC");
                Timestamp thoiGianTao = rs.getTimestamp("ThoiGianTao");
                String nguoiTao= rs.getString("TenDangNhap");   
                String MaDaiLi= rs.getString("MaDL");  
                double tongTien = rs.getDouble("TongTien");
                PhieuXuatDTO p =new PhieuXuatDTO(maNhaCungCap, maPhieu, thoiGianTao, nguoiTao,MaDaiLi, ChiTietPhieuXuatDAO.getInstance().selectAll(maPhieu), tongTien);
                ketQua.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public PhieuXuatDTO selectById(String t){
        PhieuXuatDTO ketQua= null;
        try {
            ConnectJDBC connectJDBC = new ConnectJDBC();
            String sql ="SELECT * FROM PhieuXuat WHERE MaPX=?";
            PreparedStatement pst = connectJDBC.getConnection().prepareStatement(sql);
            pst.setString(1, t);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
            String maPhieu = rs.getString("MaPX");
            Timestamp thoiGianTao = rs.getTimestamp("ThoiGianTao");
            String nguoiTao = rs.getString("TenDangNhap");
            String maNhaCungCap = rs.getString("MaNCC");
            String MaDaiLi= rs.getString("MaDL");  
            double tongTien = rs.getDouble("TongTien");
            ketQua= new PhieuXuatDTO(maNhaCungCap, maPhieu, thoiGianTao, nguoiTao, MaDaiLi,ChiTietPhieuXuatDAO.getInstance().selectAll(maPhieu), tongTien);
        }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    public ArrayList<PhieuDTO> selectAllAccount(String acc){
        ArrayList<PhieuDTO> ketQua =new ArrayList<PhieuDTO>();
        try {
            ConnectJDBC connectJDBC = new ConnectJDBC();
            String sql ="SELECT MaPX, TenDangXuat, ThoiGianTao, TongTien FROM PhieuXuat UNION SELECT * FROM PhieuXuat WHERE TenDangNhao=? OTHER BY ThoiGianTao DESC";
            PreparedStatement pst =connectJDBC.getConnection().prepareStatement(sql);
            pst.setString(1,acc);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String maPhieu = rs.getString("MaPX");
                Timestamp thoiGianTao = rs.getTimestamp("ThoiGianTao");
                String nguoiTao = rs.getString("TenDangNhap");
                String MaDaiLi= rs.getString("MaDL");  
                double tongTien = rs.getDouble("TongTien");
                PhieuDTO p= new PhieuDTO(maPhieu, thoiGianTao, nguoiTao, MaDaiLi,ChiTietPhieuXuatDAO.getInstance().selectAll(maPhieu), tongTien);
                ketQua.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    public ArrayList<PhieuDTO> selectAllP(){
        ArrayList<PhieuDTO> ketQua = new ArrayList<PhieuDTO>();
        try {
            ConnectJDBC connectJDBC = new ConnectJDBC();
            String sql ="SELECT MaPX, NgayXuat, TenDangXuat, TongTien FROM PhieuXuat UNION SELECT * FROM PhieuXuat OTHER BY ThoiGianTao DESC";
            PreparedStatement pst =connectJDBC.getConnection().prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String maPhieu = rs.getString("MaPX");
                Timestamp thoiGianTao=rs.getTimestamp("ThoiGianTao");
                String nguoiTao = rs.getString("TenDangNhap");
                String MaDaiLi= rs.getString("MaDL");  
                double tongTien = rs.getDouble("TongTien");
                PhieuDTO p=new PhieuDTO( maPhieu, thoiGianTao, nguoiTao, MaDaiLi,ChiTietPhieuXuatDAO.getInstance().selectAll(maPhieu),tongTien);
                ketQua.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }
}
