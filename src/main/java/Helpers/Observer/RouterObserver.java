/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Helpers.Observer;

import App.App;
import App.Logger;

/**
 *
 * @author gdpm
 */
public class RouterObserver implements ObserverInterface{

    private App app;
    private Logger logger;
    
    private String name;
    
    public RouterObserver(String name, App appInstance, Logger loggerInstance){
        System.out.println("New Observer");
        app = appInstance;
        logger = loggerInstance;
        this.name = name;
    }
    
    @Override
    public String notify(String response) {
        return this.execute(response);
    }

    public String getName() {
        return name;
    }

    @Override
    public String execute(String response) {

        if(response == null){
            logger.newLog(3, "Route Observer", "Route Observer response was null.");
            return null;
        }
            
        
        if("confirm".equals(response)){
            //app.callRoute("systemConfirmPost", null, null);
            logger.newLog(1, "Route Observer", "Route observer response was \"confirm\", system confirm called.");
            return "systemPostConfirmed";
        }else if("cancel".equals(response)){
            //app.callRoute("systemCancelPost", null, null);
            logger.newLog(1, "Route Observer", "Route observer response was \"cancel\", system cancel called.");
            return "systemPostCanceled";
        }else{
            logger.newLog(2, "Route Observer", "Route observer response was invalid.");
            return null;
        }
            
    }
    
    
    
}
