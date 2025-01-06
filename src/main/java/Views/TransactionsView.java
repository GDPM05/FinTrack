/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Views;

import App.EventListener;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author jpfa0
 */
public class TransactionsView extends JPanel implements ViewInterface{
    
    public TransactionsView(){
        
        setLayout(new BorderLayout());
        
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.Y_AXIS));
        buttonsPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        buttonsPanel.setPreferredSize(new Dimension(400, 300)); // Ajusta o tamanho do painel de botões

        // Criando os botões
        JButton testButton1 = new JButton("TestButton 1");
        JButton testButton2 = new JButton("TestButton 2");

        testButton1.addActionListener(new EventListener("testRoute1", 0));
        testButton2.addActionListener(new EventListener("testRoute2", 0));
        
        buttonsPanel.add(testButton1);
        buttonsPanel.add(testButton2);
        
        add(buttonsPanel);
        
    }
    
}
