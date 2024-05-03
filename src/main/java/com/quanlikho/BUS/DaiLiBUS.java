package com.quanlikho.BUS;

import java.util.ArrayList;

import com.quanlikho.DAO.DaiLiDAO;
import com.quanlikho.DTO.DaiLiDTO;

public class DaiLiBUS {
	private ArrayList<DaiLiDTO> ds;
	public DaiLiBUS() {

	}
	public ArrayList<DaiLiDTO> getList() {
		return ds;
	}

	public DaiLiBUS(int i1) {
		list();
	}

	public DaiLiDTO get(String madl) {
		for (DaiLiDTO dl : ds) {
			if (dl.getMaDL().equals(madl)) {
				return dl;
			}
		}
		return null;
	}

	public void list() {
		DaiLiDAO dlDAO = new DaiLiDAO();
		ds = new ArrayList<>();
		ds = dlDAO.list();
	
	}

	public void add(DaiLiDTO dl) {
		ds.add(dl);
		DaiLiDAO dlDAO = new DaiLiDAO();
		dlDAO.add(dl);
	}

	public void update(DaiLiDTO dl) {
		for (int i = 0; i < ds.size(); i++) {
			if (ds.get(i).getMaDL().equals(dl.getMaDL())) {
				ds.set(i, dl);
				DaiLiDAO dlDAO = new DaiLiDAO();
				dlDAO.update(dl);
			}
		}
	}
	
	public void delete(String madl) {
		for (DaiLiDTO dl : ds) {
			if (dl.getMaDL().equals(madl)) {
				ds.remove(dl);
				DaiLiDAO dlDAO = new DaiLiDAO();
				dlDAO.delete(madl);
				return;
			}
		}
	}
	public boolean checkMaDL( String madl) {
		for (DaiLiDTO dl : ds) {
			if(dl.getMaDL().equals(madl)) {
				return true ; 
			}
		}
		return false ; 
	}
}
