/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App;

import Controller.MainController;
import Helpers.Observer.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author gdpm
 */
public class Router {
    
    ArrayList<ObserverInterface> observers = new ArrayList<ObserverInterface>();
    
    Map<String, Integer> route_map = new HashMap<>();   
    private String[] routesHistory;
    private String[] routeTypeHistory;
    private String[][] callerHistory;
    private String currentRoute;
    private int currentIndex = -1;
    
    private App app;
    
    
    Logger logger = Logger.getInstance();
    
    public Router(App appInstance){
        routesHistory = new String[20];
        routeTypeHistory = new String[20];
        callerHistory = new String[20][2];
        app = appInstance;
    }
    
    public void map_routes(String[][] routes){
        logger.newLog(0, "Routes Mapping", "Mapping every listed route.");
        // Iterates over the routes to map them
        for(int i = 0; i < routes.length; i++){
            route_map.put(routes[i][0], i);
        }
        
    }
    
    public int find_route(String route){return route_map.get(route);}
    
    public void updateHistory(String route, String routeType, String[] caller){
     
        currentIndex += 1;
        
        logger.newLog(1, "Update History", "Updating the routes history. \n Current index: "+currentIndex);
        
        if(currentIndex == routesHistory.length - 1){
            currentIndex = routesHistory.length - 1;
            shiftRoutes();
            logger.newLog(1, "Update History", "Shifting routes.");
        }
        
        routesHistory[currentIndex] = route;
        routeTypeHistory[currentIndex] = routeType;
        
        callerHistory[currentIndex] = caller;
        
        System.out.println("Current index: "+currentIndex+"\nCurrent route in the index: "+routesHistory[currentIndex]);
        System.out.println("Route History: "+Arrays.toString(routesHistory));
    }
    
    private boolean checkLoop(){
        
        logger.newLog(1, "Router", "Checking for loops.");
        
        String x = routesHistory[currentIndex];
        String y = routesHistory[currentIndex-1];
        String z = routesHistory[currentIndex-2];
            
        logger.newLog(1, "CheckLoop", "Current and past routes: \n"+x+"\n"+y+"\n"+z);
        
        String[] callerX = callerHistory[currentIndex];
        String[] callerY = callerHistory[currentIndex-1];
        String[] callerZ = callerHistory[currentIndex-2];
        
        logger.newLog(1, "CheckLoop", "Past routes callers: \n"+callerX[0]+"\n"+callerY[0]+"\n"+callerZ[0]);
        
        System.out.println("CallerX: "+callerX[0]+"\nCallerY: "+callerY[0]+"\nCallerZ: "+callerZ[0]);
        
        boolean xz = (x == z);
        boolean yIsPost = (routeTypeHistory[currentIndex - 1] == "POST");
        
        System.out.println("xz: "+xz+"\nyCallsX: "+yIsPost);
        
        if(xz && yIsPost)
            return true;
        
        return false;
    }
    
    private void shiftRoutes(){
        
        for(int i = 0; i < routesHistory.length - 1; i++){
            routesHistory[i] = routesHistory[i+1];
            routeTypeHistory[i] = routeTypeHistory[i+1];
        }
        
    }
    
    public String nextRoute(){
        
        if((currentIndex == routesHistory.length - 1) || (routesHistory[currentIndex+1] == null))
            return null;
        
        currentIndex += 1;
        
        return routesHistory[currentIndex];
    }
    
    public String previousRoute(){
        
        System.out.println("Route History: "+Arrays.toString(routesHistory));
        
        if(currentIndex == 0)
            return null;
        
        System.out.println("Current Index: "+currentIndex);
        
        if(currentIndex > 2){
            currentIndex = currentIndex-1;
            if("POST".equals(routeTypeHistory[currentIndex])){
                observers.add(new RouterObserver("confirmPost", App.getInstance(), Logger.getInstance()));
                return "systemConfirmRePost";
            }
        }else
            currentIndex -= 1;
        
        System.out.println("Previous Route: "+routesHistory[currentIndex]);
        
        return routesHistory[currentIndex];
    }

    public String confirmPost(boolean confirmation) {
        
        for(int i = 0; i < observers.size(); i++){
            if(observers.get(i).getName().equals("confirmPost"))
                return observers.get(i).notify((confirmation) ? "confirm" : "cancel");
        }
        
        return null;
    }

    public String currentRoute() {
        return routesHistory[currentIndex];
    }
    
    
    
}
