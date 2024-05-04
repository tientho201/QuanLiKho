package com.quanlikho.BUS;

import java.util.ArrayList;
import com.quanlikho.DAO.LoaiDAO;
import com.quanlikho.DTO.LoaiDTO;

public class LoaiBUS {
    private ArrayList<LoaiDTO> ds;
    private LoaiDAO LoaiDAO;

    public LoaiBUS() {
        this.LoaiDAO = new LoaiDAO();
        list();
    }

    public ArrayList<LoaiDTO> getList() {
        return ds;
    }

    public LoaiDTO get(String maLoai) {
        for (LoaiDTO loai : ds) {
            if (loai.getMaLoai().equals(maLoai)) {
                return loai;
            }
        }
        return null;
    }

    public ArrayList<LoaiDTO> list() {
        ds = LoaiDAO.list();
        return ds;
    }

    // Thêm nhà sản xuất
    public void add(LoaiDTO loai) {
        ds.add(loai);
        LoaiDAO.add(loai);
    }

    // Sửa thông tin nhà sản xuất
    public void update(LoaiDTO loai) {
        for (int i = 0; i < ds.size(); i++) {
            if (ds.get(i).getMaLoai().equals(loai.getMaLoai())) {
                ds.set(i, loai);
                LoaiDAO.update(loai);
                return;
            }
        }
    }

    // Xóa nhà sản xuất
    public void delete(String maLoai) {
        for (LoaiDTO Loai : ds) {
            if (Loai.getMaLoai().equals(maLoai)) {
                ds.remove(Loai);
                LoaiDAO.delete(maLoai);
                return;
            }
        }
    }
    public boolean checkMaLoai(String maLoai) {
        for (LoaiDTO loai : ds) {
            if (loai.getMaLoai().equals(maLoai)) {
                return true; // Mã nhà sản xuất đã tồn tại
            }
        }
        return false; // Mã nhà sản xuất chưa tồn tại
    }
    
    public boolean checkDataIsReferenced(String maLoai) {
        return LoaiDAO.checkDataIsReferenced(maLoai);
    }
    public ArrayList<LoaiDTO> search(String selectedOption, String keyword) {
        ArrayList<LoaiDTO> resultList = new ArrayList<>();
        
        // Lặp qua danh sách các nhà sản xuất
        for (LoaiDTO loai : getList()) {
            switch (selectedOption) {
                case "Tất cả":
                    if (keyword.isEmpty()) {
                    	return getList();
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
