/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Views;

import App.EventListener;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author gdpm
 */
public class TestView extends MainView implements ViewInterface{;
    
    private JFrame frame;
        
    public TestView(String title){
        //frame = prepareWindow(title);
        GUI();
    }
    
    private void GUI(){
        
        JButton button = new JButton("Click me");
        button.addActionListener(new App.EventListener("test2", 0));
        
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(0, 1));
        
        panel.add(button);
        
        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }
    
}
