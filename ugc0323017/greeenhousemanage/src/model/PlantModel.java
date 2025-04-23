/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Administrator
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class PlantModel {
    private int plantId;
    private String name;
    private double waterAmount;
    private double nutAmount;

    public PlantModel(int plantId, String name, double waterAmount, double nutAmount) {
        this.plantId = plantId;
        this.name = name;
        this.waterAmount = waterAmount;
        this.nutAmount = nutAmount;
    }

    public int getPlantId() {
        return plantId;
    }

    public void setPlantId(int plantId) {
        this.plantId = plantId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWaterAmount() {
        return waterAmount;
    }

    public void setWaterAmount(double waterAmount) {
        this.waterAmount = waterAmount;
    }

    public double getNutAmount() {
        return nutAmount;
    }

    public void setNutAmount(double nutAmount) {
        this.nutAmount = nutAmount;
    }
}
