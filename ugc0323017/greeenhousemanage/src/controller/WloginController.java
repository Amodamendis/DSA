/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author Administrator
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.WorkerModel;
import java.sql.*;
import javax.swing.JOptionPane;
public class WloginController {
private static final String DB_URL = "jdbc:mysql://localhost:3306/whiteleafagri";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = ""; // Add your database password here
    
    public boolean validateLogin(String username, String password) {
        try {
            Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            String query = "SELECT * FROM Worker WHERE username = ? AND password = ?";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, username);
            pst.setString(2, password);
            
            ResultSet rs = pst.executeQuery();
            boolean isValid = rs.next(); // If there's a result, credentials are valid
            
            rs.close();
            pst.close();
            conn.close();
            
            return isValid;
            
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Database connection error: " + e.getMessage());
            return false;
        }
    }
}
