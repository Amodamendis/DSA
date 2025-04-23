/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Administrator
 */
public class EnterharvestModel {
    
    
    private int greenhouse_ID;
    private String Description;
    private String stock1;
    
    
    public EnterharvestModel(int greenhouse_ID,String Description,String stock1){
    
        this.greenhouse_ID=greenhouse_ID;
        this.Description=Description;
        this.stock1=stock1;
        
    }
            public int getgid(){
        return greenhouse_ID;
    }
      
      public String getdesc(){
        return Description;
    }
      
       public String getstock1(){
        return stock1;
    }
       
   
        
        
    public void setgid(int Did){
       greenhouse_ID = greenhouse_ID;
   }
    public void setdesc(String name){
       Description = Description;
   }
     
     public void setstock1(String symptoms){
       stock1= stock1;
   }
}

    
    

    

