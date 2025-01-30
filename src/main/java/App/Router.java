/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author gdpm
 */
public class Router {
    
    Map<String, Integer> route_map = new HashMap<>();   
    private String[] routesHistory;
    private String[] routeTypeHistory;
    private String[][] callerHistory;
    private String currentRoute;
    private int currentIndex = -1;
    
    Logger logger = Logger.getInstance();
    
    public Router(){
        routesHistory = new String[20];
        routeTypeHistory = new String[20];
        callerHistory = new String[20][2];
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
        
        if(currentIndex == 0)
            return null;
        
        if(currentIndex > 2)
            currentIndex = (checkLoop()) ? currentIndex-2 : currentIndex-1;
        else
            currentIndex -= 1;
        
        return routesHistory[currentIndex];
    }
    
    
}
