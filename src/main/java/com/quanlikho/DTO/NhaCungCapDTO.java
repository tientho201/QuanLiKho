package com.quanlikho.DTO;

import java.util.Objects;

public class NhaCungCapDTO {
	private String maNCC;
	private String tenNCC;
	private String diaChiNCC;
	private String SDTNCC;
	private String ghiChu;

	public NhaCungCapDTO(String maNCC, String tenNCC, String diaChiNCC, String SDTNCC, String ghiChu) {
		this.maNCC = maNCC;
		this.tenNCC = tenNCC;
		this.diaChiNCC = diaChiNCC;
		this.SDTNCC = SDTNCC;
		this.ghiChu = ghiChu;
	}

	public String getMaNCC() {
		return maNCC;
	}

	public void setMaNCC(String maNCC) {
		this.maNCC = maNCC;
	}

	public String getTenNCC() {
		return tenNCC;
	}

	public void setTenNCC(String tenNCC) {
		this.tenNCC = tenNCC;
	}

	public String getDiaChiNCC() {
		return diaChiNCC;
	}

	public void setDiaChiNCC(String diaChiNCC) {
		this.diaChiNCC = diaChiNCC;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	public String getSDTNCC() {
		return SDTNCC;
	}

	public void setSDTNCC(String SDTNCC) {
		this.SDTNCC = SDTNCC;
	}

	@Override
	public int hashCode() {
		return Objects.hash(diaChiNCC, ghiChu, maNCC, SDTNCC, tenNCC);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NhaCungCapDTO other = (NhaCungCapDTO) obj;
		return Objects.equals(diaChiNCC, other.diaChiNCC) && Objects.equals(ghiChu, other.ghiChu)
				&& Objects.equals(maNCC, other.maNCC) && Objects.equals(SDTNCC, other.getSDTNCC())
				&& Objects.equals(tenNCC, other.tenNCC);
	}

	@Override
	public String toString() {
		return "NhaCungCapDTO [maNCC=" + maNCC + ", tenNCC=" + tenNCC + ", diaChiNCC=" + diaChiNCC + ", ghiChuNCC="
				+ ghiChu + ", SDTNCC=" + SDTNCC + "]";
	}

}
