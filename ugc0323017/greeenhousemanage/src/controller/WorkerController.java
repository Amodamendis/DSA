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

public class WorkerController {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/whiteleafagri";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";
    
    public boolean validateInput(String username, String password) {
        if (username.length() < 5 || password.length() < 5) {
            JOptionPane.showMessageDialog(null, "Username and password must be at least 5 characters long!");
            return false;
        }
        
        boolean hasLetter = false;
        boolean hasNumber = false;
        
        // Check username
        for (char c : username.toCharArray()) {
            if (Character.isLetter(c)) hasLetter = true;
            if (Character.isDigit(c)) hasNumber = true;
        }
        
        if (!hasLetter || !hasNumber) {
            JOptionPane.showMessageDialog(null, "Username must contain both letters and numbers!");
            return false;
        }
        
        // Reset flags for password check
        hasLetter = false;
        hasNumber = false;
        
        // Check password
        for (char c : password.toCharArray()) {
            if (Character.isLetter(c)) hasLetter = true;
            if (Character.isDigit(c)) hasNumber = true;
        }
        
        if (!hasLetter || !hasNumber) {
            JOptionPane.showMessageDialog(null, "Password must contain both letters and numbers!");
            return false;
        }
        
        return true;
    }
    
    public boolean registerWorker(WorkerModel worker) {
        String sql = "INSERT INTO Worker (name, email, username, password) VALUES (?, ?, ?, ?)";
        
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, worker.getName());
            pstmt.setString(2, worker.getEmail());
            pstmt.setString(3, worker.getUsername());
            pstmt.setString(4, worker.getPassword());
            
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Database Error: " + e.getMessage());
            return false;
        }
    }
}
