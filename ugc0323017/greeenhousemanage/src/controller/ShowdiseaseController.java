/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author Administrator
 */
import java.sql.Statement;
import model.DiseaseModel2;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import view.ShowDetails;
public class ShowdiseaseController {
    private ShowDetails view;
    
    public ShowdiseaseController(ShowDetails view) {
        this.view = view;
    }
     public void displayAllPlants() {
        List<DiseaseModel2> diseases = getAllPlants();
        updateTable(diseases);
    }
 
    private List<DiseaseModel2> getAllPlants() {
        List<DiseaseModel2> diseases = new ArrayList<>();

        try {
            // Update these with your actual database credentials
            String url = "jdbc:mysql://localhost:3306/whiteleafagri";
            String username = "root";
            String password = "";
            Connection connection = DriverManager.getConnection(url, username, password);

            String query = "SELECT Disease_ID,symptoms  FROM Disease";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                int Disease_Id = rs.getInt("Disease_Id");
                String symptom = rs.getString("symptoms");
               

                DiseaseModel2 Disease = new DiseaseModel2(Disease_Id,symptom);
                diseases.add(Disease);
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return diseases;
    }
      private void updateTable(List<DiseaseModel2> diseases) {
        DefaultTableModel model = (DefaultTableModel) view.getjtable2().getModel();
        model.setRowCount(0); // Clear existing rows

        for (DiseaseModel2 Disease : diseases) {
            Object[] row = {
                Disease.getDisease_Id(),
                Disease.getSymptom(),
               
            };
            model.addRow(row);
        }
    }
}
