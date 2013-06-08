package org.discordia.java8.lambda;

import javax.swing.*;
import java.awt.*;

/**
 * @author robban
 */
public class HelloUILambda {

    public static void main(String[] args) {
        final JFrame frame = new JFrame("Hello UI Lambda");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        SwingUtilities.invokeLater(() -> {
            Container contentPane = frame.getContentPane();

            JButton helloButton = new JButton("Say Hello");
            helloButton.addActionListener(e -> {
                JOptionPane.showMessageDialog(frame, "Hello UI Lambda");
            });
            contentPane.add(helloButton);

            frame.pack();
            frame.setVisible(true);
        });

    }
}
