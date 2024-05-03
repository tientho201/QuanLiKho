package com.quanlikho.BUS;


import java.util.ArrayList;
import com.quanlikho.DAO.*;
import com.quanlikho.DTO.*;

public class PhieuXuatBUS {
    private PhieuXuatDAO phieuXuatDAO;

    public PhieuXuatBUS() {
        phieuXuatDAO = new PhieuXuatDAO();
    }

    public int themPhieuXuat(PhieuXuatDTO phieuXuat) {
        return phieuXuatDAO.insert(phieuXuat);
    }

    public int capNhatPhieuXuat(PhieuXuatDTO phieuXuat) {
        return phieuXuatDAO.update(phieuXuat);
    }

    public int xoaPhieuXuat(PhieuXuatDTO phieuXuat) {
        return phieuXuatDAO.delete(phieuXuat);
    }

    public ArrayList <PhieuXuatDTO> layDanhSachPhieuXuat() {
    	return phieuXuatDAO.selectAll();
}

public PhieuXuatDTO layPhieuXuatTheoId(String maPhieu) {
    return phieuXuatDAO.selectById(maPhieu);
}

// Các phương thức khác có thể được thêm vào ở đây để xử lý logic kinh doanh phức tạp hơn
}