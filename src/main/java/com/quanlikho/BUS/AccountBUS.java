package com.quanlikho.BUS;

import java.util.ArrayList;

import com.quanlikho.DAO.AccountDAO;
import com.quanlikho.DTO.AccountDTO;

public class AccountBUS {
	private ArrayList<AccountDTO> ds;
	public AccountBUS() {

	}
	public ArrayList<AccountDTO> getList() {
		return ds;
	}

	public AccountBUS(int i1) {
		list();
	}

	public AccountDTO get(String TenDangNhap) {
		for (AccountDTO AC : ds) {
			if (AC.getTenDangNhap().equals(TenDangNhap)) {
				return AC;
			}
		}
		return null;
	}

	public void list() {
		AccountDAO accDAO = new AccountDAO();
		ds = new ArrayList<>();
		ds = accDAO.list();
	
	}

	public void addAcc(AccountDTO acc) {
		ds.add(acc);
		AccountDAO accDAO = new AccountDAO();
		accDAO.add(acc);
	}

	public void updateAcc(AccountDTO acc) {
		for (int i = 0; i < ds.size(); i++) {
			if (ds.get(i).getTenDangNhap().equals(acc.getTenDangNhap())) {
				ds.set(i, acc);
				AccountDAO accDAO = new AccountDAO();
				accDAO.update(acc);
			}
		}
	}

	public void delete(String tenDangNhap) {
		for (AccountDTO acc : ds) {
			if (acc.getTenDangNhap().equals(tenDangNhap)) {
				ds.remove(acc);
				AccountDAO accDAO = new AccountDAO();
				accDAO.delete(tenDangNhap);
				return;
			}
		}
	}
	public boolean checkTenDangNhap(String tenDangNhap) {
		for (AccountDTO acc : ds) {
			if (acc.getTenDangNhap().equals(tenDangNhap)) {
				return true;
			}
		}
		return false;
	}

	public boolean checkPassword(String tenDangNhap, String password) {
		for (AccountDTO acc : ds) {
			if (acc.getPassword().equals(password) && acc.getTenDangNhap().equals(tenDangNhap)) {
				return true;
			}
		}
		return false;
	}

	public String PutOnRole(String tenDangNhap) {
		for (AccountDTO acc : ds) {
			if (acc.getTenDangNhap().equals(tenDangNhap)) {
				return acc.getRole();
			}
		}
		return null;
	}
	public String PutOnHovaTen(String tenDangNhap) {
		for (AccountDTO acc : ds) {
			if (acc.getTenDangNhap().equals(tenDangNhap)) {
				return acc.getHovaTen();
			}
		}
		return null;
	}
	public int checkEnable(String tenDangNhap) {
	    for (AccountDTO acc : ds) {
	        if (acc.getTenDangNhap().equals(tenDangNhap)) {
	            return acc.getEnable();
	        }
	    }
	    return -1; // Hoặc một giá trị khác đại diện cho việc không tìm thấy
	}

}
