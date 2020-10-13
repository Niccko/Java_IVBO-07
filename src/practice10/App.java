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
        Font mainFont = new Font("Arial",Font.BOLD,24);
        DecimalFormat dc = new DecimalFormat("###.####");
        Calculator calculator = new Calculator();
        JPanel mainPanel = new JPanel(null);
        JPanel buttonPanel = new JPanel(null);

        //Window setup
        setTitle("Calculator");
        setSize(525,300);
        setResizable(false);

        //Creating elements
        JTextField textA = new JTextField(20);
        textA.setBounds(10,10,480,50);
        textA.setFont(mainFont);
        textA.setToolTipText("Number A");

        JTextField textB = new JTextField(20);
        textB.setBounds(10,70,480,50);
        textB.setFont(mainFont);
        textB.setToolTipText("Number B");

        JTextField result = new JTextField();
        result.setEnabled(false);
        result.setDisabledTextColor(Color.BLACK);
        result.setBounds(10,200,480,50);
        result.setFont(mainFont);


        Vector<JButton> buttons = new Vector<>();

        JButton addButton = new JButton("+");
        addButton.setFont(mainFont);
        addButton.setBounds(0,0,75,50);
        JButton subButton = new JButton("-");
        subButton.setBounds(80,0,75,50);
        subButton.setFont(mainFont);
        JButton multButton = new JButton("*");
        multButton.setBounds(160,0,75,50);
        multButton.setFont(mainFont);
        JButton divButton = new JButton("/");
        divButton.setBounds(240,0,75,50);
        divButton.setFont(mainFont);

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
        buttonPanel.setBounds(100,130,1000,50);
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
                    textA.setText("");
                    textB.setText("");
                    result.setText(res);
                }
            });
        }
        
        add(mainPanel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
