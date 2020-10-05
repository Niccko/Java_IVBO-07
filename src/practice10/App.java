package practice10;

import javax.swing.*;

public class App extends JFrame {
    public App(){
        JPanel mainPanel = new JPanel();

        setTitle("App");
        setSize(500,600);
        setResizable(false);
        JTextField textA = new JTextField(getWidth()/12);

        JButton addButton = new JButton("+");
        JButton subButton = new JButton("-");
        JButton multButton = new JButton("*");
        JButton divButton = new JButton("/");
        mainPanel.add(textA);
        mainPanel.add(addButton);
        mainPanel.add(subButton);
        mainPanel.add(multButton);
        mainPanel.add(divButton);

        add(mainPanel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);


    }
}
