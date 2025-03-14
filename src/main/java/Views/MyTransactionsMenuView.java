package Views;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import Objects.Transaction;

public class MyTransactionsMenuView extends JPanel implements ViewInterface{

    public MyTransactionsMenuView(Object[] params) {
        setLayout(new BorderLayout());

        JLabel title = new JLabel("My Transactions", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 28));
        title.setForeground(new Color(34, 45, 65));
        
        JPanel titlePanel = new JPanel(new BorderLayout());
        titlePanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        titlePanel.setBackground(new Color(240, 240, 240));
        titlePanel.add(title, BorderLayout.CENTER);
        
        add(titlePanel, BorderLayout.NORTH);
        
        // Tabela de transações
        String[] columnNames = {"ID", "Description", "Value", "Date", "Type", "Category"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        JTable transactionsTable = new JTable(tableModel);
        transactionsTable.setFont(new Font("Arial", Font.PLAIN, 16));
        transactionsTable.setRowHeight(30);
        transactionsTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 18));
        transactionsTable.getTableHeader().setBackground(new Color(34, 167, 240));
        transactionsTable.getTableHeader().setForeground(Color.WHITE);
        
        JScrollPane scrollPane = new JScrollPane(transactionsTable);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        for (Object obj : params) {
            if (obj instanceof Transaction) {
                Transaction param = (Transaction) obj;
                tableModel.addRow(new Object[]{
                        param.id,
                        param.description,
                        param.value,
                        param.date,
                        param.type,
                        param.category
                });
            }
        }
        
        add(scrollPane, BorderLayout.CENTER);
        
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
}
