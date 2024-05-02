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
<<<<<<< HEAD
    private PhanLoaiDAO phanLoaiDAO;
    private ArrayList<NhaCungCapDTO> dsNCC;
    private ArrayList<NhaSanXuatDTO> dsNSX;
    private ArrayList<LoaiDTO> dsLoai;
=======
	private PhanLoaiDAO phanLoaiDAO;
	private ArrayList<NhaCungCapDTO> dsNCC;
	private ArrayList<NhaSanXuatDTO> dsNSX;
	private ArrayList<LoaiDTO> dsLoai;

>>>>>>> 07393a2d2d0d327f5091fdc45c171e5336a91e05

    public PhanLoaiBUS() {
        this.phanLoaiDAO = new PhanLoaiDAO();
        listNCC();
        listNSX();
        listLoai();
    }
<<<<<<< HEAD

=======
>>>>>>> 07393a2d2d0d327f5091fdc45c171e5336a91e05
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
<<<<<<< HEAD
        for (int i = 0; i < dsNCC.size(); i++) {
            if (dsNCC.get(i).getMaNCC().equals(ncc.getMaNCC())) {
                dsNCC.set(i, ncc);
                PhanLoaiDAO phanLoaiDAO = new PhanLoaiDAO();
                phanLoaiDAO.updateNCC(ncc);
            }
        }
    }
=======
    	for (int i = 0; i < dsNCC.size(); i++) {
			if (dsNCC.get(i).getMaNCC().equals(ncc.getMaNCC())) {
				dsNCC.set(i, ncc);
				PhanLoaiDAO phanLoaiDAO = new PhanLoaiDAO();
				phanLoaiDAO.updateNCC(ncc);
			}
		}
    }
    

