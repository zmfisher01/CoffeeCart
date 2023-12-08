// User.java
// By Zee Fisher
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.lang.IllegalArgumentException;
import java.io.*;
import javax.swing.JOptionPane;

/**
 * User class store user account information
 */
public class User implements Serializable {

        /**
         * User constructor creats a new usre from a username, password, and type
         * @param username String username
         * @param password String password
         * @param type 0 for customer, 1 for merchant
         */
        public User(String username, String password, boolean type) {
                this.username = username;
                this.password = password.hashCode();
                this.userType = type;
        }

        /**
         * validateCredentials validates a username and password against a user.
         * @param username String username
         * @param password String password
         * @return boolean true if they are valid for this account, false otherwise
         */
        public boolean validateCredentials(String username, String password) {
                if (username.equals(this.username) && password.hashCode() == this.password) {
                        return true;
                }
                return false;
        }

        /**
         * equals compares the hash of to users to see if they are equal.
         * @param other User to compare to this User
         * @return true if they are equal in hash, false otherwise
         */
        public boolean equals(User other) {
                return this.hashCode() == other.hashCode();
        }

        /**
         * hashCode creates a hash for a user
         * @return hash created from username and password.
         */
        public int hashCode() {
                return username.hashCode() + password;
        }

        /**
         * getUserType gets the users type
         * @return 0 for customer, 1 for merchant
         */
        public boolean getUserType() {
                return userType;
        }

        /**
         * getUsername gets the username
         * @return String username.
         */
        public String getUsername() {
                return username;
        }

        private String username; // username of account
        private int password; // password of account
        private boolean userType; // 0 if customer 1 if merchant
}

