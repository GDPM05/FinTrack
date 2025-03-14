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
        
        /*String[] data = {
            "Item 1", "Item 2", "Item 3", "Item 4", "Item 5",
            "Item 6", "Item 7", "Item 8", "Item 9", "Item 10",
            "Item 11", "Item 12", "Item 13", "Item 14", "Item 15",
            "Item 16", "Item 17", "Item 18", "Item 19", "Item 20"
        };
        
        int itemsPerPage = 5;
        Paginator paginator = new Paginator(itemsPerPage, data.length);
        
        Scanner scanner = new Scanner(System.in);
        
        boolean running = true;
                
        while(running) {
            int offset = paginator.calculateOffset();
            int totalPages = paginator.getTotalPages();
            int currentPage = paginator.getCurrentPage();
            
            int start = offset;
            int end = paginator.getEnd();
            
            String[] pageData = Arrays.copyOfRange(data, start, end);
            
            System.out.println("\nPáginaá " + currentPage + " de " + totalPages);
            
            for(String item : pageData) {
                System.out.println("- " + item);
            }
            
            System.out.println("\nOpções: [n] Próxima Página | [p] Página Anterior | [s] Sair");
            System.out.print("Escolha: ");
            String choice = scanner.nextLine().trim().toLowerCase();

            switch (choice) {
                case "n":
                    paginator.nextPage();
                    break;
                case "p":
                    paginator.prevPage();
                    break;
                case "s":
                    running = false;
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }

        System.out.println("Programa encerrado.");
        scanner.close();*/
        
        app.callRoute("home", null, null);
        
    }
}

