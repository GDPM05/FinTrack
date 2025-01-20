package Views;

import javax.swing.*;
import java.awt.*;
import App.EventListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NewTransactionView extends JPanel implements ViewInterface {

    public NewTransactionView(String[] data) {
        System.out.println("New Transaction view called.");

        // Define o layout da view
        setLayout(new BorderLayout());

        // Criação do título
        JLabel title = new JLabel("New Transaction", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        add(title, BorderLayout.NORTH);

        // Painel principal do formulário
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Campo para descrição
        JLabel descriptionLabel = new JLabel("Description:");
        JTextField descriptionField = new JTextField(20);
        gbc.gridx = 0;
        gbc.gridy = 0;
        formPanel.add(descriptionLabel, gbc);
        gbc.gridx = 1;
        formPanel.add(descriptionField, gbc);

        // Campo para montante
        JLabel amountLabel = new JLabel("Amount:");
        JTextField amountField = new JTextField(20);
        gbc.gridx = 0;
        gbc.gridy = 1;
        formPanel.add(amountLabel, gbc);
        gbc.gridx = 1;
        formPanel.add(amountField, gbc);

        // Campo para data
        JLabel dateLabel = new JLabel("Date:");
        JTextField dateField = new JTextField(20);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyy");
        Date date = new Date();
        dateField.setText(dateFormat.format(date));
        gbc.gridx = 0;
        gbc.gridy = 2;
        formPanel.add(dateLabel, gbc);
        gbc.gridx = 1;
        formPanel.add(dateField, gbc);

        // Campo para tipo
        JLabel typeLabel = new JLabel("Type:");
        String[] types = {"Income", "Expense"};
        JComboBox<String> typeComboBox = new JComboBox<>(types);
        gbc.gridx = 0;
        gbc.gridy = 3;
        formPanel.add(typeLabel, gbc);
        gbc.gridx = 1;
        formPanel.add(typeComboBox, gbc);

        // Campo para ID da categoria
        JLabel categoryIdLabel = new JLabel("Category:");
        JComboBox<String> categoryField = new JComboBox<>(data);
        JButton newCategory = new JButton("New Category");
        newCategory.addActionListener(new EventListener("categories", 0));
        gbc.gridx = 0;
        gbc.gridy = 4;
        formPanel.add(categoryIdLabel, gbc);
        gbc.gridx = 1;
        formPanel.add(categoryField, gbc);
        gbc.gridx = 2;
        formPanel.add(newCategory, gbc);

        // Botão de submissão
        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new EventListener("submitTransaction", 5));
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        formPanel.add(submitButton, gbc);

        // Adiciona o painel do formulário ao centro
        add(formPanel, BorderLayout.CENTER);
    }
}
