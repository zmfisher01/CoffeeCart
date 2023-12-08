// LoginView.java
// created by Zee Fisher

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Class Login View creates the view for the login menu
 */
public class LoginView {

	/**
	 * LoginView singleton constructor defines the elements in the GUI
	 */
	private LoginView() 
	{
		this.frame = new JFrame();
		frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

		final JPanel header = new JPanel();
		header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
		frame.add(header);

		final JLabel title = new JLabel("CoffeeCart");
		header.add(title);

		final JPanel body = new JPanel();
		body.setLayout(new BoxLayout(body, BoxLayout.Y_AXIS));
		frame.add(body);

		final JLabel loginTitle = new JLabel("Login");
		body.add(loginTitle);

		final JPanel inputs = new JPanel();
		inputs.setLayout(new BoxLayout(inputs, BoxLayout.Y_AXIS));
		body.add(inputs);

		final JLabel usernameLabel = new JLabel("Username");
		inputs.add(usernameLabel);

		final JTextField username = new JTextField();
		inputs.add(username);
		
		final JLabel passwordLabel = new JLabel("Password");
		inputs.add(passwordLabel);

		final JPasswordField password = new JPasswordField();
		inputs.add(password);

		final JPanel buttons = new JPanel();
		buttons.setLayout(new BoxLayout(buttons, BoxLayout.X_AXIS));
		body.add(buttons);

		final JButton register = new JButton("Register");
		buttons.add(register);
		register.addActionListener(LoginController.getInstance().registerButtonListener());

		final JButton login = new JButton("Login");
		buttons.add(login);
		login.addActionListener(LoginController.getInstance().loginButtonListener(username, password));

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
	}

	/**
	 * show, makes the menu visible
	 */
	public void show() 
	{
		this.frame.setVisible(true);
	}

	/**
	 * hide, make the menu not visible
	 */
	public void hide() 
	{
		this.frame.setVisible(false);
	}

	/**
	 * Loginview returns login singleton instance.
	 */
	public static LoginView getInstance() {
		return instance;
	}

	private final JFrame frame;
	private static LoginView instance = new LoginView();

}

