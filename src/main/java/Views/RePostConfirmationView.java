package Views;

import javax.swing.*;
import java.awt.*;
import App.EventListener;

public class RePostConfirmationView extends JPanel implements ViewInterface{

    public RePostConfirmationView() {
        System.out.println("RePostConfirmationView called.");

        // Definindo o layout
        setLayout(new BorderLayout());

        // Criando o título
        JLabel title = new JLabel("Deseja voltar a submeter o formulário?", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setForeground(new Color(34, 45, 65));

        // Adicionando o título no topo
        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.X_AXIS));
        titlePanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        titlePanel.setBackground(new Color(240, 240, 240));
        titlePanel.add(title);
        add(titlePanel, BorderLayout.NORTH);

        // Criando o painel de botões
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridBagLayout());
        buttonsPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        buttonsPanel.setBackground(new Color(250, 250, 250));

        // Criando os botões
        JButton confirmButton = createStyledButton("Confirmo");
        JButton cancelButton = createStyledButton("Apenas voltar atrás");

        // Adicionando os listeners aos botões
        confirmButton.addActionListener(new EventListener("systemConfirmPost", 0));
        cancelButton.addActionListener(new EventListener("systemCancelPost", 0));

        // Configurando layout para os botões
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 0, 10, 0);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;

        buttonsPanel.add(confirmButton, gbc);
        gbc.gridy++;
        buttonsPanel.add(cancelButton, gbc);

        add(buttonsPanel, BorderLayout.CENTER);
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
        button.setPreferredSize(new Dimension(250, 50));
        return button;
    }
}
