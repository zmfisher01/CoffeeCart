// CoffeeModel.java
// Created by Zee Fisher

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.lang.IllegalArgumentException;
import java.io.*;
import javax.swing.JOptionPane;

/**
 * CoffeModel handles the storage, verification, and retrieval of user accounts
 */
public class CoffeeModel {

	/**
	 * Singleton Constructor
	 */
	private CoffeeModel() {}

	/**
	 * getInstance gets CoffeModel Instance
	 * @return CoffeeModel instance
	 */
	public static CoffeeModel getInstance() {
		return instance;
	}

	/**
	 * saveUserList saves the user to a file. 
	 * Private as only the CoffeModel should be saving.
	 */
	private void saveUserList() {
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("userList.dat"));
			out.writeObject(userList);
			out.close();
		}
		catch (Exception e) {
			System.out.println("Write error:");
			System.out.println(e);
		}
	}

	/**
	 * recoverUserList recovers user list from a file.
	 * Called initially by CoffeCart to init application.
	 */
	public void recoverUserList() {
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("userList.dat"));
                        Object inputObj = in.readObject();
                        if(inputObj.getClass() == LinkedList.class) {
                                userList = new LinkedList<User>((LinkedList<User>)inputObj);
                        } else {
                                System.out.println("Error reading file. Creating blank list");
				JOptionPane.showMessageDialog(null, "Error reading user List file. Creating blank list", "Alert", JOptionPane.INFORMATION_MESSAGE); 
				userList = new LinkedList<User>();
                        }
                        in.close();	
		}
		catch (Exception e) {
			System.out.println("Error opening file. Creating blank list");
			JOptionPane.showMessageDialog(null, "Error opening user list file. Creating blank list", "Alert", JOptionPane.INFORMATION_MESSAGE); 
			userList = new LinkedList<User>();
		}
	}

	/**
	 * addUser adds a uesr to the list of user accounts.
	 * @param username Valid String username
	 * @param password Valid String password
	 * @param userType 0 for customer, 1 for merchant
	 * @throws IllegalArgumentException if the username already exists.
	 */
	public void addUser(String username, String password, boolean userType) throws IllegalArgumentException {
		for (int i = 0; i < userList.size(); i++) {
			if(userList.get(i).getUsername().equals(username)) {
				throw new IllegalArgumentException();
			}
		}
		userList.add(new User(username, password, userType));
		saveUserList();
	}

	/**
	 * loginUser logs a user in by username and password.
	 * @param username valid String username
	 * @param password valid String password
	 * @throws NoSuchElementException if there is no associated account
	 */
	public void loginUser(String username, String password) throws NoSuchElementException {
		for (int i = 0; i < userList.size(); i++) {
			if(userList.get(i).validateCredentials(username, password)) {
				loggedInUser = userList.get(i);
				if(loggedInUser.getUserType()) {
					JOptionPane.showMessageDialog(null, "Welcome, Merchant", "Welcome", JOptionPane.PLAIN_MESSAGE);	
				} else {
					JOptionPane.showMessageDialog(null, "Welcome, Customer", "Welcome", JOptionPane.PLAIN_MESSAGE);
				}
				return;
			}
		}
		throw new NoSuchElementException();
	}

	/**
	 * getLoggedInUser gets the currently logged in user.
	 * @return logged in user
	 */
	public User getLoggedInUser() {
		return loggedInUser;
	}

	private LinkedList<User> userList;
	private User loggedInUser;
	private static CoffeeModel instance = new CoffeeModel();

}


