/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Administrator
 */
public class ToolModel {
   private String toolName;
    private int connu;
    private String handoverTime;
    
    // Constructor
    public ToolModel(String toolName, int connu, String handoverTime) {
        this.toolName = toolName;
        this.connu = connu;
        this.handoverTime = handoverTime;
    }

 
  
    
    // Getters and Setters
    public String getToolName() {
        return toolName;
    }
    
    public void setToolName(String toolName) {
        this.toolName = toolName;
    }
    
    public int getConnu() {
        return connu;
    }
    
    public void setConnu(int connu) {
        this.connu = connu;
    }
    
    public String getHandoverTime() {
        return handoverTime;
    }
    
    public void setHandoverTime(String handoverTime) {
        this.handoverTime = handoverTime;
    }
}
