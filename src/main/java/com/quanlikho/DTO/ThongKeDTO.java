package com.quanlikho.DTO;

public class ThongKeDTO {
    private String maSP;
    private String tenSP;
    private int slNhap;
    private int slXuat;

    public ThongKeDTO() {
    }

	public ThongKeDTO(String maSP, String tenSP, int slNhap, int slXuat) {
		super();
		this.maSP = maSP;
		this.tenSP = tenSP;
		this.slNhap = slNhap;
		this.slXuat = slXuat;
	}

	public String getMaSP() {
		return maSP;
	}

	public void setMaSP(String maSP) {
		this.maSP = maSP;
	}

	public String getTenSP() {
		return tenSP;
	}

	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}

	public int getSlNhap() {
		return slNhap;
	}

	public void setSlNhap(int slNhap) {
		this.slNhap = slNhap;
	}

	public int getSlXuat() {
		return slXuat;
	}

	public void setSlXuat(int slXuat) {
		this.slXuat = slXuat;
	}


}