package com.quanlikho.BUS;

import java.util.ArrayList;

import com.quanlikho.DAO.LoaiDAO;
import com.quanlikho.DAO.NhaCungCapDAO;
import com.quanlikho.DAO.NhaSanXuatDAO;
import com.quanlikho.DAO.PhanLoaiDAO;
import com.quanlikho.DTO.LoaiDTO;
import com.quanlikho.DTO.NhaCungCapDTO;
import com.quanlikho.DTO.NhaSanXuatDTO;

public class PhanLoaiBUS {
	private PhanLoaiDAO phanLoaiDAO;
	private ArrayList<NhaCungCapDTO> dsNCC;
	private ArrayList<NhaSanXuatDTO> dsNSX;
	private ArrayList<LoaiDTO> dsLoai;


    public PhanLoaiBUS() {
        this.phanLoaiDAO = new PhanLoaiDAO();
        listNCC();
        listNSX();
        listLoai();
    }
    public ArrayList<NhaCungCapDTO> getListNCC() {
        return dsNCC;
    }

    public NhaCungCapDTO getNCC(String maNCC) {
        for (NhaCungCapDTO ncc : dsNCC) {
            if (ncc.getMaNCC().equals(maNCC)) {
                return ncc;
            }
        }
        return null;
    }

    public ArrayList<NhaCungCapDTO> listNCC() {
        PhanLoaiDAO phanLoaiDAO = new PhanLoaiDAO();
        dsNCC = new ArrayList<>();
        return dsNCC = phanLoaiDAO.listNCC();
    }

    public void addNCC(NhaCungCapDTO ncc) {
        dsNCC.add(ncc);
        PhanLoaiDAO phanLoaiDAO = new PhanLoaiDAO();
        phanLoaiDAO.addNCC(ncc);
    }

    public void updateNCC(NhaCungCapDTO ncc) {
    	for (int i = 0; i < dsNCC.size(); i++) {
			if (dsNCC.get(i).getMaNCC().equals(ncc.getMaNCC())) {
				dsNCC.set(i, ncc);
				PhanLoaiDAO phanLoaiDAO = new PhanLoaiDAO();
				phanLoaiDAO.updateNCC(ncc);
			}
		}
    }
    


    public void deleteNCC(String maNCC) {
        for (NhaCungCapDTO ncc : dsNCC) {
            if (ncc.getMaNCC().equals(maNCC)) {
                dsNCC.remove(ncc);
                PhanLoaiDAO phanLoaiDAO = new PhanLoaiDAO();
                phanLoaiDAO.deleteNCC(maNCC);
                return;
            }
        }
    }
    
