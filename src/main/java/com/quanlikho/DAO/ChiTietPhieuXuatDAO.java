package com.quanlikho.DAO;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;



import com.quanlikho.Connect.*;
import com.quanlikho.DTO.*;

public class ChiTietPhieuXuatDAO implements DAOInterface<ChiTietPhieu> {
    public static ChiTietPhieuXuatDAO getInstance() {
        return new ChiTietPhieuXuatDAO();
    }
     @Override
     public int insert(ChiTietPhieu t){
        int ketQua =0;
        try {
            ConnectJDBC con = new ConnectJDBC();
            String sql = "INSERT INTO ChiTietPX(MaSP, MaPX, DonGia, Soluong) VALUES(?,?,?,?,?)";
            PreparedStatement pst = con.getConnection().prepareStatement(sql);
            pst.setString(1, t.getMaMay());
            pst.setString(2, t.getMaPhieu());
            pst.setDouble(3, t.getDonGia());
            pst.setInt(4, t.getSoLuong());
            
            ketQua =pst.executeUpdate();
            con.disConnect();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
     }
     @Override
     public int update (ChiTietPhieu t){
        int ketQua = 0;
        try {
            ConnectJDBC con = new ConnectJDBC();
            String sql= "UPDATE ChiTietPX SET MaPX=?, MaSP=?, SoLuong=?, DonGia=? WHERE MaPX=? AND MaSP=?";
            PreparedStatement pst= con.getConnection().prepareStatement(sql);
            pst.setString(1, t.getMaPhieu());
            pst.setString(2, t.getMaMay());
            pst.setInt(3, t.getSoLuong());
            pst.setDouble(4, t.getDonGia());
            pst.setString(5, t.getMaPhieu());
            pst.setString(6, t.getMaMay());
            ketQua=pst.executeUpdate();
            con.disConnect();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
     }
     @Override
     public int delete (ChiTietPhieu t){
        int ketQua = 0;
        try {
            ConnectJDBC con = new ConnectJDBC();
            String sql= "DELETE FROM ChiTietPX WHERE MaPX =?";
            PreparedStatement pst= con.getConnection().prepareStatement(sql);
            pst.setString(1,t.getMaPhieu());
            ketQua = pst.executeUpdate();
            con.disConnect();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
     }
     public ArrayList<ChiTietPhieu> selectAll(String t){
        ArrayList<ChiTietPhieu> ketQua= new ArrayList<ChiTietPhieu>();
        try {
            ConnectJDBC con = new ConnectJDBC();
            String sql="SELECT * FROM ChiTietPX WHERE MaPX=?";
            PreparedStatement pst =con.getConnection().prepareStatement(sql);
            pst.setString(1, t);
            ResultSet rs= pst.executeQuery();
            while (rs.next()) {
                String maPhieu = rs.getString("MaPX");
                String maMay = rs.getString("MaSP");
                int soLuong= rs.getInt("SoLuong");
                double donGia = rs.getDouble("DonGiaXuat");
                ChiTietPhieu ctp =new ChiTietPhieu(maPhieu, maMay, soLuong, donGia);
                ketQua.add(ctp);
            }
            con.disConnect();

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
     }
     @Override
     public ArrayList<ChiTietPhieu> selectAll(){
        ArrayList <ChiTietPhieu> ketQua = new ArrayList<ChiTietPhieu>();
        try {
            ConnectJDBC con = new ConnectJDBC();
            String sql = "SELECT * FROM ChiTietPX";
            PreparedStatement pst =con.getConnection().prepareStatement(sql);
            ResultSet rs= pst.executeQuery();
            while (rs.next()) {
                String maPhieu = rs.getString("MaPX");
                String maMay = rs.getString("MaSP");
                int soLuong = rs.getInt("SoLuong");
                double donGia = rs.getDouble("DonGiaXuat");
                ChiTietPhieu ctp =new ChiTietPhieu(maPhieu, maMay, soLuong, donGia);
                ketQua.add(ctp);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
     }
     @Override
     public ChiTietPhieu selectById(String t){
        ChiTietPhieu ketQua=null;
        try {
            ConnectJDBC con = new ConnectJDBC();
            String sql="SELECT * FROM ChiTietPX WHERE MaPX=?";
            PreparedStatement pst =con.getConnection().prepareStatement(sql);
            pst.setString(1,t);
            ResultSet rs = pst.executeQuery();
            while (rs.next()){
                String maPhieu = rs.getString("MaPX");
                String maMay = rs.getString("MaSP"); //
                int soLuong = rs.getInt("SoLuong");
                double donGia = rs.getDouble("DonGiaXuat");
                ketQua =new ChiTietPhieu(maPhieu, maMay, soLuong, donGia);
            }
        } catch (Exception e) {
        // TODO: handle exception
        e.printStackTrace();
        }
        return ketQua;
     }
}
