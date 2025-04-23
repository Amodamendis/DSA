/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author Administrator
 */
import model.InventoryModel2;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class InventoryController2 {
    // Database connection constants
    private static final String DB_URL = "jdbc:mysql://localhost:3306/whiteleafagri";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    public void clearDatabase() {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement("TRUNCATE TABLE Inventory")) {
            stmt.executeUpdate();
            System.out.println("Database cleared successfully.");
        } catch (SQLException e) {
            System.out.println("Error clearing the database: " + e.getMessage());
        }
    }

    public List<InventoryModel2> getAllInventory() {
        List<InventoryModel2> inventoryList = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Inventory");
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                InventoryModel2 model = new InventoryModel2();
                model.setGreenhouseId(rs.getInt("greenhouse_ID"));
                model.setDescription(rs.getString("Description"));
                model.setStock(rs.getInt("stock"));
                model.setNumber(rs.getInt("number"));
                inventoryList.add(model);
            }
        } catch (SQLException e) {
            System.out.println("Error fetching inventory data: " + e.getMessage());
        }

        return inventoryList;
    }
}
