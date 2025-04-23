/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

// Model/Inventory.java
package model;

public class InventoryModel {
    private int greenhouseId;
    private String description;
    private int stock;
    private int number;
    
    // Constructor
    public InventoryModel(int greenhouseId, String description, int stock, int number) {
        this.greenhouseId = greenhouseId;
        this.description = description;
        this.stock = stock;
        this.number = number;
    }
    
    // Getters and Setters
    public int getGreenhouseId() {
        return greenhouseId;
    }
    
    public String getDescription() {
        return description;
    }
    
    public int getStock() {
        return stock;
    }
    
    public int getNumber() {
        return number;
    }
    public void setGreenhouseId(int greenhouseId) {
        this.greenhouseId = greenhouseId;
    }
        public void setDescription(String description) {
        this.description = description;
    }
        public void setStock(int stock) {
        this.stock = stock;
    }
        public void setNumber(int number) {
        this.number = number;
    }
}