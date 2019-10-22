package swing;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    public static void main(String args[]) {
        JFrame frame = new JFrame("Chat Frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setSize(500, 500);

        JPanel panel = new JPanel();
        JLabel label = new JLabel("Enter Text");
        JTextField textField = new JTextField(10);
        JButton send = new JButton("Send");
        JButton reset = new JButton("Reset");
        panel.add(label);
        panel.add(textField);
        panel.add(send);
        panel.add(reset);

        JTextPane textPane = new JTextPane();
        textPane.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        textPane.setEditable(false);

        send.addActionListener(event -> {
            StyledDocument doc = textPane.getStyledDocument();
            try {
                doc.insertString(doc.getLength(), "\n" + textField.getText(), null);
            } catch (BadLocationException e) {
                e.printStackTrace();
            }
        });
        reset.addActionListener(event -> {
            textPane.setText("");
            textField.setText("");
        });

        frame.getContentPane().add(BorderLayout.SOUTH, panel);
        frame.getContentPane().add(BorderLayout.CENTER, textPane);
        frame.setVisible(true);
    }
}
