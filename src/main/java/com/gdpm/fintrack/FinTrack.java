/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.gdpm.fintrack;

import App.Database;
import App.App;
import Controller.MainController;
import java.awt.*;
import java.net.URISyntaxException;
/**
 *
 * @author gdpm
 */
public class FinTrack {
    
    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        //System.out.println("Teste join: "+String.join(", ", new String[]{"ola", "tudo", "bem"}));
        
        if (GraphicsEnvironment.isHeadless()) {
            System.out.println("Modo headless ativo. Ambiente gráfico não disponível.");
        } else {
            System.out.println("Ambiente gráfico disponível.");
        }
        
        App app = App.getInstance();
        app.getControllers();
        app.config();
        //App app2 = App.getInstance();
        String teste1 = "MainController.java";
        String teste2 = "ControllerInterface.java";
        
        teste1 = teste1.substring(0, (teste1.length() - 5));
        teste2 = teste2.substring(0, (teste2.length() - 5));
        
        String[] testData = {"Hello", "18", "Unemployed"};
        
        //System.out.println("Teste1: \n"+teste1+"\n Teste2: \n"+teste2);
        
        //System.out.println("Teste1 contains? \n"+(teste1.contains("Manin"))+"\nTeste2 contains? \n"+(teste2.contains("Interface")));
        
        app.callRoute("home", null, null);
        
        //mc.callRoute("test2", null);
        
        //mc.callRoute("post_test", testData);
        
    }
}

