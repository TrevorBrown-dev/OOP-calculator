import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main {
    public static void main(String[] args) {
        Calculator c = new Calculator(400, 300);
        c.setVisible(true);
    }
}

class Calculator extends JFrame implements ActionListener {
    private JTextField ioField;
    private double answer = 0.0;

    public Calculator(int width, int height) {
        setTitle("Trevor's Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(width, height);

        JPanel textPanel = new JPanel();
        textPanel.setLayout(new FlowLayout());
        ioField = new JTextField("", 30);

        // This long thing gives the textbox some padding so it looks nicer.
        ioField.setBorder(
                BorderFactory.createCompoundBorder(ioField.getBorder(), BorderFactory.createEmptyBorder(5, 5, 5, 5)));

        // The Background color
        ioField.setBackground(Color.decode("#131313"));
        // The Text color
        ioField.setForeground(Color.decode("#ffffff"));

        textPanel.add(ioField); // add ioField as a component of the panel
        add(textPanel, BorderLayout.NORTH);

        // create a JPanel for command buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.decode("#131313"));
        buttonPanel.setLayout(new FlowLayout());

        // add button components to buttonPanel
        JButton compute = new JButton("=");
        compute.addActionListener(this);
        buttonPanel.add(compute);

        JButton clear = new JButton("Clear");
        clear.addActionListener(this);
        buttonPanel.add(clear);

        // include the button panel component
        add(buttonPanel, BorderLayout.CENTER);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e);
        if (e.getActionCommand().equals("Clear")) {
            ioField.setText("");
        }
    }

}