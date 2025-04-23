/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Administrator
 */
public class WorkerModel {
    private int worker_ID;
    private String name;
    private String email;
    private String username;
    private String password;
    
    // Default constructor
    public WorkerModel() {}
    
    // Parameterized constructor
    public WorkerModel(String name, String email, String username, String password) {
        this.worker_ID = worker_ID;
        this.name = name;
        this.email = email;
        this.username = username;
        this.password = password;
    }
    
    // Getters and Setters
    public int getWorker_ID() {
        return worker_ID;
    }
    
    public void setWorker_ID(int worker_ID) {
        this.worker_ID = worker_ID;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
}
