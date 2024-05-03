package com.quanlikho.DTO;

public class PhieuNhapHangDTO {

		private String MaPNH ; 
		private String MaNCC ; 
		private String TenDangNhap ; 
		private String NgayNhap ; 
		private int TongTien ;
		public PhieuNhapHangDTO(String maPNH, String maNCC, String tenDangNhap, String ngayNhap, int tongTien) {
			
			MaPNH = maPNH;
			MaNCC = maNCC;
			TenDangNhap = tenDangNhap; 
			NgayNhap = ngayNhap;
			TongTien = tongTien;
		}
		public PhieuNhapHangDTO() {
			
		}
		public String getMaPNH() {
			return MaPNH;
		}
		public void setMaPNH(String maPNH) {
			MaPNH = maPNH;
		}
		public String getMaNCC() {
			return MaNCC;
		}
		public void setMaNCC(String maNCC) {
			MaNCC = maNCC;
		}
		public String getTenDangNhap() {
			return TenDangNhap;
		}
		public void setTenDangNhap(String tenDangNhap) {
			TenDangNhap = tenDangNhap;
		}
		public String getNgayNhap() {
			return NgayNhap;
		}
		public void setNgayNhap(String ngayNhap) {
			NgayNhap = ngayNhap;
		}
		public int getTongTien() {
			return TongTien;
		}
		public void setTongTien(int tongTien) {
			TongTien = tongTien;
		}
		@Override
		public String toString() {
			return "PhieuNhapHangDTO [MaPNH=" + MaPNH + ", MaNCC=" + MaNCC + ", TenDangNhap=" + TenDangNhap + ", NgayNhap="
					+ NgayNhap + ", TongTien=" + TongTien + "]";
		}

		
		
	}


