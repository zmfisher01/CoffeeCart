// CoffeeCart.java
// Created by Zee Fisher

/**
 * CoffeCart is the entry point of the application.
 */
public class CoffeeCart {
	
	/**
	 * main initializes the application by 
	 * recovering the list of users and showing the 
	 * login view.
	 * @param args IGNORED
	 */
	public static void main(String[] args) {

		CoffeeModel.getInstance().recoverUserList();
		LoginView.getInstance().show();
	}

}

