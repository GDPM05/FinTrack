package Controller;

import Model.TransactionsModel;
import Views.HomeView;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author gdpm
 */
public class HomeController implements ControllerInterface{
    
    TransactionsModel model;
    
    public HomeController(){
        model = new TransactionsModel();
    }
    
    public void index(){
        String title = "FinTrack | Home";
        
        HomeView home = new HomeView(title);
    }
    
    public void transactions(){
     
        System.out.println("\nHello transactions!\n");
        
        Object[][] modelData = model.fetch(null, null);
        
        System.out.println("modelData: "+modelData.length);
        //System.out.println("modelData2: "+modelData[0].length);
        if(modelData.length > 0)
            for(int i = 0; i < modelData.length; i++){
                for(int j = 0; j < modelData[i].length; j++){
                    System.out.println("Data: "+modelData[i][j].toString());
                }
            }
        
    }
    
    
}
