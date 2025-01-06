/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App;

import Controller.MainController;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author gdpm
 */
public class EventListener implements ActionListener{

    private String route;
    private String[] params;
    private App app = App.getInstance();
    
    public EventListener(String route, int n_fields){
        this.route = route;
        params = new String[n_fields];
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        System.out.println("Event fired!");
        
        if(params.length < 0){
            // Calls the method "CallRoute" from the main controller
            app.callRoute(route, null, null);
            return;
        }
        
        // Get's the form panel in order to collect the form data
        JPanel formPanel = (JPanel) ((JButton) ae.getSource()).getParent();
        
        // Iterates through every component, in this case, the form inputs
        int index = 0;
        for(Component comp : formPanel.getComponents()){
            if(comp instanceof JTextField){
                JTextField currentInput = (JTextField) comp;
                
                String data = currentInput.getText();
                
                System.out.println("Current input data: "+data);
                
                params[index++] = data;
            }   
        }
        
        StackTraceElement[] stackTree = Thread.currentThread().getStackTrace();
        
        String className = stackTree[2].getClassName();
        String methodName = stackTree[2].getMethodName();
        
        app.callRoute(route, params, new String[]{className, methodName});
        
    }
    
}


