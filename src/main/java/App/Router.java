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
    
    public void map_routes(String[][] routes){
        // Iterates over the routes to map them
        for(int i = 0; i < routes.length; i++){
            route_map.put(routes[i][0], i);
        }
        
    }
    
    public int find_route(String route){return route_map.get(route);}
    
    
}
