package com.playerslist;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class NewPlayerDao {

	private Connection con = null;
	private PreparedStatement pst = null;

	public NewPlayerDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Agdata", "root", "root");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void saveData(Newplayerformdata n1) {
		String sql = "INSERT INTO Newplayer (playername, teamname, phonenumber, playerid) VALUES (?, ?, ?, ?)";

		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, n1.getPlayername());
			pst.setString(2, n1.getTeamname());
			pst.setString(3, n1.getPhonenumber());
			pst.setString(4, n1.getPlayerid());
			pst.executeUpdate(); // Execute the SQL statement
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pst != null) {
					pst.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
