/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Views.ViewInterface;
import java.lang.reflect.InvocationTargetException;

import App.*;

/**
 *
 * @author gdpm
 */
public class MainController {
    protected String title;
    private App app;
    public MainController() {
        StackTraceElement[] stackTree = Thread.currentThread().getStackTrace();
        
        String className = stackTree[2].getClassName();
        String methodName = stackTree[2].getMethodName();
        
        System.out.println("Class name: \n - Class: "+className + "\n - Method name: "+methodName);
        System.out.println("MainController constructor called");
        app = App.getInstance();
    }

    protected void loadView(String viewName, String[] params) {
        try {
            String classFullName = "Views." + viewName + "View";
            System.out.println("View name: "+classFullName);
            Class<?> view = Class.forName(classFullName);
            ViewInterface instance; 
            if(params != null){
                var constructor = view.getDeclaredConstructor(String[].class);
                instance = (ViewInterface) constructor.newInstance((Object) params);
            } else {
                instance = (ViewInterface) view.getDeclaredConstructor().newInstance();
            }
            app.loadPage(instance, classFullName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    protected void redirect(String route, String[] params){
        String[] caller = new String[2];
        
        StackTraceElement[] stackTree = Thread.currentThread().getStackTrace();
        
        String className = stackTree[2].getClassName();
        String methodName = stackTree[2].getMethodName();
        
        System.out.println("Caller redirect: "+className+" "+methodName);
        
        caller[0] = className;
        caller[1] = methodName;
        
        app.callRoute(route, params, caller);
    }
}
