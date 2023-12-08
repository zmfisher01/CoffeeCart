// RegisterController.java
// By Zee Fisher

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Creates register button action listeners
 */
public class RegisterController {

        private RegisterController() {}

        /** Action listener for resgistering
         * @param username text field for username
         * @param password1 first password field
         * @param password2 second password field
         * @param merchant merchant radio buttons
         * @return ActionListener
         * */
        public ActionListener registerButtonListener(final JTextField username, final JPasswordField  password1, final JPasswordField password2, final JRadioButton merchant) {
                return new ActionListener () {
                        public void actionPerformed(ActionEvent event) {
                                try {
                                        if(password1.getText().equals(password2.getText())) {
                                                CoffeeModel.getInstance().addUser(username.getText(), password1.getText(), merchant.isSelected());
                                                RegisterView.getInstance().hide();
                                                LoginView.getInstance().show();
                                        } else {
                                                JOptionPane.showMessageDialog(null, "Passwords Do Not Match", "Passwords Do Not Match", JOptionPane.ERROR_MESSAGE);
                                        }
                                }
                                catch(Exception e) {
                                        JOptionPane.showMessageDialog(null, "Username Taken", "Username Taken", JOptionPane.ERROR_MESSAGE);
                                }
                        }
                };
        }

        /**
         * cancel listner
         * @return action listner to go back to menu
         */
        public ActionListener cancelButtonListener() {
                return new ActionListener () {
                        public void actionPerformed(ActionEvent e) {
                                RegisterView.getInstance().hide();
                                LoginView.getInstance().show();
                        }
                };
        }

	/**
	 * Returns the RegisterController singleton
	 * @return RegisterController
	 */
        public static RegisterController getInstance() {
                return instance;
        }

        private static RegisterController instance = new RegisterController();
}

