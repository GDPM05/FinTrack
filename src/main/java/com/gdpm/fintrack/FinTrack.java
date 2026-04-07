/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.gdpm.fintrack;

import App.Database;
import App.App;
import Controller.MainController;
import Helpers.Paginator.Paginator;
import java.awt.*;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.Scanner;
/**
 *
 * @author gdpm
 */
public class FinTrack {
    
    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        if (GraphicsEnvironment.isHeadless()) {
            System.out.println("Modo headless ativo. Ambiente gráfico não disponível.");
        } else {
            System.out.println("Ambiente gráfico disponível.");
        }
        
        App app = App.getInstance();
        app.getControllers();
        app.config();
        
        app.callRoute("home", null, null);
        
    }
}

