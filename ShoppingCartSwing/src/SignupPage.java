import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class SignupPage extends JFrame {

  String[] roles = { "Seller", "Customer" };

  public SignupPage() {
    setTitle("Create an account on The Online Shop");
    setSize(400, 300);
    setLocationRelativeTo(null);

    JPanel panel = new JPanel(new GridBagLayout());
    GridBagConstraints constraints = new GridBagConstraints();
    constraints.insets = new Insets(10, 10, 10, 10);

    JLabel emailLabel = new JLabel("Email:");
    constraints.gridx = 0;
    constraints.gridy = 0;
    panel.add(emailLabel, constraints);

    JTextField emailField = new JTextField(20);
    constraints.gridx = 1;
    constraints.gridy = 0;
    panel.add(emailField, constraints);

    JLabel passwordLabel = new JLabel("Password:");
    constraints.gridx = 0;
    constraints.gridy = 1;
    panel.add(passwordLabel, constraints);

    JPasswordField passwordField = new JPasswordField(20);
    constraints.gridx = 1;
    constraints.gridy = 1;
    panel.add(passwordField, constraints);

    JLabel confPasswordLabel = new JLabel("Confirm Password:");
    constraints.gridx = 0;
    constraints.gridy = 2;
    panel.add(confPasswordLabel, constraints);

    JPasswordField confPasswordField = new JPasswordField(20);
    constraints.gridx = 1;
    constraints.gridy = 2;
    panel.add(confPasswordField, constraints);

    JLabel typeLabel = new JLabel("I am a:");
    constraints.gridx = 0;
    constraints.gridy = 3;
    panel.add(typeLabel, constraints);

    JComboBox<String> roleDropdown = new JComboBox<>(roles);
    constraints.gridx = 1;
    constraints.gridy = 3;
    panel.add(roleDropdown, constraints);

    JButton loginButton = new JButton("Sign Up");
    loginButton.addActionListener(
      new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          String email = emailField.getText();
          String password = new String(passwordField.getPassword());

          if ("user@example.com".equals(email) && "password".equals(password)) {
            dispose();
            openHomePage();
          } else {
            JOptionPane.showMessageDialog(
              SignupPage.this,
              "Invalid credentials. Try again."
            );
          }
        }
      }
    );
    constraints.gridx = 1;
    constraints.gridy = 4;
    panel.add(loginButton, constraints);

    JButton toLoginButton = new JButton("Login");
    loginButton.addActionListener(
      new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          dispose();
          LoginPage signupPage = new LoginPage();
          signupPage.setVisible(true);
        }
      }
    );
    constraints.gridx = 1;
    constraints.gridy = 5;
    panel.add(toLoginButton, constraints);

    add(panel);

    setVisible(true);
  }

  private void openHomePage() {
    // Close the login page
    dispose();
    // Open the home page
    // HomePage homePage = new HomePage();
    // homePage.setVisible(true);
  }

  public static void main(String[] args) {
    new SignupPage();
  }
}
