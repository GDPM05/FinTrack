package Controller;

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
    
    public void index(){
        String title = "FinTrack | Home";
        
        HomeView home = new HomeView(title);
    }
    
}
