/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.InventoryModel;

/**
 *
 * @author Administrator
 */
public class InventoryController {
       // Database connection constants
    private static final String URL = "jdbc:mysql://localhost:3306/whiteleafagri";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    
    public List<InventoryModel> getAllInventory() {
        List<InventoryModel> inventoryList = new ArrayList<>();  
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            String query = "SELECT * FROM Inventory";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);            
            while (rs.next()) {
                InventoryModel inventory = new InventoryModel(
                    rs.getInt("greenhouse_ID"),
                    rs.getString("Description"),
                    rs.getInt("stock"),
                    rs.getInt("number")
                );
                inventoryList.add(inventory);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return inventoryList;
    }   
    public void updateTableModel(DefaultTableModel model, List<InventoryModel> inventoryList) {
        model.setRowCount(0); // Clear existing rows
        
        for (InventoryModel inventory : inventoryList) {
            Object[] row = {
                inventory.getGreenhouseId(),
                inventory.getDescription(),
                inventory.getStock(),
                inventory.getNumber()
            };
            model.addRow(row);
        }
    }
    
    
    
    
}
    
