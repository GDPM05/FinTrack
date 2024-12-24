package Views;

import App.EventListener;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

public class HomeView extends MainView {
    
    JFrame frame;
    
    public HomeView(String title) {
        frame = prepareWindow("FinTrack | Home");
        GUI();
    }
    
    private void GUI() {

        // Set the layout of the JFrame as BorderLayout
        frame.setLayout(new BorderLayout());

        // Creating the title
        JLabel title = new JLabel("Welcome to FinTrack!", JLabel.CENTER);
        title.setFont(TITLE_FONT);

        // Creating the title panel
        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.X_AXIS));
        titlePanel.setBorder(new EmptyBorder(10, 10, 10, 10));  // Panel margin
        titlePanel.add(title);  // Adding the title to the panel
        //titlePanel.setBackground(Color.BLUE);

        // Adding the title to the top (North) of the frame
        frame.add(titlePanel, BorderLayout.NORTH);

        // Creating the buttons panel
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.Y_AXIS));
        buttonsPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        buttonsPanel.setPreferredSize(new java.awt.Dimension(frame.getWidth(), frame.getHeight() / 3));

        //buttonsPanel.add(Box.createVerticalGlue());

        // Creating the buttons
        JButton transactions = new JButton("Transactions");
        JButton accounts = new JButton("Accounts");
        JButton goals = new JButton("Goals");

        // Setting margins for the buttons
        transactions.setAlignmentX(JButton.LEFT_ALIGNMENT);
        accounts.setAlignmentX(JButton.LEFT_ALIGNMENT);
        goals.setAlignmentX(JButton.LEFT_ALIGNMENT);
        
        transactions.addActionListener(new EventListener("transactions", 0));
        
        buttonsPanel.add(Box.createVerticalGlue()); // Flexible space to center the buttons
        buttonsPanel.add(transactions);
        buttonsPanel.add(Box.createVerticalStrut(10)); // Space between buttons
        buttonsPanel.add(accounts);
        buttonsPanel.add(Box.createVerticalStrut(10));
        buttonsPanel.add(goals);
        buttonsPanel.add(Box.createVerticalGlue()); // Flexible space to keep the buttons centered


        //buttonsPanel.setBackground(Color.WHITE);

        JPanel fillerTop = new JPanel();
        fillerTop.setPreferredSize(new java.awt.Dimension(frame.getWidth(), frame.getHeight() / 3));
        fillerTop.setBackground(Color.CYAN);
        
        JPanel fillerBottom = new JPanel();
        fillerBottom.setPreferredSize(new java.awt.Dimension(frame.getWidth(), frame.getHeight() / 3));
        fillerBottom.setBackground(Color.ORANGE);
        
        // Creating the bottom panel to adjust height
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BorderLayout());
        bottomPanel.add(fillerTop, BorderLayout.NORTH);
        bottomPanel.add(buttonsPanel); // Buttons on the left
        bottomPanel.add(fillerBottom, BorderLayout.SOUTH);
        bottomPanel.setPreferredSize(new java.awt.Dimension(frame.getWidth() / 3, frame.getHeight()-titlePanel.getHeight())); // Height = 1/3 of the window
        //bottomPanel.setBackground(Color.RED);

        // Adding the bottom panel to the center
        frame.add(bottomPanel, BorderLayout.CENTER);

        // Make the window visible
        frame.setVisible(true);
        
        // Using SwingUtilities.invokeLater to ensure that the heights are calculated after the window layout is done
        SwingUtilities.invokeLater(() -> {
            System.out.println("Top filler height: " + fillerTop.getHeight() + "\nBottom filler height: " + fillerBottom.getHeight());
        });
    }

}
