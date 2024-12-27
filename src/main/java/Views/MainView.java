package Views;

import javax.swing.*;
import java.awt.*;

public class MainView {
    
    private final Font TITLE_FONT = new Font("Arial", Font.BOLD, 24);
    private final Font BUTTON_FONT = new Font("Arial", Font.PLAIN, 14);
    private JFrame frame;
    public JPanel mainPanel;
    private CardLayout cardLayout;

    public MainView() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1240, 800);
        frame.setLocationRelativeTo(null);
        
        // Inicializando o painel principal com CardLayout
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        frame.add(mainPanel);

        // Adicionando a HomeView e outras views
        //mainPanel.add(new HomeView(), "home"); // "home" é o identificador da view
        // mainPanel.add(new AnotherView(), "another");

        frame.setVisible(true);
    }
    
    // Método para mudar de "página"
    public void showView(String viewName) {
        cardLayout.show(mainPanel, viewName);
    }
}
