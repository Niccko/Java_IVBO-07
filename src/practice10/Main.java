package practice10;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(()->{
            App app = new App();
            app.setVisible(true);
        });
    }
}