	public boolean checkMaNCC(String MaNCC) {
		for (NhaCungCapDTO ncc : dsNCC) {
			if (ncc.getMaNCC().equals(MaNCC)) {
				return true;
			}
		}
		return false;
	}
	public boolean checkDataIsReferenced_NCC(String maNCC) {
        return phanLoaiDAO.checkDataIsReferenced_NCC(maNCC);
    }
	public ArrayList<NhaCungCapDTO> searchNCC(String selectedOption, String keyword) {
        ArrayList<NhaCungCapDTO> resultList = new ArrayList<>();
        
        // Lặp qua danh sách các nhà cung cấp
        for (NhaCungCapDTO ncc : getListNCC()) {
            switch (selectedOption) {
            	case "Tất cả":
            		if(keyword.isEmpty()){
            			return getListNCC();
            		}else {
            			if (ncc.getMaNCC().toLowerCase().contains(keyword.toLowerCase()) ||
                            ncc.getTenNCC().toLowerCase().contains(keyword.toLowerCase()) ||
                            ncc.getDiaChiNCC().toLowerCase().contains(keyword.toLowerCase()) ||
                            ncc.getSDTNCC().toLowerCase().contains(keyword.toLowerCase()) ||
                            ncc.getGhiChu().toLowerCase().contains(keyword.toLowerCase())) {
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
	public ArrayList<NhaSanXuatDTO> getListNSX() {
        return dsNSX;
    }

    public NhaSanXuatDTO getNSX(String maNSX) {
        for (NhaSanXuatDTO nsx : dsNSX) {
            if (nsx.getMaNSX().equals(maNSX)) {
                return nsx;
            }
        }
        return null;
    }

    public ArrayList<NhaSanXuatDTO> listNSX() {
    	PhanLoaiDAO phanLoaiDAO = new PhanLoaiDAO();
        dsNSX = new ArrayList<>();
        return dsNSX = phanLoaiDAO.listNSX();
    }

    // Thêm nhà sản xuất
    public void addNSX(NhaSanXuatDTO nsx) {
    	dsNSX.add(nsx);
        PhanLoaiDAO phanLoaiDAO = new PhanLoaiDAO();
        phanLoaiDAO.addNSX(nsx);
    }

    // Sửa thông tin nhà sản xuất
    public void updateNSX(NhaSanXuatDTO nsx) {
    	for (int i = 0; i < dsNSX.size(); i++) {
			if (dsNSX.get(i).getMaNSX().equals(nsx.getMaNSX())) {
				dsNSX.set(i, nsx);
				PhanLoaiDAO phanLoaiDAO = new PhanLoaiDAO();
				phanLoaiDAO.updateNSX(nsx);
			}
		}
    }

    // Xóa nhà sản xuất
    public void deleteNSX(String maNSX) {
    	for (NhaSanXuatDTO nsx : dsNSX) {
            if (nsx.getMaNSX().equals(maNSX)) {
                dsNSX.remove(nsx);
                PhanLoaiDAO phanLoaiDAO = new PhanLoaiDAO();
                phanLoaiDAO.deleteNSX(maNSX);
                return;
            }
        }
    }
    public boolean checkMaNSX(String maNSX) {
        for (NhaSanXuatDTO nsx : getListNSX()) {
            if (nsx.getMaNSX().equals(maNSX)) {
                return true; // Mã nhà sản xuất đã tồn tại
            }
        }
        return false; // Mã nhà sản xuất chưa tồn tại
    }
    
    public boolean checkDataIsReferenced_NSX(String maNSX) {
        return phanLoaiDAO.checkDataIsReferenced_NSX(maNSX);
    }
    public ArrayList<NhaSanXuatDTO> searchNSX(String selectedOption, String keyword) {
        ArrayList<NhaSanXuatDTO> resultList = new ArrayList<>();
        
        // Lặp qua danh sách các nhà sản xuất
        for (NhaSanXuatDTO nsx : getListNSX()) {
            switch (selectedOption) {
                case "Tất cả":
                    if (keyword.isEmpty()) {
                    	return getListNSX();
                    }else {
                    	if(
                        nsx.getMaNSX().toLowerCase().contains(keyword.toLowerCase()) ||
                        nsx.getTenNSX().toLowerCase().contains(keyword.toLowerCase())){
                        resultList.add(nsx);
                        }
                    }
                    break;
                case "Mã nhà sản xuất":
                    if (nsx.getMaNSX().toLowerCase().contains(keyword.toLowerCase())) {
                        resultList.add(nsx);
                    }
                    break;
                case "Tên nhà sản xuất":
                    if (nsx.getTenNSX().toLowerCase().contains(keyword.toLowerCase())) {
                        resultList.add(nsx);
                    }
                    break;
                default:
                    // Xử lý trường hợp không hợp lệ của selectedOption
                    break;
            }
        }
        
        return resultList;
    }
    public ArrayList<LoaiDTO> getListLoai() {
        return dsLoai;
    }

    public LoaiDTO getLoai(String maLoai) {
        for (LoaiDTO loai : dsLoai) {
            if (loai.getMaLoai().equals(maLoai)) {
                return loai;
            }
        }
        return null;
    }

    public ArrayList<LoaiDTO> listLoai() {
    	PhanLoaiDAO phanLoaiDAO = new PhanLoaiDAO();
        dsLoai = new ArrayList<>();
        return dsLoai = phanLoaiDAO.listLoai();
    }

    // Thêm nhà sản xuất
    public void addLoai(LoaiDTO loai) {
    	dsLoai.add(loai);
        PhanLoaiDAO phanLoaiDAO = new PhanLoaiDAO();
        phanLoaiDAO.addLoai(loai);
    }

    // Sửa thông tin nhà sản xuất
    public void updateLoai(LoaiDTO loai) {
    	for (int i = 0; i < dsLoai.size(); i++) {
			if (dsLoai.get(i).getMaLoai().equals(loai.getMaLoai())) {
				dsLoai.set(i, loai);
				PhanLoaiDAO phanLoaiDAO = new PhanLoaiDAO();
				phanLoaiDAO.updateLoai(loai);
			}
		}
    }

    // Xóa nhà sản xuất
    public void deleteLoai(String maLoai) {
    	for (LoaiDTO loai : dsLoai) {
            if (loai.getMaLoai().equals(maLoai)) {
                dsLoai.remove(loai);
                PhanLoaiDAO phanLoaiDAO = new PhanLoaiDAO();
                phanLoaiDAO.deleteLoai(maLoai);
                return;
            }
        }
    }
    public boolean checkMaLoai(String maLoai) {
        for (LoaiDTO loai : getListLoai()) {
            if (loai.getMaLoai().equals(maLoai)) {
                return true; // Mã nhà sản xuất đã tồn tại
            }
        }
        return false; // Mã nhà sản xuất chưa tồn tại
    }
    
    public boolean checkDataIsReferenced_Loai(String maLoai) {
        return phanLoaiDAO.checkDataIsReferenced_Loai(maLoai);
    }
    public ArrayList<LoaiDTO> searchLoai(String selectedOption, String keyword) {
        ArrayList<LoaiDTO> resultList = new ArrayList<>();
        
        // Lặp qua danh sách các nhà sản xuất
        for (LoaiDTO loai : getListLoai()) {
            switch (selectedOption) {
                case "Tất cả":
                    if (keyword.isEmpty()) {
                    	return getListLoai();
                    }else {
                    	if(
                        loai.getMaLoai().toLowerCase().contains(keyword.toLowerCase()) ||
                        loai.getTenLoai().toLowerCase().contains(keyword.toLowerCase())){
                        resultList.add(loai);
                        }
                    }
                    break;
                case "Mã loại":
                    if (loai.getMaLoai().toLowerCase().contains(keyword.toLowerCase())) {
                        resultList.add(loai);
                    }
                    break;
                case "Tên loại":
                    if (loai.getTenLoai().toLowerCase().contains(keyword.toLowerCase())) {
                        resultList.add(loai);
                    }
                    break;
                default:
                    // Xử lý trường hợp không hợp lệ của selectedOption
                    break;
            }
        }
        
        return resultList;
    }


}
