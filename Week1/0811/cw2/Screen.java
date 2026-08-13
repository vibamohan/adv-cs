import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Screen extends JPanel {
    private JTextField textField;
    private double savedNumber;
    private String currentOperator;

    public Screen() {
        savedNumber = 0;
        currentOperator = "";

        setLayout(new BorderLayout(10, 10));

        textField = new JTextField();
        textField.setFont(new Font("Arial", Font.PLAIN, 32));
        textField.setHorizontalAlignment(JTextField.RIGHT);
        add(textField, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridLayout(2, 3, 10, 10));

        JButton addButton = new JButton("+");
        JButton subtractButton = new JButton("-");
        JButton multiplyButton = new JButton("*");
        JButton divideButton = new JButton("/");
        JButton equalsButton = new JButton("=");
        JButton clearButton = new JButton("AC");

        addButton.addActionListener(e -> chooseOperator("+"));
        subtractButton.addActionListener(e -> chooseOperator("-"));
        multiplyButton.addActionListener(e -> chooseOperator("*"));
        divideButton.addActionListener(e -> chooseOperator("/"));
        equalsButton.addActionListener(e -> calculateAnswer());
        clearButton.addActionListener(e -> clearAll());

        buttonPanel.add(addButton);
        buttonPanel.add(subtractButton);
        buttonPanel.add(multiplyButton);
        buttonPanel.add(divideButton);
        buttonPanel.add(equalsButton);
        buttonPanel.add(clearButton);

        add(buttonPanel, BorderLayout.CENTER);
    }

    private void chooseOperator(String operator) {
        try {
            savedNumber = Double.parseDouble(textField.getText());
            currentOperator = operator;
            textField.setText("");
        } catch (NumberFormatException e) {
            textField.setText("Error");
        }
    }

    private void calculateAnswer() {
        if (currentOperator.equals("")) {
            return;
        }

        try {
            double currentNumber = Double.parseDouble(textField.getText());
            double answer = 0;

            if (currentOperator.equals("+")) {
                answer = savedNumber + currentNumber;
            } else if (currentOperator.equals("-")) {
                answer = savedNumber - currentNumber;
            } else if (currentOperator.equals("*")) {
                answer = savedNumber * currentNumber;
            } else if (currentOperator.equals("/")) {
                answer = savedNumber / currentNumber;
            }

            textField.setText(formatAnswer(answer));
            savedNumber = answer;
            currentOperator = "";
        } catch (NumberFormatException e) {
            textField.setText("Error");
        }
    }

    private void clearAll() {
        textField.setText("");
        savedNumber = 0;
        currentOperator = "";
    }

    private String formatAnswer(double answer) {
        if (answer == (long) answer) {
            return Long.toString((long) answer);
        }

        return Double.toString(answer);
    }
}
