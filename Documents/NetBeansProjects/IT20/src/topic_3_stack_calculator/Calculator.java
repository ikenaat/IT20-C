package topic_3_stack_calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame implements ActionListener {
    private JTextField inputField;
    private double num1;
    private String operator;

    public Calculator() {
        setTitle("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        inputField = new JTextField();
        inputField.setPreferredSize(new Dimension(140, 50));
        inputField.setHorizontalAlignment(JTextField.RIGHT);

        JPanel buttonPanel = new JPanel(new GridLayout(4, 4));

        String[] buttonLabels = {"7", "8", "9", "+", 
                                  "4", "5", "6", "-", 
                                  "1", "2", "3", "/", 
                                  "0", "C", "=", "*"};

        Color[] buttonColors = {Color.LIGHT_GRAY, Color.LIGHT_GRAY, Color.LIGHT_GRAY, Color.ORANGE,
                                Color.LIGHT_GRAY, Color.LIGHT_GRAY, Color.LIGHT_GRAY, Color.ORANGE,
                                Color.LIGHT_GRAY, Color.LIGHT_GRAY, Color.LIGHT_GRAY, Color.ORANGE,
                                Color.LIGHT_GRAY, Color.RED, Color.GREEN, Color.ORANGE};

        for (int i = 0; i < buttonLabels.length; i++) {
            JButton button = new JButton(buttonLabels[i]);
            button.setBackground(buttonColors[i]);
            button.setForeground(Color.BLACK);
            button.addActionListener(this);
            buttonPanel.add(button);
        }

        setLayout(new FlowLayout());
        add(inputField);
        add(buttonPanel);
        pack();
        setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton source = (JButton) e.getSource();
        String buttonText = source.getText();

        if (Character.isDigit(buttonText.charAt(0))) {
            inputField.setText(inputField.getText() + buttonText);
        } else if (buttonText.equals("+") || buttonText.equals("-") || buttonText.equals("*") || buttonText.equals("/")) {
            num1 = Double.parseDouble(inputField.getText());
            operator = buttonText;
            inputField.setText("");
        } else if (buttonText.equals("=")) {
            double num2 = Double.parseDouble(inputField.getText());
            double result = performCalculation(num1, num2, operator);
            inputField.setText(String.valueOf(result));
        } else if (buttonText.equals("C")) {
            inputField.setText("");
        }
    }

    private double performCalculation(double num1, double num2, String operator) {
        double result = 0.0;

        switch (operator) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    JOptionPane.showMessageDialog(null, "Cannot divide by zero!");
                }
                break;
        }

        return result;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Calculator().setVisible(true));
    }
}
