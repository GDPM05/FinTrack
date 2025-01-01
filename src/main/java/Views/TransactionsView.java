/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Views;

import App.EventListener;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author jpfa0
 */
public class TransactionsView extends JPanel implements ViewInterface{
    
    public TransactionsView(){
        
        setLayout(new BorderLayout());
        
        JButton nextRoute = new JButton("Next Route");
        nextRoute.addActionListener(new EventListener("nextroute", 0));
        
        add(nextRoute);
        
        JButton home = new JButton("home");
        home.addActionListener(new EventListener("home", 0));
        
        add(home);
    }
    
}
