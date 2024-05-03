package com.quanlikho.BUS;

import java.util.ArrayList;

import com.quanlikho.DAO.*;
import com.quanlikho.DTO.*;

public class ChiTietPhieuNhapBUS {
	private ArrayList<ChiTietPhieuNhapDTO> ds;

	public ChiTietPhieuNhapBUS() {

	}

	public ChiTietPhieuNhapBUS(int i1) {
		list();
	}

	public ArrayList<ChiTietPhieuNhapDTO> getList() {
		return ds;
	}

	public ChiTietPhieuNhapDTO get(String MaPNH, String MaSP) {
		for (ChiTietPhieuNhapDTO ctpn : ds) {
			if (ctpn.getMaPNH().equals(MaPNH) && ctpn.getMaSP().equals(MaSP)) {
				return ctpn;
			}
		}
		return null;
	}

	public void list() {
		ChiTietPhieuNhapDAO ctpnDAO = new ChiTietPhieuNhapDAO();
		ds = new ArrayList<>();
		ds = ctpnDAO.list();

	}

	public void add(ChiTietPhieuNhapDTO ctpn) {
		ds.add(ctpn);
		ChiTietPhieuNhapDAO ctpnDAO = new ChiTietPhieuNhapDAO();
		ctpnDAO.add(ctpn);
	}

	public void update(ChiTietPhieuNhapDTO ctpn) {
		for (int i = 0; i < ds.size(); i++) {
			if (ds.get(i).getMaPNH().equals(ctpn.getMaPNH()) && ds.get(i).getMaSP().equals(ctpn.getMaSP())) {
				ds.set(i, ctpn);
				ChiTietPhieuNhapDAO ctpnDAO = new ChiTietPhieuNhapDAO();
				ctpnDAO.update(ctpn);
				return;
			}
		}
	}

	public void delete(String MaPNH) {
		for (ChiTietPhieuNhapDTO ctpn : ds) {
			if (ctpn.getMaPNH().equals(MaPNH) ) {
				ds.remove(ctpn);
				ChiTietPhieuNhapDAO ctpnDAO = new ChiTietPhieuNhapDAO();
				ctpnDAO.delete(MaPNH);
				return;
			}
		}
	}

	public boolean checkMaPNH(String MaPNH) {
		for (ChiTietPhieuNhapDTO ctpn : ds) {
			if (ctpn.getMaPNH().equals(MaPNH)) {
				return true;
			}
		}
		return false;
	}

	public boolean checkMaSP(String MaSP) {
		for (ChiTietPhieuNhapDTO ctpn : ds) {
			if (ctpn.getMaSP().equals(MaSP)) {
				return true;
			}
		}
		return false;
	}

	public boolean checkMaPNHvaMaSP(String MaPNH, String MaSP) {
		for (ChiTietPhieuNhapDTO ctpn : ds) {
			if (ctpn.getMaSP().equals(MaSP) && ctpn.getMaPNH().equals(MaPNH)) {
				return true;
			}
		}
		return false;

	}
	public int PutOnGia(String MaPNH) {
		for (ChiTietPhieuNhapDTO ctpn : ds) {
			if (ctpn.getMaPNH().equals(MaPNH)) {
				return ctpn.getDonGiaNhap();
			}
		}
		return 0 ;
	}
	public int PutOnSoLuong(String MaPNH) {
		for (ChiTietPhieuNhapDTO ctpn : ds) {
			if (ctpn.getMaPNH().equals(MaPNH)) {
				return ctpn.getSoLuong();
			}
		}
		return 0 ;
	}

	public ArrayList<ChiTietPhieuNhapDTO> getByMaPN(String MaPNH) {
		ArrayList<ChiTietPhieuNhapDTO> result = new ArrayList<>();
		for (ChiTietPhieuNhapDTO ctpn : ds) {
			if (ctpn.getMaPNH().equals(MaPNH)) {
				result.add(ctpn);
			}
		}
		return result;
	}

}
