package customer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class CheckoutPage extends JFrame {

    public CheckoutPage() {
        setTitle("Checkout");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(10, 10, 10, 10);

        JLabel cardLabel = new JLabel("Card Number:");
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(cardLabel, constraints);

        JTextField cardField = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 0;
        panel.add(cardField, constraints);

        JLabel expLabel = new JLabel("Expiration Date:");
        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(expLabel, constraints);

        JTextField expField = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 1;
        panel.add(expField, constraints);

        JLabel addressLabel = new JLabel("Shipping Address:");
        constraints.gridx = 0;
        constraints.gridy = 2;
        panel.add(addressLabel, constraints);

        JTextField addressField = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 2;
        panel.add(addressField, constraints);

        JButton checkoutButton = new JButton("Checkout");
        checkoutButton.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    performCheckout(cardField.getText(), expField.getText(), addressField.getText());
                }
            }
        );
        constraints.gridx = 1;
        constraints.gridy = 3;
        panel.add(checkoutButton, constraints);

        add(panel);

        setVisible(true);
    }

    private void performCheckout(String cardNumber, String expirationDate, String shippingAddress) {
        // Perform checkout logic here
        System.out.println("Card Number: " + cardNumber);
        System.out.println("Expiration Date: " + expirationDate);
        System.out.println("Shipping Address: " + shippingAddress);

        // Additional logic (e.g., process payment, update order status, etc.) would go here

        // For this example, let's just display a confirmation message
        JOptionPane.showMessageDialog(this, "Checkout Successful!", "Success", JOptionPane.INFORMATION_MESSAGE);

        // Close the checkout page after successful checkout
        dispose();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(CheckoutPage::new);
    }
}
