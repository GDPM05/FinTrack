/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Views.ViewInterface;
import java.lang.reflect.InvocationTargetException;

import App.App;

/**
 *
 * @author gdpm
 */
public class MainController {
    
    protected String title;
    private App app = App.getInstance();
    
    protected void loadView(String viewName){
        
        try{
            String classFullName = "Views."+viewName+"View";
            
            Class<?> view = Class.forName(classFullName);
            
            Object instance = (ViewInterface) view.getDeclaredConstructor().newInstance();
            
            app.loadPage(instance, viewName);
            
            System.out.println("View instance created: "+instance);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
