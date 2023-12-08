// RegisterView.java
// created by Zee Fisher

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * RegisterView creates the register menu
 */
public class RegisterView {

	/**
	 * Singleton constructor for RegisterView defines GUI
	 */
	private RegisterView() 
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

		final JLabel loginTitle = new JLabel("Register");
		body.add(loginTitle);

		final JPanel inputs = new JPanel();
		inputs.setLayout(new BoxLayout(inputs, BoxLayout.Y_AXIS));
		body.add(inputs);

		final JLabel usernameLabel = new JLabel("Enter Username");
		inputs.add(usernameLabel);

		final JTextField username = new JTextField("Username");
		inputs.add(username);

		final JLabel passwordLabel1 = new JLabel("Enter Password");
		inputs.add(passwordLabel1);

		final JPasswordField password1 = new JPasswordField("Password");
		inputs.add(password1);

		final JLabel passwordLabel2 = new JLabel("Enter Password Again");
		inputs.add(passwordLabel2);

		final JPasswordField password2 = new JPasswordField("Password");
		inputs.add(password2);

		final ButtonGroup typeButtons = new ButtonGroup();

		final JRadioButton customer = new JRadioButton("Customer");
		typeButtons.add(customer);
		inputs.add(customer);
		customer.setSelected(true);

		final JRadioButton merchant = new JRadioButton("Merchant");
		typeButtons.add(merchant);
		inputs.add(merchant);

		final JPanel buttons = new JPanel();
		buttons.setLayout(new BoxLayout(buttons, BoxLayout.X_AXIS));
		body.add(buttons);

		final JButton cancel = new JButton("Cancel");
		buttons.add(cancel);
		cancel.addActionListener(RegisterController.getInstance().cancelButtonListener());

		final JButton register = new JButton("Register");
		buttons.add(register);
		register.addActionListener(RegisterController.getInstance().registerButtonListener(username, password1, password2, merchant));

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
	}

	/**
	 *shows register menu
	 */
	public void show() 
	{
		this.frame.setVisible(true);
	}
	
	/**
	 *hides register menu
	 */
	public void hide() 
	{
		this.frame.setVisible(false);
	}

	/**
	 * gets register instance
	 * @return RegisterView
	 */
	public static RegisterView getInstance() {
		return instance;
	}

	private final JFrame frame;
	private static RegisterView instance = new RegisterView();

}


