package Views;

import javax.swing.*;
import java.awt.*;
import App.EventListener;

public class TransactionsView extends JPanel implements ViewInterface {

    public TransactionsView() {
        setLayout(new BorderLayout());

        JLabel title = new JLabel("Transactions", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 28));
        title.setForeground(new Color(34, 45, 65));

        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.X_AXIS));
        titlePanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        titlePanel.setBackground(new Color(240, 240, 240));
        titlePanel.add(title);
        add(titlePanel, BorderLayout.NORTH);

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridBagLayout());
        buttonsPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        buttonsPanel.setBackground(new Color(250, 250, 250));

        JButton newTransaction = createStyledButton("New Transaction");
        newTransaction.addActionListener(new EventListener("new_transaction", 0));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 0, 10, 0);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        
        buttonsPanel.add(newTransaction, gbc);
        
        JButton myTransactions = createStyledButton("My Transactions");
        myTransactions.addActionListener(new EventListener("my_transactions", 0));
        gbc.gridx = 0;
        gbc.gridy = 1;
        
        buttonsPanel.add(myTransactions, gbc);
        
        add(buttonsPanel, BorderLayout.CENTER);

        JPanel footerPanel = new JPanel();
        footerPanel.setPreferredSize(new Dimension(getWidth(), 60));
        footerPanel.setBackground(new Color(34, 45, 65));

        JLabel footerLabel = new JLabel("FinTrack © 2025", JLabel.CENTER);
        footerLabel.setForeground(Color.WHITE);
        footerLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        footerPanel.setLayout(new BorderLayout());
        footerPanel.add(footerLabel, BorderLayout.CENTER);

        add(footerPanel, BorderLayout.SOUTH);
    }

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
        button.setPreferredSize(new Dimension(200, 50));
        return button;
    }
}
