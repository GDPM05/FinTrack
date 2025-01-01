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
    private int currentIndex = 0;
    
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
        
        // Check's if the currentRoute is different than the one before
        if(route != currentRoute){
            currentRoute = route;
        }
        // If the currentIndex is, in this case, 19, updates it to 19, to keep it in the boundaries and shift's all the routes 
        if(currentIndex == routesHistory.length-1){
            currentIndex = routesHistory.length- 1;
            shiftHistory();
        }
        
        routesHistory[currentIndex] = route;
        System.out.println("Route History | Current Route: "+routesHistory[currentIndex]+"\nCurrent Index: "+currentIndex);
        
        currentIndex++;
        
        System.out.println("Current route: "+currentRoute);
    }
    
    public String nextRoute(){
        System.out.println("Current 111 index: "+currentIndex);
        
        if(routesHistory[currentIndex] != null && (currentIndex < routesHistory.length)){
            return routesHistory[currentIndex];
        }
        
        return null;
    }
    
    public String previousRoute(){
        
        currentIndex = (currentIndex-1 > 0) ? currentIndex-1 : 1;
        
        return routesHistory[currentIndex-1];
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
