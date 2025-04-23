/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Administrator
 */
public class UpdatetaskModel {
    private int plantid;
    private String plantname;
    private String wateramount;
    private String nutrientamount;
    
    
    public UpdatetaskModel(int plantid,String plantname,String wateramount,String nutrientamount){
        this.plantid=plantid;
        this.plantname=plantname;
        this.wateramount=wateramount;
        this.nutrientamount=nutrientamount;
    
    }
            public int getplantid(){
        return plantid;
    }
      
      public String getplantname(){
        return plantname;
    }
      
       public String getwateramount(){
        return wateramount;
    }
       
        public String getnutrientamount(){
        return nutrientamount;
    }
        
        
    public void setplantid(int Did){
       plantid = plantid;
   }
    public void setplantname(String name){
       plantname = plantname;
   }
     
     public void setwateramount(String symptoms){
       wateramount= wateramount;
   }
     
      public void setnutrientamount(String treatments){
       nutrientamount = nutrientamount;
   }
}
