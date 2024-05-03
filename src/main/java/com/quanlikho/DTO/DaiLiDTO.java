package com.quanlikho.DTO;

public class DaiLiDTO {
	private String MaDL ; 
	private String TenDL ;
	private String SDT ; 
	private String DiaChi ;
	private int Enable ;
	public DaiLiDTO(String maDL, String tenDL, String sDT, String diaChi, int enable) {

		MaDL = maDL;
		TenDL = tenDL;
		SDT = sDT;
		DiaChi = diaChi;
		Enable = enable;
	}
	public DaiLiDTO() {
		
	}
	public String getMaDL() {
		return MaDL;
	}
	public void setMaDL(String maDL) {
		MaDL = maDL;
	}
	public String getTenDL() {
		return TenDL;
	}
	public void setTenDL(String tenDL) {
		TenDL = tenDL;
	}
	public String getSDT() {
		return SDT;
	}
	public void setSDT(String sDT) {
		SDT = sDT;
	}
	public String getDiaChi() {
		return DiaChi;
	}
	public void setDiaChi(String diaChi) {
		DiaChi = diaChi;
	}
	public int getEnable() {
		return Enable;
	}
	public void setEnable(int enable) {
		Enable = enable;
	}
	@Override
	public String toString() {
		return "DaiLiDTO [MaDL=" + MaDL + ", TenDL=" + TenDL + ", SDT=" + SDT + ", DiaChi=" + DiaChi + ", Enable="
				+ Enable + "]";
	} 
	
	
}
