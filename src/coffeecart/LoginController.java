// LoginController.java
// By Zee Fisher
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * LoginController defines actions for buttons
 */
public class LoginController {

        /**
         * private singleton constructor for LoginController
         */
        private LoginController() {}

        /**
         * loginButtonListener creates a button for loggin in.
         * @param username text field that stores username
         * @param password pass field that stores password
         * @return ActionListener for button
         */
        public ActionListener loginButtonListener(final JTextField username, final JPasswordField  password) {
                return new ActionListener () {
                        public void actionPerformed(ActionEvent event) {
                                try {
                                        CoffeeModel.getInstance().loginUser(username.getText(), password.getText());
                                        LoginView.getInstance().hide();
                                        PlaceHolderView.getInstance().show();
                                }
                                catch(Exception e) {
                                        JOptionPane.showMessageDialog(null, "Invalid Username or Password.", "Bad Credentials", JOptionPane.ERROR_MESSAGE);
                                }
                        }
                };
        }


        /**
         * registerButtonListener creates a button for going to register.
         * @return ActionListener for button
         */
        public ActionListener registerButtonListener() {
                return new ActionListener () {
                        public void actionPerformed(ActionEvent e) {
                                LoginView.getInstance().hide();
                                RegisterView.getInstance().show();
                        }
                };
        }

	/**
	 * getInstance gets the instance of the LoginControllers singleton.
	 * @return LoginController
	 */
        public static LoginController getInstance() {
                return instance;
        }

        private static LoginController instance = new LoginController();
}

