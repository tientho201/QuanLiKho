package com.quanlikho.BUS;

import java.util.ArrayList;
import com.quanlikho.DAO.NhaSanXuatDAO;
import com.quanlikho.DTO.NhaSanXuatDTO;

public class NhaSanXuatBUS {
    private ArrayList<NhaSanXuatDTO> ds;
    private NhaSanXuatDAO nhaSanXuatDAO;

    public NhaSanXuatBUS() {
        this.nhaSanXuatDAO = new NhaSanXuatDAO();
        list();
    }

    public ArrayList<NhaSanXuatDTO> getList() {
        return ds;
    }

    public NhaSanXuatDTO get(String maNSX) {
        for (NhaSanXuatDTO nsx : ds) {
            if (nsx.getMaNSX().equals(maNSX)) {
                return nsx;
            }
        }
        return null;
    }

    public ArrayList<NhaSanXuatDTO> list() {
        ds = nhaSanXuatDAO.list();
        return ds;
    }

    // Thêm nhà sản xuất
    public void add(NhaSanXuatDTO nsx) {
        ds.add(nsx);
        nhaSanXuatDAO.add(nsx);
    }

    // Sửa thông tin nhà sản xuất
    public void update(NhaSanXuatDTO nsx) {
        for (int i = 0; i < ds.size(); i++) {
            if (ds.get(i).getMaNSX().equals(nsx.getMaNSX())) {
                ds.set(i, nsx);
                nhaSanXuatDAO.update(nsx);
                return;
            }
        }
    }

    // Xóa nhà sản xuất
    public void delete(String maNSX) {
        for (NhaSanXuatDTO nsx : ds) {
            if (nsx.getMaNSX().equals(maNSX)) {
                ds.remove(nsx);
                nhaSanXuatDAO.delete(maNSX);
                return;
            }
        }
    }
    public boolean checkMaNSX(String maNSX) {
        for (NhaSanXuatDTO nsx : ds) {
            if (nsx.getMaNSX().equals(maNSX)) {
                return true; // Mã nhà sản xuất đã tồn tại
            }
        }
        return false; // Mã nhà sản xuất chưa tồn tại
    }
    
    public boolean checkDataIsReferenced(String maNSX) {
        return nhaSanXuatDAO.checkDataIsReferenced(maNSX);
    }
    public ArrayList<NhaSanXuatDTO> search(String selectedOption, String keyword) {
        ArrayList<NhaSanXuatDTO> resultList = new ArrayList<>();
        
        // Lặp qua danh sách các nhà sản xuất
        for (NhaSanXuatDTO nsx : getList()) {
            switch (selectedOption) {
                case "Tất cả":
                    if (keyword.isEmpty()) {
                    	return getList();
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


}
