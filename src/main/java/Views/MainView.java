package Views;

import javax.swing.*;
import java.awt.*;
import javax.swing.plaf.basic.BasicArrowButton;

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

        // Define o layout do frame como BorderLayout
        frame.setLayout(new BorderLayout());

        // Cria e adiciona o header na parte superior
        JPanel header = header();
        frame.add(header, BorderLayout.NORTH);

        // Inicializa o mainPanel com CardLayout e adiciona no centro
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        frame.add(mainPanel, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    
    private JPanel header() {
        JPanel header = new JPanel();

        // Configurando o layout do header
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
        header.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        //header.setBackground(Color.BLUE);
        header.setPreferredSize(new Dimension(1240, 40)); // Altura fixa do header

        // Criando o painel de botões
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new BorderLayout()); // Use BorderLayout para alinhar botões
        buttonsPanel.setPreferredSize(new Dimension(100, 40)); // Altura e largura fixas

        // Criando os botões de navegação
        BasicArrowButton previous = new BasicArrowButton(BasicArrowButton.WEST);
        BasicArrowButton next = new BasicArrowButton(BasicArrowButton.EAST);

        // Ajustando o tamanho dos botões
        previous.setPreferredSize(new Dimension(70, 70));
        next.setPreferredSize(new Dimension(70, 70));

        // Adicionando os botões ao painel
        buttonsPanel.add(previous, BorderLayout.WEST);
        buttonsPanel.add(next, BorderLayout.EAST);

        // Adicionando o painel de botões ao header
        header.add(buttonsPanel);

        return header;
    }

    // Método para mudar de "página"
    public void showView(String viewName) {
        cardLayout.show(mainPanel, viewName);
    }
    
    public void addComponent(Object instance, String instanceName){
        mainPanel.add((Component) instance, instanceName);
        showView(instanceName);
        frame.setVisible(true);
    }
    
}
