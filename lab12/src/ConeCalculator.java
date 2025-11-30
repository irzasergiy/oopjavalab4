import javax.swing.*;
import java.awt.event.*;

public class ConeCalculator extends JFrame {

    private JTextField radiusField;
    private JTextField heightField;
    private JTextField resultField;

    public ConeCalculator() {
        setTitle("Калькулятор об'єму конуса");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel rLabel = new JLabel("Радіус:");
        rLabel.setBounds(40, 30, 80, 25);
        add(rLabel);

        radiusField = new JTextField();
        radiusField.setBounds(120, 30, 150, 25);
        add(radiusField);

        JLabel hLabel = new JLabel("Висота:");
        hLabel.setBounds(40, 70, 80, 25);
        add(hLabel);

        heightField = new JTextField();
        heightField.setBounds(120, 70, 150, 25);
        add(heightField);

        JButton calcButton = new JButton("Обчислити");
        calcButton.setBounds(120, 110, 150, 30);
        add(calcButton);

        JLabel resLabel = new JLabel("Об'єм:");
        resLabel.setBounds(40, 160, 80, 25);
        add(resLabel);

        resultField = new JTextField();
        resultField.setBounds(120, 160, 150, 25);
        resultField.setEditable(false);
        add(resultField);

        JButton exitButton = new JButton("Вихід");
        exitButton.setBounds(120, 200, 150, 30);
        add(exitButton);

        calcButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double r = Double.parseDouble(radiusField.getText());
                    double h = Double.parseDouble(heightField.getText());
                    double V = (Math.PI * r * r * h) / 3.0;
                    resultField.setText(String.format("%.4f", V));
                } catch (Exception ex) {
                    resultField.setText("Помилка");
                }
            }
        });

        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new ConeCalculator();
    }
}
