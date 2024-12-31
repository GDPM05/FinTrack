/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author gdpm
 */
public class Router {
    
    Map<String, Integer> route_map = new HashMap<>();   
    private String[] routesHistory;
    private String currentRoute;
    private int currentIndex;
    
    public Router(){
        routesHistory = new String[20];
    }
    
    public void map_routes(String[][] routes){
        // Iterates over the routes to map them
        for(int i = 0; i < routes.length; i++){
            route_map.put(routes[i][0], i);
        }
        
    }
    
    public int find_route(String route){return route_map.get(route);}
    
    
    
    public void updateCurrentRoute(String route){
        System.out.println("Current route: "+currentRoute);
        
        if(route != currentRoute){
            currentRoute = route;
        }
        
        
        
        System.out.println("Current route: "+currentRoute);
    }
    
    // Method responsible for shifting all the indexes to the left, once the maximum is suprassed
    private void shiftHistory(){
        
        routesHistory[0] = null;
        
        // Goes through every index in the array
        for(int i = 0; i < routesHistory.length; i++){
            // Checks if it's not the last one
            if(i != routesHistory.length - 1)
                // Takes the next value and put into the current
                routesHistory[i] = routesHistory[i+1];
            
        }
    }
    
}
