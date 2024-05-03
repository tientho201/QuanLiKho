package com.quanlikho.BUS;

import java.util.ArrayList;

import com.quanlikho.DAO.*;
import com.quanlikho.DTO.*;

public class PhieuNhapHangBUS {
	private ArrayList<PhieuNhapHangDTO> ds;

	public PhieuNhapHangBUS() {

	}

	public PhieuNhapHangBUS(int i1) {
		list();
	}

	public ArrayList<PhieuNhapHangDTO> getList() {
		return ds;
	}

	public PhieuNhapHangDTO get(String MaPNH) {
		for (PhieuNhapHangDTO pnh : ds) {
			if (pnh.getMaPNH().equals(MaPNH)) {
				return pnh;
			}
		}
		return null;
	}

	public void list() {
		PhieuNhapHangDAO pnhDAO = new PhieuNhapHangDAO();
		ds = new ArrayList<>();
		ds = pnhDAO.list();

	}

	public void add(PhieuNhapHangDTO pnh) {
		ds.add(pnh);
		PhieuNhapHangDAO pnhDAO = new PhieuNhapHangDAO();
		pnhDAO.add(pnh);
	}

	public void update(PhieuNhapHangDTO pnh) {
		for (int i = 0; i < ds.size(); i++) {
			if (ds.get(i).getMaPNH().equals(pnh.getMaPNH())) {
				ds.set(i, pnh);
				PhieuNhapHangDAO pnhDAO = new PhieuNhapHangDAO();
				pnhDAO.update(pnh);
				return;
			}
		}
	}

	public void delete(String MaPNH) {
		for (PhieuNhapHangDTO pnh : ds) {
			if (pnh.getMaPNH().equals(MaPNH)) {
				ds.remove(pnh);
				PhieuNhapHangDAO pnhDAO = new PhieuNhapHangDAO();
				pnhDAO.delete(MaPNH);
				return;
			}
		}
	}

	public boolean checkMaPNH(String maPNH) {
		for (PhieuNhapHangDTO pnh : ds) {
			if (pnh.getMaPNH().equals(maPNH)) {
				return true ; 
			}
		}
		return false ; 
	}
	public boolean checkMaNCC(String maNCC) {
		for (PhieuNhapHangDTO pnh : ds) {
			if (pnh.getMaNCC().equals(maNCC)) {
				return true ; 
			}
		}
		return false ; 
	}
	public boolean checkMaNV(String maNV) {
		for (PhieuNhapHangDTO pnh : ds) {
			if (pnh.getTenDangNhap().equals(maNV)) {
				return true ; 
			}
		}
		return false ; 
	}
	public boolean checkMaPNHvaMaNCCvaMaNVvaNgayNhap(String mapnh , String mancc , String manv , String ngaynhap) {
		for (PhieuNhapHangDTO pnh : ds) {
			if (pnh.getMaPNH().equals(mapnh) && pnh.getMaNCC().equals(mancc) &&  pnh.getTenDangNhap().equals(manv) && pnh.getNgayNhap().equals(ngaynhap)) {
				return true ; 
			}
		}
		return false ; 
	}
	public String PutOnNgayNhap(String maPN) {
		for (PhieuNhapHangDTO pnh : ds) {
			if(pnh.getMaPNH().equals(maPN)) {
				return pnh.getNgayNhap();
			}
		}
		return null ; 
	}
}
