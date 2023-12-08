// PlaceHolderView.java
// created by Zee Fisher

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Place Holder View. This view acts as a placeholder due to other parts of the project not being completed.
 */
public class PlaceHolderView {

	/**
	 * Constructs a singleton placeholder view
	 */
	private PlaceHolderView() 
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

		final JLabel loginTitle = new JLabel("PlaceHolder");
		body.add(loginTitle);

		final JPanel inputs = new JPanel();
		inputs.setLayout(new BoxLayout(inputs, BoxLayout.Y_AXIS));
		body.add(inputs);

		final JPanel buttons = new JPanel();
		buttons.setLayout(new BoxLayout(buttons, BoxLayout.X_AXIS));
		body.add(buttons);
		
		final JButton login = new JButton("Back to Login");
		buttons.add(login);
		login.addActionListener(PlaceHolderController.getInstance().loginButtonListener());

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
	}

	/**
	 * shows the placeholder view
	 */
	public void show() 
	{
		this.frame.setVisible(true);
	}
	
	/**
	 * hides the placeholder view
	 */
	public void hide() 
	{
		this.frame.setVisible(false);
	}

	/**
	 * gets the singleton instance for the placeholder view
	 * @return PlaceHolderView
	 */
	public static PlaceHolderView getInstance() {
		return instance;
	}

	private final JFrame frame;
	private static PlaceHolderView instance = new PlaceHolderView();

}

