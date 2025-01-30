package Views;

import javax.swing.*;
import java.awt.*;
import App.EventListener;

public class HomeView extends JPanel implements ViewInterface {

    public HomeView() {

        System.out.println("Home view called.");

        // Definindo o layout para o painel
        setLayout(new BorderLayout());

        // Criando o título
        JLabel title = new JLabel("Welcome to FinTrack!", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 32));
        title.setForeground(new Color(34, 45, 65)); // Cor moderna para o título

        // Adicionando o título no topo
        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.X_AXIS));
        titlePanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Margem generosa
        titlePanel.setBackground(new Color(240, 240, 240)); // Fundo suave para o título
        titlePanel.add(title);
        add(titlePanel, BorderLayout.NORTH);

        // Criando o painel de botões
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridBagLayout()); // Centraliza os botões
        buttonsPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Margem do painel
        buttonsPanel.setBackground(new Color(250, 250, 250)); // Fundo claro

        // Criando os botões
        JButton transactions = createStyledButton("Transactions");
        JButton accounts = createStyledButton("Accounts");
        JButton goals = createStyledButton("Goals");
        JButton logs = createStyledButton("System Logs");

        // Adicionando os listeners aos botões
        transactions.addActionListener(new EventListener("transactions", 0));
        accounts.addActionListener(new EventListener("accounts", 0));
        goals.addActionListener(new EventListener("goals", 0));
        logs.addActionListener(new EventListener("systemlogs", 0));

        // Configurando layout para os botões
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 0, 10, 0); // Espaçamento entre os botões
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;

        buttonsPanel.add(transactions, gbc);
        gbc.gridy++;
        buttonsPanel.add(accounts, gbc);
        gbc.gridy++;
        buttonsPanel.add(goals, gbc);
        gbc.gridy++;
        buttonsPanel.add(logs, gbc);

        add(buttonsPanel, BorderLayout.CENTER);

        // Criando o painel de rodapé
        JPanel footerPanel = new JPanel();
        footerPanel.setPreferredSize(new Dimension(getWidth(), 60));
        footerPanel.setBackground(new Color(34, 45, 65)); // Cor do rodapé

        JLabel footerLabel = new JLabel("FinTrack © 2025", JLabel.CENTER);
        footerLabel.setForeground(Color.WHITE);
        footerLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        footerPanel.setLayout(new BorderLayout());
        footerPanel.add(footerLabel, BorderLayout.CENTER);

        add(footerPanel, BorderLayout.SOUTH);
    }

    // Método para criar botões estilizados
    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.PLAIN, 18));
        button.setForeground(Color.WHITE);
        button.setBackground(new Color(34, 167, 240));
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(34, 167, 240), 1),
            BorderFactory.createEmptyBorder(15, 30, 15, 30))
        );
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setPreferredSize(new Dimension(200, 50)); // Botões mais compridos
        return button;
    }
}
