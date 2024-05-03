package com.quanlikho.Connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ConnectJDBC {
//	 	private String user = "sa"; 
//	    private String password = "sa"; 
//	    private String url = "jdbc:sqlserver://DESKTOP-QSKCUSA:1433;databaseName=quanlikho;integratedSecurity=true;encrypt=true;trustServerCertificate=true"; 
	    private Connection connection = null; 
	    private Statement statement = null; 
		String url = "jdbc:mySQL://localhost:3306/quanlikho";
		String user = "root";
		String password = "";
	    public void Connect()
	    {
	         try {
	        	 Class.forName("com.mysql.cj.jdbc.Driver");
	        	 connection = DriverManager.getConnection(url, user, password);
	        } catch (ClassNotFoundException | SQLException ex) {
	            Logger.getLogger(ConnectJDBC.class.getName()).log(Level.SEVERE, null, ex);
	        }
	    }
	    public void disConnect()
	    { 
	        try{
	        	if (this.statement != null) {
	        	    this.statement.close();
	        	}
	        	connection.close();
	        }catch (SQLException E){}
	    }
	    
	    public ResultSet executeQuery(String sql)
	    {
	        ResultSet rs = null;
	        try {
	            Connect();
	            statement = connection.createStatement();
	            rs = statement.executeQuery(sql);
	        } catch (SQLException ex) {
	            Logger.getLogger(ConnectJDBC.class.getName()).log(Level.SEVERE, null, ex);
	        }
	        return rs;
	    }
	    
	    public void executeUpdate(String sql)
	    {
	        try {
	            Connect();
	            statement = connection.createStatement();
	            statement.executeUpdate(sql);
	            disConnect();
	        } catch (SQLException ex) {
	            Logger.getLogger(ConnectJDBC.class.getName()).log(Level.SEVERE, null, ex);
	        }
	    }
	    public  Connection getConnection()
	    {
	        Connect();
	        return connection;
	    }
	    public boolean isConnect()
	    {
	        return connection!=null?true:false;
	    }
}
