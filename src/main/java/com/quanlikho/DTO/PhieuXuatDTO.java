package com.quanlikho.DTO;


import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Objects;

import com.quanlikho.GUI.*;

public class PhieuXuatDTO extends PhieuDTO {
    private String nhaCungCap;

    public PhieuXuatDTO(){

    }
    public PhieuXuatDTO(String nhaCungCap){
        this.nhaCungCap=nhaCungCap;
    }
    public PhieuXuatDTO(String nhaCungCap, String maPhieu, Timestamp thoiGianTao, String nguoiTao,String daiLi, ArrayList<ChiTietPhieu> CTPhieu, double tongTien){
        super(maPhieu, thoiGianTao, nguoiTao,daiLi, CTPhieu, tongTien);
        this.nhaCungCap = nhaCungCap;
    }
    private PhieuXuatDTO(String maPhieu, Timestamp thoiGianTao, String nguoiTao, ArrayList<ChiTietPhieu> CTPhieu, double tongTien){
        throw new UnsupportedOperationException("Not supported yet.");
    }
    public String getNhaCungCap(){
        return nhaCungCap;
    }
    public void setNhaCungCap(String nhaCungCap){
        this.nhaCungCap = nhaCungCap;
    }
    @Override
    public String toString() {
        return "PhieuXuat{"+"nhaCungCap="+ nhaCungCap+" maPhieu"+ this.getMaPhieu()+'}';
    }

    @Override 
    public int hashCode() {
        int hash =7;
        hash= 23*hash + Objects.hashCode(this.nhaCungCap);
        return hash;
    }
    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass()!=obj.getClass()) {
            return false;
        }
        final PhieuXuatDTO other = (PhieuXuatDTO) obj;
        return Objects.equals(this.nhaCungCap, other.nhaCungCap) && Objects.equals(this.getMaPhieu(), other.getMaPhieu()) && Double.doubleToLongBits(this.getTongTien()) != Double.doubleToLongBits(other.getTongTien());
    }
}
