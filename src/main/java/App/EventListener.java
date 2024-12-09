/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App;

import Controller.MainController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author gdpm
 */
public class EventListener implements ActionListener{

    private String route;
    private MainController mc = MainController.getInstance();
    
    public EventListener(String route){
        this.route = route;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        System.out.println("Event fired!");
        // Calls the method "CallRoute" from the main controller
        mc.callRoute(route);
    }
    
}
