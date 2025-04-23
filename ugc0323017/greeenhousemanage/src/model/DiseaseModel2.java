/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Administrator
 */
import java.util.List;
public class DiseaseModel2 {
 private int Disease_Id;
    private String symptom;

    public DiseaseModel2(int Disease_Id, String symptom) {
        this.Disease_Id = Disease_Id;
        this.symptom = symptom;
    }

    public int getDisease_Id() {
        return Disease_Id;
    }

    public String getSymptom() {
        return symptom;
    }
}
