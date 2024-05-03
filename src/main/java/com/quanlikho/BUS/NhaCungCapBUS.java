package com.quanlikho.BUS;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import com.quanlikho.DAO.AccountDAO;
import com.quanlikho.DAO.NhaCungCapDAO;
import com.quanlikho.DTO.AccountDTO;
import com.quanlikho.DTO.NhaCungCapDTO;

public class NhaCungCapBUS {
	private ArrayList<NhaCungCapDTO> ds;
	private NhaCungCapDAO nhaCungCapDAO;

	public NhaCungCapBUS() {
		this.nhaCungCapDAO = new NhaCungCapDAO();
		this.nhaCungCapDAO = new NhaCungCapDAO();
		list();
	}

	public ArrayList<NhaCungCapDTO> getList() {
		return ds;
	}

	public NhaCungCapDTO get(String maNCC) {
		for (NhaCungCapDTO ncc : ds) {
			if (ncc.getMaNCC().equals(maNCC)) {
				return ncc;
			}
		}
		return null;
	}

	public ArrayList<NhaCungCapDTO> list() {
		NhaCungCapDAO nccDAO = new NhaCungCapDAO();
		ds = new ArrayList<>();
		return ds = nccDAO.list();
	}

	public void add(NhaCungCapDTO ncc) {
		ds.add(ncc);
		NhaCungCapDAO nccDAO = new NhaCungCapDAO();
		nccDAO.add(ncc);
	}

	public void update(NhaCungCapDTO ncc) {
		for (int i = 0; i < ds.size(); i++) {
			if (ds.get(i).getMaNCC().equals(ncc.getMaNCC())) {
				ds.set(i, ncc);
				NhaCungCapDAO nccDAO = new NhaCungCapDAO();
				nccDAO.update(ncc);
			}
		}
	}

	public void delete(String maNCC) {
		for (NhaCungCapDTO ncc : ds) {
			if (ncc.getMaNCC().equals(maNCC)) {
				ds.remove(ncc);
				NhaCungCapDAO nccDAO = new NhaCungCapDAO();
				nccDAO.delete(maNCC);
				return;
			}
		}
	}

	public boolean checkMaNCC(String MaNCC) {
		for (NhaCungCapDTO ncc : ds) {
			if (ncc.getMaNCC().equals(MaNCC)) {
				return true;
			}
		}
		return false;
	}

	public boolean checkDataIsReferenced(String maNCC) {
		return nhaCungCapDAO.checkDataIsReferenced(maNCC);
	}

	public ArrayList<NhaCungCapDTO> search(String selectedOption, String keyword) {
		ArrayList<NhaCungCapDTO> resultList = new ArrayList<>();

		// Lặp qua danh sách các nhà cung cấp
		for (NhaCungCapDTO ncc : getList()) {
			switch (selectedOption) {
			case "Tất cả":
				if (keyword.isEmpty()) {
					return getList();
				} else {
					if (ncc.getMaNCC().toLowerCase().contains(keyword.toLowerCase())
							|| ncc.getTenNCC().toLowerCase().contains(keyword.toLowerCase())
							|| ncc.getDiaChiNCC().toLowerCase().contains(keyword.toLowerCase())
							|| ncc.getSDTNCC().toLowerCase().contains(keyword.toLowerCase())
							|| ncc.getGhiChu().toLowerCase().contains(keyword.toLowerCase())) {
						resultList.add(ncc);
					}
				}
				break;
			case "Mã nhà cung cấp":
				if (ncc.getMaNCC().toLowerCase().contains(keyword.toLowerCase())) {
					resultList.add(ncc);
				}
				break;
			case "Tên nhà cung cấp":
				if (ncc.getTenNCC().toLowerCase().contains(keyword.toLowerCase())) {
					resultList.add(ncc);
				}
				break;
			case "Địa chỉ":
				if (ncc.getDiaChiNCC().toLowerCase().contains(keyword.toLowerCase())) {
					resultList.add(ncc);
				}
				break;
			case "Số điện thoại":
				if (ncc.getSDTNCC().toLowerCase().contains(keyword.toLowerCase())) {
					resultList.add(ncc);
				}
				break;
			case "Ghi chú":
				if (ncc.getGhiChu().toLowerCase().contains(keyword.toLowerCase())) {
					resultList.add(ncc);
				}
				break;
			default:

				break;
			}
		}

		return resultList;
	}
	public int countNCC() {
		int countNCC = 0 ; 
		for (NhaCungCapDTO ncc : ds) {
			countNCC++;
		}
		return countNCC;
	}
}
