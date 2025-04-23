/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author Administrator
 */
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.UpdatetaskModel;
import view.UpdateTask;
public class GreenhouseController2 {
    
    // Database connection parameters
    private static final String URL = "jdbc:mysql://localhost:3306/whiteleafagri";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    
    // Method to check if plant exists
    public static boolean checkPlantExists(int plantId, String plantName) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            String query = "SELECT * FROM Plant WHERE Plant_ID = ? AND name = ?";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setInt(1, plantId);
            pst.setString(2, plantName);
            
            ResultSet rs = pst.executeQuery();
            boolean exists = rs.next();
            
            rs.close();
            pst.close();
            conn.close();
            
            return exists;
            
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    // Method to update plant information
    public static boolean updatePlant(UpdatetaskModel plant) {
        try {
            if (!checkPlantExists(plant.getplantid(), plant.getplantname())) {
                return false;
            }
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            String query = "UPDATE Plant SET wateramount = ?, nut_amount = ? WHERE Plant_ID = ? AND name = ?";
            PreparedStatement pst = conn.prepareStatement(query);
            
            pst.setString(1, plant.getwateramount());
            pst.setString(2, plant.getnutrientamount());
            pst.setInt(3, plant.getplantid());
            pst.setString(4, plant.getplantname());
            
            int rowsAffected = pst.executeUpdate();
            
            pst.close();
            conn.close();
            
            return rowsAffected > 0;
            
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
