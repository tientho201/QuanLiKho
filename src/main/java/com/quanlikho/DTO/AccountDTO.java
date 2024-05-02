package com.quanlikho.DTO;

public class AccountDTO {
	private String TenDangNhap ; 
	private String HovaTen ; 
	private String Password ; 
	private String Role ;
	private int Enable ; 
	private String Email;
	public AccountDTO(String tenDangNhap, String hovaTen, String email,String password, String role , int enable) {
		Email = email;
		TenDangNhap = tenDangNhap;
		HovaTen = hovaTen;
		Password = password;
		Role = role;
		Enable = enable;
	}
	public AccountDTO() {
		
	}
	
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getTenDangNhap() {
		return TenDangNhap;
	}
	public void setTenDangNhap(String tenDangNhap) {
		TenDangNhap = tenDangNhap;
	}
	public String getHovaTen() {
		return HovaTen;
	}
	public void setHovaTen(String hovaTen) {
		HovaTen = hovaTen;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getRole() {
		return Role;
	}
	public void setRole(String role) {
		Role = role;
	}
	public int getEnable() {
		return Enable;
	}
	public void setEnable(int enable) {
		Enable = enable;
	}
	@Override
	public String toString() {
		return "AccountDTO [TenDangNhap=" + TenDangNhap + ", HovaTen=" + HovaTen + ", Password=" + Password + ", Role="
				+ Role + ", Enable=" + Enable + ", Email=" + Email + "]";
	}
	
	
	
}
