/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Views;

import App.EventListener;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author gdpm
 */
public class NewCategoryMenuView extends JPanel implements ViewInterface{
    
    
    public NewCategoryMenuView(){
        
        setLayout(new BorderLayout());
        
        JLabel title = new JLabel("New Category", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        add(title, BorderLayout.NORTH);
        
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField(20);
        gbc.gridx = 0;
        gbc.gridy = 0;
        formPanel.add(nameLabel, gbc);
        gbc.gridx = 1;
        formPanel.add(nameField, gbc);
        
        JLabel typeLabel = new JLabel("Type:");
        String[] types = {"Income", "Expense"};
        JComboBox<String> typeComboBox = new JComboBox<>(types);
        gbc.gridx = 0;
        gbc.gridy = 1;
        formPanel.add(typeLabel, gbc);
        gbc.gridx = 1;
        formPanel.add(typeComboBox, gbc);
        
        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new EventListener("submitCategory", 2));
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        formPanel.add(submitButton, gbc);
        
        add(formPanel, BorderLayout.CENTER);
    }
    
    
}
