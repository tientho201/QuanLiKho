package com.quanlikho.BUS;

import java.util.ArrayList;

import com.quanlikho.DAO.SanPhamDAO;
import com.quanlikho.DTO.SanPhamDTO;

public class SanPhamBUS {
	private ArrayList<SanPhamDTO> ds;
	private SanPhamDAO sanPhamDAO;
	
	public SanPhamBUS() {
		this.sanPhamDAO = new SanPhamDAO();
		list();

	}
	public ArrayList<SanPhamDTO> getList() {
		return ds;
	}

	public SanPhamBUS(int i1) {
		list();
	}

	public SanPhamDTO get(String MaSP) {
		for (SanPhamDTO sp : ds) {
			if (sp.getMaSP().equals(MaSP)) {
				return sp;
			}
		}
		return null;
	}

	public ArrayList<SanPhamDTO> list() {
	    SanPhamDAO spDAO = new SanPhamDAO();
	    ds = spDAO.list(); // Gán kết quả trả về từ spDAO.list() cho biến ds
	    return ds; // Trả về danh sách sản phẩm
	}



	public void add(SanPhamDTO sp) {
		ds.add(sp);
		SanPhamDAO spDAO = new SanPhamDAO();
		spDAO.add(sp);
	}

	public void update(SanPhamDTO sp) {
		for (int i = 0; i < ds.size(); i++) {
			if (ds.get(i).getMaSP().equals(sp.getMaSP())) {
				ds.set(i, sp);
				SanPhamDAO spDAO = new SanPhamDAO();
				spDAO.update(sp);
			}
		}
	}

	public void delete(String maSP) {
		for (SanPhamDTO sp : ds) {
			if (sp.getMaSP().equals(maSP)) {
				ds.remove(sp);
				SanPhamDAO spDAO = new SanPhamDAO();
				spDAO.delete(maSP);
				return;
			}
		}
	}
	public boolean checkMaSP(String MaSP) {
        for (SanPhamDTO sp : ds) {
            if (sp.getMaSP().equals(MaSP)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkDataIsReferenced(String maSP) {
        // Gọi tới DAO để kiểm tra liệu sản phẩm có được tham chiếu trong các phiếu nhập hoặc xuất không
        return sanPhamDAO.checkDataIsReferenced(maSP);
    }

    public ArrayList<SanPhamDTO> search(String selectedOption, String keyword) {
        ArrayList<SanPhamDTO> resultList = new ArrayList<>();
        
        // Lặp qua danh sách các sản phẩm
        for (SanPhamDTO sp : getList()) {
            switch (selectedOption) {
                case "Tất cả":
                	if (keyword.isEmpty()) {
                    	return getList();
                    }else {
                    // Tìm kiếm tất cả các trường dựa trên từ khóa
                    if (sp.getMaSP().toLowerCase().contains(keyword.toLowerCase()) ||
                        sp.getTenSP().toLowerCase().contains(keyword.toLowerCase()) ||
                        String.valueOf(sp.getSoLuong()).contains(keyword) ||
                        String.valueOf(sp.getGia()).contains(keyword) ||
                        sp.getMaLoai().toLowerCase().contains(keyword.toLowerCase()) ||
                        sp.getMaNSX().toLowerCase().contains(keyword.toLowerCase()) ||
                        sp.getGhiChu().toLowerCase().contains(keyword.toLowerCase())) {
                        resultList.add(sp);
                    }
                    }
                    break;
                case "Mã sản phẩm":
                    if (sp.getMaSP().toLowerCase().contains(keyword.toLowerCase())) {
                        resultList.add(sp);
                    }
                    break;
                case "Tên sản phẩm":
                    if (sp.getTenSP().toLowerCase().contains(keyword.toLowerCase())) {
                        resultList.add(sp);
                    }
                    break;
                case "Số lượng":
                    if (String.valueOf(sp.getSoLuong()).contains(keyword)) {
                        resultList.add(sp);
                    }
                    break;
                case "Giá":
                    if (String.valueOf(sp.getGia()).contains(keyword)) {
                        resultList.add(sp);
                    }
                    break;
                case "Mã loại":
                    if (sp.getMaLoai().toLowerCase().contains(keyword.toLowerCase())) {
                        resultList.add(sp);
                    }
                    break;
                case "Mã NSX":
                    if (sp.getMaNSX().toLowerCase().contains(keyword.toLowerCase())) {
                        resultList.add(sp);
                    }
                    break;
                case "Ghi chú":
                    if (sp.getGhiChu().toLowerCase().contains(keyword.toLowerCase())) {
                        resultList.add(sp);
                    }
                    break;
                default:
                    // Nếu không có lựa chọn nào phù hợp, không làm gì cả
                    break;
            }
        }
        
        return resultList;
    }
	public int countSoLuongSP() {
		int countSP = 0 ; 
		 for (SanPhamDTO sp : ds) {
			 countSP++;
		 }
		 return countSP ; 
	}
	public String PutOnTenSP(String maSP) {
		 for (SanPhamDTO sp : ds) {
			 if(sp.getMaSP().equals(maSP)) {
				 return sp.getTenSP();
			 }
			 
		 }
		 return null ; 
	}
	public int PutOnGia(String maSP) {
		 for (SanPhamDTO sp : ds) {
			 if(sp.getMaSP().equals(maSP)) {
				 return sp.getGia();
			 }
			 
		 }
		 return 0 ; 
	}
}

