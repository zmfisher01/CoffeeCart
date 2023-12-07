# CRC Coffee Cart Login
--- 


## CoffeeCart
 - **Responsibilities**
    - Initalizes the application.
    - Activates the Model of the Login page
    - Shows Login View
 - **Collaborators**
    - CoffeeModel
    - LoginView

## User
 - **Responsibilities**
    - Store username, password, and type 
    - Validate uesrname and password
    - Identifies type
 - **Collaborators**
    - LoginModel
    - LoginController

## CoffeeModel
 - **Responsibilities**
    - Manages List of Users
    - Manages User Validation
 - **Collaborators**
    - LoginView
    - ActionListener
    - LinkedList

## LoginView
 - **Responsibilities**
    - Manage login layout
    - Attach action listeners
 - **Collaborators**
    - Controller
    - JFrame, JPanel, JTextField, JPasswordField, JButton, JLabel
    - ActionListener

## LoginController
 - **Responsibilities**
    - Create ActionListeners
    - Listens to buttons
    - Validates Username and Password
 - **Collaborators**
    - LoginView
    - LoginModel
    - ActionListener
    - JOptionPane

## RegisterView
 - **responsibilities**
    - Manage register layout
 - **collaborators**
    - JFrame, JPanel, JTextField, JPasswordField, JButton, JLabel, JRadioButton

## CustomerMainView
 - **Responsibilities**
    - Manage customer main layout
 - **Collaborators**
    - JFrame, JPanel, JTextField, JPasswordField, JButton, JLabel

---

*Created by Zee Fisher in MultiMardown v6*
