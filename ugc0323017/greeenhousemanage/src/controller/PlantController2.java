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
import model.PlantModel;
import java.sql.*;
import javax.swing.JOptionPane;
public class PlantController2 {
// Database connection details
    private static final String URL = "jdbc:mysql://localhost:3306/whiteleafagri";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    
    // Delete plant method
    public boolean deletePlant(int plantId) {
        String query = "DELETE FROM Plant WHERE Plant_ID = ?";
        
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setInt(1, plantId);
            
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error deleting plant: " + e.getMessage(), 
                                        "Database Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
}
