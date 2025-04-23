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
import java.sql.DriverManager;
import java.sql.Connection;
import model.PlantModel;
import view.SeeTask;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class PlantController {
    private final SeeTask view;
    
    public PlantController(SeeTask view) {
        this.view = view;
    }
    
    public void displayAllPlants() {
        List<PlantModel> plants = getAllPlants();
        updateTable(plants);
    }
    
    private List<PlantModel> getAllPlants() {
        List<PlantModel> plants = new ArrayList<>();

        try {
            // Update these with your actual database credentials
            String URL = "jdbc:mysql://localhost:3306/whiteleafagri";
            String USERNAME = "root";
            String PASSWORD = "";
            try (Connection connection = DriverManager.getConnection(URL, USERNAME , PASSWORD)) {
                String query = "SELECT * FROM Plant";
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                
                while (rs.next()) {
                    int plantId = rs.getInt("Plant_ID");
                    String name = rs.getString("name");
                    double waterAmount = rs.getDouble("wateramount");
                    double nutAmount = rs.getDouble("nut_amount");
                    
                    PlantModel plant = new PlantModel(plantId, name, waterAmount, nutAmount);
                    plants.add(plant);
                }
            }
        } catch (SQLException e) {
        }

        return plants;
    }

    private void updateTable(List<PlantModel> plants) {
        DefaultTableModel model = (DefaultTableModel) view.getJTable1().getModel();
        model.setRowCount(0); // Clear existing rows

        for (PlantModel plant : plants) {
            Object[] row = {
                plant.getPlantId(),
                plant.getName(),
                plant.getWaterAmount(),
                plant.getNutAmount()
            };
            model.addRow(row);
        }
    }
}
