/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Administrator
 */
public class GreenhouseModelA {
    
    private int Did;
    private String name;
    private String Symptoms;
    private String Treatments;
    

    
    
    public GreenhouseModelA (int Did,String name,String Symptoms,String Treatments){
        this.Did=Did;
        this.name=name;
        this.Symptoms=Symptoms;
        this.Treatments=Treatments;
    
        

    }
    
          public int getID(){
        return Did;
    }
      
      public String getname(){
        return name;
    }
      
       public String getsymptoms(){
        return Symptoms;
    }
       
        public String gettreatments(){
        return Treatments;
    }
        
        
        public void setID(int Did){
       Did = Did;
   }
    public void setname(String name){
       name = name;
   }
     
     public void setsymptoms(String symptoms){
       Symptoms = Symptoms ;
   }
     
      public void settreatments(String treatments){
       Treatments = Treatments;
   }
 //update task
      
      
  
    
}
