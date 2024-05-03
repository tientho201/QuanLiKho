package com.quanlikho.DTO;



import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Objects;

public class PhieuDTO {
    private String maPhieu;
    private Timestamp thoiGianTao;
    private String nguoiTao;
    private String DaiLi; 
    private ArrayList<ChiTietPhieu> CTPhieu;
    private double tongTien;
	public PhieuDTO(String maPhieu, Timestamp thoiGianTao, String nguoiTao, String daiLi,
			ArrayList<ChiTietPhieu> cTPhieu, double tongTien) {
	
		this.maPhieu = maPhieu;
		this.thoiGianTao = thoiGianTao;
		this.nguoiTao = nguoiTao;
		DaiLi = daiLi;
		CTPhieu = cTPhieu;
		this.tongTien = tongTien;
	}
	public PhieuDTO() {
		
	}
	public String getMaPhieu() {
		return maPhieu;
	}
	public void setMaPhieu(String maPhieu) {
		this.maPhieu = maPhieu;
	}
	public Timestamp getThoiGianTao() {
		return thoiGianTao;
	}
	public void setThoiGianTao(Timestamp thoiGianTao) {
		this.thoiGianTao = thoiGianTao;
	}
	public String getNguoiTao() {
		return nguoiTao;
	}
	public void setNguoiTao(String nguoiTao) {
		this.nguoiTao = nguoiTao;
	}
	public String getDaiLi() {
		return DaiLi;
	}
	public void setDaiLi(String daiLi) {
		DaiLi = daiLi;
	}
	public ArrayList<ChiTietPhieu> getCTPhieu() {
		return CTPhieu;
	}
	public void setCTPhieu(ArrayList<ChiTietPhieu> cTPhieu) {
		CTPhieu = cTPhieu;
	}
	public double getTongTien() {
		return tongTien;
	}
	public void setTongTien(double tongTien) {
		this.tongTien = tongTien;
	}
    
   

    
}
