/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.gdpm.fintrack;

import App.Database;
import App.App;
import Controller.MainController;
import java.net.URISyntaxException;
/**
 *
 * @author gdpm
 */
public class FinTrack {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        App app = App.getInstance();
        
        String teste1 = "MainController.java";
        String teste2 = "ControllerInterface.java";
        
        teste1 = teste1.substring(0, (teste1.length() - 5));
        teste2 = teste2.substring(0, (teste2.length() - 5));
        
        String[] testData = {"Hello", "18", "Unemployed"};
        
        //System.out.println("Teste1: \n"+teste1+"\n Teste2: \n"+teste2);
        
        //System.out.println("Teste1 contains? \n"+(teste1.contains("Manin"))+"\nTeste2 contains? \n"+(teste2.contains("Interface")));
        
        app.callRoute("home", null);
        
        //mc.callRoute("test2", null);
        
        //mc.callRoute("post_test", testData);
        
    }
}
