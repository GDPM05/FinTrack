/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import App.Config;
import App.Database;
import App.Router;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gdpm
 */
public class MainController {
    
    /**
     * To ensure that the MainController has only one instance throughout the application and that this instance is 
     * globally accessible, I implemented it using the Singleton design pattern.
     */
    
    private static MainController instance;
    
    private Database db;
    private Router router;
    private List<ControllerInterface> controllers = new ArrayList<>();
    private Map<String, Integer> controllers_map = new HashMap<>();
    
    private MainController(){
        
        // Method responsible for kickstarting our application
        this.prepare();
    }
        
    private void prepare(){
        // Initializes the database
        db = new Database();
        
        // Initializes and stores the controllers
        getControllers();
        
        // Initializes the router
        this.router = new Router();
        
        // Starts the app configuration
        config();
    }
    
    public static MainController getInstance(){
        if(instance == null)
            return new MainController();
        
        return instance;
    }
    
    private void getControllers(){
               
        try{
            
            // Controllers folder
            Path dir = Path.of(getClass().getClassLoader().getResource("Controller").toURI());
            
            // DirectoryStream to iterate through the controllers
            DirectoryStream<Path> stream = Files.newDirectoryStream(dir);
            
            for(Path file: stream){
                System.out.println("Current file: "+file.getFileName());
                
                String fileName = file.getFileName().toString().substring(0, (file.getFileName().toString().length() - 6));
                
                // Check if the current file is not the controllers interface or the main controller
                if(fileName.contains("Interface") || fileName.contains("Main"))
                    continue;
                
                // To load a class dynamically we need the classes fully qualified name
                String className = this.getClass().getPackageName() + "." + fileName;
                
                try{
                    Class<?> currentClass = Class.forName(className);
                    
                    if(ControllerInterface.class.isAssignableFrom(currentClass)){
                        ControllerInterface controller = (ControllerInterface) currentClass.getDeclaredConstructor().newInstance();
                         
                        controllers.add(controller);
                        System.out.println("Class Name: "+className);
                        controllers_map.put(className, controllers.size()-1);
                    }
                }catch(ClassNotFoundException e){
                    System.out.println("Class not found: "+e.getMessage());
                }catch(ClassCastException e){
                    System.out.println("Class conversion error: "+e.getMessage());
                }catch(Exception e){
                    System.out.println("General Error: "+e.getMessage());
                }
            }
        }catch(IOException | DirectoryIteratorException x){
            System.err.println("Error: "+x);
            
        } catch (URISyntaxException ex) {
            System.out.println("Error getting controllers path: "+ex.getMessage());
        }
    }
    
    public void callRoute(String route){
        System.out.println("Route: "+route);
        if(route == null || route == "")
            return;
     
        int route_index = this.router.find_route(route);
        
        String[] full_route = App.Config.routes[route_index];
            
        System.out.println("Full route: "+Arrays.toString(full_route));
        
        String action = full_route[2];
        
        System.out.println("Action: "+action);
        
        String controller = "Controller."+action.split("/")[0];
        String method_name = action.split("/")[1];
        
        try{
            // Get controller instance
            Object controllerInstance = controllers.get(controllers_map.get(controller));
            
            if(controllerInstance == null)
                throw new RuntimeException("Controller not found: "+controller);
        
            // Get the instance class
            Class<?> controllerClass = controllerInstance.getClass();
            
            // Get the method from the class, no arguments
            Method method = controllerClass.getMethod(method_name);
            
            // Invoke the method from the controllers instance
            method.invoke(controllerInstance);
            
            System.out.println("Method successfully executed. "+method_name);
        }catch(Exception e){
            System.out.println("Error while trying to get controllers method "+e.getMessage());
        }
    }
    
    private void config(){
        
        this.router.map_routes(App.Config.routes);
        
    }
    
    
}
