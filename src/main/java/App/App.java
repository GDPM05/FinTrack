/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App;

import Controller.ControllerInterface;
import Controller.MainController;
import Views.MainView;
import Views.ViewInterface;

import com.sun.istack.Nullable;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
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

/**
 *
 * @author gdpm
 */
public class App {
    
    /**
     * To ensure that the App has only one instance throughout the application and that this instance is 
     * globally accessible, I implemented it using the Singleton design pattern.
     */
    
    private static App instance;
    
    private Database db;
    private Router router;
    private MainView page;
    private Logger logger;
    
    private List<ControllerInterface> controllers = new ArrayList<>();
    private Map<String, Integer> controllers_map = new HashMap<>();
    private Map<String, String> controllersReference = new HashMap<>();
    
    private String[] lastPostParams;
    
    private App(){
        StackTraceElement[] stackTree = Thread.currentThread().getStackTrace();
        
        String className = stackTree[2].getClassName();
        String methodName = stackTree[2].getMethodName();
        
        System.out.println("Class name: \n - Class: "+className + "\n - Method name: "+methodName);
        // Method responsible for kickstarting our application
        System.out.println("ClassLoader: " + App.class.getClassLoader());
        this.prepare();
        logger.newLog(1, "App called", "App constructor called, app intialized."); 
    }
        
    private void prepare(){
        // Initializes the database
        db = Database.getInstance();
                
        // Initializes the router
        this.router = new Router(this.instance);
        
        // Initializes the logger
        logger = Logger.getInstance();
    }
    
    public static synchronized App getInstance(){
        if(instance == null) {
            synchronized (App.class) {
                if(instance == null) 
                    instance = new App();
            }
        }
        return instance;
    }

