import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class LoginPage extends JFrame {

  public LoginPage() {
    setTitle("Login to The Online Shop");
    setSize(400, 300);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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

    JButton loginButton = new JButton("Login");
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
              LoginPage.this,
              "Invalid credentials. Try again."
            );
          }
        }
      }
    );
    constraints.gridx = 1;
    constraints.gridy = 2;
    panel.add(loginButton, constraints);

    JButton toSignupButton = new JButton("Sign Up");
    loginButton.addActionListener(
      new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          dispose();
          SignupPage signupPage = new SignupPage();
          signupPage.setVisible(true);
          //   revalidate();
        }
      }
    );
    constraints.gridx = 1;
    constraints.gridy = 3;
    panel.add(toSignupButton, constraints);

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
    new LoginPage();
  }
}
