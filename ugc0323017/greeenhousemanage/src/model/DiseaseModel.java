/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Administrator
 */
public class DiseaseModel {
     private int diseaseId;
    private String name;
    private String symptoms;
    private String treatment;
    
    // Constructor
    public DiseaseModel(int diseaseId, String name, String symptoms, String treatment) {
        this.diseaseId = diseaseId;
        this.name = name;
        this.symptoms = symptoms;
        this.treatment = treatment;
    }
    
    // Getters and Setters
    public int getDiseaseId() { return diseaseId; }
    public void setDiseaseId(int diseaseId) { this.diseaseId = diseaseId; }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public String getSymptoms() { return symptoms; }
    public void setSymptoms(String symptoms) { this.symptoms = symptoms; }
    
    public String getTreatment() { return treatment; }
    public void setTreatment(String treatment) { this.treatment = treatment; }
    
        
}

