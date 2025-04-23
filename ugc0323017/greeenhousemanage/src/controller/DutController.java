/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author Administrator
 */
import model.DiseaseModel;
import java.sql.*;
import javax.swing.JOptionPane;
public class DutController {
    // Database connection constants
    private static final String DB_URL = "jdbc:mysql://localhost:3306/whiteleafagri";
    private static final String USER = "root";
    private static final String PASS = "";
    
    public boolean deleteDisease(int diseaseId) {
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            String sql = "DELETE FROM Disease WHERE Disease_ID = ?";
            
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, diseaseId);
            
            int rowsAffected = pstmt.executeUpdate();
            pstmt.close();
            conn.close();
            
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
