package com.quanlikho.DTO;

public class ChiTietPhieuNhapDTO {
	private String MaSP ; 
	private String MaPNH ; 
	private int DonGiaNhap ; 
	private int SoLuong  ; 
	public ChiTietPhieuNhapDTO(String maSP, String maPNH, int donGiaNhap, int soLuong) {
		
		MaSP = maSP;
		MaPNH = maPNH;
		DonGiaNhap = donGiaNhap;
		SoLuong = soLuong;
	}
	public ChiTietPhieuNhapDTO() {
		
	}
	public String getMaSP() {
		return MaSP;
	}
	public void setMaSP(String maSP) {
		MaSP = maSP;
	}
	public String getMaPNH() {
		return MaPNH;
	}
	public void setMaPNH(String maPNH) {
		MaPNH = maPNH;
	}
	public int getDonGiaNhap() {
		return DonGiaNhap;
	}
	public void setDonGiaNhap(int donGiaNhap) {
		DonGiaNhap = donGiaNhap;
	}
	public int getSoLuong() {
		return SoLuong;
	}
	public void setSoLuong(int soLuong) {
		SoLuong = soLuong;
	}
	
	@Override
	public String toString() {
		return "ChiTietPhieuNhapDTO [MaSP=" + MaSP + ", MaPNH=" + MaPNH + ", DonGiaNhap=" + DonGiaNhap + ", SoLuong="
				+ SoLuong + "]";
	} 
	
}
