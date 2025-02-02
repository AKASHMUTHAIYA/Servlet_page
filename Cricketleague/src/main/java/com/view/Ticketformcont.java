package com.view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Ticketformcont {
    private Connection con = null;
    private PreparedStatement pst = null;

    public Ticketformcont() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/AGDATA", "root", "root");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void storedata(Ticketform1 T) {
        String sql = "INSERT INTO Tickets (Matchname, Place, Date, Block) VALUES (?, ?, ?, ?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, T.getMatchname());
            pst.setString(2, T.getPlace());
            pst.setString(3, T.getDate());
            pst.setString(4, T.getBlock());
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
    }

    private void closeResources() {
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
