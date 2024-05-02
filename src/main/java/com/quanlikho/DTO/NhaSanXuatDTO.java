package com.quanlikho.DTO;

public class NhaSanXuatDTO {
	private String maNSX;
	private String tenNSX;
	
	public NhaSanXuatDTO() {

	}

	public NhaSanXuatDTO(String maNSX, String tenNSX) {
		super();
		this.maNSX = maNSX;
		this.tenNSX = tenNSX;
	}

	public String getMaNSX() {
		return maNSX;
	}

	public void setMaNSX(String maNSX) {
		this.maNSX = maNSX;
	}

	public String getTenNSX() {
		return tenNSX;
	}

	public void setTenNSX(String tenNSX) {
		this.tenNSX = tenNSX;
	}

	@Override
	public String toString() {
		return "NhaSanXuatDTO [maNSX=" + maNSX + ", tenNSX=" + tenNSX + "]";
	}
	
	
	
}
