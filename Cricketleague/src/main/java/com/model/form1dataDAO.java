package com. model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class form1dataDAO {
	Connection con=null;
	PreparedStatement pst=null;
	ResultSet rs=null;
	
	public form1dataDAO()
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/AGDATA","root","root");
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	public void saveData(form1data f1)
	{
		String sql="insert into new_table(Title,Place,Date) values(?,?,?)";
		try
		{
			pst=con.prepareStatement(sql);
			pst.setString(1, f1.getTitle());
			pst.setString(2, f1.getPlace());
			pst.setString(3, f1.getDate());
			pst.executeUpdate();			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	public ResultSet retrievedata()
	{
		String sql="select title, place,date from new_table";
		try {
			pst=con.prepareStatement(sql);
			rs=pst.executeQuery();
			}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return rs;
	}
}
