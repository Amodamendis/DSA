/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author Amoda
 */
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.DiseaseModel;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
public class DiseaseController {
    // Database connection constants
    private static final String DB_URL = "jdbc:mysql://localhost:3306/whiteleafagri";
    private static final String USER = "root";
    private static final String PASS = ""; // Set your database password here
    
    public DiseaseModel searchDiseaseById(int diseaseId) {
        DiseaseModel disease = null;
        String query = "SELECT * FROM Disease WHERE Disease_ID = ?";
        
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setInt(1, diseaseId);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                disease = new DiseaseModel(
                    rs.getInt("Disease_ID"),
                    rs.getString("name"),
                    rs.getString("symptoms"),
                    rs.getString("treatment")
                );
            }
            

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return disease;
    }
    
    public void updateTableWithDisease(DefaultTableModel model, DiseaseModel disease) {
        // Clear existing rows
        model.setRowCount(0);
        
        if (disease != null) {
            // Add the disease data to the table
            model.addRow(new Object[]{
                disease.getDiseaseId(),
                disease.getName(),
                disease.getSymptoms(),
                disease.getTreatment()
            });
        }
    }
}
    