>>>>>>> 07393a2d2d0d327f5091fdc45c171e5336a91e05

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
<<<<<<< HEAD

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
                    if (keyword.isEmpty()) {
                        return getListNCC();
                    } else {
                        if (ncc.getMaNCC().toLowerCase().contains(keyword.toLowerCase()) ||
                                ncc.getTenNCC().toLowerCase().contains(keyword.toLowerCase()) ||
                                ncc.getDiaChiNCC().toLowerCase().contains(keyword.toLowerCase()) ||
                                ncc.getSDTNCC().toLowerCase().contains(keyword.toLowerCase()) ||
                                ncc.getGhiChu().toLowerCase().contains(keyword.toLowerCase())) {
=======
    
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
>>>>>>> 07393a2d2d0d327f5091fdc45c171e5336a91e05
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
<<<<<<< HEAD

                    break;
            }
        }

        return resultList;
    }

    public ArrayList<NhaSanXuatDTO> getListNSX() {
=======
                	
                    break;
            }
        }
        
        return resultList;
    }
	public ArrayList<NhaSanXuatDTO> getListNSX() {
>>>>>>> 07393a2d2d0d327f5091fdc45c171e5336a91e05
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
<<<<<<< HEAD
        PhanLoaiDAO phanLoaiDAO = new PhanLoaiDAO();
=======
    	PhanLoaiDAO phanLoaiDAO = new PhanLoaiDAO();
>>>>>>> 07393a2d2d0d327f5091fdc45c171e5336a91e05
        dsNSX = new ArrayList<>();
        return dsNSX = phanLoaiDAO.listNSX();
    }

    // Thêm nhà sản xuất
    public void addNSX(NhaSanXuatDTO nsx) {
<<<<<<< HEAD
        dsNSX.add(nsx);
=======
    	dsNSX.add(nsx);
>>>>>>> 07393a2d2d0d327f5091fdc45c171e5336a91e05
        PhanLoaiDAO phanLoaiDAO = new PhanLoaiDAO();
        phanLoaiDAO.addNSX(nsx);
    }

    // Sửa thông tin nhà sản xuất
    public void updateNSX(NhaSanXuatDTO nsx) {
<<<<<<< HEAD
        for (int i = 0; i < dsNSX.size(); i++) {
            if (dsNSX.get(i).getMaNSX().equals(nsx.getMaNSX())) {
                dsNSX.set(i, nsx);
                PhanLoaiDAO phanLoaiDAO = new PhanLoaiDAO();
                phanLoaiDAO.updateNSX(nsx);
            }
        }
=======
    	for (int i = 0; i < dsNSX.size(); i++) {
			if (dsNSX.get(i).getMaNSX().equals(nsx.getMaNSX())) {
				dsNSX.set(i, nsx);
				PhanLoaiDAO phanLoaiDAO = new PhanLoaiDAO();
				phanLoaiDAO.updateNSX(nsx);
			}
		}
>>>>>>> 07393a2d2d0d327f5091fdc45c171e5336a91e05
    }

    // Xóa nhà sản xuất
    public void deleteNSX(String maNSX) {
<<<<<<< HEAD
        for (NhaSanXuatDTO nsx : dsNSX) {
=======
    	for (NhaSanXuatDTO nsx : dsNSX) {
>>>>>>> 07393a2d2d0d327f5091fdc45c171e5336a91e05
            if (nsx.getMaNSX().equals(maNSX)) {
                dsNSX.remove(nsx);
                PhanLoaiDAO phanLoaiDAO = new PhanLoaiDAO();
                phanLoaiDAO.deleteNSX(maNSX);
                return;
            }
        }
    }
<<<<<<< HEAD

=======
>>>>>>> 07393a2d2d0d327f5091fdc45c171e5336a91e05
    public boolean checkMaNSX(String maNSX) {
        for (NhaSanXuatDTO nsx : getListNSX()) {
            if (nsx.getMaNSX().equals(maNSX)) {
                return true; // Mã nhà sản xuất đã tồn tại
            }
        }
        return false; // Mã nhà sản xuất chưa tồn tại
    }
<<<<<<< HEAD

    public boolean checkDataIsReferenced_NSX(String maNSX) {
        return phanLoaiDAO.checkDataIsReferenced_NSX(maNSX);
    }

    public ArrayList<NhaSanXuatDTO> searchNSX(String selectedOption, String keyword) {
        ArrayList<NhaSanXuatDTO> resultList = new ArrayList<>();

=======
    
    public boolean checkDataIsReferenced_NSX(String maNSX) {
        return phanLoaiDAO.checkDataIsReferenced_NSX(maNSX);
    }
    public ArrayList<NhaSanXuatDTO> searchNSX(String selectedOption, String keyword) {
        ArrayList<NhaSanXuatDTO> resultList = new ArrayList<>();
        
>>>>>>> 07393a2d2d0d327f5091fdc45c171e5336a91e05
        // Lặp qua danh sách các nhà sản xuất
        for (NhaSanXuatDTO nsx : getListNSX()) {
            switch (selectedOption) {
                case "Tất cả":
                    if (keyword.isEmpty()) {
<<<<<<< HEAD
                        return getListNSX();
                    } else {
                        if (nsx.getMaNSX().toLowerCase().contains(keyword.toLowerCase()) ||
                                nsx.getTenNSX().toLowerCase().contains(keyword.toLowerCase())) {
                            resultList.add(nsx);
=======
                    	return getListNSX();
                    }else {
                    	if(
                        nsx.getMaNSX().toLowerCase().contains(keyword.toLowerCase()) ||
                        nsx.getTenNSX().toLowerCase().contains(keyword.toLowerCase())){
                        resultList.add(nsx);
>>>>>>> 07393a2d2d0d327f5091fdc45c171e5336a91e05
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
<<<<<<< HEAD

        return resultList;
    }

=======
        
        return resultList;
    }
>>>>>>> 07393a2d2d0d327f5091fdc45c171e5336a91e05
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
<<<<<<< HEAD
        PhanLoaiDAO phanLoaiDAO = new PhanLoaiDAO();
=======
    	PhanLoaiDAO phanLoaiDAO = new PhanLoaiDAO();
>>>>>>> 07393a2d2d0d327f5091fdc45c171e5336a91e05
        dsLoai = new ArrayList<>();
        return dsLoai = phanLoaiDAO.listLoai();
    }

    // Thêm nhà sản xuất
    public void addLoai(LoaiDTO loai) {
<<<<<<< HEAD
        dsLoai.add(loai);
=======
    	dsLoai.add(loai);
>>>>>>> 07393a2d2d0d327f5091fdc45c171e5336a91e05
        PhanLoaiDAO phanLoaiDAO = new PhanLoaiDAO();
        phanLoaiDAO.addLoai(loai);
    }

    // Sửa thông tin nhà sản xuất
    public void updateLoai(LoaiDTO loai) {
<<<<<<< HEAD
        for (int i = 0; i < dsLoai.size(); i++) {
            if (dsLoai.get(i).getMaLoai().equals(loai.getMaLoai())) {
                dsLoai.set(i, loai);
                PhanLoaiDAO phanLoaiDAO = new PhanLoaiDAO();
                phanLoaiDAO.updateLoai(loai);
            }
        }
=======
    	for (int i = 0; i < dsLoai.size(); i++) {
			if (dsLoai.get(i).getMaLoai().equals(loai.getMaLoai())) {
				dsLoai.set(i, loai);
				PhanLoaiDAO phanLoaiDAO = new PhanLoaiDAO();
				phanLoaiDAO.updateLoai(loai);
			}
		}
>>>>>>> 07393a2d2d0d327f5091fdc45c171e5336a91e05
    }

    // Xóa nhà sản xuất
    public void deleteLoai(String maLoai) {
<<<<<<< HEAD
        for (LoaiDTO loai : dsLoai) {
=======
    	for (LoaiDTO loai : dsLoai) {
>>>>>>> 07393a2d2d0d327f5091fdc45c171e5336a91e05
            if (loai.getMaLoai().equals(maLoai)) {
                dsLoai.remove(loai);
                PhanLoaiDAO phanLoaiDAO = new PhanLoaiDAO();
                phanLoaiDAO.deleteLoai(maLoai);
                return;
            }
        }
    }
<<<<<<< HEAD

=======
>>>>>>> 07393a2d2d0d327f5091fdc45c171e5336a91e05
    public boolean checkMaLoai(String maLoai) {
        for (LoaiDTO loai : getListLoai()) {
            if (loai.getMaLoai().equals(maLoai)) {
                return true; // Mã nhà sản xuất đã tồn tại
            }
        }
        return false; // Mã nhà sản xuất chưa tồn tại
    }
<<<<<<< HEAD

    public boolean checkDataIsReferenced_Loai(String maLoai) {
        return phanLoaiDAO.checkDataIsReferenced_Loai(maLoai);
    }

    public ArrayList<LoaiDTO> searchLoai(String selectedOption, String keyword) {
        ArrayList<LoaiDTO> resultList = new ArrayList<>();

=======
    
    public boolean checkDataIsReferenced_Loai(String maLoai) {
        return phanLoaiDAO.checkDataIsReferenced_Loai(maLoai);
    }
    public ArrayList<LoaiDTO> searchLoai(String selectedOption, String keyword) {
        ArrayList<LoaiDTO> resultList = new ArrayList<>();
        
>>>>>>> 07393a2d2d0d327f5091fdc45c171e5336a91e05
        // Lặp qua danh sách các nhà sản xuất
        for (LoaiDTO loai : getListLoai()) {
            switch (selectedOption) {
                case "Tất cả":
                    if (keyword.isEmpty()) {
<<<<<<< HEAD
                        return getListLoai();
                    } else {
                        if (loai.getMaLoai().toLowerCase().contains(keyword.toLowerCase()) ||
                                loai.getTenLoai().toLowerCase().contains(keyword.toLowerCase())) {
                            resultList.add(loai);
=======
                    	return getListLoai();
                    }else {
                    	if(
                        loai.getMaLoai().toLowerCase().contains(keyword.toLowerCase()) ||
                        loai.getTenLoai().toLowerCase().contains(keyword.toLowerCase())){
                        resultList.add(loai);
>>>>>>> 07393a2d2d0d327f5091fdc45c171e5336a91e05
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
<<<<<<< HEAD

        return resultList;
    }

=======
        
        return resultList;
    }


>>>>>>> 07393a2d2d0d327f5091fdc45c171e5336a91e05
}
