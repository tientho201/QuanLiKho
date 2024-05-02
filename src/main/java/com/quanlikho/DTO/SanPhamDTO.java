package com.quanlikho.DTO;

public class SanPhamDTO {
	private String MaSP ; 
	private String TenSP ; 
	private int SoLuong ; 
	private int Gia ; 
	private String MaLoai ; 
	private String MaNSX ;
	private String GhiChu ;
	public SanPhamDTO(String maSP, String tenSP, int soLuong, int gia, String maLoai, String maNSX, String ghiChu) {
		
		MaSP = maSP;
		TenSP = tenSP;
		SoLuong = soLuong;
		Gia = gia;
		MaLoai = maLoai;
		MaNSX = maNSX;
		GhiChu = ghiChu;
	}
	public SanPhamDTO() {
		
	}
	public String getMaSP() {
		return MaSP;
	}
	public void setMaSP(String maSP) {
		MaSP = maSP;
	}
	public String getTenSP() {
		return TenSP;
	}
	public void setTenSP(String tenSP) {
		TenSP = tenSP;
	}
	public int getSoLuong() {
		return SoLuong;
	}
	public void setSoLuong(int soLuong) {
		SoLuong = soLuong;
	}
	public int getGia() {
		return Gia;
	}
	public void setGia(int gia) {
		Gia = gia;
	}
	public String getMaLoai() {
		return MaLoai;
	}
	public void setMaLoai(String maLoai) {
		MaLoai = maLoai;
	}
	public String getMaNSX() {
		return MaNSX;
	}
	public void setMaNSX(String maNSX) {
		MaNSX = maNSX;
	}
	public String getGhiChu() {
		return GhiChu;
	}
	public void setGhiChu(String ghiChu) {
		GhiChu = ghiChu;
	}
	@Override
	public String toString() {
		return "SanPhamDTO [MaSP=" + MaSP + ", TenSP=" + TenSP + ", SoLuong=" + SoLuong + ", Gia=" + Gia + ", MaLoai="
				+ MaLoai + ", MaNSX=" + MaNSX + ", GhiChu=" + GhiChu + "]";
	}
	
	
}
