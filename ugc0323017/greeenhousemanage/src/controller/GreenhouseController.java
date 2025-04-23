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
import model.GreenhouseModelA;
import model.UpdatetaskModel;
import model.EnterharvestModel;
import java.sql.ResultSet;


public class GreenhouseController {
    
 
    private static Connection connection;
    
        
    // Creating the database connection
    static {
        try {
            // Database connection constants
            String url = "jdbc:mysql://localhost:3306/whiteleafagri";
            String user = "root";
            String password = ""; 

            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Database connection established successfully.");
        } catch (SQLException ex) {
            System.err.println("Failed to establish database connection: " + ex.getMessage());
            throw new RuntimeException("Database connection failed", ex);
        }
    }

    public static boolean insert(GreenhouseModelA Disease) {
        boolean result = false;
        String insertSql = "INSERT INTO Disease(Disease_ID, name,symptoms,treatment) VALUES(?, ?, ?, ?)";

        try (PreparedStatement insertStmt = connection.prepareStatement(insertSql)) {
            insertStmt.setInt(1, Disease.getID());
            insertStmt.setString(2, Disease.getname());
            insertStmt.setString(3, Disease.getsymptoms());
            insertStmt.setString(4, Disease.gettreatments());
            insertStmt.executeUpdate();

            result = true;
            System.out.println("Disease details inserted successfully.");
        } catch (SQLException ex) {
            System.err.println("Error while inserting Disease details: " + ex.getMessage());
        }
        return result;
    }
    
    public static boolean insertenter(UpdatetaskModel Plant){
               boolean result = false;
        String insertSql = "INSERT INTO Plant(Plant_ID, name,wateramount,nut_amount) VALUES(?, ?, ?, ?)";

        try (PreparedStatement insertStmt = connection.prepareStatement(insertSql)) {
            insertStmt.setInt(1, Plant.getplantid());
            insertStmt.setString(2, Plant.getplantname());
            insertStmt.setString(3, Plant.getwateramount());
            insertStmt.setString(4, Plant.getnutrientamount());
            insertStmt.executeUpdate();
             
            result = true;
            System.out.println("Daily tasks  inserted successfully.");
            
        } catch (SQLException ex) {
            System.err.println("Error while inserting Daily tasks : " + ex.getMessage());
        }
        return result;  
         
         
    }
    
    
        public static boolean enterharvest(EnterharvestModel inventory){
               boolean result = false;
        String insertSql = "INSERT INTO Inventory(greenhouse_ID,Description,stock) VALUES(?, ?, ?)";

        try (PreparedStatement insertStmt = connection.prepareStatement(insertSql)) {
            insertStmt.setInt(1, inventory.getgid());
            insertStmt.setString(2, inventory.getdesc());
            insertStmt.setString(3, inventory.getstock1());
            
            insertStmt.executeUpdate();

            result = true;
            System.out.println("Harvest  inserted successfully.");
        } catch (SQLException ex) {
            System.err.println("Error while inserting harvest : " + ex.getMessage());
        }
        return result;  
         
         
    }


        

       
        
     
    
}
