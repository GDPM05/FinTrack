/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Views;

import java.awt.Font;
import javax.swing.JFrame;

/**
 *
 * @author gdpm
 */
public class MainView {
 
    public final Font TITLE_FONT = new Font("Arial", Font.BOLD, 24);
    public final Font BUTTON_FONT = new Font("Arial", Font.PLAIN, 14);
    
    public JFrame prepareWindow(String title){
        JFrame frame = new JFrame();
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle(title);
        frame.setSize(1240, 800);
        frame.setLocationRelativeTo(null);
        
        return frame;
    }
    
}
