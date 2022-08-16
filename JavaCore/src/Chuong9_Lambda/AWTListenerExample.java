package Chuong9_Lambda;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AWTListenerExample {
    public static void main(String[] args) {
        example2();
    }

    private static void example2() {
        Frame screen = new Frame();
        Button button = new Button("Press me");
        screen.add(button);

        button.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Info Box: Welcome to Java by Example","Java Sample", JOptionPane.INFORMATION_MESSAGE);
        });
        screen.setSize(250,400);
        screen.setVisible(true);
    }

    private static void example1() {
        Frame screen = new Frame();
        Button button = new Button("Press me");
        screen.add(button);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Welcome to Java by Example","Java Sample", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        screen.setSize(250,400);
        screen.setVisible(true);
    }
}