    public void getControllers(){
        System.out.println("Instance: "+(instance != null));
        try{
            // Controllers folder
            Path dir = Path.of(getClass().getClassLoader().getResource("Controller").toURI());

            // DirectoryStream to iterate through the controllers
            DirectoryStream<Path> stream = Files.newDirectoryStream(dir);

            for (Path file : stream) {
                System.out.println("Current file: " + file.getFileName());

                System.out.println("Filaenme: "+file.getFileName().toString().substring(0, (file.getFileName().toString().length() - 6)));
                
                String fileName = file.getFileName().toString().substring(0, (file.getFileName().toString().length() - 6));
                
                // Check if the current file is not the controllers interface or the main controller
                if (fileName.contains("Interface") || fileName.equals("MainController"))
                    continue;

                // To load a class dynamically we need the class's fully qualified name
                String className = "Controller." + fileName;
                
                String sClassName = fileName.split("[.]")[0];
                    
                System.out.println("sClassName "+sClassName);
                
                this.controllersReference.put(sClassName, className);
            }

        }catch(IOException | DirectoryIteratorException x){
            System.err.println("Error: "+x);

        } catch (URISyntaxException ex) {
            System.out.println("Error getting controllers path: "+ex.getMessage());
        }
    }

    
    public void callRoute(String route, @Nullable String[] params, @Nullable String[] caller){
        
        StackTraceElement[] stackTree = Thread.currentThread().getStackTrace();
        
        String className = stackTree[2].getClassName();
        String methodName = stackTree[2].getMethodName();
        
        System.out.println("Route caller: \n - Class: "+className + "\n - Method name: "+methodName);
        
        System.out.println("Current Route: "+route);
        if(route == null || route.equals(""))
            return;
        
        if(route.contains("system")){
            String operation = route.substring(6, route.length());
            
            //System.out.println("Operation: "+operation);
            
            this.executeSystemOperation(operation);
            
            return;
        }
        
        int route_index = this.router.find_route(route);
        
        String[] full_route = Config.routes[route_index];
            
        //System.out.println("Full route: "+Arrays.toString(full_route));
        
        String action = full_route[2];
        
        //System.out.println("Action: "+action);
        
        String controller = "Controller."+action.split("/")[0];
        String method_name = action.split("/")[1];
        
        System.out.println("Controller: "+controller);
        
        if(methodName != "executeSystemOperation"){
            System.out.println("Non system route called");
            //lastPrevRoutes.add(route);
            //tempPrevRoutesIndex = lastPrevRoutes.size() - 1;
            router.updateHistory(route, full_route[1], caller);
        }
        
        try{
            
            // Get controller instance
            Object controllerInstance = this.invokeController(controller);
            
            if(controllerInstance == null)
                throw new RuntimeException("Controller not found: "+controller);
        
            // Get the instance class
            Class<?> controllerClass = controllerInstance.getClass();
            
            //System.out.println("\nMethod name: "+method_name);
            
            Method method;
            
            if("POST".equals(full_route[1])){
                // Get the method from the class with arguments
                method = controllerClass.getMethod(method_name, String[].class);
                
                if(params == null)
                    params = new String[0];
                
                lastPostParams = params;
                
                // Get the method from the class with arguments
                method.invoke(controllerInstance, (Object) params); // Cast the params to Object
                
            }else{
                // Get the method from the class, no arguments
                method = controllerClass.getMethod(method_name);
                
                // Iboke the method from the class, no arguments
                method.invoke(controllerInstance);
            }
            
            System.out.println("Method successfully executed. "+method_name);
        }catch (NoSuchMethodException e) {
            logger.newLog(3, "callRoute", "Try to find a method in the controller but was unsuccessful.");
            System.err.println("No such method found: " + method_name);
            e.printStackTrace();
        } catch (IllegalAccessException | InvocationTargetException e) {
            logger.newLog(3, "callRoute", "Try to invoke a method in the controller but was unsuccessful.");
            System.err.println("Error invoking method: " + e.getMessage());
            stackTree = Thread.currentThread().getStackTrace();

            className = stackTree[2].getClassName();
            methodName = stackTree[2].getMethodName();

            //System.out.println("Route caller: \n - Class: "+className + "\n - Method name: "+methodName);
            e.printStackTrace();
        } catch (Exception e) {
            logger.newLog(3, "callRoute", "Try to call a route, but an unexpected error was found.");
            System.err.println("Unexpected error: " + e.getMessage());
            e.printStackTrace();
        }
    }
        
        
    // Method responsible for invoking the controllers
    private ControllerInterface invokeController(String controllerName){
        
        System.out.println("Invoking a controller");
        
        ControllerInterface instance = null;
        
        String controller = controllerName.split("[.]")[1];
        
        if(this.controllers_map.containsKey(controller)) {
            int controllerIndex = this.controllers_map.get(controller);
            instance = this.controllers.get(controllerIndex);
            System.out.println("Controller already instantiated");
        } else {
            System.out.println("Creating a new instance");
            try {
                String className = this.controllersReference.get(controller);
                
                Class<?> currentClass = Class.forName(className);

                if (ControllerInterface.class.isAssignableFrom(currentClass)) {
                    instance = (ControllerInterface) currentClass.getDeclaredConstructor().newInstance();
                    controllers.add(instance);
                    controllers_map.put(controller, controllers.size() - 1);
                }
            } catch (ClassCastException e) {
                System.out.println("Class conversion error: " + e.getMessage());
                return null;
            } catch (Exception e) {
                System.out.println("General Error: " + e.getMessage());
                return null;
            }
            
        }
            
        return instance;
    }
    
    public void config(){
        this.router.map_routes(Config.routes);
        
        this.page = (page == null) ? new MainView() : this.page;
    }
    
    public void loadPage(ViewInterface ViewInstance, String instanceName){
        
        if(null == ViewInstance || !(ViewInstance instanceof ViewInterface))
            return;
        
        this.page.addComponent(ViewInstance, instanceName);
    }

    private void executeSystemOperation(String operation) {
        
        //System.out.println("Called\n"+lastRoutes.get(lastRoutes.size()-1));
       
        switch(operation){
            case "Prev":
                String lastRoute = router.previousRoute();
                callRoute(lastRoute, null, null);
                break;
            case "Next":
                String nextRoute = router.nextRoute();
                callRoute(nextRoute, null, null);
                break;
            case "ConfirmRePost":
                callRoute("confirmationPage", null, null);
                break;
            case "ConfirmPost":
                callRoute(router.confirmPost(true), null, null);
                break;
            case "CancelPost":
                callRoute(router.confirmPost(false), null, null);
                break;
            case "PostCanceled":
                callRoute(router.previousRoute(), null, null);
                break;
            case "PostConfirmed": 
                callRoute(router.currentRoute(), lastPostParams, null);
                break;
        }
        
    }
    
    
}
