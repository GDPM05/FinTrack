/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import App.Database;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gdpm
 */
public class MainController {
    
    private Database db;
    private List<ControllerInterface> controllers = new ArrayList<>();
    
    public MainController(){
        
        // Method responsible for kickstarting our application
        this.prepare();
    }
        
    private void prepare(){
        // Initializes the database
        db = new Database();
        
        // Initializes and stores the controllers
        getControllers();
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
    
    
}
