package com.quanlikho.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.quanlikho.Connect.ConnectJDBC;
import com.quanlikho.DTO.AccountDTO;

public class AccountDAO {
	private ConnectJDBC connection = new ConnectJDBC();

	public AccountDAO() {

	}
	public ArrayList<AccountDTO> list(){
		 ArrayList<AccountDTO> ds = new ArrayList<AccountDTO>();
		 try {
			 String sql = "SELECT * FROM Account "; 
			  ResultSet rs = connection.executeQuery(sql);
			  while(rs.next()) {
				  String tenDangNhap = rs.getString("TenDangNhap");
				  String hovaTen = rs.getString("HovaTen"); 
				  String email = rs.getString("Email"); 
				  String password = rs.getString("Password"); 
				  String role = rs.getString("Role"); 
				  int enable = rs.getInt("Enable"); 
				  AccountDTO accountDTO = new AccountDTO(tenDangNhap ,hovaTen ,email,password , role, enable);
				  ds.add(accountDTO);
			  }
			  rs.close();
			  connection.disConnect();
		 }catch(SQLException ex) {
			 Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
		 }
		return ds;
	}
	public void add(AccountDTO acc) {
		ConnectJDBC connection = new ConnectJDBC();
		String sql = "INSERT INTO Account  VALUES(";
		sql += "'" + acc.getTenDangNhap() +"',";
		sql += "N'" + acc.getHovaTen() +"',";
		sql += "N'" + acc.getEmail() +"',";
		sql += "N'" + acc.getPassword() +"', ";
		sql += "N'" + acc.getRole() +"',";
		sql += "" + acc.getEnable() +");";
		System.out.println(sql);
	    connection.executeUpdate(sql);
	}
	public void update(AccountDTO acc) {
		ConnectJDBC connection = new ConnectJDBC();
		String sql = "UPDATE Account SET ";
		sql += "HovaTen = N'" + acc.getHovaTen() +"', ";
		sql += "Email = N'" + acc.getEmail() +"', ";
		sql += "Password = N'" + acc.getPassword() +"', ";
		sql += "Role = N'" + acc.getRole() +"', ";
		sql += "Enable = " + acc.getEnable() +" ";
		sql += "Where TenDangNhap = '"+acc.getTenDangNhap()+"';";
	    System.out.println(sql);
	    connection.executeUpdate(sql);
	}
	public void delete(String TenDangNhap) {
		ConnectJDBC connection = new ConnectJDBC();
        String sqlAccount = "DELETE FROM Account  WHERE TenDangNhap='"+ TenDangNhap+"'";
        connection.executeUpdate(sqlAccount);
	}
}
