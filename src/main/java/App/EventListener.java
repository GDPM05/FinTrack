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
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
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
        
        if(params.length > 0){

            // Get's the form panel in order to collect the form data
            JPanel formPanel = (JPanel) ((JButton) ae.getSource()).getParent();

            // Iterates through every component, in this case, the form inputs
            int index = 0;
            for (Component comp : formPanel.getComponents()) {
                // Due to the arrays type being String, I have to transform every value in a type of String. 
                // For example, the boolean values are transformed in strings of "1" and "0", being 1 true and 0 false.
                if (comp instanceof JTextField) {
                    JTextField currentInput = (JTextField) comp;
                    params[index++] = currentInput.getText();
                    System.out.println("TextField input: " + currentInput.getText());
                } else if (comp instanceof JComboBox) {
                    JComboBox<?> comboBox = (JComboBox<?>) comp;
                    params[index++] = comboBox.getSelectedItem().toString();
                    System.out.println("ComboBox selected: " + comboBox.getSelectedItem());
                } else if (comp instanceof JCheckBox) {
                    JCheckBox checkBox = (JCheckBox) comp;
                    params[index++] = (checkBox.isSelected()) ? "1" : "0";
                    System.out.println("CheckBox selected: " + checkBox.isSelected());
                } else if (comp instanceof JRadioButton) {
                    JRadioButton radioButton = (JRadioButton) comp;
                    params[index++] = (radioButton.isSelected()) ? "1" : "0";
                    System.out.println("RadioButton selected: " + radioButton.isSelected());
                } else {
                    System.out.println("Component type not handled: " + comp.getClass().getSimpleName());
                }
            }
        }else{
            // Calls the method "CallRoute" from the main controller
            app.callRoute(route, null, null);
            return;
        }
        
        StackTraceElement[] stackTree = Thread.currentThread().getStackTrace();
        
        String className = stackTree[2].getClassName();
        String methodName = stackTree[2].getMethodName();
        
        app.callRoute(route, params, new String[]{className, methodName});
        
    }
    
}


