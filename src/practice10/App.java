package practice10;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;
import java.util.Vector;

public class App extends JFrame {
    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public App(){
        JPanel mainPanel = new JPanel();
        JPanel buttonPanel = new JPanel(new FlowLayout());

        //Window setup
        setTitle("App");
        setSize(500,600);
        setResizable(false);

        //Creating elements
        JTextField textA = new JTextField(20);
        JTextField textB = new JTextField(20);
        JLabel result = new JLabel("Result");
        Vector<JButton> buttons = new Vector<>();
        Calculator calculator = new Calculator();
        DecimalFormat dc = new DecimalFormat("###.####");

        JButton addButton = new JButton("+");
        JButton subButton = new JButton("-");
        JButton multButton = new JButton("*");
        JButton divButton = new JButton("/");

        //Adding elements to the window
        buttons.add(addButton);
        buttons.add(subButton);
        buttons.add(multButton);
        buttons.add(divButton);

        mainPanel.add(textA);
        buttonPanel.add(addButton);
        buttonPanel.add(subButton);
        buttonPanel.add(multButton);
        buttonPanel.add(divButton);
        mainPanel.add(textB);
        mainPanel.add(buttonPanel);
        mainPanel.add(result);


        for (JButton button:buttons) {
            button.addActionListener(action->{
                if(textA.getText().equals("") || textB.getText().equals("") || !isNumeric(textA.getText())||!isNumeric(textB.getText())){
                    result.setText("Invalid operators");
                } else {
                    double a = Double.parseDouble(textA.getText());
                    double b = Double.parseDouble(textB.getText());
                    String res = dc.format(calculator.calculate(a,button.getText(),b));
                    result.setText(res);
                }
            });
        }



        add(mainPanel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);


    }
}
