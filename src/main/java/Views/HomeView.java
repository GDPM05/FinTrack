package Views;

import javax.swing.*;
import java.awt.*;
import App.EventListener;

public class HomeView extends JPanel implements ViewInterface{
    
    public HomeView() {
        // Definindo o layout para o painel
        setLayout(new BorderLayout());

        // Criando o título
        JLabel title = new JLabel("Welcome to FinTrack!", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 24));

        // Adicionando o título no topo
        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.X_AXIS));
        titlePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));  // Margem
        titlePanel.add(title);  // Adiciona o título no painel
        add(titlePanel, BorderLayout.NORTH);  // Adiciona o título ao topo (North) da tela

        // Criando o painel de botões
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.Y_AXIS));
        buttonsPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        buttonsPanel.setPreferredSize(new Dimension(400, 300)); // Ajusta o tamanho do painel de botões

        // Criando os botões
        JButton transactions = new JButton("Transactions");
        JButton accounts = new JButton("Accounts");
        JButton goals = new JButton("Goals");

        // Ajustando o alinhamento dos botões
        transactions.setAlignmentX(JButton.LEFT_ALIGNMENT);
        accounts.setAlignmentX(JButton.LEFT_ALIGNMENT);
        goals.setAlignmentX(JButton.LEFT_ALIGNMENT);

        // Adicionando os listeners aos botões
        transactions.addActionListener(new EventListener("transactions", 0));
        accounts.addActionListener(new EventListener("accounts", 0));
        goals.addActionListener(new EventListener("goals", 0));

        // Adicionando os botões ao painel
        buttonsPanel.add(transactions);
        buttonsPanel.add(Box.createVerticalStrut(10)); // Espaço entre os botões
        buttonsPanel.add(accounts);
        buttonsPanel.add(Box.createVerticalStrut(10)); // Espaço entre os botões
        buttonsPanel.add(goals);
        buttonsPanel.add(Box.createVerticalGlue()); // Espaço flexível para manter os botões centralizados

        // Adicionando o painel de botões ao centro da tela
        add(buttonsPanel, BorderLayout.CENTER);

        // Criando o painel de rodapé, com fundo colorido para visualização
        JPanel fillerBottom = new JPanel();
        fillerBottom.setPreferredSize(new Dimension(getWidth(), 100));
        fillerBottom.setBackground(Color.ORANGE);
        add(fillerBottom, BorderLayout.SOUTH); // Adiciona o rodapé
    }
}
